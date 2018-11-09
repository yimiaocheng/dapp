package com.dapp.server.eth.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wallet 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Table(name = "dapp_eth_wallet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet extends BaseModel {
	@Id
	@Column(name = "addr")
	private String addr;
	@Column(name = "user_open_id")
	private String userOpenId;
	@Column(name = "private_key")
	private String privateKey;
	@Column(name = "keystore")
	private String keystore;
	@Column(name = "balance")
	private String balance;
	@Column(name = "create_time")
	private java.util.Date createTime;
	@Column(name = "update_time")
	private java.util.Date updateTime;
}