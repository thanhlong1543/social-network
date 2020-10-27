-- --------------------------------------------------------
-- Host:                         192.168.123.66
-- Server version:               10.5.4-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ambi
CREATE DATABASE IF NOT EXISTS `ambi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ambi`;

-- Dumping structure for table ambi.about
CREATE TABLE IF NOT EXISTS `about` (
  `aboutid` int(11) NOT NULL AUTO_INCREMENT,
  `education` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `lives` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `bio` text DEFAULT NULL,
  `comefrom` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aboutid`),
  KEY `FK_about_userid_user_userid` (`userid`),
  CONSTRAINT `FK_about_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.about: ~4 rows (approximately)
/*!40000 ALTER TABLE `about` DISABLE KEYS */;
INSERT INTO `about` (`aboutid`, `education`, `country`, `lives`, `birthday`, `userid`, `bio`, `comefrom`, `company`) VALUES
	(83, 'Oxford University', 'Vietnam', 'London', '1999-10-01', 2, 'Lorem ipsum dolor sit amet', 'Sai gon', 'Cafe24'),
	(84, 'Harvard University', 'Vietnam', 'New York', '1997-03-23', 6, '', 'HCM', 'WoowaHan'),
	(85, 'Education', NULL, NULL, NULL, 67, NULL, NULL, NULL),
	(86, 'Oxford University', 'Vietnam', 'London', '1999-10-01', 1, 'Lorem ipsum dolor sit ametttttt', 'Sai gon', 'Cafe24');
/*!40000 ALTER TABLE `about` ENABLE KEYS */;

-- Dumping structure for table ambi.category
CREATE TABLE IF NOT EXISTS `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.category: ~2 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryid`, `name`, `description`) VALUES
	(1, 'admin', 'admin'),
	(2, 'user', 'user');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table ambi.chat
