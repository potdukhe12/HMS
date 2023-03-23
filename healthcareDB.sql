CREATE DATABASE  IF NOT EXISTS `healthcare` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `healthcare`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: healthcare
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `aname` varchar(45) NOT NULL,
  `mobno` varchar(10) NOT NULL,
  `uid` int NOT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `aname_UNIQUE` (`aname`),
  KEY `FK_ADMIN_USER_ID_idx` (`uid`),
  CONSTRAINT `FK_ADMIN_USER_ID` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (3,'Gaurav Urkude','9923876586',60),(4,'Saurabh Potdukhe','8275772711',61);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `apmtid` int NOT NULL AUTO_INCREMENT,
  `status` tinyint NOT NULL,
  `datetime` datetime NOT NULL,
  `treatid` int NOT NULL,
  `did` int NOT NULL,
  `pid` int NOT NULL,
  `hid` int NOT NULL,
  PRIMARY KEY (`apmtid`),
  KEY `FK_APMT_DOC_ID_idx` (`did`),
  KEY `FK_APMT_HOS_ID_idx` (`hid`),
  KEY `FK_APMT_PAT_ID_idx` (`pid`),
  KEY `FK_APMT_TREAT_ID_idx` (`treatid`),
  CONSTRAINT `FK_APMT_DOC_ID` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_APMT_HOS_ID` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_APMT_PAT_ID` FOREIGN KEY (`pid`) REFERENCES `patient` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_APMT_TREAT_ID` FOREIGN KEY (`treatid`) REFERENCES `treatment` (`treatid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,0,'2023-03-03 00:00:00',1,4,9,4),(2,0,'2023-03-04 00:00:00',2,7,10,5),(3,0,'2023-03-05 00:00:00',9,7,6,5),(4,0,'2023-03-04 00:00:00',4,8,7,5),(6,1,'2023-03-02 00:00:00',6,9,10,6),(7,0,'2023-03-05 00:00:00',9,7,6,5),(8,0,'2023-04-13 18:30:00',9,7,10,5),(9,0,'2023-03-17 21:47:00',1,4,10,4),(11,0,'2023-03-12 06:02:00',1,4,10,4),(12,0,'2023-03-12 08:10:00',1,4,10,4),(13,0,'2023-03-31 09:48:00',1,4,13,4),(14,0,'2023-03-30 08:01:00',2,7,13,5),(15,0,'2023-04-04 08:00:00',6,9,13,6),(16,0,'2023-05-22 10:03:00',3,6,13,6),(17,0,'2023-05-11 13:00:00',11,11,8,4);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `did` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `mobno` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `uid` int NOT NULL,
  `degree` varchar(45) NOT NULL,
  `experience` int NOT NULL,
  `specialization` varchar(45) NOT NULL,
  `status` tinyint NOT NULL,
  `hid` int NOT NULL,
  PRIMARY KEY (`did`),
  KEY `FK_USER_ID_idx` (`uid`),
  KEY `FK_HOS_ID_idx` (`hid`),
  CONSTRAINT `FK_DOC_USER_ID` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_HOS_ID` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (4,'Dr Neelam Sharma','1984-06-15 00:00:00','777 6485','Female',51,'MMBS',13,'Surgeon',1,4),(6,'Dr Manjula','1990-07-22','777 2164','Female',53,'MD',7,'Medicine',1,6),(7,'Dr Gandhi','1980-12-31','777 3487','Male',54,'BAMS',17,'Medicine and Surgeon',1,5),(8,'Dr Ajita','1983-03-01','777 2648','Female',55,'BHMS',14,'Homeopathic',1,5),(9,'Dr Das','1970-01-30','777 0148','Male',56,'BPT',27,'Physiotherapy',1,6),(11,'Dr. Yuvraj Sing','1985-01-29 05:30:00','7666777666','Male',98,'MBBS',15,'ENT',1,4);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `hisid` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `treatid` int NOT NULL,
  `apmtid` int NOT NULL,
  `hid` int NOT NULL,
  PRIMARY KEY (`hisid`),
  KEY `FK_HIS_PRE_ID_idx` (`hisid`),
  KEY `FK_HIS_APMT_ID_idx` (`apmtid`),
  KEY `FK_HIS_PAT_ID_idx` (`pid`),
  KEY `FK_HIS_TREAT_ID_idx` (`treatid`),
  KEY `FK_HIS_HOS_ID_idx` (`hid`),
  CONSTRAINT `FK_HIS_APMT_ID` FOREIGN KEY (`apmtid`) REFERENCES `appointment` (`apmtid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_HIS_HOS_ID` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_HIS_PAT_ID` FOREIGN KEY (`pid`) REFERENCES `patient` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_HIS_TREAT_ID` FOREIGN KEY (`treatid`) REFERENCES `treatment` (`treatid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,6,10000,4,4,5),(2,9,12000,1,1,4),(3,10,25000,2,2,5),(4,7,5000,4,4,5),(6,10,14000,6,6,6);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `hid` int NOT NULL AUTO_INCREMENT,
  `hname` varchar(45) NOT NULL,
  `teleno` varchar(45) NOT NULL,
  `status` tinyint NOT NULL,
  `uid` int NOT NULL,
  PRIMARY KEY (`hid`),
  UNIQUE KEY `teleno_UNIQUE` (`teleno`),
  UNIQUE KEY `hname_UNIQUE` (`hname`),
  KEY `FK_HOS_USER_ID_idx` (`uid`),
  CONSTRAINT `FK_HOS_USER_ID` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (4,'Apollo Spectra Hospital','222 2158',1,57),(5,'Noble Hospital','222 6941',1,58),(6,'Sancheti Hospital','222 1524',0,59);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medserv`
--

DROP TABLE IF EXISTS `medserv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medserv` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(45) NOT NULL,
  `hid` int NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `FK_MS_HOS_ID_idx` (`hid`),
  CONSTRAINT `FK_MS_HOS_ID` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medserv`
