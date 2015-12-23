-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketreservation2
-- ------------------------------------------------------
-- Server version	5.6.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) NOT NULL,
  `release_date` date DEFAULT NULL,
  `no_of_shows` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `active` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`movie_id`,`movie_name`),
  UNIQUE KEY `movie_name_UNIQUE` (`movie_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'villu','2015-01-01',4,'2015-12-06 09:57:21','2015-12-07 08:07:44','yes','admin','admin'),(2,'mkumaran','2016-01-01',2,'2015-12-06 10:11:01','2015-12-07 04:51:48','yes','admin','admin'),(3,'suriyavamsam','2016-02-07',3,'2015-12-06 10:11:57','2015-12-07 04:52:29','yes','admin','admin'),(4,'sakthi','2016-01-16',4,'2015-12-23 03:55:17','2015-12-23 03:55:17','yes','admin','admin');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_list_has_timings`
--

DROP TABLE IF EXISTS `movies_list_has_timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies_list_has_timings` (
  `movie_id` int(11) NOT NULL,
  `timings_id` int(11) NOT NULL,
  PRIMARY KEY (`movie_id`,`timings_id`),
  KEY `fk_movies_list_has_timings_timings1_idx` (`timings_id`),
  KEY `fk_movies_list_has_timings_movies_list1_idx` (`movie_id`),
  CONSTRAINT `fk_movies_list_has_timings_movies_list1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_list_has_timings_timings1` FOREIGN KEY (`timings_id`) REFERENCES `timings` (`timings_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_list_has_timings`
--

LOCK TABLES `movies_list_has_timings` WRITE;
/*!40000 ALTER TABLE `movies_list_has_timings` DISABLE KEYS */;
INSERT INTO `movies_list_has_timings` VALUES (1,1),(2,1),(3,1),(4,1),(1,2),(2,2),(3,2),(4,2),(1,3),(3,3),(4,3),(1,4),(4,4);
/*!40000 ALTER TABLE `movies_list_has_timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `reservation_count` int(11) NOT NULL DEFAULT '1',
  `reservation_date` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `reservation_status` int(11) NOT NULL,
  `reserved_by` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `timings_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `fk_reservation_reservation_status1_idx` (`reservation_status`),
  KEY `fk_reservation_user1_idx` (`reserved_by`),
  KEY `fk_reservation_movie1_idx` (`movie_id`),
  KEY `fk_reservation_timings1_idx` (`timings_id`),
  CONSTRAINT `fk_reservation_movie1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_reservation_status1` FOREIGN KEY (`reservation_status`) REFERENCES `reservation_status` (`reservation_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_timings1` FOREIGN KEY (`timings_id`) REFERENCES `timings` (`timings_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_user1` FOREIGN KEY (`reserved_by`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_status`
--

DROP TABLE IF EXISTS `reservation_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_status` (
  `reservation_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `reservation_status` varchar(45) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reservation_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_status`
--

LOCK TABLES `reservation_status` WRITE;
/*!40000 ALTER TABLE `reservation_status` DISABLE KEYS */;
INSERT INTO `reservation_status` VALUES (1,'Booked','2015-12-06 09:35:49','2015-12-06 09:35:49','admin','admin'),(2,'Cancelled','2015-12-06 09:35:49','2015-12-06 09:35:49','admin','admin');
/*!40000 ALTER TABLE `reservation_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserved_seat`
--

DROP TABLE IF EXISTS `reserved_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserved_seat` (
  `reserved_seat_id` int(11) NOT NULL AUTO_INCREMENT,
  `reserved_seat_no` varchar(45) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  PRIMARY KEY (`reserved_seat_id`),
  KEY `fk_reserved_seat_reservation1_idx` (`reservation_id`),
  CONSTRAINT `fk_reserved_seat_reservation1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserved_seat`
--

LOCK TABLES `reserved_seat` WRITE;
/*!40000 ALTER TABLE `reserved_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserved_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_rate`
--

DROP TABLE IF EXISTS `ticket_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_rate` (
  `ticket_rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_rate` float DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `movie_id` int(11) NOT NULL,
  `ticket_type` int(11) NOT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ticket_rate_id`),
  KEY `fk_ticket_rates_movies_list1_idx` (`movie_id`),
  KEY `fk_ticket_rate_ticket_type1_idx` (`ticket_type`),
  CONSTRAINT `fk_ticket_rate_ticket_type1` FOREIGN KEY (`ticket_type`) REFERENCES `ticket_type` (`ticket_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_rates_movies_list1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_rate`
--

LOCK TABLES `ticket_rate` WRITE;
/*!40000 ALTER TABLE `ticket_rate` DISABLE KEYS */;
INSERT INTO `ticket_rate` VALUES (2,150,'2015-12-06 09:57:21','2015-12-06 09:57:21',1,1,'admin','admin'),(3,100,'2015-12-06 09:57:21','2015-12-06 09:57:21',1,2,'admin','admin'),(4,150,'2015-12-06 10:23:08','2015-12-06 10:23:08',1,1,'admin','admin'),(5,100,'2015-12-06 10:23:08','2015-12-06 10:23:08',1,2,'admin','admin'),(6,150,'2015-12-06 10:11:01','2015-12-06 10:11:01',2,1,'admin','admin'),(7,100,'2015-12-06 10:11:01','2015-12-06 10:11:01',2,2,'admin','admin'),(8,150,'2015-12-06 10:11:57','2015-12-06 10:11:57',3,1,'admin','admin'),(9,100,'2015-12-06 10:11:57','2015-12-06 10:11:57',3,2,'admin','admin'),(10,150,'2015-12-07 04:50:38','2015-12-07 04:50:38',1,1,'admin','admin'),(11,100,'2015-12-07 04:50:38','2015-12-07 04:50:38',1,2,'admin','admin'),(12,150,'2015-12-07 04:51:48','2015-12-07 04:51:48',2,1,'admin','admin'),(13,100,'2015-12-07 04:51:48','2015-12-07 04:51:48',2,2,'admin','admin'),(14,170,'2015-12-07 04:52:29','2015-12-07 04:52:29',3,1,'admin','admin'),(15,120,'2015-12-07 04:52:29','2015-12-07 04:52:29',3,2,'admin','admin'),(16,150,'2015-12-07 08:07:44','2015-12-07 08:07:44',1,1,'admin','admin'),(17,100,'2015-12-07 08:07:44','2015-12-07 08:07:44',1,2,'admin','admin'),(18,60,'2015-12-23 03:55:17','2015-12-23 03:55:17',4,1,'admin','admin'),(19,40,'2015-12-23 03:55:17','2015-12-23 03:55:17',4,2,'admin','admin');
/*!40000 ALTER TABLE `ticket_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_type`
--

DROP TABLE IF EXISTS `ticket_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_type` (
  `ticket_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_type` varchar(45) NOT NULL,
  `ticket_type_count` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ticket_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_type`
--

LOCK TABLES `ticket_type` WRITE;
/*!40000 ALTER TABLE `ticket_type` DISABLE KEYS */;
INSERT INTO `ticket_type` VALUES (1,'FirstClass',50,'2015-12-06 09:40:11','2015-12-06 09:40:11'),(2,'Secondclass',50,'2015-12-06 09:40:28','2015-12-06 09:40:28');
/*!40000 ALTER TABLE `ticket_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timings`
--

DROP TABLE IF EXISTS `timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timings` (
  `timings_id` int(11) NOT NULL AUTO_INCREMENT,
  `timings` varchar(45) DEFAULT NULL,
  `created_date` varchar(45) DEFAULT NULL,
  `updated_date` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`timings_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timings`
--

LOCK TABLES `timings` WRITE;
/*!40000 ALTER TABLE `timings` DISABLE KEYS */;
INSERT INTO `timings` VALUES (1,'7:00 AM - 10:00 AM','2015-12-06-09.38.39','2015-12-06-10.24.36','admin','admin'),(2,'10:00 AM - 1:00 PM','2015-12-06-09.38.59','2015-12-06-09.38.59','admin','admin'),(3,'2:00 PM - 5:00 PM','2015-12-06-09.39.16','2015-12-06-09.39.16','admin','admin'),(4,'6:30 PM - 9:30 PM','2015-12-06-09.39.36','2015-12-06-09.39.36','admin','admin');
/*!40000 ALTER TABLE `timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  `user_role` int(11) NOT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_address_UNIQUE` (`email`),
  KEY `fk_user_user_role_idx` (`user_role`),
  CONSTRAINT `fk_user_user_role` FOREIGN KEY (`user_role`) REFERENCES `user_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'admin','admin','adminfirst','adminlast','admin@gmail.com','adminarea','2015-12-06 17:35:49','2015-12-06 17:35:49',2,NULL),(8,'pandi','pandi','vicky','pandi','vicky@gmail.com','chennai','2015-12-06 17:36:46','2015-12-06 17:36:46',1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` varchar(45) NOT NULL,
  `user_role_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'1','user'),(2,'2','admin');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-23 23:10:23
