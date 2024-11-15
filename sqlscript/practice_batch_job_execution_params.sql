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
-- Table structure for table `batch_job_execution_params`
--

DROP TABLE IF EXISTS `batch_job_execution_params`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch_job_execution_params` (
  `JOB_EXECUTION_ID` bigint NOT NULL,
  `PARAMETER_NAME` varchar(100) NOT NULL,
  `PARAMETER_TYPE` varchar(100) NOT NULL,
  `PARAMETER_VALUE` varchar(2500) DEFAULT NULL,
  `IDENTIFYING` char(1) NOT NULL,
  KEY `JOB_EXEC_PARAMS_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_PARAMS_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_job_execution_params`
--

LOCK TABLES `batch_job_execution_params` WRITE;
/*!40000 ALTER TABLE `batch_job_execution_params` DISABLE KEYS */;
INSERT INTO `batch_job_execution_params` VALUES (1,'time','java.lang.Long','1731404673786','Y'),(2,'time','java.lang.Long','1731404796932','Y'),(3,'time','java.lang.Long','1731404915291','Y'),(4,'time','java.lang.Long','1731405256204','Y'),(5,'time','java.lang.Long','1731405272695','Y'),(6,'time','java.lang.Long','1731405370926','Y'),(7,'time','java.lang.Long','1731408370009','Y'),(8,'time','java.lang.Long','1731408377951','Y'),(9,'time','java.lang.Long','1731408450563','Y'),(10,'time','java.lang.Long','1731469833544','Y'),(11,'time','java.lang.Long','1731490024607','Y'),(12,'time','java.lang.Long','1731490039495','Y'),(13,'time','java.lang.Long','1731490128658','Y'),(14,'time','java.lang.Long','1731490138316','Y'),(15,'time','java.lang.Long','1731492302642','Y'),(16,'time','java.lang.Long','1731492438757','Y'),(17,'time','java.lang.Long','1731492444913','Y'),(18,'time','java.lang.Long','1731544373024','Y'),(19,'time','java.lang.Long','1731544379567','Y'),(20,'time','java.lang.Long','1731544503111','Y'),(21,'time','java.lang.Long','1731544709944','Y'),(22,'time','java.lang.Long','1731565255740','Y'),(23,'time','java.lang.Long','1731638046323','Y'),(24,'time','java.lang.Long','1731638083348','Y'),(25,'time','java.lang.Long','1731638887343','Y'),(26,'time','java.lang.Long','1731650876578','Y'),(27,'time','java.lang.Long','1731652803569','Y'),(28,'time','java.lang.Long','1731655534111','Y'),(29,'time','java.lang.Long','1731656541185','Y');
/*!40000 ALTER TABLE `batch_job_execution_params` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-15 16:08:52
