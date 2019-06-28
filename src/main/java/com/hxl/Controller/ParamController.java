package com.hxl.controller;

import com.hxl.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2019/6/28.
 */
@Controller
@RequestMapping("param")
public class ParamController {

    /**
     * 请求参数绑定
     */
    @RequestMapping("/testparam")
    public String testParam(String key){
        System.out.println("执行了" + key);
        return "success";
    }

    /**
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(UserInfo userInfo){
        System.out.println("执行了" + userInfo);
        return "success";
    }
}
