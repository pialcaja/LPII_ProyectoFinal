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
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="shortcut icon" href="img/bloqueado.ico" />
        <%
			TblUsuario u = (TblUsuario) request.getSession().getAttribute("u");
		%>
        <title>CyberCloud | Nosotros</title>
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                    	<i class="bi bi-person-fill"></i><%=u.getNomUsu()%>
                    </a>
                    <ul class="dropdown-menu">
                     <li><a class="dropdown-item" href="actualizar.jsp">Actualizar datos</a><li/>
                     <li class="dropdown divider"><li/>
                     <li><a class="dropdown-item" href="ControladorUsuario?accion=Logout">Cerrar sesión</a><li/>
                    </ul>
                </li>
                </ul>
            </div>
            </div>
        </nav>
        <!-- BOTON REGRESO ARRIBA -->
        <button type="button" class="btn btn-danger btn-floating btn-lg" id="btn-back-to-top">
            <i class="bi bi-arrow-up"></i>
        </button>
        <!-- SECCION NOSOTROS -->
        <section id="nosotros" class="nosotros">
            <div class="seccion-subtitulo text-center">
                <h2>|  Nosotros  |</h2>
            </div>
            <div class="container text-left">
                <div class="row">
                    <div class="nosotros-columna col-12 col-md-6">
                        <img src="img/nosotros-1.jpg" class="d-block w-80" alt="">
                    </div>
                    <div class="nosotros-columna col-12 col-md-6 texto">
                        <p class="nosotros-titulo"><b>NUESTRA MISIÓN</b></p>
                        <p class="nosotros-slogan"><b>Su socio de ciberseguridad, hoy y mañana</b></p>
                        <p>Nuestra misión es ser el socio de ciberseguridad preferido, protegiendo nuestra forma de vida digital.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="nosotros-columna col-12 col-md-6 texto">
                        <p class="nosotros-titulo"><b>¿QUÉ HACEMOS?</b></p>
                        <p class="nosotros-slogan"><b>Impulsar la innovación para un mañana mejor</b></p>
                        <p>Todos los días, CyberCloud proporciona la visibilidad, inteligencia confiable, automatización y flexibilidad que ayudan a las organizaciones complejas a avanzar de forma segura.</p>
                    </div>
                    <div class="nosotros-columna col-12 col-md-6">
                        <img src="img/nosotros-2.jpg" class="d-block w-80" alt="">
                    </div>
                </div>
                <div class="row">
                    <div class="nosotros-columna col-12 col-md-6">
                        <img src="img/nosotros-3.jpg" class="d-block w-80" alt="">
                    </div>
                    <div class="nosotros-columna col-12 col-md-6 texto">
                        <p class="nosotros-titulo"><b>SOMOS INTEGRALES</b></p>
                        <p class="nosotros-slogan"><b>Superar todas las necesidades de seguridad</b></p>
                        <p>Al ofrecer una cartera integral y potenciar un ecosistema de socios en crecimiento, estamos a la vanguardia de la protección de decenas de miles de organizaciones en nubes, redes y dispositivos móviles.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- FOOTER -->
        <footer class="d-flex align-items-center flex-column">
            <div>
                <p class="footer-texto text-center">Síguenos en nuestras <br> redes sociales</p>
                <div class="iconos-redes-sociales d-flex flex-wrap align-items-center justify-content-center">
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
            </div>
            <p class="copy">Copyright © 2024 CyberCloud. Todos los derechos reservados.</p>
        </footer>
    </body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="js/button-to-top.js"></script>
</html>