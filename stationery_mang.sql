-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2020 at 06:20 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stationery_mang`
--

-- --------------------------------------------------------

--
-- Table structure for table `stationery_records`
--

CREATE TABLE `stationery_records` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `enrollno` int(11) NOT NULL,
  `year` text NOT NULL,
  `semester` text NOT NULL,
  `branch` text NOT NULL,
  `uniform` text NOT NULL,
  `file` text NOT NULL,
  `pages` text NOT NULL,
  `manuals` text NOT NULL,
  `subjects` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stationery_records`
--

INSERT INTO `stationery_records` (`id`, `name`, `enrollno`, `year`, `semester`, `branch`, `uniform`, `file`, `pages`, `manuals`, `subjects`, `date`) VALUES
(19, 'pankaj mahajan', 1914758, '5th Sem', '3rd Year', 'EE', '---', 'File', 'Pages', 'Manuals', '                    MAN 22509\n                    IAM 22523\n                    ---\n                    ECA 22525\n                    ELA 22526\n                    WPT 22528\n                    ---\n                    ---', '11-11-2020'),
(20, 'lalit tawde', 1914765, '6th Sem', '3rd Year', 'ME', '---', 'File', 'Pages', 'Manuals', '                    ETM 22652\n                    IHP 22655\n                    AEN 22656\n                    IEQ 22657\n                    CIM 22658\n                    RAC 22660\n                    \n                    ---', '11-11-2020');

-- --------------------------------------------------------

--
-- Table structure for table `studdata`
--

