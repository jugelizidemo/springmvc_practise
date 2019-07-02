package com.hxl.controller;

import com.hxl.domain.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

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

    /**
     * 请求转发,一次请求
     * @param
     * @return
     */
    @RequestMapping("/testRequestzf")
    public void testRequestzf(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("testRequestzf" );
        //请求转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        return;
    }


    /**
     * 重定向,两次请求
     * @param
     * @return
     */
    @RequestMapping("/testRedict")
    public void testRedict(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("testRedict");
        response.sendRedirect(request.getContextPath() + "/param/testRequestzf");
        return;
    }

    /**
     * 直接响应
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("testResponse");
        response.getWriter().print("121312313");
    }


    /**
     * ajax
     * 特别注意的是post请求,才能使用@RequestBody注解,url请求数据是封装在body里的
     * get请求,使用Httpservlet.getParame(key)方法可以获得请求参数,请求参数append在url后面
     * @throws Exception
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public  UserInfo testAjax(@RequestBody UserInfo user) throws Exception{
        System.out.println("testAjax :" + user);
        user.setUserName("ttt");
        return user;
    //public void testAjax(HttpServletRequest request) throws Exception{
        //System.out.println("testAjax :" + request.getParameter("userName"));
    }


    /**
     * 传统方式实现文件上传测试
     * @return
     */
    @RequestMapping("/testFileupload")
    public String testFileupload(HttpServletRequest request)throws Exception{
        System.out.println("testFileupload...");
        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);

        if(!file.exists()){
            file.mkdirs();
        }

        //解析request对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for(FileItem item:items){
            //判断当前item对象是否是文件上传项
            if(item.isFormField()){
                //普通表单项目
            }else{
                //上传文件项目
                //获取上传文件名
                String fileName = item.getName();
                //文件名称唯一
                String uuid = UUID.randomUUID().toString();
                fileName = uuid + "_" +fileName;
                //完成文件上传
                item.write(new File(path,fileName));
                //删除临时文件
                item.delete();
            }
        }
        System.out.println("testFileupload success " + path);
        return "success";
    }


    /**
     * springmvc方式实现文件上传测试(springmvc实现了文件的解析,然后将解析后的文件对象返回给服务)
     * @return
     */
    @RequestMapping("/testFileuploadbyspringmvc")
    public String testFileuploadBySpringMVC(HttpServletRequest request, MultipartFile upload)throws Exception{
        System.out.println("testFileuploadbyspringmvc...");
        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);

        if(!file.exists()){
            file.mkdirs();
        }

        //上传文件项目
        //获取上传文件名
        String fileName = upload.getOriginalFilename();
        //文件名称唯一
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + "_" +fileName;
        //完成文件上传
        upload.transferTo(new File(path,fileName));

        System.out.println("testFileuploadbyspringmvc success " + path);
        return "success";
    }


    /**
     * springmvc方式实现夸服务器文件上传测试
     * @return
     */
    @RequestMapping("/testFileuploadoverserver")
    public String testFileuploadOverServer(HttpServletRequest request, MultipartFile upload)throws Exception{
        System.out.println("testFileuploadoverserver...");

        //获取上传文件名
        String fileName = upload.getOriginalFilename();
        //文件名称唯一
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid + "_" +fileName;

        //文件名urlencode编码,防止中文命名的文件导致图片服务器不识别url(浏览器使用搜索时输入中文关键词,
        //浏览器地址栏会自动将中文进行url编码,原理一致)
        fileName = URLEncoder.encode(fileName,"utf8");

        //定义上传文件服务器的路径
        String path = "http://localhost:8090/fileupload/" + fileName;

        //创建客户端对象
        Client client = Client.create();

        //与图片服务器进行连接
        WebResource webResource = client.resource(path);

        //完成文件上传,夸服务器上传
        webResource.put(upload.getBytes());

        System.out.println("testFileuploadoverserver success " + fileName);
        return "success";
    }

}
