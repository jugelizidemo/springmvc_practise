package com.hxl.controller;

import com.hxl.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    /**
     * 测试远程的servletApi
     * @param req
     * @param res
     * @param session
     * @return
     */
    @RequestMapping("/testservletapi")
    public String testServletApi(HttpServletRequest req, HttpServletResponse res, HttpSession session){
        System.out.println("HttpServletRequest" + req);
        System.out.println("HttpServletResponse" + res);
        System.out.println("HttpSession" + session);
        return "success";
    }

    /**
     *测试pathVariable

     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable( @PathVariable("id") String id){
        System.out.println("pathVariable:" + id);
        return "success";
    }


    @RequestMapping("/testRequestHeader")
    public String testRequestHeader( @RequestHeader("Accept") String header){
        System.out.println("RequestHeader:" + header);
        return "success";
    }


    @RequestMapping("/testCookie")
    public String testCookieValue( @CookieValue("JSESSIONID")  String cookieValue){
        System.out.println("CookieValue:" + cookieValue);
        return "success";
    }
}
