package com.dapp.server.eth.mapper;

import com.dapp.server.eth.model.WalletTransfer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * WalletTransferMapper 数据访问类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Repository
public interface WalletTransferMapper extends Mapper<WalletTransfer> {
}