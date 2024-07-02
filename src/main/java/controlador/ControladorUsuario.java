package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioImp;
import model.TblTipousuario;
import model.TblUsuario;
import model.UsuarioConTipo;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// RECUPERA ACCION Y CODIGO
		String accion = request.getParameter("accion");

		// CONDICION
		if (accion != null) {
			switch (accion) {
			case "Logout":
				LogoutUsuario(request, response);
				break;
			case "Listar":
				ListarUsuarioConTipo(request, response);
				break;
			default:
				break;
			}
		}
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
		if(accion != null) {
			switch (accion) {
			case "Registrar":
				RegistrarUsuario(request, response);
				break;
			case "Actualizar":
				ActualizarUsuario(request, response);
				break;
			case "ActualizarTipo":
				ActualizarTipoUsuario(request, response);
				break;
			case "Eliminar":
				break;
			case "Login":
				LoginUsuario(request, response);
				break;
			}
		}
				
	}
	
	public void RegistrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ENTRADAS
		String nom = request.getParameter("txtNombre");
		String apepa = request.getParameter("txtApepa");
		String apema = request.getParameter("txtApema");
		String fono = request.getParameter("txtFono");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		int tipo = 2;

		int contador = 0;

		// VALIDACIONES
		if (!nom.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Nombre no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!apepa.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!apema.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!fono.matches("[0-9]{9}")) {
			request.setAttribute("mensaje", "Teléfono no válido, debe contener 9 digitos");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			request.setAttribute("mensaje", "Email no válido");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$")) {
			request.setAttribute("mensaje",
					"La contraseña debe contener de 4 a 16 caracteres, números, letras mayúsculas y minúsculas");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		// CREACION DE OBJETO
		if (contador == 0) {

			// INSTANCIAS
			TblUsuario usuario = new TblUsuario();
			UsuarioImp crud = new UsuarioImp();

			usuario.setNomUsu(nom);
			usuario.setApepaUsu(apepa);
			usuario.setApemaUsu(apema);
			usuario.setFonoUsu(fono);
			usuario.setEmailUsu(email);
			usuario.setPasswordUsu(password);
			TblTipousuario tipoUsu = new TblTipousuario();
			tipoUsu.setIdTipo(tipo);
			usuario.setTblTipousuario(tipoUsu);

			// REGISTRO
			int ok = crud.RegistrarUsuario(usuario);

			// SALIDAS
			if (ok == 0) {

				request.setAttribute("mensaje", "Error al registrar");
				request.setAttribute("estilo", "alert alert-danger");
				request.getRequestDispatcher("registro.jsp").forward(request, response);

			} else {

				request.setAttribute("mensaje", "Registro exitoso!");
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);

			}
		}
	}
	
	public void ActualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ENTRADAS
		int id = Integer.parseInt(request.getParameter("txtId"));
		String nom = request.getParameter("txtNombre");
		String apepa = request.getParameter("txtApepa");
		String apema = request.getParameter("txtApema");
		String fono = request.getParameter("txtFono");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		int tipo = 2;

		int contador = 0;

		// VALIDACIONES
		if (!nom.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Nombre no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!apepa.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!apema.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!fono.matches("[0-9]{9}")) {
			request.setAttribute("mensaje", "Teléfono no válido, debe contener 9 digitos");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!email.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			request.setAttribute("mensaje", "Email no válido");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$")) {
			request.setAttribute("mensaje",
					"La contraseña debe contener de 4 a 16 caracteres, números, letras mayúsculas y minúsculas");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			contador++;
		}

		// CREACION DE OBJETO
		if (contador == 0) {

			// INSTANCIAS
			TblUsuario usuario = new TblUsuario();
			UsuarioImp crud = new UsuarioImp();

			usuario.setIdUsu(id);
			usuario.setNomUsu(nom);
			usuario.setApepaUsu(apepa);
			usuario.setApemaUsu(apema);
			usuario.setFonoUsu(fono);
			usuario.setEmailUsu(email);
			usuario.setPasswordUsu(password);
			TblTipousuario tipoUsu = new TblTipousuario();
			tipoUsu.setIdTipo(tipo);
			usuario.setTblTipousuario(tipoUsu);

			// REGISTRO
			int ok = crud.ActualizarUsuario(usuario);

			// SALIDAS
			if (ok == 0) {

				request.setAttribute("mensaje", "Error al actualizar");
				request.setAttribute("estilo", "alert alert-danger");
				request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);

			} else {

				request.setAttribute("mensaje", "Actualización exitosa!");
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}
		}
	}
	
	public void LoginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ENTRADA
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		// OBJETO
		TblUsuario u = new TblUsuario();

		UsuarioImp crud = new UsuarioImp();
		u = crud.ValidarUsuario(email, password);

		// VALIDA EL ACCESO
		if (u == null || !u.getPasswordUsu().equals(password)) {

			request.setAttribute("mensaje", "Usuario o clave incorrecto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {

			if (u.getTblTipousuario().getIdTipo() == 1) {

				request.getSession().setAttribute("u", u);
				request.setAttribute("mensaje", "Bienvenido(a) " + u.getNomUsu());
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);

			} else {

				request.getSession().setAttribute("u", u);
				request.setAttribute("mensaje", "Bienvenido(a) " + u.getNomUsu());
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);

			}
		}
	}
	
	public void LogoutUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		
		sesion.invalidate();
		request.setAttribute("mensaje", "Sesión finalizada");
		request.setAttribute("estilo", "alert alert-success");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	public void ListarUsuarioConTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioImp crud = new UsuarioImp();
		List<UsuarioConTipo> usuarioConTipo = crud.ListarUsuarioConTipo();
		request.setAttribute("usuarioConTipo", usuarioConTipo);
		request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
		
	}
	
	public void ActualizarTipoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioImp crud = new UsuarioImp();
		
		int idUsu = Integer.parseInt(request.getParameter("cod"));
		
		if(idUsu == 1) {
			
			request.setAttribute("mensaje", "Error al actualizar - No puedes cambiar el tipo de usuario del administrador principal :)");
			request.setAttribute("estilo", "alert alert-info");
			request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
			
		} else {
			
			int ok = crud.ActualizarTipoUsuario(idUsu);
			
			if (ok == 0) {
				
				request.setAttribute("mensaje", "Error al actualizar");
				request.setAttribute("estilo", "alert alert-danger");
				request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
				
			} else {
				
				request.setAttribute("mensaje", "Actualización exitosa");
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
			}
		}
	}

}
