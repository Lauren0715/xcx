/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : z_web

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 29/12/2020 13:52:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ad_id` int NOT NULL,
  `ad_log` varchar(255) NOT NULL,
  `ad_pwd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, '111', '111');
INSERT INTO `admin` VALUES (2, 'admin', '111');
INSERT INTO `admin` VALUES (3, '111111', '111111');
INSERT INTO `admin` VALUES (4, '123', '456');
COMMIT;

-- ----------------------------
-- Table structure for fk_cpjy
-- ----------------------------
DROP TABLE IF EXISTS `fk_cpjy`;
CREATE TABLE `fk_cpjy` (
  `detail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_cpjy
-- ----------------------------
BEGIN;
INSERT INTO `fk_cpjy` VALUES (NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for fk_gnyc
-- ----------------------------
DROP TABLE IF EXISTS `fk_gnyc`;
CREATE TABLE `fk_gnyc` (
  `detail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_gnyc
-- ----------------------------
BEGIN;
INSERT INTO `fk_gnyc` VALUES ('啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('哦挥洒等候 i 啊活动地方等你送 i 我就去拍', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('哦挥洒等候 i 啊活动地方等你送 i 我就去拍活动啊是哦对哈', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('或辜负义愤填膺翻译干净利落好看', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('就是对嗨皮啊师傅怕是佩服你送的；final·', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('说的是；非；阿森纳翻看了个美丽的撒干嘛', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('拉赫蒂市电话拉屎咖啡连卡佛你离开那；快', '17817182488');
INSERT INTO `fk_gnyc` VALUES ('fhoashfpsdlamslf;alfl;adk', '17817182488');
COMMIT;

-- ----------------------------
-- Table structure for fk_wgjb
-- ----------------------------
DROP TABLE IF EXISTS `fk_wgjb`;
CREATE TABLE `fk_wgjb` (
  `detail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_wgjb
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for fk_zfwt
-- ----------------------------
DROP TABLE IF EXISTS `fk_zfwt`;
CREATE TABLE `fk_zfwt` (
  `detail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zfwt
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for fy_data
-- ----------------------------
DROP TABLE IF EXISTS `fy_data`;
CREATE TABLE `fy_data` (
  `fyid` int NOT NULL AUTO_INCREMENT,
  `fytp` varchar(255) DEFAULT NULL,
  `fydz` varchar(255) DEFAULT NULL,
  `fyjg` varchar(255) DEFAULT NULL,
  `fypf` varchar(255) DEFAULT NULL,
  `fymc` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `common` varchar(255) DEFAULT NULL,
  `bb1` varchar(255) DEFAULT NULL,
  `bb2` varchar(255) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `fdmc` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fyid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fy_data
-- ----------------------------
BEGIN;
INSERT INTO `fy_data` VALUES (1, '3', NULL, '666', NULL, '【skullpanda】CBD天河区K1/兴盛路/广州塔附近/投影/珠江新城公寓【浴缸】每客消毒', NULL, NULL, NULL, NULL, NULL, '', '天河区');
COMMIT;

-- ----------------------------
-- Table structure for sp_data
-- ----------------------------
DROP TABLE IF EXISTS `sp_data`;
CREATE TABLE `sp_data` (
  `SP_id` int NOT NULL AUTO_INCREMENT,
  `SP_mingcheng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SP_jiage` int DEFAULT NULL,
  `SP_kucun` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SP_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SP_check` tinyint DEFAULT NULL,
  PRIMARY KEY (`SP_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2228 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sp_data
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sysinfo
-- ----------------------------
DROP TABLE IF EXISTS `sysinfo`;
CREATE TABLE `sysinfo` (
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pixel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `width` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `sys` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysinfo
-- ----------------------------
BEGIN;
INSERT INTO `sysinfo` VALUES ('iphone XR', '2', '414', '808', 'zh_CN', '7.0.4', 'IOS 10.0.1', 'devtools');
COMMIT;

-- ----------------------------
-- Table structure for th_dingdan
-- ----------------------------
DROP TABLE IF EXISTS `th_dingdan`;
CREATE TABLE `th_dingdan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `situation` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `tupian` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `booker` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of th_dingdan
-- ----------------------------
BEGIN;
INSERT INTO `th_dingdan` VALUES (1, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '左营区', '2019年7月25-26日', '5', '订单已完成', '835', '1', '高雄左营高铁捷运台铁旁、一次一组客人、免费停车位/适合6-17人', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (2, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '吉安乡', '2019年7月21-23日', '5', '订单已取消', '941', '2', '花莲县吉安乡吉兴三街125巷19号', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (3, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '天河区', '2020年12月31-1日', '5', '待支付订单', '666', '3', '【skullpanda】CBD天河区K1/兴盛路/广州塔附近/投影/珠江新城公寓【浴缸】每客消毒', NULL, NULL, '欧霆', '440181200001010063');
INSERT INTO `th_dingdan` VALUES (4, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '番禺区', '2020年1月23-24日', '2', '订单已完成', '233', '4', '广州长隆地铁口&近南站广州塔&北欧森系网红投影独立两房', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (5, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '香洲区', '2020年10月1-2日', '3', '订单已取消', '180', '5', 'Khouse 4 珠海超高档小区，停车方便，封顶8元', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (6, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '香洲区', '2020年10月1-2日', '3', '订单已完成', '196', '6', '超大投影仪 步行可达滨海泳场珠海渔女/情侣路海滨公园/日月贝/港珠澳大桥/扬名广场', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (7, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '越秀区', '2021年1月1-2日', '5', '待支付订单', '786', '7', '【空中花园】北京路/上下九/陈家祠/沙面/珠江夜游/广州塔|西关美食&近西门口地铁观景大阳台温馨三房', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (8, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '番禺区', '2019年6月26-27日', '4', '订单已完成', '412', '8', '高雄左营高铁捷运台铁旁、一次一组客人、免费停车位/适合6-17人', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (9, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '天河区', '2019年6月27-29日', '5', '订单已取消', '376', '9', '【skullpanda】CBD天河区K1/兴盛路/广州塔附近/投影/珠江新城公寓【浴缸】每客消毒', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (10, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '吉安乡', '2019年6月29-30日', '2', '订单已完成', '248', '10', '【空中花园】北京路/上下九/陈家祠/沙面/珠江夜游/广州塔|西关美食&近西门口地铁观景大阳台温馨三房', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (11, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '越秀区', '2019年6月30-31日', '3', '待支付订单', '352', '11', '高雄左营高铁捷运台铁旁、一次一组客人、免费停车位/适合6-17人', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (12, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '天河区', '2019年7月5-7日', '5', '订单已完成', '633', '12', '超大投影仪 步行可达滨海泳场珠海渔女/情侣路海滨公园/日月贝/港珠澳大桥/扬名广场', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (13, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '吉安乡', '2019年7月25-26日', '7', '订单已完成', '720', '13', '超大投影仪 步行可达滨海泳场珠海渔女/情侣路海滨公园/日月贝/港珠澳大桥/扬名广场', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (14, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '越秀区', '2018年7月20-21日', '2', '待支付订单', '476', '14', '【skullpanda】CBD天河区K1/兴盛路/广州塔附近/投影/珠江新城公寓【浴缸】每客消毒', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (15, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '番禺区', '2018年7月21-23日', '4', '订单已取消', '711', '15', '【空中花园】北京路/上下九/陈家祠/沙面/珠江夜游/广州塔|西关美食&近西门口地铁观景大阳台温馨三房', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (16, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '天河区', '2018年7月23-24日', '5', '订单已完成', '371', '16', '高雄左营高铁捷运台铁旁、一次一组客人、免费停车位/适合6-17人', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (17, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '吉安乡', '2018年7月24-26日', '5', '订单已完成', '487', '17', '【空中花园】北京路/上下九/陈家祠/沙面/珠江夜游/广州塔|西关美食&近西门口地铁观景大阳台温馨三房', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (18, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '越秀区', '2019年1月30-31日', '2', '订单已完成', '156', '18', '高雄左营高铁捷运台铁旁、一次一组客人、免费停车位/适合6-17人', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (19, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '吉安乡', '2021年1月10-11日', '3', '订单已取消', '237', '19', '【skullpanda】CBD天河区K1/兴盛路/广州塔附近/投影/珠江新城公寓【浴缸】每客消毒', NULL, NULL, NULL, NULL);
INSERT INTO `th_dingdan` VALUES (20, 'ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '天河区', '2021年1月10-13日', '5', '待支付订单', '586', '20', '花莲县吉安乡吉兴三街125巷19号', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for th_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `th_userinfo`;
CREATE TABLE `th_userinfo` (
  `openid` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of th_userinfo
-- ----------------------------
BEGIN;
INSERT INTO `th_userinfo` VALUES ('ozSIj6mnCyM0JrbKj-dYz2AfxGfA', '13902384433', '1048821993@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for xcx_sp_data
-- ----------------------------
DROP TABLE IF EXISTS `xcx_sp_data`;
CREATE TABLE `xcx_sp_data` (
  `spid` varchar(255) NOT NULL,
  `spname` varchar(255) DEFAULT NULL,
  `spinfo` varchar(255) DEFAULT NULL,
  `spjiage` varchar(255) DEFAULT NULL,
  `view` int DEFAULT NULL,
  `spjpg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`spid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xcx_sp_data
-- ----------------------------
BEGIN;
INSERT INTO `xcx_sp_data` VALUES ('111', '三只老鼠', '不怎么好吃的坚果', '30', NULL, '001.jpg');
INSERT INTO `xcx_sp_data` VALUES ('112', 'iphone', '上等人手机', '6888', NULL, '002.jpg');
INSERT INTO `xcx_sp_data` VALUES ('113', '洗发水', '洗了一定有头屑', '68.8', NULL, '003.jpg');
INSERT INTO `xcx_sp_data` VALUES ('114', '周黑鸭', '隔壁家孩子闻着都哭了', '39.9', NULL, '004.jpg');
COMMIT;

-- ----------------------------
-- Table structure for xcx_yh_info
-- ----------------------------
DROP TABLE IF EXISTS `xcx_yh_info`;
CREATE TABLE `xcx_yh_info` (
  `yh_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `yh_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xcx_yh_info
-- ----------------------------
BEGIN;
INSERT INTO `xcx_yh_info` VALUES ('111', '2222');
INSERT INTO `xcx_yh_info` VALUES ('1111', '1111');
INSERT INTO `xcx_yh_info` VALUES ('123', '456');
INSERT INTO `xcx_yh_info` VALUES ('2222', '2222');
COMMIT;

-- ----------------------------
-- Table structure for xw_data
-- ----------------------------
DROP TABLE IF EXISTS `xw_data`;
CREATE TABLE `xw_data` (
  `XW_id` int NOT NULL AUTO_INCREMENT,
  `XW_topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `XW_keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `XW_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `XW_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `XW_check` tinyint DEFAULT '0',
  PRIMARY KEY (`XW_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of xw_data
-- ----------------------------
BEGIN;
INSERT INTO `xw_data` VALUES (3, 'Pdf', 'Ads', '', NULL, 0);
INSERT INTO `xw_data` VALUES (4, '111', '111', '', NULL, 0);
INSERT INTO `xw_data` VALUES (6, '444', '444', '', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for yh_data
-- ----------------------------
DROP TABLE IF EXISTS `yh_data`;
CREATE TABLE `yh_data` (
  `YH_id` int NOT NULL AUTO_INCREMENT,
  `YH_log` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `YH_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`YH_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of yh_data
-- ----------------------------
BEGIN;
INSERT INTO `yh_data` VALUES (1, '111111', '111111');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
