<%@page import="model.TblCharla"%>
<%@page import="java.util.List"%>
<%@page import="model.TblUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/libreria.tld" prefix="tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="./css/estilos.css">
		<link rel="shortcut icon" href="img/bloqueado.ico" />
		<%
			TblUsuario u = (TblUsuario) request.getSession().getAttribute("u");
		%>
		<title>CyberCloud | Eventos</title>
	</head>
	<body style="background: #e4e4e4 url('img/rp.jpg') no-repeat center center fixed;
	            background-size: cover;">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp">| CyberCloud |</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link" href="index.jsp#productos">Productos</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="index.jsp#soluciones">Soluciones</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="eventos.jsp">Eventos</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="nosotros.jsp">Nosotros</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="index.jsp#contacto">Contacto</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown"> <i class="bi bi-person-fill"></i><%=u.getNomUsu()%>
						</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="actualizar.jsp">Actualizar
										datos</a>
								<li />
	                     <li class="dropdown divider">
								<li />
	                     <li><a class="dropdown-item" href="ControladorUsuario?accion=Logout">Cerrar sesión</a></li>
	                    </ul>
	                </li>
	                </ul>
	            </div>
	           </div>
	    </nav>
		<main style="margin: 50px 0">
		<div style="text-align: center; margin: 20px 0;"><h1 style="color: white;">Nuestros eventos</h1></div>
		<div class="container" style="display: flex; flex-direction: row; justify-content: space-evenly; align-items: center; margin-top: 80px; margin-bottom: 100px; animation: divanimation 1.5s ease forwards;">
			<div style="max-width: 500px; border-radius: 10pt; padding: 1rem; text-align: center; background: rgba(52, 235, 146); box-shadow: 0 0 10px rgba(0, 0, 0, .5);">
				<h2>Inscríbete en nuestras charlas aquí</h2>
				<br>
				<form action="ControladorEvento?accion=Registrar&cod=<%=u.getIdUsu()%>" method="post">
					<div class="form-row">
						<div class="form-group col-md-12">
							<select id="inputCharla" name="cboCharlas" class="form-control">
								<tags:cboCharlas />
							</select>
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Registrar</button>
					<br>
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
				</form>
			</div>
			<div style="box-shadow: 0 0 10px rgba(0, 0, 0, .5);">
				<table class="table table-hover" id="myTable">
					<thead>
						<tr>
							<th scope="col">Charla</th>
							<th scope="col">Cupos disponibles</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<TblCharla> listadoCharla = (List<TblCharla>) session.getAttribute("charlas");
						if (listadoCharla != null) {
							for (TblCharla lis : listadoCharla) {
						%>
						<tr>
							<td><%=lis.getTema()%></td>
							<td><%=lis.getCupos()%></td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td colspan="2">No hay charlas disponibles.</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
		</main>
		<footer class="d-flex align-items-center flex-column">
			<div>
				<p class="footer-texto text-center">
					Síguenos en nuestras <br> redes sociales
				</p>
				<div
					class="iconos-redes-sociales d-flex flex-wrap align-items-center justify-content-center">
					<a href="https://www.facebook.com/" target="_blank"
						rel="noopener noreferrer"> <i class="bi bi-facebook"></i>
					</a> <a href="https://www.instagram.com/" target="_blank"
						rel="noopener noreferrer"> <i class="bi bi-instagram"></i>
					</a> <a href="https://twitter.com/" target="_blank"
						rel="noopener noreferrer"> <i class="bi bi-twitter"></i>
					</a> <a href="https://www.linkedin.com/" target="_blank"
						rel="noopener noreferrer"> <i class="bi bi-linkedin"></i>
					</a> <a href="https://github.com/" target="_blank"
						rel="noopener noreferrer"> <i class="bi bi-github"></i>
					</a>
				</div>
			</div>
			<p class="copy">Copyright © 2024 CyberCloud. Todos los derechos
				reservados.</p>
		</footer>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="js/button-to-top.js"></script>
</html>