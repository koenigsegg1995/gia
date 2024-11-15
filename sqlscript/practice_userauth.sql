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
-- Table structure for table `userauth`
--

DROP TABLE IF EXISTS `userauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userauth` (
  `empno` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `fk_empno_userAuth_emp2` FOREIGN KEY (`empno`) REFERENCES `emp2` (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauth`
--

LOCK TABLES `userauth` WRITE;
/*!40000 ALTER TABLE `userauth` DISABLE KEYS */;
INSERT INTO `userauth` VALUES (1,'king','$2a$10$zq5KxJn8xtQ3wUjXn0Pv5.mUIx2InhowHwj8D54G0Cu3TsLAaKhx6','ADMIN'),(2,'blake','$2a$10$oS3tkqpygu.M01Hg5vKc.eH01aqa7zkcWsOAC8Z2ZxUNHZjLuB2OG','MANAGER'),(3,'clark','$2a$10$Ad995bnrvNw9Z1b/68l.JeRzxZxBVoGBnz0ZJ93lgEczcj0gdB0ba','MANAGER'),(4,'jones','$2a$10$iFQFdm1zSrTGd5wpgR.B9..Ucw/YymJIacaG5MpX0QvBV2/6KfQxe','MANAGER'),(5,'martin','$2a$10$g/wc3NF8ZvtXxaccY1gt1.g9GfIpDbm7ZmpvxO3bH4aZ3uTKXuXZ.','USER'),(6,'allen','$2a$10$bUj.x.9gFUxVLmbTN8LEu.1aOMoAb1k93x3QyFwKqcsJch76NXXFe','USER'),(7,'turner','$2a$10$7/LLnMfRi8ZWoO7ZnSqIOeCnSZJyxF9jE7zgbb5.RI9L0VzuaPqtq','USER'),(8,'james','$2a$10$QCpPnTO6qRl/u4eTwpXl/.JLKY6byUFe9jLJWBpLOCv/dt682rnPK','USER'),(9,'ward','$2a$10$lPNSAUu93IlhWpuEKKKJJ.vTS0H26HeeIKzVvKIN7yEinT5xSQwAy','USER'),(10,'ford','$2a$10$ZuvX1axs84nrw0LfqawG/.a8g7M8LQii..QYj.L1wtLI7JgTbNef6','USER'),(11,'smith','$2a$10$q4Sj5oBG9KpIvrGNuy7YmOaWcsUhdHAYMi4Xpil0Os3c2j9s9XdYW','USER'),(12,'scott','$2a$10$XGR9jxRZzcga1/l1KW/T7OIlApXDdxgMv67.CPt4r.I0WbLgCiHI6','USER'),(13,'adams','$2a$10$Eam0l4M.y/U0BGW5Ua8MKu/V3/d.zsdB3mRlJwMspZm9yr8.kQ2cC','USER'),(14,'miller','$2a$10$ZQvAfNpykMFte82MzIoGMeWs2Wn6ji7R7SMlUznI2xTvSajzgDh8C','USER');
/*!40000 ALTER TABLE `userauth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-15 16:08:51
