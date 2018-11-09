package com.dapp.server.ore.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Power 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Table(name = "dapp_ore_power")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Power extends BaseModel {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "user_open_id")
	private String userOpenId;
	@Column(name = "power_count")
	private String powerCount;
	@Column(name = "update_time")
	private java.util.Date updateTime;

}