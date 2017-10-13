/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-27 15:33:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `expireTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('402880e8576a8f1e01576a8f1ec70001', 'admin', '123', '2016-09-27 03:32:26', '2016-09-27 03:32:26');
INSERT INTO `user` VALUES ('402880e8576a8fa901576a8faa1d0001', 'abc', '456', '2016-09-27 03:33:02', '2016-09-27 03:33:02');
