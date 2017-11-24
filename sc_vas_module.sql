-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: sc_vas_module
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `sc_vas_activation`
--

DROP TABLE IF EXISTS `sc_vas_activation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sc_vas_activation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_no` varchar(45) NOT NULL,
  `feature_code` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `activate_date` timestamp(6) NULL DEFAULT NULL,
  `terminate_date` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sc_vas_activation`
--

LOCK TABLES `sc_vas_activation` WRITE;
/*!40000 ALTER TABLE `sc_vas_activation` DISABLE KEYS */;
INSERT INTO `sc_vas_activation` VALUES (1,'0714244978','MCA',1,'2017-10-31 16:50:36.000000',NULL),(2,'0714244978','MMS',0,'2017-10-31 16:51:40.000000',NULL),(3,'0714244978','GPRS',1,'2017-10-31 16:51:49.000000',NULL),(4,'0714244978','DFR',1,'2017-10-31 16:51:59.000000',NULL),(5,'0714244978','SMSR',1,'2017-10-31 16:52:06.000000',NULL),(6,'0714244978','EBILL',1,'2017-10-31 16:52:35.000000','2017-10-31 16:52:36.000000'),(7,'0714244978','NAS',1,'2017-10-31 16:52:44.000000','2017-10-31 16:52:45.000000'),(8,'0714244978','DUSA',0,'2017-10-30 18:30:00.000000','2017-11-04 18:30:00.000000'),(9,'0715566152','MCA',1,'2017-10-31 18:30:00.000000','2017-10-31 18:30:00.000000'),(10,'0715566152','GPRS',1,'2017-10-31 18:30:00.000000',NULL),(11,'0714244978','MMS',0,'2017-11-03 18:30:00.000000',NULL),(12,'0714244978','BR',1,'2017-11-03 18:30:00.000000',NULL),(13,'0714244978','MMS',1,'2017-11-03 18:30:00.000000',NULL),(14,'0714244978','MMS',1,'2017-11-03 18:30:00.000000',NULL),(15,'0714244978','MMS',1,'2017-11-03 18:30:00.000000',NULL),(16,'0714244978','MMS',1,'2017-11-03 18:30:00.000000',NULL),(17,'0714244978','DUSA',1,'2017-11-04 18:30:00.000000',NULL),(18,'0718847868','MMS',1,'2017-11-23 18:30:00.000000',NULL);
/*!40000 ALTER TABLE `sc_vas_activation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vas_feature_list`
--

DROP TABLE IF EXISTS `vas_feature_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vas_feature_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vas_code` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vas_feature_list`
--

LOCK TABLES `vas_feature_list` WRITE;
/*!40000 ALTER TABLE `vas_feature_list` DISABLE KEYS */;
INSERT INTO `vas_feature_list` VALUES (1,'DUSA','Daily Usage SMS Alert',1),(2,'MMS','MMS Settings',1),(3,'GPRS','GPRS Settings',1),(4,'MCA','Miss Call Alerts',1),(5,'EBILL','E-bill',1),(6,'BR','Budget Roaming',1),(7,'DFR','Deposite Free Roaming',1),(8,'SMSR','SMS Roaming',1),(9,'NAS','News Alerts',1);
/*!40000 ALTER TABLE `vas_feature_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-24 14:27:11
