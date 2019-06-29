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
</body>
</html>
