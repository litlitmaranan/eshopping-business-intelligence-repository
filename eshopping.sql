-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2015 at 10:02 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eshopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_db`
--

CREATE TABLE IF NOT EXISTS `admin_db` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cart_db`
--

CREATE TABLE IF NOT EXISTS `cart_db` (
  `productid` int(50) NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(50) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `quantity` int(50) NOT NULL,
  `productprice` int(50) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer_db`
--

CREATE TABLE IF NOT EXISTS `customer_db` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `own_db`
--

CREATE TABLE IF NOT EXISTS `own_db` (
  `productid` int(50) NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(50) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `quantity` int(50) NOT NULL,
  `productprice` int(50) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `own_db`
--

INSERT INTO `own_db` (`productid`, `productbrand`, `productname`, `quantity`, `productprice`) VALUES
(1, 'iPhone', 'adfadsf', 234234, 34234),
(2, '', 'samsun note mini', 2, 25000),
(3, '', 'adf', 23, 42),
(4, '', 'adf', 23, 42),
(5, '', 'adf', 23, 42),
(6, 'Sony', 'gjhjkyugfhj', 134132, 3241324),
(7, '', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `prod_db`
--

CREATE TABLE IF NOT EXISTS `prod_db` (
  `productid` int(50) NOT NULL AUTO_INCREMENT,
  `productbrand` varchar(50) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `quantity` int(50) NOT NULL,
  `productprice` int(50) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
