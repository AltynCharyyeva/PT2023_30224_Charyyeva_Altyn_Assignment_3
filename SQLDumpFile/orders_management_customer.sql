-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: orders_management
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(50) DEFAULT NULL,
  `customerMail` varchar(50) DEFAULT NULL,
  `customerAddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'A. Anderson','anderson1@gmail.com','Rome'),(2,'Sw.Bob','brown@gmial.com','San-Francisco'),(3,'C. Cole','colecole43@gmail.com','Barcelona'),(4,'D. Doe','dwdoe@gmail.com','Hong Kong'),(5,'E. Elliott','elli1234we@yahoo.com','Edinburgh'),(6,'F. Ford','fordFB@yahoo.com','Seattle'),(7,'G. Grimmer','grimmm@gamil.com','Los-Angeles'),(8,'H. Hoover','hoo909@gmail.com','Milan'),(9,'I. Irving','irvingMane@yahoo.com','Bucharest'),(10,'J. Jordan','jordanjori@gmail.com','Beijing'),(11,'K. Kurtz','kurtzUniverse@gmail.com','Budapest'),(12,'L. Lamb','lollyLira@yahoo.com','Budapest'),(13,'M. Miller','millerMary@gamil.com','Franfurt'),(14,'N. Norris','norrineslon12@yahoo.com','Munich'),(15,'O. Olsen','OlsiKetty23@gmail.com','Oslo'),(16,'P. Pitt','larapitttt@gmail.com','Los-Angeles'),(17,'Q. Quirrel','quirrelken@gmail.com','Washington'),(18,'Steve Raet','steveraet676@gmail.com','Liverpool'),(19,'Fred Smith','smithfree@gmail.com','London'),(20,'T. Thomas','thomasmichael3@gmail.com','London'),(21,'U. Underwood','underwood999@gmail.com','London'),(22,'V. Voss','voss2020@yahoo.com','Muncih'),(23,'W. Williams','willywilliams@yahoo.com','Munich'),(24,'X. Xu','xuxiu7890@yahoo.com','Tokio'),(25,'Y. Yoder','yodermolo@gmail.com','Tokio'),(26,'Z. Zimmerman','zimmiman@yahoo.com','Honh Kong'),(30,'dummyDummy','adresaadr@gmail.com','Bucharest'),(31,'Charyyeva','charyyeva@gmail.com','Mary'),(32,'Charles Wisdom ','charleswww23@gmail.com','Cluj-Napoca'),(33,'Maria','maria@gmaol.com','Turda'),(34,'Maria Molodovan','mariamoldovan@gmail.com','Cluj-Napoca');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 23:05:28
