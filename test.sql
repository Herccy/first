/*
 Navicat Premium Data Transfer

 Source Server         : Laundry
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 02/05/2019 14:02:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost`  (
  `Cno` int(255) NOT NULL AUTO_INCREMENT,
  `Pno` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `CostType` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `CostTime` int(8) NULL DEFAULT NULL,
  `CostMoney` double(255, 0) NULL DEFAULT NULL,
  `Pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Cno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2001 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES (2, '2000', '1', 20090527, 22, '22');
INSERT INTO `cost` VALUES (3, '2000', '1', 20190528, 33, '22');
INSERT INTO `cost` VALUES (4, '2000', '1', 19890809, 44, '22');
INSERT INTO `cost` VALUES (5, '2000', '1', 19860805, 55, '22');

-- ----------------------------
-- Table structure for costtype
-- ----------------------------
DROP TABLE IF EXISTS `costtype`;
CREATE TABLE `costtype`  (
  `CostType` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CostMoney` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`CostType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of costtype
-- ----------------------------
INSERT INTO `costtype` VALUES ('1', 52);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `Pno` int(255) NOT NULL AUTO_INCREMENT,
  `Pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Psex` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Page` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `Pphone` int(12) NULL DEFAULT NULL,
  `Pvip` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`Pno`) USING BTREE,
  INDEX `Pno`(`Pno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2010 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (2000, '33', '男', '15', 23, 23);
INSERT INTO `person` VALUES (2002, '王五', '男', '17', 189, 152);
INSERT INTO `person` VALUES (2003, '哈哈哈', '男', '15', 123, -1);
INSERT INTO `person` VALUES (2004, '七七', '女', '14', 154, 0);
INSERT INTO `person` VALUES (2009, '15', '男', '15', 158469857, 598);

-- ----------------------------
-- Table structure for shopper
-- ----------------------------
DROP TABLE IF EXISTS `shopper`;
CREATE TABLE `shopper`  (
  `id` int(255) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `Pno` FOREIGN KEY (`id`) REFERENCES `person` (`pno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopper
-- ----------------------------
INSERT INTO `shopper` VALUES (2000, '123');

SET FOREIGN_KEY_CHECKS = 1;
