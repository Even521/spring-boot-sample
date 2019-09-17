/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.10
Source Server Version : 50724
Source Host           : 192.168.0.10:3310
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-08-20 10:54:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_fee_recharge
-- ----------------------------
DROP TABLE IF EXISTS `company_fee_recharge`;
CREATE TABLE `company_fee_recharge` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `type` tinyint(4) unsigned DEFAULT '1' COMMENT '账户类型: 1-兑换特权码，2-充值， 3-对公账户，4-余额抵扣',
  `invitation` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '邀请码',
  `status` tinyint(3) unsigned DEFAULT '0' COMMENT '充值状态，0-待付款，1-充值成功',
  `fee` int(10) unsigned DEFAULT '0' COMMENT '充值金额，单位分',
  `business_code` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `start_time` datetime DEFAULT NULL COMMENT '周期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '周期结束时间',
  `unit_price` int(10) unsigned DEFAULT NULL COMMENT '单价，单位分',
  `user_id` int(10) unsigned NOT NULL COMMENT '发生人的用户id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='内训充值表';

-- ----------------------------
-- Records of company_fee_recharge
-- ----------------------------
INSERT INTO `company_fee_recharge` VALUES ('1', '23', '1', 'aaaaa1', '1', '680000', '', '2019-04-04 00:00:00', '2019-05-03 23:59:59', '1000', '5233', '2019-04-04 18:38:12');
INSERT INTO `company_fee_recharge` VALUES ('2', '23', '3', '', '1', '680000', null, '2019-05-03 23:59:59', '2019-05-10 23:59:59', '500', '5233', '2019-04-04 18:40:19');
INSERT INTO `company_fee_recharge` VALUES ('3', '23', '3', '', '1', '680000', null, '2019-04-04 00:00:00', '2019-05-03 23:59:59', '1000', '5233', '2019-04-04 18:41:44');
INSERT INTO `company_fee_recharge` VALUES ('4', '23', '3', '', '1', '680000', null, '2019-05-10 23:59:59', '2020-05-10 23:59:59', '5000', '5233', '2019-04-04 18:49:03');
INSERT INTO `company_fee_recharge` VALUES ('5', '237', '1', 'td18dc', '1', '0', '', '2019-04-04 00:00:00', '2021-12-31 23:59:59', '5000', '5122', '2019-04-04 23:18:05');
INSERT INTO `company_fee_recharge` VALUES ('6', '249', '1', 'dr56hs', '1', '0', '', '2019-04-05 00:00:00', '2021-12-31 23:59:59', '5000', '5459', '2019-04-05 19:30:31');
INSERT INTO `company_fee_recharge` VALUES ('7', '242', '1', 'ksb4a7', '1', '50000000', '', '2019-04-09 00:00:00', '2021-12-31 23:59:59', '5000', '4712', '2019-04-09 09:07:56');
INSERT INTO `company_fee_recharge` VALUES ('8', '225', '1', 'bd12ss', '1', '3000000', '', '2019-04-09 00:00:00', '2021-12-31 23:59:59', '5000', '3478', '2019-04-09 09:27:17');
INSERT INTO `company_fee_recharge` VALUES ('9', '247', '1', 'sbx8ad', '1', '0', '', '2019-04-09 00:00:00', '2021-12-31 23:59:59', '5000', '5843', '2019-04-09 10:18:31');
INSERT INTO `company_fee_recharge` VALUES ('10', '221', '1', '67dcao', '1', '0', '', '2019-04-09 00:00:00', '2021-12-31 23:59:59', '5000', '4442', '2019-04-09 10:48:25');
INSERT INTO `company_fee_recharge` VALUES ('11', '251', '1', 'oppodl', '1', '0', '', '2019-04-10 00:00:00', '2021-12-31 23:59:59', '5000', '4441', '2019-04-10 17:21:59');
INSERT INTO `company_fee_recharge` VALUES ('12', '240', '1', 'gs215s', '1', '0', '', '2019-04-11 00:00:00', '2021-12-31 23:59:59', '5000', '3549', '2019-04-11 21:01:55');
INSERT INTO `company_fee_recharge` VALUES ('13', '235', '1', 'xta216', '1', '0', '', '2019-04-12 00:00:00', '2021-12-31 23:59:59', '5000', '4684', '2019-04-12 11:29:09');
INSERT INTO `company_fee_recharge` VALUES ('14', '246', '1', 'xta2df', '1', '0', '', '2019-04-12 00:00:00', '2021-12-31 23:59:59', '5000', '5430', '2019-04-12 13:27:35');
INSERT INTO `company_fee_recharge` VALUES ('15', '252', '1', 'as278f', '1', '0', '', '2019-04-16 00:00:00', '2021-12-31 23:59:59', '5000', '8722', '2019-04-16 11:46:24');
INSERT INTO `company_fee_recharge` VALUES ('16', '253', '1', '3df7xa', '1', '0', '', '2019-04-16 00:00:00', '2021-12-31 23:59:59', '5000', '8684', '2019-04-16 14:45:27');
INSERT INTO `company_fee_recharge` VALUES ('17', '254', '1', '7dzxb2', '1', '0', '', '2019-04-17 00:00:00', '2021-12-31 23:59:59', '5000', '9193', '2019-04-17 12:24:35');
INSERT INTO `company_fee_recharge` VALUES ('18', '23', '3', '', '0', '680000', null, '2019-04-04 00:00:00', '2019-07-03 23:59:59', '2000', '3523', '2019-04-19 21:52:15');
INSERT INTO `company_fee_recharge` VALUES ('19', '257', '1', '8yd21x', '1', '0', '', '2019-04-23 00:00:00', '2021-12-31 23:59:59', '5000', '10207', '2019-04-23 12:03:07');
INSERT INTO `company_fee_recharge` VALUES ('20', '256', '1', 'kj231x', '1', '100000', '', '2019-04-23 00:00:00', '2021-12-31 23:59:59', '5000', '10195', '2019-04-23 15:36:17');
INSERT INTO `company_fee_recharge` VALUES ('21', '244', '1', '6scj52', '1', '0', '', '2019-04-24 00:00:00', '2021-12-31 23:59:59', '5000', '5179', '2019-04-24 14:13:33');
INSERT INTO `company_fee_recharge` VALUES ('22', '255', '1', '6sd1as', '1', '0', '', '2019-04-24 00:00:00', '2021-12-31 23:59:59', '5000', '10197', '2019-04-24 14:30:06');
INSERT INTO `company_fee_recharge` VALUES ('23', '258', '1', 'xh12js', '1', '0', '', '2019-05-05 00:00:00', '2021-12-31 23:59:59', '5000', '10526', '2019-05-05 13:21:05');
INSERT INTO `company_fee_recharge` VALUES ('24', '259', '3', null, '1', '0', null, '2019-05-08 00:00:00', '2021-12-31 23:59:59', '5000', '1', '2019-05-08 22:01:37');
INSERT INTO `company_fee_recharge` VALUES ('25', '260', '1', null, '1', '0', null, '2019-05-24 00:00:00', '2021-12-31 23:59:59', '5000', '1', '2019-05-24 14:33:26');
INSERT INTO `company_fee_recharge` VALUES ('27', '261', '2', null, '1', '200000000', null, '2019-06-10 09:48:29', '2021-12-31 23:59:59', '5000', '10733', '2019-06-10 09:49:23');
INSERT INTO `company_fee_recharge` VALUES ('28', '262', '2', null, '1', '10000000', null, '2019-06-28 11:07:54', '2021-12-31 23:59:59', '5000', '12175', '2019-06-28 11:07:04');
INSERT INTO `company_fee_recharge` VALUES ('29', '263', '2', null, '1', '0', null, '2019-06-28 15:16:14', '2021-12-31 23:59:59', '5000', '12181', '2019-06-28 15:17:24');
INSERT INTO `company_fee_recharge` VALUES ('30', '264', '1', null, '1', '0', null, '2019-07-03 09:13:34', '2021-12-31 23:59:59', '5000', '1', '2019-07-03 09:14:03');
INSERT INTO `company_fee_recharge` VALUES ('31', '265', '1', null, '1', '0', null, '2019-07-04 11:33:15', '2021-12-31 23:59:59', '5000', '1', '2019-07-04 11:33:37');
INSERT INTO `company_fee_recharge` VALUES ('32', '266', '1', '', '1', '0', null, '2019-07-06 02:30:18', '2021-12-31 23:59:59', '5000', '1', '2019-07-06 02:30:47');
INSERT INTO `company_fee_recharge` VALUES ('33', '267', '1', null, '1', '0', null, '2019-07-06 02:31:06', '2021-12-31 23:59:59', '5000', '1', '2019-07-06 02:31:25');
INSERT INTO `company_fee_recharge` VALUES ('34', '268', '1', null, '1', '1000000', null, '2019-07-08 15:05:42', '2021-12-31 23:59:59', '5000', '1', '2019-07-08 15:06:04');
INSERT INTO `company_fee_recharge` VALUES ('35', '269', '1', null, '1', '1000000', null, '2019-07-10 08:55:15', '2021-12-31 23:59:59', '5000', '1', '2019-07-10 08:55:31');
INSERT INTO `company_fee_recharge` VALUES ('36', '270', '1', null, '1', '100000000', null, '2019-07-11 17:25:56', '2021-12-31 23:59:59', '5000', '1', '2019-07-11 17:26:41');
INSERT INTO `company_fee_recharge` VALUES ('39', '98', '4', '', '1', '0', null, '2019-07-12 22:25:28', '2021-12-31 23:59:59', '5000', '12200', '2019-07-15 07:53:16');
INSERT INTO `company_fee_recharge` VALUES ('40', '271', '1', null, '1', '2000000', null, '2019-07-09 17:03:04', '2021-12-31 23:59:59', '5000', '1', '2019-07-16 17:04:03');
INSERT INTO `company_fee_recharge` VALUES ('41', '272', '1', null, '1', '2000000', null, '2019-07-17 00:03:05', '2021-12-31 23:59:59', '5000', '1', '2019-07-17 14:21:18');
INSERT INTO `company_fee_recharge` VALUES ('42', '273', '1', null, '1', '2000000', null, '2019-07-17 00:28:39', '2021-12-31 23:59:59', '5000', '1', '2019-07-17 14:28:59');
INSERT INTO `company_fee_recharge` VALUES ('43', '235', '4', '', '1', '0', null, '2019-07-11 23:59:59', '2021-12-31 23:59:59', '5000', '4684', '2019-07-18 23:21:20');
INSERT INTO `company_fee_recharge` VALUES ('44', '274', '1', null, '1', '2000000', null, '2019-07-30 19:04:13', '2021-12-31 23:59:59', '5000', '1', '2019-07-30 19:04:40');
INSERT INTO `company_fee_recharge` VALUES ('46', '275', '1', null, '1', '10000000', null, '2019-08-03 11:21:23', '2021-12-31 23:59:59', '5000', '1', '2019-08-06 11:21:52');
INSERT INTO `company_fee_recharge` VALUES ('47', '276', '1', null, '1', '2000000', null, '2019-08-13 07:29:33', '2021-12-31 23:59:59', '5000', '1', '2019-08-13 09:30:12');
INSERT INTO `company_fee_recharge` VALUES ('48', '277', '1', null, '1', '500000000', null, '2019-08-16 11:16:07', '2021-12-31 23:59:59', '5000', '1', '2019-08-16 11:17:34');
