package com.hxl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2019/6/26.
 */

@Controller
public class TestController {

    @RequestMapping(path="/hello",method ={RequestMethod.GET},params = {"key"})
    public String sayHello(){
        System.out.println("试一下!");
        return "success";
    }
}
