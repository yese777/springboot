/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云MySQL
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 47.100.230.188:3306
 Source Schema         : test01

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 12/03/2020 21:37:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_department`;
CREATE TABLE `t_sys_department` (
  `id` int(50) NOT NULL,
  `departmentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_sys_department
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_department` VALUES (1, '开发部');
INSERT INTO `t_sys_department` VALUES (2, '销售部');
INSERT INTO `t_sys_department` VALUES (3, '市场部');
COMMIT;

-- ----------------------------
-- Table structure for t_sys_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_employee`;
CREATE TABLE `t_sys_employee` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gender` int(50) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `deptId` int(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_sys_employee
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_employee` VALUES (1, '张三1', '132@qq.com', 1, '2019-10-15', 1);
INSERT INTO `t_sys_employee` VALUES (2, '张三2', '132@qq.com', 0, '2019-12-03', 1);
INSERT INTO `t_sys_employee` VALUES (3, '张三3', '132@qq.com', 1, '2019-12-18', 1);
INSERT INTO `t_sys_employee` VALUES (4, '张三4', '132@qq.com', 0, '2019-12-04', 2);
INSERT INTO `t_sys_employee` VALUES (5, '张三5', '132@qq.com', 1, '2019-12-17', 2);
INSERT INTO `t_sys_employee` VALUES (6, '张三6', '132@qq.com', 1, '2019-12-31', 3);
INSERT INTO `t_sys_employee` VALUES (7, '张三7', '1321810135@qq.com', 1, '2019-12-02', 1);
INSERT INTO `t_sys_employee` VALUES (8, '张三8', '1565565@163.com', 1, '2019-12-02', 2);
INSERT INTO `t_sys_employee` VALUES (10, '张三9', '1321810135@qq.com', 1, '2019-12-19', 3);
INSERT INTO `t_sys_employee` VALUES (11, '张三10', '1565565@163.com', 0, '2019-12-08', 1);
INSERT INTO `t_sys_employee` VALUES (12, '张三11', '1565565@163.com', 0, '2019-12-16', 2);
INSERT INTO `t_sys_employee` VALUES (14, '张三100', '1321810135@qq.com', 0, '2020-01-01', 2);
INSERT INTO `t_sys_employee` VALUES (17, '张三9', '1321810135@qq.com', 0, '2019-12-29', 3);
INSERT INTO `t_sys_employee` VALUES (18, '张三3', '1321810135@qq.com', 0, '2020-01-26', 1);
INSERT INTO `t_sys_employee` VALUES (19, '董', '1565565@163.com', 0, '2020-03-01', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
