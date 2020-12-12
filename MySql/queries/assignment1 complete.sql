CREATE DATABASE  IF NOT EXISTS `assignment1b_tzivanis` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `assignment1b_tzivanis`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment1b_tzivanis
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `assignment_briefings`
--

DROP TABLE IF EXISTS `assignment_briefings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment_briefings` (
  `assignment_brief_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `description` text,
  `max_oral_mark` int DEFAULT NULL,
  `max_total_mark` int DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `is_group_project` tinyint DEFAULT '0',
  PRIMARY KEY (`assignment_brief_id`),
  KEY `course_id_fk_idx` (`course_id`),
  CONSTRAINT `assignment_briefings_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment_briefings`
--

LOCK TABLES `assignment_briefings` WRITE;
/*!40000 ALTER TABLE `assignment_briefings` DISABLE KEYS */;
INSERT INTO `assignment_briefings` VALUES (21,'Java assignment','Java basics assignmment, bla bla',50,100,'2020-01-25 23:59:00',2,0),(22,'Java group assignment','Java web assignmment, ..group by 2..',50,100,'2020-03-25 23:59:00',2,1),(23,'Final assignment','No small assignments, group up and make a webapp!',50,100,'2020-03-25 23:59:00',3,1),(24,'C# assignment','C#, la minore, fake java, bla bla',15,50,'2020-03-25 23:59:00',4,0),(25,'Final project','Web app in c#, glhf, crud bla bla',40,100,'2020-05-10 23:59:00',4,1),(26,'Frontend','Web landing page, blabla blalba blabal',50,100,'2020-04-13 23:59:00',5,1),(27,'RDBM','Databases blabla blalba blabal',50,100,'2020-05-13 23:59:00',5,0),(28,'Final project','Final group project blabla blalba blabal',50,100,'2020-08-11 23:59:00',5,1);
/*!40000 ALTER TABLE `assignment_briefings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignment_submissions`
--

DROP TABLE IF EXISTS `assignment_submissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment_submissions` (
  `assignment_submission_id` int NOT NULL AUTO_INCREMENT,
  `oral_mark` int DEFAULT NULL,
  `total_mark` int DEFAULT NULL,
  `submission_date` datetime DEFAULT NULL,
  `assignment_brief_id` int DEFAULT NULL,
  PRIMARY KEY (`assignment_submission_id`),
  KEY `assignment_brief_fk_idx` (`assignment_brief_id`),
  CONSTRAINT `assignment_submissions_fk1` FOREIGN KEY (`assignment_brief_id`) REFERENCES `assignment_briefings` (`assignment_brief_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment_submissions`
--

LOCK TABLES `assignment_submissions` WRITE;
/*!40000 ALTER TABLE `assignment_submissions` DISABLE KEYS */;
INSERT INTO `assignment_submissions` VALUES (3,20,60,'2020-01-23 15:15:00',21),(4,30,70,'2020-01-26 17:15:00',21),(5,45,90,'2020-01-22 16:15:00',21),(6,30,80,'2020-03-20 18:18:00',22),(7,40,60,'2020-03-26 19:18:00',22),(8,45,95,'2020-03-22 19:18:00',23),(9,12,35,'2020-03-23 03:18:00',23),(10,21,22,'2020-03-28 16:18:00',23),(11,9,35,'2020-03-15 11:18:00',24),(12,8,44,'2020-03-16 12:18:00',24),(13,7,10,'2020-03-29 10:18:00',24),(14,5,40,'2020-03-24 13:18:00',24),(15,30,88,'2020-05-09 12:18:00',25),(16,16,71,'2020-05-12 17:18:00',25),(17,33,85,'2020-04-09 12:18:00',26),(18,44,75,'2020-05-01 18:18:00',26),(19,22,92,'2020-04-11 15:18:00',26),(20,32,45,'2020-05-09 12:18:00',27),(21,33,96,'2020-05-15 19:18:00',27),(22,22,45,'2020-05-16 09:18:00',27),(23,12,86,'2020-08-16 09:18:00',28),(24,50,78,'2020-08-08 09:18:00',28);
/*!40000 ALTER TABLE `assignment_submissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `stream_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `stream_id_fk_idx` (`stream_id`),
  KEY `type_id_fk_idx` (`type_id`),
  CONSTRAINT `courses_fk1` FOREIGN KEY (`stream_id`) REFERENCES `streams` (`stream_id`),
  CONSTRAINT `courses_fk2` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (2,'CB12',1,1,'2020-01-05','2020-04-05'),(3,'CB12',1,2,'2020-01-05','2020-07-05'),(4,'CB12',2,1,'2020-02-10','2020-05-15'),(5,'CB12',2,2,'2020-02-10','2020-08-15'),(6,'CB13',3,2,'2020-09-10','2020-03-25');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `streams`
--

DROP TABLE IF EXISTS `streams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `streams` (
  `stream_id` int NOT NULL AUTO_INCREMENT,
  `stream` varchar(20) NOT NULL,
  PRIMARY KEY (`stream_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `streams`
--

LOCK TABLES `streams` WRITE;
/*!40000 ALTER TABLE `streams` DISABLE KEYS */;
INSERT INTO `streams` VALUES (1,'Java'),(2,'C#'),(3,'Python'),(4,'Js');
/*!40000 ALTER TABLE `streams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `tuition_fees` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Rae','Alvaro','1974-07-30',9121.57),(2,'Lindsey','Carruth','1973-12-03',4595.93),(3,'Zach','Postans','1972-09-15',8675.58),(4,'Alano','Kaley','1979-01-07',3322.58),(5,'See','Howling','1994-02-13',6335.51),(6,'Jordan','Barwack','1986-03-31',3087.32),(7,'Idell','Kestin','1978-06-10',3614.35),(8,'Adan','Ivatts','1978-07-06',9212.81),(9,'Eilis','Kloster','1973-04-12',1759.68),(10,'Dayle','Spring','1977-01-12',3178.30),(11,'Sanford','Charrier','1990-07-30',2709.29),(12,'Tamar','Randlesome','1979-05-28',5292.31),(13,'Heather','Kimmitt','1982-09-01',3381.15),(14,'Babbie','Gyppes','1996-05-08',6850.88),(15,'Erma','Houlson','1988-03-23',1110.46),(16,'Alphonse','Brokenshire','1983-04-23',8416.11),(17,'Guillaume','Janak','1993-07-30',8711.27),(18,'Mirabel','Lochrie','1999-03-16',5569.81),(19,'Doralia','Thurlbeck','1997-12-23',7334.12),(20,'Morgun','Shipp','1972-10-15',4924.57),(21,'Symon','Meek','1992-01-05',9191.73),(22,'Jervis','Joul','1988-05-07',2285.18),(23,'Antonie','Behrens','1984-12-05',1721.30),(24,'Ricoriki','Veasey','1985-08-12',2368.71),(25,'Fionnula','Creany','1974-02-14',4122.72),(26,'Susie','Woolward','1978-09-02',8502.41),(27,'Dylan','Herrema','1995-05-09',7431.31),(28,'Jermaine','Weekland','1984-09-08',4132.81),(29,'Abie','Fonzo','1982-07-19',3213.17),(30,'Leanor','Billin','1971-03-07',8999.12);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_assignment_submissions`
--

DROP TABLE IF EXISTS `students_assignment_submissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_assignment_submissions` (
  `student_id` int NOT NULL,
  `assignment_submission_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`assignment_submission_id`),
  KEY `assignment_submission_id_fk_idx` (`assignment_submission_id`),
  CONSTRAINT `students_assignment_submissions_fk1` FOREIGN KEY (`assignment_submission_id`) REFERENCES `assignment_submissions` (`assignment_submission_id`),
  CONSTRAINT `students_assignment_submissions_fk2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_assignment_submissions`
--

LOCK TABLES `students_assignment_submissions` WRITE;
/*!40000 ALTER TABLE `students_assignment_submissions` DISABLE KEYS */;
INSERT INTO `students_assignment_submissions` VALUES (1,3),(2,4),(3,5),(1,6),(2,6),(3,6),(4,7),(5,7),(6,7),(8,8),(9,8),(10,9),(11,9),(12,10),(13,10),(1,11),(2,12),(16,13),(18,14),(15,15),(16,15),(17,15),(1,16),(20,16),(21,16),(22,17),(23,17),(24,18),(25,18),(1,19),(26,19),(23,20),(24,21),(25,22),(22,23),(25,23),(1,24),(24,24);
/*!40000 ALTER TABLE `students_assignment_submissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_courses`
--

DROP TABLE IF EXISTS `students_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_courses` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `course_id_fk_idx` (`course_id`),
  CONSTRAINT `students_courses_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `students_courses_fk2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_courses`
--

LOCK TABLES `students_courses` WRITE;
/*!40000 ALTER TABLE `students_courses` DISABLE KEYS */;
INSERT INTO `students_courses` VALUES (1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(22,3),(1,4),(2,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(21,4),(1,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5);
/*!40000 ALTER TABLE `students_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject` varchar(20) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Java'),(2,'C#'),(3,'JS'),(4,'MySql'),(5,'Html'),(6,'CSS'),(7,'Python');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`trainer_id`),
  KEY `trainers_fk1_idx` (`subject_id`),
  CONSTRAINT `trainers_fk1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (23,'Amalita','Marson',1),(24,'Mala','Bedo',1),(25,'Allys','Merryman',2),(26,'Neila','Vass',2),(27,'Yardley','Vasilischev',4),(28,'Gloriane','Menlove',4),(29,'Howard','Mabb',5),(30,'Robinett','Filyashin',6),(31,'Art','McBrearty',7),(32,'Nico','Whettleton',4),(33,'Cassie','Bissill',5),(34,'Georgeta','Torresi',6);
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers_courses`
--

DROP TABLE IF EXISTS `trainers_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers_courses` (
  `trainer_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`trainer_id`,`course_id`),
  KEY `trainers_courses_fk1_idx` (`course_id`),
  CONSTRAINT `trainers_courses_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `trainers_courses_fk2` FOREIGN KEY (`trainer_id`) REFERENCES `trainers` (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers_courses`
--

LOCK TABLES `trainers_courses` WRITE;
/*!40000 ALTER TABLE `trainers_courses` DISABLE KEYS */;
INSERT INTO `trainers_courses` VALUES (23,2),(27,2),(29,2),(30,2),(24,3),(28,3),(29,3),(34,3),(25,4),(32,4),(33,4),(34,4),(26,5),(28,5),(29,5),(31,6),(33,6),(34,6);
/*!40000 ALTER TABLE `trainers_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Full Time'),(2,'Part Time');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07 15:47:18
