/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : dbo

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-08-24 08:54:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单编码',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单-角色关系表';

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('1', '1000');
INSERT INTO `sys_menu_role` VALUES ('2', '1000');
INSERT INTO `sys_menu_role` VALUES ('3', '1000');
INSERT INTO `sys_menu_role` VALUES ('4', '1000');
INSERT INTO `sys_menu_role` VALUES ('5', '1000');
INSERT INTO `sys_menu_role` VALUES ('6', '1000');
INSERT INTO `sys_menu_role` VALUES ('7', '1000');
INSERT INTO `sys_menu_role` VALUES ('8', '1000');
