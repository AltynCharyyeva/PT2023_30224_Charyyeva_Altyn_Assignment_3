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
-- Table structure for table `orderedproduct`
--

DROP TABLE IF EXISTS `orderedproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderedproduct` (
  `orderId` int NOT NULL,
  `productId` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`orderId`,`productId`),
  KEY `productId` (`productId`),
  CONSTRAINT `orderedproduct_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderedproduct_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderedproduct`
--

LOCK TABLES `orderedproduct` WRITE;
/*!40000 ALTER TABLE `orderedproduct` DISABLE KEYS */;
INSERT INTO `orderedproduct` VALUES (1,5,1),(2,3,2),(3,4,1),(4,2,2),(5,6,3),(6,7,8),(7,7,1),(8,9,4),(9,10,3),(10,7,8),(11,2,4),(12,18,1),(13,20,1),(14,21,1),(15,16,1),(16,17,10),(17,18,1),(18,12,1),(19,3,1),(20,3,3),(21,4,2),(22,5,2),(23,5,2),(24,7,3),(25,7,3),(26,8,2),(27,8,1),(28,15,1),(29,15,1),(30,15,2),(31,14,1),(32,14,1),(33,14,5),(34,3,2),(34,11,2),(35,11,1),(36,11,1),(37,11,2),(38,10,1),(39,5,2),(40,5,1),(41,5,3),(48,13,10),(49,11,3),(50,18,1),(51,18,1),(52,2,4),(53,1,1),(54,9,50);
/*!40000 ALTER TABLE `orderedproduct` ENABLE KEYS */;
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
