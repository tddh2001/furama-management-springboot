-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: furamaresort
-- ------------------------------------------------------
-- Server version	8.0.25

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
  `customer_id` varchar(50) NOT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_birthday` datetime(6) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customeridcard` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK1lt23ie2trgs1r42hqyhliedv` (`gender_id`),
  KEY `FKn8vf9jf3m29plqn6rx45p2pl7` (`customer_type_id`),
  CONSTRAINT `FK1lt23ie2trgs1r42hqyhliedv` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`),
  CONSTRAINT `FKn8vf9jf3m29plqn6rx45p2pl7` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('KH-0001','Quảng Trị','2001-11-18 00:00:00.000000','ntdat@gmail.com','197385811','Nguyễn Tiến Đạt','0858158157',1,5),('KH-0002','Kon Tum','2001-12-18 00:00:00.000000','tvhdan@gmail.com','198765274','Trần Vũ Hồng Đan','0858158157',2,4),('KH-0003','Nghệ An','2001-05-22 00:00:00.000000','lhduc@gmail.com','197654376','Lê Hồng Đức','0858158157',1,5),('KH-0004','Quảng Trị','2001-10-17 00:00:00.000000','nqcuong@gmail.com','198765301','Nguyễn Quốc Cường','0858158157',1,1),('KH-0006','Quảng Nam','2021-10-31 00:00:00.000000','dsktt123@gmail.com','123456789','Dương Lê Hà','0912345665',1,1);
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

-- Dump completed on 2021-11-12 10:58:01
