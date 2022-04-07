-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: whiskey_api
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `whiskeys`
--

DROP TABLE IF EXISTS `whiskeys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `whiskeys` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `category` varchar(255) NOT NULL,
                            `description` varchar(255) NOT NULL,
                            `name` varchar(255) NOT NULL,
                            `optional_name` varchar(255) NOT NULL,
                            `origin` varchar(255) NOT NULL,
                            `price` double NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `whiskeys`
--

LOCK TABLES `whiskeys` WRITE;
/*!40000 ALTER TABLE `whiskeys` DISABLE KEYS */;
INSERT INTO `whiskeys` VALUES (100,'Irish','Charring is an age-old method for invigorating barrels to intensify the taste. Jameson Black Barrel is our tribute to our coopers, who painstakingly give their bourbon barrels an additional charring to reveal their untold richness and complexity. Because ','Jameson','Black Barrel','Ireland',25),(101,'Irish','Tullamore D.E.W. 12 Year Old Special Reserve offers a spice flavour with a robust yet creamy body wrapped in a definite chocolaty note.','Tullamore Dew','12 Year Old Special Reserve','Ireland',50),(102,'Scotch','A legendary malt that is on many people\'s most wanted list. The 16 year old is a true classic from Islay which combines pungent smoke along with complex flavours of dried fruits, spice, malt, vanilla and oak.','Lagavulin','16 Year Old','Scotland',97.5),(103,'Bourbon','Bulleit Rye is an award-winning, straight rye whiskey with a character of unparalleled spice and complexity. Released in 2011, it continues to enjoy recognition as one of the highest quality ryes available.','Bulleit','Rye','USA',50);
/*!40000 ALTER TABLE `whiskeys` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-12 20:19:55
