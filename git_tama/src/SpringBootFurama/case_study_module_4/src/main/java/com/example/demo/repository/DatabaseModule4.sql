-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_boot_furama
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `attach_service_cost` double DEFAULT NULL,
  `attach_service_unit` varchar(10) DEFAULT NULL,
  `attach_service_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),(3,'Thuê xe đạp',20000,'chiếc','tốt'),(4,'Buffet buổi sáng',15000,'suất',' đầy đủ đồ ăn, tráng miệng '),(5,'Buffet buổi trưa',90000,'suất',' đầy đủ đồ ăn, tráng miệng '),(6,'Buffet buổi tối',16000,'suất',' đầy đủ đồ ăn, tráng miệng ');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `total_money` double DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  `status` varchar(4) DEFAULT 'on',
  PRIMARY KEY (`id`),
  KEY `fk_c_e` (`employee_id`),
  KEY `fk_c_c` (`customer_id`),
  KEY `fk_c_s` (`service_id`),
  CONSTRAINT `fk_c_c` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_c_e` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_c_s` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'2020-12-08 00:00:00','2020-12-08 00:00:00',0,NULL,3,1,3,'on'),(2,'2020-07-14 00:00:00','2020-07-21 00:00:00',200000,NULL,7,3,1,'on'),(3,'2021-03-15 00:00:00','2021-03-17 00:00:00',50000,NULL,3,4,2,'on'),(4,'2021-01-14 00:00:00','2021-01-18 00:00:00',100000,NULL,7,5,5,'on'),(5,'2021-07-14 00:00:00','2021-07-15 00:00:00',0,NULL,7,2,6,'on'),(6,'2021-06-01 00:00:00','2021-06-03 00:00:00',0,NULL,7,7,6,'on'),(7,'2021-09-02 00:00:00','2021-09-05 00:00:00',100000,NULL,7,4,4,'on'),(8,'2021-06-17 00:00:00','2021-06-18 00:00:00',150000,NULL,3,4,1,'on'),(9,'2020-11-19 00:00:00','2020-11-19 00:00:00',0,NULL,3,4,3,'on'),(10,'2021-04-12 00:00:00','2021-04-14 00:00:00',0,NULL,10,3,5,'on'),(11,'2021-04-25 00:00:00','2021-04-25 00:00:00',0,NULL,2,2,1,'on'),(12,'2021-05-25 00:00:00','2021-05-27 00:00:00',0,NULL,7,10,1,'on');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_contract` AFTER UPDATE ON `contract` FOR EACH ROW begin 
if new.`status` = "off" 
then 
delete from contract_details where contract_details.contract_id = new.id;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `delete_contract` BEFORE DELETE ON `contract` FOR EACH ROW begin 
delete from contract_details where contract_details.contract_id = old.id;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `contract_details`
--

DROP TABLE IF EXISTS `contract_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contract_id` int DEFAULT NULL,
  `attach_service_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cd_as` (`attach_service_id`),
  KEY `fk_cd_c` (`contract_id`),
  CONSTRAINT `fk_cd_as` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`id`),
  CONSTRAINT `fk_cd_c` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_details`
--

LOCK TABLES `contract_details` WRITE;
/*!40000 ALTER TABLE `contract_details` DISABLE KEYS */;
INSERT INTO `contract_details` VALUES (1,5,4,2),(2,8,5,12),(3,3,6,2),(4,1,1,13),(5,3,2,3),(6,1,3,1),(7,2,2,1),(8,2,2,12);
/*!40000 ALTER TABLE `contract_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_customer_id` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` varchar(4) DEFAULT 'on',
  PRIMARY KEY (`id`),
  KEY `fk_c_type` (`type_customer_id`),
  KEY `FK_cus_gender` (`gender`),
  CONSTRAINT `fk_c_type` FOREIGN KEY (`type_customer_id`) REFERENCES `type_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,5,'Nguyễn Thị Hào','1970-11-07','643431213',_binary '\0','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng','on'),(2,3,'Phạm Xuân Diệu','1992-08-08','865342123',_binary '','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị','on'),(3,1,'Trương Đình Nghệ','1990-02-27','488645199',_binary '','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh','on'),(4,1,'Dương Văn Quan','1981-07-08','543432111',_binary '','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng','on'),(5,4,'Hoàng Trần Nhi Nhi','1995-12-09','795453345',_binary '\0','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai','on'),(6,4,'Tôn Nữ Mộc Châu','2005-12-06','732434215',_binary '\0','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng','on'),(7,1,'Nguyễn Mỹ Kim','1984-04-08','856453123',_binary '\0','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh','on'),(8,3,'Nguyễn Thị Hào','1999-04-08','965656433',_binary '\0','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum','on'),(9,1,'Trần Đại Danh','1994-07-01','432341235',_binary '','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi','on'),(10,2,'Nguyễn Tâm Đắc','1989-07-01','344343432',_binary '','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng','on');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_customer` AFTER UPDATE ON `customer` FOR EACH ROW begin 
