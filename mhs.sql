-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2020 at 07:41 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kuis`
--

-- --------------------------------------------------------

--
-- Table structure for table `mhs`
--

CREATE TABLE `mhs` (
  `nama` varchar(20) NOT NULL,
  `nim` int(11) NOT NULL,
  `mat1` varchar(15) NOT NULL,
  `nilai1` int(11) NOT NULL,
  `mat2` varchar(15) NOT NULL,
  `nilai2` int(11) NOT NULL,
  `rata2` float NOT NULL,
  `huruf` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mhs`
--

INSERT INTO `mhs` (`nama`, `nim`, `mat1`, `nilai1`, `mat2`, `nilai2`, `rata2`, `huruf`) VALUES
('re', 123, 're', 20, 'we', 13, 13, ''),
('risa', 123, 'PBO', 70, 'MAT', 50, 60, ''),
('baba', 1234, 'SCPK', 90, 'PBO', 20, 55, ''),
('iv', 21, 'apa', 30, 'hm', 35, 32.5, ''),
('farisa', 44, 'PBO', 95, 'SCPK', 90, 92.5, 'E'),
('ahaid', 123345, 'jsh', 35, 'ja', 60, 47.5, 'D'),
('Farisa ', 123, 'PBO', 30, 'SCPK', 35, 32.5, 'D'),
('BABA ', 23, 'RPL', 50, 'SCPK', 35, 42.5, 'D'),
('Farisa Yumna', 123180103, 'PBO', 98, 'SCPK', 85, 91.5, 'A');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
