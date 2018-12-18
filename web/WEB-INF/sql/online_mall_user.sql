/*
Navicat MySQL Data Transfer
Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001
Date: 2018-12-18 16:02:42
*/

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `online_mall_user`;
CREATE TABLE `online_mall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '会员名',
  `password` char(20) NOT NULL DEFAULT '' COMMENT '密码',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

