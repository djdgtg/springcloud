/*
Navicat MySQL Data Transfer

Source Server         : work
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : testspringcloud

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-02-20 13:17:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderId` varchar(100) NOT NULL,
  `userId` int(10) DEFAULT NULL,
  `orderStatus` int(10) DEFAULT NULL,
  `money` float(10,2) DEFAULT NULL,
  `tradingTime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1', '199.00', '2019-01-22 09:39:49');
INSERT INTO `t_order` VALUES ('2', '1', '0', '209.00', '2019-01-22 09:40:00');
INSERT INTO `t_order` VALUES ('3', '2', '1', '188.00', '2019-01-22 09:40:09');
INSERT INTO `t_order` VALUES ('4', '2', '2', '168.00', '2019-01-22 09:40:19');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `createdtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '689EE787E0EA220E6D5A72163EB8C437', '1', '17', '2018-11-23 17:33:12');
INSERT INTO `t_user` VALUES ('2', 'test', '689EE787E0EA220E6D5A72163EB8C437', '1', '16', '2019-01-22 09:40:42');
