/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-08-17 11:21:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_staff
-- ----------------------------
DROP TABLE IF EXISTS `sys_staff`;
CREATE TABLE `sys_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `staff_id` varchar(255) DEFAULT NULL COMMENT '员工id',
  `staff_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `staff_sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `staff_status` varchar(255) DEFAULT NULL COMMENT '员工状态',
  `staff_source` varchar(255) DEFAULT NULL COMMENT '来源',
  `staff_reservation` varchar(255) DEFAULT NULL COMMENT '预约人',
  `Staff_buildDate` varchar(255) DEFAULT NULL COMMENT '创建日期',
  `Staff_buildMan` varchar(255) DEFAULT NULL COMMENT '创建人',
  `Staff_visitDate` varchar(255) DEFAULT NULL COMMENT '来访日期',
  `Staff_birthday` varchar(255) DEFAULT NULL COMMENT '出生日期',
  `staff_graduateSchool` varchar(255) DEFAULT NULL COMMENT '毕业学校',
  `Staff_education` varchar(255) DEFAULT NULL COMMENT '最高学历',
  `Staff_contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `staff_urgencyName` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `Staff_urgencyPhone` varchar(255) DEFAULT NULL COMMENT '紧急联系人电话',
  `staff_jobInterview` varchar(255) DEFAULT NULL COMMENT '面试职位',
  `staff_visible` varchar(255) DEFAULT NULL COMMENT '是否可见',
  `user_id` varchar(255) DEFAULT NULL COMMENT '面试人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_staff
-- ----------------------------
INSERT INTO `sys_staff` VALUES ('1', '11', '小紫', '1', '预约', '58', '马蓉', '2016-03-11', '小强', '2016-03-13', '1993-06-15', '深圳大学', '本科', '13250326548', '霍建华', '13927025012', '销售员', '0', '1000');
INSERT INTO `sys_staff` VALUES ('2', '12', '大紫', '0', '面试', '58', '宋喆', '2016-05-11', '小强', '2016-05-13', '1993-03-17', '清华大学', '本科', '13250326548', '胡歌', '13927025012', '主管', '0', '1000');
INSERT INTO `sys_staff` VALUES ('3', '13', '小灰', '1', '预约', '智联', '马蓉', '2016-05-18', '小强', '2016-05-20', '1995-01-21', '北京大学', '硕士', '13250326548', '刘诗诗', '13927025012', '会计', '0', '1001');
INSERT INTO `sys_staff` VALUES ('4', '14', '大灰', '0', '考核', '中华英才网', '宋喆', '2016-06-11', '小强', '2016-06-14', '1991-08-28', '复旦大学', '硕士', '13250326548', '唐嫣', '13927025012', '经理', '0', '1002');
INSERT INTO `sys_staff` VALUES ('5', '15', '小胖', '1', '预约', '58', '马蓉', '2016-04-11', '小强', '2016-04-15', '1993-02-15', '广州大学华软软件学院', '博士', '13250326548', '杨幂', '13927025012', 'java开发工程师', '0', '1003');
INSERT INTO `sys_staff` VALUES ('6', '16', '大胖', '0', '面试', '猎聘', '宋喆', '2016-07-11', '小强', '2016-07-12', '1992-10-26', '浙江大学', '博士', '13250326548', '吕斌', '13927025012', '前端开发工程师', '0', '1004');
INSERT INTO `sys_staff` VALUES ('7', '17', '小青', '1', '预约', '前程无忧', '马蓉', '2016-08-16', '小强', '2016-08-18', '1993-08-02', '湖南大学', '本科', '13250326548', '林丹', '13927025012', '采购员', '0', '1002');
INSERT INTO `sys_staff` VALUES ('8', '18', '大青', '0', '考核', '赶集网', '宋喆', '2016-01-11', '小强', '2016-01-13', '1994-06-16', '重庆大学', '本科', '13250326548', '张继科', '13927025012', '销售员', '1', '1000');
INSERT INTO `sys_staff` VALUES ('9', '19', '小白', '1', '预约', '前程无忧', '马蓉', '2016-05-11', '小强', '2016-05-14', '1993-05-15', '西南大学', '硕士', '13250326548', '张怡宁', '13927025012', '出纳', '1', '1001');
INSERT INTO `sys_staff` VALUES ('10', '20', '小红', '0', '面试', '58', '宋喆', '2016-03-05', '小强', '2016-03-07', '1996-10-03', '四川大学', '博士', '13250326548', '福原爱', '13927025012', '文员', '1', '1003');
INSERT INTO `sys_staff` VALUES ('11', '21', '小黄', '1', '预约', '猎聘', '马蓉', '2016-03-25', '小强', '2016-03-26', '1990-06-15', '厦门大学', '本科', '13250326548', '杨洋', '13927025012', '经理', '1', '1002');
INSERT INTO `sys_staff` VALUES ('12', '22', '小黑', '0', '预约', '人才市场', '马蓉', '2016-03-18', '小强', '2016-03-19', '1991-12-25', '同济大学', '本科', '13250326548', '姚明', '13927025012', '主管', '1', '1000');
INSERT INTO `sys_staff` VALUES ('13', '23', '小蓝', '1', '预约', '中华英才网', '马蓉', '2015-09-14', '小强', '2015-09-17', '1994-09-27', '中国人民大学', '博士', '13250326548', '刘翔', '13927025012', '文员', '1', '1004');
INSERT INTO `sys_staff` VALUES ('14', '24', '大白', '0', '预约', '58', '马蓉', '2016-03-11', '小强', '2016-03-13', '1992-08-11', '华南理工大学', '本科', '13250326548', '张梦雪', '13927025012', '总经理', '1', '1002');
INSERT INTO `sys_staff` VALUES ('15', '25', '大红', '1', '入职', '智联', '宋喆', '2016-05-24', '小强', '2016-05-27', '1993-07-22', '华南师范大学', '本科', '13250326548', '毛泽东', '13927025012', '采购员', '1', '1001');
INSERT INTO `sys_staff` VALUES ('16', '26', '大黄', '0', '预约', '智联', '马蓉', '2016-03-05', '小强', '2016-03-08', '1993-05-29', '北京理工大学', '硕士', '13250326548', '周恩来', '13927025012', '出纳', '1', '1001');
INSERT INTO `sys_staff` VALUES ('17', '27', '大黑', '1', '预约', '人才市场', '马蓉', '2016-03-11', '小强', '2016-03-12', '1995-11-15', '哈尔滨工业大学', '博士', '13250326548', '邓小平', '13927025012', '人事主管', '1', '1003');
INSERT INTO `sys_staff` VALUES ('18', '28', '大蓝', '0', '面试', '前程无忧', '宋喆', '2016-07-28', '小强', '2016-07-29', '1993-05-17', '中国石油大学', '本科', '13250326548', '胡锦涛', '13927025012', '会计', '1', '1002');
INSERT INTO `sys_staff` VALUES ('19', '29', '王宝强', '1', '预约', '赶集网', '马蓉', '2016-03-11', '小强', '2016-03-14', '1993-02-15', '中国地质大学', '硕士', '13250326548', '习近平', '13927025012', '主管', '1', '1002');
