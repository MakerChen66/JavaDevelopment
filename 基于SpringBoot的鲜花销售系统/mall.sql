/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-24 23:45:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) NOT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `classification`
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classification
-- ----------------------------
INSERT INTO `classification` VALUES ('12', '玫瑰', '0', '1');
INSERT INTO `classification` VALUES ('13', '隐逸花', '0', '1');
INSERT INTO `classification` VALUES ('15', 'rose', '12', '2');
INSERT INTO `classification` VALUES ('16', 'chrysanthemum', '13', '2');
INSERT INTO `classification` VALUES ('18', '百合', '0', '1');
INSERT INTO `classification` VALUES ('19', '满天星', '0', '1');
INSERT INTO `classification` VALUES ('21', 'lily', '18', '2');
INSERT INTO `classification` VALUES ('22', 'Babysbreath', '19', '2');
INSERT INTO `classification` VALUES ('23', '其他', '0', '1');
INSERT INTO `classification` VALUES ('24', 'other', '23', '2');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `phone` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('6', '湖南长沙', '石魁', '2019-10-02 22:59:58', '15575884696', '3', '555', '1');
INSERT INTO `order` VALUES ('7', '湖南长沙湖南信息职业技术学院', 'lambert.shi', '2019-10-14 12:55:15', '13786887337', '4', '600', '5');
INSERT INTO `order` VALUES ('8', '这些', '地方', '2019-10-14 13:06:53', '214', '3', '9600', '5');
INSERT INTO `order` VALUES ('9', '是', 'qq', '2019-10-16 08:07:32', '1', '2', '600', '5');
INSERT INTO `order` VALUES ('10', '11', '11', '2019-10-18 02:14:20', '11', '1', '55', '5');
INSERT INTO `order` VALUES ('11', 'sa', 'sa', '2019-10-18 02:51:29', 'sa', '2', '666', '6');

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1', '1', '1', '10', '8888');
INSERT INTO `order_item` VALUES ('2', '2', '2', '9', '17998');
INSERT INTO `order_item` VALUES ('3', '2', '3', '11', '78');
INSERT INTO `order_item` VALUES ('4', '1', '3', '13', '5999');
INSERT INTO `order_item` VALUES ('5', '1', '4', '9', '8999');
INSERT INTO `order_item` VALUES ('6', '1', '5', '13', '5999');
INSERT INTO `order_item` VALUES ('7', '1', '6', '14', '555');
INSERT INTO `order_item` VALUES ('8', '1', '7', '15', '600');
INSERT INTO `order_item` VALUES ('9', '5', '8', '15', '9600');
INSERT INTO `order_item` VALUES ('10', '1', '9', '15', '600');
INSERT INTO `order_item` VALUES ('11', '1', '10', '14', '55');
INSERT INTO `order_item` VALUES ('12', '1', '11', '14', '666');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `csid` int(11) DEFAULT NULL,
  `desc` varchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `shop_price` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('14', '15', '花色是最标准的玫瑰红，红色中的经典款，也是最畅销的一款，属于红玫瑰中的顶级品种。', '/mall/admin/product/img/56FD776C1C422092775FED55D46CB1.jpg', '1', '999', '2019-10-18 03:12:39', '666', '红玫瑰（卡罗拉）');
