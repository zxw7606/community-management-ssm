/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.213.128:3307
 Source Schema         : manager

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 01/09/2019 10:36:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`  (
  `owner_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业主id',
  `owner_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主名字',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `hsize` float NOT NULL COMMENT '房屋面积',
  `num` int(11) NOT NULL COMMENT '居住人员数量',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `pro` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `hourse_id` int(11) NULL DEFAULT NULL COMMENT '房屋的id',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `iscar` bit(1) NOT NULL COMMENT '有无车',
  `car_id` int(11) NOT NULL COMMENT '车号',
  `cartype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车型',
  PRIMARY KEY (`owner_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of owner
-- ----------------------------
INSERT INTO `owner` VALUES (14, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (20, '1111111', '3', '3', 13131, 123, '13', NULL, 23, '13', b'1', 1231, '31');
INSERT INTO `owner` VALUES (21, '2', '3', '121', 1312, 1, '13123', NULL, 2, '13123', b'1', 123, '131');

SET FOREIGN_KEY_CHECKS = 1;
