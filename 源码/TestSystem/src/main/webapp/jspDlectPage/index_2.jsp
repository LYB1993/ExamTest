<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>This is IndexPage</title>
  <style type="text/css">
body {
	background-image: url(img/parallax.png);
}
#index {
	height: 400px;
	width: 800px;
	margin: 180px;
}
.inx{
	float: left;
	height: 75px;
	margin-top: 24px;
	width: 150px;
	margin-left: 25px;
	margin-right: 25px;
	cursor: pointer;
}
  .img:hover{
		  width:200px;
		  height:180px;
		  
	  }
	 
  </style>
  </head>
    
  <body style="">
  <div><p>${user.userName}</p></div>
  <div class="main" id="index">
    <div class="inx" id="info"><a href="toPersonalInformation.do"><img class="img" src="img/pro.jpg" alt="" width="163" height="143" id="person"/></a></div>
    <div class="inx" id="score"><a href="toSlelctScore.do"><img class="img" src="img/sele.jpg" alt="" width="163" height="143" id="select"/></a></div>
    <div class="inx" id="test"><a href="toChoice.do"><img class="img" src="img/chonice.jpg" alt="" width="163" height="143" id="examtest"/></a></div>
    <div class="inx" id="infor"><a href="toAbout.do"><img class="img" src="img/about.jpg" alt="" width="163" height="143" id="about"/></a></div>
  </div>
  </body>
</html>