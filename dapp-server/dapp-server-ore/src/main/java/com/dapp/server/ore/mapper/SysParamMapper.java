package com.dapp.server.ore.mapper;

import com.dapp.server.ore.model.SysParam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * SysParamMapper 数据访问类
 *
 * @version 1.0
 * @date 2018-11-05 15:09:43
 */
@Repository
public interface SysParamMapper extends Mapper<SysParam> {
}