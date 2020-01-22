<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/26/2019
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>

<script>
    function deleteRow(id) {
        if (confirm("are you sure?"))
            window.location = "/delete.do?id=" + id;
    }
</script>

<form action="/save.do">
  <input type="text" name="id"/>
  <input type="text" name="name"/>
  <input type="text" name="family"/>
  <input type="submit"/>
</form>
<table border="0" style="width: 100%">
  <tr>
    <td>ID</td>
    <td>NAME</td>
    <td>FAMILY</td>
    <td>password</td>
    <td>DELETE</td>
    <td>UPDATE</td>
  </tr>
  <script:forEach items="${requestScope.list}" var="p">
    <tr>
      <form action="/update.do">
        <td><input style="width: 100%" type="text" name="id" value="${p.id}" readonly></td>
        <td><input style="width: 100%" type="text" name="name" value="${p.name}"></td>
        <td><input style="width: 100%" type="text" name="family" value="${p.lastname}"></td>
        <td><input style="width: 100%" type="password" name="password" value="${p.password}"></td>
        <td><input style="width: 100%" type="button" value="delete" onclick="deleteRow(${p.id})"></td>
        <td><input style="width: 100%" type="submit" value="update"></td>
      </form>
    </tr>
  </script:forEach>
</table>

</body>

</html>
--%>


<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
    <title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Sign In :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script src="jquery-3.4.1.min.js"></script>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->

    <link href="static/css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="static/css/style.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="static/css/morris.css" type="text/css"/>
    <!-- Graph CSS -->
    <link href="static/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/jquery-ui.css">
    <!-- jQuery -->
    <script src="static/js/jquery-2.1.4.min.js"></script>
    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet'
          type='text/css'/>
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href="static/css/icon-font.min.css" type='text/css'/>
    <!-- //lined-icons -->
</head>
<body>
<div class="main-wthree">
    <div class="container">
        <div class="sin-w3-agile">
            <h2>Sign In</h2>
            <form>
                <div class="username">
                    <span class="username">Username:</span>
                    <input type="text" id="username" class="name" placeholder="" required="">
                    <div class="clearfix"></div>
                </div>
                <div class="password-agileits">
                    <span class="username">Password:</span>
                    <input type="password" id="password" class="password" placeholder="" required="">
                    <div class="clearfix"></div>
                </div>
                <div class="rem-for-agile">
                    <input type="checkbox" name="remember" class="remember">Remember me<br>
                    <a href="#">Forgot Password</a><br>
                </div>
                <div id="login_div" class="login-w3">
                    <button id="btnlogIn" class="login">sign in</button>
                </div>
                <div class="clearfix"></div>
            </form>
            <div class="back">
                <a href="static\indexx.html">Back to home</a>
            </div>
            <div class="footer">
                <p>&copy; 2016 Pooled . All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
            </div>
        </div>
    </div>
</div>

<script>

    $(function () {
        $("#btnlogIn").click(function () {
            $.ajax({
                url: "/check.do",
                type: 'GET',
                data: "username=" + $("#username").val() + "&password=" + $("#password").val(),
                success: function (result) {
                    console.log(result);
                    if (result.res == "1") {
                        window.location = "static/indexx.html";


                    } else {
                        alert("wrong user name or password");
                    }
                },
            });

        });
    });


</script>
</body>
</html>