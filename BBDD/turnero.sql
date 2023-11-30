-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-11-2023 a las 15:14:16
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
CREATE TABLE IF NOT EXISTS `ciudadano` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `DNI` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `DNI`, `NOMBRE`) VALUES
(1, 'del palacio', '50996874d', 'jose'),
(2, 'del palacio', '50996874d', 'jose'),
(3, 'del palacio', '50996874d', 'jose'),
(4, 'nuñez', '50996874d', 'jose');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE IF NOT EXISTS `turno` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ESTADO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ciudadano_nombre` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ciudadano_dni` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ciudadano_apellido` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`ID`, `DESCRIPCION`, `ESTADO`, `FECHA`, `ciudadano_nombre`, `ciudadano_dni`, `ciudadano_apellido`) VALUES
(1, 'arreglar tuberias', 'Ya atendido', '2023-11-29', 'jose', '50996874d', 'del palacio'),
(2, 'arreglar canalones', 'Ya atendido', '2023-11-29', 'jose', '50996874d', 'del palacio'),
(3, 'arreglar tuberias', 'En espera', '2023-11-30', 'jose', '50996874d', 'nuñez'),
(4, NULL, 'En espera', '2023-11-30', NULL, NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
