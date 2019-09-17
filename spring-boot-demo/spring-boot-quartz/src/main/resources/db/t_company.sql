/*
Navicat MySQL Data Transfer

Source Server         : 阿里
Source Server Version : 50725
Source Host           : rm-bp1saa198wv4arf9uio.mysql.rds.aliyuncs.com:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-20 10:33:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '企业名称',
  `name_abbreviate` varchar(45) DEFAULT NULL COMMENT '企业简称',
  `pinyin` varchar(200) DEFAULT NULL COMMENT '企业名称的拼音',
  `employees` int(10) unsigned DEFAULT '0' COMMENT '企业人数',
  `introduction` varchar(16) DEFAULT NULL COMMENT '宣传语',
  `cover` varchar(150) DEFAULT NULL COMMENT '封面图',
  `learn_count` int(10) unsigned DEFAULT '0' COMMENT '总学习人数',
  `password` char(32) DEFAULT NULL,
  `expire_date` int(11) unsigned DEFAULT NULL,
  `entry_mode` tinyint(2) NOT NULL DEFAULT '1' COMMENT '1密码登录,2申请登录',
  `banner` varchar(150) DEFAULT NULL COMMENT '企业banner',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='企业内训表';

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('23', '享学科技有限公司', '享学科技', 'xiangxuekejiyouxiangongsi', '68', '人人分享  人人学习  享受学习', 'http://xiangxue-company.ap511.com/cover/1560140413656.jpg', '6693', '123456', null, '1', null);
INSERT INTO `t_company` VALUES ('36', '深圳市爱施德股份有限公司', '爱施德', 'aishide', '0', '诚信、责任、服务、创新', 'http://xiangxue-course.ap511.com/company/a9.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('37', '深圳市天音通信发展有限公司', '天音通信', 'tianyintongxin', '0', '恒守人本、坚持诚信、服务客户', 'http://xiangxue-course.ap511.com/company/a8.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('38', '小米科技有限责任公司', '小米科技', 'xiaomikeji', '0', '为发烧而生', 'http://xiangxue-course.ap511.com/company/a32.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('39', '天翼电信终端有限公司', '天翼电信', 'tianyizhongduan', '0', '用户至上、用心服务', 'http://xiangxue-course.ap511.com/company/a24.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('40', '中国电信集团有限公司', '中国电信', 'dianxin', '0', '用户至上、用心服务', 'http://xiangxue-course.ap511.com/company/a20.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('41', '中国联合网络通信集团有限公司', '联合网络', 'liantong', '0', '创新●改变世界', 'http://xiangxue-course.ap511.com/company/a26.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('42', '联通华盛通信有限公司', '联通华盛', 'huasheng', '0', '创新●改变世界', 'http://xiangxue-course.ap511.com/company/a27.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('43', '中国移动通信集团有限公司', '中国移动', 'yidong', '0', '移动改变生活', 'http://xiangxue-course.ap511.com/company/a21.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('44', '中国移动通信集团终端有限公司', '移动通信终端', 'yidongzhongduan', '0', '移动改变生活', 'http://xiangxue-course.ap511.com/company/a22.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('45', '华为终端有限公司', '华为终端', 'huaweizhongduan', '0', '华为不仅仅是世界500强', 'http://xiangxue-course.ap511.com/company/a28.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('46', '广东欧珀移动通信有限公司', '欧珀移动', 'oppo', '0', '本分、诚信、创新、团队、品质', 'http://xiangxue-course.ap511.com/company/a29.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('47', '维沃移动通信有限公司', '维沃移动', 'vivo', '0', '敢于追求极致，持续创造惊喜', 'http://xiangxue-course.ap511.com/company/a31.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('98', '空间时间文化传播有限公司！', '空间时间', 'kongjianshijianwenhuachuanboyouxiangongsi！', '0', '空间时间', 'http://xiangxue-company.ap511.com/cover/1545875411176.jpg', '333', '123456', '0', '1', 'http://xiangxue-company.ap511.com/cover/1564554843897.jpg');
INSERT INTO `t_company` VALUES ('100', '金鹏通信手机连锁', '金鹏通信', 'jingpengtongxin', '0', '追求卓越品质，缔造世界名牌', 'http://xiangxue-course.ap511.com/company/a35.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('101', '余姚市星际通通信设备有限公司', '星际通', 'xingjitong', '0', '创优质品牌，铸一流企业', 'http://xiangxue-course.ap511.com/company/a36.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('102', '杭州利通数码科技有限公司', '利通数码', 'litongshuma', '0', '没有完美个个人，只有完美的团队', 'http://xiangxue-course.ap511.com/company/a37.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('104', '陕西中人通信有限责任公司', '陕西中人', 'shanxizhognren', '0', '细节决定成败，态度决定一切', 'http://xiangxue-course.ap511.com/company/a2.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('105', '成都龙翔通信有限责任公司', '成都龙翔', 'chengdulongxiang', '0', '追求卓越无止境，与时俱进创未来', 'http://xiangxue-course.ap511.com/company/a3.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('106', '成都讯捷通信连锁有限责任公司', '成都讯捷', 'chengduxunjie', '0', '您的满意是我们的追求', 'http://xiangxue-course.ap511.com/company/a4.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('107', '成都利群通信有限责任公司', '成都利群', 'chengduliqun', '0', '以匠心，打造专家团队', 'http://xiangxue-course.ap511.com/company/a5.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('108', '成都英普瑞生通信设备有限责任公司', '成都英普瑞生', 'chengduyinpuruisheng', '0', '凝聚产生力量，团结成就辉煌', 'http://xiangxue-course.ap511.com/company/a6.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('109', '四川佳海电子有限公司', '佳海电子', 'jiahaidianzi', '0', '诚信为本，合作共赢，创造价值', 'http://xiangxue-course.ap511.com/company/a7.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('186', '中域电讯', '中域电讯', 'zhongyudianxun', '0', '发展永远是第一要务', 'http://xiangxue-course.ap511.com/company/a10.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('187', '乐语Funtalk', '乐语', 'leyu', '0', '专业决定品质', 'http://xiangxue-course.ap511.com/company/a11.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('188', '恒波Holpe', '恒波', 'hengbo', '0', '把平凡事做得不平凡', 'http://xiangxue-course.ap511.com/company/a12.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('189', '话机世界T.WORLD', '话机世界', 'huajishijie', '0', '相信人人有才，引导人人成才', 'http://xiangxue-course.ap511.com/company/a13.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('190', '大地通信DADICOM', '大地通信', 'daditongxin', '0', '快乐工作，快乐成长', 'http://xiangxue-course.ap511.com/company/a14.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('214', '骏和通信', '骏和通信', 'junhetongxin', '0', '市场是企业的方向', 'http://xiangxue-course.ap511.com/company/a15.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('215', '中复电讯', '中复电讯', 'zhongfudianxun', '0', '不创新突破，只有出局', 'http://xiangxue-course.ap511.com/company/a16.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('216', '易天itell', '易天', 'yitian', '0', '以真诚为先导，以务实为基础', 'http://xiangxue-course.ap511.com/company/a17.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('217', '酷动Coodoo', '酷动', 'kudong', '0', '努力上进，立志有所作为', 'http://xiangxue-course.ap511.com/company/a18.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('218', '中国电信四川公司', '电信四川公司', 'dianxinsichuan', '0', '用户至上,用心服务', 'http://xiangxue-course.ap511.com/company/a19.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('219', '中国移动四川公司', '移动四川公司', 'yidongsichuan', '0', '用真诚构建美丽，用实力打造非凡', 'http://xiangxue-course.ap511.com/company/a23.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('220', '中国联通四川公司', '联通四川公司', 'liantongsichuan', '0', '让一切自由联通', 'http://xiangxue-course.ap511.com/company/a25.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('221', '四川欧珀（OPPO）', '成都欧柏', '01sichuanoppi', '0', '用户是企业发展的源泉', 'http://xiangxue-company.ap511.com/cover/1545972265057.jpg', '3958', '884060', '0', '1', null);
INSERT INTO `t_company` VALUES ('222', '杭州晶杰通信', '杭州晶杰', 'hangzhoujingjietongxin', '500', '晶杰通信，坚持杰出！', 'http://xiangxue-company.ap511.com/222.jpg', '6', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('223', '安徽鸿讯和客', '鸿讯和客', '113anhuihongxunheke', '0', '让员工实现梦想成为企业主导者', 'http://xiangxue-company.ap511.com/223.jpg', '11', '607106', '0', '1', null);
INSERT INTO `t_company` VALUES ('224', '北京易联讯达', '易联讯达', '114yilianxunda', '0', '始于诚 厚于德 赢于新 贵于恒', 'http://xiangxue-company.ap511.com/224.jpg', '29', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('225', '广西亚速通讯', '亚速通讯', 'guangxiyasutongxun', '300', '奋斗、分享、快乐', 'http://xiangxue-company.ap511.com/cover/1562209679872.jpg', '4727', '199147', '0', '1', null);
INSERT INTO `t_company` VALUES ('227', '江苏华顶数码', '华顶数码', '117huadingshuma', '0', '诚信、负责、拼搏、共赢', 'http://xiangxue-company.ap511.com/227.jpg', '1', '313444', '0', '1', null);
INSERT INTO `t_company` VALUES ('228', '迪信通集团总部', '迪信通', 'dixintongjituanzongbu', '0', '智能生活服务提供商', 'http://xiangxue-company.ap511.com/228.jpg', '3808', '453767', '0', '1', null);
INSERT INTO `t_company` VALUES ('229', '沃美商学院', '沃美高科', 'womeishangxueyuan', '268', '让培训不再局限于线下', 'http://xiangxue-company.ap511.com/cover/1545995612248.jpg', '103', '723380', '0', '1', null);
INSERT INTO `t_company` VALUES ('230', '长远通讯', '长远通讯', 'zhangyuantongxun', '51', '同心筑长远，明天会更好', 'http://xiangxue-company.ap511.com/cover/1546412055017.jpg', '13', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('231', '开封家得福', '家得福', '121kaifengjiadefu', '0', '家得福，您身边的通讯行业服务商', 'http://xiangxue-company.ap511.com/231.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('232', '谈机通讯', '谈机通讯', '122tanjitongxun', '0', '专注、执着', 'http://xiangxue-company.ap511.com/232.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('233', '国宇通讯', '国宇通讯', '123guoyutongxun', '0', '同心经营 共享未来', 'http://xiangxue-company.ap511.com/233.jpg', '5', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('234', '和瑞通', '和瑞通', '124heruitong', '0', '王者通讯手机专家——我信、我选', 'http://xiangxue-company.ap511.com/234.jpg', '0', '845705', '0', '1', null);
INSERT INTO `t_company` VALUES ('235', '郑州华语堂企业管理咨询有限公司', '郑州华语堂', 'zhengzhouhuayutangqiyeguanlizixunyouxiangongsi', '0', '“专业专注，服务通信行业客户”！', 'http://xiangxue-company.ap511.com/235.jpg', '545', '842007', '0', '1', null);
INSERT INTO `t_company` VALUES ('236', '平顶山市天翼晓华商贸有限公司', '天翼晓华 ', '14tianyixiaohua', '0', '您的满意是我们的追求', 'http://xiangxue-company.ap511.com/236.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('237', '和德信通（北京）', '和德信通', '02hedexintong（beijing）', '0', '手机及智能终端保障服务产品提供商', 'http://xiangxue-company.ap511.com/cover/1550655963331.jpg', '69', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('238', '河南迪信通商贸有限公司', '河南迪信通', '03henandixintongshangmaoyouxiangongsi', '0', '智能生活服务提供商', 'http://xiangxue-company.ap511.com/238.jpg', '78', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('239', '郑州超讯发', '郑州超讯发', '03zhengzhouchaoxunfa', '0', '服务创造未来', 'http://xiangxue-company.ap511.com/239.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('240', '湖北迪信通', '湖北迪信通', '04hubeidixintong', '0', '智能生活服务提供商', 'http://xiangxue-company.ap511.com/240.jpg', '15706', '925303', '0', '1', null);
INSERT INTO `t_company` VALUES ('241', '湖南迪信通', '湖南迪信通', '05hunandixintong', '0', '智能生活服务提供商', 'http://xiangxue-company.ap511.com/241.jpg', '27', '138158', '0', '1', null);
INSERT INTO `t_company` VALUES ('242', '辽宁电信', '辽宁电信', 'liaoningdianxin', '5000', '领跑信息科技,维系万千基业', 'http://xiangxue-company.ap511.com/cover/1552464181621.jpg', '74', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('243', '河南欧珀（OPPO）', '河南OPPO', '06henanoppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/243.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('244', '上海迪信通', '上海迪信通', '07shanghaidixintong', '0', '服务创造未来', 'http://xiangxue-company.ap511.com/244.jpg', '600', '071671', '0', '1', null);
INSERT INTO `t_company` VALUES ('245', '广西OPPO', '广西OPPO', '07guangxioppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/245.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('246', '南宁OPPO', '南宁OPPO', '08nanningoppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/246.jpg', '966', '506294', '0', '1', null);
INSERT INTO `t_company` VALUES ('247', '辽宁抚顺电信', '辽宁抚顺电信', '09liaoningfusun', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/247.jpg', '0', '936668', '0', '1', null);
INSERT INTO `t_company` VALUES ('248', 'OPPO内部体验', 'OPPO内部体验', '10oppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.oss-cn-hangzhou.aliyuncs.com/248.jpeg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('249', '深圳电信', '深圳电信', '11liaoningfusun', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/249.jpg', '790', '826037', '0', '1', null);
INSERT INTO `t_company` VALUES ('250', '湖南oppo', '湖南oppo', '12oppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/250.jpg', '91', '212354', '0', '1', null);
INSERT INTO `t_company` VALUES ('251', '四川欧珀 DL（OPPO）', '四川欧珀 DL（OPPO）', '13sichuanoppodaili', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/251.jpg', '1266', '521165', '0', '1', null);
INSERT INTO `t_company` VALUES ('252', '江西OPPO体专事业部', '江西OPPO体专事业部', '14jiangxioppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/252.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('253', '江西vivo体专事业部', '江西vivo体专事业部', '14jiangxioppo', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/253.jpg', '1997', '347342', '0', '1', null);
INSERT INTO `t_company` VALUES ('254', '广西鑫仕泽', '广西鑫仕泽', '15xingshize', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/254.jpg', '38', '655244', '0', '1', null);
INSERT INTO `t_company` VALUES ('255', '内蒙包头金篇', '内蒙包头金篇', 'neimengbaotoujinpian', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/255.jpg', '125', '520005', '0', '1', null);
INSERT INTO `t_company` VALUES ('256', '成都金丰立', '成都金丰立', 'chengdoujinfengli', '10', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/256.jpg', '2', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('257', '江西荧核悦', '江西荧核悦', 'yingherui', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/257.jpg', '29', '908180', '0', '1', null);
INSERT INTO `t_company` VALUES ('258', '青岛翼家', '青岛翼家', 'qingdaoyijia', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/258.jpg', '0', '809166', '0', '1', null);
INSERT INTO `t_company` VALUES ('259', '深圳电信中小渠道', '深圳电信中小渠道', 'shenzxiaoqudao', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/259.jpeg', '453', '012457', '0', '1', null);
INSERT INTO `t_company` VALUES ('260', '百度智能音响', '百度智能音响', 'shangxibaidu', '0', '本分、用户导向、追求极致、结果导', 'http://xiangxue-company.ap511.com/260.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('261', '广西电信', '广西电信(销售及渠道扩展部)', 'gaungxidianxin', '20000', '更快、更新、更好，更聚焦、更全面', 'http://xiangxue-company.ap511.com/261.jpg', '31972', '189189', '0', '1', null);
INSERT INTO `t_company` VALUES ('262', '广西三才通信设备有限公司', '广西三才通信', 'guangxisancaitongxinshebeiyouxiangongsi', '1000', '专业决定品质', 'http://xiangxue-company.ap511.com/262.jpg', '32', '116902', '0', '1', null);
INSERT INTO `t_company` VALUES ('263', '福建人本教育', '福建人本教育', 'fujianrenbenjiaoyu', '0', '以真诚为先导，以务实为基础', 'http://xiangxue-company.ap511.com/263.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('264', '福建迪信通', '福建迪信通', 'fujiandixintong', '0', '服务创造未来', 'http://xiangxue-company.ap511.com/264.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('265', '动力步', '动力步', 'donglibu', '0', '科技改善健康   ', 'http://xiangxue-company.ap511.com/265.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('266', '巴中劳动就业保障培训', '巴中劳动就业保障培训', 'bazhonglaodongjiuyebaozhangpeixun', '0', ' 坚持以人民为中心', 'http://xiangxue-company.ap511.com/266.jpg', '0', '654321', '0', '1', null);
INSERT INTO `t_company` VALUES ('267', '巴中教育局教师培训', '巴中教育局教师培训', 'bazhongjiaoyujujiaoshipeixun', '0', '让人民有更多获得感幸福感', 'http://xiangxue-company.ap511.com/267.jpg', '0', '654321', '0', '1', null);
INSERT INTO `t_company` VALUES ('268', '福建小米', '福建小米', 'fujianxiaomi', '100', '为发烧而生   ', 'http://xiangxue-company.ap511.com/268.png', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('269', '四川格力', '四川格力', 'sichuangeli', '100', '格力掌握核心科技 ', 'http://xiangxue-company.ap511.com/269.jpg', '22', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('270', '迪信通IOT智能潮品培训', '迪信通IOT智能潮品培训', 'dixintongIOTzhinengchaopingpeixun', '10000', '智能生活服务提供商', 'http://xiangxue-company.ap511.com/270.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('271', '牛智物联', '牛智物联', 'niuzhiwulian', '200', '市场是企业的方向', 'http://xiangxue-company.ap511.com/cover/1566195330047.png', '0', '032359', '0', '1', '');
INSERT INTO `t_company` VALUES ('272', '华阳悦客', '华阳悦客', 'huayangyueke', '200', '赋能实体门店、创新引领转型', 'http://xiangxue-company.ap511.com/272.jpg', '35', '643124', '0', '1', null);
INSERT INTO `t_company` VALUES ('273', '宁波星际通', '宁波星际通', 'ningboxingjitong', '200', '把平凡事做得不平凡', 'http://xiangxue-company.ap511.com/273.jpg', '23', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('274', '平果王者通讯', '平果王者通讯', 'ningboxingjitong', '200', '专业决定品质', 'http://xiangxue-company.ap511.com/274.png', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('275', '湖南电信365成长计划', '湖南电信365成长计划', 'hulandianxin365chengzhangjihua', '1000', '专业决定品质', 'http://xiangxue-company.ap511.com/275.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('276', '四川揽客魔术', '四川揽客魔术', 'sichuanlankemoshu', '200', '市场是企业的方向', 'http://xiangxue-company.ap511.com/276.jpg', '0', '123456', '0', '1', null);
INSERT INTO `t_company` VALUES ('277', '康裕咨询', '康裕咨询', 'kangyuzixun', '50000', '合作共赢，与客户共筑基业长青', 'http://xiangxue-company.ap511.com/277.png', '0', '123456', '0', '1', null);
