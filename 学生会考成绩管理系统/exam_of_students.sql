-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: exam_of_students
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `information_of_administration`
--

DROP TABLE IF EXISTS `information_of_administration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `information_of_administration` (
  `id` varchar(4) NOT NULL,
  `name` varchar(32) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information_of_administration`
--

LOCK TABLES `information_of_administration` WRITE;
/*!40000 ALTER TABLE `information_of_administration` DISABLE KEYS */;
INSERT INTO `information_of_administration` VALUES ('100','张三','5201314'),('101','李四','123456'),('102','王二','654321'),('103','麻子','54086'),('104','大壮','666666'),('105','翠花','888888');
/*!40000 ALTER TABLE `information_of_administration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `information_of_grade`
--

DROP TABLE IF EXISTS `information_of_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `information_of_grade` (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '﻿考生号',
  `geography` varchar(20) NOT NULL,
  `chemistry` varchar(20) NOT NULL,
  `IT` varchar(20) NOT NULL,
  `history` varchar(20) NOT NULL,
  `biology` varchar(20) NOT NULL,
  `mathematics` varchar(20) NOT NULL,
  `general_technique` varchar(20) NOT NULL,
  `physics` varchar(20) NOT NULL,
  `english` varchar(20) NOT NULL,
  `chinese` varchar(20) NOT NULL,
  `politics` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information_of_grade`
--

LOCK TABLES `information_of_grade` WRITE;
/*!40000 ALTER TABLE `information_of_grade` DISABLE KEYS */;
INSERT INTO `information_of_grade` VALUES ('194023010170','132','129','113','63','130','112','100','62','32','100','103'),('194023010410','114','128','78','101','86','98','116','56','114','109','85'),('194023010650','124','105','98','94','104','129','120','134','130','104','103'),('194023010721','81','120','97','72','136','110','105','58','62','98','94'),('194023010730','96','117','107','88','140','64','109','125','105','105','79'),('194023010894','66','116','69','106','140','122','108','64','79','98','106'),('194023010990','119','111','97','101','106','130','115','99','78','109','99'),('194023011041','123','143','125','65','102','133','102','60','42','103','96'),('194023011148','114','102','84','122','75','131','116','94','46','109','110'),('194023011173','75','107','117','82','83','122','111','92','138','122','112');
/*!40000 ALTER TABLE `information_of_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `information_of_students`
--

DROP TABLE IF EXISTS `information_of_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `information_of_students` (
  `id` varchar(20) NOT NULL,
  `pwd` char(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information_of_students`
--

LOCK TABLES `information_of_students` WRITE;
/*!40000 ALTER TABLE `information_of_students` DISABLE KEYS */;
INSERT INTO `information_of_students` VALUES ('194023010170','666666'),('194023010410','000000'),('194023010650','000000'),('194023010721','000000'),('194023010730','000000'),('194023010894','000000'),('194023010990','000000'),('194023011041','000000'),('194023011148','000000'),('194023011173','000000'),('﻿考生号','密码');
/*!40000 ALTER TABLE `information_of_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'exam_of_students'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-01 21:13:09
