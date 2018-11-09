package com.dapp.server.txmanager.api.service.impl;


import com.dapp.server.txmanager.api.service.ApiTxManagerService;
import com.dapp.server.txmanager.compensate.model.TransactionCompensateMsg;
import com.dapp.server.txmanager.compensate.service.CompensateService;
import com.dapp.server.txmanager.config.ConfigReader;
import com.dapp.server.txmanager.manager.service.MicroService;
import com.dapp.server.txmanager.manager.service.TxManagerSenderService;
import com.dapp.server.txmanager.manager.service.TxManagerService;
import com.dapp.server.txmanager.model.TxServer;
import com.dapp.server.txmanager.model.TxState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/7/1.
 */
@Service
public class ApiTxManagerServiceImpl implements ApiTxManagerService {


    @Autowired
    private TxManagerService managerService;

    @Autowired
    private MicroService eurekaService;

    @Autowired
    private CompensateService compensateService;


    @Autowired
    private TxManagerSenderService txManagerSenderService;

    @Autowired
    private ConfigReader configReader;


    @Override
    public TxServer getServer() {
        return eurekaService.getServer();
    }


    @Override
    public int cleanNotifyTransaction(String groupId, String taskId) {
        return managerService.cleanNotifyTransaction(groupId,taskId);
    }


    @Override
    public boolean sendCompensateMsg(long currentTime, String groupId, String model, String address, String uniqueKey, String className, String methodStr, String data, int time,int startError) {
        TransactionCompensateMsg transactionCompensateMsg = new TransactionCompensateMsg(currentTime, groupId, model, address, uniqueKey, className, methodStr, data, time, 0,startError);
        return compensateService.saveCompensateMsg(transactionCompensateMsg);
    }

    @Override
    public String sendMsg(String model,String msg) {
        return txManagerSenderService.sendMsg(model, msg, configReader.getTransactionNettyDelayTime());
    }


    @Override
    public TxState getState() {
        return eurekaService.getState();
    }
}
