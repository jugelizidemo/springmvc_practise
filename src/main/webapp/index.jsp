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
    <h3>入门程序</h3>
    <%-- <a href="hello?key=1">入门程序</a>--%>
    <%--  <a href="param/testparam?key=hehehe">请求参数绑定</a>--%>

    <form action="param/saveAccount" method="post">
        姓名: <input type="text" name="userName"/><br/>
        密码: <input type="text" name="password"/><br/>
        金额: <input type="text" name="money"/><br/>
        日期: <input type="text" name="date"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
