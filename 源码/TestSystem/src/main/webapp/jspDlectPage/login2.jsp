<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>This is Login Page</title>
		<script type="text/javascript">
		//验证账号的格式
		function checkCode() {
			console.log("调用");
			//获取账号
			var code = 
				document.getElementById("code").value;
			//获取span
			var span = 
				document.getElementById("codeMsg");
			//判断账号的格式
			var reg = /^\w{5,10}$/;
			if(reg.test(code)) {
				//正确，颜色变绿
				span.className = "ok";
				return true;
			} else {
				//错误，颜色变红
				span.className = "error";
				return false;
			}
		}
		//验证密码的格式
		function checkPwd() {
			var pwd = 
				document.getElementById("pwd").value;
			var span = 
				document.getElementById("pwdMsg");
			var reg = /^\w{10,20}$/;
			if(reg.test(pwd)) {
				span.className = "ok";
				return true;
			} else {
				span.className = "error";
				return false;
			}
		}
	</script>
	</head>
	<style type="text/css">
		body{
			background:"img/bg2.jpg";
		}
	
		#title{
			
			width: 540px;
			height: 40px;
			float:right;
			margin-top: -126px;
			margin-right: 72px;
			margin-left: 0px;
			margin-bottom: auto;
			padding: 20px;
			font-size: 36px;
			font-style: normal;
			font-weight: 100;
			text-align: center;
			color: #FF7300;
			
		}
		#login{
			width: 300px;
			height: 270px;
			margin-top: 186px;
			margin-right: auto;
			margin-left: auto;
			padding: 10px;
		}
		#display{
			height: 50px;
			width: 230px;
			margin-top: 32px;
			margin-right: auto;
			margin-left: auto;
			margin-bottom: 0;
			padding-top: 0px;
			padding-right: 0px;
			padding-left: 0px;
			padding-bottom: 0px;
			font-size: 36px;
			color: #FF7300;
		}
		.dl{
			height: 30px;
			width: 260px;
			margin-top: 35px;
			margin-left: auto;
			margin-right:auto;
			line-height:25px;
		}
		.btn{
			height: 35px;
			width: 97px;
		}
		.btn input{
			width:100%;
			height:100%;
			background:#FF7300;
		}
		.btn input:hover{
			background:#46FF06;
		}
		#btn1{
			float;left;
			margin-left:20px;
		}
		#btn2{
			margin-top:-37px;
			float: right;
			margin-right:20px;
		}
		.ok {
		color: green;
	}
	.error {
		color: red;
	}
		
	
	</style>
	<body background="images/parallax.png">
		<div class="title" id="title">Vocational examination system</div>
		<div class="login" id="login">
		<form  action="login.do" class="dlup" id="dlup" method="post">
			 <div class="display" id="display">System  Login</div>
			<div class="dl" id="dlu">UserCode;
			 <input name="usercode" onblur="checkCode();" type="text" id="code" autocomplete="on" size="20" maxlength="10" placeholder="username">
			 <span id="codeMsg">5-10位字母、数字、下划线</span>
			</div>
			<div class="dl" id="dlp">PassWord:
			 <input name="password" onblur="checkPwd();" type="password" id="pwd" size="20" maxlength="10" placeholder="username">
			 <span id="pwdMsg">10-20位字母、数字、下划线</span>
			</div>
		</form>	
		<form id="register" action="register.cp" method="post"></form>
		<div class="btn" id="btn1"><input type="submit" value="Login" onclick="document.getElementById('dlup').submit();"></div>
		<div class="btn" id="btn2"><input type="submit" value="Register" onclick="document.getElementById('register').submit();"></div>
		</div>
	</body>
</html>
