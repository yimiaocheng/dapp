package com.dapp.server.txmanager.listener.service.impl;

import com.dapp.server.txmanager.Constants;
import com.dapp.server.txmanager.config.ConfigReader;
import com.dapp.server.txmanager.listener.service.InitService;
import com.dapp.server.txmanager.netty.service.NettyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lorne on 2017/7/4.
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private NettyServerService nettyServerService;

    @Autowired
    private ConfigReader configReader;


    @Override
    public void start() {
        /**加载本地服务信息**/

        Constants.socketPort = configReader.getSocketPort();
        Constants.maxConnection = configReader.getSocketMaxConnection();
        nettyServerService.start();
    }

    @Override
    public void close() {
        nettyServerService.close();
    }
}
