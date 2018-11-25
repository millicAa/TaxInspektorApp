/*
SQLyog Ultimate v9.50 
MySQL - 5.6.20 : Database - prosoftjun18predrok
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoftjun18predrok` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoftjun18predrok`;

/*Table structure for table `fizickolice` */

DROP TABLE IF EXISTS `fizickolice`;

CREATE TABLE `fizickolice` (
  `ObveznikID` int(11) NOT NULL,
  `JMBG` varchar(13) DEFAULT NULL,
  `ImePrezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ObveznikID`),
  CONSTRAINT `fizickolice_ibfk_1` FOREIGN KEY (`ObveznikID`) REFERENCES `poreskiobveznik` (`ObveznikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fizickolice` */

insert  into `fizickolice`(`ObveznikID`,`JMBG`,`ImePrezime`) values (3,'3333333333333','Jovan Jovanovic'),(4,'4444444444444','Marija Markovic'),(5,'5555555555555','Ivan Ivkovic');

/*Table structure for table `poreskaprijava` */

DROP TABLE IF EXISTS `poreskaprijava`;

CREATE TABLE `poreskaprijava` (
  `PrijavaID` int(11) NOT NULL,
  `Godina` int(11) DEFAULT NULL,
  `ObveznikID` int(11) DEFAULT NULL,
  `InspektorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PrijavaID`),
  KEY `ObveznikID` (`ObveznikID`),
  KEY `InspektorID` (`InspektorID`),
  CONSTRAINT `poreskaprijava_ibfk_1` FOREIGN KEY (`ObveznikID`) REFERENCES `poreskiobveznik` (`ObveznikID`),
  CONSTRAINT `poreskaprijava_ibfk_2` FOREIGN KEY (`InspektorID`) REFERENCES `poreskiinspektor` (`InspektorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `poreskaprijava` */

/*Table structure for table `poreskiinspektor` */

DROP TABLE IF EXISTS `poreskiinspektor`;

CREATE TABLE `poreskiinspektor` (
  `InspektorID` int(11) NOT NULL,
  `ImePrezime` varchar(255) DEFAULT NULL,
  `KorisnickoIme` varchar(255) DEFAULT NULL,
  `Lozinka` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`InspektorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `poreskiinspektor` */

insert  into `poreskiinspektor`(`InspektorID`,`ImePrezime`,`KorisnickoIme`,`Lozinka`) values (1,'Ivana Ivanic','ivana','ivana1'),(2,'Dusan Dusanic','dusan','dusan1'),(3,'Marko Markovic','marko','marko1');

/*Table structure for table `poreskiobveznik` */

DROP TABLE IF EXISTS `poreskiobveznik`;

CREATE TABLE `poreskiobveznik` (
  `ObveznikID` int(11) NOT NULL,
  PRIMARY KEY (`ObveznikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `poreskiobveznik` */

insert  into `poreskiobveznik`(`ObveznikID`) values (1),(2),(3),(4),(5);

/*Table structure for table `pravnolice` */

DROP TABLE IF EXISTS `pravnolice`;

CREATE TABLE `pravnolice` (
  `ObveznikID` int(11) NOT NULL,
  `PIB` varchar(9) DEFAULT NULL,
  `MaticniBroj` varchar(8) DEFAULT NULL,
  `Naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ObveznikID`),
  CONSTRAINT `pravnolice_ibfk_1` FOREIGN KEY (`ObveznikID`) REFERENCES `poreskiobveznik` (`ObveznikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pravnolice` */

insert  into `pravnolice`(`ObveznikID`,`PIB`,`MaticniBroj`,`Naziv`) values (1,'100383934','07004044','Fakultet organizacionih nauka'),(2,'222222222','02222222','Bambi');

/*Table structure for table `stavkaporeskeprijave` */

DROP TABLE IF EXISTS `stavkaporeskeprijave`;

CREATE TABLE `stavkaporeskeprijave` (
  `PrijavaID` int(11) NOT NULL,
  `RB` int(11) NOT NULL,
  `DatumPrometa` date DEFAULT NULL,
  `Vrednost` decimal(10,2) DEFAULT NULL,
  `Napomena` varchar(255) DEFAULT NULL,
  `VrstaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PrijavaID`,`RB`),
  KEY `VrstaID` (`VrstaID`),
  CONSTRAINT `stavkaporeskeprijave_ibfk_1` FOREIGN KEY (`PrijavaID`) REFERENCES `poreskaprijava` (`PrijavaID`),
  CONSTRAINT `stavkaporeskeprijave_ibfk_2` FOREIGN KEY (`VrstaID`) REFERENCES `vrstaporeza` (`VrstaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavkaporeskeprijave` */

/*Table structure for table `vrstaporeza` */

DROP TABLE IF EXISTS `vrstaporeza`;

CREATE TABLE `vrstaporeza` (
  `VrstaID` int(11) NOT NULL,
  `Naziv` varchar(255) DEFAULT NULL,
  `ProcenatPoreza` int(11) DEFAULT NULL,
  PRIMARY KEY (`VrstaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vrstaporeza` */

insert  into `vrstaporeza`(`VrstaID`,`Naziv`,`ProcenatPoreza`) values (1,'Porez na imovinu',10),(2,'Porez na dohodak',15),(3,'Porez na zaradu',10),(4,'Porez na kapitalnu dobit (igre na srecu, stednja itd.)',20),(5,'Porez na profit',20),(6,'Porez na upotrebnu motornih vozila',15),(7,'Porez na upotrebu plovila',30),(8,'Porez na upotrebu vazduhoplova',30);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
