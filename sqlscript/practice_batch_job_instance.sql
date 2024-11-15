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
-- Table structure for table `batch_job_instance`
--

DROP TABLE IF EXISTS `batch_job_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch_job_instance` (
  `JOB_INSTANCE_ID` bigint NOT NULL,
  `VERSION` bigint DEFAULT NULL,
  `JOB_NAME` varchar(100) NOT NULL,
  `JOB_KEY` varchar(32) NOT NULL,
  PRIMARY KEY (`JOB_INSTANCE_ID`),
  UNIQUE KEY `JOB_INST_UN` (`JOB_NAME`,`JOB_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_job_instance`
--

LOCK TABLES `batch_job_instance` WRITE;
/*!40000 ALTER TABLE `batch_job_instance` DISABLE KEYS */;
INSERT INTO `batch_job_instance` VALUES (1,0,'exportEmpJob','58606ca20c82560325ef8e72bd9ca387'),(2,0,'exportEmpJob','2d380ae19d0c252e459093c78db01f47'),(3,0,'exportEmpJob','23a308361ad7108f23900f94175fee39'),(4,0,'exportEmpJob','4da24df8cfb64790deba4489699682af'),(5,0,'exportEmpJob','c7178d5c58f80ef72045d86bc61f3060'),(6,0,'exportEmpJob','43366f5e9db9f84587d6633d6e1a777a'),(7,0,'exportEmpJob','c650f739fa094984646b70d4323702e6'),(8,0,'exportEmpJob','8f9df959b78a9b59798d46804e215719'),(9,0,'exportEmpJob','35a8b0fbffaad28bd0e2e892c7f52e43'),(10,0,'exportEmpJob','17721583c01ff817e676053a6a6b7887'),(11,0,'exportEmpJob','869f8403d8c63f9d932fadabfdedabfe'),(12,0,'exportEmpJob','18dc7850cad112430961feff51285c34'),(13,0,'exportEmpJob','698ce822a831b6f7fda7fad954c3d629'),(14,0,'exportEmpJob','b4688142df53a5c830bf4a3bb8d88529'),(15,0,'exportEmpJob','ddde672355a317da2fb7f64e059b5812'),(16,0,'exportEmpJob','536f4c410b91d8c706ba18542ed2b114'),(17,0,'exportEmpJob','fc15f5b58747914d63b8a36ad5b18656'),(18,0,'exportEmpJob','6985d875e90b373f528378fb4aea0d24'),(19,0,'exportEmpJob','8e4a2aebbf484a38338263a5e2e0d1aa'),(20,0,'exportEmpJob','60d73832b3aebeba9113551f97c41b70'),(21,0,'exportEmpJob','862bf68f4dad5e96748bf58c2444e1ff'),(22,0,'exportEmpJob','66379c675d3d598e9b69a3745344dbc4'),(23,0,'exportEmpJob','e4923c729a89076d19700f27f83955e2'),(24,0,'exportEmpJob','b459edf7b3b619246c6092116866247b'),(25,0,'exportEmpJob','40ac008d3faf7a2ac4e4483e50ef71ed'),(26,0,'exportEmpJob','3dddf999e0df1f1f66058b6c61406a3d'),(27,0,'exportEmpJob','e3800802530daefacda3e2d11836fb66'),(28,0,'exportEmpJob','46a4e17bae5ddb0a4eaa1ecbe169d8e1'),(29,0,'exportEmpJob','56992fbc2f65feeb7819d676df8e90ac');
/*!40000 ALTER TABLE `batch_job_instance` ENABLE KEYS */;
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
