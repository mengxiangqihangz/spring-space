/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-21 18:05:05
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

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(20) DEFAULT NULL COMMENT '用户id',
  `USER_NAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `SEX` varchar(1) DEFAULT NULL COMMENT '性别1男0女',
  `CARD_ID` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `STATUS` varchar(1) DEFAULT NULL COMMENT '状态0禁用1启用',
  `USER_ACCOUNT` varchar(200) DEFAULT NULL COMMENT '登陆账号',
  `USER_PWD` varchar(200) DEFAULT NULL COMMENT '登陆密码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'ufo1463633067750', 'aaa', '1', 'aaa', '', '', '', '1', '', '');
INSERT INTO `sys_user` VALUES ('2', 'ufo1463639896161', 'aaa', '0', '121312121212', '12', '12', '12', '0', '12', '12');
INSERT INTO `sys_user` VALUES ('3', 'ufo1463641252945', 'a', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('4', 'ufo1463641252945', 'b', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('5', 'ufo1463641252945', 'c', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('6', 'ufo1463641252945', 'd', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('7', 'ufo1463641252945', 'e', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('8', 'ufo1463641252945', 'f', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('9', 'ufo1463641252945', 'g', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('10', 'ufo1463641252945', 'h', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('11', 'ufo1463641252945', 'j', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('12', 'ufo1463641252945', 'k', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('13', 'ufo1463641252945', 'l', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('14', 'ufo1463641252945', 'm', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('15', 'ufo1463641252945', 'n', '1', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('16', 'ufo1463641252945', 'o', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
