-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: kasebot
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrator` (
  `administrator_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `login_name` varchar(100) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (100,'Tim','Sanders','tsanders','password123'),(101,'Hamza','Taoui','htaoui',''),(102,'Ting','Yu','tyu',''),(103,'Adil','ChickenTest','achicken','password123'),(104,'NewAdmin','Test','testAdmin','password123'),(105,'NewAdmin2','Test2','testAdmin2','password123'),(106,'BLAHHHH','BLAHJJH','bbbbb','password123');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `avg_cases_dur_rpt_vw`
--

DROP TABLE IF EXISTS `avg_cases_dur_rpt_vw`;
/*!50001 DROP VIEW IF EXISTS `avg_cases_dur_rpt_vw`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `avg_cases_dur_rpt_vw` AS SELECT 
 1 AS `cases_duration`,
 1 AS `create_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cases` (
  `cases_id` int(11) NOT NULL AUTO_INCREMENT,
  `cases_type` varchar(45) DEFAULT NULL COMMENT 'SALES/INFO/SUPPORT/GENERAL',
  `cases_notes` varchar(45) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `cases_status` varchar(45) DEFAULT NULL COMMENT 'Resolved/Unresolved/In Progress',
  `cases_create_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`cases_id`),
  KEY `customer_id_fk_idx` (`customer_id`),
  CONSTRAINT `customer_cases_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
INSERT INTO `cases` VALUES (1,'INFO','testt',1,'Resolved','2019-04-12 00:00:00'),(2,'INFO','testt',1,'Resolved','2019-04-12 00:00:00'),(3,'INFO','testt',2,'Unresolved','2019-04-12 00:00:00'),(4,'INFO','testt',2,'Unresolved','2019-04-12 00:00:00'),(5,'INFO','testt',2,'Unresolved','2019-04-12 00:00:00'),(6,'INFO','testt',2,'Unresolved','2019-04-12 00:00:00'),(8,'IN PROGRESS','This case is still in progress',7,'Unresolved','2019-04-10 00:00:00'),(9,'IN PROGRESS','YOU SUCK',9,'Unresolved','2019-03-30 00:00:00'),(10,'INFO','Blahdfkgdfgkdfgkjdfgjkdfgkdfgkjdkfgjdfkgj',9,'Resolved','2019-04-04 00:00:00'),(11,'SALES','MONDAY MONDAY MONDAY',8,'Resolved',NULL);
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'hello12','hello12','password123','hello12@gmail.com'),(2,'Jimmy','Carr','password123','car@gmail.com'),(6,'Michael','Bluth','password123','mikeBluth@gmail.com'),(7,'dfdfgf','Cocdfgdfggswell','password123','dfgdfg@gmail.com'),(8,'fgddfggggg','ggggg','password123','gggg@gmail.com'),(9,'ttttt','tttt','password123','ttttt@gmail.com'),(10,'rrrrrr','gfdfgdf','password123','dfgdfgdfg@gmail.com'),(11,'ppp','pppp','password123','ppp@gmail.com'),(12,'ppp','pppp','password123','ppppppp@gmail.com'),(13,'hello','hello','password123','hello@gmail.com'),(14,'hello1','hello1','password123','hello1@gmail.com'),(15,'hello2','hello2','password123','hello2@gmail.com'),(16,'hello3','hello3','password123','hello3@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_address` (
  `customer_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(100) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_address_id`),
  KEY `customer_id_fk_idx` (`customer_id`),
  CONSTRAINT `customer_address_id_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` VALUES (1,'Philadelphia',19144,NULL),(2,'London',48392,2),(6,'Los Angeles',12356,NULL),(8,'Los AngelesTest',12356,NULL),(9,'Los AngelesTestTest',12356,NULL),(10,'Los Angeles',12356,6),(11,'Beverly Hills',90210,6),(12,'Philadelphia',19144,7),(13,'Philadelphia',19144,8),(14,'Philadelphia',19144,9),(15,'Philadelphia',19144,10),(16,'Philadelphia',19144,11),(17,'Philadelphia',19144,12),(18,'Philadelphia',19144,13),(19,'Philadelphia',19144,14),(20,'Philadelphia',19144,15),(21,'Philadelphia',19144,16),(22,'New York',19144,1);
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(25) NOT NULL COMMENT 'CUSTOMER/BOT',
  `msg_text` varchar(500) DEFAULT NULL,
  `cases_id` int(11) NOT NULL,
  `message_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `cases_id_idx` (`cases_id`),
  CONSTRAINT `cases_id_fk` FOREIGN KEY (`cases_id`) REFERENCES `cases` (`cases_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'bc@gmail.com','test',1,'2019-01-01 00:00:00');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `resolve_unresolve_rpt_vw`
--

DROP TABLE IF EXISTS `resolve_unresolve_rpt_vw`;
/*!50001 DROP VIEW IF EXISTS `resolve_unresolve_rpt_vw`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `resolve_unresolve_rpt_vw` AS SELECT 
 1 AS `report_key`,
 1 AS `total_count`,
 1 AS `cases_status`,
 1 AS `case_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `avg_cases_dur_rpt_vw`
--

/*!50001 DROP VIEW IF EXISTS `avg_cases_dur_rpt_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `avg_cases_dur_rpt_vw` AS select avg((to_days(`msg`.`message_timestamp`) - to_days(`cs`.`cases_create_timestamp`))) AS `cases_duration`,date_format(`cs`.`cases_create_timestamp`,'%Y-%m-%d') AS `create_date` from (`message` `msg` join `cases` `cs` on((`msg`.`cases_id` = `cs`.`cases_id`))) where `msg`.`message_id` in (select max(`msgo`.`message_id`) from `message` `msgo` where (`msgo`.`cases_id` = `cs`.`cases_id`)) group by date_format(`cs`.`cases_create_timestamp`,'%Y-%m-%d') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `resolve_unresolve_rpt_vw`
--

/*!50001 DROP VIEW IF EXISTS `resolve_unresolve_rpt_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `resolve_unresolve_rpt_vw` AS select floor((rand() * 1000000000000)) AS `report_key`,count(0) AS `total_count`,`cases`.`cases_status` AS `cases_status`,date_format(`cases`.`cases_create_timestamp`,'%Y-%m-%d') AS `case_date` from `cases` group by `cases`.`cases_status`,date_format(`cases`.`cases_create_timestamp`,'%Y-%m-%d') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-17  8:56:23

--Add cleaner view create

-- -----------------------------------------------------
-- View `kasebot`.`resolve_unresolve_rpt_vw`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kasebot`.`resolve_unresolve_rpt_vw`;
USE `kasebot`;
CREATE  OR REPLACE VIEW kasebot.`resolve_unresolve_rpt_vw` AS
    SELECT FLOOR((RAND() * 1000000000000)) AS `report_key`, count(*) AS 'total_count', cases_status, DATE_FORMAT(cases_create_timestamp, '%Y-%m-%d') as 'case_date'
    FROM `kasebot`.cases
    GROUP BY cases_status, DATE_FORMAT(cases_create_timestamp, '%Y-%m-%d');


-- -----------------------------------------------------
-- View `kasebot`.`avg_cases_dur_rpt_vw`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kasebot`.`avg_cases_dur_rpt_vw`;
USE `kasebot`;
CREATE  OR REPLACE VIEW kasebot.`avg_cases_dur_rpt_vw` AS
	SELECT avg(datediff(msg.message_timestamp, cases_create_timestamp)) as cases_duration, DATE_FORMAT(cases_create_timestamp, "%Y-%m-%d") as create_date
    FROM `kasebot`.message msg
		INNER JOIN `kasebot`.cases cs ON msg.cases_id = cs.cases_id
	WHERE message_id in(
		SELECT max(message_id)
        FROM `kasebot`.message msgo
        WHERE msgo.cases_id = cs.cases_id
    )
    GROUP BY DATE_FORMAT(cases_create_timestamp, "%Y-%m-%d");
