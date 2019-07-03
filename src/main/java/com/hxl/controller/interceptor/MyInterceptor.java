package com.hxl.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * Created by admin on 2019/7/3.
 */
public class MyInterceptor implements HandlerInterceptor{


    /**
     * 预处理,在controller方法执行前
     * return true:放行,执行下一个拦截器,如果没有下一个拦截器,则执行controller中的方法
     * return false:不放行,直接执行拦截器中的内容,不在执行controller中的方法
     *
     * @param var1
     * @param var2
     * @param var3
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3) throws Exception{

        System.out.println("MyInterceptor拦截器预处理执行了...");

        return false;
    }

    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{

        System.out.println("MyInterceptor拦截器正在执行...");
    }

    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{

    }
}
