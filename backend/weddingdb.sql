-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2018 at 07:41 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `weddingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_invitation`
--

CREATE TABLE `tbl_invitation` (
  `pageno` text NOT NULL,
  `imgpath` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_menu`
--

CREATE TABLE `tbl_menu` (
  `mid` int(5) NOT NULL,
  `menu_type` text NOT NULL,
  `menu_time` text NOT NULL,
  `menu_dt` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_menu`
--

INSERT INTO `tbl_menu` (`mid`, `menu_type`, `menu_time`, `menu_dt`) VALUES
(1, 'Breakfast', '666', '11-12-2018');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_other`
--

CREATE TABLE `tbl_other` (
  `venue` text NOT NULL,
  `poc` text NOT NULL,
  `description` text NOT NULL,
  `vidhiname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_other`
--

INSERT INTO `tbl_other` (`venue`, `poc`, `description`, `vidhiname`) VALUES
('ggggg', '5555', 'vvbh', 'Phera');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_participants`
--

CREATE TABLE `tbl_participants` (
  `partname` text NOT NULL,
  `partno` text NOT NULL,
  `parttype` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_participants`
--

INSERT INTO `tbl_participants` (`partname`, `partno`, `parttype`) VALUES
('Vaishnavi', '9898989898', 'Drama'),
('Vaishnavi', '9898989898', 'Drama');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sangit`
--

CREATE TABLE `tbl_sangit` (
  `venue` text NOT NULL,
  `poc` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_sangit`
--

INSERT INTO `tbl_sangit` (`venue`, `poc`, `description`) VALUES
('snagar', '98989898', 'bvhg'),
('ddff', '4445', 'gff'),
('vvbb', '888', 'vvv');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transport`
--

CREATE TABLE `tbl_transport` (
  `route` text NOT NULL,
  `drivername` text NOT NULL,
  `driverno` text NOT NULL,
  `vehicleno` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transport`
--

INSERT INTO `tbl_transport` (`route`, `drivername`, `driverno`, `vehicleno`, `date`) VALUES
('surendranagar to wadhwan', 'harish\r\n', '889988998', 'gj04 ghjr', '2018-09-05'),
('surendranagar to wadhwan', 'harish\r\n', '889988998', 'gj04 ghjr', '2018-09-05'),
('kk', 'dd', 'dd', 'dd', 'dd'),
('Lonar to Sailu', 'yfg', '844', 'cvff', '11-12-2018'),
('Lonar to Sailu', 'nnn', '999971148144', 'bbbb', '11-12-2018');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