--

LOCK TABLES `medserv` WRITE;
/*!40000 ALTER TABLE `medserv` DISABLE KEYS */;
INSERT INTO `medserv` VALUES (20,'Sonography',4),(21,'MRI',4),(22,'Blood Test',4),(23,'X-Ray',4),(24,'Orthopedic',4),(25,'Endoscopy',4),(26,'Angiography',4),(27,'Angioplasty',4),(28,'Orthopedic',5),(29,'X-Ray',5),(30,'Blood Test',5),(31,'MRI',5),(32,'Orthopedic',6),(33,'X-Ray',6),(34,'Blood Test',6),(35,'Sonography',5),(36,'Angiography',6),(37,'Endoscopy',6),(38,'Angioplasty',6),(39,'Sonography',6);
/*!40000 ALTER TABLE `medserv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `mobno` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `uid` int NOT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `mobno_UNIQUE` (`mobno`),
  KEY `FK_PAT_USER_ID_idx` (`uid`),
  CONSTRAINT `FK_PAT_USER_ID` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (6,'Daksh','1990-02-20','555 3156','Male',46),(7,'Saanvi','1992-04-10','555 1566','Female',47),(8,'Aahan','1996-05-13','555 3561','Male',48),(9,'Parth','1990-03-26','555 5461','Male',49),(10,'Radha','1998-11-14','555 8657','Female',50),(12,'Utkarsh Potdukhe','2000-04-16','7774448888','Male',76),(13,'Utkarsh P2','2022-08-10','3339995454','Male',77);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `prescid` int NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `pid` int NOT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`prescid`),
  KEY `FK_PRE_PAT_ID` (`pid`),
  KEY `FK_PRE_DOC_ID_idx` (`did`),
  CONSTRAINT `FK_PRE_DOC_ID` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PRE_PAT_ID` FOREIGN KEY (`pid`) REFERENCES `patient` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'aspirin',9,4),(2,'morphine',10,7),(3,'small pox vaccine',6,6),(4,'insulin',7,8),(6,'paracetomol',10,9);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `treatid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(45) NOT NULL,
  `did` int NOT NULL,
  `hid` int NOT NULL,
  PRIMARY KEY (`treatid`),
  KEY `FK_TREAT_DOC_ID_idx` (`did`),
  KEY `FK_TREAT_HOS_ID_idx` (`hid`),
  CONSTRAINT `FK_TREAT_DOC_ID` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TREAT_HOS_ID` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (1,'Radiation Therapy',4,4),(2,'Surgery',7,5),(3,'Psycho Therapy',6,6),(4,'Immuno Therapy',8,5),(6,'MRI',9,6),(7,'PET Scan',7,5),(8,'Eye Surgery',9,6),(9,'Endoscopy',8,5),(10,'Dialysis',4,4),(11,'ENT',11,4);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `pwd` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `uname` varchar(45) NOT NULL,
  `address` longtext,
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `uname_UNIQUE` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (46,'slJOeX1EVppbbzpqJK+3uvy5yNggzXOKgFw1zch0EQc=','patient1@gmail.com','Patient@1','Pune','1'),(47,'PZvf4Px870NVUdvDlbr6Y2n4rI7ekuxIGXH00yqWDZo=','patient2@gmail.com','Patient@2','Pune','1'),(48,'ckugxjBRg6uGEsG2x93rsP9pdxccbyEV5looDMjKWT0=','patient3@gmail.com','Patient@3','Satara','1'),(49,'v/lXK+atpA6gkP5jvtD29nJU62lZypeRcdC9T0YJMCk=','patient4@gmail.com','Patient@4','Washim','1'),(50,'VK3kHy2WQ549UREvdLvIRn6ANI6LVDIS86LpntyCg88=','patient5@gmail.com','Patient@5','Kolhapur','1'),(51,'tQZlqnDYh3gEpyDjTx8qXPD4afnfvZgvfzIuT/g0EcE=','Doctor1@gmail.com','Doctor@1','Amravati','2'),(53,'uNFExvPM4QXV6rSVt724Mhmq8Ryv9W9vMKoZsqyFIvc=','doctor3@gmail.com','Doctor@3','Chandrapur','2'),(54,'zgf+TvxGof4j/tNltLVQ/v88khRLbD9LrQpwqs30c78=','doctor4@gmail.com','Doctor@4','Nagpur','2'),(55,'4UCQZKU5HHbreANUobrnb96XTkqS7Wc1LbyUqkPUwY0=','doctor5@gmail.com','Doctor@5','Buttibori','2'),(56,'A/7HkKXNn0VQ/c2D2B3dGLaJC9sBCXcxUQa+VJwmWqU=','doctor6@gmail.com','Doctor@6','Hyderabad','2'),(57,'sJ1MpIqYBreUxpknl/Zc+RlMwiYwqWcmnSbzAfGpD6g=','hospital1@gmail.com','Hospital@1','Karvenagar, Pune','3'),(58,'L2pzhVEWzBDI0Tm5WX7BUCDDcIY/cghOt2etcZrpCPE=','hospital2@gmail.com','Hospital@2','Baner, Pune','3'),(59,'SkUe4l3tARcaiepDo22V/g5f1edYKZ3YM9HBbflp9TM=','hospita3@gmail.com','Hospital@3','Hinjewadi, Pune','3'),(60,'HdRTnIcgUM/2EVWmFLrX8tx3ZJCE3kj2/IXUM+x/u2A=','admin1@gmail.com','Admin@1','Wani','4'),(61,'3mAfd9OQcfjNdhhoK3uUymyG7VTc/xeD4L7KmAgVEzs=','admin2@gmail.com','Admin@2','Sundarnagar','4'),(76,'rkxd1dDVonQpOPZ2d9Jrdqv2NAQRmg6wBXwp2sTvRro=','Utkarsh@gmail.in','Utkarsh@1','Wani','1'),(77,'MuL+tYjEiDaIDFOaB018p2lL1PKAnZTtnFAIldBgRBQ=','Utkarsh@2mail.com','Utkarsh@2','Wani','1'),(98,'1EMfHODC9WK5EPZ2dJYnC3B8QmoeN7/jPFQQtxoLZu4=','Doctor7@gmail.in','Doctor@7','Nashik','2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-23 12:45:48
