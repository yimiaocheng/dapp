package com.dapp.server.market.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dapp_currency_pair")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPair extends BaseModel {

	@Id
	@Column(name = "currency_pair")
	private String currencyPair;
	@Column(name = "status")
	private String status;

}