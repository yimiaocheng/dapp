package com.dapp.server.ore.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * PowerTask 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Table(name = "dapp_ore_power_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerTask extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "task_descr")
	private String taskDescr;
	@Column(name = "task_power")
	private String taskPower;
	@Column(name = "task_count")
	private Integer taskCount;
	@Column(name = "status")
	private String status;
	@Column(name = "update_time")
	private java.util.Date updateTime;

}