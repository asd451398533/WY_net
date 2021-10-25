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
DROP TABLE IF EXISTS `xt`;
CREATE TABLE `xt`
(
    `id`              int(255) NOT NULL AUTO_INCREMENT,
    `number`           double       DEFAULT NULL,
    `userKey`         varchar(255) DEFAULT NULL,
    `foods`         varchar(255) DEFAULT NULL,
    `images`         varchar(255) DEFAULT NULL,
    `remarkId`        varchar(255) DEFAULT NULL,
    `remark`          varchar(255) DEFAULT NULL,
    `type`            varchar(255) DEFAULT NULL,
    `isDelete`        int(11) DEFAULT NULL,
    `createTimestamp` varchar(255) DEFAULT NULL,
    `createTime`      varchar(255) DEFAULT NULL,
    `updateTimestamp` varchar(255) DEFAULT NULL,
    `updateTime`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `xtRemark`;
CREATE TABLE `xtRemark`
(
    `id`              int(255) NOT NULL AUTO_INCREMENT,
    `userKey`         varchar(255) DEFAULT NULL,
    `isDelete`        int(255) DEFAULT NULL,
    `remarkId`        varchar(255) DEFAULT NULL,
    `remark`          varchar(255) DEFAULT NULL,
    `images`          varchar(255) DEFAULT NULL,
    `xtId`          int(255) DEFAULT NULL,
    `createTimestamp` varchar(255) DEFAULT NULL,
    `createTime`      varchar(255) DEFAULT NULL,
    `updateTimestamp` varchar(255) DEFAULT NULL,
    `updateTime`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET
FOREIGN_KEY_CHECKS = 1;
