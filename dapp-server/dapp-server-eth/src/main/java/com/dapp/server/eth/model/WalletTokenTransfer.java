package com.dapp.server.eth.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WalletTokenTransfert 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Table(name = "dapp_eth_wallet_token_transfer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletTokenTransfer extends BaseModel {
	@Id
	@Column(name = "hash")
	private String hash;
	@Column(name = "from_addr")
	private String fromeAddr;
	@Column(name = "to_addr")
	private String toAddr;
	@Column(name = "timestamp")
	private java.util.Date timestamp;
	@Column(name = "gas_price")
	private String gasPrice;
	@Column(name = "amount")
	private String amount;
	@Column(name = "descr")
	private String descr;
	@Column(name = "transfer_type")
	private String transferType;
	@Column(name = "status")
	private String status;

}