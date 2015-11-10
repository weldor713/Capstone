-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 10, 2015 at 08:38 AM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `CmsTest`
--

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `body` varchar(10000) NOT NULL,
  `postDate` date NOT NULL,
  `expiration` date NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `title`, `body`, `postDate`, `expiration`) VALUES
(13, 'asdsadsada', '<p>asdsadasda</p>', '0000-00-00', '0000-00-00'),
(14, 'Testing the DB again', '<p>Testing testing</p>', '0000-00-00', '0000-00-00'),
(15, 'Testing database dupes', '<p>zxczxz</p>', '0000-00-00', '0000-00-00'),
(16, 'title', '<p>body</p>', '0000-00-00', '0000-00-00'),
(17, '', '<p>sdf</p>', '2016-12-01', '0242-03-23'),
(18, 'sdf', '<p>sdfa</p>', '2015-11-04', '2015-11-11');

-- --------------------------------------------------------

--
-- Table structure for table `post_tag`
--

CREATE TABLE IF NOT EXISTS `post_tag` (
  `post_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  KEY `post_id` (`post_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post_tag`
--

INSERT INTO `post_tag` (`post_id`, `tag_id`) VALUES
(13, 2),
(13, 1),
(13, 3),
(14, 1),
(14, 4),
(14, 2),
(15, 5),
(15, 6),
(15, 7),
(15, 8),
(15, 9),
(16, 10),
(16, 11),
(17, 12),
(18, 13);

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`tag_id`, `tagName`) VALUES
(1, 'hey'),
(2, 'zoopa'),
(3, 'hi'),
(4, 'hi'),
(5, 'ho'),
(6, 'zuppa'),
(7, 'zinger'),
(8, 'hey'),
(9, 'hi'),
(10, ' hello'),
(11, 'hi'),
(12, 'ad'),
(13, 'asdf');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `post_tag`
--
ALTER TABLE `post_tag`
  ADD CONSTRAINT `post_tag_ibfk1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `post_tag_ibfk2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
