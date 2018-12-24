<%--
  Created by Fu.
  Author: fu
  Date: 2018/12/23
  Time: 14:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script>
        function displayAjaxInfo() {
            var xmlhttp;
            if (window.XMLHttpRequest)
            {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
            }
            else
            {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById("dis").innerHTML=xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET","/online-mall/ajax?kind=info",true);
            xmlhttp.send();
        }
        function displayErrorInfo(str) {
            var xmlhttp;
            if (str.length==0)
            {
                document.getElementById("txtHint").innerHTML="";
                return;
            }
            if (window.XMLHttpRequest)
            {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
            }
            else
            {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById("error").innerHTML=xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET","/online-mall/ajax?kind=error&str="+str,true);
            xmlhttp.send();
        }
    </script>
</head>
<body>

    <div id="dis"><h2>初始字符，点击按钮可修改</h2></div>
    <button onclick="displayAjaxInfo()">点击可修改</button>
    <br/>
    输入fu:<input type="text" id="textInput" onmouseleave="displayErrorInfo(this.value)">
    <div id="error"><h3>输入后移出鼠标可看见提示</h3></div>
</body>
</html>
