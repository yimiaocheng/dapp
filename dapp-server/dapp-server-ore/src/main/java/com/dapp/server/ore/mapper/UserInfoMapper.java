package com.dapp.server.ore.mapper;

import com.dapp.server.ore.model.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * UserInfoMapper 数据访问类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}