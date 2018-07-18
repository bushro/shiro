/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-07-12 18:35:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wc_study
-- ----------------------------
DROP TABLE IF EXISTS `wc_study`;
CREATE TABLE `wc_study` (
  `c_id` int(255) NOT NULL AUTO_INCREMENT,
  `c_image` varchar(255) DEFAULT NULL,
  `c_title` varchar(255) DEFAULT NULL,
  `c_intrduce` varchar(255) DEFAULT NULL,
  `c_degree` varchar(255) DEFAULT NULL,
  `c_people` int(100) DEFAULT NULL,
  `c_time` datetime DEFAULT NULL,
  `c_author` varchar(255) DEFAULT NULL,
  `c_content` longtext,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wc_study
-- ----------------------------

-- ----------------------------
-- Table structure for wc_user
-- ----------------------------
DROP TABLE IF EXISTS `wc_user`;
CREATE TABLE `wc_user` (
  `user_id` varchar(255) NOT NULL COMMENT '用户名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `user_active` varchar(255) DEFAULT NULL COMMENT '0锁定，1不锁',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `wc_user_roles` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wc_user
-- ----------------------------
INSERT INTO `wc_user` VALUES ('admin1', '5826c6b4f4f7b527b3d6ecd6f45401a9', '1');
INSERT INTO `wc_user` VALUES ('admin2', 'c3270271f36e5e795e54c2721896102e', '1');

-- ----------------------------
-- Table structure for wc_user_power
-- ----------------------------
DROP TABLE IF EXISTS `wc_user_power`;
CREATE TABLE `wc_user_power` (
  `user_role` varchar(255) NOT NULL COMMENT '用户角色',
  `user_power` varchar(255) DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`user_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wc_user_power
-- ----------------------------
INSERT INTO `wc_user_power` VALUES ('admin', 'all');
INSERT INTO `wc_user_power` VALUES ('user', 'select');

-- ----------------------------
-- Table structure for wc_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `wc_user_roles`;
CREATE TABLE `wc_user_roles` (
  `user_id` varchar(255) NOT NULL COMMENT '用户名',
  `user_role` varchar(255) DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wc_user_roles
-- ----------------------------
INSERT INTO `wc_user_roles` VALUES ('admin1', 'superadmin');
INSERT INTO `wc_user_roles` VALUES ('admin2', 'commonadmin');