if new.`status` = "off" 
then 
update contract set `status` = "off" where contract.customer_id = old.id;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Sale – Marketing'),(2,'Administration'),(3,'Service'),(4,'Manager');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'Intermediate'),(2,'Degree Of Associate'),(3,'Undergraduate'),(4,'Post graduate');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `education_degree_id` int DEFAULT NULL,
  `division_id` int DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `status` varchar(4) DEFAULT 'on',
  PRIMARY KEY (`id`),
  KEY `fk_user_employee` (`username`),
  KEY `fk_e_p` (`position_id`),
  KEY `fk_e_e_d` (`education_degree_id`),
  KEY `fk_e_d` (`division_id`),
  CONSTRAINT `fk_e_d` FOREIGN KEY (`division_id`) REFERENCES `division` (`id`),
  CONSTRAINT `fk_e_e_d` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`id`),
  CONSTRAINT `fk_e_p` FOREIGN KEY (`position_id`) REFERENCES `positions` (`id`),
  CONSTRAINT `fk_user_employee` FOREIGN KEY (`username`) REFERENCES `user_account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,'Nhan','on'),(2,'Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,'Nhan','on'),(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,'Nhan','on'),(4,'Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,'Nhan','on'),(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,'Tri','on'),(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3,'Tri','on'),(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,'Tri','on'),(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,'Tri','on'),(9,'Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,'Tri','on'),(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,'Tri','on');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_employee` AFTER UPDATE ON `employee` FOR EACH ROW begin 
if new.`status` = "off" 
then 
update contract set `status` = "off" where contract.employee_id = old.id;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Receptionist '),(2,'Expert'),(3,'Supervisor'),(4,'Manager'),(5,'President');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `rent_type_cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,'year',1000),(2,'month',700),(3,'day',300),(4,'hour',100);
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `area` int DEFAULT NULL,
  `service_cost` double DEFAULT NULL,
  `max_people` int DEFAULT NULL,
  `standard_room` varchar(50) DEFAULT NULL,
  `description_other_convenience` varchar(50) DEFAULT NULL,
  `pool_area` double DEFAULT NULL,
  `number_of_floors` int DEFAULT NULL,
  `facility_text` text,
  `rent_type_id` int DEFAULT NULL,
  `service_type_id` int DEFAULT NULL,
  `status` varchar(50) DEFAULT 'on',
  PRIMARY KEY (`id`),
  KEY `fk_ser_type_rent` (`rent_type_id`),
  KEY `fk_ser_type_facility` (`service_type_id`),
  CONSTRAINT `fk_ser_type_facility` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`),
  CONSTRAINT `fk_ser_type_rent` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Villa Beach Front',25000,1000000,10,'vip','Có hồ bơi',500,4,NULL,3,1,'on'),(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',NULL,3,NULL,2,2,'on'),(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',NULL,NULL,'1 Xe máy, 1 Xe đạp',4,3,'on'),(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,NULL,3,1,'on'),(5,'House Princess 02',1000,4000000,5,'normal','Có thêm bếp nướng',NULL,2,NULL,3,2,'on'),(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',NULL,NULL,'1 Xe máy',4,3,'on');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_service` AFTER UPDATE ON `service` FOR EACH ROW begin 
if new.`status` = "off" 
then 
update contract set `status` = "off" where contract.service_id = old.id;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'room'),(2,'house'),(3,'villa');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_customer`
--

DROP TABLE IF EXISTS `type_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_customer`
--

LOCK TABLES `type_customer` WRITE;
/*!40000 ALTER TABLE `type_customer` DISABLE KEYS */;
INSERT INTO `type_customer` VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `type_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('Nhan','nhanso12'),('Tri','123456');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_author`
--

DROP TABLE IF EXISTS `user_role_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role_author` (
  `role_id` int DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  KEY `fk_role_author` (`role_id`),
  KEY `fk_user_author` (`username`),
  CONSTRAINT `fk_role_author` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`),
  CONSTRAINT `fk_user_author` FOREIGN KEY (`username`) REFERENCES `user_account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_author`
--

LOCK TABLES `user_role_author` WRITE;
/*!40000 ALTER TABLE `user_role_author` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--
USE `spring_boot_furama`;
DROP function IF EXISTS `total_money_service`;

USE `spring_boot_furama`;
DROP function IF EXISTS `spring_boot_furama`.`total_money_service`;
;

DELIMITER $$
USE `spring_boot_furama`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `total_money_service`(id_contract int) RETURNS int
    DETERMINISTIC
BEGIN
declare total int;
SELECT ((service_cost + sum(IFNULL(quantity * attach_service_cost, 0))) - deposit) into total FROM contract inner join service ON service.id = contract.service_id  and contract.`status` = 'on' and contract.id = id_contract left JOIN service_type ON service_type.id = service.service_type_id left JOIN contract_details ON contract_details.contract_id = contract.id left JOIN attach_service ON attach_service.id = contract_details.attach_service_id GROUP BY contract.id ;
        RETURN total;
END$$

DELIMITER ;
;

USE `spring_boot_furama`;
DROP function IF EXISTS `getMoneyCreateContract`;

DELIMITER $$
USE `spring_boot_furama`$$
CREATE FUNCTION `getMoneyCreateContract` (id_service int, deposit int)
RETURNS INTEGER deterministic
BEGIN
declare cost int;
select (service_cost - deposit) into cost from service where id  = id_service;
RETURN cost;
END$$

DELIMITER ;



DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19 20:04:20
