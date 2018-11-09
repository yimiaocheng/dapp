package com.dapp.server.ore.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * UserInfo 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Table(name = "dapp_ore_user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_open_id")
	private String openId;
	@Column(name = "invitte_count")
	private Integer count;
	@Column(name = "invite_user_id")
	private Integer inviteUserId;
	@Column(name = "create_time")
	private java.util.Date createTime;

}