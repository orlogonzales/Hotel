-- MySQL dump 10.13  Distrib 5.5.12, for Win64 (x86)
--
-- Host: localhost    Database: hotel_db
-- ------------------------------------------------------
-- Server version	5.5.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes_tb`
--

DROP TABLE IF EXISTS `clientes_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes_tb` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tipoCartao` varchar(45) DEFAULT NULL,
  `numeroCartao` varchar(45) DEFAULT NULL,
  `validadeCartao` varchar(45) DEFAULT NULL,
  `cliente_tbcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_tb`
--

LOCK TABLES `clientes_tb` WRITE;
/*!40000 ALTER TABLE `clientes_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoteis_tb`
--

DROP TABLE IF EXISTS `hoteis_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoteis_tb` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteis_tb`
--

LOCK TABLES `hoteis_tb` WRITE;
/*!40000 ALTER TABLE `hoteis_tb` DISABLE KEYS */;
INSERT INTO `hoteis_tb` VALUES (1,'Formula 1 - Alphaville'),(2,'Formula 1 - Santa Efigênia'),(3,'Formula 1 - Vila Guilherme');
/*!40000 ALTER TABLE `hoteis_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartos_tb`
--

DROP TABLE IF EXISTS `quartos_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quartos_tb` (
  `quarto_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `preco` double NOT NULL,
  `frigobar` enum('yes','no') DEFAULT 'yes',
  `banheira` enum('yes','no') DEFAULT 'no',
  `numero_hospedes` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`quarto_id`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `quartos_tb_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis_tb` (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartos_tb`
--

LOCK TABLES `quartos_tb` WRITE;
/*!40000 ALTER TABLE `quartos_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartos_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas_tb`
--

DROP TABLE IF EXISTS `reservas_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas_tb` (
  `reserva_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `quarto_id` int(11) NOT NULL,
  `data_reserva` date DEFAULT NULL,
  `cafe` enum('yes','no') DEFAULT 'no',
  `periodo_dias` int(11) DEFAULT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `quarto_id` (`quarto_id`),
  CONSTRAINT `reservas_tb_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes_tb` (`cliente_id`),
  CONSTRAINT `reservas_tb_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis_tb` (`hotel_id`),
  CONSTRAINT `reservas_tb_ibfk_3` FOREIGN KEY (`quarto_id`) REFERENCES `quartos_tb` (`quarto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_tb`
--

LOCK TABLES `reservas_tb` WRITE;
/*!40000 ALTER TABLE `reservas_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-11-15 16:47:09
