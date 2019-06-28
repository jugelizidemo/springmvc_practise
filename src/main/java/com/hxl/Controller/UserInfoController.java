package com.hxl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@Controller
@RestController
@RequestMapping(value = "/userInfo")
@Api(value = "用户信息", description = "用户信息")
public class UserInfoController {


    @ResponseBody
    @RequestMapping(value = "/selectAllUsers", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的人员信息并分页展示", notes = "查询所有的人员信息并分页展示")
    public void selectAllUsers() {

    }

}


