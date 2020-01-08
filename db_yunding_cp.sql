/*
Navicat MySQL Data Transfer

Source Server         : liyuhao
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : db_yunding_cp

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2020-01-08 08:45:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cp_admin
-- ----------------------------
DROP TABLE IF EXISTS `cp_admin`;
CREATE TABLE `cp_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_admin
-- ----------------------------
INSERT INTO `cp_admin` VALUES ('100', 'aaa', '679a320492b7ad55d3b1fe0d49a398a6', '2018-08-13 15:24:45', '2018-08-13 20:40:13');
INSERT INTO `cp_admin` VALUES ('101', 'bbb', '793f2158e3bf33357e743eb875f4eac2', '2018-08-13 20:39:52', '2018-08-13 20:39:52');
INSERT INTO `cp_admin` VALUES ('102', 'ccc', '793f2158e3bf33357e743eb875f4eac2', '2018-08-26 16:37:55', '2018-08-27 17:19:22');
INSERT INTO `cp_admin` VALUES ('103', '夏明', '793f2158e3bf33357e743eb875f4eac2', '2018-08-27 17:37:00', '2018-08-27 17:37:00');

-- ----------------------------
-- Table structure for cp_apply
-- ----------------------------
DROP TABLE IF EXISTS `cp_apply`;
CREATE TABLE `cp_apply` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `reason` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `fk_name_c` (`user_id`),
  KEY `fk_name_d` (`type_id`),
  CONSTRAINT `fk_name_c` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`),
  CONSTRAINT `fk_name_d` FOREIGN KEY (`type_id`) REFERENCES `cp_apply_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_apply
-- ----------------------------
INSERT INTO `cp_apply` VALUES ('1', '39', '1', '2018-08-06 11:07:59', '2018-08-08 11:08:04', '1', '2018-08-06 11:08:26', '2018-08-06 11:08:30', 0x796F75736E69);
INSERT INTO `cp_apply` VALUES ('2', '39', '1', '2018-08-08 11:21:39', '2018-08-08 11:21:39', '1', '2018-08-08 11:21:39', '2018-08-08 11:21:39', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('3', '39', '1', '2018-08-08 11:38:31', '2018-08-08 11:38:31', '1', '2018-08-08 11:38:31', '2018-08-08 11:38:31', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('4', '39', '1', '2018-12-09 12:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 11:42:33', '2018-08-08 11:42:33', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('5', '39', '1', '2018-12-09 12:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 11:51:36', '2018-08-08 11:51:36', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('6', '39', '1', '2018-12-09 12:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 11:52:43', '2018-08-08 11:52:43', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('7', '39', '1', '2018-12-09 12:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 11:52:52', '2018-08-08 11:52:52', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('8', '39', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:13:27', '2018-08-08 13:13:27', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('9', '62', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:13:38', '2018-08-08 13:13:38', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('10', '61', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:30:13', '2018-08-08 13:30:13', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('12', '62', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:30:51', '2018-08-08 13:30:51', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('13', '62', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:30:53', '2018-08-08 13:30:53', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('14', '62', '1', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 13:30:54', '2018-08-08 13:30:54', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('15', '66', '2', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 15:04:50', '2018-08-08 15:04:50', 0xE69C89E4BA8B);
INSERT INTO `cp_apply` VALUES ('16', '66', '2', '2018-12-09 10:09:00', '2018-12-09 13:33:00', '1', '2018-08-08 15:30:22', '2018-08-08 15:30:22', 0xE69C89E4BA8B);

-- ----------------------------
-- Table structure for cp_apply_clock
-- ----------------------------
DROP TABLE IF EXISTS `cp_apply_clock`;
CREATE TABLE `cp_apply_clock` (
  `supply_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL DEFAULT '0',
  `reason` varchar(255) COLLATE utf8_bin NOT NULL,
  `punch_id` int(11) NOT NULL,
  `time_name_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `auditing_time` datetime DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`supply_id`),
  KEY `fk_name_m` (`punch_id`) USING BTREE,
  KEY `fk_name_s` (`time_name_id`),
  CONSTRAINT `fk_name_m` FOREIGN KEY (`punch_id`) REFERENCES `cp_punch_user` (`punch_id`),
  CONSTRAINT `fk_name_s` FOREIGN KEY (`time_name_id`) REFERENCES `cp_time_name` (`time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_apply_clock
-- ----------------------------
INSERT INTO `cp_apply_clock` VALUES ('15', '0', '有事', '110', '1', '2018-08-28 17:18:34', '2018-08-28 17:18:34', null, '1');
INSERT INTO `cp_apply_clock` VALUES ('16', '0', '有事', '110', '1', '2018-08-28 17:28:53', '2018-08-28 17:28:53', null, '2');
INSERT INTO `cp_apply_clock` VALUES ('17', '0', '有事', '121', '1', '2018-08-29 11:52:30', '2018-08-29 11:52:30', null, '2');

-- ----------------------------
-- Table structure for cp_apply_type
-- ----------------------------
DROP TABLE IF EXISTS `cp_apply_type`;
CREATE TABLE `cp_apply_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_apply_type
-- ----------------------------
INSERT INTO `cp_apply_type` VALUES ('1', '事假', '2018-08-06 11:07:30', '2018-08-06 11:07:34', '1');
INSERT INTO `cp_apply_type` VALUES ('2', '病假', '2018-08-08 14:59:00', '2018-08-08 14:59:03', '1');
INSERT INTO `cp_apply_type` VALUES ('3', 'canjia', '2018-08-28 15:27:36', '2018-08-28 15:27:38', '1');

-- ----------------------------
-- Table structure for cp_article
-- ----------------------------
DROP TABLE IF EXISTS `cp_article`;
CREATE TABLE `cp_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id 自增',
  `type_id` int(11) NOT NULL,
  `title` varchar(1024) COLLATE utf8_bin NOT NULL,
  `content` text COLLATE utf8_bin NOT NULL,
  `status` int(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `praise_num` int(11) DEFAULT NULL,
  `comment_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `fk_name_a` (`user_id`),
  KEY `fk_name_b` (`type_id`),
  CONSTRAINT `fk_name_a` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`),
  CONSTRAINT `fk_name_b` FOREIGN KEY (`type_id`) REFERENCES `cp_article_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_article
-- ----------------------------
INSERT INTO `cp_article` VALUES ('1', '1', 'dw', 0x737861, '1', '2018-08-03 16:29:20', '2018-08-03 16:29:17', '37', '1', '4');
INSERT INTO `cp_article` VALUES ('2', '1', 'dsw sdad', 0x6373646473637364636473632073646320, '1', '2018-08-06 10:51:22', '2018-08-06 10:51:35', '58', '2', '1');
INSERT INTO `cp_article` VALUES ('3', '1', 'd', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-07 20:22:36', '2018-08-07 20:22:36', '61', '2', '2');
INSERT INTO `cp_article` VALUES ('4', '1', 'dcv', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-07 20:25:49', '2018-08-07 20:25:49', '61', '3', '1');
INSERT INTO `cp_article` VALUES ('5', '1', 'dxaaxa', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-07 20:33:32', '2018-08-07 20:33:32', '61', '4', '4');
INSERT INTO `cp_article` VALUES ('6', '1', 'dscs', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-07 21:23:55', '2018-08-07 21:23:55', '61', '4', '2');
INSERT INTO `cp_article` VALUES ('7', '1', 'zzzzzd', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-08 09:09:50', '2018-08-08 09:09:50', '39', '4', '4');
INSERT INTO `cp_article` VALUES ('8', '1', 'zzd', 0xE68891E788B1E4BDA0EFBC8CE4BDA0E5A6B9E79A84, '0', '2018-08-08 11:07:17', '2018-08-08 11:07:17', '39', '4', '4');
INSERT INTO `cp_article` VALUES ('9', '1', '我', 0xE68C89E697B6E587BAE78EB0E5958A, '1', '2018-08-26 17:28:06', '2018-08-26 17:28:08', '62', '4', '4');
INSERT INTO `cp_article` VALUES ('14', '1', '我哎', 0xE4B88BE5B882E59CBAE99480E594AE, '1', '2018-08-26 17:29:57', '2018-08-26 17:30:00', '66', '4', '45');
INSERT INTO `cp_article` VALUES ('15', '1', '我想着想着', 0xE5958AE68C89E7A88BE5BA8FE794B3E8AFB7E68C89E6ADA4, '1', '2018-08-26 17:30:28', '2018-08-26 17:30:31', '67', '12', '11');
INSERT INTO `cp_article` VALUES ('16', '1', '问问', 0xE6ADA6E599A8E79A84E5898DE99BBEE781AFE587BAE58EBBE78EA9, '0', '2018-08-27 19:35:01', '2018-08-27 19:35:01', '66', '12', '14');
INSERT INTO `cp_article` VALUES ('17', '1', '利于', 0xE4BAB2E788B1E79A84E697A0E5A49AE697A0, '1', '2018-08-28 15:34:15', '2018-08-28 15:34:15', '74', null, null);
INSERT INTO `cp_article` VALUES ('18', '1', '利于', 0xE4BAB2E788B1E79A84E697A0E5A49AE697A0, '1', '2018-08-28 15:44:27', '2018-08-28 15:44:27', '74', null, null);
INSERT INTO `cp_article` VALUES ('19', '1', '利于', 0xE4BAB2E788B1E79A84E697A0E5A49AE697A0E58887E58887E68891E694BEE5BC83, '1', '2018-08-28 15:46:37', '2018-08-28 15:46:37', '66', null, null);
INSERT INTO `cp_article` VALUES ('20', '1', '利于', 0xE4BAB2E788B1E79A84E697A0E5A49AE697A0E58887E58887E68891E694BEE5BC83, '1', '2018-08-28 15:46:39', '2018-08-28 15:46:39', '66', null, null);
INSERT INTO `cp_article` VALUES ('21', '1', '利于', 0xE4BAB2E788B1E79A84E697A0E5A49AE697A0E58887E58887E68891E694BEE5BC83, '1', '2018-08-28 15:46:41', '2018-08-28 15:46:41', '66', null, null);

-- ----------------------------
-- Table structure for cp_article_praise
-- ----------------------------
DROP TABLE IF EXISTS `cp_article_praise`;
CREATE TABLE `cp_article_praise` (
  `praise_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `praiseTime` datetime NOT NULL,
  PRIMARY KEY (`praise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_article_praise
-- ----------------------------
INSERT INTO `cp_article_praise` VALUES ('1', '65', '13', '2018-08-16 15:40:50');
INSERT INTO `cp_article_praise` VALUES ('2', '65', '12', '2018-08-16 15:42:46');
INSERT INTO `cp_article_praise` VALUES ('3', '65', '11', '2018-08-16 17:11:52');
INSERT INTO `cp_article_praise` VALUES ('4', '65', '10', '2018-08-16 19:01:29');
INSERT INTO `cp_article_praise` VALUES ('5', '65', '9', '2018-08-16 19:02:36');
INSERT INTO `cp_article_praise` VALUES ('6', '64', '9', '2018-08-17 11:38:00');
INSERT INTO `cp_article_praise` VALUES ('15', '39', '15', '2018-08-28 08:10:59');

-- ----------------------------
-- Table structure for cp_article_type
-- ----------------------------
DROP TABLE IF EXISTS `cp_article_type`;
CREATE TABLE `cp_article_type` (
  `status` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `article_type` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_article_type
-- ----------------------------
INSERT INTO `cp_article_type` VALUES ('1', '1', '科技', '2018-08-03 16:29:44', '2018-08-03 16:29:49');
INSERT INTO `cp_article_type` VALUES ('1', '2', '心得', '2018-08-08 14:56:32', '2018-08-08 14:56:35');

-- ----------------------------
-- Table structure for cp_comment
-- ----------------------------
DROP TABLE IF EXISTS `cp_comment`;
CREATE TABLE `cp_comment` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_content` varchar(255) COLLATE utf8_bin NOT NULL,
  `com_art_id` int(11) NOT NULL,
  `com_user_id` int(11) NOT NULL,
  `com_time` datetime NOT NULL,
  PRIMARY KEY (`com_id`),
  KEY `fk_name_g` (`com_art_id`),
  KEY `fk_name_k` (`com_user_id`),
  CONSTRAINT `fk_name_g` FOREIGN KEY (`com_art_id`) REFERENCES `cp_article` (`article_id`),
  CONSTRAINT `fk_name_k` FOREIGN KEY (`com_user_id`) REFERENCES `cp_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_comment
-- ----------------------------
INSERT INTO `cp_comment` VALUES ('1', 'qwqd', '15', '66', '2018-08-27 15:36:48');
INSERT INTO `cp_comment` VALUES ('2', 'qwqd', '15', '66', '2018-08-27 16:41:14');
INSERT INTO `cp_comment` VALUES ('4', 'qwqd', '15', '66', '2018-08-27 16:42:26');
INSERT INTO `cp_comment` VALUES ('11', 'qwqd', '15', '63', '2018-08-28 08:57:45');
INSERT INTO `cp_comment` VALUES ('12', 'qwqd', '16', '63', '2018-08-28 09:16:10');
INSERT INTO `cp_comment` VALUES ('13', 'qwqd', '14', '63', '2018-08-28 09:16:16');
INSERT INTO `cp_comment` VALUES ('15', 'qwqd', '8', '63', '2018-08-28 09:16:38');
INSERT INTO `cp_comment` VALUES ('17', 'qwqd', '16', '63', '2018-08-28 09:17:16');

-- ----------------------------
-- Table structure for cp_comment_multi
-- ----------------------------
DROP TABLE IF EXISTS `cp_comment_multi`;
CREATE TABLE `cp_comment_multi` (
  `com_multi_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_id` int(11) NOT NULL,
  `com_multi_content` varchar(255) COLLATE utf8_bin NOT NULL,
  `com_multi_user_id` int(11) NOT NULL,
  `com_multi_time` datetime NOT NULL,
  PRIMARY KEY (`com_multi_id`),
  KEY `fk_name_i` (`com_id`),
  KEY `fk_name_j` (`com_multi_user_id`),
  CONSTRAINT `fk_name_i` FOREIGN KEY (`com_id`) REFERENCES `cp_comment` (`com_id`),
  CONSTRAINT `fk_name_j` FOREIGN KEY (`com_multi_user_id`) REFERENCES `cp_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_comment_multi
-- ----------------------------
INSERT INTO `cp_comment_multi` VALUES ('13', '17', '我李宇豪就是就是九十九', '64', '2018-08-29 11:26:58');

-- ----------------------------
-- Table structure for cp_item
-- ----------------------------
DROP TABLE IF EXISTS `cp_item`;
CREATE TABLE `cp_item` (
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `introduce` varchar(255) COLLATE utf8_bin NOT NULL,
  `item_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `leader` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_item
-- ----------------------------
INSERT INTO `cp_item` VALUES ('57', '7', 'app', '这是一个很好看的APP', '1234112', '李宇豪', '2018-08-12 14:36:12', '2018-08-12 14:36:12');
INSERT INTO `cp_item` VALUES ('63', '13', '手', '这是一个很好看的收', '1234111', '21w', '2018-08-12 20:30:05', '2018-08-12 20:30:05');
INSERT INTO `cp_item` VALUES ('57', '18', '孤岛', '这是一个很好看的收', '1234111', 'liyuhao', '2018-08-13 08:14:34', '2018-08-13 08:14:34');
INSERT INTO `cp_item` VALUES ('68', '19', '孤岛', '这是一个很好看的收', '1234111', '巴拉巴拉', '2018-08-13 08:24:21', '2018-08-13 08:24:21');
INSERT INTO `cp_item` VALUES ('57', '23', '孤岛', '这是一个很好看的收', '1234111', 'liyuhao', '2018-08-13 08:45:43', '2018-08-13 08:45:43');
INSERT INTO `cp_item` VALUES ('69', '30', '孤岛', '这是一个很好看的收', '1234111', '流弊', '2018-08-13 09:33:34', '2018-08-13 09:33:34');
INSERT INTO `cp_item` VALUES ('68', '32', '金刚大战', '金刚是一只大醒醒', '1234111', '巴拉巴拉', '2018-08-13 23:07:59', '2018-08-13 23:07:59');
INSERT INTO `cp_item` VALUES ('60', '33', '创建想想', '创建哟个属于自己的无敌大公司', '1234111', '任嘉敏', '2018-08-14 13:29:06', '2018-08-14 13:29:06');
INSERT INTO `cp_item` VALUES ('75', '39', '钉钉', '我们组想要一点点好起来，创造辉煌', '12341121', '李宇豪', '2018-08-14 21:04:09', '2018-08-14 21:04:09');
INSERT INTO `cp_item` VALUES ('89', '41', '云顶', '云顶是一个优秀的团体，欢迎各位萌新加入', 'yunding2018', '高老师', '2018-08-28 20:08:57', '2018-08-28 20:11:14');
INSERT INTO `cp_item` VALUES ('59', '42', '云顶', '云顶是一个优秀的团体，欢迎各位萌新加入', 'yunding2018', 'sadca', '2018-09-29 20:59:40', '2018-09-29 20:59:40');

-- ----------------------------
-- Table structure for cp_item_crew
-- ----------------------------
DROP TABLE IF EXISTS `cp_item_crew`;
CREATE TABLE `cp_item_crew` (
  `user_id` int(11) NOT NULL,
  `crew_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `item_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `crew_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`crew_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_item_crew
-- ----------------------------
INSERT INTO `cp_item_crew` VALUES ('64', '50', '32', '金刚大战', '1ww2', '2018-08-14 17:55:31', '2018-08-14 17:55:31');
INSERT INTO `cp_item_crew` VALUES ('65', '51', '7', 'app', '帝皇铠甲', '2018-08-14 18:01:09', '2018-08-14 18:01:09');
INSERT INTO `cp_item_crew` VALUES ('66', '53', '23', '孤岛', '昊天大帝', '2018-08-14 18:02:05', '2018-08-14 18:02:05');
INSERT INTO `cp_item_crew` VALUES ('74', '56', '39', '钉钉', '杜宸霆', '2018-08-14 21:06:28', '2018-08-14 21:06:28');
INSERT INTO `cp_item_crew` VALUES ('74', '57', '33', '创建想想', '杜宸霆', '2018-08-14 21:13:36', '2018-08-14 21:13:36');
INSERT INTO `cp_item_crew` VALUES ('74', '58', '32', '金刚大战', '杜宸霆', '2018-08-14 21:13:44', '2018-08-14 21:13:44');
INSERT INTO `cp_item_crew` VALUES ('89', '60', '41', '云顶', '高老师', '2018-08-28 20:14:44', '2018-08-28 20:14:44');
INSERT INTO `cp_item_crew` VALUES ('74', '61', '41', '云顶', '杜宸霆', '2018-08-28 20:15:29', '2018-08-28 20:15:29');
INSERT INTO `cp_item_crew` VALUES ('75', '62', '41', '云顶', '李宇豪', '2018-08-28 20:15:35', '2018-08-28 20:15:35');
INSERT INTO `cp_item_crew` VALUES ('76', '63', '41', '云顶', 'RizN3d', '2018-08-28 20:15:38', '2018-08-28 20:15:38');
INSERT INTO `cp_item_crew` VALUES ('77', '64', '41', '云顶', 'zkfWb4', '2018-08-28 20:15:41', '2018-08-28 20:15:41');
INSERT INTO `cp_item_crew` VALUES ('78', '65', '41', '云顶', 'McllXP', '2018-08-28 20:15:43', '2018-08-28 20:15:43');
INSERT INTO `cp_item_crew` VALUES ('79', '66', '41', '云顶', '昊宇里', '2018-08-28 20:15:46', '2018-08-28 20:15:46');
INSERT INTO `cp_item_crew` VALUES ('80', '67', '41', '云顶', 'stEo3x', '2018-08-28 20:15:49', '2018-08-28 20:15:49');
INSERT INTO `cp_item_crew` VALUES ('81', '68', '41', '云顶', 'yjhVuH', '2018-08-28 20:15:52', '2018-08-28 20:15:52');
INSERT INTO `cp_item_crew` VALUES ('82', '69', '41', '云顶', 'pcPovE', '2018-08-28 20:15:55', '2018-08-28 20:15:55');

-- ----------------------------
-- Table structure for cp_item_upload
-- ----------------------------
DROP TABLE IF EXISTS `cp_item_upload`;
CREATE TABLE `cp_item_upload` (
  `item_id` int(11) NOT NULL,
  `upload_id` int(11) NOT NULL AUTO_INCREMENT,
  `crew_id` int(11) NOT NULL,
  `item_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `crew_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `upload_content` text COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `dateline_at` datetime NOT NULL,
  PRIMARY KEY (`upload_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_item_upload
-- ----------------------------
INSERT INTO `cp_item_upload` VALUES ('32', '36', '50', '金刚大战', '1ww2', 0xE588A0E999A4E8B4A6E58FB73825, '2018-08-15 19:19:18', '2018-08-15 19:19:18', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('7', '37', '51', 'app', '帝皇铠甲', 0xE6B8A9E983BDE6B0B4E59F8EE68891E58EBBE4BA8CE697A0, '2018-08-15 19:29:14', '2018-08-15 19:29:14', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('23', '38', '53', '孤岛', '昊天大帝', 0xE8AEA4E4B8BAE6B395E4BABAE58886E4B8BA76, '2018-08-15 19:29:21', '2018-08-15 19:29:21', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('39', '39', '56', '钉钉', '杜宸霆', 0xE6B2A1E79C8BE8A781E4BDA0E79C8BE5B0B1E7A6BBE5BC80E58DB3E5BC80E7A5A8E68EA5E58FA3E5B0B1, '2018-08-15 19:29:30', '2018-08-15 19:29:30', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('33', '40', '57', '创建想想', '杜宸霆', 0xE8AEA9E4BDA02020E4B88D4756E58F91E588B0E6B7B156E983BDE698AF, '2018-08-15 19:29:40', '2018-08-15 19:29:40', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('32', '41', '58', '金刚大战', '杜宸霆', 0x20E7A88BE5BAA6E4B88AE79A84353625, '2018-08-15 19:30:35', '2018-08-15 19:30:35', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('40', '42', '59', '美图秀秀', '杜宸霆', 0x20E5B0B1E698AFE7899BE980BCE79A84353625, '2018-08-15 19:30:49', '2018-08-15 19:30:49', '2018-08-16 00:00:00');
INSERT INTO `cp_item_upload` VALUES ('41', '43', '69', '云顶', 'pcPovE', 0xE5A4A7E5AEB6E5A5BDE68891E698AFE4BDA9E5A587, '2018-08-29 11:48:03', '2018-08-29 11:48:03', '2018-08-30 00:00:00');

-- ----------------------------
-- Table structure for cp_log
-- ----------------------------
DROP TABLE IF EXISTS `cp_log`;
CREATE TABLE `cp_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(11) COLLATE utf8_bin NOT NULL,
  `content` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`),
  KEY `admin_id` (`admin_name`)
) ENGINE=InnoDB AUTO_INCREMENT=365 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_log
-- ----------------------------
INSERT INTO `cp_log` VALUES ('1', 'bbb', '查看文章列表', '2018-08-13 16:19:56', '2018-08-13 16:19:56');
INSERT INTO `cp_log` VALUES ('2', 'bbb', '查看文章列表', '2018-08-13 16:35:31', '2018-08-13 16:35:31');
INSERT INTO `cp_log` VALUES ('3', '', '登录', '2018-08-13 17:01:06', '2018-08-13 17:01:06');
INSERT INTO `cp_log` VALUES ('4', 'bbb', '查看管理员列表', '2018-08-13 17:01:08', '2018-08-13 17:01:08');
INSERT INTO `cp_log` VALUES ('5', 'bbb', '修改管理员信息', '2018-08-13 17:01:19', '2018-08-13 17:01:19');
INSERT INTO `cp_log` VALUES ('6', 'bbb', '查看申请列表', '2018-08-13 17:01:23', '2018-08-13 17:01:23');
INSERT INTO `cp_log` VALUES ('7', 'bbb', '查看文章具体内容', '2018-08-13 17:01:36', '2018-08-13 17:01:36');
INSERT INTO `cp_log` VALUES ('8', 'bbb', '查看文章具体内容', '2018-08-13 17:01:40', '2018-08-13 17:01:40');
INSERT INTO `cp_log` VALUES ('9', 'bbb', '查看文章具体内容', '2018-08-13 17:01:43', '2018-08-13 17:01:43');
INSERT INTO `cp_log` VALUES ('10', 'bbb', '查看文章具体内容', '2018-08-13 17:01:47', '2018-08-13 17:01:47');
INSERT INTO `cp_log` VALUES ('11', 'bbb', '修改文章类型', '2018-08-13 17:01:54', '2018-08-13 17:01:54');
INSERT INTO `cp_log` VALUES ('12', 'bbb', '查看申请列表', '2018-08-13 17:02:00', '2018-08-13 17:02:00');
INSERT INTO `cp_log` VALUES ('13', 'bbb', '查看申请具体信息', '2018-08-13 17:02:01', '2018-08-13 17:02:01');
INSERT INTO `cp_log` VALUES ('14', 'bbb', '查看用户列表', '2018-08-13 17:02:06', '2018-08-13 17:02:06');
INSERT INTO `cp_log` VALUES ('15', 'bbb', '查看用户列表', '2018-08-13 17:02:07', '2018-08-13 17:02:07');
INSERT INTO `cp_log` VALUES ('16', 'aaa', '登录', '2018-08-13 17:03:01', '2018-08-13 17:03:01');
INSERT INTO `cp_log` VALUES ('17', 'aaa', '查看文章列表', '2018-08-13 17:03:44', '2018-08-13 17:03:44');
INSERT INTO `cp_log` VALUES ('18', 'aaa', '修改文章类型', '2018-08-13 17:03:49', '2018-08-13 17:03:49');
INSERT INTO `cp_log` VALUES ('19', 'aaa', '查看用户列表', '2018-08-13 17:03:52', '2018-08-13 17:03:52');
INSERT INTO `cp_log` VALUES ('20', 'aaa', '查看用户列表', '2018-08-13 17:04:01', '2018-08-13 17:04:01');
INSERT INTO `cp_log` VALUES ('21', 'aaa', '登录', '2018-08-13 20:32:22', '2018-08-13 20:32:22');
INSERT INTO `cp_log` VALUES ('22', 'aaa', '登录', '2018-08-13 20:35:05', '2018-08-13 20:35:05');
INSERT INTO `cp_log` VALUES ('23', 'aaa', '查看管理员列表', '2018-08-13 20:35:08', '2018-08-13 20:35:08');
INSERT INTO `cp_log` VALUES ('24', 'aaa', '查看文章列表', '2018-08-13 20:35:19', '2018-08-13 20:35:19');
INSERT INTO `cp_log` VALUES ('25', 'aaa', '查看文章具体内容', '2018-08-13 20:35:20', '2018-08-13 20:35:20');
INSERT INTO `cp_log` VALUES ('26', 'aaa', '登录', '2018-08-13 20:39:38', '2018-08-13 20:39:38');
INSERT INTO `cp_log` VALUES ('27', 'aaa', '查看管理员列表', '2018-08-13 20:39:41', '2018-08-13 20:39:41');
INSERT INTO `cp_log` VALUES ('28', 'aaa', '增加管理员', '2018-08-13 20:39:52', '2018-08-13 20:39:52');
INSERT INTO `cp_log` VALUES ('29', 'aaa', '查看管理员列表', '2018-08-13 20:39:53', '2018-08-13 20:39:53');
INSERT INTO `cp_log` VALUES ('30', 'aaa', '修改管理员信息', '2018-08-13 20:40:13', '2018-08-13 20:40:13');
INSERT INTO `cp_log` VALUES ('31', 'bbb', '登录', '2018-08-14 11:42:14', '2018-08-14 11:42:14');
INSERT INTO `cp_log` VALUES ('32', 'bbb', '查看管理员列表', '2018-08-14 11:42:23', '2018-08-14 11:42:23');
INSERT INTO `cp_log` VALUES ('33', 'bbb', '查看申请列表', '2018-08-14 11:42:31', '2018-08-14 11:42:31');
INSERT INTO `cp_log` VALUES ('34', 'bbb', '查看文章具体内容', '2018-08-14 11:42:37', '2018-08-14 11:42:37');
INSERT INTO `cp_log` VALUES ('35', 'bbb', '查看文章列表', '2018-08-14 11:42:41', '2018-08-14 11:42:41');
INSERT INTO `cp_log` VALUES ('36', 'bbb', '查看文章具体内容', '2018-08-14 11:42:49', '2018-08-14 11:42:49');
INSERT INTO `cp_log` VALUES ('37', 'bbb', '修改文章类型', '2018-08-14 11:42:52', '2018-08-14 11:42:52');
INSERT INTO `cp_log` VALUES ('38', 'bbb', '查看申请列表', '2018-08-14 11:43:01', '2018-08-14 11:43:02');
INSERT INTO `cp_log` VALUES ('39', 'bbb', '查看申请具体信息', '2018-08-14 11:43:05', '2018-08-14 11:43:05');
INSERT INTO `cp_log` VALUES ('40', 'bbb', '查看申请列表', '2018-08-14 11:43:10', '2018-08-14 11:43:10');
INSERT INTO `cp_log` VALUES ('41', 'bbb', '查看申请类型列表', '2018-08-14 11:43:12', '2018-08-14 11:43:12');
INSERT INTO `cp_log` VALUES ('42', 'bbb', '查看用户列表', '2018-08-14 11:43:25', '2018-08-14 11:43:25');
INSERT INTO `cp_log` VALUES ('43', 'bbb', '查看用户列表', '2018-08-14 11:43:27', '2018-08-14 11:43:27');
INSERT INTO `cp_log` VALUES ('44', 'bbb', '查看用户列表', '2018-08-14 11:43:28', '2018-08-14 11:43:28');
INSERT INTO `cp_log` VALUES ('45', 'aaa', '登录', '2018-08-18 10:12:58', '2018-08-18 10:12:58');
INSERT INTO `cp_log` VALUES ('46', 'aaa', '登录', '2018-08-18 10:13:02', '2018-08-18 10:13:02');
INSERT INTO `cp_log` VALUES ('47', 'aaa', '查看申请列表', '2018-08-18 10:17:02', '2018-08-18 10:17:02');
INSERT INTO `cp_log` VALUES ('48', 'bbb', '登录', '2018-08-18 10:19:29', '2018-08-18 10:19:29');
INSERT INTO `cp_log` VALUES ('49', 'bbb', '登录', '2018-08-18 10:27:57', '2018-08-18 10:27:57');
INSERT INTO `cp_log` VALUES ('50', 'bbb', '登录', '2018-08-18 10:28:57', '2018-08-18 10:28:57');
INSERT INTO `cp_log` VALUES ('51', 'bbb', '登录', '2018-08-21 08:26:47', '2018-08-21 08:26:47');
INSERT INTO `cp_log` VALUES ('52', 'bbb', '查看申请列表', '2018-08-21 08:26:50', '2018-08-21 08:26:50');
INSERT INTO `cp_log` VALUES ('53', 'bbb', '查看文章具体内容', '2018-08-21 08:27:18', '2018-08-21 08:27:19');
INSERT INTO `cp_log` VALUES ('54', 'bbb', '查看文章列表', '2018-08-21 08:27:22', '2018-08-21 08:27:22');
INSERT INTO `cp_log` VALUES ('55', 'bbb', '查看文章具体内容', '2018-08-21 08:27:24', '2018-08-21 08:27:24');
INSERT INTO `cp_log` VALUES ('56', 'bbb', '修改文章类型', '2018-08-21 08:27:36', '2018-08-21 08:27:36');
INSERT INTO `cp_log` VALUES ('57', 'bbb', '查看文章列表', '2018-08-21 08:37:29', '2018-08-21 08:37:29');
INSERT INTO `cp_log` VALUES ('58', 'bbb', '查看文章列表', '2018-08-21 08:37:31', '2018-08-21 08:37:31');
INSERT INTO `cp_log` VALUES ('59', 'bbb', '查看文章列表', '2018-08-21 08:37:37', '2018-08-21 08:37:37');
INSERT INTO `cp_log` VALUES ('60', 'bbb', '查看文章列表', '2018-08-21 08:38:22', '2018-08-21 08:38:22');
INSERT INTO `cp_log` VALUES ('61', 'bbb', '查看文章列表', '2018-08-21 08:38:26', '2018-08-21 08:38:26');
INSERT INTO `cp_log` VALUES ('62', 'bbb', '查看文章列表', '2018-08-21 08:38:52', '2018-08-21 08:38:52');
INSERT INTO `cp_log` VALUES ('63', 'bbb', '查看文章列表', '2018-08-21 08:39:23', '2018-08-21 08:39:23');
INSERT INTO `cp_log` VALUES ('64', 'bbb', '查看文章列表', '2018-08-21 08:39:48', '2018-08-21 08:39:48');
INSERT INTO `cp_log` VALUES ('65', 'bbb', '登录', '2018-08-21 08:41:18', '2018-08-21 08:41:18');
INSERT INTO `cp_log` VALUES ('66', 'bbb', '查看申请列表', '2018-08-21 08:41:24', '2018-08-21 08:41:24');
INSERT INTO `cp_log` VALUES ('67', 'bbb', '查看申请具体信息', '2018-08-21 08:41:26', '2018-08-21 08:41:26');
INSERT INTO `cp_log` VALUES ('68', 'bbb', '查看申请列表', '2018-08-21 08:41:32', '2018-08-21 08:41:32');
INSERT INTO `cp_log` VALUES ('69', 'bbb', '查看申请具体信息', '2018-08-21 08:41:34', '2018-08-21 08:41:34');
INSERT INTO `cp_log` VALUES ('70', 'bbb', '查看申请列表', '2018-08-21 08:41:39', '2018-08-21 08:41:39');
INSERT INTO `cp_log` VALUES ('71', 'bbb', '查看申请列表', '2018-08-21 08:42:18', '2018-08-21 08:42:18');
INSERT INTO `cp_log` VALUES ('72', 'bbb', '查看申请列表', '2018-08-21 08:42:34', '2018-08-21 08:42:34');
INSERT INTO `cp_log` VALUES ('73', 'bbb', '查询申请', '2018-08-21 08:42:36', '2018-08-21 08:42:36');
INSERT INTO `cp_log` VALUES ('74', 'bbb', '查看申请列表', '2018-08-21 08:42:57', '2018-08-21 08:42:57');
INSERT INTO `cp_log` VALUES ('75', 'bbb', '查询申请', '2018-08-21 08:43:01', '2018-08-21 08:43:02');
INSERT INTO `cp_log` VALUES ('76', 'bbb', '登录', '2018-08-21 08:45:40', '2018-08-21 08:45:40');
INSERT INTO `cp_log` VALUES ('77', 'bbb', '查看申请列表', '2018-08-21 08:45:44', '2018-08-21 08:45:44');
INSERT INTO `cp_log` VALUES ('78', 'bbb', '查看申请类型列表', '2018-08-21 08:45:45', '2018-08-21 08:45:45');
INSERT INTO `cp_log` VALUES ('79', 'bbb', '查看申请类型列表', '2018-08-21 08:45:57', '2018-08-21 08:45:57');
INSERT INTO `cp_log` VALUES ('80', 'bbb', '停用申请类型', '2018-08-21 08:46:01', '2018-08-21 08:46:01');
INSERT INTO `cp_log` VALUES ('81', 'bbb', '查询申请', '2018-08-21 08:46:11', '2018-08-21 08:46:11');
INSERT INTO `cp_log` VALUES ('82', 'bbb', '登录', '2018-08-21 08:50:33', '2018-08-21 08:50:33');
INSERT INTO `cp_log` VALUES ('83', 'bbb', '查看申请列表', '2018-08-21 08:50:35', '2018-08-21 08:50:35');
INSERT INTO `cp_log` VALUES ('84', 'bbb', '查询申请', '2018-08-21 08:50:45', '2018-08-21 08:50:45');
INSERT INTO `cp_log` VALUES ('85', 'bbb', '登录', '2018-08-21 08:53:23', '2018-08-21 08:53:23');
INSERT INTO `cp_log` VALUES ('86', 'bbb', '查看申请列表', '2018-08-21 08:53:28', '2018-08-21 08:53:28');
INSERT INTO `cp_log` VALUES ('87', 'bbb', '查询申请', '2018-08-21 08:53:36', '2018-08-21 08:53:36');
INSERT INTO `cp_log` VALUES ('88', 'bbb', '查看申请列表', '2018-08-21 08:54:06', '2018-08-21 08:54:06');
INSERT INTO `cp_log` VALUES ('89', 'bbb', '查询申请', '2018-08-21 08:54:11', '2018-08-21 08:54:11');
INSERT INTO `cp_log` VALUES ('90', 'bbb', '登录', '2018-08-21 09:04:22', '2018-08-21 09:04:22');
INSERT INTO `cp_log` VALUES ('91', 'bbb', '查看申请列表', '2018-08-21 09:04:24', '2018-08-21 09:04:24');
INSERT INTO `cp_log` VALUES ('92', 'bbb', '查询申请', '2018-08-21 09:04:36', '2018-08-21 09:04:36');
INSERT INTO `cp_log` VALUES ('93', 'bbb', '登录', '2018-08-21 09:05:33', '2018-08-21 09:05:33');
INSERT INTO `cp_log` VALUES ('94', 'bbb', '查看申请列表', '2018-08-21 09:05:35', '2018-08-21 09:05:35');
INSERT INTO `cp_log` VALUES ('95', 'bbb', '查询申请', '2018-08-21 09:11:54', '2018-08-21 09:11:54');
INSERT INTO `cp_log` VALUES ('96', 'bbb', '查看申请列表', '2018-08-21 09:13:05', '2018-08-21 09:13:05');
INSERT INTO `cp_log` VALUES ('97', 'bbb', '查询申请', '2018-08-21 09:13:17', '2018-08-21 09:13:17');
INSERT INTO `cp_log` VALUES ('98', 'bbb', '登录', '2018-08-21 09:13:32', '2018-08-21 09:13:32');
INSERT INTO `cp_log` VALUES ('99', 'bbb', '查看申请列表', '2018-08-21 09:13:35', '2018-08-21 09:13:35');
INSERT INTO `cp_log` VALUES ('100', 'bbb', '查询申请', '2018-08-21 09:13:39', '2018-08-21 09:13:39');
INSERT INTO `cp_log` VALUES ('101', 'aaa', '登录', '2018-08-21 09:15:33', '2018-08-21 09:15:33');
INSERT INTO `cp_log` VALUES ('102', 'aaa', '查看申请列表', '2018-08-21 09:15:38', '2018-08-21 09:15:38');
INSERT INTO `cp_log` VALUES ('103', 'aaa', '查询申请', '2018-08-21 09:15:49', '2018-08-21 09:15:49');
INSERT INTO `cp_log` VALUES ('104', 'bbb', '登录', '2018-08-21 09:17:55', '2018-08-21 09:17:55');
INSERT INTO `cp_log` VALUES ('105', 'bbb', '查看申请列表', '2018-08-21 09:17:58', '2018-08-21 09:17:58');
INSERT INTO `cp_log` VALUES ('106', 'bbb', '查询申请', '2018-08-21 09:18:10', '2018-08-21 09:18:10');
INSERT INTO `cp_log` VALUES ('107', 'bbb', '查看申请列表', '2018-08-21 09:18:29', '2018-08-21 09:18:29');
INSERT INTO `cp_log` VALUES ('108', 'bbb', '查询申请', '2018-08-21 09:18:34', '2018-08-21 09:18:34');
INSERT INTO `cp_log` VALUES ('109', 'bbb', '登录', '2018-08-21 09:19:37', '2018-08-21 09:19:37');
INSERT INTO `cp_log` VALUES ('110', 'bbb', '查看申请列表', '2018-08-21 09:19:39', '2018-08-21 09:19:39');
INSERT INTO `cp_log` VALUES ('111', 'bbb', '查询申请', '2018-08-21 09:19:43', '2018-08-21 09:19:43');
INSERT INTO `cp_log` VALUES ('112', 'bbb', '登录', '2018-08-21 09:24:35', '2018-08-21 09:24:35');
INSERT INTO `cp_log` VALUES ('113', 'bbb', '查看申请列表', '2018-08-21 09:24:37', '2018-08-21 09:24:37');
INSERT INTO `cp_log` VALUES ('114', 'bbb', '查询申请', '2018-08-21 09:24:41', '2018-08-21 09:24:41');
INSERT INTO `cp_log` VALUES ('115', 'bbb', '查询申请', '2018-08-21 09:24:46', '2018-08-21 09:24:46');
INSERT INTO `cp_log` VALUES ('116', 'bbb', '查看申请列表', '2018-08-21 09:25:01', '2018-08-21 09:25:01');
INSERT INTO `cp_log` VALUES ('117', 'bbb', '查看申请类型列表', '2018-08-21 09:26:55', '2018-08-21 09:26:55');
INSERT INTO `cp_log` VALUES ('118', 'bbb', '查看申请类型列表', '2018-08-21 09:27:10', '2018-08-21 09:27:10');
INSERT INTO `cp_log` VALUES ('119', 'bbb', '查看申请类型列表', '2018-08-21 09:27:37', '2018-08-21 09:27:37');
INSERT INTO `cp_log` VALUES ('120', 'bbb', '登录', '2018-08-21 09:29:54', '2018-08-21 09:29:54');
INSERT INTO `cp_log` VALUES ('121', 'bbb', '查看申请列表', '2018-08-21 09:29:56', '2018-08-21 09:29:56');
INSERT INTO `cp_log` VALUES ('122', 'bbb', '查询申请', '2018-08-21 09:30:06', '2018-08-21 09:30:06');
INSERT INTO `cp_log` VALUES ('123', 'bbb', '查看申请列表', '2018-08-21 09:30:17', '2018-08-21 09:30:17');
INSERT INTO `cp_log` VALUES ('124', 'bbb', '查询申请', '2018-08-21 09:30:21', '2018-08-21 09:30:21');
INSERT INTO `cp_log` VALUES ('125', 'bbb', '查看申请类型列表', '2018-08-21 09:30:44', '2018-08-21 09:30:44');
INSERT INTO `cp_log` VALUES ('126', 'bbb', '增加申请类型', '2018-08-21 09:30:49', '2018-08-21 09:30:49');
INSERT INTO `cp_log` VALUES ('127', 'bbb', '查看申请列表', '2018-08-21 09:30:54', '2018-08-21 09:30:54');
INSERT INTO `cp_log` VALUES ('128', 'bbb', '查询申请', '2018-08-21 09:31:06', '2018-08-21 09:31:06');
INSERT INTO `cp_log` VALUES ('129', 'bbb', '查询申请', '2018-08-21 09:31:07', '2018-08-21 09:31:07');
INSERT INTO `cp_log` VALUES ('130', 'bbb', '查询申请', '2018-08-21 09:31:08', '2018-08-21 09:31:08');
INSERT INTO `cp_log` VALUES ('131', 'bbb', '查询申请', '2018-08-21 09:31:08', '2018-08-21 09:31:08');
INSERT INTO `cp_log` VALUES ('132', 'bbb', '查询申请', '2018-08-21 09:31:14', '2018-08-21 09:31:14');
INSERT INTO `cp_log` VALUES ('133', 'bbb', '查询申请', '2018-08-21 09:31:18', '2018-08-21 09:31:18');
INSERT INTO `cp_log` VALUES ('134', 'bbb', '登录', '2018-08-21 09:33:06', '2018-08-21 09:33:06');
INSERT INTO `cp_log` VALUES ('135', 'bbb', '查看申请列表', '2018-08-21 09:33:08', '2018-08-21 09:33:08');
INSERT INTO `cp_log` VALUES ('136', 'bbb', '查询申请', '2018-08-21 09:33:15', '2018-08-21 09:33:15');
INSERT INTO `cp_log` VALUES ('137', 'bbb', '登录', '2018-08-21 09:34:17', '2018-08-21 09:34:17');
INSERT INTO `cp_log` VALUES ('138', 'bbb', '查看申请类型列表', '2018-08-21 09:34:19', '2018-08-21 09:34:19');
INSERT INTO `cp_log` VALUES ('139', 'bbb', '查看申请列表', '2018-08-21 09:34:23', '2018-08-21 09:34:23');
INSERT INTO `cp_log` VALUES ('140', 'bbb', '查询申请', '2018-08-21 09:34:26', '2018-08-21 09:34:26');
INSERT INTO `cp_log` VALUES ('141', 'bbb', '查询申请', '2018-08-21 09:34:28', '2018-08-21 09:34:28');
INSERT INTO `cp_log` VALUES ('142', 'bbb', '查询申请', '2018-08-21 09:34:31', '2018-08-21 09:34:31');
INSERT INTO `cp_log` VALUES ('143', 'bbb', '查询申请', '2018-08-21 09:34:34', '2018-08-21 09:34:34');
INSERT INTO `cp_log` VALUES ('144', 'bbb', '登录', '2018-08-21 09:35:22', '2018-08-21 09:35:22');
INSERT INTO `cp_log` VALUES ('145', 'bbb', '查看申请列表', '2018-08-21 09:35:24', '2018-08-21 09:35:24');
INSERT INTO `cp_log` VALUES ('146', 'bbb', '查询申请', '2018-08-21 09:35:27', '2018-08-21 09:35:27');
INSERT INTO `cp_log` VALUES ('147', 'bbb', '查询申请', '2018-08-21 09:35:32', '2018-08-21 09:35:32');
INSERT INTO `cp_log` VALUES ('148', 'bbb', '查询申请', '2018-08-21 09:35:34', '2018-08-21 09:35:34');
INSERT INTO `cp_log` VALUES ('149', 'bbb', '查询申请', '2018-08-21 09:35:37', '2018-08-21 09:35:37');
INSERT INTO `cp_log` VALUES ('150', 'bbb', '登录', '2018-08-21 09:37:00', '2018-08-21 09:37:00');
INSERT INTO `cp_log` VALUES ('151', 'bbb', '查看申请列表', '2018-08-21 09:37:04', '2018-08-21 09:37:04');
INSERT INTO `cp_log` VALUES ('152', 'bbb', '查询申请', '2018-08-21 09:37:11', '2018-08-21 09:37:11');
INSERT INTO `cp_log` VALUES ('153', 'bbb', '查询申请', '2018-08-21 09:37:14', '2018-08-21 09:37:14');
INSERT INTO `cp_log` VALUES ('154', 'bbb', '查询申请', '2018-08-21 09:37:15', '2018-08-21 09:37:15');
INSERT INTO `cp_log` VALUES ('155', 'bbb', '查询申请', '2018-08-21 09:37:17', '2018-08-21 09:37:17');
INSERT INTO `cp_log` VALUES ('156', 'bbb', '查询申请', '2018-08-21 09:37:20', '2018-08-21 09:37:20');
INSERT INTO `cp_log` VALUES ('157', 'bbb', '查询申请', '2018-08-21 09:37:22', '2018-08-21 09:37:22');
INSERT INTO `cp_log` VALUES ('158', 'bbb', '查询申请', '2018-08-21 09:37:22', '2018-08-21 09:37:22');
INSERT INTO `cp_log` VALUES ('159', 'bbb', '查询申请', '2018-08-21 09:37:29', '2018-08-21 09:37:29');
INSERT INTO `cp_log` VALUES ('160', 'bbb', '查询申请', '2018-08-21 09:38:03', '2018-08-21 09:38:03');
INSERT INTO `cp_log` VALUES ('161', 'bbb', '查询申请', '2018-08-21 09:38:44', '2018-08-21 09:38:44');
INSERT INTO `cp_log` VALUES ('162', 'bbb', '查看申请类型列表', '2018-08-21 09:43:30', '2018-08-21 09:43:30');
INSERT INTO `cp_log` VALUES ('163', 'bbb', '登录', '2018-08-21 09:45:45', '2018-08-21 09:45:45');
INSERT INTO `cp_log` VALUES ('164', 'bbb', '查看申请类型列表', '2018-08-21 09:45:47', '2018-08-21 09:45:47');
INSERT INTO `cp_log` VALUES ('165', 'bbb', '增加申请类型', '2018-08-21 09:45:52', '2018-08-21 09:45:52');
INSERT INTO `cp_log` VALUES ('166', 'bbb', '查看申请类型列表', '2018-08-21 09:45:52', '2018-08-21 09:45:52');
INSERT INTO `cp_log` VALUES ('167', 'bbb', '查看申请列表', '2018-08-21 09:45:57', '2018-08-21 09:45:57');
INSERT INTO `cp_log` VALUES ('168', 'bbb', '查询申请', '2018-08-21 09:46:00', '2018-08-21 09:46:00');
INSERT INTO `cp_log` VALUES ('169', 'bbb', '查询申请', '2018-08-21 09:46:04', '2018-08-21 09:46:04');
INSERT INTO `cp_log` VALUES ('170', 'bbb', '登录', '2018-08-21 09:47:19', '2018-08-21 09:47:19');
INSERT INTO `cp_log` VALUES ('171', 'bbb', '查看申请列表', '2018-08-21 09:47:23', '2018-08-21 09:47:23');
INSERT INTO `cp_log` VALUES ('172', 'bbb', '查询申请', '2018-08-21 09:47:26', '2018-08-21 09:47:26');
INSERT INTO `cp_log` VALUES ('173', 'bbb', '查询申请', '2018-08-21 09:47:30', '2018-08-21 09:47:30');
INSERT INTO `cp_log` VALUES ('174', 'bbb', '登录', '2018-08-21 09:48:18', '2018-08-21 09:48:18');
INSERT INTO `cp_log` VALUES ('175', 'bbb', '查看申请列表', '2018-08-21 09:48:20', '2018-08-21 09:48:20');
INSERT INTO `cp_log` VALUES ('176', 'bbb', '查询申请', '2018-08-21 09:48:25', '2018-08-21 09:48:25');
INSERT INTO `cp_log` VALUES ('177', 'bbb', '查询申请', '2018-08-21 09:48:28', '2018-08-21 09:48:28');
INSERT INTO `cp_log` VALUES ('178', 'bbb', '登录', '2018-08-21 09:57:57', '2018-08-21 09:57:57');
INSERT INTO `cp_log` VALUES ('179', 'bbb', '登录', '2018-08-21 09:58:04', '2018-08-21 09:58:04');
INSERT INTO `cp_log` VALUES ('180', 'bbb', '查看申请列表', '2018-08-21 09:58:08', '2018-08-21 09:58:08');
INSERT INTO `cp_log` VALUES ('181', 'bbb', '查询申请', '2018-08-21 09:58:14', '2018-08-21 09:58:14');
INSERT INTO `cp_log` VALUES ('182', 'bbb', '查询申请', '2018-08-21 09:58:18', '2018-08-21 09:58:18');
INSERT INTO `cp_log` VALUES ('183', 'bbb', '登录', '2018-08-21 09:59:32', '2018-08-21 09:59:32');
INSERT INTO `cp_log` VALUES ('184', 'bbb', '查看申请列表', '2018-08-21 09:59:33', '2018-08-21 09:59:33');
INSERT INTO `cp_log` VALUES ('185', 'bbb', '查询申请', '2018-08-21 09:59:37', '2018-08-21 09:59:37');
INSERT INTO `cp_log` VALUES ('186', 'bbb', '登录', '2018-08-21 10:00:41', '2018-08-21 10:00:41');
INSERT INTO `cp_log` VALUES ('187', 'bbb', '查看申请列表', '2018-08-21 10:00:43', '2018-08-21 10:00:43');
INSERT INTO `cp_log` VALUES ('188', 'bbb', '查询申请', '2018-08-21 10:00:46', '2018-08-21 10:00:46');
INSERT INTO `cp_log` VALUES ('189', 'bbb', '登录', '2018-08-21 10:01:09', '2018-08-21 10:01:09');
INSERT INTO `cp_log` VALUES ('190', 'bbb', '查看申请列表', '2018-08-21 10:01:12', '2018-08-21 10:01:12');
INSERT INTO `cp_log` VALUES ('191', 'bbb', '查询申请', '2018-08-21 10:01:21', '2018-08-21 10:01:21');
INSERT INTO `cp_log` VALUES ('192', 'bbb', '查询申请', '2018-08-21 10:01:25', '2018-08-21 10:01:25');
INSERT INTO `cp_log` VALUES ('193', 'bbb', '查询申请', '2018-08-21 10:01:28', '2018-08-21 10:01:28');
INSERT INTO `cp_log` VALUES ('194', 'bbb', '查询申请', '2018-08-21 10:01:31', '2018-08-21 10:01:31');
INSERT INTO `cp_log` VALUES ('195', 'bbb', '查看申请类型列表', '2018-08-21 10:01:53', '2018-08-21 10:01:53');
INSERT INTO `cp_log` VALUES ('196', 'bbb', '停用申请类型', '2018-08-21 10:01:56', '2018-08-21 10:01:56');
INSERT INTO `cp_log` VALUES ('197', 'bbb', '查看用户列表', '2018-08-21 10:02:18', '2018-08-21 10:02:18');
INSERT INTO `cp_log` VALUES ('198', 'bbb', '查看用户列表', '2018-08-21 10:02:21', '2018-08-21 10:02:21');
INSERT INTO `cp_log` VALUES ('199', 'bbb', '登录', '2018-08-21 11:06:42', '2018-08-21 11:06:42');
INSERT INTO `cp_log` VALUES ('200', 'bbb', '查看申请列表', '2018-08-21 11:11:58', '2018-08-21 11:11:58');
INSERT INTO `cp_log` VALUES ('201', 'bbb', '查看申请类型列表', '2018-08-21 11:11:59', '2018-08-21 11:11:59');
INSERT INTO `cp_log` VALUES ('202', 'bbb', '查看申请列表', '2018-08-21 11:12:01', '2018-08-21 11:12:01');
INSERT INTO `cp_log` VALUES ('203', 'bbb', '查看文章列表', '2018-08-21 11:12:01', '2018-08-21 11:12:01');
INSERT INTO `cp_log` VALUES ('204', 'bbb', '修改文章类型', '2018-08-21 11:12:02', '2018-08-21 11:12:02');
INSERT INTO `cp_log` VALUES ('205', 'bbb', '登录', '2018-08-21 15:52:28', '2018-08-21 15:52:28');
INSERT INTO `cp_log` VALUES ('206', 'bbb', '登录', '2018-08-21 15:55:27', '2018-08-21 15:55:27');
INSERT INTO `cp_log` VALUES ('207', 'bbb', '登录', '2018-08-21 15:57:45', '2018-08-21 15:57:45');
INSERT INTO `cp_log` VALUES ('208', 'bbb', '登录', '2018-08-21 16:05:02', '2018-08-21 16:05:02');
INSERT INTO `cp_log` VALUES ('209', 'bbb', '登录', '2018-08-21 16:07:42', '2018-08-21 16:07:42');
INSERT INTO `cp_log` VALUES ('210', 'bbb', '登录', '2018-08-21 16:11:22', '2018-08-21 16:11:22');
INSERT INTO `cp_log` VALUES ('211', 'bbb', '登录', '2018-08-21 16:12:22', '2018-08-21 16:12:22');
INSERT INTO `cp_log` VALUES ('212', 'bbb', '登录', '2018-08-21 16:13:15', '2018-08-21 16:13:15');
INSERT INTO `cp_log` VALUES ('213', 'bbb', '登录', '2018-08-21 16:14:55', '2018-08-21 16:14:55');
INSERT INTO `cp_log` VALUES ('214', 'bbb', '登录', '2018-08-21 16:16:08', '2018-08-21 16:16:08');
INSERT INTO `cp_log` VALUES ('215', 'bbb', '登录', '2018-08-21 16:21:00', '2018-08-21 16:21:01');
INSERT INTO `cp_log` VALUES ('216', 'bbb', '登录', '2018-08-21 16:22:33', '2018-08-21 16:22:33');
INSERT INTO `cp_log` VALUES ('217', 'bbb', '登录', '2018-08-21 16:22:38', '2018-08-21 16:22:38');
INSERT INTO `cp_log` VALUES ('218', 'bbb', '登录', '2018-08-21 16:26:31', '2018-08-21 16:26:31');
INSERT INTO `cp_log` VALUES ('219', 'bbb', '登录', '2018-08-21 16:26:35', '2018-08-21 16:26:35');
INSERT INTO `cp_log` VALUES ('220', 'bbb', '登录', '2018-08-21 16:28:00', '2018-08-21 16:28:00');
INSERT INTO `cp_log` VALUES ('221', 'bbb', '登录', '2018-08-21 16:29:58', '2018-08-21 16:29:58');
INSERT INTO `cp_log` VALUES ('222', 'bbb', '修改文章类型', '2018-08-21 16:59:09', '2018-08-21 16:59:09');
INSERT INTO `cp_log` VALUES ('223', 'bbb', '登录', '2018-08-21 17:02:44', '2018-08-21 17:02:44');
INSERT INTO `cp_log` VALUES ('224', 'bbb', '登录', '2018-08-21 17:13:59', '2018-08-21 17:13:59');
INSERT INTO `cp_log` VALUES ('225', 'bbb', '登录', '2018-08-21 17:27:26', '2018-08-21 17:27:26');
INSERT INTO `cp_log` VALUES ('226', 'bbb', '登录', '2018-08-21 17:32:02', '2018-08-21 17:32:02');
INSERT INTO `cp_log` VALUES ('227', 'bbb', '登录', '2018-08-21 17:33:57', '2018-08-21 17:33:57');
INSERT INTO `cp_log` VALUES ('228', 'bbb', '登录', '2018-08-21 17:41:06', '2018-08-21 17:41:06');
INSERT INTO `cp_log` VALUES ('229', 'bbb', '登录', '2018-08-21 17:45:40', '2018-08-21 17:45:40');
INSERT INTO `cp_log` VALUES ('230', 'bbb', '登录', '2018-08-21 20:27:43', '2018-08-21 20:27:44');
INSERT INTO `cp_log` VALUES ('231', 'bbb', '登录', '2018-08-21 20:31:22', '2018-08-21 20:31:22');
INSERT INTO `cp_log` VALUES ('232', 'bbb', '登录', '2018-08-21 20:37:13', '2018-08-21 20:37:13');
INSERT INTO `cp_log` VALUES ('233', 'bbb', '登录', '2018-08-21 20:39:23', '2018-08-21 20:39:23');
INSERT INTO `cp_log` VALUES ('234', 'bbb', '登录', '2018-08-21 20:40:03', '2018-08-21 20:40:03');
INSERT INTO `cp_log` VALUES ('235', 'bbb', '登录', '2018-08-21 20:43:06', '2018-08-21 20:43:06');
INSERT INTO `cp_log` VALUES ('236', 'bbb', '登录', '2018-08-22 09:59:27', '2018-08-22 09:59:27');
INSERT INTO `cp_log` VALUES ('237', 'bbb', '登录', '2018-08-22 10:06:39', '2018-08-22 10:06:39');
INSERT INTO `cp_log` VALUES ('238', 'bbb', '登录', '2018-08-22 10:09:42', '2018-08-22 10:09:42');
INSERT INTO `cp_log` VALUES ('239', 'bbb', '登录', '2018-08-22 10:10:33', '2018-08-22 10:10:33');
INSERT INTO `cp_log` VALUES ('240', 'bbb', '查看文章列表', '2018-08-23 10:50:37', '2018-08-23 10:50:37');
INSERT INTO `cp_log` VALUES ('241', 'bbb', '查看文章列表', '2018-08-23 10:52:57', '2018-08-23 10:52:57');
INSERT INTO `cp_log` VALUES ('242', 'bbb', '修改文章类型', '2018-08-23 10:53:57', '2018-08-23 10:53:57');
INSERT INTO `cp_log` VALUES ('243', 'bbb', '查看文章列表', '2018-08-23 10:54:00', '2018-08-23 10:54:00');
INSERT INTO `cp_log` VALUES ('244', 'bbb', '下架文章', '2018-08-23 10:54:04', '2018-08-23 10:54:04');
INSERT INTO `cp_log` VALUES ('245', 'bbb', '查看文章列表', '2018-08-23 10:54:04', '2018-08-23 10:54:04');
INSERT INTO `cp_log` VALUES ('246', 'bbb', '查看文章列表', '2018-08-25 20:33:53', '2018-08-25 20:33:53');
INSERT INTO `cp_log` VALUES ('247', 'bbb', '查询文章信息', '2018-08-25 20:34:00', '2018-08-25 20:34:00');
INSERT INTO `cp_log` VALUES ('248', 'bbb', '查看文章列表', '2018-08-25 20:41:26', '2018-08-25 20:41:26');
INSERT INTO `cp_log` VALUES ('249', 'bbb', '查询文章信息', '2018-08-25 20:41:28', '2018-08-25 20:41:28');
INSERT INTO `cp_log` VALUES ('250', 'bbb', '查看管理员列表', '2018-08-26 15:37:25', '2018-08-26 15:37:25');
INSERT INTO `cp_log` VALUES ('251', 'bbb', '查看用户列表', '2018-08-26 15:37:50', '2018-08-26 15:37:50');
INSERT INTO `cp_log` VALUES ('252', 'bbb', '查看管理员列表', '2018-08-26 15:37:58', '2018-08-26 15:37:58');
INSERT INTO `cp_log` VALUES ('253', 'bbb', '查看管理员列表', '2018-08-26 15:38:43', '2018-08-26 15:38:43');
INSERT INTO `cp_log` VALUES ('254', 'bbb', '查看用户列表', '2018-08-26 15:40:24', '2018-08-26 15:40:24');
INSERT INTO `cp_log` VALUES ('255', 'bbb', '查看管理员列表', '2018-08-26 16:37:45', '2018-08-26 16:37:45');
INSERT INTO `cp_log` VALUES ('256', 'bbb', '增加管理员', '2018-08-26 16:37:55', '2018-08-26 16:37:55');
INSERT INTO `cp_log` VALUES ('257', 'bbb', '查看管理员列表', '2018-08-26 16:37:56', '2018-08-26 16:37:56');
INSERT INTO `cp_log` VALUES ('258', 'bbb', '查看用户列表', '2018-08-26 16:38:01', '2018-08-26 16:38:01');
INSERT INTO `cp_log` VALUES ('259', 'bbb', '查看管理员列表', '2018-08-26 16:38:05', '2018-08-26 16:38:05');
INSERT INTO `cp_log` VALUES ('260', 'bbb', '修改管理员信息', '2018-08-26 16:38:21', '2018-08-26 16:38:22');
INSERT INTO `cp_log` VALUES ('261', 'bbb', '修改管理员信息', '2018-08-26 16:38:27', '2018-08-26 16:38:27');
INSERT INTO `cp_log` VALUES ('262', 'ccc', '查看管理员列表', '2018-08-26 16:39:58', '2018-08-26 16:39:58');
INSERT INTO `cp_log` VALUES ('263', 'ccc', '修改管理员信息', '2018-08-26 16:40:11', '2018-08-26 16:40:11');
INSERT INTO `cp_log` VALUES ('264', 'bbb', '查看申请列表', '2018-08-26 16:46:54', '2018-08-26 16:46:54');
INSERT INTO `cp_log` VALUES ('265', 'bbb', '查看用户列表', '2018-08-26 16:47:08', '2018-08-26 16:47:08');
INSERT INTO `cp_log` VALUES ('266', 'bbb', '查看文章列表', '2018-08-26 17:00:17', '2018-08-26 17:00:17');
INSERT INTO `cp_log` VALUES ('267', 'aaa', '查看文章列表', '2018-08-26 17:06:58', '2018-08-26 17:06:58');
INSERT INTO `cp_log` VALUES ('268', 'aaa', '查看文章列表', '2018-08-26 17:07:16', '2018-08-26 17:07:16');
INSERT INTO `cp_log` VALUES ('269', 'ccc', '查看文章列表', '2018-08-26 17:08:09', '2018-08-26 17:08:09');
INSERT INTO `cp_log` VALUES ('270', 'ccc', '查看文章列表', '2018-08-26 17:08:31', '2018-08-26 17:08:31');
INSERT INTO `cp_log` VALUES ('271', 'bbb', '查看文章列表', '2018-08-26 17:08:44', '2018-08-26 17:08:44');
INSERT INTO `cp_log` VALUES ('272', 'bbb', '查看文章列表', '2018-08-26 17:09:37', '2018-08-26 17:09:37');
INSERT INTO `cp_log` VALUES ('273', 'bbb', '查看文章列表', '2018-08-26 17:10:21', '2018-08-26 17:10:21');
INSERT INTO `cp_log` VALUES ('274', 'bbb', '查看文章列表', '2018-08-26 17:11:57', '2018-08-26 17:11:57');
INSERT INTO `cp_log` VALUES ('275', 'bbb', '查看文章列表', '2018-08-26 17:19:39', '2018-08-26 17:19:39');
INSERT INTO `cp_log` VALUES ('276', 'bbb', '查看文章列表', '2018-08-26 17:25:37', '2018-08-26 17:25:37');
INSERT INTO `cp_log` VALUES ('277', 'bbb', '查看文章列表', '2018-08-26 17:26:20', '2018-08-26 17:26:20');
INSERT INTO `cp_log` VALUES ('278', 'bbb', '查看文章列表', '2018-08-26 17:29:40', '2018-08-26 17:29:40');
INSERT INTO `cp_log` VALUES ('279', 'bbb', '查看文章列表', '2018-08-26 17:30:05', '2018-08-26 17:30:05');
INSERT INTO `cp_log` VALUES ('280', 'bbb', '查看文章列表', '2018-08-26 17:30:14', '2018-08-26 17:30:14');
INSERT INTO `cp_log` VALUES ('281', 'bbb', '查看文章列表', '2018-08-26 17:30:33', '2018-08-26 17:30:33');
INSERT INTO `cp_log` VALUES ('282', 'bbb', '查看管理员列表', '2018-08-26 17:33:19', '2018-08-26 17:33:19');
INSERT INTO `cp_log` VALUES ('283', 'bbb', '查询管理员信息', '2018-08-26 17:33:26', '2018-08-26 17:33:26');
INSERT INTO `cp_log` VALUES ('284', 'bbb', '查看管理员列表', '2018-08-26 17:34:15', '2018-08-26 17:34:15');
INSERT INTO `cp_log` VALUES ('285', 'bbb', '查看管理员列表', '2018-08-26 17:35:07', '2018-08-26 17:35:07');
INSERT INTO `cp_log` VALUES ('286', 'bbb', '查看管理员列表', '2018-08-26 17:35:23', '2018-08-26 17:35:23');
INSERT INTO `cp_log` VALUES ('287', 'bbb', '查看管理员列表', '2018-08-26 17:35:31', '2018-08-26 17:35:31');
INSERT INTO `cp_log` VALUES ('288', 'bbb', '查看管理员列表', '2018-08-26 17:36:19', '2018-08-26 17:36:19');
INSERT INTO `cp_log` VALUES ('289', 'bbb', '查看申请列表', '2018-08-26 17:36:29', '2018-08-26 17:36:29');
INSERT INTO `cp_log` VALUES ('290', 'bbb', '修改文章类型', '2018-08-26 17:36:35', '2018-08-26 17:36:35');
INSERT INTO `cp_log` VALUES ('291', 'bbb', '查看申请类型列表', '2018-08-26 17:36:42', '2018-08-26 17:36:42');
INSERT INTO `cp_log` VALUES ('292', 'bbb', '查看申请列表', '2018-08-26 17:36:44', '2018-08-26 17:36:44');
INSERT INTO `cp_log` VALUES ('293', 'bbb', '查看用户列表', '2018-08-26 17:37:02', '2018-08-26 17:37:02');
INSERT INTO `cp_log` VALUES ('294', 'bbb', '查看用户列表', '2018-08-26 17:37:12', '2018-08-26 17:37:12');
INSERT INTO `cp_log` VALUES ('295', 'bbb', '查看用户列表', '2018-08-26 17:37:23', '2018-08-26 17:37:23');
INSERT INTO `cp_log` VALUES ('296', 'bbb', '查看用户列表', '2018-08-26 17:37:59', '2018-08-26 17:37:59');
INSERT INTO `cp_log` VALUES ('297', 'bbb', '查询用户信息', '2018-08-26 17:38:05', '2018-08-26 17:38:05');
INSERT INTO `cp_log` VALUES ('298', 'bbb', '查看用户列表', '2018-08-26 17:38:45', '2018-08-26 17:38:45');
INSERT INTO `cp_log` VALUES ('299', 'bbb', '登录', '2018-08-27 17:19:00', '2018-08-27 17:19:00');
INSERT INTO `cp_log` VALUES ('300', 'bbb', '查看管理员列表', '2018-08-27 17:19:03', '2018-08-27 17:19:03');
INSERT INTO `cp_log` VALUES ('301', 'bbb', '修改管理员信息', '2018-08-27 17:19:22', '2018-08-27 17:19:22');
INSERT INTO `cp_log` VALUES ('302', 'bbb', '查看申请列表', '2018-08-27 17:19:32', '2018-08-27 17:19:32');
INSERT INTO `cp_log` VALUES ('303', 'bbb', '查看文章具体内容', '2018-08-27 17:19:35', '2018-08-27 17:19:35');
INSERT INTO `cp_log` VALUES ('304', 'bbb', '登录', '2018-08-27 17:20:07', '2018-08-27 17:20:07');
INSERT INTO `cp_log` VALUES ('305', 'bbb', '查看申请列表', '2018-08-27 17:20:09', '2018-08-27 17:20:09');
INSERT INTO `cp_log` VALUES ('306', 'bbb', '同意申请', '2018-08-27 17:20:12', '2018-08-27 17:20:12');
INSERT INTO `cp_log` VALUES ('307', 'bbb', '查看申请列表', '2018-08-27 17:20:15', '2018-08-27 17:20:15');
INSERT INTO `cp_log` VALUES ('308', 'bbb', '查看文章列表', '2018-08-27 17:20:27', '2018-08-27 17:20:27');
INSERT INTO `cp_log` VALUES ('309', 'bbb', '查看文章列表', '2018-08-27 17:20:32', '2018-08-27 17:20:32');
INSERT INTO `cp_log` VALUES ('310', 'bbb', '修改文章类型', '2018-08-27 17:20:32', '2018-08-27 17:20:32');
INSERT INTO `cp_log` VALUES ('311', 'bbb', '修改申请列表', '2018-08-27 17:20:48', '2018-08-27 17:20:48');
INSERT INTO `cp_log` VALUES ('312', 'bbb', '修改文章类型', '2018-08-27 17:20:48', '2018-08-27 17:20:48');
INSERT INTO `cp_log` VALUES ('313', 'bbb', '登录', '2018-08-27 17:22:53', '2018-08-27 17:22:53');
INSERT INTO `cp_log` VALUES ('314', 'bbb', '修改文章类型', '2018-08-27 17:22:56', '2018-08-27 17:22:56');
INSERT INTO `cp_log` VALUES ('315', 'bbb', '登录', '2018-08-27 17:23:41', '2018-08-27 17:23:41');
INSERT INTO `cp_log` VALUES ('316', 'bbb', '修改文章类型', '2018-08-27 17:23:43', '2018-08-27 17:23:43');
INSERT INTO `cp_log` VALUES ('317', 'bbb', '登录', '2018-08-27 17:25:28', '2018-08-27 17:25:28');
INSERT INTO `cp_log` VALUES ('318', 'bbb', '修改文章类型', '2018-08-27 17:25:39', '2018-08-27 17:25:39');
INSERT INTO `cp_log` VALUES ('319', 'bbb', '登录', '2018-08-27 17:26:49', '2018-08-27 17:26:49');
INSERT INTO `cp_log` VALUES ('320', 'bbb', '修改文章类型', '2018-08-27 17:26:51', '2018-08-27 17:26:51');
INSERT INTO `cp_log` VALUES ('321', 'bbb', '增加文章类型', '2018-08-27 17:26:55', '2018-08-27 17:26:55');
INSERT INTO `cp_log` VALUES ('322', 'bbb', '修改文章类型', '2018-08-27 17:26:55', '2018-08-27 17:26:55');
INSERT INTO `cp_log` VALUES ('323', 'bbb', '删除文章类型', '2018-08-27 17:27:01', '2018-08-27 17:27:01');
INSERT INTO `cp_log` VALUES ('324', 'bbb', '查看申请列表', '2018-08-27 17:27:11', '2018-08-27 17:27:11');
INSERT INTO `cp_log` VALUES ('325', 'bbb', '查看申请具体信息', '2018-08-27 17:27:12', '2018-08-27 17:27:12');
INSERT INTO `cp_log` VALUES ('326', 'bbb', '查看申请列表', '2018-08-27 17:27:14', '2018-08-27 17:27:14');
INSERT INTO `cp_log` VALUES ('327', 'bbb', '查看申请类型列表', '2018-08-27 17:27:21', '2018-08-27 17:27:21');
INSERT INTO `cp_log` VALUES ('328', 'bbb', '停用申请类型', '2018-08-27 17:27:36', '2018-08-27 17:27:36');
INSERT INTO `cp_log` VALUES ('329', 'bbb', '登录', '2018-08-27 17:35:23', '2018-08-27 17:35:23');
INSERT INTO `cp_log` VALUES ('330', 'bbb', '查看管理员列表', '2018-08-27 17:35:25', '2018-08-27 17:35:25');
INSERT INTO `cp_log` VALUES ('331', 'bbb', '查看申请列表', '2018-08-27 17:36:13', '2018-08-27 17:36:13');
INSERT INTO `cp_log` VALUES ('332', 'bbb', '查看补卡列表', '2018-08-27 17:36:15', '2018-08-27 17:36:15');
INSERT INTO `cp_log` VALUES ('333', 'bbb', '查看补卡申请列表', '2018-08-27 17:36:30', '2018-08-27 17:36:30');
INSERT INTO `cp_log` VALUES ('334', 'bbb', '查看补卡列表', '2018-08-27 17:36:33', '2018-08-27 17:36:33');
INSERT INTO `cp_log` VALUES ('335', 'bbb', '查看用户列表', '2018-08-27 17:36:44', '2018-08-27 17:36:44');
INSERT INTO `cp_log` VALUES ('336', 'bbb', '添加id为50的用户为管理员', '2018-08-27 17:37:00', '2018-08-27 17:37:00');
INSERT INTO `cp_log` VALUES ('337', 'bbb', '查看用户列表', '2018-08-27 17:37:01', '2018-08-27 17:37:01');
INSERT INTO `cp_log` VALUES ('338', 'bbb', '查看用户列表', '2018-08-27 17:37:22', '2018-08-27 17:37:22');
INSERT INTO `cp_log` VALUES ('339', 'bbb', '查看用户列表', '2018-08-27 17:37:25', '2018-08-27 17:37:25');
INSERT INTO `cp_log` VALUES ('340', 'bbb', '查看具体项目信息', '2018-08-27 17:37:35', '2018-08-27 17:37:35');
INSERT INTO `cp_log` VALUES ('341', 'bbb', '查看项目进度', '2018-08-27 17:37:37', '2018-08-27 17:37:37');
INSERT INTO `cp_log` VALUES ('342', 'bbb', '选择打卡时间地点', '2018-08-27 17:37:40', '2018-08-27 17:37:40');
INSERT INTO `cp_log` VALUES ('343', 'bbb', '查看打卡地点列表', '2018-08-27 17:37:45', '2018-08-27 17:37:45');
INSERT INTO `cp_log` VALUES ('344', 'bbb', '获取打卡时间列表', '2018-08-27 17:37:49', '2018-08-27 17:37:49');
INSERT INTO `cp_log` VALUES ('345', 'bbb', '查看用户打卡记录列表', '2018-08-27 17:37:52', '2018-08-27 17:37:52');
INSERT INTO `cp_log` VALUES ('346', 'bbb', '登录', '2018-08-28 15:33:42', '2018-08-28 15:33:42');
INSERT INTO `cp_log` VALUES ('347', 'bbb', '查看文章列表', '2018-08-28 15:33:44', '2018-08-28 15:33:44');
INSERT INTO `cp_log` VALUES ('348', 'bbb', '查看文章具体内容', '2018-08-28 15:33:46', '2018-08-28 15:33:46');
INSERT INTO `cp_log` VALUES ('349', 'bbb', '修改文章类型', '2018-08-28 15:33:52', '2018-08-28 15:33:52');
INSERT INTO `cp_log` VALUES ('350', 'bbb', '查看文章列表', '2018-08-28 15:33:55', '2018-08-28 15:33:55');
INSERT INTO `cp_log` VALUES ('351', 'bbb', '登录', '2018-08-28 15:35:06', '2018-08-28 15:35:06');
INSERT INTO `cp_log` VALUES ('352', 'bbb', '查看文章列表', '2018-08-28 15:35:08', '2018-08-28 15:35:08');
INSERT INTO `cp_log` VALUES ('353', 'bbb', '查看文章列表', '2018-08-28 15:35:38', '2018-08-28 15:35:38');
INSERT INTO `cp_log` VALUES ('354', 'bbb', '登录', '2018-08-28 15:36:21', '2018-08-28 15:36:21');
INSERT INTO `cp_log` VALUES ('355', 'bbb', '查看文章列表', '2018-08-28 15:36:23', '2018-08-28 15:36:23');
INSERT INTO `cp_log` VALUES ('356', 'bbb', '登录', '2018-08-28 15:38:35', '2018-08-28 15:38:35');
INSERT INTO `cp_log` VALUES ('357', 'bbb', '查看文章列表', '2018-08-28 15:38:38', '2018-08-28 15:38:38');
INSERT INTO `cp_log` VALUES ('358', 'bbb', '查看文章列表', '2018-08-28 15:38:58', '2018-08-28 15:38:58');
INSERT INTO `cp_log` VALUES ('359', 'bbb', '登录', '2018-08-28 15:39:12', '2018-08-28 15:39:12');
INSERT INTO `cp_log` VALUES ('360', 'bbb', '查看文章列表', '2018-08-28 15:39:17', '2018-08-28 15:39:17');
INSERT INTO `cp_log` VALUES ('361', 'bbb', '登录', '2018-08-28 15:41:55', '2018-08-28 15:41:55');
INSERT INTO `cp_log` VALUES ('362', 'bbb', '登录', '2018-08-28 15:42:27', '2018-08-28 15:42:27');
INSERT INTO `cp_log` VALUES ('363', 'bbb', '登录', '2018-08-28 15:57:12', '2018-08-28 15:57:12');
INSERT INTO `cp_log` VALUES ('364', 'bbb', '修改文章类型', '2018-08-28 15:57:15', '2018-08-28 15:57:15');

-- ----------------------------
-- Table structure for cp_punch
-- ----------------------------
DROP TABLE IF EXISTS `cp_punch`;
CREATE TABLE `cp_punch` (
  `site_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `lng` double NOT NULL,
  `lat` double NOT NULL,
  `scope` int(50) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_punch
-- ----------------------------
INSERT INTO `cp_punch` VALUES ('1', '逸庐', '112.716033', '37.752627', '100', '2018-08-21 15:00:22', '2018-08-21 15:00:24');
INSERT INTO `cp_punch` VALUES ('2', '数港', '112.720314', '37.75258', '100', '2018-08-25 17:09:18', '2018-08-25 17:09:25');

-- ----------------------------
-- Table structure for cp_punch_time
-- ----------------------------
DROP TABLE IF EXISTS `cp_punch_time`;
CREATE TABLE `cp_punch_time` (
  `status` int(11) NOT NULL,
  `site_Id` int(11) NOT NULL,
  `time_id` int(11) NOT NULL AUTO_INCREMENT,
  `am_start_at` time DEFAULT NULL,
  `am_end_at` time DEFAULT NULL,
  `pm_start_at` time DEFAULT NULL,
  `pm_end_at` time DEFAULT NULL,
  `night_start_at` time DEFAULT NULL,
  `night_end_at` time DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_punch_time
-- ----------------------------
INSERT INTO `cp_punch_time` VALUES ('1', '1', '1', '08:30:00', '12:00:00', '19:20:00', '11:22:00', '13:00:00', '12:30:00', '2018-08-21 11:24:43', '2018-08-21 11:24:51');

-- ----------------------------
-- Table structure for cp_punch_user
-- ----------------------------
DROP TABLE IF EXISTS `cp_punch_user`;
CREATE TABLE `cp_punch_user` (
  `punch_id` int(11) NOT NULL AUTO_INCREMENT,
  `site_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `site_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_nick` varchar(255) COLLATE utf8_bin NOT NULL,
  `am_start_p` time DEFAULT NULL,
  `am_end_p` time DEFAULT NULL,
  `pm_start_p` time DEFAULT NULL,
  `pm_end_p` time DEFAULT NULL,
  `night_start_p` time DEFAULT NULL,
  `night_end_p` time DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`punch_id`),
  KEY `fk_name_h` (`user_id`),
  CONSTRAINT `fk_name_h` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_punch_user
-- ----------------------------
INSERT INTO `cp_punch_user` VALUES ('110', '逸庐', '1', '79', '昊宇里', '09:18:08', '10:24:38', '10:31:41', '10:56:01', null, null, '2018-08-25 00:00:00', '2018-08-25 00:00:00');
INSERT INTO `cp_punch_user` VALUES ('116', '叔叔数港', '1', '74', '杜宸霆', '09:12:00', '09:12:03', '09:12:06', '09:12:09', null, null, '2018-08-23 00:00:00', '2018-08-23 00:00:00');
INSERT INTO `cp_punch_user` VALUES ('117', 'APP', '1', '74', '杜宸霆', '12:18:33', null, '12:22:30', null, null, '12:26:13', '2018-08-24 00:00:00', '2018-08-24 00:00:00');
INSERT INTO `cp_punch_user` VALUES ('120', 'app', '1', '74', '杜宸霆', '09:12:12', '16:56:29', null, null, null, null, '2018-08-25 00:00:00', '2018-08-25 00:00:00');
INSERT INTO `cp_punch_user` VALUES ('121', 'app', '1', '74', '杜宸霆', null, '09:12:14', null, '09:12:16', '09:12:19', null, '2018-08-26 00:00:00', '2018-08-26 00:00:00');
INSERT INTO `cp_punch_user` VALUES ('122', '逸庐', '1', '66', '昊天大帝', null, null, null, null, null, null, '2018-08-28 16:45:25', '2018-08-28 16:45:25');

-- ----------------------------
-- Table structure for cp_supply_type
-- ----------------------------
DROP TABLE IF EXISTS `cp_supply_type`;
CREATE TABLE `cp_supply_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_supply_type
-- ----------------------------
INSERT INTO `cp_supply_type` VALUES ('1', '缺卡');
INSERT INTO `cp_supply_type` VALUES ('2', '迟到打卡');
INSERT INTO `cp_supply_type` VALUES ('3', '早退');

-- ----------------------------
-- Table structure for cp_time_name
-- ----------------------------
DROP TABLE IF EXISTS `cp_time_name`;
CREATE TABLE `cp_time_name` (
  `time_id` int(11) NOT NULL,
  `time_name` varchar(255) COLLATE utf8_bin NOT NULL,
  KEY `time_id` (`time_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_time_name
-- ----------------------------
INSERT INTO `cp_time_name` VALUES ('1', 'am_start_at');
INSERT INTO `cp_time_name` VALUES ('2', 'am_end_at');
INSERT INTO `cp_time_name` VALUES ('3', 'pm_start_at');
INSERT INTO `cp_time_name` VALUES ('4', 'pm_end_at');
INSERT INTO `cp_time_name` VALUES ('5', 'night_start_at');
INSERT INTO `cp_time_name` VALUES ('6', 'night_end_at');

-- ----------------------------
-- Table structure for cp_user
-- ----------------------------
DROP TABLE IF EXISTS `cp_user`;
CREATE TABLE `cp_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id,自增长',
  `avatar` varchar(1024) COLLATE utf8_bin NOT NULL DEFAULT 'https://pic.qqtn.com/up/2016-11/2016112511304065550.jpg',
  `user_nick` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '33',
  `signature` varchar(1024) COLLATE utf8_bin NOT NULL,
  `gender` int(1) NOT NULL DEFAULT '1',
  `status` int(1) NOT NULL DEFAULT '1',
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_user
-- ----------------------------
INSERT INTO `cp_user` VALUES ('37', 'C:\\Users\\Administrator\\Desktop\\zhx.jpg', 'ada', '暂无签名', '1', '1', '2018-08-03 13:41:39', '2018-08-03 13:41:39', null);
INSERT INTO `cp_user` VALUES ('38', 'adsds', 'ada', '暂无签名', '1', '1', '2018-08-03 13:47:07', '2018-08-03 13:47:07', null);
INSERT INTO `cp_user` VALUES ('39', 'adsds', 'adsda', '暂无签名', '1', '1', '2018-08-03 13:47:28', '2018-08-03 13:47:28', null);
INSERT INTO `cp_user` VALUES ('57', 'adsds', 'liyuhao', '暂无签名', '1', '1', '2018-08-05 21:08:54', '2018-08-05 21:08:54', null);
INSERT INTO `cp_user` VALUES ('58', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'asc', '无敌就是寂寞', '2', '1', '2018-08-05 21:11:04', '2018-08-06 14:52:48', null);
INSERT INTO `cp_user` VALUES ('59', 'adsds', 'sadca', '暂无签名', '1', '1', '2018-08-06 14:08:28', '2018-08-06 14:08:28', null);
INSERT INTO `cp_user` VALUES ('60', 'adsds', '任嘉敏', '暂无签名', '1', '1', '2018-08-06 14:50:04', '2018-08-06 14:50:04', null);
INSERT INTO `cp_user` VALUES ('61', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'www', '无敌就是寂寞', '2', '1', '2018-08-07 19:56:13', '2018-08-07 20:13:58', null);
INSERT INTO `cp_user` VALUES ('62', 'adsds', '21w1', '暂无签名', '1', '1', '2018-08-08 08:12:56', '2018-08-08 08:12:56', null);
INSERT INTO `cp_user` VALUES ('63', 'adsds', '21w', '暂无签名', '1', '1', '2018-08-08 10:59:09', '2018-08-08 10:59:09', null);
INSERT INTO `cp_user` VALUES ('64', 'adsds', '1ww2', '暂无签名', '1', '1', '2018-08-08 11:06:57', '2018-08-08 11:06:57', null);
INSERT INTO `cp_user` VALUES ('65', 'adsds', '帝皇铠甲', '暂无签名', '1', '1', '2018-08-08 13:36:48', '2018-08-08 13:36:48', '');
INSERT INTO `cp_user` VALUES ('66', 'adsds', '昊天大帝', 'asa', '1', '1', '2018-08-08 14:41:57', '2018-08-08 14:44:04', '');
INSERT INTO `cp_user` VALUES ('67', 'adsds', '昊天', '暂无签名', '1', '1', '2018-08-09 08:37:53', '2018-08-09 08:37:53', '1015883843@qq.com');
INSERT INTO `cp_user` VALUES ('68', 'adsds', '巴拉巴拉', '暂无签名', '1', '1', '2018-08-11 15:49:12', '2018-08-11 15:49:12', null);
INSERT INTO `cp_user` VALUES ('69', 'adsds', '流弊', '11', '1', '1', '2018-08-11 20:32:48', '2018-08-11 20:34:55', '212666902@qq.com');
INSERT INTO `cp_user` VALUES ('73', 'adsds', '任嘉敏', '11', '1', '1', '2018-08-14 19:14:18', '2018-08-14 19:25:48', '1019808375@qq.com');
INSERT INTO `cp_user` VALUES ('74', 'adsds', '杜宸霆', '暂无签名', '1', '1', '2018-08-14 19:15:29', '2018-08-14 19:15:29', null);
INSERT INTO `cp_user` VALUES ('75', 'adsds', '里圆圈', '暂无签名', '1', '1', '2018-08-14 19:15:58', '2018-08-14 19:15:58', '1285875671@qq.com');
INSERT INTO `cp_user` VALUES ('76', 'adsds', 'RizN3d', '暂无签名', '1', '1', '2018-08-20 16:39:26', '2018-08-20 16:39:26', null);
INSERT INTO `cp_user` VALUES ('77', 'adsds', 'zkfWb4', '暂无签名', '1', '1', '2018-08-20 19:58:28', '2018-08-20 19:58:28', null);
INSERT INTO `cp_user` VALUES ('78', 'adsds', 'McllXP', '暂无签名', '1', '1', '2018-08-22 08:53:45', '2018-08-22 08:53:45', null);
INSERT INTO `cp_user` VALUES ('79', 'adsds', '昊宇里', '暂无签名', '1', '1', '2018-08-22 09:02:00', '2018-08-22 09:02:00', null);
INSERT INTO `cp_user` VALUES ('80', 'adsds', 'stEo3x', '暂无签名', '1', '1', '2018-08-22 09:03:39', '2018-08-22 09:03:39', null);
INSERT INTO `cp_user` VALUES ('81', 'adsds', 'yjhVuH', '暂无签名', '1', '1', '2018-08-22 10:06:49', '2018-08-22 10:06:49', null);
INSERT INTO `cp_user` VALUES ('82', 'adsds', 'pcPovE', '暂无签名', '1', '1', '2018-08-22 11:55:10', '2018-08-22 11:55:10', null);
INSERT INTO `cp_user` VALUES ('83', 'adsds', 'fEhnaZ', '暂无签名', '1', '1', '2018-08-23 09:29:19', '2018-08-23 09:29:19', null);
INSERT INTO `cp_user` VALUES ('84', 'adsds', 'lw5mqu', '暂无签名', '1', '1', '2018-08-23 10:57:34', '2018-08-23 10:57:34', null);
INSERT INTO `cp_user` VALUES ('85', 'adsds', '4WZzh3', '暂无签名', '1', '1', '2018-08-24 19:44:25', '2018-08-24 19:44:25', null);
INSERT INTO `cp_user` VALUES ('86', 'adsds', '2DCDO0', '暂无签名', '1', '1', '2018-08-24 19:45:26', '2018-08-24 19:45:26', null);
INSERT INTO `cp_user` VALUES ('87', 'adsds', 'pk98mf', '暂无签名', '1', '1', '2018-08-28 14:45:44', '2018-08-28 14:45:44', '1460909710@qq.com');
INSERT INTO `cp_user` VALUES ('88', 'adsds', 'EXR1Dq', '暂无签名', '1', '1', '2018-08-28 16:09:41', '2018-08-28 16:09:41', null);
INSERT INTO `cp_user` VALUES ('89', 'adsds', '高老师', '暂无签名', '1', '1', '2018-08-28 16:42:42', '2018-08-28 16:42:42', '111111111111');
INSERT INTO `cp_user` VALUES ('90', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'ACZrYr', '暂无签名', '1', '1', '2018-08-29 10:42:54', '2018-08-29 10:42:54', '');
INSERT INTO `cp_user` VALUES ('91', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', '0aCbwF', '暂无签名', '1', '1', '2018-08-29 10:53:41', '2018-08-29 10:53:41', '3160895751@qq.com');
INSERT INTO `cp_user` VALUES ('92', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'NT53B0', '暂无签名', '1', '1', '2018-10-17 14:33:41', '2018-10-17 14:33:41', '10198083751@qq.com');
INSERT INTO `cp_user` VALUES ('93', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'EFXh73', '暂无签名', '1', '1', '2018-10-17 20:20:33', '2018-10-17 20:20:33', 'liyuhao@qq.com');
INSERT INTO `cp_user` VALUES ('94', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'vs1I9T', '暂无签名', '1', '1', '2018-10-17 20:40:07', '2018-10-17 20:40:07', 'liyuhao1@qq.com');
INSERT INTO `cp_user` VALUES ('95', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', 'lA2vOw', '暂无签名', '1', '1', '2018-10-17 21:24:32', '2018-10-17 21:24:32', 'liyuha11@qq.com');
INSERT INTO `cp_user` VALUES ('96', 'http://n1.itc.cn/img8/wb/recom/2017/02/17/148730694699756907.JPEG', '4jrCzD', '暂无签名', '1', '1', '2018-10-17 21:26:36', '2018-10-17 21:26:36', 'liyuha111@qq.com');

-- ----------------------------
-- Table structure for cp_user_email
-- ----------------------------
DROP TABLE IF EXISTS `cp_user_email`;
CREATE TABLE `cp_user_email` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `captcha` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `dateline` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_user_email
-- ----------------------------
INSERT INTO `cp_user_email` VALUES ('91', '1019808375@qq.com', 'UkYeoS', '2019-10-11 22:19:50', '2019-10-11 22:19:50', '2019-10-11 22:24:50');
INSERT INTO `cp_user_email` VALUES ('92', '212666902@qq.com', '6i61g9', '2018-08-11 20:35:15', '2018-08-11 20:35:15', '2018-08-11 20:40:15');
INSERT INTO `cp_user_email` VALUES ('93', '1460909710@qq.com', '3LKe6D', '2018-09-18 21:27:39', '2018-09-18 21:27:39', '2018-09-18 21:32:39');
INSERT INTO `cp_user_email` VALUES ('94', '1285875671@qq.com', 'dnvrGe', '2018-09-18 21:28:17', '2018-09-18 21:28:17', '2018-09-18 21:33:17');

-- ----------------------------
-- Table structure for cp_user_identity
-- ----------------------------
DROP TABLE IF EXISTS `cp_user_identity`;
CREATE TABLE `cp_user_identity` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id，自增长',
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_name_e` (`user_id`),
  CONSTRAINT `fk_name_e` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_user_identity
-- ----------------------------
INSERT INTO `cp_user_identity` VALUES ('57', '李宇豪', '12345678', '2018-08-05 21:08:54', '2018-08-05 21:08:54');
INSERT INTO `cp_user_identity` VALUES ('58', '任嘉敏', '123456782', '2018-08-05 21:11:04', '2018-08-06 10:11:57');
INSERT INTO `cp_user_identity` VALUES ('59', '1', '1', '2018-08-06 14:08:28', '2018-09-26 23:17:11');
INSERT INTO `cp_user_identity` VALUES ('60', '32', '123456782', '2018-08-06 14:50:04', '2018-08-06 14:51:31');
INSERT INTO `cp_user_identity` VALUES ('61', 'ED', '123456782', '2018-08-07 19:56:13', '2018-08-07 20:16:24');
INSERT INTO `cp_user_identity` VALUES ('62', 'E', '123456782', '2018-08-08 08:12:56', '2018-08-08 08:12:56');
INSERT INTO `cp_user_identity` VALUES ('63', 'E1', '123456782', '2018-08-08 10:59:09', '2018-08-08 10:59:09');
INSERT INTO `cp_user_identity` VALUES ('64', 'E11', '123456782', '2018-08-08 11:06:57', '2018-08-08 11:06:57');
INSERT INTO `cp_user_identity` VALUES ('65', 'q', '12345678a', '2018-08-08 13:36:48', '2018-08-08 13:36:48');
INSERT INTO `cp_user_identity` VALUES ('66', '昊宇里', '131452100000', '2018-08-08 14:41:57', '2018-08-08 14:50:32');
INSERT INTO `cp_user_identity` VALUES ('67', '昊宇', '21123134gfdbfrbgd', '2018-08-09 08:37:53', '2018-08-11 20:24:29');
INSERT INTO `cp_user_identity` VALUES ('68', '利于', '12345678qqwqw', '2018-08-11 15:49:12', '2018-08-11 15:49:12');
INSERT INTO `cp_user_identity` VALUES ('69', '成泳甫', '21123134gfdbfrbgd', '2018-08-11 20:32:48', '2018-08-11 20:36:43');
INSERT INTO `cp_user_identity` VALUES ('73', '瀑雨梨花', '111111111111111', '2018-08-14 19:14:18', '2018-10-21 15:55:55');
INSERT INTO `cp_user_identity` VALUES ('74', '暴雨梨花', 'duchenting1314', '2018-08-14 19:15:29', '2018-08-14 19:15:29');
INSERT INTO `cp_user_identity` VALUES ('75', '泪雨梨花', 'liyuhao1314', '2018-08-14 19:15:58', '2018-08-14 19:51:46');
INSERT INTO `cp_user_identity` VALUES ('76', '老王', 'liyuhao1314', '2018-08-20 16:39:26', '2018-08-20 16:39:26');
INSERT INTO `cp_user_identity` VALUES ('77', '老1', '11111111112q11', '2018-08-20 19:58:28', '2018-09-30 12:50:18');
INSERT INTO `cp_user_identity` VALUES ('78', '老11', 'liyuhao1314', '2018-08-22 08:53:45', '2018-08-22 08:53:45');
INSERT INTO `cp_user_identity` VALUES ('79', '老2', 'liyuhao1314', '2018-08-22 09:02:00', '2018-08-22 09:02:00');
INSERT INTO `cp_user_identity` VALUES ('80', '老3', 'liyuhao1314', '2018-08-22 09:03:39', '2018-08-22 09:03:39');
INSERT INTO `cp_user_identity` VALUES ('81', '老v', 'liyuhao1314', '2018-08-22 10:06:49', '2018-08-22 10:06:49');
INSERT INTO `cp_user_identity` VALUES ('82', '老额', 'liyuhao1314', '2018-08-22 11:55:10', '2018-08-22 11:55:10');
INSERT INTO `cp_user_identity` VALUES ('83', '老变化', 'liyuhao1314', '2018-08-23 09:29:19', '2018-08-23 09:29:19');
INSERT INTO `cp_user_identity` VALUES ('84', '老变', 'liyuhao1314', '2018-08-23 10:57:34', '2018-08-23 10:57:34');
INSERT INTO `cp_user_identity` VALUES ('85', 'yulihao ', '1111111111111', '2018-08-24 19:44:25', '2018-08-24 19:44:25');
INSERT INTO `cp_user_identity` VALUES ('86', '11', '1111111111111', '2018-08-24 19:45:26', '2018-08-24 19:45:26');
INSERT INTO `cp_user_identity` VALUES ('87', 'qqq', '111111111111', '2018-08-28 14:45:44', '2018-08-28 14:45:44');
INSERT INTO `cp_user_identity` VALUES ('88', 'qqq11', '111111111111', '2018-08-28 16:09:41', '2018-08-28 16:09:41');
INSERT INTO `cp_user_identity` VALUES ('89', 'wq1', '111111111111', '2018-08-28 16:42:42', '2018-08-28 16:42:42');
INSERT INTO `cp_user_identity` VALUES ('90', '杜憨憨', '12345678', '2018-08-29 10:42:54', '2018-08-29 10:42:54');
INSERT INTO `cp_user_identity` VALUES ('91', '杜憨', '12345678', '2018-08-29 10:53:41', '2018-08-29 10:53:41');
INSERT INTO `cp_user_identity` VALUES ('92', '李宇豪11', '111111111111', '2018-10-17 14:33:41', '2018-10-17 14:33:41');
INSERT INTO `cp_user_identity` VALUES ('93', 'liyuhao', '111111111111', '2018-10-17 20:20:33', '2018-10-17 20:20:33');
INSERT INTO `cp_user_identity` VALUES ('94', 'liyuhao12', '111111111111', '2018-10-17 20:40:07', '2018-10-17 20:40:07');
INSERT INTO `cp_user_identity` VALUES ('95', 'liyuhao1211', '111111111111', '2018-10-17 21:24:32', '2018-10-17 21:24:32');
INSERT INTO `cp_user_identity` VALUES ('96', 'liyuhao12111', '111111111111', '2018-10-17 21:26:36', '2018-10-17 21:26:36');

-- ----------------------------
-- Table structure for cp_user_question
-- ----------------------------
DROP TABLE IF EXISTS `cp_user_question`;
CREATE TABLE `cp_user_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `question_a` varchar(255) COLLATE utf8_bin NOT NULL,
  `question_b` varchar(255) COLLATE utf8_bin NOT NULL,
  `question_c` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cp_user_question
-- ----------------------------
INSERT INTO `cp_user_question` VALUES ('1', '利于', '11', '11', '11', '2018-08-11 17:10:01', '2018-08-11 17:10:01');
INSERT INTO `cp_user_question` VALUES ('3', '昊宇', '111', '222', '333', '2018-08-11 17:20:43', '2018-08-11 18:10:09');
INSERT INTO `cp_user_question` VALUES ('4', '泪雨梨花', 'liyuhao1314', '19990220', 'anyiquan', '2018-08-14 19:44:11', '2018-08-14 19:45:52');
