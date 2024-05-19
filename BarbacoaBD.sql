CREATE DATABASE  IF NOT EXISTS `barbacoa1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `barbacoa`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: barbacoa
-- ------------------------------------------------------
-- Server version	5.7.43-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acompañantes`
--

DROP TABLE IF EXISTS `acompañantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acompañantes` (
  `Cod_Acompañante` varchar(5) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Precio` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Acompañante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `acompañantes_pedidos`
--

DROP TABLE IF EXISTS `acompañantes_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acompañantes_pedidos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Pedidos` int(11) NOT NULL,
  `Cod_Acompañante` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_AcompañantePedido_Acompañante_idx` (`Cod_Acompañante`),
  KEY `Fk_AcompañantePedido_Pedidos_idx` (`Id_Pedidos`),
  CONSTRAINT `Fk_AcompañantePedido_Acompañante` FOREIGN KEY (`Cod_Acompañante`) REFERENCES `acompañantes` (`Cod_Acompañante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_AcompañantePedido_Pedidos` FOREIGN KEY (`Id_Pedidos`) REFERENCES `pedidos` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bebidas`
--

DROP TABLE IF EXISTS `bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas` (
  `Cod_Bebida` varchar(5) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Precio` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Bebida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bebidas_pedidos`
--

DROP TABLE IF EXISTS `bebidas_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas_pedidos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Pedidos` int(11) NOT NULL,
  `Cod_Bebida` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_BebidasPedidos_Bebidas_idx` (`Cod_Bebida`),
  KEY `Fk_BebidasPedidos_Pedidos_idx` (`Id_Pedidos`),
  CONSTRAINT `Fk_BebidasPedidos_Bebidas` FOREIGN KEY (`Cod_Bebida`) REFERENCES `bebidas` (`Cod_Bebida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_BebidasPedidos_Pedidos` FOREIGN KEY (`Id_Pedidos`) REFERENCES `pedidos` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `Codigo` varchar(5) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Valor_Hora` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cargo_personal`
--

DROP TABLE IF EXISTS `cargo_personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo_personal` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Personal` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `N_Horas` int(11) NOT NULL,
  `Cod_Cargo` varchar(5) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_CargoPersonal_Personal_idx` (`Id_Personal`),
  KEY `Fk_CargoPersonal_Cargo_idx` (`Cod_Cargo`),
  CONSTRAINT `Fk_CargoPersonal_Cargo` FOREIGN KEY (`Cod_Cargo`) REFERENCES `cargo` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_CargoPersonal_Personal` FOREIGN KEY (`Id_Personal`) REFERENCES `personal` (`Id_Personal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `carta`
--

DROP TABLE IF EXISTS `carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carta` (
  `Cod_Carta` varchar(5) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Descripcion` varchar(144) NOT NULL,
  `Precio` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Carta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `carta_pedido`
--

DROP TABLE IF EXISTS `carta_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carta_pedido` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Pedidos` int(11) NOT NULL,
  `Cod_Carta` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_CartaPedido_Pedidos_idx` (`Id_Pedidos`),
  KEY `Fk_CartaPedido_Carta_idx` (`Cod_Carta`),
  CONSTRAINT `Fk_CartaPedido_Carta` FOREIGN KEY (`Cod_Carta`) REFERENCES `carta` (`Cod_Carta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_CartaPedido_Pedidos` FOREIGN KEY (`Id_Pedidos`) REFERENCES `pedidos` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Cliente` varchar(10) NOT NULL,
  `F_Ingreso` date NOT NULL,
  `Comentarios` varchar(120) NOT NULL,
  `Calificacion` double NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_Clientes_Personas_idx` (`Id_Cliente`),
  CONSTRAINT `Fk_Clientes_Personas` FOREIGN KEY (`Id_Cliente`) REFERENCES `personas` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventario_acompañantes`
--

DROP TABLE IF EXISTS `inventario_acompañantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_acompañantes` (
  `Cod_Acompañante` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Acompañante`),
  KEY `Fk_InventarioAcompañantes_AcompañantesPedidos_idx` (`Cod_Acompañante`),
  CONSTRAINT `Fk_InventarioAcompañantes_AcompañantesPedidos` FOREIGN KEY (`Cod_Acompañante`) REFERENCES `acompañantes_pedidos` (`Cod_Acompañante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventario_bebidas`
--

DROP TABLE IF EXISTS `inventario_bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_bebidas` (
  `Cod_Bebida` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Bebida`),
  KEY `Fk_InventarioBebidas_BebidasPedido_idx` (`Cod_Bebida`),
  CONSTRAINT `Fk_InventarioBebidas_BebidasPedido` FOREIGN KEY (`Cod_Bebida`) REFERENCES `bebidas_pedidos` (`Cod_Bebida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventario_carta`
--

DROP TABLE IF EXISTS `inventario_carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_carta` (
  `Cod_Carta` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Carta`),
  KEY `Fk_InventarioCarta_CartaPedido_idx` (`Cod_Carta`),
  CONSTRAINT `Fk_InventarioCarta_CartaPedido` FOREIGN KEY (`Cod_Carta`) REFERENCES `carta_pedido` (`Cod_Carta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventario_postres`
--

DROP TABLE IF EXISTS `inventario_postres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_postres` (
  `Cod_Postre` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Postre`),
  KEY `Fk_InventarioPostres_PostresPedidos_idx` (`Cod_Postre`),
  CONSTRAINT `Fk_InventarioPostres_PostresPedidos` FOREIGN KEY (`Cod_Postre`) REFERENCES `postres_pedidos` (`Cod_Postre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesa` (
  `Id` int(11) NOT NULL,
  `Descripcion` varchar(15) NOT NULL,
  `Sillas` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `Id` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Id_Mesa` int(11) NOT NULL,
  `Id_Mesero` varchar(10) NOT NULL,
  `Valor_Cuenta` int(11) DEFAULT NULL,
  `Estado` enum('Espera','Finalizado') NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_Pedidos_Mesas_idx` (`Id_Mesa`),
  KEY `Fk_Pedidos_Personal_idx` (`Id_Mesero`),
  CONSTRAINT `Fk_Pedidos_Mesas` FOREIGN KEY (`Id_Mesa`) REFERENCES `mesa` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Pedidos_Personal` FOREIGN KEY (`Id_Mesero`) REFERENCES `personal` (`Id_Personal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `Id_Personal` varchar(10) NOT NULL,
  `Comentario` varchar(50) DEFAULT NULL,
  `Calificacion` float DEFAULT NULL,
  PRIMARY KEY (`Id_Personal`),
  CONSTRAINT `Fk_PersonalPersonas` FOREIGN KEY (`Id_Personal`) REFERENCES `personas` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `Id` varchar(10) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Celular` varchar(10) NOT NULL,
  `F_Nacimiento` date NOT NULL,
  `Edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `postres`
--

DROP TABLE IF EXISTS `postres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postres` (
  `Cod_Postre` varchar(5) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Precio` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Postre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `postres_pedidos`
--

DROP TABLE IF EXISTS `postres_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postres_pedidos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Pedidos` int(11) NOT NULL,
  `Cod_Postre` varchar(5) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_PostresPedidos_Pedidos_idx` (`Id_Pedidos`),
  KEY `Fk_PostresPedidos_Postres_idx` (`Cod_Postre`),
  CONSTRAINT `Fk_PostresPedidos_Pedidos` FOREIGN KEY (`Id_Pedidos`) REFERENCES `pedidos` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_PostresPedidos_Postres` FOREIGN KEY (`Cod_Postre`) REFERENCES `postres` (`Cod_Postre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor_acompañantes`
--

DROP TABLE IF EXISTS `proveedor_acompañantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_acompañantes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Proveedor` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `Valor` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_ProveedorAcompañante_Proveedores_idx` (`Id_Proveedor`),
  CONSTRAINT `Fk_ProveedorAcompañante_Proveedores` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedores` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor_bebidas`
--

DROP TABLE IF EXISTS `proveedor_bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_bebidas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Proveedor` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(80) NOT NULL,
  `Valor` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_ProveedorBebidas_Proveedores_idx` (`Id_Proveedor`),
  CONSTRAINT `Fk_ProveedorBebidas_Proveedores` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedores` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor_carta`
--

DROP TABLE IF EXISTS `proveedor_carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_carta` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Proveedor` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(80) NOT NULL,
  `Valor` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_ProveedorCarta_Proveedores_idx` (`Id_Proveedor`),
  CONSTRAINT `Fk_ProveedorCarta_Proveedores` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedores` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor_servicios`
--

DROP TABLE IF EXISTS `proveedor_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_servicios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Proveedor` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `Valor` int(11) NOT NULL,
  `Nombre` varchar(85) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_ProveedorServicios_Proveedores_idx` (`Id_Proveedor`),
  CONSTRAINT `Fk_ProveedorServicios_Proveedores` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedores` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `Id` varchar(10) NOT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `Fk_Proveedor_Persona` FOREIGN KEY (`Id`) REFERENCES `personas` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedores_postres`
--

DROP TABLE IF EXISTS `proveedores_postres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores_postres` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Proveedor` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(60) NOT NULL,
  `Valor` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_ProveedorPostre_Proveedores_idx` (`Id_Proveedor`),
  CONSTRAINT `Fk_ProveedorPostre_Proveedores` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedores` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Valor_Reserva` int(11) NOT NULL,
  `Id_Cliente` varchar(10) NOT NULL,
  `Id_Pedido` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Fk_Reservas_Personas_idx` (`Id_Cliente`),
  KEY `Fk_Reservas_Pedidos_idx` (`Id_Pedido`),
  CONSTRAINT `Fk_Reservas_Pedidos` FOREIGN KEY (`Id_Pedido`) REFERENCES `pedidos` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Reservas_Personas` FOREIGN KEY (`Id_Cliente`) REFERENCES `personas` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Id_Usuario` varchar(10) NOT NULL,
  `Usuario` varchar(25) NOT NULL,
  `Contraseña` varchar(15) NOT NULL,
  PRIMARY KEY (`Id_Usuario`),
  UNIQUE KEY `Usuario_UNIQUE` (`Usuario`),
  CONSTRAINT `Fk_Usuarios_Persona` FOREIGN KEY (`Id_Usuario`) REFERENCES `personas` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 18:25:16
