package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserInfoDto 数据传输类
 *
 * @version 1.0
 * @date 2018-11-05 15:09:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private Integer id;
    private String openId;
    private Integer inviteUserId;
    private java.util.Date createTime;

}