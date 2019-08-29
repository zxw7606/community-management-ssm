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

 Date: 29/08/2019 10:51:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for asks
-- ----------------------------
DROP TABLE IF EXISTS `asks`;
CREATE TABLE `asks`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `atarget` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投诉对象',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投诉内容',
  `personid` int(11) NULL DEFAULT NULL COMMENT '投诉人',
  `empid` int(11) NULL DEFAULT NULL COMMENT '受理人',
  `result` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理结果',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '受理时间',
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `empid_idx`(`empid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for carpostion
-- ----------------------------
DROP TABLE IF EXISTS `carpostion`;
CREATE TABLE `carpostion`  (
  `cid` int(11) NOT NULL COMMENT '车位编号',
  `pid` int(11) NULL DEFAULT NULL COMMENT '车位业主',
  `isuse` bit(1) NULL DEFAULT NULL COMMENT '是否使用',
  `money` float NULL DEFAULT NULL COMMENT '年费',
  `paytype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
  `did` int(11) NOT NULL COMMENT '设备编号',
  `dname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `dtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型',
  `duse` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用情况',
  `user` int(100) NULL DEFAULT NULL COMMENT '负责人',
  `dchecktype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修方式',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hourse
-- ----------------------------
DROP TABLE IF EXISTS `hourse`;
CREATE TABLE `hourse`  (
  `hid` int(11) NOT NULL COMMENT '单元号',
  `hdescription` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元楼描述',
  `empid` int(11) NOT NULL COMMENT '负责人',
  PRIMARY KEY (`hid`) USING BTREE,
  INDEX `empid _idx`(`empid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for man
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初始密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of man
-- ----------------------------
INSERT INTO `man` VALUES (6, 'a111', '222111', '333222123123123', '1112223333', '123123123123123123123123');
INSERT INTO `man` VALUES (32, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (33, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (34, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (35, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (36, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (37, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (38, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (39, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (40, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (41, 'xxx', 'xxx', '1111', 'xxxxxx', 'xxxxxxx');
INSERT INTO `man` VALUES (42, '1234', '123', '12312323123', '123', '123123');
INSERT INTO `man` VALUES (43, 'wqwe', '123123', '12312323123', 'weizhou964@gmail.com', '');
INSERT INTO `man` VALUES (44, '1234', '123', '12312323123', 'weizhou964@gmail.com', '');
INSERT INTO `man` VALUES (45, 'wqwe', '123', '12312323123', 'weizhou964@gmail.com', '');
INSERT INTO `man` VALUES (46, 'wqwe', '123', '12312323123', 'weizhou964@gmail.com', '');
INSERT INTO `man` VALUES (47, 'wqwe', '123123', '12312323123', 'weizhou964@gmail.com', '');

-- ----------------------------
-- Table structure for mes
-- ----------------------------
DROP TABLE IF EXISTS `mes`;
CREATE TABLE `mes`  (
  `id` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mes_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for moneys
-- ----------------------------
DROP TABLE IF EXISTS `moneys`;
CREATE TABLE `moneys`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '费用编号',
  `typeid` int(11) NULL DEFAULT NULL COMMENT '费用类型',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主编号',
  `money` float NULL DEFAULT NULL COMMENT '缴纳金额',
  `timespan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务周期',
  `paytime` datetime(0) NULL DEFAULT NULL COMMENT '应交时间',
  `gettime` datetime(0) NULL DEFAULT NULL COMMENT '收款时间',
  `personid` int(11) NULL DEFAULT NULL COMMENT '缴费人',
  `empid` int(11) NULL DEFAULT NULL COMMENT '收款人',
  `paytype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `empid_idx`(`empid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for moneytype
-- ----------------------------
DROP TABLE IF EXISTS `moneytype`;
CREATE TABLE `moneytype`  (
  `m_id` int(11) NOT NULL,
  `m_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `owner` VALUES (10, '????111', 'hhhhhhhhh', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (11, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (12, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (13, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (14, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (15, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (16, '0', 'H', 'h', 1, 120, '1', '12', 12, '12', b'1', 0, '12');
INSERT INTO `owner` VALUES (19, '123', '331', '123123', 3, 231, '213132', NULL, 2, '123', b'1', 23, '1231');
INSERT INTO `owner` VALUES (20, '1111111', '3', '3', 13131, 123, '13', NULL, 23, '13', b'1', 1231, '31');
INSERT INTO `owner` VALUES (21, '2', '3', '121', 1312, 1, '13123', NULL, 2, '13123', b'1', 123, '131');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permisssion_id` int(11) NOT NULL,
  `roles_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permissionitem` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permisssion_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `emp_id` int(11) NOT NULL COMMENT '员工id',
  `emp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `u_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `emp_position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工职位',
  `emp_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工电话',
  `emp_descript` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工描述',
  `roles` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工角色',
  PRIMARY KEY (`emp_id`) USING BTREE,
  UNIQUE INDEX `Uname`(`u_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
