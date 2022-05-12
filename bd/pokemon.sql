-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220508.7aa512c357
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2022 a las 22:00:22
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokemon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_ENTRENADOR` int(255) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  `EQUIPO` int(255) NOT NULL,
  `CAJA` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `ID_ESTADO` int(255) NOT NULL,
  `NOM_ESTADO` varchar(255) NOT NULL,
  `NUM_tURNOS` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `ID_MOVIMIENTO` int(255) NOT NULL,
  `NOM_MOVIMIENTO` varchar(255) NOT NULL,
  `TIPO_MOVIMIENTO` int(255) NOT NULL,
  `CONS_ESTAMINA` int(255) NOT NULL,
  `FK ID_ATAQUE` int(255) NOT NULL,
  `FK ID_MEJORA` int(255) NOT NULL,
  `FK ID_ESTADO` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mov_ataque`
--

CREATE TABLE `mov_ataque` (
  `ID_MOV_ATAQUE` int(255) NOT NULL,
  `NOM_MOVIMIENTO` varchar(255) NOT NULL,
  `POTENCIA` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mov_estado`
--

CREATE TABLE `mov_estado` (
  `ID_MOV_ESTADO` int(255) NOT NULL,
  `NOM_MOVIMIENTO` varchar(255) NOT NULL,
  `ESTADO` enum('DORMIDO','QUEMADO','CONGELADO','PARALIZADO','SIN_ESTADO') NOT NULL,
  `NUM_TURNOS` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mov_mejora`
--

CREATE TABLE `mov_mejora` (
  `ID_MOV_MEJORA` int(255) NOT NULL,
  `NOM_MOVIMIENTO` varchar(255) NOT NULL,
  `MEJORA` varchar(255) NOT NULL,
  `CANT_MEJORA` int(255) NOT NULL,
  `NUM_TURNOS` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokedex`
--

CREATE TABLE `pokedex` (
  `NUM_POKEDEX` int(255) NOT NULL,
  `ID_POKEMON` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `ID_POKEMON` int(255) NOT NULL,
  `ID_ENTRENADOR` int(255) NOT NULL,
  `NUM_POKEDEX` int(255) NOT NULL,
  `MOTE` varchar(255) NOT NULL,
  `VITALIDAD` int(255) NOT NULL,
  `ATAQUE` int(255) NOT NULL,
  `DEFENSA` int(255) NOT NULL,
  `ATQ_ESPECIAL` int(255) NOT NULL,
  `DEF_ESPECIAL` int(255) NOT NULL,
  `VELOCIDAD` int(255) NOT NULL,
  `ESTAMINA` int(255) NOT NULL,
  `NIVEL` int(255) NOT NULL,
  `EXPERIENCIA` int(255) NOT NULL,
  `FERTILIDAD` int(255) NOT NULL,
  `ID_EQUIPO` int(255) NOT NULL,
  `ID_MOVIMIENTO` int(255) NOT NULL,
  `TIPO` int(255) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_ENTRENADOR`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`ID_ESTADO`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`ID_MOVIMIENTO`),
  ADD KEY `FK ID_ESTADO` (`FK ID_ESTADO`),
  ADD KEY `FK ID_MEJORA` (`FK ID_MEJORA`),
  ADD KEY `FK ID_ATAQUE` (`FK ID_ATAQUE`);

--
-- Indices de la tabla `mov_ataque`
--
ALTER TABLE `mov_ataque`
  ADD PRIMARY KEY (`ID_MOV_ATAQUE`);

--
-- Indices de la tabla `mov_estado`
--
ALTER TABLE `mov_estado`
  ADD PRIMARY KEY (`ID_MOV_ESTADO`);

--
-- Indices de la tabla `mov_mejora`
--
ALTER TABLE `mov_mejora`
  ADD PRIMARY KEY (`ID_MOV_MEJORA`);

--
-- Indices de la tabla `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`NUM_POKEDEX`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID_POKEMON`),
  ADD KEY `ID_ENTRENADOR` (`ID_ENTRENADOR`),
  ADD KEY `ID_MOVIMIENTO` (`ID_MOVIMIENTO`),
  ADD KEY `NUM_POKEDEX` (`NUM_POKEDEX`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`FK ID_ESTADO`) REFERENCES `estado` (`ID_ESTADO`),
  ADD CONSTRAINT `movimiento_ibfk_2` FOREIGN KEY (`FK ID_MEJORA`) REFERENCES `mov_mejora` (`ID_MOV_MEJORA`),
  ADD CONSTRAINT `movimiento_ibfk_3` FOREIGN KEY (`FK ID_ATAQUE`) REFERENCES `mov_ataque` (`ID_MOV_ATAQUE`);

--
-- Filtros para la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD CONSTRAINT `pokemon_ibfk_1` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenador` (`ID_ENTRENADOR`),
  ADD CONSTRAINT `pokemon_ibfk_2` FOREIGN KEY (`ID_MOVIMIENTO`) REFERENCES `movimiento` (`ID_MOVIMIENTO`),
  ADD CONSTRAINT `pokemon_ibfk_3` FOREIGN KEY (`NUM_POKEDEX`) REFERENCES `pokedex` (`NUM_POKEDEX`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



