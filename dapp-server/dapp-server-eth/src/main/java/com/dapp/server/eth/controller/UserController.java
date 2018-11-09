package com.dapp.server.eth.controller;

import com.dapp.server.eth.dto.ResultDTO;
import com.dapp.server.eth.dto.Test;
import com.dapp.server.eth.dto.User;
import com.dapp.server.eth.dto.UserWallet;
import com.dapp.server.eth.service.UserWalletService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eth/user")
public class UserController {

    @Autowired
    private UserWalletService userWalletService;

    @RequestMapping(value = "/addUserWallet")
    @ResponseBody
    public ResultDTO addUserWallet(@RequestBody UserWallet userWallet){
        System.out.println("skldhlsakhdlskahdlk:"+JSONObject.fromObject(userWallet));

        userWalletService.addUserWallet();

        ResultDTO resultDTO = new ResultDTO();
        User<Test> user = new User<Test>();
        Test t = new Test();
        t.setName("test");
        user.setCode("code");
        user.setData(t);
        resultDTO.setCode(200);
        resultDTO.setData(user);

        System.out.println("skldhlsakhdlskahdlk:"+JSONObject.fromObject(resultDTO));

        return resultDTO;
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    @ResponseBody
    public void addUser(){
        //System.out.println(json);
        //将json转出为对象
        //UserWallet userWallet = (UserWallet)JSONObject.toBean(JSONObject.fromObject(json),UserWallet.class);

        userWalletService.addUserWallet();

        //return ResultDTO.requstSuccess();
    }
    @RequestMapping(value = "/addWallet",method = RequestMethod.POST)
    @ResponseBody
    public void addWallet(@RequestBody User user){
        System.out.println(JSONObject.fromObject(user));
        userWalletService.addUserWallet();

        //return ResultDTO.requstSuccess();
    }



}
