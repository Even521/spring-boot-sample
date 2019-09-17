/*
Navicat MySQL Data Transfer

Source Server         : 阿里
Source Server Version : 50725
Source Host           : rm-bp1saa198wv4arf9uio.mysql.rds.aliyuncs.com:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-20 10:33:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_bank
-- ----------------------------
DROP TABLE IF EXISTS `company_bank`;
CREATE TABLE `company_bank` (
  `company_id` int(11) NOT NULL,
  `money` int(10) unsigned NOT NULL DEFAULT '0',
  `invitation_money` int(10) NOT NULL DEFAULT '0',
  `invitation_over_time` datetime DEFAULT NULL,
  `unit_price` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '当前单价，0为不限制人数',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='内训公司金额表';

-- ----------------------------
-- Records of company_bank
-- ----------------------------
INSERT INTO `company_bank` VALUES ('23', '3000', '0', '2019-05-03 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('98', '87000', '59987000', '2019-11-12 09:59:59', '5000');
INSERT INTO `company_bank` VALUES ('221', '0', '27795000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('225', '0', '48785000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('235', '0', '29961000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('237', '0', '29978000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('240', '0', '29626000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('242', '0', '29988000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('244', '0', '28083000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('246', '0', '29836000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('247', '0', '30000000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('249', '0', '69000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('251', '0', '28580000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('252', '0', '59998000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('253', '0', '58852000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('254', '0', '19980000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('255', '0', '1968000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('256', '0', '1994000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('257', '0', '1994000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('258', '0', '1000000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('259', '50000', '0', '2019-08-08 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('260', '0', '500000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('261', '36486000', '0', '2019-06-10 09:52:46', '5000');
INSERT INTO `company_bank` VALUES ('262', '19982000', '0', '2019-06-28 11:12:07', '5000');
INSERT INTO `company_bank` VALUES ('263', '19994000', '0', '2019-06-28 15:15:01', '5000');
INSERT INTO `company_bank` VALUES ('264', '0', '19994000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('265', '0', '91000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('266', '0', '20000000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('267', '0', '20000000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('268', '0', '49500', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('269', '0', '47500', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('270', '0', '29991000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('271', '0', '9998500', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('272', '0', '97000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('273', '0', '186000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('274', '0', '8500', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('275', '0', '29997000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('276', '0', '594000', '2021-12-31 23:59:59', '5000');
INSERT INTO `company_bank` VALUES ('277', '149994000', '0', '2021-12-31 23:59:59', '5000');
