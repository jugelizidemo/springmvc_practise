package com.hxl.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2019/6/26.
 */

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("第一个程序!");
        return "success";
    }
}
