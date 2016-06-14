<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=10,chrome=1">
<meta name="renderer" content="webkit">
<title>登陆</title>
   <title>Login</title>
    <link rel="stylesheet" href="../../static/base/css/bootstrap.min.css" />
	<script type="text/javascript" src="../../static/base/js/login.js"></script>
  </head>

  <body >
		<div style="width:100%;height:100%;position:absolute;z-index:-1;top:0px;">
			<img src="../../static/base/images/backimg1.png" width="100%" height="100%" >
		</div> 
    <div class="container" >

      <form class="form-signin" style="background-color: beige; margin-top: 10%; ">
        <h3 class="form-signin-heading">欢迎来到3D+<small>虚拟现实家装设计平台</small></h3>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="chkRememberPwd" value="remember-me"> 记住我
          </label>
          <label >
            <a href="#"> 忘记密码？</a>
          </label>
        </div>
        <button type="button" class="btn btn-lg btn-primary btn-block" type="submit" onclick="login()">登录</button>
      </form>

    </div>
  </body>
  <script>
    window.onload = function(){
      document.getElementById('inputEmail').focus();GetCookie();
    }

  </script>
</html>
