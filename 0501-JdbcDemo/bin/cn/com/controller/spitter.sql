/*
Navicat MySQL Data Transfer

Source Server         : shop
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : vip

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-07 18:47:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for spitter
-- ----------------------------
DROP TABLE IF EXISTS `spitter`;
CREATE TABLE `spitter` (
  `spittername` varchar(255) NOT NULL,
  `spitterpassword` varchar(255) NOT NULL,
  PRIMARY KEY (`spittername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spitter
-- ----------------------------
INSERT INTO `spitter` VALUES ('张三', '321');
INSERT INTO `spitter` VALUES ('李四', '21212');
