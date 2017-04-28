<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
   <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="application-name" content="reg.163.com">
    <title>用户中心</title>
    <link rel="canonical" href="http://reg.163.com">
    <link rel="stylesheet" type="text/css" href="../resources/reg_urs/css/index.css?regVersion=1481531786347">
<!-- @NOPARSE -->
    <script type="text/javascript">
      var userAgent = navigator.userAgent.toLowerCase();
      var msie = /msie/.test( userAgent ) && !/opera/.test( userAgent );
      var version = (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [0,'0'])[1];
      var _test = {6:'2.0',7:'3.0',8:'4.0',9:'5.0',10:'6.0',11:'7.0'};
      var release = _test[document.documentMode]||_test[parseInt(version)];
      if (msie && parseInt(release,10)<4){
        location.href = "http://urscdn.nosdn.127.net/reg/ieUpdate01.html";
      }
    //验证账号的格式
		function checkCode() {
			console.log("调用");
			//获取账号
			var code = 
				document.getElementById("inpt-account").value;
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
				document.getElementById("inpt-pw").value;
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
    <script type="text/javascript">
    </script>
    <!-- /@NOPARSE -->
<style type="text/css">.auto-1482041036105-parent{position:relative;} .auto-1482041036105{position:absolute;border:1px solid #aaa;background:#fff;text-align:left;visibility:hidden;} .auto-1482041036105 .zitm{height:20px;line-height:20px;cursor:default;} .auto-1482041036105 .js-selected{background:#1257F9;}</style>
<style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_kcuuxxyze2hjjor.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_kcuuxxyze2hjjor.ttf) format('truetype')}</style>
<link id="Ecaptcha_2.0" rel="stylesheet" type="text/css" href="https://captcha.reg.163.com/v2/css/Ecaptcha_2.0.css?v=6xpfaxg03s8vr7e97ldi" media="all">

<link href="styles/regis.css" rel="stylesheet" type="text/css" media="screen">
</head>
<body>
<input id="hid_pkid" type="hidden" value="CvvJSJE">
<input id="hid_pkht" type="hidden" value="study.163.com">
<input id="hid_pd" type="hidden" value="study">
<div id="tost-b"><!--Regular list--></div>

  <div class="g-hd">
  	
  </div>
  <div id="reg_block" class="g-bd">

  <div class="top_tlt">注册帐号</div>

<!--Regular if0-->
<div class="m-opr clearfix">
    <form id="bind-phone-form" class="" autocomplete="off" action="registersun.do">
        <div class="u-input firstelem">
            <label for="inpt-account" class="u-label">帐号：</label>
            <input type="text" name="userCode" id="inpt-account" placeholder="输入账户名称" class="i-inpt"><div class="auto-1482041036105 m-sug" id="auto-id-1482041036107" style="visibility: hidden;"></div>
            <input type="text" name="username" style="display: none;">
            <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036123"></div></div>
            <!--Regular if1-->
            <!--Regular if2--><!--Regular if3--><!--Regular if4-->
        </div>
        <div class="u-input">
            <label for="inpt-pw" class="u-label">密码：</label>
            <input type="password" name="password" style="display: none;">
            <input type="password" name="pwd" id="inpt-pw" placeholder="6-16位密码，区分大小写" class="i-inpt ">
            <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036124"></div></div>
            <!--Regular if5--><!--Regular if6-->
        </div>
      <div class="u-input">
            <label for="inpt-pw2" class="u-label">确认密码：</label>
            <input type="password" name="pwd2" id="inpt-pw2" placeholder="再次输入密码" class="i-inpt ">
            <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036125"></div></div>
            <!--Regular if7--><!--Regular if8-->
      </div>
        <!--Regular if9-->
      <div class="u-tip f-dn" style="display: none !important;"><div class="spritebg u-clear" id="auto-id-1482041036126"></div></div>
            <!--Regular if10-->
        
      <div class="u-input j-phone-box">
            <label for="inpt-phone" class="u-label">手机号：</label>
            <input type="text" name="phone" id="inpt-phone" placeholder="11位手机号" maxlength="20" class="i-inpt ">
            <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036127"></div></div>
            <!--Regular if12--><!--Regular if13-->
      </div>
      
          <div class="u-input">
                <label class="u-label">姓名：</label>
                <input type="text" name="name" id="inpt-username" placeholder="请输入姓名" class="i-inpt">
                <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036130"></div></div>
                <!--Regular if20--><!--Regular if21-->
        </div>

            <div class="u-input">
                <label class="u-label">身份证：</label>
                <input type="text" name="idcard" id="inpt-idcard" placeholder="请输入身份证" class="i-inpt">
                <div class="u-tip f-dn"><div class="spritebg u-clear" id="auto-id-1482041036131"></div></div>
                <!--Regular if22--><!--Regular if23-->
            </div>
      
 </form>
        <div class="u-input" style="height: 58px;">
            <label class="u-label">&nbsp;</label>
			<div class="b-btn btn-reg btn-red btndisabled" id="addnewuser"><input type="submit" value="注&nbsp;&nbsp;册" onclick="document.getElementById('bind-phone-form').submit();"></div>
            <!--Regular if24-->
        </div>

      

   
    <!--Regular if25-->
</div>
<!--Regular if26-->
</div>
  <div class="g-ft">
    <div class="g-in">
      <div class="m-cp">
        <p>版权所有 ©2016-2016</p>
      </div>
    </div><!---->
  </div>

<!-- @NOPARSE -->


<!-- /@NOPARSE -->
<!-- DEFINE -->
<script src="../resources/lib/nej/src/define.js?pro=../resources/reg_urs/js/"></script><a href="https://zc.reg.163.com/resources/lib/js/gaq.js" style="display: none;"></a>
<script src="../resources/reg_urs/out/s/pp_reg.js?regVersion=1481531786347"></script>

</body>
</html><!---->
