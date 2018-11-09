package com.dapp.server.eth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WalletTokenTransfertDto 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletTokenTransfertDto {
	private String hash;
	private String fromAddr;
	private String toAddr;
	private java.util.Date timestamp;
	private String gasPrice;
	private String amount;
	private String descr;
	private String transferType;
	private String status;

}