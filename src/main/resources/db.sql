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
--  Table structure for `test_0`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(255) NOT NULL AUTO_INCREMENT,
    `key`      varchar(255) DEFAULT NULL,
    `name`     varchar(255) DEFAULT NULL,
    `phone`    varchar(255) DEFAULT NULL,
    `birth`    varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `users`    varchar(255) DEFAULT NULL,
    `img`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `test_0`
-- ----------------------------
INSERT INTO `user`
VALUES (1, '960401', '吴月', '13971706944', '1996-04-01', '960401', '951102', '');

INSERT INTO `user`
VALUES (2, '951102', '林生雨', '15734066007', '1995-11-02', '951102', '960401', '');

INSERT INTO `user`
VALUES (3, '111', '啊', '15734066007', '1995-11-02', '951102', '960401', '');
INSERT INTO `user`
VALUES (3, '111', 'a', '15734066007', '1995-11-02', '951102', '960401', '');

-- ----------------------------
--  Table structure for `test_1`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`
(
    `id`              int(255) NOT NULL AUTO_INCREMENT,
    `money`           double       DEFAULT NULL,
    `userKey`         varchar(255) DEFAULT NULL,
    `remarkId`        varchar(255) DEFAULT NULL,
    `remark`          varchar(255) DEFAULT NULL,
    `categoryImage`   varchar(255) DEFAULT NULL,
    `type`            int(11) DEFAULT NULL,
    `isDelete`        int(11) DEFAULT NULL,
    `createTimestamp` varchar(255) DEFAULT NULL,
    `createTime`      varchar(255) DEFAULT NULL,
    `updateTimestamp` varchar(255) DEFAULT NULL,
    `updateTime`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark`
(
    `id`              int(255) NOT NULL AUTO_INCREMENT,
    `userKey`         varchar(255) DEFAULT NULL,
    `isDelete`        int(255) DEFAULT NULL,
    `remarkId`        varchar(255) DEFAULT NULL,
    `remark`          varchar(255) DEFAULT NULL,
    `billId`          int(255) DEFAULT NULL,
    `createTimestamp` varchar(255) DEFAULT NULL,
    `createTime`      varchar(255) DEFAULT NULL,
    `updateTimestamp` varchar(255) DEFAULT NULL,
    `updateTime`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `test_2`
-- ----------------------------
DROP TABLE IF EXISTS `test_2`;
CREATE TABLE `test_2`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `key`   varchar(255) DEFAULT NULL,
    `value` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=731 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET
FOREIGN_KEY_CHECKS = 1;
