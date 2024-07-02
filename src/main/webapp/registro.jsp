<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	    <link rel="stylesheet" href="./css/estilos.css">
	    <link rel="shortcut icon" href="img/bloqueado.ico" />
	    <title>CyberCloud | Registro</title>
	</head>
	<body>
	    <div class="background-register"></div>
	    <!-- BARRA DE NAVEGACION -->
	    <header>
	        <nav class="navbar navbar-expand-lg bg-body-tertiary">
	            <div class="container-fluid">
	            <a class="navbar-brand" href="index.jsp">| CyberCloud |</a>
	            </div>
	        </nav>
	    </header>
	    <!-- FORMULARIO DE REGISTRO -->
	    <div class="contenedor-form register">
	        <div class="content">
	            <div class="text-sci">
	                <h2>Bienvenido(a)!<br><span>Regístrate en nuestro sitio web.</span></h2>
	                <p>También puedes seguirnos en nuestras redes sociales para enterarte de los nuevos avances en ciberseguridad.</p>
	                <div class="iconos-redes-sociales d-flex flex-wrap align-items-center justify-content-start">
	                    <a href="https://www.facebook.com/" target="_blank" rel="noopener noreferrer">
	                        <i class="bi bi-facebook"></i>
	                    </a>
	                    <a href="https://www.instagram.com/" target="_blank" rel="noopener noreferrer">
	                        <i class="bi bi-instagram"></i>
	                    </a>
	                    <a href="https://twitter.com/" target="_blank" rel="noopener noreferrer">
	                        <i class="bi bi-twitter"></i>
	                    </a>
	                    <a href="https://www.linkedin.com/" target="_blank" rel="noopener noreferrer">
	                        <i class="bi bi-linkedin"></i>
	                    </a>
	                    <a href="https://github.com/" target="_blank" rel="noopener noreferrer">
	                        <i class="bi bi-github"></i>
	                    </a>
	                </div>
					<%
					Object mensaje = request.getAttribute("mensaje");
					Object estilo = request.getAttribute("estilo");
	
					if (mensaje != null) {
					%>
					<div class="<%=estilo%>" role="alert">
						<%=mensaje%>
					</div>
					<%
					}
					%>
				</div>
	        </div>
	        <div class="logreg-box">
	            <div class="form-box">
	                <form action="ControladorUsuario?accion=Registrar" method="post">
	                    <h2>Registrar</h2>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtNombre" autocomplete="off" required>
	                        <label>Nombre</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtApepa" autocomplete="off" required>
	                        <label>Apellido paterno</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtApema" autocomplete="off" required>
	                        <label>Apellido materno</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-telephone-fill"></i></span>
	                        <input type="text" name="txtFono" autocomplete="off" required>
	                        <label>Teléfono</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-envelope"></i></span>
	                        <input type="text" name="txtEmail" autocomplete="off" required>
	                        <label>Correo</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-lock-fill"></i></span>
	                        <input type="password" name="txtPassword" autocomplete="off" required>
	                        <label>Contraseña</label>
	                    </div>
	                    <div class="agree">
	                        <label><input type="checkbox" required>Estoy de acuerdo con los términos y condiciones</label>
	                    </div>
	                    <button type="submit" class="boton">Registrarse</button>
	                    <div class="login-register">
	                        <p>¿Ya estás registrado? <a href="index.jsp" class="register-link">Inicia sesión</a></p>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="js/button-to-top.js"></script>
	<script src="js/navbar-scroll.js"></script>
</html>