CREATE TABLE `studdata` (
  `id` int(11) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `enrollno` int(11) NOT NULL,
  `branch` text NOT NULL,
  `semester` text NOT NULL,
  `year` text NOT NULL,
  `address` text NOT NULL,
  `mobnp` text NOT NULL,
  `mobns` text NOT NULL,
  `dob` text NOT NULL,
  `gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studdata`
--

INSERT INTO `studdata` (`id`, `fname`, `lname`, `enrollno`, `branch`, `semester`, `year`, `address`, `mobnp`, `mobns`, `dob`, `gender`) VALUES
(34, 'harshal', 'Ramole', 19147525, 'CM', '1st Sem', '1st Year', 'nawa bhoi wada', '5456936598', '1582569874', '19-11-2002', 'Male'),
(35, 'Sumit', 'Wadile', 19147523, 'CM', '1st Sem', '1st Year', 'pakistan', '1523698563', '4523698546', '19-11-2012', 'Male'),
(36, 'Anil', 'Wadile', 19147536, 'CM', '1st Sem', '1st Year', 'Bangladesh', '452369856', '125632598', '16-11-2011', 'Male'),
(37, 'Sana', 'Patil', 19147569, 'CM', '1st Sem', '1st Year', 'Shri lanka', '145236987', '5632147896', '17-11-2020', 'Female'),
(38, 'Pankaj', 'Thakur', 191475369, 'EE', '1st Sem', '1st Year', 'America', '14785236', '95452587', '24-11-2003', 'Male'),
(39, 'Vijay', 'kale', 19147589, 'ME', '1st Sem', '1st Year', 'Russia', '256325698', '525656955', '11-11-2011', 'Male'),
(41, 'jay ', 'mahajan', 19147588, 'CE', '1st Sem', '1st Year', 'china', '14236985', '475632899', '10-11-2002', 'Male'),
(42, 'kajal', 'agrawal', 19147563, 'E&TC', '1st Sem', '1st Year', 'hongkong', '7878888', '8256369', '11-11-2008', 'Female'),
(44, 'palak', 'aggrawal', 19147512, 'CM', '2nd Sem', '1st Year', 'afganistan', '456336666', '52369856', '16-11-2011', 'Female'),
(45, 'komal', 'mahle', 19147520, 'EE', '2nd Sem', '1st Year', 'south korea', '452369566', '5888596585', '12-11-2013', 'Male'),
(46, 'neerma', 'powder', 19147565, 'ME', '2nd Sem', '1st Year', 'india', '4523698', '6255869', '18-11-2020', 'Female'),
(47, 'ghadi', 'ditergent', 19147586, 'CE', '2nd Sem', '1st Year', 'north korea', '452369', '55588554', '25-11-2020', 'Female'),
(49, 'santoor', 'soap', 19147580, 'E&TC', '2nd Sem', '1st Year', 'bhopal', '45823', '148', '19-11-2020', 'Male'),
(51, 'colgate', 'toothpast', 19147574, 'CM', '3rd Sem', '2nd Year', 'turkey', '12002', '4444', '12-11-2020', 'Male'),
(52, 'sony', 'tv', 19147500, 'EE', '3rd Sem', '2nd Year', 'azerbaijan', '200012012', '0012150', '16-11-2020', 'Male'),
(53, 'lenevo', 'kakar', 191475236, 'ME', '3rd Sem', '2nd Year', 'taiwan', '00120362', '4561451', '18-11-2020', 'Male'),
(54, 'probook', 'hp', 191475632, 'CE', '3rd Sem', '2nd Year', 'germany', '41256302', '56666', '09-11-2020', 'Female'),
(56, 'core', 'intel', 191471141, 'E&TC', '3rd Sem', '2nd Year', 'Jordan', '410236', '5594112015', '10-11-2020', 'Male'),
(58, 'rohit', 'sharma', 191475003, 'CM', '4th Sem', '2nd Year', 'australia', '588988', '6558988', '16-11-2020', 'Male'),
(60, 'hardik', 'pandya', 191475255, 'EE', '4th Sem', '2nd Year', 'india', '5635463', '645654', '17-11-2020', 'Male'),
(61, 'sam ', 'karan', 191475824, 'ME', '4th Sem', '2nd Year', 'china', '5636', '35353', '17-11-2020', 'Male'),
(62, 'ishan', 'kisan', 191475185, 'CE', '4th Sem', '2nd Year', 'india', '786486', '689696', '24-11-2020', 'Male'),
(64, 'surykumar', 'yadav', 191475884, 'E&TC', '4th Sem', '2nd Year', 'india', '116861', '168961', '16-11-2020', 'Male'),
(65, 'aakash', 'thakur', 19147524, 'CM', '5th Sem', '3rd Year', 'mumbai', '19415', '1541', '23-11-2020', 'Male'),
(66, 'pankaj', 'mahajan', 1914758, 'EE', '5th Sem', '3rd Year', 'pune', '846888', '91268962', '20-11-2020', 'Male'),
(67, 'chetan', 'koli', 19147584, 'ME', '5th Sem', '3rd Year', 'nashik', '18626896', '61896129', '16-11-2020', 'Male'),
(69, 'nikhil', 'patil', 191475886, 'CE', '5th Sem', '3rd Year', 'dhule', '14561632', '125632189', '22-11-2020', 'Male'),
(70, 'pramod', 'sharma', 19147285, 'E&TC', '5th Sem', '3rd Year', 'goa', '1286286', '2186', '26-11-2020', 'Male'),
(71, 'rahul', 'chahar', 19147865, 'CM', '6th Sem', '3rd Year', 'shirpur', '19147815', '157818', '23-11-2020', 'Male'),
(72, 'mayur', 'jadhav', 19147955, 'EE', '6th Sem', '3rd Year', 'nashik', '7857857', '45416485', '26-11-2020', 'Male'),
(73, 'lalit', 'tawde', 1914765, 'ME', '6th Sem', '3rd Year', 'Dondaicha', '15871', '1867167', '12-11-2020', 'Male'),
(74, 'aadesh', 'wadile', 1914786, 'CE', '6th Sem', '3rd Year', 'india', '245252', '52452', '18-11-2020', 'Male'),
(76, 'pavan', 'more', 191475894, 'E&TC', '6th Sem', '3rd Year', 'surat', '15413', '451245124', '24-11-2020', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `uname` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `uname`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'admin2', 'admin2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `stationery_records`
--
ALTER TABLE `stationery_records`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `studdata`
--
ALTER TABLE `studdata`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `enrollno` (`enrollno`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `stationery_records`
--
ALTER TABLE `stationery_records`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `studdata`
--
ALTER TABLE `studdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
