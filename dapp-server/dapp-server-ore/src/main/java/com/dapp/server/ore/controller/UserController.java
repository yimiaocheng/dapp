package com.dapp.server.ore.controller;

import com.dapp.server.ore.dto.ResultDTO;
import com.dapp.server.ore.model.UserInfo;
import com.dapp.server.ore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ore/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/addUser")
    @ResponseBody
    public ResultDTO addUser(@RequestBody UserInfo userInfo){
        userService.addUser(userInfo);
        return ResultDTO.requstSuccess();
    }
}
