package com.dapp.server.txmanager.manager.service.impl;

import com.dapp.server.txmanager.Constants;
import com.dapp.server.txmanager.config.ConfigReader;
import com.dapp.server.txmanager.framework.utils.SocketManager;
import com.dapp.server.txmanager.manager.service.MicroService;
import com.dapp.server.txmanager.model.TxServer;
import com.dapp.server.txmanager.model.TxState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by lorne on 2017/11/11
 */
@Service
public class MicroServiceImpl implements MicroService {

    @Value("${spring.cloud.client.ip-address}")
    private String ipAddress;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConfigReader configReader;


    @Autowired
    private DiscoveryClient discoveryClient;



    private boolean isIp(String ipAddress) {
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }


    @Override
    public TxState getState() {
        TxState state = new TxState();
        String ipAddress = "";
        //TODO Spring boot 2.0.0没有discoveryClient.getLocalServiceInstance() 用InetAddress获取host;modify by young
        //String ipAddress = discoveryClient.getLocalServiceInstance().getHost();
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isIp(ipAddress)) {
            ipAddress = "127.0.0.1";
        }
        state.setIp(ipAddress);
        state.setPort(Constants.socketPort);
        state.setMaxConnection(SocketManager.getInstance().getMaxConnection());
        state.setNowConnection(SocketManager.getInstance().getNowConnection());
        state.setRedisSaveMaxTime(configReader.getRedisSaveMaxTime());
        state.setTransactionNettyDelayTime(configReader.getTransactionNettyDelayTime());
        state.setTransactionNettyHeartTime(configReader.getTransactionNettyHeartTime());
        state.setNotifyUrl(configReader.getCompensateNotifyUrl());
        state.setCompensate(configReader.isCompensateAuto());
        state.setCompensateTryTime(configReader.getCompensateTryTime());
        state.setCompensateMaxWaitTime(configReader.getCompensateMaxWaitTime());
        state.setSlbList(getServices());
        return state;
    }


    private List<String> getServices(){
        List<String> urls = new ArrayList<>();
        List<ServiceInstance>  serviceInstances = discoveryClient.getInstances(tmKey);
        for (ServiceInstance instanceInfo : serviceInstances) {
            urls.add(instanceInfo.getUri().toASCIIString());
        }
        return urls;
    }

    @Override
    public TxServer getServer() {
        List<String> urls= getServices();
        List<TxState> states = new ArrayList<>();
        for(String url:urls){
            try {
                TxState state = restTemplate.getForObject(url + "/tx/manager/state", TxState.class);
                states.add(state);
            } catch (Exception e) {
            }

        }
        if(states.size()<=1) {
            TxState state = getState();
            if (state.getMaxConnection() > state.getNowConnection()) {
                return TxServer.format(state);
            } else {
                return null;
            }
        }else{
            //找默认数据
            TxState state = getDefault(states,0);
            if (state == null) {
                //没有满足的默认数据
                return null;
            }
            return TxServer.format(state);
        }
    }

    private TxState getDefault(List<TxState> states, int index) {
        TxState state = states.get(index);
        if (state.getMaxConnection() == state.getNowConnection()) {
            index++;
            if (states.size() - 1 >= index) {
                return getDefault(states, index);
            } else {
                return null;
            }
        } else {
            return state;
        }
    }

}
