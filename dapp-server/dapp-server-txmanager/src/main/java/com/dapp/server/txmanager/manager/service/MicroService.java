package com.dapp.server.txmanager.manager.service;

import com.dapp.server.txmanager.model.TxServer;
import com.dapp.server.txmanager.model.TxState;

/**
 * create by lorne on 2017/11/11
 */
public interface MicroService {

    String  tmKey = "tx-manager";

    TxServer getServer();

    TxState getState();
}
