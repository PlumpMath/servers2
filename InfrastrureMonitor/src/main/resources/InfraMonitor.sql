-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 27, 2012 at 06:50 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `InfraMonitor`
--

-- --------------------------------------------------------

--
-- Table structure for table `servers`
--

CREATE TABLE IF NOT EXISTS `servers` (
  `serverid` bigint(20) NOT NULL AUTO_INCREMENT,
  `servername` varchar(45) DEFAULT NOT NULL,
  PRIMARY KEY (`Serverid`),
 -- KEY `FK3580769128426C` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `role`
--

--INSERT INTO `role` (`id`, `role`, `user_id`) VALUES
--(1, 1, 1),
--(13, 2, 13);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

--CREATE TABLE IF NOT EXISTS `user` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `firstName` varchar(255) DEFAULT NULL,
--  `lastName` varchar(255) DEFAULT NULL,
--  `password` varchar(255) DEFAULT NULL,
--  `username` varchar(255) DEFAULT NULL,
--  `email` varchar(255) DEFAULT NULL,
--  `phone` varchar(255) DEFAULT NULL,
--  PRIMARY KEY (`id`),
--  UNIQUE KEY `username` (`username`)
--) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `user`
--

--INSERT INTO `user` (`id`, `firstName`, `lastName`, `password`, `username`, `email`, `phone`) VALUES
--(1, 'John', 'Smith', '21232f297a57a5a743894a0e4a801fc3', 'john', 'john.smith@abc.com', '800-555-1212'),

--
-- Constraints for dumped tables
--

--
-- Constraints for table `role`
--
--ALTER TABLE `role`
 -- ADD CONSTRAINT `FK3580769128426C` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);