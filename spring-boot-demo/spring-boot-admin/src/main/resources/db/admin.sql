/*
Navicat MySQL Data Transfer

Source Server         : 10.10.20.100
Source Server Version : 50721
Source Host           : 125.69.73.254:33600
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-17 18:01:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for BS_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `BS_PERMISSION`;
CREATE TABLE `BS_PERMISSION` (
  `ID` int(11) NOT NULL COMMENT '权限ID',
  `ALIAS` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '别名',
  `PERMISSION_NAME` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '名字',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `PID` int(11) DEFAULT NULL COMMENT '父ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
-- Records of BS_PERMISSION
-- ----------------------------
INSERT INTO `BS_PERMISSION` VALUES ('1', '超级管理员', 'ADMIN', '2019-01-17 15:28:57', '0');

-- ----------------------------
-- Table structure for BS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `BS_ROLE`;
CREATE TABLE `BS_ROLE` (
  `ID` int(11) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '角色创建时间',
  `REMARK` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of BS_ROLE
-- ----------------------------
INSERT INTO `BS_ROLE` VALUES ('1', '超级管理员', '2019-01-17 15:30:32', '超级管理员');
INSERT INTO `BS_ROLE` VALUES ('2', '普通用户', '2019-01-17 15:30:55', '普通用户');

-- ----------------------------
-- Table structure for BS_ROLE_PERMISSIONS
-- ----------------------------
DROP TABLE IF EXISTS `BS_ROLE_PERMISSIONS`;
CREATE TABLE `BS_ROLE_PERMISSIONS` (
  `ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `PERMISSION_ID` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限中间表';

-- ----------------------------
-- Records of BS_ROLE_PERMISSIONS
-- ----------------------------
INSERT INTO `BS_ROLE_PERMISSIONS` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for BS_USER
-- ----------------------------
DROP TABLE IF EXISTS `BS_USER`;
CREATE TABLE `BS_USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `PASS_WORD` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `AVATAR` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `ENABLED` int(2) DEFAULT NULL COMMENT '是否可用 1可用 0不可用',
  `EMAIL` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱地址',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of BS_USER
-- ----------------------------
INSERT INTO `BS_USER` VALUES ('1', 'even', '123', null, '1', 'even366@qq.com', '2019-01-17 15:32:44', '2019-01-17 15:32:47');

-- ----------------------------
-- Table structure for BS_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `BS_USER_ROLE`;
CREATE TABLE `BS_USER_ROLE` (
  `ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of BS_USER_ROLE
-- ----------------------------
INSERT INTO `BS_USER_ROLE` VALUES ('1', '1', '1');
