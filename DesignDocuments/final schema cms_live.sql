-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 19, 2015 at 08:55 AM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cms_live`
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
  `expiration` date DEFAULT NULL,
  `isPublished` tinyint(1) NOT NULL,
  `author` varchar(20) NOT NULL DEFAULT 'Anonymous',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `title`, `body`, `postDate`, `expiration`, `isPublished`, `author`) VALUES
(1, 'Booo?', '<p>This is a <strong>prettttty</strong> good bodyy.</p>', '2015-11-18', NULL, 1, 'Bob'),
(2, '', '<p><br data-mce-bogus="1"></p>', '2015-11-16', NULL, 1, 'Bob'),
(3, 'Title', '<p>alsdkfjkjasldfkj</p>', '2015-11-16', NULL, 1, 'Bob'),
(4, 'Post with no tags', '<p>this is a body</p>', '2015-11-18', NULL, 1, 'Bob'),
(5, 'another post with no tags', '<p>body</p>', '2015-11-18', NULL, 1, 'Bob'),
(6, 'asdf', '<p>asdf</p>', '2015-11-18', NULL, 1, 'Bob'),
(7, 'tt', '<p>asdf</p>', '2015-11-19', NULL, 1, 'Bob');

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
(2, 2),
(3, 1),
(1, 1),
(4, 2),
(5, 2),
(6, 11),
(7, 12);

-- --------------------------------------------------------

--
-- Table structure for table `static_content`
--

CREATE TABLE IF NOT EXISTS `static_content` (
  `content_id` int(11) NOT NULL,
  `content` varchar(10000) NOT NULL,
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `static_content`
--

INSERT INTO `static_content` (`content_id`, `content`) VALUES
(1, '<p>Yuck</p>');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `tagName` (`tagName`),
  UNIQUE KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`tag_id`, `tagName`) VALUES
(2, ''),
(1, 'asd'),
(12, 'suuuuuuuuuperlongtag'),
(10, 'tag'),
(11, 'tagtag');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `publicname` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_2` (`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`, `publicname`, `authority`) VALUES
(1, 'test', 'password', 1, 'Bob', 'ROLE_ADMIN'),
(2, 'test2', 'password', 1, 'Larry', 'ROLE_USER');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `post_tag`
--
ALTER TABLE `post_tag`
  ADD CONSTRAINT `post_tag_ibfk1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  ADD CONSTRAINT `post_tag_ibfk2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
