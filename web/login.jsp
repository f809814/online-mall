<%--
  Created by Fu.
  Author: fu
  Date: 2018/12/18
  Time: 22:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<form action="login" method="post">
    <input type="hidden" name="method" value="login"/>
    用户名：<input type="text" name="username" value="${form.username }"/><br/>
    密　码：<input type="password" name="password" value="${form.password }"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
