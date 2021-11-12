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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_birthday` datetime(6) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employeeidcard` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone` varchar(255) DEFAULT NULL,
  `employee_salary` double NOT NULL,
  `division_id` int DEFAULT NULL,
  `education_degree_id` int DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKoxlp1b4xvwyjgb7hh4wd54jy4` (`division_id`),
  KEY `FKs4qy1cue6wal9e4pq9wjuau5w` (`education_degree_id`),
  KEY `FKe0w26qjedr99vwno4pqauw9i9` (`gender_id`),
  KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`),
  KEY `FK6xssc5111669b17m97qxsm2r` (`username`),
  CONSTRAINT `FK6xssc5111669b17m97qxsm2r` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `FKe0w26qjedr99vwno4pqauw9i9` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`),
  CONSTRAINT `FKoxlp1b4xvwyjgb7hh4wd54jy4` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`),
  CONSTRAINT `FKs4qy1cue6wal9e4pq9wjuau5w` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`education_degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Quang Tri','1999-11-11 00:00:00.000000','dsktt@gmail.com','197385811','dat','0858158157',10,4,4,1,1,NULL),(2,'Quang Tri','1999-11-11 00:00:00.000000','dsktt@gmail.com','197375723','Dan','0858158157',10,1,2,2,6,NULL),(3,'Quang Tri','1999-11-11 00:00:00.000000','dsktt@gmail.com','197385811','Cuong','0858158154',10,2,3,2,4,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-12 10:58:00
