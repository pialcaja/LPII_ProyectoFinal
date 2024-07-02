<%@page import="model.MensajeConUsuario"%>
<%@page import="model.TblDetallemensaje"%>
<%@page import="java.util.List"%>
<%@page import="model.TblUsuario"%>
<%@page import="model.TblMensaje"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
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
    <link rel="shortcut icon" href="img/bloqueado.ico" />
    <%
        TblUsuario u = (TblUsuario) request.getSession().getAttribute("u");
    %>
    <title>CyberCloud | Administrador</title>
</head>
<body style="background: #e4e4e4 url('img/jjj.jpg') no-repeat center center fixed; background-size: cover;">
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
                                <li><a class="dropdown-item" href="listaUsuariosAdmin.jsp">Lista de usuarios</a></li>
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
    <div class="container" style="margin-top: 20px; background: rgba(52, 235, 146); padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, .5); animation: divanimation 1s ease forwards;">
        <div class="row">
            <div class="col-12">
                <h2 style="text-align: center"><strong><i class="bi bi-card-list"></i> Lista de mensajes <i class="bi bi-card-list"></i></strong></h2>
                <form action="ControladorMensaje" method="get">
                    <input type="hidden" name="accion" value="Listar">
                    <button class="btn btn-success" style="width: 100%; margin: 20px 0">Listar</button>
                </form>
                <table class="table table-hover" id="myTable" style="background: white; padding: 20px; border-radius: 10px; margin-bottom: 20px;">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Mensaje</th>
                            <th scope="col">Fecha registro</th>
                            <th scope="col">Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
						List<MensajeConUsuario> mensajes = (List<MensajeConUsuario>) request.getAttribute("mensajesConUsuario");
						if (mensajes != null) {
						    for (MensajeConUsuario mensaje : mensajes) {
						%>
						<tr>
						    <td><%=mensaje.getIdUsuario()%></td>
						    <td><%=mensaje.getNomUsuario()%></td>
						    <td><%=mensaje.getDescMensaje()%></td>
						    <td><%=mensaje.getFecRegistro()%></td>
						    <td>
							    <form action="ControladorMensaje?accion=Eliminar&cod=<%=mensaje.getIdMensaje()%>" method="post" >
						            <button type="submit" style="color:red; background:none; border:none; text-decoration:none; cursor:pointer;">Eliminar</button>
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
                    "lengthMenu" : "Mostrar _MENU_ registros por página",
                    "zeroRecords" : "No se encontraron registros",
                    "info" : "Mostrando página _PAGE_ de _PAGES_",
                    "infoEmpty" : "No hay registros disponibles",
                    "infoFiltered" : "(filtrado de _MAX_ registros totales)",
                    "search" : "Buscar:",
                    "paginate" : {
                        "first" : "Primero",
                        "last" : "Último",
                        "next" : "Siguiente",
                        "previous" : "Anterior"
                    }
                }
            });
        });
    </script>
</body>
</html>
