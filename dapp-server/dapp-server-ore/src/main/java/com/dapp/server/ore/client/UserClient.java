package com.dapp.server.ore.client;

import com.dapp.server.ore.dto.ResultDTO;
import com.dapp.server.ore.dto.Test;
import com.dapp.server.ore.dto.User;
import com.dapp.server.ore.dto.UserWallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("blockchain-eth-server")
public interface UserClient {

    @RequestMapping(value = "/eth/user/addUserWallet",method = RequestMethod.POST)
    ResultDTO<User<Test>> addUserWallet(@RequestBody UserWallet userWallet);

    @RequestMapping(value = "/eth/user/addUser",method = RequestMethod.GET)
    void addUser();

    @RequestMapping(value = "/eth/user/addWallet",method = RequestMethod.POST)
    void addWallet(@RequestBody User user);
}
