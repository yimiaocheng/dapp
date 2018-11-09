package com.dapp.server.ore.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CoinHistory 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Table(name = "dapp_ore_coin_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinHistory extends BaseModel {
    @Id
	@Column(name = "coin_id")
	private String coinId;
	@Column(name = "create_time")
	private java.util.Date createTime;

}