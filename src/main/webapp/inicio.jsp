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
        <title>CyberCloud | Inicio</title>
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">| CyberCloud |</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#productos">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#soluciones">Soluciones</a>
                </li>
				<li class="nav-item">
					<a class="nav-link" href="eventos.jsp">Eventos</a>
				</li>
                <li class="nav-item">
                    <a class="nav-link" href="nosotros.jsp">Nosotros</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contacto">Contacto</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                    	<i class="bi bi-person-fill"></i><%=u.getNomUsu()%>
                    </a>
                    <ul class="dropdown-menu">
                     <li><a class="dropdown-item" href="actualizar.jsp">Actualizar datos</a><li/>
                     <li class="dropdown divider"><li/>
                     <li><a class="dropdown-item" href="ControladorUsuario?accion=Logout">Cerrar sesión</a></li>
                    </ul>
                </li>
                </ul>
            </div>
            </div>
        </nav>
        <!-- BANNER -->
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div id="carousel-1" class="carousel-item active" data-bs-interval="5000" style="max-height: 650px;">
                    <div>
                        <img src="img/que-es-seguridad-informatica.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-caption">
                        <h3>No todos los eventos SASE se crean igual.
                            <br>
                            Conozca Prisma SASE con tecnología de IA.
                        </h3>
                        <p> Descubra cómo Prisma SASE ofrece operaciones de IA totalmente nuevas con seguridad ZTNA 2.0 y SD-WAN integrada.</p>
                    </div>
                </div>
                <div id="carousel-2" class="carousel-item" data-bs-interval="5000" style="max-height: 650px;">
                    <img src="img/seguridad_informatica_8d68a869-db4f-4469-acb7-fcfc6d20a383.webp" class="d-block w-100" alt="...">
                    <div class="carousel-caption">
                        <h3>Desde las instalaciones a Azure,
                            <br>
                            seguridad sin inconvenientes
                        </h3>
                        <p> Presentamos NGFW en la nube para Azure.
                            <br>
                            Ahora puede implementar fácilmente la seguridad de red de Palo Alto Networks, la mejor de su categoría, independientemente de dónde se ejecuten sus aplicaciones.
                        </p>
                    </div>
                </div>
                <div id="carousel-3" class="carousel-item" data-bs-interval="5000" style="max-height: 650px;">
                    <img src="img/istock-802320836.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption">
                        <h3>El único proveedor reconocido como líder en SSE y SD-WAN</h3>
                        <p> Después de haber sido considerados por Gartner® como líderes en Magic Quadrant 2022 para SD-WAN, acabamos de ser considerados como líderes en el Magic Quadrant 2023 para SSE.</p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
            </button>
        </div>
        <!-- BOTON REGRESO ARRIBA -->
        <button type="button" class="btn btn-danger btn-floating btn-lg" id="btn-back-to-top">
            <i class="bi bi-arrow-up"></i>
        </button>
        <!-- SECCION PRODUCTOS -->
        <section id="productos" class="productos">
            <div class="seccion-subtitulo text-center">
                <h2>|  Productos  |</h2>
            </div>
            <div class="container text-left">
                <div class="row">
                    <div class="producto-columna col-12 col-md-2.4">
                        <img src="img/producto-1.svg" class="d-block w-80" alt="">
                        <p class="producto-titulo"><b>Proteja cualquier nube</b></p>
                        <p>Proteja las aplicaciones nativas de la nube durante todo el ciclo de vida en cualquier nube.</p>
                    </div>
                    <div class="producto-columna col-12 col-md-2.4">
                        <img src="img/producto-2.svg" class="d-block w-80" alt="">
                        <p class="producto-titulo"><b>Automatice las operaciones de seguridad</b></p>
                        <p>Potencie las operaciones de seguridad con detección, investigación y respuesta basadas en la automatización.</p>
                    </div>
                    <div class="producto-columna col-12 col-md-2.4">
                        <img src="img/producto-3.svg" class="d-block w-80" alt="">
                        <p class="producto-titulo"><b>Adopte el modelo de seguridad de res Zero Trust</b></p>
                        <p>Aplique las innovaciones del sector en toda la pila de seguridad de la red.</p>
                    </div>
                    <div class="producto-columna col-12 col-md-2.4">
                        <img src="img/producto-4.svg" class="d-block w-80" alt="">
                        <p class="producto-titulo"><b>Proteja las fuerzas de trabajo híbridas</b></p>
                        <p>Conecte y proteja a todos los usuarios y dispositivos que acceden a cualquier aplicación.</p>
                    </div>
                    <div class="producto-columna col-12 col-md-2.4">
                        <img src="img/producto-5.svg" class="d-block w-80" alt="">
                        <p class="producto-titulo"><b>Responda más rápido con inteligencia sobre amenazas y consultoría de seguridad</b></p>
                        <p>Apóyese en asesores de confianza para defenderse a las ciberamenazas.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- SECCION SOLUCIONES -->
        <section id="soluciones" class="soluciones">
            <div class="seccion-subtitulo text-center">
                <h2>|  Soluciones  |</h2>
            </div>
            <div class="container text-left">
                <div class="row">
                    <div class="solucion-columna col-12 col-md-2.4">
                        <img src="img/solucion-1.svg" alt="">
                        <p class="solucion-titulo"><b>Para los Directores de seguridad de la información (CISO)</b></p>
                        <p class="solucion-texto">Obtenga visibilidad y reduzca los riesgos de los puntos débiles y lo puntos ciegos de toda su organización, incluidos los entornos locales y en la nube.</p>
                    </div>
                    <div class="solucion-columna col-12 col-md-2.4">
                        <img src="img/solucion-2.svg" alt="">
                        <p class="solucion-titulo"><b>Para Jefes de Infraestructura</b></p>
                        <p class="solucion-texto">Su red depende cada vez más de datos externos. Proteja los límites en un mundo sin perímetros mientras las amenazas continúan diversificándose.</p>
                    </div>
                    <div class="solucion-columna col-12 col-md-2.4">
                        <img src="img/solucion-3.svg" alt="">
                        <p class="solucion-titulo"><b>Para ingenieros de seguridad de redes</b></p>
                        <p class="solucion-texto">La seguridad resulta fundamental para las decisiones de su organización. Asegúrese de que no haya sorpresas al trabajar con nuevas soluciones.</p>
                    </div>
                    <div class="solucion-columna col-12 col-md-2.4">
                        <img src="img/solucion-4.svg" alt="">
                        <p class="solucion-titulo"><b>Para arquitectos de la nube</b></p>
                        <p class="solucion-texto">Proteja los contenedores y aplicaciones de Kubernetes en cualquier entorno. Gestione las vulnerabilidades, cumpla con las normativas y proteja sus aplicaciones.</p>
                    </div>
                    <div class="solucion-columna col-12 col-md-2.4">
                        <img src="img/solucion-2.svg" alt="">
                        <p class="solucion-titulo"><b>Para Gerentes de SOC</b></p>
                        <p class="solucion-texto">Reduzca el tiempo de respuesta aprovechando el poder de lo análisis, el aprendizaje automático y la automatización. Proteja los activos de los endpoints, de la red y la nube de los ataques modernos</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- SECCION CONTACTO -->
        <section id="contacto" class="contacto">
            <div class="seccion-subtitulo text-center">
                <h2>|  Contacto  |</h2>
            </div>
            <div class="formulario">
                <form class="row g-3" action="ControladorMensaje?accion=Registrar" method="post">
                    <div class="col-md-4">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="txtNombre" value="<%=u.getNomUsu()%>" placeholder="Ingrese nombre" autocomplete="off" readonly required>
                    </div>
                    <div class="col-md-4">
                    <label for="apepa" class="form-label">Apellido paterno</label>
                    <input type="text" class="form-control" id="apepa" name="txtApepa" value="<%=u.getApepaUsu()%>" placeholder="Ingrese apellido paterno" autocomplete="off" readonly required>
                    </div>
                    <div class="col-md-4">
                    <label for="apema" class="form-label">Apellido materno</label>
                    <input type="text" class="form-control" id="apema" name="txtApema" value="<%=u.getApemaUsu()%>" placeholder="Ingrese apellido materno" autocomplete="off" readonly required>
                    </div>
                    <div class="col-md-6">
                    <label for="email" class="form-label">Correo</label>
                    <input type="email" class="form-control" id="email" name="txtEmail" value="<%=u.getEmailUsu()%>" placeholder="Ingrese correo electrónico" autocomplete="off" readonly required>
                    </div>
                    <div class="col-md-6">
                    <label for="fono" class="form-label">Teléfono</label>
                    <input type="text" class="form-control" id="fono" name="txtFono" value="<%=u.getFonoUsu()%>" placeholder="Ingrese teléfono" autocomplete="off" readonly required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Mensaje</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="txtMensaje" placeholder="Ingrese mensaje" autocomplete="off" required></textarea>
                    </div>
                    <div class="col-12">
                    <button type="submit" class="btn btn-primary">Enviar</button>
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
			</form>
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