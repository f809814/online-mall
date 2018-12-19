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
    <style>
        .form_login
        {
            text-align: center;
            background-color: rgba(29, 240, 255, 0.72);
            border-radius: 20px;
            border-bottom-color: aqua;
            width: 800px;
            height: 150px;
            margin: auto;
            padding:50px 50px;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
</head>
<body>
    <div class="form_login">
        <form action="/online-mall/login" method="post">
            <input type="hidden" name="method" value="login"/>
            用户名：<input type="text" name="username" value="${form.username }" required="required"/><br/>
            密　码：<input type="password" name="password" value="${form.password }" required="required"/><br/>
            <input type="submit" value="登录"/>
        </form>
        <form action="/online-mall/jsp/register.jsp" method="post">
            <input type="submit" value="去注册"/>
            <input type="hidden" name="method" value="register"/>
        </form>
    </div>
</body>
</html>
