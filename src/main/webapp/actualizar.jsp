<%@page import="model.TblUsuario"%>
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
		<%
			TblUsuario u = (TblUsuario) request.getSession().getAttribute("u");
		%>
	<title>CyberCloud | Actualizar Datos</title>
	</head>
	<body>
	    <div class="background-register"></div>
	    <!-- BARRA DE NAVEGACION -->
	    <header>
	        <nav class="navbar navbar-expand-lg bg-body-tertiary">
	            <div class="container-fluid">
	            <a class="navbar-brand" href="inicio.jsp">| CyberCloud |</a>
	            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarNav">
	                <ul class="navbar-nav ms-auto">
	                <li class="nav-item">
	                    <a class="nav-link" href="inicio.jsp#productos">Productos</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="inicio.jsp#soluciones">Soluciones</a>
	                </li>
					<li class="nav-item">
						<a class="nav-link" href="eventos.jsp">Eventos</a>
					</li>
	                <li class="nav-item">
	                    <a class="nav-link" href="nosotros.jsp">Nosotros</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="inicio.jsp#contacto">Contacto</a>
	                </li>
	                </ul>
	            </div>
	            </div>
	        </nav>
	    </header>
	    <!-- FORMULARIO DE REGISTRO -->
	    <div class="contenedor-form register">
	        <div class="content">
	            <div class="text-sci">
	                <h2>Actualización de datos personales</h2>
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
	        <div class="logreg-box">
	            <div class="form-box">
	                <form action="ControladorUsuario?accion=Actualizar" method="post">
	                    <h2>Actualizar</h2>
	                    <div class="input-box id">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtId" autocomplete="off" value="<%=u.getIdUsu()%>" readonly required>
	                        <label>Codigo</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtNombre" autocomplete="off" value="<%=u.getNomUsu()%>" required>
	                        <label>Nombre</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtApepa" autocomplete="off" value="<%=u.getApepaUsu()%>" required>
	                        <label>Apellido paterno</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-person"></i></span>
	                        <input type="text" name="txtApema" autocomplete="off" value="<%=u.getApemaUsu()%>" required>
	                        <label>Apellido materno</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-telephone-fill"></i></span>
	                        <input type="text" name="txtFono" autocomplete="off" value="<%=u.getFonoUsu()%>" required>
	                        <label>Teléfono</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-envelope"></i></span>
	                        <input type="text" name="txtEmail" autocomplete="off" value="<%=u.getEmailUsu()%>" required>
	                        <label>Correo</label>
	                    </div>
	                    <div class="input-box">
	                        <span class="icon"><i class="bi bi-lock-fill"></i></span>
	                        <input type="password" name="txtPassword" autocomplete="off" required>
	                        <label>Contraseña nueva o actual</label>
	                    </div>
	                    <button type="submit" class="boton">Actualizar</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="js/button-to-top.js"></script>
	<script src="js/navbar-scroll.js"></script>
</html>