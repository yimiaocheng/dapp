package com.dapp.server.eth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WalletDto 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
	private String addr;
	private String userOpenId;
	private String privateKey;
	private String keystore;
	private String balance;
	private java.util.Date createTime;
	private java.util.Date updateTime;

}