INSERT INTO `product` VALUES ('15', '15', '颜色组合古朴、别致平满芯。翘角、卷边外瓣色淡，个别外瓣瓣缘呈浅绿色；内瓣色浓、均匀，花瓣排列整齐、紧凑。', '/mall/admin/product/img/E3F3F84A92328CC39A1442411D3329.png', '0', '280', '2019-10-18 03:12:32', '200', '香槟');
INSERT INTO `product` VALUES ('17', '15', '具有迷人的气质，玫瑰不仅危险，还经常成为重金属摇滚乐专辑和幻想书籍的封面，无法说出口的爱。', '/mall/admin/product/img/CBF6B82567780B11E0413BEED4E408.jpg', '0', '800', '2019-10-18 03:12:18', '750', '黑玫瑰');
INSERT INTO `product` VALUES ('18', '15', '戴安娜是最漂亮的粉玫瑰。就像午后阳光，淡淡的温暖里，有着我们无法拒绝的舒适。', '/mall/admin/product/img/1D72E840B1FE8279DC07D57F028E25.jpg', '0', '230', '2019-10-18 03:12:12', '190', '戴安娜');
INSERT INTO `product` VALUES ('19', '24', '开花的植物中最香的一个品种，蓝色风信子代表生命、贞操、忧郁的爱，白色代表纯洁和暗恋，黄色代表幸福与感谢，红色代表热情和热恋，粉色代表浪漫与宁静，而紫色则代表道歉、自责或缅怀之意。', '/mall/admin/product/img/80DA674A949BFF15F9173BE8520375.jpg', '0', '119', '2019-10-18 03:12:05', '110', '风信子');
INSERT INTO `product` VALUES ('20', '21', '“云裳仙子”，外表高雅纯洁，天主教以白百合花为圣母玛利亚的象征，而梵蒂冈以百合花为国花。百合的种头由鳞片抱合而成，取“百年好合”“百事合意”之意，中国自古视为婚礼必不可少的吉祥花卉。', '/mall/admin/product/img/4CB22186282455D2A29F590AF64F37.jpg', '1', '688', '2019-10-18 03:11:58', '599', '香水百合');
INSERT INTO `product` VALUES ('21', '21', '重逢的喜悦；期待再一次相遇；深深的祝福和百年好合之意。', '/mall/admin/product/img/A295FE68A3B1AF2959F86E6A53A5B4.png', '0', '288', '2019-10-18 03:11:50', '199', '水仙百合');
INSERT INTO `product` VALUES ('22', '16', '黄色的菊花代表着高雅的君子品格，所以在平时也可以用来送给老师、长辈等。', '/mall/admin/product/img/70F8F1F1342FB5EC758C8FDDEC1F20.jpg', '0', '155', '2019-10-18 03:11:43', '100', '黄半球菊花');
INSERT INTO `product` VALUES ('23', '16', '纯洁的美·天真·幼稚, 愉快、幸福、和平、希望，还有“深藏在心底的爱”。', '/mall/admin/product/img/72A784C69649F8A3C403DCBD6E7C86.jpg', '1', '288', '2019-10-18 03:11:33', '199', '小雏菊');
INSERT INTO `product` VALUES ('24', '24', '热情、魅力、使人柔弱的爱、真情、母亲我爱你、温馨的祝福、热爱着你、慈祥、不求代价的母爱、宽容、母亲之花、浓郁的亲情、亲情思念、清纯的爱慕之情、热恋、热心、伤心与懊悔、伟大、神圣，慰问、心灵的相通、真挚、走运、思念。', '/mall/admin/product/img/83070AEFAED058105A4A35E5DB5897.jpg', '1', '399', '2019-10-18 03:11:17', '319', '康乃馨');
INSERT INTO `product` VALUES ('25', '22', '思念、清纯、梦境、真心喜欢、配角，但不可缺。', '/mall/admin/product/img/6D6496CDDDC3950D792A068064210A.jpg', '0', '99', '2019-10-18 03:11:09', '88', '蓝色满天星');
INSERT INTO `product` VALUES ('26', '22', '思念、清纯、梦境、真心喜欢、配角，但不可缺。', '/mall/admin/product/img/4CA802C15AE1DB7624AC6469621371.jpg', '0', '99', '2019-10-18 03:10:59', '88', '红色满天星');
INSERT INTO `product` VALUES ('27', '24', '信念、光辉、高傲、忠诚、爱慕，向日葵的寓意是沉默的爱，向日葵代表着勇敢地去追求自己想要的幸福。', '/mall/admin/product/img/D5B984D40690DCA42AFF89AB7425EA.jpg', '0', '188', '2019-10-18 03:10:52', '166', '向日葵');
INSERT INTO `product` VALUES ('28', '16', '在逆境中成长，不向困难低头、和好等意思。因为洋甘菊的生命力很顽强，从来不因为困难而倒下，正是由于它的生长精神，从而导致它的花语也是一种积极正能量。', '/mall/admin/product/img/2D81236F07CB7C616B2E33D9D041B3.jpg', '0', '168', '2019-10-18 03:10:31', '118', '洋甘菊');
INSERT INTO `product` VALUES ('29', '24', '多肉又称观音莲,具有沾佛气,送运气的含义。', '/mall/admin/product/img/BE9418E5267FA3A87800BCD795BF9B.jpg', '0', '80', '2019-10-18 03:10:42', '60', '多肉');
INSERT INTO `product` VALUES ('30', '24', '永久的爱和美丽、质朴和美德，花朵茂盛,花色鲜艳,香气浓郁。', '/mall/admin/product/img/ECBAE1447B2605A46C2493C7E58141.jpg', '0', '188', '2019-10-18 02:25:29', '168', '紫罗兰');
INSERT INTO `product` VALUES ('31', '24', '真诚不变的爱，纯洁、无邪 、漂亮、感动，富於感情。', '/mall/admin/product/img/768569B500563F8690D9255FBA6F01.jpg', '0', '368', '2019-10-18 02:38:45', '298', '洋桔梗');
INSERT INTO `product` VALUES ('32', '21', '典雅而富丽,象征着友谊。', '/mall/admin/product/img/2F0874BFB30FE9D26ACBCFE15B61ED.jpg', '0', '410', '2019-10-18 02:45:02', '310', '秘鲁百合');
INSERT INTO `product` VALUES ('33', '24', '有着非常美好的花语,它的花语为永远的爱、永恒的回忆以及永远不变的心。', '/mall/admin/product/img/85B82D8A7274A26E3E5B9A0794B31C.jpg', '0', '188', '2019-10-18 02:46:24', '166', '勿忘我');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '湖南长沙职业技术学院', '670569467@qq.com', 'lambert.shi', 'admin', '13786887333', 'admin');
INSERT INTO `user` VALUES ('6', 'da', '2072923175@qq.com', '大', '123', '15007445676', '1');
