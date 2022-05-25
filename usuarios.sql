-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 25-05-2022 a las 17:48:54
-- Versión del servidor: 5.7.34
-- Versión de PHP: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `CentreCiutat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `cuentaCorriente` varchar(30) NOT NULL,
  `matricula` varchar(10) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL,
  `idEstacionamiento` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `nombre`, `apellidos`, `direccion`, `cuentaCorriente`, `matricula`, `admin`, `idEstacionamiento`) VALUES
('43056439H', 'Reginaldo Patricio', 'Angue', 'Calle Volcán 34, bajos H', 'ES213243434356788986', '3348KFW', 0, '1A25'),
('43451287S', 'Marcos', 'Perelló', 'Calle malta, 11', 'ES154287653251487591', NULL, 1, NULL),
('43910299L', 'Antonio', 'Rodriguez Soleado', 'Calle Andalucia 293', 'ES933920475839028480', '8493RUF', 0, '1A27'),
('49403993T', 'Alfredo', 'Martinez Soria', 'Calle Peru 93', 'ES231234543245566532', NULL, 1, NULL),
('74984134S', 'Leonardo', 'Casio Enrique', 'Calle Mamadou 32, 2J', 'ES313243344356288896', '8495AKV', 0, '1A30'),
('94302049N', 'Adrian', 'Tur Marzo', 'Calle Instituto, 23', 'ES293032101048489345', NULL, 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `fk_UsuarioMatricula` (`matricula`),
  ADD KEY `fk_UsuarioEstacionamiento` (`idEstacionamiento`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_UsuarioEstacionamiento` FOREIGN KEY (`idEstacionamiento`) REFERENCES `estacionamientos` (`idEstacionamiento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_UsuarioMatricula` FOREIGN KEY (`matricula`) REFERENCES `vehiculos` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
