package com.dapp.server.eth.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WalletToken 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Table(name = "dapp_eth_wallet_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletToken extends BaseModel {
	@Id
	@Column(name = "addr")
	private String addr;
	@Column(name = "token_addr")
	private String tokenAddr;
	@Column(name = "token_name")
	private String tokenName;
	@Column(name = "token_balance")
	private String tokenBalance;
	@Column(name = "token_decimals")
	private int tokenDecimals;
	@Column(name = "update_time")
	private java.util.Date updateTime;

}