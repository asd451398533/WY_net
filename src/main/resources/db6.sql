/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost
 Source Database       : tcy

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : utf-8

 Date: 09/25/2020 14:37:09 PM
*/

SET
FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
--  Table structure for `test_1`
-- ----------------------------
DROP TABLE IF EXISTS `fk`;
CREATE TABLE `fk`
(
    `id`   int(255) NOT NULL AUTO_INCREMENT,
    `word` TEXT DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET
FOREIGN_KEY_CHECKS = 1;
