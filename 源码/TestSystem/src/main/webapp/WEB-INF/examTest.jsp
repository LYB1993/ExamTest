<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>考试界面</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
  </head>
  <body>

  <!-- container section start -->
  <section id="container" class="">
      <!--header start-->
      <header class="header dark-bg">
            <!--logo start-->
            <input id="examTime" type="hidden" value=${examTime }>
            <input id="examSum" type="hidden" value=${examSum }>
            <a href="index.html" class="logo">考试 系统 <span class="lite"></span></a>
            <!--logo end-->
                 <div class="nav search-row" id="top_menu">
                <!--  Time start -->
                <ul class="nav top-menu">                    
                    <li>
                       <canvas id="canvas"></canvas>
                    </li>                    
                </ul>               
            </div>
   
            <div class="nav search-row" id="top_menu"></div>
            <div class="top-nav notification-row">                
                <!-- person start-->
                <c:import url="person.jsp"></c:import>
                <!-- person end-->
            </div>
      </header>      
      <!--header end-->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- menu start-->
              <c:import url="menu.jsp"></c:import>
              <!-- menu end-->
          </div>
      </aside>
      <!--sidebar end-->

      <!--main content start-->
      <section id="main-content-score">
          <section class="wrapper">             
              <div class="row">
                  <div class="col-lg-6">
                      <!--notification start-->
                      <form class="form-validate form-horizontal" id="feedback_form" method="get" action="toAnswer.do">    
                   <section class="panel">
                      <header class="panel-heading">
                          <strong id="sub"></strong><!-- 这里显示题目 -->
                      </header>
                          <div class="panel-body">
                            <div class="alert alert-success fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input id = "radio1" type=radio value="A">
                                  <strong id="QA"></strong><!-- 这里显示A选项 -->
                            </div>      
                              <div class="alert alert-block alert-danger fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input id = "radio2" type=radio  value="B">
                                  <strong id="QB"></strong><!-- 这里显示B选项 -->
                              </div>                              
                              <div class="alert alert-info fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input id = "radio3" type=radio value="C">
                                  <strong id="QC"></strong> <!-- 这里显示C选项 -->
                              </div>
                              <div class="alert alert-warning fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input id = "radio4" type=radio value="D">
                                  <strong id="QD"></strong> <!-- 这里显示D选项 -->
                              </div>
                              <strong id="examnum"></strong>
                          </div> 
                          <div class="form-group">
                             <div class="col-lg-offset-2 col-lg-10"> 
                                  <input class="btn btn-primary" id="returnNextone" type="button" onclick="returnnextone();" value="上一题">
                                 <input class="btn btn-primary" id="nextOne"  type="button" onclick="nextone();" value="下一题">
                                 <input class="btn btn-primary" id="endExam"  type="button" onclick="window.location.href='toSumitAnser.do'" value="提交">  
                             </div>
                          </div> 
                      </section>
                     </form>
                     </div>
              </div>
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section end -->
    <!-- javascripts -->
    <script type="text/javascript" src="js/digit.js"></script>
	<script type="text/javascript" src="js/control.js"></script>
	<script type="text/javascript" src="js/examajax.js"></script>
	
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- nice scroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- custom gritter script for this page only-->
    <script src="js/gritter.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
    <script type="text/javascript">
		$(function(){
			if($("input:hidden[name='identity']").val()=="STU"){
				
			}else{
				$(".sub-menu2").removeClass("sub-menu2");
			}
		});
		$(document).mouseleave(function() {
			alert("请注意");
		});
		$("#returnNextone").attr("disabled",false);
		$("#nextOne").attr("disabled",false);
		
    </script>
</body>
</html>
