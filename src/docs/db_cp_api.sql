/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : db_cp_api

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 31/07/2018 09:09:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cp_apply
-- ----------------------------
DROP TABLE IF EXISTS `cp_apply`;
CREATE TABLE `cp_apply` (
  `apply_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `reason` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `fk_name_c` (`user_id`),
  KEY `fk_name_d` (`type_id`),
  CONSTRAINT `fk_name_c` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`),
  CONSTRAINT `fk_name_d` FOREIGN KEY (`type_id`) REFERENCES `cp_apply_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for cp_apply_type
-- ----------------------------
DROP TABLE IF EXISTS `cp_apply_type`;
CREATE TABLE `cp_apply_type` (
  `type_id` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for cp_article
-- ----------------------------
DROP TABLE IF EXISTS `cp_article`;
CREATE TABLE `cp_article` (
  `article_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `title` varchar(5120) COLLATE utf8_bin NOT NULL,
  `content` text COLLATE utf8_bin NOT NULL,
  `status` int(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`article_id`),
  KEY `fk_name_a` (`user_id`),
  KEY `fk_name_b` (`type_id`),
  CONSTRAINT `fk_name_a` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`),
  CONSTRAINT `fk_name_b` FOREIGN KEY (`type_id`) REFERENCES `cp_article_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for cp_article_type
-- ----------------------------
DROP TABLE IF EXISTS `cp_article_type`;
CREATE TABLE `cp_article_type` (
  `type_id` int(11) NOT NULL,
  `article_type` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for cp_user
-- ----------------------------
DROP TABLE IF EXISTS `cp_user`;
CREATE TABLE `cp_user` (
  `user_id` int(11) NOT NULL,
  `avatar` varchar(1024) COLLATE utf8_bin NOT NULL,
  `signature` varchar(5120) COLLATE utf8_bin NOT NULL,
  `gender` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for cp_user_identity
-- ----------------------------
DROP TABLE IF EXISTS `cp_user_identity`;
CREATE TABLE `cp_user_identity` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_name_e` (`user_id`) USING BTREE,
  CONSTRAINT `fk_name_e` FOREIGN KEY (`user_id`) REFERENCES `cp_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
