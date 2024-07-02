package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharlaImp;
import dao.DetalleCharlaImp;
import model.CharlaConUsuario;
import model.TblCharla;
import model.TblDetallecharla;
import model.TblDetallecharlaPK;
import model.TblUsuario;

/**
 * Servlet implementation class ControladorEvento
 */
public class ControladorEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEvento() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// RECUPERA ACCION Y CODIGO
		String accion = request.getParameter("accion");

		// CONDICION
		if (accion != null) {
			switch (accion) {
			case "Registrar":
				RegistrarEvento(request, response);
				break;
			case "ListarFiltro":
				ListarCharlaConUsuario(request, response);
				break;
			default:
				break;
			}
		}
	}

	public void RegistrarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INSTANCIAS
		TblUsuario usuario = new TblUsuario();
		TblCharla charla = new TblCharla();
		TblDetallecharla detaChar = new TblDetallecharla();
		DetalleCharlaImp crud = new DetalleCharlaImp();
		TblDetallecharlaPK detaChl = new TblDetallecharlaPK();
		
		// DATOS OBTENIDOS DEL FORMULARIO
		int idUsu = Integer.parseInt(request.getParameter("cod"));
		int idCharla = Integer.parseInt(request.getParameter("cboCharlas"));
		
		if (idCharla < 1) {
			request.setAttribute("mensaje", "Por favor, seleccione una charla");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			return;
		}
		
		// CREACION DE OBJETOS
		usuario.setIdUsu(idUsu);
		charla.setIdCharla(idCharla);
		
		detaChl.setIdUsu(usuario.getIdUsu());
		detaChl.setIdCharla(charla.getIdCharla());
		
		detaChar.setId(detaChl);
		detaChar.setTblUsuario(usuario);
		detaChar.setTblCharla(charla);
		detaChar.setFecReg(Calendar.getInstance().getTime());
		
		// REGISTRAR Y ACTUALIZAR CANTIDAD DE CUPOS
		int ok = crud.RegistrarDetalleCharla(detaChar);
		
		// ACTUALIZAR LA LISTA DE CHARLAS EN LA SESION
		List<TblCharla> charlas = new CharlaImp().ListarCharla();
		request.getSession().setAttribute("charlas", charlas);
		
		// SALIDAS
		switch (ok) {
		case 0:
			request.setAttribute("mensaje", "Error al registrar");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			break;
		case 2:
			request.setAttribute("mensaje", "Usted ya está registrado en la charla seleccionada");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			break;
		case 3:
			request.setAttribute("mensaje", "No hay cupos disponibles para la charla seleccionada");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("mensaje", "Registro exitoso!");
			request.setAttribute("estilo", "alert alert-success");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			break;
		}
	}
	
	public void ListarCharlaConUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCharla = Integer.parseInt(request.getParameter("cboCharlas"));
		
		DetalleCharlaImp crud = new DetalleCharlaImp();
		List<CharlaConUsuario> charlaConUsuario = crud.ListarUsuarioSegunCharla(idCharla);
		request.setAttribute("charlaConUsuario", charlaConUsuario);
		request.getRequestDispatcher("listaReservasAdmin.jsp").forward(request, response);
		
	}
}
