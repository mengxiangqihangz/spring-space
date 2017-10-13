/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : dbo

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-08-23 17:25:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '菜单请求路径',
  `parent_menu_id` varchar(255) DEFAULT NULL COMMENT '父菜单编码 没有父节点默认为-1',
  `menu_desc` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `menu_level` int(2) DEFAULT NULL COMMENT '菜单级别',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `Modifier` int(11) DEFAULT NULL COMMENT '修改人',
  `Modify_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '根菜单', null, '-1', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统管理', null, '1', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '员工管理', null, '1', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '合同管理', null, '1', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '商家管理', null, '1', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', '用户管理', null, '2', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '角色管理', null, '2', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '菜单管理', null, '2', null, null, null, null, null, null);
