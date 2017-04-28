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

    <title>考试系统登陆 </title>
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
    <script type="text/javascript">
    	function signup() {
			location.href="register.cp";
		}
    
    </script>
</head>

  <body class="login-img3-body">

    <div class="container">

      <form class="login-form" action="login.do">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
           
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input name="usercode" type="text" class="form-control" placeholder="Username" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input name="password" type="password" class="form-control" placeholder="Password">
            </div>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> 记住密码
                <span class="pull-right" style="font-size:15px;color:red;">${UP }</span>
                <span class="pull-right"><a href="toFindpwd.do">忘记密码</a></span>
            </label>
            <button class="btn btn-primary btn-lg btn-block" type="submit">登陆</button>  
            <button class="btn btn-info btn-lg btn-block"  type="button" onclick="window.location.href='toregister.do'">注册</button> 
        </div>
      </form>
    </div>
  </body>
</html>
