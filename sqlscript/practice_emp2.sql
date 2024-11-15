CREATE DATABASE  IF NOT EXISTS `practice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `practice`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: practice
-- ------------------------------------------------------
-- Server version	8.4.3

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
-- Table structure for table `emp2`
--

DROP TABLE IF EXISTS `emp2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp2` (
  `empno` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` float DEFAULT NULL,
  `comm` float DEFAULT NULL,
  `deptno` int NOT NULL,
  PRIMARY KEY (`empno`),
  KEY `emp2_deptno_fk` (`deptno`),
  CONSTRAINT `emp2_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `dept2` (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp2`
--

LOCK TABLES `emp2` WRITE;
/*!40000 ALTER TABLE `emp2` DISABLE KEYS */;
INSERT INTO `emp2` VALUES (1,'king','president','1981-11-17',5000.5,0,10),(2,'blake','manager','1981-05-01',2850,0,30),(3,'clark','manager','1981-01-09',2450,0,10),(4,'jones','manager','1981-04-02',2975,0,20),(5,'martin','salesman','1981-09-28',1250,1400,30),(6,'allen','salesman','1981-02-02',1600,300,30),(7,'turner','salesman','1981-09-28',1500,0,30),(8,'james','clerk','1981-12-03',950,0,30),(9,'ward','salesman','1981-02-22',1250,500,30),(10,'ford','analyst','1981-12-03',3000,0,20),(11,'smith','clerk','1980-12-17',800,0,20),(12,'scott','analyst','1981-12-09',3000,0,20),(13,'adams','clerk','1983-01-12',1100,0,20),(14,'miller','clerk','1982-01-23',1300,0,10);
/*!40000 ALTER TABLE `emp2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-15 16:08:54
