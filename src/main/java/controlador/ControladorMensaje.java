package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DetalleMensajeImp;
import dao.MensajeImp;
import model.MensajeConUsuario;
import model.TblDetallemensaje;
import model.TblDetallemensajePK;
import model.TblMensaje;
import model.TblUsuario;

public class ControladorMensaje extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorMensaje() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String accion = request.getParameter("accion");

        // COMPROBAR QUE LA ACCION ES NULA
        if (accion != null) {
            switch (accion) {
                case "Listar":
                    ListarMensajeConUsuario(request, response);
                    break;
                default:
                    break;
            }
        } else {
            response.getWriter().append("Acción no especificada.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    	
    	String accion = request.getParameter("accion");

        // COMPROBAR QUE LA ACCION ES NULA
        if (accion != null) {
            switch (accion) {
                case "Registrar":
                    RegistrarMensaje(request, response);
                    break;
                case "Eliminar":
                    EliminarMensaje(request, response);
                    break;
                default:
                    break;
            }
        } else {
            response.getWriter().append("Acción no especificada.");
        }
    }

    public void ListarMensajeConUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	DetalleMensajeImp crud = new DetalleMensajeImp();
        List<MensajeConUsuario> mensajeConUsuario = crud.ListarMensajeConUsuario();
        request.setAttribute("mensajesConUsuario", mensajeConUsuario);
        request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);
    }
    
    public void RegistrarMensaje(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		// INSTANCIAS
		TblMensaje mensaje = new TblMensaje();
		MensajeImp crud1 = new MensajeImp();
		TblUsuario usuario = new TblUsuario();
		TblDetallemensaje detaMsj = new TblDetallemensaje();
		DetalleMensajeImp crud2 = new DetalleMensajeImp();
		TblDetallemensajePK detaMsjPk = new TblDetallemensajePK();
		
		// OBJETOS
		usuario = (TblUsuario)request.getSession().getAttribute("u");
		String msj = request.getParameter("txtMensaje");
		
		mensaje.setDescMsj(msj);
		mensaje.setFecReg(Calendar.getInstance().getTime());
		
		// REGISTRA MENSAJE
		int ok = crud1.RegistrarMensaje(mensaje);
		
		if (ok == 0) {
			
			request.setAttribute("mensaje", "Error al registrar mensaje");
			request.setAttribute("estilo", "alert alert-danger");
	        request.getRequestDispatcher("inicio.jsp").forward(request, response);
	        
		} else {
			
			// OBJETOS
			detaMsjPk.setIdUsu(usuario.getIdUsu());
			detaMsjPk.setIdMsj(mensaje.getIdMsj());
			
			detaMsj.setId(detaMsjPk);
			detaMsj.setTblUsuario(usuario);
			detaMsj.setTblMensaje(mensaje);
			
			// REGISTRA DETALLE MENSAJE
			int ok2 = crud2.RegistrarDetalleMensaje(detaMsj);
			
			if (ok2 == 0) {
				
				request.setAttribute("mensaje", "Error al registrar detalle de mensaje");
				request.setAttribute("estilo", "alert alert-danger");
		        request.getRequestDispatcher("inicio.jsp").forward(request, response);
		        
			} else {
				
				request.setAttribute("mensaje", "Mensaje enviado");
				request.setAttribute("estilo", "alert alert-success");
		        request.getRequestDispatcher("inicio.jsp").forward(request, response);
		        
			}
		}
    }
    
    public void EliminarMensaje(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// INSTANCIAS
	    MensajeImp crud1 = new MensajeImp();

	    // OBJETOS
	    int idMensaje = Integer.parseInt(request.getParameter("cod"));

	    System.out.println("ID Mensaje: " + idMensaje);

	    if (idMensaje != 0) {

	    	int ok = crud1.EliminarMensaje(idMensaje);

            if (ok == 0) {
                request.setAttribute("mensaje", "Error al eliminar mensaje y sus detalles");
                request.setAttribute("estilo", "alert alert-danger");
                request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);

                System.out.println("Error al eliminar mensaje");
            } else {
                response.sendRedirect("ControladorMensaje?accion=Listar");
            }
	    } else {
	        request.setAttribute("mensaje", "Uno de los IDs es 0");
	        request.setAttribute("estilo", "alert alert-danger");
	        request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);

	        System.out.println("Uno de los IDs es 0");
	    }

    }
}
