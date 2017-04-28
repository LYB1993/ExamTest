<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>找回密码 </title>
    <!-- Bootstrap CSS -->    
    <link href="styles/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="styles/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="styles/elegant-icons-style.css" rel="stylesheet" />
    <link href="styles/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/style-responsive.css" rel="stylesheet" />
</head>

  <body class="login-img3-body">

    <div class="container">
      <form class="login-form" action="findpwd.do">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input name="numcard" type="text" class="form-control" placeholder="身份证号码" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input name="password" type="text" class="form-control" readonly="readonly" style="color: red" value="${returnpwd }">
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">找回密码</button>  
            <button class="btn btn-info btn-lg btn-block"  type="button" onclick="window.location.href='toLogin.do'">返回登陆页</button>       
        </div>
      </form>
    </div>
  </body>
</html>