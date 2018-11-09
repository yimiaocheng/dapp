/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dapp

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-05 17:05:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dapp_currency
-- ----------------------------
DROP TABLE IF EXISTS `dapp_currency`;
CREATE TABLE `dapp_currency` (
  `currency_name` varchar(16) NOT NULL,
  `currency_name_cn` varchar(16) NOT NULL,
  `status` varchar(8) NOT NULL,
  PRIMARY KEY (`currency_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dapp_currency_market
-- ----------------------------
DROP TABLE IF EXISTS `dapp_currency_market`;
CREATE TABLE `dapp_currency_market` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currency_pair` varchar(16) DEFAULT NULL COMMENT '货币对id',
  `amount` double DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=950 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dapp_currency_pair
-- ----------------------------
DROP TABLE IF EXISTS `dapp_currency_pair`;
CREATE TABLE `dapp_currency_pair` (
  `currency_pair` varchar(16) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dapp_eth_token
-- ----------------------------
DROP TABLE IF EXISTS `dapp_eth_token`;
CREATE TABLE `dapp_eth_token` (
  `token_addr` varchar(64) NOT NULL COMMENT '代币地址',
  `token_name` varchar(36) DEFAULT NULL COMMENT '代币名称',
  `token_decimals` int(11) DEFAULT NULL COMMENT '代币小数位数',
  PRIMARY KEY (`token_addr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='以太坊代币表';

-- ----------------------------
-- Table structure for dapp_eth_wallet
-- ----------------------------
DROP TABLE IF EXISTS `dapp_eth_wallet`;
CREATE TABLE `dapp_eth_wallet` (
  `addr` varchar(42) NOT NULL COMMENT '托管钱包地址',
  `user_open_id` varchar(36) DEFAULT NULL COMMENT '系统用户id',
  `private_key` varchar(64) DEFAULT NULL COMMENT '钱包私钥',
  `keystore` varchar(1024) DEFAULT NULL,
  `balance` varchar(36) DEFAULT NULL COMMENT '余额[需要转为18位小数]',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`addr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='eth托管钱包';

-- ----------------------------
-- Table structure for dapp_eth_wallet_token
-- ----------------------------
DROP TABLE IF EXISTS `dapp_eth_wallet_token`;
CREATE TABLE `dapp_eth_wallet_token` (
  `addr` varchar(42) NOT NULL COMMENT '托管钱包地址',
  `token_addr` varchar(64) DEFAULT NULL COMMENT '代币地址',
  `token_name` varchar(36) DEFAULT NULL COMMENT '代币名称',
  `token_balance` varchar(36) DEFAULT NULL COMMENT '代币余额[需除以代币小数位数]',
  `token_decimals` int(11) DEFAULT NULL COMMENT '代币小数位数',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`addr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='托管钱包代币';

-- ----------------------------
-- Table structure for dapp_eth_wallet_token_transfer
-- ----------------------------
DROP TABLE IF EXISTS `dapp_eth_wallet_token_transfer`;
CREATE TABLE `dapp_eth_wallet_token_transfer` (
  `id` varchar(36) NOT NULL,
  `hash` varchar(66) NOT NULL,
  `from_addr` varchar(42) DEFAULT NULL COMMENT '支付地址(空则为提现)',
  `to_addr` varchar(42) DEFAULT NULL COMMENT '收款地址[空则为充值]',
  `timestamp` datetime DEFAULT NULL COMMENT '转账时间戳',
  `gas_price` varchar(36) DEFAULT NULL COMMENT '手续费[需除以18位小数]',
  `amount` varchar(36) DEFAULT NULL COMMENT '转账金额[需除以代币小数位数]',
  `descr` varchar(128) DEFAULT NULL COMMENT '转账描述',
  `transfer_type` varchar(8) DEFAULT NULL COMMENT 'DIG:挖矿,TX转账',
  `status` tinyint(4) DEFAULT NULL COMMENT '0失败，1成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='以太坊代币转账记录表';

-- ----------------------------
-- Table structure for dapp_eth_wallet_transfer
-- ----------------------------
DROP TABLE IF EXISTS `dapp_eth_wallet_transfer`;
CREATE TABLE `dapp_eth_wallet_transfer` (
  `hash` varchar(66) NOT NULL,
  `from_addr` varchar(42) DEFAULT NULL COMMENT '支付地址(空则为提现)',
  `to_addr` varchar(42) DEFAULT NULL COMMENT '收款地址[空则为充值]',
  `timestamp` datetime DEFAULT NULL COMMENT '转账时间戳',
  `gas_price` varchar(36) DEFAULT NULL COMMENT '手续费[需除以18位小数]',
  `amount` varchar(36) DEFAULT NULL COMMENT '转账金额[需除以18位小数]',
  `descr` varchar(128) DEFAULT NULL COMMENT '转账描述',
  `status` tinyint(4) DEFAULT NULL COMMENT '0失败，1成功',
  PRIMARY KEY (`hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='以太坊转账记录表';

-- ----------------------------
-- Table structure for dapp_ore_coin
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_coin`;
CREATE TABLE `dapp_ore_coin` (
  `id` varchar(36) NOT NULL,
  `user_open_id` varchar(36) DEFAULT NULL COMMENT '系统用户openid',
  `coin_amount` varchar(36) DEFAULT NULL COMMENT '矿金数量(需要转为18位小数)',
  `ceate_time` datetime DEFAULT NULL COMMENT '生成时间',
  `status` varchar(8) DEFAULT NULL COMMENT 'USABLE:可用，UNUSABLE:不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='矿金表';

-- ----------------------------
-- Table structure for dapp_ore_coin_history
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_coin_history`;
CREATE TABLE `dapp_ore_coin_history` (
  `coin_id` varchar(36) NOT NULL COMMENT '矿金id',
  `create_time` datetime DEFAULT NULL COMMENT '挖取时间',
  PRIMARY KEY (`coin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='矿金挖取历史表';

-- ----------------------------
-- Table structure for dapp_ore_power
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_power`;
CREATE TABLE `dapp_ore_power` (
  `id` varchar(36) NOT NULL,
  `user_open_id` varchar(36) DEFAULT NULL COMMENT '系统用户openid',
  `power_count` varchar(36) DEFAULT NULL COMMENT '算力值',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算力表';

-- ----------------------------
-- Table structure for dapp_ore_power_history
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_power_history`;
CREATE TABLE `dapp_ore_power_history` (
  `id` varchar(36) NOT NULL,
  `power_count` varchar(36) DEFAULT NULL COMMENT '算力值',
  `user_open_id` varchar(36) DEFAULT NULL COMMENT '系统用户openid',
  `history_type` varchar(8) DEFAULT NULL COMMENT '记录来源,TASK:任务',
  `task_id` int(11) DEFAULT NULL COMMENT '任务id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算力历史记录表';

-- ----------------------------
-- Table structure for dapp_ore_power_task
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_power_task`;
CREATE TABLE `dapp_ore_power_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(64) DEFAULT NULL COMMENT '任务名称',
  `task_descr` varchar(128) DEFAULT NULL COMMENT '任务描述',
  `task_power` varchar(36) DEFAULT NULL COMMENT '完成任务添加的算力值',
  `task_count` int(11) DEFAULT NULL COMMENT '任务可完成次数,0为无限次',
  `status` varchar(8) DEFAULT NULL COMMENT 'USABLE:可用，UNUSABLE:不可用',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算力任务表';

-- ----------------------------
-- Table structure for dapp_ore_sys_param
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_sys_param`;
CREATE TABLE `dapp_ore_sys_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(32) DEFAULT NULL COMMENT '参数名',
  `param_value` varchar(32) DEFAULT NULL COMMENT '参数值',
  `param_descr` varchar(128) DEFAULT NULL COMMENT '参数描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数配置表';

-- ----------------------------
-- Table structure for dapp_ore_user_info
-- ----------------------------
DROP TABLE IF EXISTS `dapp_ore_user_info`;
CREATE TABLE `dapp_ore_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_open_id` varchar(36) DEFAULT NULL COMMENT '系统用户openid',
  `invitte_count` int(11) DEFAULT NULL COMMENT '已邀请他人次数',
  `invite_user_id` int(11) DEFAULT NULL COMMENT '邀请人id(邀请码为id转16进制)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='挖矿系统用户表';
