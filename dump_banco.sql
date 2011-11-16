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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_tb`
--

LOCK TABLES `clientes_tb` WRITE;
/*!40000 ALTER TABLE `clientes_tb` DISABLE KEYS */;
INSERT INTO `clientes_tb` VALUES (6,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(7,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(8,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(9,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(10,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(11,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(12,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(13,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(14,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(15,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(16,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(17,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(18,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(19,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(20,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(21,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(22,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(23,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(24,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(25,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(26,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(27,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(28,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(29,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(30,'Alisson','Estr. da Batalha','474747','sÃ£o Roque','2091208','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(31,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(32,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(33,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(34,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(35,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(36,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(37,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(38,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(39,'Alisson Perez','Estr. da Batalha','12342123','SÃ£o Roque','02967-170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(40,'ALissno','Estr. da Batalha','23123123','SÃ£o Roque','02967170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL),(41,'Alisson Perez','Estr. da Batalha','31872398','SÃ£o Roque','02967170','SP','Brasil','alissonperez@gmail.com',NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteis_tb`
--

LOCK TABLES `hoteis_tb` WRITE;
/*!40000 ALTER TABLE `hoteis_tb` DISABLE KEYS */;
INSERT INTO `hoteis_tb` VALUES (4,'Mackenzie Hotel - Sao Paulo'),(5,'Mackenzie Hotel - Campinas'),(6,'Mackenzie Hotel - RJ');
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
  `ocupado` enum('yes','no') DEFAULT 'no',
  `reservado` enum('yes','no') DEFAULT 'no',
  PRIMARY KEY (`quarto_id`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `quartos_tb_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis_tb` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartos_tb`
--

LOCK TABLES `quartos_tb` WRITE;
/*!40000 ALTER TABLE `quartos_tb` DISABLE KEYS */;
INSERT INTO `quartos_tb` VALUES (1,4,140,'yes','yes',3,'comum','no','yes'),(2,4,180,'yes','yes',4,'master','no','yes'),(3,4,180,'yes','yes',4,'master','no','yes'),(4,4,180,'yes','yes',4,'master','no','yes'),(5,4,140,'yes','yes',3,'comum','no','yes'),(6,4,140,'yes','yes',3,'comum','no','yes'),(7,4,140,'yes','yes',3,'comum','no','yes'),(8,4,200,'yes','yes',5,'presidencial','no','no'),(9,4,200,'yes','yes',5,'presidencial','no','no'),(10,4,200,'yes','yes',5,'presidencial','no','no'),(12,4,90,'yes','yes',1,'alone','no','no'),(13,4,90,'yes','yes',1,'alone','no','no'),(14,4,90,'yes','yes',1,'alone','no','no'),(15,5,90,'yes','yes',1,'alone','no','no'),(16,5,90,'yes','yes',1,'alone','no','no'),(17,5,90,'yes','yes',1,'alone','no','no'),(18,5,90,'yes','yes',1,'alone','no','no'),(19,5,90,'yes','yes',1,'alone','no','no'),(20,5,200,'yes','yes',5,'presidencial','no','no'),(21,5,200,'yes','yes',5,'presidencial','no','no'),(22,5,200,'yes','yes',5,'presidencial','no','no'),(23,5,200,'yes','yes',5,'presidencial','no','no'),(24,5,200,'yes','yes',5,'presidencial','no','no'),(25,5,140,'yes','yes',3,'commum','no','no'),(26,5,140,'yes','yes',3,'commum','no','no'),(27,5,140,'yes','yes',3,'commum','no','no'),(28,5,140,'yes','yes',3,'commum','no','no'),(29,5,140,'yes','yes',3,'commum','no','no'),(30,5,140,'yes','yes',3,'commum','no','no'),(31,5,140,'yes','yes',3,'commum','no','no'),(32,5,140,'yes','yes',3,'commum','no','no'),(33,5,180,'yes','yes',4,'master','no','yes'),(34,5,180,'yes','yes',4,'master','no','yes'),(35,5,180,'yes','yes',4,'master','no','yes'),(36,5,180,'yes','yes',4,'master','no','yes'),(37,5,180,'yes','yes',4,'master','no','yes'),(38,5,180,'yes','yes',4,'master','no','yes'),(39,6,90,'yes','yes',1,'alone','no','yes'),(40,6,90,'yes','yes',1,'alone','no','no'),(41,6,90,'yes','yes',1,'alone','no','no'),(42,6,90,'yes','yes',1,'alone','no','no'),(43,6,90,'yes','yes',1,'alone','no','no'),(44,6,200,'yes','yes',5,'presidencial','no','no'),(45,6,200,'yes','yes',5,'presidencial','no','no'),(46,6,200,'yes','yes',5,'presidencial','no','no'),(47,6,200,'yes','yes',5,'presidencial','no','no'),(48,6,200,'yes','yes',5,'presidencial','no','no'),(49,6,140,'yes','yes',3,'commum','no','no'),(50,6,140,'yes','yes',3,'commum','no','no'),(51,6,140,'yes','yes',3,'commum','no','no'),(52,6,140,'yes','yes',3,'commum','no','no'),(53,6,140,'yes','yes',3,'commum','no','no'),(54,6,140,'yes','yes',3,'commum','no','no'),(55,6,140,'yes','yes',3,'commum','no','no'),(56,6,140,'yes','yes',3,'commum','no','no'),(57,6,180,'yes','yes',4,'master','no','yes'),(58,6,180,'yes','yes',4,'master','no','no'),(59,6,180,'yes','yes',4,'master','no','no'),(60,6,180,'yes','yes',4,'master','no','no'),(61,6,180,'yes','yes',4,'master','no','no'),(62,6,180,'yes','yes',4,'master','no','no');
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
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `cafe` enum('yes','no') DEFAULT 'no',
  PRIMARY KEY (`reserva_id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `quarto_id` (`quarto_id`),
  CONSTRAINT `reservas_tb_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes_tb` (`cliente_id`),
  CONSTRAINT `reservas_tb_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis_tb` (`hotel_id`),
  CONSTRAINT `reservas_tb_ibfk_3` FOREIGN KEY (`quarto_id`) REFERENCES `quartos_tb` (`quarto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=536 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_tb`
--

LOCK TABLES `reservas_tb` WRITE;
/*!40000 ALTER TABLE `reservas_tb` DISABLE KEYS */;
INSERT INTO `reservas_tb` VALUES (1,4,23,1,'2011-10-12','2011-10-15','yes'),(2,4,24,1,'2011-10-12','2011-10-15','yes'),(3,4,25,1,'2011-10-12','2011-10-15','yes'),(4,4,26,1,'2011-10-12','2011-10-15','yes'),(5,4,27,1,'2011-10-12','2011-10-15','yes'),(6,4,28,5,'2011-10-12','2011-10-15','yes'),(7,4,29,6,'2011-10-12','2011-10-15','yes'),(8,4,30,7,'2011-10-12','2011-10-15','yes'),(9,4,31,2,'2011-11-12','2011-11-15','yes'),(10,4,32,3,'2011-11-12','2011-11-15','yes'),(11,4,33,4,'2011-11-12','2011-11-15','yes'),(12,5,34,33,'2011-11-12','2011-11-15','yes'),(13,5,35,34,'2011-11-12','2011-11-15','yes'),(14,5,36,35,'2011-11-12','2011-11-15','yes'),(15,5,37,36,'2011-11-12','2011-11-15','yes'),(16,5,38,37,'2011-11-12','2011-11-15','yes'),(17,5,39,38,'2011-11-12','2011-11-15','yes'),(534,6,40,57,'2011-10-12','2011-10-15','no'),(535,6,41,39,'2011-11-16','2011-11-20','yes');
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

-- Dump completed on 2011-11-16 19:51:50
