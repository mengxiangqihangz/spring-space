/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-09-21 17:12:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '蛋糕');
INSERT INTO `category` VALUES ('2', '牛奶');
INSERT INTO `category` VALUES ('3', '鞋');

-- ----------------------------
-- Table structure for consignee
-- ----------------------------
DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee` (
  `consignee_id` int(11) NOT NULL AUTO_INCREMENT,
  `consignee_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `consignee_phone` varchar(255) CHARACTER SET utf8 NOT NULL,
  `consignee_address` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`consignee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of consignee
-- ----------------------------
INSERT INTO `consignee` VALUES ('1', '张三', '12345678901', '广东省深圳市龙华新区港之龙C座9楼902');
INSERT INTO `consignee` VALUES ('2', '李四', '12345678901', '广东省深圳市龙华新区港之龙C座9楼902');
INSERT INTO `consignee` VALUES ('3', '王五', '12345678901', '广东省深圳市龙华新区港之龙C座9楼902');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(2) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(100) NOT NULL,
  `goods_price` varchar(3000) NOT NULL,
  `goods_information` varchar(3000) NOT NULL,
  `goods_remainNum` varchar(3000) NOT NULL,
  `goods_picture` varchar(3000) NOT NULL,
  `merchant_id` varchar(3000) NOT NULL,
  `category_id` int(3) NOT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '奶酪蛋糕', '15000', '以海绵蛋糕、派皮等为底坯，将加工后的乳酪混合物，经过烘烤、装饰而成的制品', '120', 'resources/img/p1.jpg', '1', '1');
INSERT INTO `goods` VALUES ('2', '慕斯蛋糕', '16000', '以慕斯粉为主材料的糕点。慕斯的英文是mousse，是一种奶冻式的甜点', '110', 'resources/img/p2.jpg', '2', '1');
INSERT INTO `goods` VALUES ('3', '天使蛋糕', '20000', '硬性发泡的鸡蛋清、白糖和白面粉制成', '180', 'resources/img/p3.jpg', '3', '1');
INSERT INTO `goods` VALUES ('4', '戚风蛋糕', '18000', '属海绵蛋糕类型，质地非常轻，用菜油、鸡蛋、糖、面粉、发粉为基本材料', '160', 'resources/img/p4.jpg', '2', '1');
INSERT INTO `goods` VALUES ('5', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('6', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('7', '高钙奶', '2400', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '50', 'resources/img/p7.jpg', '2', '2');
INSERT INTO `goods` VALUES ('8', '儿童奶', '4000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '45', 'resources/img/p8.jpg', '1', '2');
INSERT INTO `goods` VALUES ('9', '帆布鞋', '16500', '帆布鞋是一种兴起于欧洲的厚胶底', '140', 'resources/img/p9.jpg', '3', '3');
INSERT INTO `goods` VALUES ('10', '皮鞋', '55000', '是指以天然皮革为鞋面，各类鞋靴中品位最高的鞋', '135', 'resources/img/p10.jpg', '2', '3');
INSERT INTO `goods` VALUES ('11', '休闲鞋', '24000', '主要特色是以一种简单，舒适的设计理念', '140', 'resources/img/p11.jpg', '1', '3');
INSERT INTO `goods` VALUES ('12', '运动鞋', '32500', '运动鞋是根据人们参加运动或旅游的特点设计制造的', '165', 'resources/img/p12.jpg', '3', '3');
INSERT INTO `goods` VALUES ('13', '奶酪蛋糕', '15000', '以海绵蛋糕、派皮等为底坯，将加工后的乳酪混合物，经过烘烤、装饰而成的制品', '120', 'resources/img/p1.jpg', '1', '1');
INSERT INTO `goods` VALUES ('14', '慕斯蛋糕', '16000', '以慕斯粉为主材料的糕点。慕斯的英文是mousse，是一种奶冻式的甜点', '110', 'resources/img/p2.jpg', '2', '1');
INSERT INTO `goods` VALUES ('15', '天使蛋糕', '20000', '硬性发泡的鸡蛋清、白糖和白面粉制成', '180', 'resources/img/p3.jpg', '3', '1');
INSERT INTO `goods` VALUES ('16', '戚风蛋糕', '18000', '属海绵蛋糕类型，质地非常轻，用菜油、鸡蛋、糖、面粉、发粉为基本材料', '160', 'resources/img/p4.jpg', '2', '1');
INSERT INTO `goods` VALUES ('17', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('18', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('19', '高钙奶', '2400', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '50', 'resources/img/p7.jpg', '2', '2');
INSERT INTO `goods` VALUES ('20', '儿童奶', '4000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '45', 'resources/img/p8.jpg', '1', '2');
INSERT INTO `goods` VALUES ('21', '帆布鞋', '16500', '帆布鞋是一种兴起于欧洲的厚胶底', '140', 'resources/img/p9.jpg', '3', '3');
INSERT INTO `goods` VALUES ('22', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('23', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('24', '高钙奶', '2400', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '50', 'resources/img/p7.jpg', '2', '2');
INSERT INTO `goods` VALUES ('25', '儿童奶', '4000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '45', 'resources/img/p8.jpg', '1', '2');
INSERT INTO `goods` VALUES ('26', '帆布鞋', '16500', '帆布鞋是一种兴起于欧洲的厚胶底', '140', 'resources/img/p9.jpg', '3', '3');
INSERT INTO `goods` VALUES ('27', '皮鞋', '55000', '是指以天然皮革为鞋面，各类鞋靴中品位最高的鞋', '135', 'resources/img/p10.jpg', '2', '3');
INSERT INTO `goods` VALUES ('28', '休闲鞋', '24000', '主要特色是以一种简单，舒适的设计理念', '140', 'resources/img/p11.jpg', '1', '3');
INSERT INTO `goods` VALUES ('29', '运动鞋', '32500', '运动鞋是根据人们参加运动或旅游的特点设计制造的', '165', 'resources/img/p12.jpg', '3', '3');
INSERT INTO `goods` VALUES ('30', '奶酪蛋糕', '15000', '以海绵蛋糕、派皮等为底坯，将加工后的乳酪混合物，经过烘烤、装饰而成的制品', '120', 'resources/img/p1.jpg', '1', '1');
INSERT INTO `goods` VALUES ('31', '慕斯蛋糕', '16000', '以慕斯粉为主材料的糕点。慕斯的英文是mousse，是一种奶冻式的甜点', '110', 'resources/img/p2.jpg', '2', '1');
INSERT INTO `goods` VALUES ('32', '天使蛋糕', '20000', '硬性发泡的鸡蛋清、白糖和白面粉制成', '180', 'resources/img/p3.jpg', '3', '1');
INSERT INTO `goods` VALUES ('33', '戚风蛋糕', '18000', '属海绵蛋糕类型，质地非常轻，用菜油、鸡蛋、糖、面粉、发粉为基本材料', '160', 'resources/img/p4.jpg', '2', '1');
INSERT INTO `goods` VALUES ('34', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('35', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('36', '戚风蛋糕', '18000', '属海绵蛋糕类型，质地非常轻，用菜油、鸡蛋、糖、面粉、发粉为基本材料', '160', 'resources/img/p4.jpg', '2', '1');
INSERT INTO `goods` VALUES ('37', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('38', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('39', '高钙奶', '2400', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '50', 'resources/img/p7.jpg', '2', '2');
INSERT INTO `goods` VALUES ('40', '儿童奶', '4000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '45', 'resources/img/p8.jpg', '1', '2');
INSERT INTO `goods` VALUES ('41', '帆布鞋', '16500', '帆布鞋是一种兴起于欧洲的厚胶底', '140', 'resources/img/p9.jpg', '3', '3');
INSERT INTO `goods` VALUES ('42', '纯牛奶', '1500', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '80', 'resources/img/p5.jpg', '1', '2');
INSERT INTO `goods` VALUES ('43', '酸奶', '3000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '70', 'resources/img/p6.jpg', '3', '2');
INSERT INTO `goods` VALUES ('44', '高钙奶', '2400', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '50', 'resources/img/p7.jpg', '2', '2');
INSERT INTO `goods` VALUES ('45', '儿童奶', '4000', '牛奶是人体钙的最佳来源，是人们日常生活中喜爱的饮食之一', '45', 'resources/img/p8.jpg', '1', '2');
INSERT INTO `goods` VALUES ('46', '帆布鞋', '16500', '帆布鞋是一种兴起于欧洲的厚胶底', '140', 'resources/img/p9.jpg', '3', '3');
INSERT INTO `goods` VALUES ('47', '皮鞋', '55000', '是指以天然皮革为鞋面，各类鞋靴中品位最高的鞋', '135', 'resources/img/p10.jpg', '2', '3');
INSERT INTO `goods` VALUES ('48', '休闲鞋', '24000', '主要特色是以一种简单，舒适的设计理念', '140', 'resources/img/p11.jpg', '1', '3');
INSERT INTO `goods` VALUES ('49', '运动鞋', '32500', '运动鞋是根据人们参加运动或旅游的特点设计制造的', '165', 'resources/img/p12.jpg', '3', '3');
INSERT INTO `goods` VALUES ('50', '奶酪蛋糕', '15000', '以海绵蛋糕、派皮等为底坯，将加工后的乳酪混合物，经过烘烤、装饰而成的制品', '120', 'resources/img/p1.jpg', '1', '1');
INSERT INTO `goods` VALUES ('51', '慕斯蛋糕', '16000', '以慕斯粉为主材料的糕点。慕斯的英文是mousse，是一种奶冻式的甜点', '110', 'resources/img/p2.jpg', '2', '1');
INSERT INTO `goods` VALUES ('52', '天使蛋糕', '20000', '硬性发泡的鸡蛋清、白糖和白面粉制成', '180', 'resources/img/p3.jpg', '3', '1');
INSERT INTO `goods` VALUES ('53', '戚风蛋糕', '18000', '属海绵蛋糕类型，质地非常轻，用菜油、鸡蛋、糖、面粉、发粉为基本材料', '160', 'resources/img/p4.jpg', '2', '1');

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
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_realname` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_identity` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_homeAddress` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_phone` varchar(255) CHARACTER SET utf8 NOT NULL,
  `member_email` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '赵六', '123', '赵六', '362525190036253610', '广东省深圳市龙华新区港之龙C座9楼902', '12345678901', 'zhiliangmx@163.com');
INSERT INTO `member` VALUES ('2', '王朝', '123', '王朝', '362525190036253610', '广东省深圳市龙华新区港之龙C座9楼902', '12345678901', 'zhiliangmx@163.com');
INSERT INTO `member` VALUES ('3', '马汉', '123', '马汉', '362525190036253610', '广东省深圳市龙华新区港之龙C座9楼902', '12345678901', 'zhiliangmx@163.com');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_price` int(11) NOT NULL,
  `order_createtime` datetime NOT NULL,
  `order_state` varchar(255) CHARACTER SET utf8 NOT NULL,
  `order_payMethod` varchar(255) CHARACTER SET utf8 NOT NULL,
  `consignee_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `shopping_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  PRIMARY KEY (`shopping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shopping
-- ----------------------------

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
INSERT INTO `sysuser` VALUES (null, '1', 'admin', '保密', '0', '0', '0', '0', '0', '0', '0', 'admin', '0000-00-00', '0', '0');
INSERT INTO `sysuser` VALUES (null, '2', 'liuziyang', '保密', '20', '0', '13249840564@qq.com', '13249840564', '13249840564', '0', '0', '123', '2016-09-10', '0', '广东');
INSERT INTO `sysuser` VALUES (null, '3', '张三', '保密', '20', '0', '231231@qq.com', '13146341514', '5464556', '0', '0', '123', '2016-02-25', '0', '江西');
