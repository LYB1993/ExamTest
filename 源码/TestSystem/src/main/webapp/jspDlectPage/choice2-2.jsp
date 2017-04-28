<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ProFinal</title>
<link href="styles/choicequest.css" rel="stylesheet" type="text/css">
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

<body>
<div class="header">
  <div class="container"> <img >
    <h1 class="htitle">试题</h1>
  </div>
</div>
<div class="exam-cont">
  <ul class="exam-box">
    <li>
      <h2 class="ex-title">Welcome</h2>
    </li>
    <form id="choice" action="toExamTest.do">
    <li class="ex-sel"> 
     <p>
      <select name="choice" class="form-control">
		
			<option value="">- 选择课程方向 -</option>
            <option value="english">English</option>
            <option value="Art">Art</option>
            <option value="History">History</option>
            <option value="History">History</option>
         	</select></p>
      
      <div class="iscroll-ar isa1 mCustomScrollbar _mCS_1">
        <div id="mCSB_1" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0">
          <div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">	
         	
          </div>
          <div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: block;">
            <div class="mCSB_draggerContainer">
              <div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; display: block; height: 0px; top: 0px; max-height: 25px;" oncontextmenu="return false;">
                <div class="mCSB_dragger_bar" style="line-height: 30px;"></div>
              </div>
              <div class="mCSB_draggerRail"></div>
            </div>
          </div>
        </div>
      </div>
    </li>
    </form>
    <li class="ex-sel li-hid">
      <p>
      <select name="choice" class="form-control">
		<option selected="Choice">选择课程阶段</option>
			<option value="english">English</option>
			<option value="Art">Art</option>
			<option value="History">History</option>
         	</select></p>
      <div class="iscroll-ar isa2">
        <ul id="exStage" class="ex-sel-cont">
          <!-- <li>请选择上一项</li> -->
        </ul>
      </div>
    </li>
    <li id="tsli" class="ex-sel li-hid">
      <p>
      <select name="choice" class="form-control">
		<option selected="Choice">选择课程要点</option>
			<option value="english">English</option>
			<option value="Art">Art</option>
			<option value="History">History</option>
         	</select>
      </p>
      <div class="iscroll-ar isa3">
        <ul id="exKnow" class="ex-sel-cont">
          <!-- <li>请选择上一项</li> -->
        </ul>
      </div>
    </li>
    
    <li>
      <button id="ex-enter" class="ex-enter" onclick="document.getElementById('choice').submit();">开始考试</button>
    </li>
  </ul>
</div>
</body>
</html>
