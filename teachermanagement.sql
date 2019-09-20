/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : teachermanagement

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 20/09/2019 09:17:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for auth_group_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_role`;
CREATE TABLE `auth_group_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NULL DEFAULT NULL,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_id`(`group_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `auth_group_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_group_role_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_time` datetime NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL,
  `name` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for class_lesson
-- ----------------------------
DROP TABLE IF EXISTS `class_lesson`;
CREATE TABLE `class_lesson`  (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `lesson_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `lesson_id`(`lesson_id`) USING BTREE,
  CONSTRAINT `class_lesson_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `class_lesson_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `thumbnail_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lesson_section
-- ----------------------------
DROP TABLE IF EXISTS `lesson_section`;
CREATE TABLE `lesson_section`  (
  `id` int(11) NOT NULL,
  `lesson_id` int(11) NULL DEFAULT NULL,
  `section_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `lesson_id`(`lesson_id`) USING BTREE,
  INDEX `section_id`(`section_id`) USING BTREE,
  CONSTRAINT `lesson_section_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lesson_section_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `approved` tinyint(4) NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `video_count` int(255) NULL DEFAULT NULL,
  `playlist_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `thumbnail_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `about` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for section_feedback
-- ----------------------------
DROP TABLE IF EXISTS `section_feedback`;
CREATE TABLE `section_feedback`  (
  `id` int(11) NOT NULL,
  `section_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insert_date_time` datetime NOT NULL,
  `author_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `section_id`(`section_id`) USING BTREE,
  CONSTRAINT `section_feedback_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for suport_status
-- ----------------------------
DROP TABLE IF EXISTS `suport_status`;
CREATE TABLE `suport_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `support_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `support_id`(`support_id`) USING BTREE,
  CONSTRAINT `suport_status_ibfk_1` FOREIGN KEY (`support_id`) REFERENCES `support` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for support
-- ----------------------------
DROP TABLE IF EXISTS `support`;
CREATE TABLE `support`  (
  `id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `solved_date_time` datetime NULL DEFAULT NULL,
  `status_id` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `status_id`(`status_id`) USING BTREE,
  CONSTRAINT `support_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `support_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(255) NOT NULL,
  `approved` tinyint(255) NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for website_settings
-- ----------------------------
DROP TABLE IF EXISTS `website_settings`;
CREATE TABLE `website_settings`  (
  `id` int(11) NOT NULL,
  `banner_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `autobiography` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduce_video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insert_date_time` datetime NULL DEFAULT NULL,
  `last_update_date_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
