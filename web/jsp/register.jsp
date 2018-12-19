<%--
  Created by fu.
  Author: Fu
  Date: 2018/12/19
  Time: 15:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎注册</title>
    <style>
        .form_div
        {
            text-align: center;
            background-color: rgba(29, 240, 255, 0.72);
            border-radius: 20px;
            border-bottom-color: aqua;
            width: 800px;
            height: 150px;
            margin: auto;
            padding:25px 50px;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
</head>
<body>
    <div class="form_div">
        <form action="/online-mall/register" method="post">
            <input type="hidden" name="method" value="register"/>
            <span style="color: red; font-weight: 900">${errors.username }</span><br/>
            用户名：<input type="text" name="username" value="${form.username }" required="required"/><br/>
            密　码：<input type="password" name="password" value="${form.password }" required="required"/><br/>
            <input type="submit" value="注册"/>
        </form>
    </div>
</body>
</html>
