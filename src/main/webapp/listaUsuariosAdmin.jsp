<%@page import="java.util.List"%>
<%@page import="model.TblUsuario"%>
<%@page import="model.UsuarioConTipo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
	    <link rel="stylesheet" href="./css/estilos.css">
	     <link rel="stylesheet" href="./css/estil.css">
	    <link rel="shortcut icon" href="img/bloqueado.ico" />
	    <%
        	TblUsuario u = (TblUsuario) request.getSession().getAttribute("u");
    	%>
	    <title>CyberCloud | Administrador</title>
	</head>
	<body style="background: #e4e4e4 url('img/miau.png') no-repeat center center fixed;
	            background-size: cover;">
	    <!-- BARRA DE NAVEGACION -->
	    <header style="position: static">
	        <nav class="navbar navbar-expand-lg bg-body-tertiary bandeja" style="background: black!important">
	            <div class="container-fluid">
	            <a class="navbar-brand" href="bandejaAdmin.jsp">| CyberCloud |</a>
	            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarNav">
	                <ul class="navbar-nav ms-auto">
	                <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
	                    	<i class="bi bi-person-fill"></i><%=u.getNomUsu()%>
	                    </a>
	                    <ul class="dropdown-menu">
	                     <li><a class="dropdown-item" href="bandejaAdmin.jsp">Lista de mensajes</a></li>
	                     <li><a class="dropdown-item" href="listaReservasAdmin.jsp">Lista de reservas</a></li>
	                     <li><a class="dropdown-item" href="ControladorUsuario?accion=Logout">Cerrar sesión</a></li>
	                    </ul>
	                </li>
	                </ul>
	            </div>
	            </div>
	        </nav>
	    </header>
	    <!-- BANDEJA DE MENSAJES -->
	    <div class="container" style="margin-top: 20px;background: rgba(52, 235, 146);padding: 20px;border-radius: 10px;box-shadow: 0 0 10px rgba(0, 0, 0, .5);animation: divanimation 1s ease forwards;">
	    	<div class="row">
	    		<div class="col-12">
	    			<h2 style="text-align: center"><strong><i class="bi bi-person-fill"></i> Lista de usuarios <i class="bi bi-person-fill"></i></strong></h2>
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
					<form action="ControladorUsuario" method="get">
	                    <input type="hidden" name="accion" value="Listar">
	                    <button class="btn btn-success" style="width: 100%; margin: 20px 0">Listar</button>
                	</form>
					<table class="table table-hover" id="myTable" style="background: white;padding: 20px;border-radius: 10px;margin-bottom: 20px;">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Nombre</th>
								<th scope="col">Apellido paterno</th>
								<th scope="col">Apellido materno</th>
								<th scope="col">Teléfono</th>
								<th scope="col">Correo</th>
								<th scope="col">Tipo de usuario</th>
								<th scope="col">Acción</th>
							</tr>
						</thead>
						<tbody>
								<%
								List<UsuarioConTipo> usuarios = (List<UsuarioConTipo>) request.getAttribute("usuarioConTipo");
								if (usuarios != null) {
								    for (UsuarioConTipo usuario : usuarios) {
								%>
								<tr>
								    <td><%=usuario.getIdUsu()%></td>
								    <td><%=usuario.getNomUsu() %></td>
								    <td><%=usuario.getApepaUsu() %></td>
								    <td><%=usuario.getApemaUsu() %></td>
								    <td><%=usuario.getFonoUsu() %></td>
								    <td><%=usuario.getEmailUsu() %></td>
								    <td><%=usuario.getNomTipo() %></td>
								    <td>
									    <form action="ControladorUsuario?accion=ActualizarTipo&cod=<%=usuario.getIdUsu() %>" method="post" >
								            <button class="btn btn-success" type="submit" style="width: 100%;">Actualizar tipo</button>
							        	</form>
								    </td>
								</tr>
								<%
								    }
								}
								%>
						</tbody>
					</table>
				</div>
	    	</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="js/button-to-top.js"></script>
		<script src="js/navbar-scroll.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
		<script 
			src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js">
		</script>
		<script>
			$(document).ready(function() {
				$('#myTable').DataTable({
					"language" : {
						"lengthMenu" : "Mostrando _MENU_ ",
						"zeroRecords" : "No hay registros a mostrar",
						"info" : "Página _PAGE_ de _PAGES_",
						"infoEmpty" : "No hay registros disponibles",
						"infoFiltered" : "(filtered from _MAX_ total records)"
					}
				});
			});
		</script>
	</body>
</html>