package com.dapp.server.market.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dapp_currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends BaseModel {

	@Id
	@Column(name = "currency_name")
	private String currencyName;
	@Column(name = "currency_name_cn")
	private String currencyNameCn;
	@Column(name = "status")
	private String status;

}