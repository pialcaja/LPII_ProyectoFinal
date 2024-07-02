-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-06-2024 a las 16:04:13
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bd_cybercloud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_charla`
--

CREATE TABLE IF NOT EXISTS `tbl_charla` (
  `id_charla` int(11) NOT NULL AUTO_INCREMENT,
  `tema` varchar(50) NOT NULL,
  `cupos` int(11) NOT NULL,
  PRIMARY KEY (`id_charla`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tbl_charla`
--

INSERT INTO `tbl_charla` (`id_charla`, `tema`, `cupos`) VALUES
(1, 'Implementación de seguridad en mi sitio web', 2),
(2, 'Nuevos avances en soluciones de ciberseguridad', 0),
(3, 'Estándares de seguridad en la nube', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_detallecharla`
--

CREATE TABLE IF NOT EXISTS `tbl_detallecharla` (
  `id_usu` int(11) NOT NULL DEFAULT '0',
  `id_charla` int(11) NOT NULL DEFAULT '0',
  `fec_reg` date NOT NULL,
  PRIMARY KEY (`id_usu`,`id_charla`),
  KEY `fk_detallecharla_id_charla` (`id_charla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_detallecharla`
--

INSERT INTO `tbl_detallecharla` (`id_usu`, `id_charla`, `fec_reg`) VALUES
(4, 1, '2024-06-27'),
(4, 2, '2024-06-22'),
(4, 3, '2024-06-27'),
(7, 3, '2024-06-27'),
(8, 1, '2024-06-28'),
(8, 3, '2024-06-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_detallemensaje`
--

CREATE TABLE IF NOT EXISTS `tbl_detallemensaje` (
  `id_usu` int(11) NOT NULL DEFAULT '0',
  `id_msj` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usu`,`id_msj`),
  KEY `fk_tbl_detallemensaje_id_msj` (`id_msj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_detallemensaje`
--

INSERT INTO `tbl_detallemensaje` (`id_usu`, `id_msj`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_mensaje`
--

CREATE TABLE IF NOT EXISTS `tbl_mensaje` (
  `id_msj` int(11) NOT NULL AUTO_INCREMENT,
  `desc_msj` varchar(500) NOT NULL,
  `fec_reg` date NOT NULL,
  PRIMARY KEY (`id_msj`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tbl_mensaje`
--

INSERT INTO `tbl_mensaje` (`id_msj`, `desc_msj`, `fec_reg`) VALUES
(2, 'Cambio', '2024-06-20'),
(4, 'prueba 2', '2024-06-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipousuario`
--

CREATE TABLE IF NOT EXISTS `tbl_tipousuario` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(13) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tbl_tipousuario`
--

INSERT INTO `tbl_tipousuario` (`id_tipo`, `nom_tipo`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE IF NOT EXISTS `tbl_usuario` (
  `id_usu` int(11) NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(40) NOT NULL,
  `apepa_usu` varchar(40) NOT NULL,
  `apema_usu` varchar(40) NOT NULL,
  `fono_usu` char(9) NOT NULL,
  `email_usu` varchar(40) NOT NULL,
  `password_usu` varchar(40) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id_usu`),
  KEY `fk_usuario` (`id_tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`id_usu`, `nom_usu`, `apepa_usu`, `apema_usu`, `fono_usu`, `email_usu`, `password_usu`, `id_tipo`) VALUES
(1, 'Piero', 'Caro', 'Jara', '912345677', 'piero@gmail.com', 'Piero123', 1),
(2, 'Favio', 'Condor', 'Silva', '934567891', 'favio@hotmail.com', 'Favio123', 1),
(3, 'Anthony', 'Perez', 'Carrera', '956789013', 'anthony@outlook.com', 'Anthony123', 1),
(4, 'John', 'Connor', 'Hills', '923654987', 'john@hotmail.com', 'John123', 1),
(7, 'Angel', 'Caro', 'Jara', '987654321', 'angel@gmail.com', 'Angel123', 2),
(8, 'Yahir', 'Caro', 'Jara', '987123654', 'yahir@gmail.com', 'Yahir123', 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_detallecharla`
--
ALTER TABLE `tbl_detallecharla`
  ADD CONSTRAINT `fk_detallecharla_id_charla` FOREIGN KEY (`id_charla`) REFERENCES `tbl_charla` (`id_charla`),
  ADD CONSTRAINT `fk_detallecharla_id_usu` FOREIGN KEY (`id_usu`) REFERENCES `tbl_usuario` (`id_usu`);

--
-- Filtros para la tabla `tbl_detallemensaje`
--
ALTER TABLE `tbl_detallemensaje`
  ADD CONSTRAINT `fk_tbl_detallemensaje_id_msj` FOREIGN KEY (`id_msj`) REFERENCES `tbl_mensaje` (`id_msj`),
  ADD CONSTRAINT `fk_tbl_detallemensaje_id_usu` FOREIGN KEY (`id_usu`) REFERENCES `tbl_usuario` (`id_usu`);

--
-- Filtros para la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_tipo`) REFERENCES `tbl_tipousuario` (`id_tipo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
