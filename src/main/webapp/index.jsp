<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/6/26
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <Script src = "/js/jquery-3.4.1.min.js"></Script>

    <script>
        $(function(){
            $("#btn").click(function(){
                //alert("jquery...");
                $.ajax({
                    url:"param/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"userName":"hhh","password":"12334","money":"99999"}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        alert(data.userName);
                    }
                });
            });
        });

    </script>
</head>
<body>
    <h3>测试程序</h3>

    <hr>

    <a href="hello?key=1">测试程序</a>

    <hr>

    <a href="param/testparam?key=hehehe">请求参数绑定</a>

    <hr>

    <form action="param/saveAccount" method="post">
        姓名: <input type="text" name="userName"/><br/>
        密码: <input type="text" name="password"/><br/>
        金额: <input type="text" name="money"/><br/>
        日期: <input type="text" name="date"/><br/>
        <input type="submit" value="提交"/>
    </form>

    <hr>

    <a href="param/testservletapi">原生servletAPI测试</a>

    <hr>

    <a href="param/testPathVariable/999">PathVariable测试</a>

    <hr>

    <a href="param/testRequestHeader">requestHeader测试</a>

    <hr>

    <a href="param/testCookie">CookieValue测试</a>

    <hr>

    <a href="param/testRequestzf">请求转发测试</a>

    <hr>

    <a href="param/testRedict">重定向测试</a>

    <hr>

    <a href="param/testResponse">直接响应测试</a>

    <hr>

    <button id="btn">发送ajax请求</button>

    <hr>

   <form action ="param/testFileupload" method="post" enctype="multipart/form-data">
       (传统方式)选择文件:<input type="file" name ="upload" value="选择文件"/><br/>
       <input type="submit" value="上传" />
   </form>

    <hr>

    <form action ="param/testFileuploadbyspringmvc" method="post" enctype="multipart/form-data">
        (springmvc)选择文件:<input type="file" name ="upload" value="选择文件"/><br/>
        <input type="submit" value="上传" />
    </form>


    <hr>

    <form action ="param/testFileuploadoverserver" method="post" enctype="multipart/form-data">
        (跨服务器文件上传)选择文件:<input type="file" name ="upload" value="选择文件"/><br/>
        <input type="submit" value="上传" />
    </form>


    <hr>

    <a href="param/testInterceptor">拦截器测试</a>

</body>
</html>
