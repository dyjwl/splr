/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : jdbc_test

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2021-10-29 18:48:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', 'zhangsan', '1', '20');
INSERT INTO `student` VALUES ('5', 'weiz多数据源', '0', '30');
INSERT INTO `student` VALUES ('6', 'weiz', '1', '30');
INSERT INTO `student` VALUES ('7', 'weiz2', '1', '30');
INSERT INTO `student` VALUES ('10', '李四', '0', '18');
INSERT INTO `student` VALUES ('11', 'weiz11', '1', '23');
