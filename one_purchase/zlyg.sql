# Host: localhost  (Version: 5.6.11)
# Date: 2016-06-22 14:52:31
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "sys_menu"
#

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

#
# Data for table "sys_menu"
#


#
# Source for table "sys_menu_role"
#

CREATE TABLE `sys_menu_role` (
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单编码',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单-角色关系表';

#
# Data for table "sys_menu_role"
#


#
# Source for table "sys_role"
#

CREATE TABLE `sys_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

#
# Data for table "sys_role"
#

INSERT INTO `sys_role` VALUES (1,'1000','系统管理员',''),(2,'1001','区总',NULL),(3,'1002','分总',NULL),(4,'1003','业务员',NULL);

#
# Source for table "sys_user"
#

CREATE TABLE `sys_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(20) DEFAULT NULL COMMENT '用户id',
  `USER_NAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名称——简单一对一',
  `SEX` varchar(1) DEFAULT NULL COMMENT '性别1男0女',
  `CARD_ID` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `STATUS` varchar(1) DEFAULT NULL COMMENT '状态0禁用1启用',
  `USER_ACCOUNT` varchar(200) DEFAULT NULL COMMENT '登陆账号',
  `USER_PWD` varchar(200) DEFAULT NULL COMMENT '登陆密码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'ufo1463633067750','aaa','1','aaa','','','','1','',''),(2,'ufo1463639896161','aaa','0','121312121212','12','12','12','0','12','12'),(3,'ufo1463641252945','zhangsan','0','12345667777777','abcdefef@qq.com','1233434342','1212122323','1','xiaowang','123');

#
# Source for table "sys_user_role"
#

CREATE TABLE `sys_user_role` (
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';

#
# Data for table "sys_user_role"
#

INSERT INTO `sys_user_role` VALUES (0,1000),(0,1001);

#
# Source for table "t_company_info"
#

CREATE TABLE `t_company_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Company_id` varchar(20) DEFAULT NULL,
  `Company_name` varchar(200) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `License_url` varchar(200) DEFAULT NULL,
  `Legal_person` varchar(50) DEFAULT NULL,
  `Creator` int(11) DEFAULT NULL,
  `Create_date` date DEFAULT NULL,
  `Modifier` int(11) DEFAULT NULL,
  `Modify_date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家信息表';

#
# Data for table "t_company_info"
#


#
# Source for table "t_goods_info"
#

CREATE TABLE `t_goods_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(20) DEFAULT NULL,
  `goods_name` varchar(200) DEFAULT NULL,
  `Type_id` int(11) DEFAULT NULL,
  `Manufacturer` varchar(200) DEFAULT NULL,
  `Goods_price` int(11) DEFAULT NULL,
  `Shelf_life` date DEFAULT NULL,
  `Goods_ stock` int(11) DEFAULT NULL,
  `Company_id` int(11) DEFAULT NULL,
  `Creator` int(11) DEFAULT NULL,
  `Create_date` date DEFAULT NULL,
  `Modifier` int(11) DEFAULT NULL,
  `Modify_date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

#
# Data for table "t_goods_info"
#


#
# Source for table "t_goods_order"
#

CREATE TABLE `t_goods_order` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) DEFAULT NULL COMMENT '订单编码',
  `Trace_id` int(10) DEFAULT NULL COMMENT '交易流水号',
  `pay_money` int(11) DEFAULT NULL COMMENT '支付金额',
  `pay_type` varchar(255) DEFAULT NULL COMMENT '支付方式：微信支付 支付宝支付 银联支付 余额支付',
  `order_state` int(2) DEFAULT NULL COMMENT '未支付 支付完成 待发货 已发货 已收货 已完成  返修 退货',
  `user_id` varchar(255) DEFAULT NULL COMMENT '购买人编码',
  `pay_account` varchar(255) DEFAULT NULL COMMENT '支付账号',
  `Creator` varchar(20) DEFAULT NULL,
  `Create_date` date DEFAULT NULL,
  `Modifier` varchar(20) DEFAULT NULL,
  `Modify_date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

#
# Data for table "t_goods_order"
#


#
# Source for table "t_goods_order_detail"
#

CREATE TABLE `t_goods_order_detail` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单编码（订单表外键）',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品编码（商品表外键）',
  `goods_count` int(11) DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单交易详情';

#
# Data for table "t_goods_order_detail"
#


#
# Source for table "t_goods_trade"
#

CREATE TABLE `t_goods_trade` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Company_id` int(11) DEFAULT NULL COMMENT '所属商家(商家表外键)',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品编码（商品表外键）',
  `goods_stock` int(11) DEFAULT NULL COMMENT '商品库存',
  `in_shelf_date` date DEFAULT NULL COMMENT '上架日期',
  `out_shelf_date` int(10) DEFAULT NULL COMMENT '下架日期',
  `goods_price` int(2) DEFAULT NULL COMMENT '商品单价',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在售商品表';

