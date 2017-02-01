/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.17 : Database - epos_projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`epos_projekat` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

/*Table structure for table `clan` */

DROP TABLE IF EXISTS `clan`;

CREATE TABLE `clan` (
  `broj_clana` int(11) NOT NULL AUTO_INCREMENT,
  `datum_uclanjenja` date DEFAULT NULL,
  `ime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kontakt` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresa` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`broj_clana`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `clan` */

insert  into `clan`(`broj_clana`,`datum_uclanjenja`,`ime`,`prezime`,`kontakt`,`adresa`) values (8,'2017-02-02','5','5','5','5 ');

/*Table structure for table `clanarina` */

DROP TABLE IF EXISTS `clanarina`;

CREATE TABLE `clanarina` (
  `broj_clana` int(11) NOT NULL,
  `mesec` int(11) NOT NULL,
  `godina` int(11) NOT NULL,
  `datum_uplate` date DEFAULT NULL,
  `iznos` int(11) DEFAULT NULL,
  `korisnik` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`broj_clana`,`mesec`,`godina`),
  CONSTRAINT `clanarina_ibfk_1` FOREIGN KEY (`broj_clana`) REFERENCES `clan` (`broj_clana`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `clanarina` */

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lozinka` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`username`,`lozinka`,`ime`,`prezime`) values ('1','1','1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
