USE `emotelprod`;



DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `provincia` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `distrito`;
CREATE TABLE `distrito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `provincia_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_provincia_id_idx` (`provincia_id`),
  CONSTRAINT `fk_provincia_id` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `distrito` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `rol` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `password` varchar(50) NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rol_id_idx` (`rol_id`),
  CONSTRAINT `fk_rol_id` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `usuario` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `tipohotel`;
CREATE TABLE `tipohotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(900) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tipohotel` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `tipohotel_id` int(11) NOT NULL,
  `distritos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_distritos_id_idx` (`distritos_id`),
  KEY `fk_tipohotel_id_idx` (`tipohotel_id`),
  CONSTRAINT `fk_distritos_id` FOREIGN KEY (`distritos_id`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipohotel_id` FOREIGN KEY (`tipohotel_id`) REFERENCES `tipohotel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `hotel` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `restaurante`;
CREATE TABLE `restaurante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `distrito_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_distrito_id_idx` (`distrito_id`),
  CONSTRAINT `fk_distrito_id` FOREIGN KEY (`distrito_id`) REFERENCES `distrito` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `restaurante` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurante_id` int(11) NOT NULL,
  `hotel_id` int(11) NOT NULL,
  `administrador_id` int(11) NOT NULL,
  `diasreserva` int(11) NOT NULL,
  `costototal` double NOT NULL,
  `fechareserva` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_restaurante_id_idx` (`restaurante_id`),
  KEY `fk_hotel_id_idx` (`hotel_id`),
  KEY `fk_administrador_id_idx` (`administrador_id`),
  CONSTRAINT `fk_administrador_id` FOREIGN KEY (`administrador_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurante_id` FOREIGN KEY (`restaurante_id`) REFERENCES `restaurante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `reserva` WRITE;
UNLOCK TABLES;