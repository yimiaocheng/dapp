package com.dapp.server.ore.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.dapp.server.ore.client.UserClient;
import com.dapp.server.ore.dto.*;
import com.dapp.server.ore.mapper.UserInfoMapper;
import com.dapp.server.ore.model.Power;
import com.dapp.server.ore.model.UserInfo;
import com.dapp.server.ore.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserClient userClient;

    @Override
    @TxTransaction(isStart = true)//开启分布式事务
    @Transactional
    public void addUser(UserInfo userInfo) {

        userInfo.setCreateTime(new Date());
        userInfo.setOpenId(UUID.randomUUID().toString());

        //当前服务
        userInfoMapper.insert(userInfo);

        //调用其他微服务接口
        UserWallet userWallet = new UserWallet();
        userWallet.setUserId(UUID.randomUUID().toString());
        userWallet.setUsername("我们的借口啊");


        WalletInfo wallet = new WalletInfo();
        wallet.setAddr(UUID.randomUUID().toString());
        wallet.setUserOpenId("31232100");
        wallet.setPrivateKey("522222222634ds65d4s654");
        wallet.setKeystore("524135416300");
        wallet.setBalance("21231");
        wallet.setCreateTime(new Date());
        wallet.setUpdateTime(new Date());

        Power power = new Power();
        power.setId("35125434343135435135");
        power.setUserOpenId("5454654");
        power.setPowerCount("41353");
        power.setUpdateTime(new Date());

        wallet.setPower(power);

        userWallet.setWallet(wallet);

        //将对象转化为json字符串
        String json = JSONObject.fromObject(userWallet).toString();

        System.out.println(json);

        ResultDTO<User<Test>> resultDTO = userClient.addUserWallet(userWallet);
        //userClient.addUser();
        System.out.println(resultDTO.getData().getData().getName());

        User user = new User();
        user.setCode("200");
        user.setMsg("3213131");
        user.setData(resultDTO);
        userClient.addWallet(user);


    }
}
