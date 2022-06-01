-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 01-06-2022 a las 17:05:02
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
-- Estructura de tabla para la tabla `alquiler`
--

CREATE TABLE `alquiler` (
  `idAlquiler` int(11) NOT NULL,
  `idEstacionamiento` varchar(10) NOT NULL,
  `precioMesual` int(11) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `matricula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alquiler`
--

INSERT INTO `alquiler` (`idAlquiler`, `idEstacionamiento`, `precioMesual`, `dni`, `matricula`) VALUES
(1, '1A25', 350, '43056439H', '3348KFW'),
(2, '1A27', 400, '43910299L', '8493RUF'),
(3, '1A30', 320, '74984134S', '8495AKV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacionamientos`
--

CREATE TABLE `estacionamientos` (
  `idEstacionamiento` varchar(10) NOT NULL,
  `precioMensual` double NOT NULL,
  `m2` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estacionamientos`
--

INSERT INTO `estacionamientos` (`idEstacionamiento`, `precioMensual`, `m2`) VALUES
('1A20', 200, 4),
('1A21', 300, 3.5),
('1A22', 300, 5),
('1A23', 440, 4),
('1A24', 340, 3.4),
('1A25', 350, 3),
('1A26', 250, 4),
('1A27', 400, 4),
('1A28', 475, 3),
('1A29', 500, 4),
('1A30', 320, 3);

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
  `idEstacionamiento` varchar(10) DEFAULT NULL,
  `contrasena` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `nombre`, `apellidos`, `direccion`, `cuentaCorriente`, `matricula`, `admin`, `idEstacionamiento`, `contrasena`) VALUES
('43056439H', 'Reginaldo Patricio', 'Angue', 'Calle Volcán 34, bajos H', 'ES213243434356788986', '3348KFW', 0, '1A25', '123'),
('43451287S', 'Marcos', 'Perelló', 'Calle malta, 11', 'ES154287653251487591', NULL, 1, NULL, ''),
('43910299L', 'Antonio', 'Rodriguez Soleado', 'Calle Andalucia 293', 'ES933920475839028480', '8493RUF', 0, '1A27', ''),
('49403993T', 'Alfredo', 'Martinez Soria', 'Calle Peru 93', 'ES231234543245566532', NULL, 1, NULL, ''),
('74984134S', 'Leonardo', 'Casio Enrique', 'Calle Mamadou 32, 2J', 'ES313243344356288896', '8495AKV', 0, '1A30', ''),
('94302049N', 'Adrian', 'Tur Marzo', 'Calle Instituto, 23', 'ES293032101048489345', NULL, 1, NULL, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `color` varchar(30) NOT NULL,
  `motor` varchar(30) NOT NULL,
  `tipoVehiculo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`matricula`, `marca`, `modelo`, `color`, `motor`, `tipoVehiculo`) VALUES
('3348KFW', 'Mazda', 'RX-7', 'Granate', '2JZ', 'Coche'),
('8493RUF', 'Seat', 'Leon', 'Blanco', '1.0 TSI', 'Coche'),
('8495AKV', 'Kawasaki', 'Ninja', 'Verde', 'H2R', 'Motocicleta');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alquiler`
--
ALTER TABLE `alquiler`
  ADD PRIMARY KEY (`idAlquiler`),
  ADD KEY `fk_alquilerEstacionamiento` (`idEstacionamiento`),
  ADD KEY `fk_alquilerUsuario` (`dni`),
  ADD KEY `fk_alquilerVehiculos` (`matricula`);

--
-- Indices de la tabla `estacionamientos`
--
ALTER TABLE `estacionamientos`
  ADD PRIMARY KEY (`idEstacionamiento`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `fk_UsuarioMatricula` (`matricula`),
  ADD KEY `fk_UsuarioEstacionamiento` (`idEstacionamiento`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`matricula`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquiler`
--
ALTER TABLE `alquiler`
  ADD CONSTRAINT `fk_alquilerEstacionamiento` FOREIGN KEY (`idEstacionamiento`) REFERENCES `estacionamientos` (`idEstacionamiento`),
  ADD CONSTRAINT `fk_alquilerUsuario` FOREIGN KEY (`dni`) REFERENCES `usuarios` (`dni`),
  ADD CONSTRAINT `fk_alquilerVehiculos` FOREIGN KEY (`matricula`) REFERENCES `vehiculos` (`matricula`);

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