#
# Data for table "t_goods_trade"
#


#
# Source for table "t_goods_type"
#

CREATE TABLE `t_goods_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` int(10) DEFAULT NULL,
  `parent_type_id` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

#
# Data for table "t_goods_type"
#


#
# Source for table "t_shopping_cart"
#

CREATE TABLE `t_shopping_cart` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` varchar(255) DEFAULT NULL COMMENT '商品编码',
  `goods_count` int(11) DEFAULT NULL COMMENT '购买数量',
  `Company_id` int(11) DEFAULT NULL COMMENT '所属商家（商家表外键）',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编码（用户表外键）',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Data for table "t_shopping_cart"
#


INSERT INTO `sys_user` VALUES ('1', 'ufo1463633067750', 'aaa', '11', '1', 'aaa', '', '', '', '1', '', '');
INSERT INTO `sys_user` VALUES ('2', 'ufo1463639896161', 'aaa', '11', '0', '121312121212', '12', '12', '12', '0', '12', '12');
INSERT INTO `sys_user` VALUES ('3', 'ufo1463641252945', 'zhangsan', '11', '0', '12345667777777', 'abcdefef@qq.com', '1233434342', '1212122323', '1', 'xiaowang', '123');
INSERT INTO `sys_user` VALUES ('4', '111', 'eeee', '11', '1', '1111', '111', '111', '1111', '1', 'ee', '123456');
INSERT INTO `sys_user` VALUES ('5', '11', 'ee', null, '1', '11', '111', '111', '111', '1', 'eeeee', '123456');
INSERT INTO `sys_user` VALUES ('6', '11', '1e', null, '1', '111', 'e1e11e', '111', '111', '1', 'e11', '123456');
INSERT INTO `sys_user` VALUES ('7', '11', 'eea', null, '1', '11', '11', '111', '111', '1', 'dada', '123456');
INSERT INTO `sys_user` VALUES ('8', '222', 'eeqq', null, '1', '11', '11', '11', '11', '1', 'eqeq', '123456');
INSERT INTO `sys_user` VALUES ('9', '1222', '22ae', null, '1', '11231', '2313', '1321', '311', '1', 'eqe', '123456');
INSERT INTO `sys_user` VALUES ('10', '123', '2eq', null, '1', '2323', '2323', '2222', '222', '1', '222', '123456');
INSERT INTO `sys_user` VALUES ('11', '222', '22', null, '1', '1', '11', '11', '11', '1', '111', '123456');
INSERT INTO `sys_user` VALUES ('12', '22', '22', null, '1', '22', '2222', '22', '22', '1', '22', '123456');
INSERT INTO `sys_user` VALUES ('13', '333', '33', null, '1', '333', '33', '333', '33', '1', '33', '123456');
INSERT INTO `sys_user` VALUES ('14', '33', '33222', null, '1', '2113', '3314', '411', '111', '1', '3111', '123456');
INSERT INTO `sys_user` VALUES ('15', '131', '223', null, '1', '123', '131', '311', '311', '1', '11', '123456');
INSERT INTO `sys_user` VALUES ('16', '13', '123', null, '1', '131', '231', '131', '131', '1', '1231', '123456');
