/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-27 19:15:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `comm` double DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('123', 'asd', 'sdf', '2', '2016-09-28 14:37:06', '232', '2121', '1');
INSERT INTO `emp` VALUES ('456', 'admin', 'sss', '2', '2016-08-28 14:37:44', '231', '231', '2');
