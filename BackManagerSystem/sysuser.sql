/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-20 09:12:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for loginrecords
-- ----------------------------
DROP TABLE IF EXISTS `loginrecords`;
CREATE TABLE `loginrecords` (
  `count` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(6) NOT NULL,
  `gener` int(5) NOT NULL DEFAULT '1',
  `content` varchar(15) NOT NULL DEFAULT '登录成功！',
  `site` varchar(100) NOT NULL DEFAULT '广东深圳',
  `userName` varchar(100) NOT NULL,
  `IP` varchar(100) NOT NULL,
  `dateTime` varchar(50) NOT NULL,
  PRIMARY KEY (`count`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginrecords
-- ----------------------------
INSERT INTO `loginrecords` VALUES ('1', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 16:39:50');
INSERT INTO `loginrecords` VALUES ('2', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 16:40:30');
INSERT INTO `loginrecords` VALUES ('3', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 17:20:57');
INSERT INTO `loginrecords` VALUES ('4', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 18:17:33');
INSERT INTO `loginrecords` VALUES ('5', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 18:17:55');
INSERT INTO `loginrecords` VALUES ('6', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-19 18:32:29');
INSERT INTO `loginrecords` VALUES ('7', '10001', '1', '登录成功！', '广东深圳', 'admin', '0:0:0:0:0:0:0:1', '2016-09-20 08:50:48');
INSERT INTO `loginrecords` VALUES ('8', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-20 09:02:35');
INSERT INTO `loginrecords` VALUES ('9', '10002', '1', '登录成功！', '广东深圳', 'liuziyang', '0:0:0:0:0:0:0:1', '2016-09-20 09:06:01');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(11) DEFAULT NULL,
  `userid` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `cardId` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `userAccount` varchar(50) DEFAULT NULL,
  `userPwd` varchar(50) NOT NULL,
  `createDate` varchar(12) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `addr` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES (null, '10001', 'admin', '保密', '0', '0', '0', '0', '0', '0', '0', 'admin', '0000-00-00', '0', '0');
INSERT INTO `sysuser` VALUES (null, '10002', 'liuziyang', '保密', '20', '0', '13249840564@qq.com', '13249840564', '13249840564', '0', '0', '123', '2016-09-10', '0', '广东');
