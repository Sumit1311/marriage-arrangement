-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2018 at 01:44 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wedding`
--

-- --------------------------------------------------------

--
-- Table structure for table `t3`
--

CREATE TABLE `t3` (
  `name` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_contact`
--

CREATE TABLE `tbl_contact` (
  `cname` text NOT NULL,
  `cno` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_contact`
--

INSERT INTO `tbl_contact` (`cname`, `cno`) VALUES
('Bhavin', '9723253190'),
('Raj', '7874667055'),
('Raju', '9879818332'),
('Raja', '8200912237'),
('Vaishnavi', '8780016500'),
('Bhavin S Chauhan', '9988998899');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_invitation`
--

CREATE TABLE `tbl_invitation` (
  `pageno` text NOT NULL,
  `imgpath` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_invitation`
--

INSERT INTO `tbl_invitation` (`pageno`, `imgpath`) VALUES
('First Page', '1538475029615.jpg'),
('Second Page', '1538475069251.jpg'),
('Third Page', '1538475091494.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_menu`
--

CREATE TABLE `tbl_menu` (
  `m_id` int(4) NOT NULL,
  `menu_type` text NOT NULL,
  `menu_time` text NOT NULL,
  `menu_dt` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_menu`
--

INSERT INTO `tbl_menu` (`m_id`, `menu_type`, `menu_time`, `menu_dt`) VALUES
(2, 'Breakfast', '5', '11-12-2018');

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
('hfhfsjshdh', '65656565', 'bgdhcg', 'Beva'),
('lonar', '7405243489', 'hellooo', 'Phera');

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
('Raj', '87878787', 'drama'),
('vaishnavi', '8780016500', 'drama');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_room`
--

CREATE TABLE `tbl_room` (
  `roomno` text NOT NULL,
  `guest_nm` text NOT NULL,
  `guest_mob` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_room`
--

INSERT INTO `tbl_room` (`roomno`, `guest_nm`, `guest_mob`) VALUES
('1', 'Bhavin', '9898989898'),
('1', 'Bhavin', '9898989898'),
('1', 'Vaishnavi', '8780016500'),
('1', 'Raj', '7874667055'),
('1', 'Vaishnavi', '8780016500'),
('1', 'Raja', '8200912237'),
('1', 'Raju', '9879818332'),
('6', 'Raja', '8200912237'),
('6', 'Vaishnavi', '8780016500'),
('6', 'Raju', '9879818332'),
('6', 'Raj', '7874667055'),
('6', 'Raju', '9879818332'),
('6', 'Raja', '8200912237'),
('2', 'Vaishnavi', '8780016500'),
('2', 'Raju', '9879818332'),
('2', 'Bhavin S Chauhan', '9988998899');

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
('lonar', '7588415318', 'hello...');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transport`
--

CREATE TABLE `tbl_transport` (
  `t_id` int(4) NOT NULL,
  `route` text NOT NULL,
  `drivername` text NOT NULL,
  `driverno` text NOT NULL,
  `vehicleno` text NOT NULL,
  `dt` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transport`
--

INSERT INTO `tbl_transport` (`t_id`, `route`, `drivername`, `driverno`, `vehicleno`, `dt`) VALUES
(1, 'Lonar to Sailu', 'fff', '222', 'fff', 'Lonar to Sailu');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `uname` text NOT NULL,
  `pwd` text NOT NULL,
  `arrangertype` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`uname`, `pwd`, `arrangertype`) VALUES
('bsc', 'bsc', 'Menu Arranger'),
('vv', 'vv', 'Transport Arranger'),
('vaishnavi', 'vaishnavi', 'Admin'),
('saurabh toshniwal', 'saurabh@123', 'Menu Arranger');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_menu`
--
ALTER TABLE `tbl_menu`
  ADD PRIMARY KEY (`m_id`);

--
-- Indexes for table `tbl_transport`
--
ALTER TABLE `tbl_transport`
  ADD PRIMARY KEY (`t_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_menu`
--
ALTER TABLE `tbl_menu`
  MODIFY `m_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_transport`
--
ALTER TABLE `tbl_transport`
  MODIFY `t_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