CREATE TABLE IF NOT EXISTS `chat` (
  `chatid` int(11) NOT NULL AUTO_INCREMENT,
  `conid` int(11) NOT NULL,
  `content` text DEFAULT NULL,
  `chattime` datetime DEFAULT NULL,
  PRIMARY KEY (`chatid`),
  KEY `FK_chat_conid_conversation_conid` (`conid`),
  CONSTRAINT `FK_chat_conid_conversation_conid` FOREIGN KEY (`conid`) REFERENCES `conversation` (`conid`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.chat: ~169 rows (approximately)
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` (`chatid`, `conid`, `content`, `chattime`) VALUES
	(20, 1, '123213', '2020-09-21 19:03:46'),
	(21, 1, '123123', '2020-09-21 19:07:02'),
	(22, 1, '11111', '2020-09-21 19:22:16'),
	(23, 1, '1', '2020-09-21 19:22:22'),
	(24, 1, '222', '2020-09-21 19:22:25'),
	(25, 1, '222', '2020-09-21 19:22:27'),
	(26, 1, '12', '2020-09-21 19:22:30'),
	(27, 1, '123', '2020-09-21 19:22:34'),
	(28, 5, 'dawdaw', '2020-09-22 09:25:26'),
	(29, 5, 'adaw', '2020-09-22 09:25:28'),
	(30, 6, 'cc\n', '2020-09-22 17:03:41'),
	(31, 6, 'gi m', '2020-09-22 17:03:46'),
	(32, 7, 'dsadsa', '2020-09-23 13:48:29'),
	(33, 7, 'hahhahahaha', '2020-09-23 13:48:38'),
	(34, 7, 'hahaha clgithe', '2020-09-23 13:48:50'),
	(35, 7, 'dsadasdsadsadas', '2020-09-23 13:49:02'),
	(36, 7, 'dasdasdsadsadsadas', '2020-09-23 13:49:05'),
	(37, 7, 'dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd', '2020-09-23 14:15:30'),
	(38, 7, 'ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd', '2020-09-23 14:15:46'),
	(39, 6, 'alooo\n', '2020-09-23 14:57:28'),
	(40, 6, 'tadwadaw', '2020-09-23 14:57:31'),
	(41, 6, 'awfafafwa', '2020-09-23 14:57:37'),
	(42, 6, 'awdawfawgfawf', '2020-09-23 14:57:39'),
	(43, 7, 'dsadasdsa', '2020-09-23 14:57:46'),
	(44, 7, 'ddsadsa', '2020-09-23 14:57:54'),
	(45, 1, 'dawdaw', '2020-09-23 14:58:54'),
	(46, 1, 'awdawdw', '2020-09-23 14:58:58'),
	(47, 1, 'dawdawdawd', '2020-09-23 14:59:02'),
	(48, 1, 'awgawawfaw', '2020-09-23 14:59:06'),
	(49, 7, 'haif', '2020-09-23 14:59:11'),
	(50, 7, 'dasdas', '2020-09-23 14:59:29'),
	(51, 1, 'afafw', '2020-09-23 15:00:29'),
	(52, 1, 'awwfawfawfw', '2020-09-23 15:00:32'),
	(53, 1, '12', '2020-09-23 15:00:38'),
	(54, 1, '1a', '2020-09-23 15:00:44'),
	(55, 1, 'aw', '2020-09-23 15:00:49'),
	(56, 7, 'dsaddas', '2020-09-23 15:01:12'),
	(57, 7, '11111111111111111', '2020-09-23 15:01:20'),
	(58, 7, '1111111111111111111111111111111111', '2020-09-23 15:01:25'),
	(59, 7, 'hello', '2020-09-23 15:24:43'),
	(60, 6, 'hello', '2020-09-23 15:38:49'),
	(61, 6, 'test\n', '2020-09-23 15:40:28'),
	(62, 6, 'hi', '2020-09-23 15:40:47'),
	(63, 6, 'hi cc', '2020-09-23 15:41:33'),
	(64, 7, 'dsadsadsa', '2020-09-23 16:18:23'),
	(65, 6, '????', '2020-09-23 16:33:30'),
	(66, 6, 'testtttt', '2020-09-23 16:34:22'),
	(67, 6, 'fawfaw', '2020-09-23 16:36:17'),
	(68, 6, 'awfawfawf', '2020-09-23 16:36:18'),
	(69, 6, 'fawfawfawfaw', '2020-09-23 16:36:20'),
	(70, 6, 'adasdawfaw', '2020-09-23 16:37:34'),
	(71, 6, 'dsadsa', '2020-09-23 16:48:59'),
	(72, 6, 'dsadas', '2020-09-23 16:49:04'),
	(73, 6, '?', '2020-09-23 16:51:24'),
	(74, 6, 't', '2020-09-23 17:56:43'),
	(75, 6, 't', '2020-09-23 17:56:46'),
	(76, 6, 'adaw', '2020-09-23 17:56:54'),
	(77, 6, 'awdawd', '2020-09-23 17:57:01'),
	(78, 6, 'awdaw', '2020-09-23 18:04:50'),
	(79, 6, 'awdawa', '2020-09-23 18:04:54'),
	(80, 6, 'awdaw', '2020-09-23 18:04:57'),
	(81, 6, 'test', '2020-09-23 18:05:36'),
	(82, 6, 'abc', '2020-09-23 18:05:51'),
	(83, 6, 'asd', '2020-09-23 18:05:58'),
	(84, 6, 'a', '2020-09-23 18:06:11'),
	(85, 6, 'asd', '2020-09-23 18:06:39'),
	(86, 6, 'a', '2020-09-23 18:07:20'),
	(87, 6, 'b', '2020-09-23 18:07:28'),
	(88, 6, 'a', '2020-09-23 18:07:55'),
	(89, 6, 'a', '2020-09-23 18:08:48'),
	(90, 6, 'r', '2020-09-23 18:08:59'),
	(91, 6, 'a', '2020-09-23 18:09:10'),
	(92, 6, 'w', '2020-09-23 18:09:47'),
	(93, 6, 'awds', '2020-09-23 18:09:53'),
	(94, 6, 'asd', '2020-09-23 18:10:22'),
	(95, 6, 'a', '2020-09-23 18:10:42'),
	(96, 6, 'a', '2020-09-23 18:11:03'),
	(97, 6, 'w', '2020-09-23 18:11:08'),
	(98, 6, 'dashdas', '2020-09-24 08:16:02'),
	(99, 1, '111', '2020-09-24 13:05:17'),
	(100, 1, '111111', '2020-09-24 13:06:04'),
	(101, 1, '1', '2020-09-24 13:06:19'),
	(102, 1, '12', '2020-09-24 13:06:30'),
	(103, 1, '111', '2020-09-24 13:07:05'),
	(104, 1, '1', '2020-09-24 13:08:22'),
	(105, 1, '123', '2020-09-24 13:08:43'),
	(106, 1, '1', '2020-09-24 13:09:21'),
	(107, 1, 'test1', '2020-09-24 13:20:48'),
	(108, 1, 'test2', '2020-09-24 13:21:36'),
	(109, 1, '1', '2020-09-24 13:26:58'),
	(110, 1, '12', '2020-09-24 13:27:15'),
	(111, 1, '123', '2020-09-24 13:31:20'),
	(112, 1, '11', '2020-09-24 13:37:00'),
	(113, 1, '1', '2020-09-24 13:37:50'),
	(114, 1, 'ttest', '2020-09-24 13:50:09'),
	(115, 1, '1', '2020-09-24 14:01:32'),
	(116, 1, '12', '2020-09-24 14:04:26'),
	(117, 1, '123', '2020-09-24 14:09:00'),
	(118, 1, '1', '2020-09-24 14:23:34'),
	(119, 5, 'saoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo', '2020-09-24 15:35:16'),
	(120, 5, 'dsadddddddddddddddddddddddddddddddddddd', '2020-09-24 15:36:46'),
	(121, 5, 'dsdas', '2020-09-24 15:36:48'),
	(122, 5, 'dsadsa', '2020-09-24 15:36:54'),
	(123, 1, 'dasdsa', '2020-09-24 15:42:35'),
	(124, 1, '1', '2020-09-25 10:46:19'),
	(125, 1, '1', '2020-09-25 10:47:39'),
	(126, 1, '1', '2020-09-25 10:47:50'),
	(127, 1, '1', '2020-09-25 10:48:04'),
	(128, 6, 'daw', '2020-09-25 10:49:28'),
	(129, 6, 'awdaw', '2020-09-25 10:49:33'),
	(130, 1, '123', '2020-09-25 10:54:21'),
	(131, 1, '12', '2020-09-25 10:57:34'),
	(132, 1, '3', '2020-09-25 11:06:10'),
	(133, 1, '1', '2020-09-25 11:09:02'),
	(134, 1, '123', '2020-09-25 11:10:54'),
	(135, 1, '1233333333333', '2020-09-25 15:10:20'),
	(136, 3, '123123', '2020-09-25 16:58:35'),
	(137, 3, 'hihi', '2020-09-25 19:14:42'),
	(138, 3, 'hi', '2020-09-25 19:14:48'),
	(139, 3, 'ssss', '2020-09-25 19:14:55'),
	(140, 3, 'sss', '2020-09-25 19:14:58'),
	(141, 3, 'aaaaa', '2020-09-25 19:15:02'),
	(142, 1, '1', '2020-09-25 19:16:29'),
	(143, 1, '12', '2020-09-25 19:16:44'),
	(144, 1, '1', '2020-09-25 19:17:45'),
	(145, 1, '1212', '2020-09-25 19:18:00'),
	(146, 1, '12213', '2020-09-25 19:18:02'),
	(147, 1, '1', '2020-09-25 19:18:20'),
	(148, 1, '111', '2020-09-25 19:19:47'),
	(149, 1, '123213', '2020-09-25 19:19:51'),
	(150, 1, '1', '2020-09-25 19:21:02'),
	(151, 1, '1212', '2020-09-25 19:22:26'),
	(152, 1, '1', '2020-09-25 19:22:38'),
	(153, 3, 'hihi\n', '2020-09-25 19:24:16'),
	(154, 3, 'hello\n', '2020-09-25 19:24:56'),
	(155, 7, 'hihihihi', '2020-09-25 19:49:22'),
	(156, 7, 'ff', '2020-09-25 19:49:40'),
	(157, 7, 'jj', '2020-09-25 19:49:44'),
	(158, 7, 'o', '2020-09-25 19:49:48'),
	(159, 7, 'chihih\n', '2020-09-25 19:51:38'),
	(160, 7, 'hihi', '2020-09-25 19:51:48'),
	(161, 7, 'sss', '2020-09-25 19:52:11'),
	(162, 7, 'ssss', '2020-09-25 19:52:16'),
	(163, 1, '12', '2020-09-28 10:55:55'),
	(164, 7, '1', '2020-09-28 10:57:26'),
	(165, 7, '1', '2020-09-28 10:57:33'),
	(166, 7, '123', '2020-09-28 10:57:39'),
	(167, 7, '12', '2020-09-28 10:57:43'),
	(168, 7, '1', '2020-09-28 10:58:53'),
	(169, 13, '1', '2020-09-28 11:45:20'),
	(170, 13, '1', '2020-09-28 11:45:25'),
	(171, 13, '1', '2020-09-28 11:45:28'),
	(172, 13, '2', '2020-09-28 11:45:29'),
	(173, 13, '3', '2020-09-28 11:46:59'),
	(174, 13, '12', '2020-09-28 11:47:05'),
	(175, 13, '123', '2020-09-28 11:48:32'),
	(176, 13, '1', '2020-09-28 11:48:42'),
	(177, 13, '12', '2020-09-28 11:48:48'),
	(178, 13, '1', '2020-09-28 11:49:17'),
	(179, 13, '1', '2020-09-28 11:49:27'),
	(180, 13, '12', '2020-09-28 11:49:31'),
	(181, 5, 'testttt', '2020-09-28 13:12:43'),
	(182, 5, 'hello asd', '2020-09-28 13:12:53'),
	(183, 5, 'hello long ca', '2020-09-28 13:12:58'),
	(184, 5, 'test', '2020-09-28 13:13:39'),
	(185, 5, 'test', '2020-09-28 13:13:51'),
	(186, 5, 'alo ban', '2020-09-28 13:21:12'),
	(187, 5, 'minh nghe ne', '2020-09-28 13:21:16'),
	(188, 5, 'thang dau cat moi', '2020-09-28 13:21:23');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- Dumping structure for table ambi.chat_user
CREATE TABLE IF NOT EXISTS `chat_user` (
  `chatid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `isread` bit(1) NOT NULL,
  `isdelete` bit(1) NOT NULL,
  KEY `FK_chat_user_chatid_chat_chatid` (`chatid`),
  KEY `FK_chat_user_userid_user_userid` (`userid`),
  CONSTRAINT `FK_chat_user_chatid_chat_chatid` FOREIGN KEY (`chatid`) REFERENCES `chat` (`chatid`),
  CONSTRAINT `FK_chat_user_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.chat_user: ~169 rows (approximately)
/*!40000 ALTER TABLE `chat_user` DISABLE KEYS */;
INSERT INTO `chat_user` (`chatid`, `userid`, `isread`, `isdelete`) VALUES
	(20, 13, b'0', b'0'),
	(21, 13, b'0', b'0'),
	(22, 13, b'0', b'0'),
	(23, 13, b'0', b'0'),
	(24, 2, b'0', b'0'),
	(25, 2, b'0', b'0'),
	(26, 13, b'0', b'0'),
	(27, 2, b'0', b'0'),
	(28, 67, b'0', b'0'),
	(29, 1, b'0', b'0'),
	(30, 67, b'0', b'0'),
	(31, 3, b'0', b'0'),
	(32, 3, b'0', b'0'),
	(33, 3, b'0', b'0'),
	(34, 1, b'0', b'0'),
	(35, 3, b'0', b'0'),
	(36, 1, b'0', b'0'),
	(37, 1, b'0', b'0'),
	(38, 3, b'0', b'0'),
	(39, 67, b'0', b'0'),
	(40, 3, b'0', b'0'),
	(41, 67, b'0', b'0'),
	(42, 3, b'0', b'0'),
	(43, 3, b'0', b'0'),
	(44, 3, b'0', b'0'),
	(45, 13, b'0', b'0'),
	(46, 2, b'0', b'0'),
	(47, 13, b'0', b'0'),
	(48, 2, b'0', b'0'),
	(49, 3, b'0', b'0'),
	(50, 3, b'0', b'0'),
	(51, 13, b'0', b'0'),
	(52, 2, b'0', b'0'),
	(53, 2, b'0', b'0'),
	(54, 2, b'0', b'0'),
	(55, 2, b'0', b'0'),
	(56, 3, b'0', b'0'),
	(57, 3, b'0', b'0'),
	(58, 3, b'0', b'0'),
	(59, 3, b'0', b'0'),
	(60, 67, b'0', b'0'),
	(61, 3, b'0', b'0'),
	(62, 3, b'0', b'0'),
	(63, 67, b'0', b'0'),
	(64, 3, b'0', b'0'),
	(65, 3, b'0', b'0'),
	(66, 67, b'0', b'0'),
	(67, 67, b'0', b'0'),
	(68, 67, b'0', b'0'),
	(69, 67, b'0', b'0'),
	(70, 67, b'0', b'0'),
	(71, 3, b'0', b'0'),
	(72, 3, b'0', b'0'),
	(73, 3, b'0', b'0'),
	(74, 67, b'0', b'0'),
	(75, 67, b'0', b'0'),
	(76, 3, b'0', b'0'),
	(77, 67, b'0', b'0'),
	(78, 67, b'0', b'0'),
	(79, 3, b'0', b'0'),
	(80, 67, b'0', b'0'),
	(81, 67, b'0', b'0'),
	(82, 3, b'0', b'0'),
	(83, 3, b'0', b'0'),
	(84, 67, b'0', b'0'),
	(85, 3, b'0', b'0'),
	(86, 67, b'0', b'0'),
	(87, 67, b'0', b'0'),
	(88, 67, b'0', b'0'),
	(89, 67, b'0', b'0'),
	(90, 67, b'0', b'0'),
	(91, 3, b'0', b'0'),
	(92, 3, b'0', b'0'),
	(93, 67, b'0', b'0'),
	(94, 67, b'0', b'0'),
	(95, 3, b'0', b'0'),
	(96, 67, b'0', b'0'),
	(97, 3, b'0', b'0'),
	(98, 67, b'0', b'0'),
	(99, 13, b'0', b'0'),
	(100, 2, b'0', b'0'),
	(101, 1, b'0', b'0'),
	(102, 1, b'0', b'0'),
	(103, 1, b'0', b'0'),
	(104, 13, b'0', b'0'),
	(105, 2, b'0', b'0'),
	(106, 2, b'0', b'0'),
	(107, 2, b'0', b'0'),
	(108, 2, b'0', b'0'),
	(109, 13, b'0', b'0'),
	(110, 13, b'0', b'0'),
	(111, 13, b'0', b'0'),
	(112, 13, b'0', b'0'),
	(113, 13, b'0', b'0'),
	(114, 1, b'0', b'0'),
	(115, 2, b'0', b'0'),
	(116, 13, b'0', b'0'),
	(117, 13, b'0', b'0'),
	(118, 13, b'0', b'0'),
	(119, 1, b'0', b'0'),
	(120, 1, b'0', b'0'),
	(121, 1, b'0', b'0'),
	(122, 1, b'0', b'0'),
	(123, 2, b'0', b'0'),
	(124, 13, b'0', b'0'),
	(125, 13, b'0', b'0'),
	(126, 13, b'0', b'0'),
	(127, 13, b'0', b'0'),
	(128, 3, b'0', b'0'),
	(129, 67, b'0', b'0'),
	(130, 13, b'0', b'0'),
	(131, 13, b'0', b'0'),
	(132, 13, b'0', b'0'),
	(133, 13, b'0', b'0'),
	(134, 13, b'0', b'0'),
	(135, 13, b'0', b'0'),
	(136, 22, b'0', b'0'),
	(137, 1, b'0', b'0'),
	(138, 89, b'0', b'0'),
	(139, 89, b'0', b'0'),
	(140, 1, b'0', b'0'),
	(141, 1, b'0', b'0'),
	(142, 13, b'0', b'0'),
	(143, 13, b'0', b'0'),
	(144, 2, b'0', b'0'),
	(145, 2, b'0', b'0'),
	(146, 13, b'0', b'0'),
	(147, 13, b'0', b'0'),
	(148, 2, b'0', b'0'),
	(149, 13, b'0', b'0'),
	(150, 13, b'0', b'0'),
	(151, 2, b'0', b'0'),
	(152, 13, b'0', b'0'),
	(153, 89, b'0', b'0'),
	(154, 1, b'0', b'0'),
	(155, 90, b'0', b'0'),
	(156, 90, b'0', b'0'),
	(157, 90, b'0', b'0'),
	(158, 90, b'0', b'0'),
	(159, 90, b'0', b'0'),
	(160, 1, b'0', b'0'),
	(161, 90, b'0', b'0'),
	(162, 1, b'0', b'0'),
	(163, 13, b'0', b'0'),
	(164, 90, b'0', b'0'),
	(165, 1, b'0', b'0'),
	(166, 90, b'0', b'0'),
	(167, 1, b'0', b'0'),
	(168, 1, b'0', b'0'),
	(169, 2, b'0', b'0'),
	(170, 2, b'0', b'0'),
	(171, 90, b'0', b'0'),
	(172, 90, b'0', b'0'),
	(173, 2, b'0', b'0'),
	(174, 90, b'0', b'0'),
	(175, 2, b'0', b'0'),
	(176, 2, b'0', b'0'),
	(177, 90, b'0', b'0'),
	(178, 2, b'0', b'0'),
	(179, 2, b'0', b'0'),
	(180, 90, b'0', b'0'),
	(181, 67, b'0', b'0'),
	(182, 1, b'0', b'0'),
	(183, 67, b'0', b'0'),
	(184, 1, b'0', b'0'),
	(185, 67, b'0', b'0'),
	(186, 1, b'0', b'0'),
	(187, 67, b'0', b'0'),
	(188, 1, b'0', b'0');
/*!40000 ALTER TABLE `chat_user` ENABLE KEYS */;

-- Dumping structure for table ambi.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `commentdate` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  `isdelete` bit(1) DEFAULT NULL,
  `remotion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FK_comment_postid_post_postid` (`postid`),
  KEY `FK_comment_userid_user_userid` (`userid`),
  CONSTRAINT `FK_comment_postid_post_postid` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`),
  CONSTRAINT `FK_comment_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=336 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.comment: ~136 rows (approximately)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`commentid`, `content`, `commentdate`, `userid`, `postid`, `isdelete`, `remotion`) VALUES
	(1, 'Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow', '2020-08-31 11:16:27', 2, 1, b'0', NULL),
	(2, 'haha', '2020-08-28 11:16:52', 5, 1, b'0', NULL),
	(3, 'hihi', '2020-08-30 11:17:07', 3, 1, b'0', NULL),
	(4, 'tests', '2020-08-27 10:26:43', 1, 1, b'0', '123'),
	(5, 'Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow', '2020-09-04 18:01:11', 22, 16, b'0', NULL),
	(6, 'ccccc', '2020-09-04 18:02:32', 22, 16, b'0', NULL),
	(51, '12312', '2020-09-08 11:33:22', 22, 16, b'0', 'qwe'),
	(52, '123213', '2020-09-08 13:24:41', 22, 16, b'0', 'qwe'),
	(54, 'test123456', '2020-09-08 13:27:05', 13, 17, b'0', 'qwe'),
	(73, '123123', '2020-09-13 18:11:58', 1, 1, b'0', 'qwe'),
	(74, '1', '2020-09-08 18:12:02', 1, 1, b'0', 'qwe'),
	(75, '2321', '2020-09-11 18:12:03', 1, 1, b'0', 'qwe'),
	(76, '321321534634', '2020-09-08 18:12:06', 1, 1, b'0', 'qwe'),
	(77, '213213', '2020-09-10 18:12:22', 1, 1, b'0', 'qwe'),
	(78, 't3wtw3', '2020-09-08 18:12:43', 1, 1, b'0', 'qwe'),
	(79, 'teststt', '2020-09-08 18:12:55', 1, 1, b'0', 'qwe'),
	(131, 'f3', '2020-09-08 19:14:22', 22, 16, b'0', 'qwe'),
	(132, '123123', '2020-09-08 19:16:25', 13, 16, b'0', 'qwe'),
	(133, '123123', '2020-09-08 19:16:38', 22, 16, b'0', 'qwe'),
	(196, '12323', '2020-09-10 18:00:17', 1, 17, b'0', 'qwe'),
	(197, '123', '2020-09-10 18:17:45', 2, 17, b'0', 'qwe'),
	(198, '123', '2020-09-10 18:21:57', 10, 17, b'0', 'qwe'),
	(199, '123213', '2020-09-10 18:22:49', 67, 17, b'0', 'qwe'),
	(200, '12312', '2020-09-10 18:23:09', 16, 17, b'0', 'qwe'),
	(201, '1231', '2020-09-10 18:24:14', 2, 17, b'0', 'qwe'),
	(202, '123123', '2020-09-10 18:25:34', 22, 17, b'0', 'qwe'),
	(203, '123123', '2020-09-10 19:02:47', 22, 17, b'0', 'qwe'),
	(204, 'huhu\n', '2020-09-10 20:15:42', 2, 19, b'0', 'qwe'),
	(205, 'awdaw', '2020-09-11 20:01:05', 2, 19, b'0', 'qwe'),
	(206, '1231', '2020-09-11 20:05:06', 13, 19, b'0', 'qwe'),
	(207, 'asdasdasdasd', '2020-09-15 18:26:58', 2, 2, b'0', 'qwe'),
	(208, '...', '2020-09-15 18:29:27', 2, 2, b'0', 'qwe'),
	(209, '', '2020-09-17 10:03:39', 2, 18, b'0', 'qwe'),
	(210, 'xinh qua <3', '2020-09-17 10:13:07', 2, 3, b'0', 'qwe'),
	(213, 'haha', '2020-09-18 18:19:40', 3, 59, b'0', 'qwe'),
	(215, 'dsadsads', '2020-09-18 18:27:58', 3, 59, b'0', 'qwe'),
	(216, 'dsadas', '2020-09-18 18:28:00', 3, 59, b'0', 'qwe'),
	(217, 'dsadsa', '2020-09-18 18:28:01', 3, 59, b'0', 'qwe'),
	(218, 'dsadsad', '2020-09-18 18:28:02', 3, 59, b'0', 'qwe'),
	(219, 'dsadsa', '2020-09-18 18:28:04', 3, 59, b'0', 'qwe'),
	(220, 'dasdas', '2020-09-18 18:28:05', 3, 59, b'0', 'qwe'),
	(221, 'dasdsa\n', '2020-09-18 19:53:52', 3, 59, b'0', 'qwe'),
	(222, 'afawfawf', '2020-09-18 19:54:21', 67, 51, b'0', 'qwe'),
	(223, 'hi', '2020-09-18 19:54:38', 1, 19, b'0', 'qwe'),
	(224, '...', '2020-09-21 10:45:12', 2, 57, b'0', 'qwe'),
	(225, '', '2020-09-21 15:45:01', 2, 87, b'0', 'qwe'),
	(226, '', '2020-09-21 15:47:25', 2, 19, b'0', 'qwe'),
	(227, '', '2020-09-21 15:47:26', 2, 19, b'0', 'qwe'),
	(228, '', '2020-09-21 15:47:27', 2, 19, b'0', 'qwe'),
	(229, '', '2020-09-21 15:47:27', 2, 19, b'0', 'qwe'),
	(230, 'safdsgfdggf', '2020-09-21 15:47:37', 2, 19, b'0', 'qwe'),
	(231, 'dafdafdadfdsgds', '2020-09-21 15:47:45', 2, 19, b'0', 'qwe'),
	(232, 'asfsgdrhdthp-esiyghp[srkg;lahuiw\n', '2020-09-21 15:47:56', 2, 19, b'0', 'qwe'),
	(233, 'vtgvv5y5t', '2020-09-21 15:48:11', 2, 87, b'0', 'qwe'),
	(234, '', '2020-09-21 15:48:39', 67, 51, b'0', 'qwe'),
	(235, 'Hi', '2020-09-21 18:33:47', 15, 19, b'0', 'qwe'),
	(236, 'sa', '2020-09-21 19:06:11', 2, 19, b'0', 'qwe'),
	(237, 'No', '2020-09-21 19:09:22', 13, 19, b'0', 'qwe'),
	(238, 'Nahhhhhhhhhhhhhhhh', '2020-09-21 19:10:40', 15, 19, b'0', 'qwe'),
	(239, 'Nah cc', '2020-09-21 19:11:54', 2, 19, b'0', 'qwe'),
	(240, 'love u Lisa', '2020-09-21 19:18:20', 2, 19, b'0', 'qwe'),
	(241, '...', '2020-09-21 19:21:29', 2, 19, b'0', 'qwe'),
	(242, 'ok', '2020-09-21 19:34:19', 2, 19, b'0', 'qwe'),
	(243, 'dasda', '2020-09-22 08:23:30', 67, 93, b'0', 'qwe'),
	(244, 'dasdas', '2020-09-22 08:35:16', 1, 93, b'0', 'qwe'),
	(245, '123', '2020-09-22 10:32:21', 2, 93, b'0', 'qwe'),
	(246, 'awd', '2020-09-22 10:52:06', 67, 59, b'0', 'qwe'),
	(247, 'hey du com hia let mi si do neo', '2020-09-22 11:49:19', 2, 18, b'0', 'qwe'),
	(248, 'What...', '2020-09-22 13:18:54', 13, 18, b'0', 'qwe'),
	(249, 'Whats wrong?', '2020-09-22 13:19:52', 13, 18, b'0', 'qwe'),
	(250, 'Ok', '2020-09-22 13:21:14', 13, 18, b'0', 'qwe'),
	(251, 'WWWWW', '2020-09-22 13:22:16', 13, 18, b'0', 'qwe'),
	(252, 'So beautiful honey', '2020-09-22 13:23:13', 2, 18, b'0', 'qwe'),
	(253, 'OK', '2020-09-22 15:03:55', 2, 19, b'0', 'qwe'),
	(254, 'Ok Long', '2020-09-22 15:24:55', 2, 98, b'0', 'qwe'),
	(255, '.', '2020-09-22 15:40:43', 2, 95, b'0', 'qwe'),
	(256, 'ok', '2020-09-22 15:42:24', 2, 1, b'0', 'qwe'),
	(257, 'asdad', '2020-09-22 15:53:26', 2, 98, b'0', 'qwe'),
	(258, '1232', '2020-09-22 15:53:53', 2, 98, b'0', 'qwe'),
	(259, '1231', '2020-09-22 16:02:46', 2, 93, b'0', 'qwe'),
	(260, '1232', '2020-09-22 16:56:41', 2, 98, b'0', 'qwe'),
	(261, '123123', '2020-09-22 16:58:02', 2, 98, b'0', 'qwe'),
	(262, '123123', '2020-09-22 16:58:43', 67, 93, b'0', 'qwe'),
	(263, 'long fix\n', '2020-09-22 16:59:39', 3, 98, b'0', 'qwe'),
	(264, 'testtt\n', '2020-09-22 17:00:31', 67, 98, b'0', 'qwe'),
	(265, 'hello\n', '2020-09-22 17:00:43', 3, 98, b'0', 'qwe'),
	(266, 'fsadas', '2020-09-22 17:01:00', 67, 98, b'0', 'qwe'),
	(267, 'hdhashdas', '2020-09-22 17:02:28', 67, 98, b'0', 'qwe'),
	(268, '123123', '2020-09-22 17:04:06', 67, 93, b'0', 'qwe'),
	(269, '123123', '2020-09-22 17:04:42', 67, 93, b'0', 'qwe'),
	(270, '123', '2020-09-22 17:55:49', 1, 98, b'0', 'qwe'),
	(271, '1111', '2020-09-22 18:04:05', 2, 98, b'0', 'qwe'),
	(272, '1', '2020-09-22 18:04:19', 2, 98, b'0', 'qwe'),
	(273, '1', '2020-09-22 18:04:29', 2, 98, b'0', 'qwe'),
	(274, '1', '2020-09-22 18:05:11', 2, 98, b'0', 'qwe'),
	(275, '123123', '2020-09-22 18:25:18', 2, 98, b'0', 'qwe'),
	(276, '1', '2020-09-22 18:31:19', 2, 98, b'0', 'qwe'),
	(277, '11', '2020-09-22 18:32:18', 2, 98, b'0', 'qwe'),
	(278, '1111', '2020-09-22 18:32:36', 2, 98, b'0', 'qwe'),
	(279, '1', '2020-09-22 18:33:55', 2, 98, b'0', 'qwe'),
	(280, '1', '2020-09-22 18:37:05', 2, 98, b'0', 'qwe'),
	(281, '`11111', '2020-09-22 18:38:55', 2, 98, b'0', 'qwe'),
	(282, '1', '2020-09-22 18:41:29', 2, 98, b'0', 'qwe'),
	(283, '1', '2020-09-22 18:41:56', 2, 98, b'0', 'qwe'),
	(284, '...', '2020-09-23 11:41:42', 1, 51, b'0', 'qwe'),
	(285, 'dawda', '2020-09-23 11:45:29', 13, 18, b'0', 'qwe'),
	(286, 'asda', '2020-09-23 11:45:35', 13, 18, b'0', 'qwe'),
	(287, 'dasda', '2020-09-23 11:45:41', 13, 18, b'0', 'qwe'),
	(288, 'adawfawhtbcg', '2020-09-23 11:46:00', 67, 55, b'0', 'qwe'),
	(289, 'asdas', '2020-09-23 11:46:25', 67, 93, b'0', 'qwe'),
	(290, 'nbnb', '2020-09-23 11:46:35', 6, 87, b'0', 'qwe'),
	(291, 'adwdaw', '2020-09-23 11:46:39', 67, 93, b'0', 'qwe'),
	(292, 'adwd', '2020-09-23 11:54:36', 40, 61, b'0', 'qwe'),
	(293, 'adaw', '2020-09-23 11:54:42', 40, 61, b'0', 'qwe'),
	(294, '321321321', '2020-09-23 11:58:47', 6, 100, b'0', 'qwe'),
	(295, '123123', '2020-09-23 11:59:17', 6, 100, b'0', 'qwe'),
	(296, '123123', '2020-09-23 11:59:19', 6, 100, b'0', 'qwe'),
	(297, 'so beautiful', '2020-09-23 16:17:19', 40, 62, b'0', 'qwe'),
	(298, 'daw', '2020-09-24 11:40:37', 67, 19, b'0', 'qwe'),
	(312, 'HOHOHOHOOH', '2020-09-25 16:27:19', 2, 19, b'0', 'qwe'),
	(313, 'CC', '2020-09-25 17:12:20', 83, 104, b'0', 'qwe'),
	(314, 'con cho thien\n', '2020-09-25 19:04:33', 1, 49, b'0', 'qwe'),
	(315, 'xinh ', '2020-09-25 19:05:45', 1, 105, b'0', 'qwe'),
	(316, 'hello a', '2020-09-25 19:34:29', 1, 49, b'0', 'qwe'),
	(317, 'thien khung', '2020-09-25 19:39:05', 90, 55, b'0', 'qwe'),
	(318, 'hihi dethuong ghe', '2020-09-25 19:41:43', 90, 115, b'0', 'qwe'),
	(319, 'dung oi', '2020-09-25 19:42:03', 1, 115, b'0', 'qwe'),
	(320, 'ahihi\n', '2020-09-25 19:42:40', 1, 115, b'0', 'qwe'),
	(321, 'hihi', '2020-09-25 19:43:27', 1, 115, b'0', 'qwe'),
	(322, 'hhh', '2020-09-25 19:44:23', 1, 107, b'0', 'qwe'),
	(323, 'CHI CẮT MOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII', '2020-09-25 19:51:37', 90, 116, b'0', 'qwe'),
	(324, 'tam hon dep', '2020-09-25 19:55:00', 90, 19, b'0', 'qwe'),
	(325, '5000$', '2020-09-25 19:55:49', 90, 16, b'0', 'qwe'),
	(326, 'hihihi', '2020-09-25 19:56:49', 90, 101, b'0', 'qwe'),
	(329, 'dau cat moi!!!', '2020-09-28 13:11:40', 67, 119, b'0', 'qwe'),
	(330, 'hello moi nguoi', '2020-09-28 13:20:55', 67, 120, b'0', 'qwe');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- Dumping structure for table ambi.conversation
CREATE TABLE IF NOT EXISTS `conversation` (
  `conid` int(11) NOT NULL AUTO_INCREMENT,
  `ownerid` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`conid`),
  KEY `FK_conversation_ownerid_user_userid` (`ownerid`),
  CONSTRAINT `FK_conversation_ownerid_user_userid` FOREIGN KEY (`ownerid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.conversation: ~14 rows (approximately)
/*!40000 ALTER TABLE `conversation` DISABLE KEYS */;
INSERT INTO `conversation` (`conid`, `ownerid`, `title`) VALUES
	(1, 2, NULL),
	(3, 4, NULL),
	(4, 22, NULL),
	(5, 67, NULL),
	(6, 67, NULL),
	(7, 3, NULL),
	(8, 82, NULL),
	(9, NULL, NULL),
	(10, 2, NULL),
	(11, 2, NULL),
	(12, 2, NULL),
	(13, 2, NULL),
	(14, 6, NULL),
	(15, 90, NULL);
/*!40000 ALTER TABLE `conversation` ENABLE KEYS */;

-- Dumping structure for table ambi.conversation_user
CREATE TABLE IF NOT EXISTS `conversation_user` (
  `conid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  KEY `FK_conversation_user_userid_user_userid` (`userid`),
  KEY `FK_conversation_user_conid_conversation_conid` (`conid`),
  CONSTRAINT `FK_conversation_user_conid_conversation_conid` FOREIGN KEY (`conid`) REFERENCES `conversation` (`conid`),
  CONSTRAINT `FK_conversation_user_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.conversation_user: ~20 rows (approximately)
/*!40000 ALTER TABLE `conversation_user` DISABLE KEYS */;
INSERT INTO `conversation_user` (`conid`, `userid`) VALUES
	(1, 2),
	(1, 13),
	(3, 1),
	(3, 89),
	(4, 5),
	(4, 22),
	(3, 13),
	(4, 16),
	(5, 1),
	(5, 67),
	(6, 67),
	(6, 3),
	(7, 90),
	(7, 1),
	(13, 2),
	(13, 90),
	(14, 6),
	(14, 90),
	(15, 90),
	(15, 6);
/*!40000 ALTER TABLE `conversation_user` ENABLE KEYS */;

-- Dumping structure for table ambi.friend
CREATE TABLE IF NOT EXISTS `friend` (
  `friendid` int(11) NOT NULL AUTO_INCREMENT,
  `user1id` int(11) NOT NULL,
  `user2id` int(11) NOT NULL,
  `reid` int(11) NOT NULL,
  PRIMARY KEY (`friendid`),
  KEY `FK_friend_reid_relationship_reid` (`reid`),
  KEY `FK_friend_user2id_user_userid` (`user2id`),
  KEY `FK_friend_use1id_user_userid` (`user1id`) USING BTREE,
  CONSTRAINT `FK_friend_reid_relationship_reid` FOREIGN KEY (`reid`) REFERENCES `relationship` (`reid`),
  CONSTRAINT `FK_friend_user` FOREIGN KEY (`user1id`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_friend_user2id_user_userid` FOREIGN KEY (`user2id`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10180 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.friend: ~37 rows (approximately)
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` (`friendid`, `user1id`, `user2id`, `reid`) VALUES
	(6, 4, 5, 2),
	(10004, 22, 1, 2),
	(10005, 2, 13, 2),
	(10014, 4, 67, 2),
	(10015, 4, 3, 2),
	(10020, 10, 2, 2),
	(10022, 15, 2, 2),
	(10024, 1, 2, 2),
	(10025, 6, 13, 2),
	(10026, 22, 13, 2),
	(10028, 6, 2, 2),
	(10029, 6, 5, 2),
	(10031, 40, 1, 2),
	(10034, 4, 2, 2),
	(10085, 1, 3, 2),
	(10131, 6, 67, 2),
	(10136, 67, 2, 2),
	(10137, 67, 3, 2),
	(10142, 3, 6, 2),
	(10143, 67, 1, 2),
	(10157, 6, 4, 1),
	(10158, 69, 2, 2),
	(10159, 69, 5, 1),
	(10160, 82, 2, 2),
	(10161, 82, 1, 2),
	(10162, 22, 2, 2),
	(10163, 89, 1, 2),
	(10164, 89, 40, 1),
	(10165, 1, 13, 1),
	(10168, 1, 90, 2),
	(10169, 1, 16, 1),
	(10170, 90, 3, 1),
	(10171, 90, 82, 1),
	(10175, 90, 2, 2),
	(10177, 67, 90, 1),
	(10178, 67, 13, 2),
	(10179, 90, 6, 1);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;

-- Dumping structure for table ambi.icon
CREATE TABLE IF NOT EXISTS `icon` (
  `iconid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`iconid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.icon: ~0 rows (approximately)
/*!40000 ALTER TABLE `icon` DISABLE KEYS */;
/*!40000 ALTER TABLE `icon` ENABLE KEYS */;

-- Dumping structure for table ambi.image
CREATE TABLE IF NOT EXISTS `image` (
  `imageid` int(11) NOT NULL AUTO_INCREMENT,
  `imgname` varchar(100) NOT NULL,
  `description` varchar(45) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `postid` int(11) DEFAULT NULL,
  PRIMARY KEY (`imageid`) USING BTREE,
  KEY `FK_image_userid_user_userid` (`userid`),
  KEY `FK_image_postid_post_postid` (`postid`),
  CONSTRAINT `FK_image_postid_post_postid` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`),
  CONSTRAINT `FK_image_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.image: ~32 rows (approximately)
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` (`imageid`, `imgname`, `description`, `userid`, `postid`) VALUES
	(1, '201793410c19-8aab-4e2b-b56b-940fd7590598.png', '12132131', NULL, 2),
	(2, 'lisa21557298567width640height754_UKPA.jpg', '123123', NULL, 1),
	(3, 'tzuyu11557301517width1080height1349_CCTG.jpg', 'asdasd', NULL, 3),
	(4, 'tzuyu11557301517width1080height1349_CCTG.jpg', '123213', NULL, 16),
	(5, 'lisa21557298567width640height754_UKPA.jpg', '123123', NULL, 17),
	(6, '201793410c19-8aab-4e2b-b56b-940fd7590598.png', '123123', NULL, 18),
	(7, '201793410c19-8aab-4e2b-b56b-940fd7590598.png', '3123213', NULL, 19),
	(20, '0cf92b77952347.5c96d8498d6f0.jpg', '341521.0', NULL, 58),
	(21, '1d561f77952347.5c96d8493dc20.jpg', '250497.0', NULL, 59),
	(26, 'tzuyu-twice-qua-khong-ho-danh-la-my-nhan-dep-nhat-the-gioi15-5f6363d235ca9.jpg', '123123', NULL, 62),
	(27, 'tzuyu-twice-qua-khong-ho-danh-la-my-nhan-dep-nhat-the-gioi4-5f6363842f61c.jpg', '12312312', NULL, 61),
	(28, 'tzuyu-twice-qua-khong-ho-danh-la-my-nhan-dep-nhat-the-gioi1-5f63637456585.jpg', '123123', NULL, 63),
	(35, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 93),
	(36, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 98),
	(37, 'logo.png', '197402.0', NULL, 99),
	(38, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 102),
	(39, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 103),
	(40, '119218762_10157811263648590_7511150450765753872_n.jpg', 'a', NULL, 104),
	(41, '118960082_10157811263513590_37080201354678103_n.jpg', 'bbb', NULL, 105),
	(42, '103822600_576825642986723_6268319965592544477_n.jpg', '103567.0', NULL, 106),
	(43, '72275358_130641914990743_8116056397667368960_n.png', 'ann', NULL, 107),
	(44, '69698296_530690920806121_7150606036527742976_o.jpg', 'ann', NULL, 108),
	(45, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 109),
	(46, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 110),
	(47, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 112),
	(48, 'Test 4.jpg', '192821.0', NULL, 113),
	(49, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 114),
	(50, 'sweet-sugar.jpg', '82049.0', NULL, 115),
	(51, 'Test 6.jpg', '216708.0', NULL, 49),
	(52, 'lisa21557298567width640height754_UKPA.jpg', '81946.0', NULL, 118),
	(53, '201793410c19-8aab-4e2b-b56b-940fd7590598.png', '868243.0', NULL, 119),
	(54, '201793410c19-8aab-4e2b-b56b-940fd7590598.png', '868243.0', NULL, 120);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;

-- Dumping structure for table ambi.like
CREATE TABLE IF NOT EXISTS `like` (
  `likeid` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`likeid`),
  KEY `FK_like_postid_post_postid` (`postid`),
  KEY `FK_like_userid_user_userid` (`userid`),
  CONSTRAINT `FK_like_postid_post_postid` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`),
  CONSTRAINT `FK_like_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.like: ~59 rows (approximately)
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
INSERT INTO `like` (`likeid`, `postid`, `userid`) VALUES
	(111, 51, 3),
	(112, 50, 3),
	(113, 49, 3),
	(114, 1, 3),
	(115, 3, 3),
	(116, 2, 3),
	(131, 57, 6),
	(132, 19, 6),
	(134, 18, 6),
	(135, 87, 6),
	(151, 58, 3),
	(188, 98, 3),
	(191, 59, 6),
	(192, 101, 2),
	(193, 59, 1),
	(194, 61, 1),
	(195, 62, 1),
	(196, 63, 1),
	(197, 93, 1),
	(198, 97, 1),
	(199, 98, 1),
	(200, 93, 6),
	(201, 58, 6),
	(202, 101, 6),
	(203, 100, 6),
	(204, 55, 6),
	(207, 62, 40),
	(208, 61, 40),
	(209, 98, 6),
	(210, 102, 6),
	(212, 99, 2),
	(213, 105, 6),
	(232, 108, 13),
	(233, 106, 3),
	(234, 101, 3),
	(236, 108, 15),
	(237, 59, 3),
	(246, 93, 3),
	(265, 103, 3),
	(275, 108, 6),
	(276, 103, 6),
	(278, 107, 6),
	(279, 104, 6),
	(281, 55, 3),
	(288, 113, 1),
	(289, 49, 1),
	(290, 115, 90),
	(291, 112, 1),
	(292, 111, 1),
	(293, 50, 1),
	(294, 16, 90),
	(295, 103, 67),
	(301, 119, 67),
	(302, 119, 6),
	(303, 120, 67),
	(304, 120, 1),
	(305, 120, 6),
	(306, 112, 6),
	(307, 108, 2);
/*!40000 ALTER TABLE `like` ENABLE KEYS */;

-- Dumping structure for procedure ambi.list_mutual
DELIMITER //
CREATE PROCEDURE `list_mutual`(
	IN `myid` INT(11),
	IN `fid` INT(11)
)
BEGIN
	SELECT u.* FROM user u
	INNER JOIN 
	(SELECT f.user1id, f.user2id, f.reid FROM friend f WHERE f.user1id in ( 
	SELECT f2.user2id FROM friend f2 WHERE f2.user1id = myid AND f.reid =2
	) OR f.user2id in ( 
	SELECT f2.user2id FROM friend f2 WHERE f2.user1id = myid AND f.reid =2
	) OR f.user2id in ( 
	SELECT f2.user1id FROM friend f2 WHERE f2.user2id = myid AND f.reid =2
	) OR f.user1id in (
	SELECT f2.user1id FROM friend f2 WHERE f2.user2id = myid AND f.reid =2
	) GROUP BY f.friendid HAVING f.reid =2) AS l
ON u.userid = l.user1id OR u.userid = l.user2id
WHERE l.user1id = fid OR l.user2id = fid 
GROUP BY u.userid
HAVING u.userid !=fid AND u.userid !=myid;
END//
DELIMITER ;

-- Dumping structure for table ambi.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuid`),
  KEY `FK_menu_categoryid_category_categoryid` (`categoryid`),
  CONSTRAINT `FK_menu_categoryid_category_categoryid` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.menu: ~5 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`menuid`, `name`, `description`, `categoryid`) VALUES
	(1, 'Dashboard', 'dashboard', 1),
	(2, 'User list', 'user', 1),
	(3, 'Post', 'post', 1),
	(4, 'Notifications', 'notifications', 1),
	(5, 'Map', 'map', 1);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for procedure ambi.mutual_friend
DELIMITER //
CREATE PROCEDURE `mutual_friend`(
	IN `id` INT(11)
)
BEGIN
	SELECT  u.*, COUNT(*) AS mutual FROM user u
	INNER JOIN 
	(SELECT f.user1id,f.user2id, f.reid FROM friend f WHERE f.user1id in ( 
	SELECT f2.user2id FROM friend f2 WHERE f2.user1id = id AND f.reid =2
	) OR f.user2id in ( 
	SELECT f2.user2id FROM friend f2 WHERE f2.user1id = id AND f.reid =2
	) OR f.user2id in ( 
	SELECT f2.user1id FROM friend f2 WHERE f2.user2id = id AND f.reid =2
	) OR f.user1id in (
	SELECT f2.user1id FROM friend f2 WHERE f2.user2id = id AND f.reid =2
	) GROUP BY f.friendid HAVING f.reid =2) l
	ON 
	u.userid NOT IN
	(SELECT f.user1id FROM friend f WHERE f.user2id = id)
	WHERE 
	u.userid = l.user1id
	OR u.userid = l.user2id
	GROUP BY u.userid
	HAVING u.userid != id
	AND
	u.userid NOT IN
	(SELECT f.user2id FROM friend f WHERE f.user1id = id)
	Order By mutual DESC
	LIMIT 6;
END//
DELIMITER ;

-- Dumping structure for table ambi.notifications
CREATE TABLE IF NOT EXISTS `notifications` (
  `notiid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `isread` bit(1) DEFAULT NULL,
  `notidate` datetime DEFAULT NULL,
  `content` text DEFAULT NULL,
  `memo` int(11) DEFAULT NULL,
  `notitypeid` int(11) DEFAULT NULL,
  `iduseractor` int(11) DEFAULT NULL,
  `quant` int(11) DEFAULT NULL,
  PRIMARY KEY (`notiid`) USING BTREE,
  KEY `FK_notifications_user_id_user_userid` (`userid`) USING BTREE,
  KEY `FK_notifications_noti_type` (`notitypeid`) USING BTREE,
  KEY `FK_notifications_user_2` (`iduseractor`),
  CONSTRAINT `FK_notifications_noti_type` FOREIGN KEY (`notitypeid`) REFERENCES `noti_type` (`notitypeid`),
  CONSTRAINT `FK_notifications_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_notifications_user_2` FOREIGN KEY (`iduseractor`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.notifications: ~83 rows (approximately)
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` (`notiid`, `userid`, `isread`, `notidate`, `content`, `memo`, `notitypeid`, `iduseractor`, `quant`) VALUES
	(5, 2, b'1', '2020-09-21 10:35:16', '', 0, 2, 16, NULL),
	(6, 2, b'1', '2020-09-21 11:06:47', '', 0, 2, 22, NULL),
	(7, 67, b'1', '2020-09-21 11:07:52', '', 0, 2, 16, NULL),
	(8, 2, b'1', '2020-09-25 19:55:10', 'bichchiit1701@gmail.com and 6 other people', 19, 3, 90, 6),
	(10, 1, b'0', '2020-09-25 19:55:10', 'bichchiit1701@gmail.com and 5 other people comment on Duc\'s post', 19, 3, 90, 5),
	(11, 13, b'0', '2020-09-25 19:55:10', 'bichchiit1701@gmail.com and 5 other people comment on Duc\'s post', 19, 3, 90, 5),
	(12, 15, b'0', '2020-09-25 19:55:10', 'bichchiit1701@gmail.com and 2 other people comment on Duc\'s post', 19, 3, 90, 2),
	(13, 3, b'0', '2020-09-22 08:16:51', '', 0, 2, 6, 0),
	(14, 67, b'0', '2020-09-22 16:02:46', 'Duc and 1 other people', 93, 3, 2, 1),
	(66, 1, b'0', '2020-09-23 11:46:39', 'Long comment on his post', 93, 3, 67, 1),
	(67, 6, b'0', '2020-09-22 10:36:47', 'Long', 87, 3, 67, 1),
	(68, 2, b'1', '2020-09-23 11:46:35', 'Truong and 1 other people comment on Truong\'s post', 87, 3, 6, 1),
	(69, 3, b'0', '2020-09-22 10:52:06', 'Long', 59, 3, 67, 1),
	(70, 13, b'0', '2020-09-23 11:45:41', 'Long and 4 other people', 18, 3, 67, 4),
	(72, 2, b'1', '2020-09-23 11:45:41', 'Long and 4 other people comment on Lalisa\'s post', 18, 3, 67, 4),
	(73, 1, b'0', '2020-09-22 13:38:38', '', 0, 2, 67, 0),
	(74, 67, b'0', '2020-09-22 18:41:56', 'Duc and 1 other people', 98, 3, 2, 1),
	(75, 10, b'0', '2020-09-22 15:40:43', 'Duc', 95, 3, 2, 1),
	(76, 1, b'0', '2020-09-22 15:42:24', 'Duc', 1, 3, 2, 1),
	(77, 22, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(78, 4, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(79, 67, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(80, 5, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(81, 16, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(82, 3, b'0', '2020-09-22 15:42:24', 'Duc comment on asdpham\'s post', 1, 3, 2, 1),
	(96, 2, b'1', '2020-09-23 11:46:40', 'Long comment on his post', 93, 3, 67, 1),
	(97, 2, b'1', '2020-09-22 17:55:49', 'asdpham and 1 other people comment on Long\'s post', 98, 3, 1, 1),
	(98, 3, b'0', '2020-09-22 18:41:56', 'Duc and 1 other people comment on Long\'s post', 98, 3, 2, 1),
	(99, 1, b'0', '2020-09-22 18:41:56', 'Duc and 1 other people comment on Long\'s post', 98, 3, 2, 1),
	(100, 1, b'0', '2020-09-23 11:41:42', 'Duc', 51, 3, 2, 1),
	(101, 67, b'0', '2020-09-23 11:41:42', 'Duc comment on asdpham\'s post', 51, 3, 2, 1),
	(102, 3, b'0', '2020-09-25 19:39:05', 'bichchiit1701@gmail.com and 1 other people', 55, 3, 90, 1),
	(103, 67, b'0', '2020-09-23 11:46:35', 'Truong comment on Truong\'s post', 87, 3, 6, 1),
	(104, 40, b'0', '2020-09-23 11:55:11', 'Long and 4 other people', 61, 3, 67, 4),
	(105, 4, b'1', '2020-09-23 11:58:46', '', 0, 2, 6, 0),
	(106, 6, b'0', '2020-09-23 11:59:19', 'Duc and 4 other people', 100, 3, 2, 4),
	(107, 67, b'1', '2020-09-25 19:55:10', 'bichchiit1701@gmail.com and 2 other people comment on Duc\'s post', 19, 3, 90, 2),
	(108, 2, b'1', '2020-09-28 16:17:20', 'Long and 1 other people', 108, 3, 67, 1),
	(109, 2, b'1', '2020-09-25 14:16:14', '', 0, 2, 69, 0),
	(110, 5, b'0', '2020-09-25 14:16:21', '', 0, 2, 69, 0),
	(111, 2, b'1', '2020-09-25 18:17:14', 'Truong and 3 other people ', 108, 1, 6, 3),
	(112, 2, b'1', '2020-09-25 16:27:10', '', 0, 2, 82, 0),
	(113, 1, b'0', '2020-09-25 16:27:37', '', 0, 2, 82, 0),
	(114, 2, b'1', '2020-09-25 17:12:20', 'a@gmail.com', 104, 3, 83, 1),
	(115, 83, b'0', '2020-09-25 17:12:48', 'Duc comment on Duc\'s post', 104, 3, 2, 1),
	(116, 67, b'0', '2020-09-25 18:17:43', 'Truong and 2 other people ', 103, 1, 6, 2),
	(117, 2, b'1', '2020-09-25 18:17:53', 'Truong and 2 other people ', 107, 1, 6, 2),
	(118, 2, b'1', '2020-09-25 18:18:22', 'Truong', 104, 1, 6, 1),
	(119, 1, b'0', '2020-09-25 18:55:52', '', 0, 2, 89, 0),
	(120, 40, b'0', '2020-09-25 18:59:45', '', 0, 2, 89, 0),
	(121, 13, b'0', '2020-09-25 19:04:59', '', 0, 2, 1, 0),
	(122, 2, b'1', '2020-09-25 19:05:45', 'asdpham', 105, 3, 1, 1),
	(123, 67, b'0', '2020-09-25 19:39:05', 'bichchiit1701@gmail.com comment on Thien\'s post', 55, 3, 90, 1),
	(124, 1, b'1', '2020-09-25 19:39:32', '', 0, 2, 90, 0),
	(125, 1, b'1', '2020-09-25 19:40:33', '', 0, 2, 90, 0),
	(126, 90, b'0', '2020-09-25 19:43:27', 'asdpham and 1 other people', 115, 3, 1, 1),
	(127, 67, b'0', '2020-09-28 13:24:38', 'Truong and 2 other people ', 112, 1, 6, 2),
	(128, 67, b'0', '2020-09-25 19:43:34', 'asdpham', 111, 1, 1, 1),
	(129, 2, b'1', '2020-09-25 19:44:23', 'asdpham', 107, 3, 1, 1),
	(130, 90, b'0', '2020-09-25 19:45:43', '', 0, 2, 1, 0),
	(131, 16, b'0', '2020-09-25 19:47:52', '', 0, 2, 1, 0),
	(132, 3, b'0', '2020-09-25 19:53:51', '', 0, 2, 90, 0),
	(133, 82, b'0', '2020-09-25 19:54:25', '', 0, 2, 90, 0),
	(134, 22, b'0', '2020-09-25 19:55:37', 'bichchiit1701@gmail.com', 16, 1, 90, 1),
	(135, 22, b'0', '2020-09-25 19:55:49', 'bichchiit1701@gmail.com', 16, 3, 90, 1),
	(136, 13, b'0', '2020-09-25 19:55:49', 'bichchiit1701@gmail.com comment on asd\'s post', 16, 3, 90, 1),
	(137, 6, b'0', '2020-09-25 19:56:49', 'bichchiit1701@gmail.com', 101, 3, 90, 1),
	(138, 6, b'1', '2020-09-25 19:57:25', '', 0, 2, 90, 0),
	(139, 67, b'0', '2020-09-25 19:58:05', '', 0, 2, 90, 0),
	(140, 6, b'1', '2020-09-25 19:58:09', '', 0, 2, 90, 0),
	(141, 1, b'0', '2020-09-25 20:05:06', 'bichchiit1701@gmail.com comment on bichchiit1701@gmail.com\'s post', 115, 3, 90, 1),
	(142, 13, b'0', '2020-09-28 16:18:29', 'Duc and 1 other people comment on Duc\'s post', 108, 3, 2, 1),
	(143, 2, b'1', '2020-09-28 11:00:52', '', 0, 2, 90, 0),
	(144, 67, b'0', '2020-09-28 13:12:07', 'Truong', 119, 1, 6, 1),
	(145, 6, b'0', '2020-09-28 13:20:35', '', 0, 2, 90, 0),
	(146, 67, b'0', '2020-09-28 13:24:32', 'Truong and 2 other people ', 120, 1, 6, 2),
	(147, 67, b'1', '2020-09-28 16:18:35', 'Duc and 1 other people', 120, 3, 2, 1),
	(148, 90, b'0', '2020-09-28 13:21:46', '', 0, 2, 67, 0),
	(149, 13, b'0', '2020-09-28 13:22:51', '', 0, 2, 67, 0),
	(150, 6, b'0', '2020-09-28 14:29:09', '', 0, 2, 90, 0),
	(151, 1, b'0', '2020-09-28 16:18:29', 'Duc and 1 other people comment on Duc\'s post', 108, 3, 2, 1),
	(152, 1, b'0', '2020-09-28 16:18:35', 'Duc and 1 other people comment on Long\'s post', 120, 3, 2, 1),
	(153, 67, b'0', '2020-09-28 16:18:29', 'Duc comment on Duc\'s post', 108, 3, 2, 1);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;

-- Dumping structure for table ambi.noti_type
CREATE TABLE IF NOT EXISTS `noti_type` (
  `notitypeid` int(11) NOT NULL AUTO_INCREMENT,
  `nametype` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`notitypeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.noti_type: ~3 rows (approximately)
/*!40000 ALTER TABLE `noti_type` DISABLE KEYS */;
INSERT INTO `noti_type` (`notitypeid`, `nametype`, `description`) VALUES
	(1, 'like', 'liked your post'),
	(2, 'friend request', 'Send you a friend request'),
	(3, 'comment', ' comment on your post');
/*!40000 ALTER TABLE `noti_type` ENABLE KEYS */;

-- Dumping structure for table ambi.post
CREATE TABLE IF NOT EXISTS `post` (
  `postid` int(11) NOT NULL AUTO_INCREMENT,
  `content` text DEFAULT NULL,
  `postdate` datetime NOT NULL,
  `totallike` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `privacyid` int(11) NOT NULL,
  `isdelete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `FK_post_privacyid_privacy_privacyid` (`privacyid`),
  KEY `FK_post_userid_user_userid` (`userid`),
  CONSTRAINT `FK_post_privacyid_privacy_privacyid` FOREIGN KEY (`privacyid`) REFERENCES `privacy` (`privacyid`) ON DELETE NO ACTION,
  CONSTRAINT `FK_post_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.post: ~47 rows (approximately)
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` (`postid`, `content`, `postdate`, `totallike`, `userid`, `privacyid`, `isdelete`) VALUES
	(1, 'Wow so beautiful ', '2020-08-31 10:25:06', 201, 1, 1, b'1'),
	(2, 'test2', '2020-08-22 10:26:10', 11, 1, 1, b'1'),
	(3, 'test3', '2020-08-27 10:26:43', 13, 1, 1, b'1'),
	(16, 'Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow so beautiful Wow', '2020-09-04 18:01:55', 11, 22, 1, b'0'),
	(17, '123213123', '2020-09-04 18:33:31', 12, 22, 1, b'1'),
	(18, 'test111111111', '2020-09-10 09:00:20', 213, 13, 1, b'0'),
	(19, '내 여 자 친 구', '2020-09-10 19:05:50', 12, 2, 1, b'0'),
	(49, 'thong cat mooi', '2020-09-25 19:43:59', 2, 1, 1, b'1'),
	(50, 'dsadsa', '2020-09-18 16:09:06', 2, 1, 1, b'0'),
	(51, '', '2020-09-18 16:10:29', 1, 1, 1, b'0'),
	(54, 'tttttt', '2020-09-18 16:12:44', 0, 2, 1, b'0'),
	(55, 'dsadsa', '2020-09-18 16:12:51', 6, 3, 1, b'0'),
	(56, 'ccccccc', '2020-09-18 16:18:28', 0, 2, 1, b'0'),
	(57, 'asdasdas', '2020-09-18 16:19:55', 1, 2, 2, b'0'),
	(58, 'hello word', '2020-09-18 16:35:46', 9, 3, 1, b'1'),
	(59, 'hello cac ban', '2020-09-18 16:36:51', 100025, 3, 1, b'0'),
	(61, 'asdasdsa', '2020-09-18 17:48:32', 1002, 40, 2, b'0'),
	(62, 'asdasdsa', '2020-09-18 17:48:50', 2002, 40, 1, b'0'),
	(63, 'asdasdbcfvxv', '2020-09-18 17:50:40', 50001, 40, 1, b'0'),
	(87, '', '2020-09-21 09:38:02', 1, 6, 1, b'1'),
	(93, 'abloooo', '2020-09-21 10:14:18', 3, 67, 1, b'1'),
	(95, 'fjfjvhjgjgjgj', '2020-09-22 11:22:42', 0, 10, 1, b'0'),
	(97, '11111', '2020-09-22 11:29:00', 1, 2, 1, b'0'),
	(98, 'tiesttt', '2020-09-22 11:44:39', 3, 67, 1, b'0'),
	(99, 'awdawd', '2020-09-23 11:48:19', 1, 15, 1, b'0'),
	(100, '', '2020-09-23 11:58:07', 1, 6, 1, b'1'),
	(101, '', '2020-09-23 11:58:43', 3, 6, 1, b'1'),
	(102, 'testttttttttt', '2020-09-23 11:58:43', 1, 6, 1, b'1'),
	(103, 'abcfaw', '2020-09-25 19:18:06', 3, 67, 1, b'0'),
	(104, 'Xinh vl', '2020-09-24 10:59:45', 1, 2, 1, b'0'),
	(105, 'Xinh qua', '2020-09-24 11:55:10', 1, 2, 1, b'0'),
	(106, '', '2020-09-24 13:07:28', 1, 67, 1, b'1'),
	(107, '><', '2020-09-24 13:09:46', 1, 2, 1, b'0'),
	(108, 'Woww', '2020-09-28 16:25:04', 4, 2, 1, b'0'),
	(109, 'testtttafa', '2020-09-24 13:40:20', 0, 67, 1, b'1'),
	(110, 'Lisaaa', '2020-09-25 10:45:11', 0, 67, 1, b'1'),
	(111, 'teaswgfa', '2020-09-25 19:25:29', 1, 67, 1, b'0'),
	(112, 'testttt', '2020-09-28 12:01:08', 2, 67, 1, b'0'),
	(113, 'hihi', '2020-09-25 19:29:45', 1, 1, 1, b'1'),
	(114, 'testtt', '2020-09-28 12:01:33', 0, 16, 1, b'0'),
	(115, 'em tuk ak', '2020-09-25 19:58:33', 1, 90, 1, b'0'),
	(116, 'hihi', '2020-09-25 19:45:11', 0, 90, 2, b'0'),
	(117, 'tui tuk ak', '2020-09-25 19:53:31', 0, 90, 1, b'0'),
	(118, 'hom nay that la dep', '2020-09-28 13:10:35', 0, 67, 1, b'1'),
	(119, 'hello cac ban!', '2020-09-28 13:11:27', 2, 67, 1, b'1'),
	(120, 'hola', '2020-09-28 13:20:25', 3, 67, 1, b'0'),
	(121, '', '2020-09-28 13:23:34', 0, 6, 1, b'1');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;

-- Dumping structure for table ambi.privacy
CREATE TABLE IF NOT EXISTS `privacy` (
  `privacyid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`privacyid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.privacy: ~2 rows (approximately)
/*!40000 ALTER TABLE `privacy` DISABLE KEYS */;
INSERT INTO `privacy` (`privacyid`, `name`, `description`) VALUES
	(1, 'public', 'public'),
	(2, 'private', 'private');
/*!40000 ALTER TABLE `privacy` ENABLE KEYS */;

-- Dumping structure for table ambi.relationship
CREATE TABLE IF NOT EXISTS `relationship` (
  `reid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`reid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.relationship: ~3 rows (approximately)
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` (`reid`, `description`, `name`) VALUES
	(1, 'pending', 'pending'),
	(2, 'friend', 'friend'),
	(3, 'block', 'block');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;

-- Dumping structure for table ambi.role
CREATE TABLE IF NOT EXISTS `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.role: ~2 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`roleid`, `description`, `name`) VALUES
	(1, 'user', 'ROLE_USER'),
	(2, 'admin', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table ambi.role_user
CREATE TABLE IF NOT EXISTS `role_user` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  KEY `FK_role_user_userid_user_userid` (`userid`),
  KEY `FK_role_user_roleid_role_roleid` (`roleid`),
  CONSTRAINT `FK_role_user_roleid_role_roleid` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `FK_role_user_userid_user_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.role_user: ~25 rows (approximately)
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` (`userid`, `roleid`) VALUES
	(1, 1),
	(1, 2),
	(67, 1),
	(37, 2),
	(3, 2),
	(68, 1),
	(69, 1),
	(73, 1),
	(74, 1),
	(75, 1),
	(76, 1),
	(77, 1),
	(78, 1),
	(79, 1),
	(80, 1),
	(81, 1),
	(82, 1),
	(83, 1),
	(84, 1),
	(85, 1),
	(86, 1),
	(87, 1),
	(88, 1),
	(89, 1),
	(90, 1);
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;

-- Dumping structure for table ambi.subcomment
CREATE TABLE IF NOT EXISTS `subcomment` (
  `subcommentid` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `commentdate` datetime NOT NULL,
  `commentid` int(11) NOT NULL,
  `remotion` varchar(50) DEFAULT NULL,
  `isdelete` bit(1) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`subcommentid`),
  KEY `FK_subcomment_commentid_comment_commentid` (`commentid`),
  KEY `FK_subcomment_user` (`userid`),
  CONSTRAINT `FK_subcomment_commentid_comment_commentid` FOREIGN KEY (`commentid`) REFERENCES `comment` (`commentid`),
  CONSTRAINT `FK_subcomment_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.subcomment: ~69 rows (approximately)
/*!40000 ALTER TABLE `subcomment` DISABLE KEYS */;
INSERT INTO `subcomment` (`subcommentid`, `content`, `commentdate`, `commentid`, `remotion`, `isdelete`, `userid`) VALUES
	(1, 'tests', '2020-08-27 10:26:43', 1, 'asd', b'0', 22),
	(2, 'kaka2', '2020-09-02 11:17:54', 1, NULL, b'0', 2),
	(3, 'haha1', '2020-08-31 11:18:09', 2, NULL, b'0', 16),
	(4, 'hihi1', '2020-09-01 11:18:23', 3, NULL, b'1', 5),
	(5, 'tests1', '2020-08-28 10:26:43', 1, 'asd', b'0', 22),
	(6, 'tests1', '2020-08-28 10:26:43', 1, 'asd', b'0', 4),
	(7, '123123', '2020-09-08 13:25:55', 51, 'qwe', b'0', 22),
	(8, 'test12345', '2020-09-08 13:27:11', 54, 'qwe', b'0', 22),
	(90, 'af2', '2020-09-08 19:14:32', 131, 'qwe', b'0', 22),
	(91, 'af2', '2020-09-08 19:14:32', 131, 'qwe', b'0', 22),
	(92, '123123', '2020-09-08 19:16:28', 132, 'qwe', b'0', 22),
	(147, '123123', '2020-09-10 18:00:19', 196, 'qwe', b'0', 22),
	(148, '123123', '2020-09-10 18:27:34', 202, 'qwe', b'0', 22),
	(149, '123123', '2020-09-10 18:27:59', 202, 'qwe', b'0', 22),
	(150, '12313', '2020-09-10 18:28:04', 202, 'qwe', b'0', 22),
	(151, 'asdasd', '2020-09-10 19:02:50', 203, 'qwe', b'0', 22),
	(152, 'qweqwe', '2020-09-10 19:02:55', 201, 'qwe', b'0', 22),
	(153, 'qweqwe', '2020-09-10 19:02:58', 200, 'qwe', b'0', 22),
	(154, '12321', '2020-09-11 20:05:09', 206, 'qwe', b'0', 2),
	(155, 'Hello girl... I love u', '2020-09-14 16:57:02', 206, 'qwe', b'0', 2),
	(156, 'Gaugaugau', '2020-09-14 18:36:11', 205, 'qwe', b'0', 2),
	(157, 'b', '2020-09-14 18:36:39', 204, 'qwe', b'0', 2),
	(158, 'test ', '2020-09-14 18:44:45', 204, 'qwe', b'0', 2),
	(159, 'hihi', '2020-09-14 18:46:20', 204, 'qwe', b'0', 2),
	(160, 'a', '2020-09-14 19:43:34', 204, 'qwe', b'0', 2),
	(161, 'finally', '2020-09-14 19:45:39', 204, 'qwe', b'0', 2),
	(162, 'hihi', '2020-09-15 18:29:32', 208, 'qwe', b'0', 2),
	(163, '', '2020-09-17 10:54:38', 210, 'qwe', b'0', 2),
	(164, 'haha', '2020-09-18 19:54:45', 206, 'qwe', b'0', 1),
	(165, 'dawdawd', '2020-09-18 19:54:56', 1, 'qwe', b'0', 67),
	(166, 'helllo', '2020-09-18 19:56:23', 1, 'qwe', b'0', 67),
	(167, 'alo', '2020-09-18 19:56:46', 1, 'qwe', b'0', 1),
	(169, 'vtgtvtt', '2020-09-21 15:48:14', 233, 'qwe', b'0', 2),
	(170, '', '2020-09-21 15:48:16', 233, 'qwe', b'0', 2),
	(171, '', '2020-09-21 15:48:17', 233, 'qwe', b'0', 2),
	(172, '', '2020-09-21 15:48:18', 233, 'qwe', b'0', 2),
	(173, '', '2020-09-21 15:48:19', 233, 'qwe', b'0', 2),
	(174, '', '2020-09-21 15:48:41', 234, 'qwe', b'0', 67),
	(175, '', '2020-09-21 15:48:42', 234, 'qwe', b'0', 67),
	(176, '', '2020-09-21 15:48:42', 234, 'qwe', b'0', 67),
	(177, 'Hi cai gi ma hi?', '2020-09-21 18:34:43', 235, 'qwe', b'0', 2),
	(178, 'Hi', '2020-09-21 19:05:00', 235, 'qwe', b'0', 13),
	(179, 'Check my inbox please! :(', '2020-09-21 19:06:58', 236, 'qwe', b'0', 15),
	(180, 'No', '2020-09-21 19:09:03', 236, 'qwe', b'0', 13),
	(181, '123', '2020-09-22 10:32:05', 244, 'qwe', b'0', 2),
	(182, 'dasa', '2020-09-22 10:32:18', 244, 'qwe', b'0', 67),
	(183, 'dasdas', '2020-09-22 10:36:47', 233, 'qwe', b'0', 67),
	(184, 'ok', '2020-09-23 11:38:57', 234, 'qwe', b'0', 1),
	(185, 'ok', '2020-09-23 11:39:55', 207, 'qwe', b'0', 1),
	(186, 'hi cc', '2020-09-23 11:40:06', 208, 'qwe', b'0', 1),
	(187, 'OKkk', '2020-09-23 11:41:09', 207, 'qwe', b'0', 1),
	(188, '...', '2020-09-23 11:41:20', 234, 'qwe', b'0', 1),
	(189, 'mmmm', '2020-09-23 11:42:15', 222, 'qwe', b'0', 1),
	(190, 'mmmm', '2020-09-23 11:42:20', 222, 'qwe', b'0', 1),
	(191, 'awfawayge', '2020-09-23 11:46:06', 288, 'qwe', b'0', 67),
	(192, 'awdaw', '2020-09-23 11:55:06', 293, 'qwe', b'0', 40),
	(193, 'dawdaw', '2020-09-23 11:55:11', 293, 'qwe', b'0', 40),
	(194, '12312312313123', '2020-09-23 11:59:04', 294, 'qwe', b'0', 6),
	(195, '12312', '2020-09-23 11:59:10', 294, 'qwe', b'0', 6),
	(196, '11', '2020-09-23 11:59:14', 294, 'qwe', b'0', 6),
	(197, 'awdawda', '2020-09-23 11:59:13', 294, 'qwe', b'0', 6),
	(198, 'asdas', '2020-09-24 11:40:23', 206, 'qwe', b'0', 67),
	(199, 'Chao Long', '2020-09-24 17:05:19', 298, 'qwe', b'0', 2),
	(200, 'CLGT', '2020-09-25 17:12:48', 313, 'qwe', b'0', 2),
	(201, 'thien c', '2020-09-25 19:04:43', 314, 'qwe', b'0', 1),
	(202, 'dung oi', '2020-09-25 19:42:02', 318, 'qwe', b'0', 1),
	(203, 'sss', '2020-09-25 19:55:10', 324, 'qwe', b'0', 90),
	(204, 'mullet', '2020-09-28 13:11:54', 329, 'qwe', b'0', 67),
	(205, 'thang dau cat moi', '2020-09-28 13:21:01', 330, 'qwe', b'0', 1);
/*!40000 ALTER TABLE `subcomment` ENABLE KEYS */;

-- Dumping structure for table ambi.user
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(225) NOT NULL,
  `isactive` bit(1) DEFAULT NULL,
  `userurl` varchar(45) DEFAULT NULL,
  `useravt` varchar(100) DEFAULT NULL,
  `userbgr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.user: ~34 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`, `name`, `phone`, `email`, `password`, `isactive`, `userurl`, `useravt`, `userbgr`) VALUES
	(1, 'asdpham', 'asd', 'asd@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'asd', 'images (1).jpg', '3.jpg'),
	(2, 'Duc', '0932174169', 'vmd211099@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'vmd211099', '82631395_1484045415093215_1664493281116946432_o.jpg', '2.jpg'),
	(3, 'Thien', '0111111111', 'thienkut3@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'thienkut3', '116442692_1216331545387883_1483374940740545334_o.jpg', '10.jpg'),
	(4, 'Tam', '0123456789', 'tamchimte@gmail.com', '11111111', b'1', 'tamchimte', '37947336_1236677303138662_3252476860931506176_n.jpg', '5.jpg'),
	(5, 'Another Long', '0333333333', 'longfish@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'longfish', '78355589_2505040122941805_6920204169496231936_o.jpg', '8.jpg'),
	(6, 'Truong', '0123456789', 'truong@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'truong', '84499919_1360549807668095_4174386437057150976_n.jpg', '1.jpg'),
	(10, 'asd', '', 'test@gmail.com', 'wENTB', b'1', 'test', 'default_avatar.jpg', '4.jpg'),
	(13, 'Lalisa', NULL, 'lisa97@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'lisa97', '117191865_1728338037323738_5104815721467262269_n.jpg', '1.jpg'),
	(15, 'Rose', NULL, 'rose@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'rose', '29354901_2031609440388410_3782684179869333995_o.jpg', '1.jpg'),
	(16, 'Jennie', NULL, 'jennie@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'jennie', '105366462_3069789306391127_1763904381130441267_n.jpg', '7.jpg'),
	(22, 'asd', NULL, 'asdpham@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'asdpham', '105366462_3069789306391127_1763904381130441267_n.jpg', '1.jpg'),
	(37, 'abc', NULL, 'chuckimthien.131@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'chuckimthien.131', '105366462_3069789306391127_1763904381130441267_n.jpg', '2.jpg'),
	(40, 'tzuyu', NULL, 'tzuyu@gmail.com', '$2a$08$QvPDHRxlISY5g26SNkk14erW/ZHbmRzXZ4ciyXWRejTI5KOIKkHU6', b'1', 'tzuyu', 'tzuyu11557301517width1080height1349_CCTG.jpg', '1.jpg'),
	(67, 'Long', NULL, 'thanhlong15423@gmail.com', '$2a$08$3jlpsIE5GAlvMwgESkwp7O11dz4UPohYzCbsWkcR/QSLAcZHnAVYu', b'1', 'thanhlong1543', '78355589_2505040122941805_6920204169496231936_o.jpg', '9.jpg'),
	(68, 'thanhlong15443@gmail.com', NULL, 'thanhlong15443@gmail.com', '$2a$08$4MEnmK0oykEGTeZYabxh2e6txYwJxRBvve595WSJ9X4OaYpM.17cC', b'0', 'thanhlong15443', NULL, NULL),
	(69, 'nodeandvue@gmail.com', NULL, 'nodeandvue@gmail.com', '$2a$08$lkcFiXDp/ljIRM3TKARnxefYxg6.Y2sggdyLnrLGwNM8OkRD1Pw06', b'1', 'nodeandvue', 'default_avatar.jpg', NULL),
	(73, 's@gmail.com', NULL, 's@gmail.com', '$2a$08$BStzKzAS.cWK7EUv3SXrv.uJrDwl/g5HAGfZ51it3.PoK1OcrVmG6', b'0', 's', 'default_avatar.jpg', NULL),
	(74, 'test12@gmail.com', NULL, 'test12@gmail.com', '$2a$08$ryQ2dzuVb9Y3xHkrKvBY8.XGEGzMt0foD96N53QHu1u.O0fZ4aYmW', b'1', 'test12', 'avt9.jpg', NULL),
	(75, 'test13@gmail.com', NULL, 'test13@gmail.com', '$2a$08$yz5mYahrgaw1BwlmdXjBD.OgZ0ReRWFr5LECyy68UHMW7HrPK67jy', b'1', 'test13', 'avt10.jpg', NULL),
	(76, 'test14@gmail.com', NULL, 'test14@gmail.com', '$2a$08$DIYnripm98G8sObLgQv0Ou./s2y.zoDkNhyZvODmaj7DYk1rUf5/G', b'1', 'test14', 'default_avatar.jpg', NULL),
	(77, 'test15@gmail.com', NULL, 'test15@gmail.com', '$2a$08$NJrQWTx0dE4H6lPr4C8ZteOH3.EQsDoSSBIQhcNH8Ou4YJejrZqKi', b'1', 'test15', 'avt8.jpg', NULL),
	(78, 'test16@gmail.com', NULL, 'test16@gmail.com', '$2a$08$C5uyZOT9EKygfoF7kPRL.e6UpD8SyFfJWdWDw33Oa7m5UWwoYdmgS', b'1', 'test16', 'avt6.jpg', NULL),
	(79, 'test17@gmail.com', NULL, 'test17@gmail.com', '$2a$08$m4/A8mvG8tvzvT58bCDlo.ttKYVWl9yhJLxNwXtbSCbVMl.h2/MKa', b'1', 'test17', 'avt6.jpg', NULL),
	(80, 'test18@gmail.com', NULL, 'test18@gmail.com', '$2a$08$u5KpG4X3w1//GqO9WdNAjuBa2w6drUqMbhj.q.DHLrLuvWs9ArwFK', b'1', 'test18', 'avt6.jpg', NULL),
	(81, 'test19@gmail.com', NULL, 'test19@gmail.com', '$2a$08$Z6EAbNUUexiIth7tSggcl./3Fv8spgGSpPph3vmBaXaR4Kw6pwoXO', b'1', 'test19', 'avt1.jpg', NULL),
	(82, 'bichchiit1701il.com', NULL, 'bichchiit1701il.com', '$2a$08$ExR.0pt8GWQJ1YOi9vkvC.wS84YZFz77qP6GWeKcrVUPzXPuWv4o2', b'1', '', 'default_avatar.jpg', NULL),
	(83, 'a@gmail.com', NULL, 'a@gmail.com', '$2a$08$s/Wl.9FwV5jvzdkAkOQAC.6y/XxzySpUpadT19v07E76MptWA0hpa', b'1', 'a', 'avt2.jpg', '2.jpg'),
	(84, 'quangdeptrai@gmail.com', NULL, 'quangdeptrai@gmail.com', '$2a$08$7iv0ddok8Er8rEYxNlXr0u1m13SGSzDR/QUTVogBvSHRM7qGVJ5RC', b'1', 'quangdeptrai', 'avt1.jpg', '1.jpg'),
	(85, 'gianglatao123@gmail.com', NULL, 'gianglatao123@gmail.com', '$2a$08$W7AM9JebP/RlYs0f6ohCPO/yZk9azmtlPuxkAD8otGrOg40uci.uq', b'1', 'gianglatao123', 'avt1.jpg', '1.jpg'),
	(86, 'quangcccc@gmail.com', NULL, 'quangcccc@gmail.com', '$2a$08$gg4omJzkJFPELUQvFRy3POC0KdQFWripDGQzp2BjadyjUBXwyEFly', b'1', 'quangcccc', 'avt3.jpg', '3.jpg'),
	(87, 'thaicc@gmail.com', NULL, 'thaicc@gmail.com', '$2a$08$AvD/SxzQjBkusXpMTMRebuwjdmLDr/rP82iZP5MEmYdoWVcth8Uxq', b'1', 'thaicc', 'avt5.jpg', '5.jpg'),
	(88, 'thiencc@gmail.com', NULL, 'thiencc@gmail.com', '$2a$08$pTBaY8mas7NQOvbCGdaiKuWpYt12dADTxveqMff/Cspuv.ZrgU.1u', b'0', 'thiencc', 'avt6.jpg', '6.jpg'),
	(89, 'nguyenthai492017@gmail.com', NULL, 'nguyenthai492017@gmail.com', '$2a$08$IZdczWQhIV/Vz8q6tYBD0.k3fPft4aj0NfkqPqeXCQPk/qq4nT/NS', b'1', 'nguyenthai492017', 'avt5.jpg', '5.jpg'),
	(90, 'bichchiit1701@gmail.com', 'hggg', 'bichchiit1701@gmail.com', '$2a$08$KxNxkhb9ZqqKpqX4kAeDJedN.zvfZBnEuDMTxz/3FI0vyjBOcwT4K', b'1', 'bichchiit1701', 'avt2.jpg', '1.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table ambi.verification_token
CREATE TABLE IF NOT EXISTS `verification_token` (
  `tokenid` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(50) NOT NULL DEFAULT '',
  `userId` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`tokenid`),
  UNIQUE KEY `token` (`token`),
  KEY `FK__user` (`userId`),
  CONSTRAINT `FK__user` FOREIGN KEY (`userId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table ambi.verification_token: ~6 rows (approximately)
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` (`tokenid`, `token`, `userId`) VALUES
	(3, 'e13691b0-568a-4340-ac1f-1732526eda18', 67),
	(6, 'b9dcd982-9614-4a92-9457-edcbc9549376', 73),
	(7, '67edd433-836c-4074-8ab8-103bedcd70a0', 82),
	(8, 'fb076e6f-6ee0-4d9d-bbdb-167953cc841f', 88),
	(9, '5b0b60d3-1a16-4b36-be0a-1f5faf431905', 89),
	(10, 'e2424d90-77d3-4d37-a7c1-68982bd354b0', 90);
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
