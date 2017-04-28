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
    <title>考试题目组合</title>
    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />    
    <!-- full calendar css-->
    <link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
    <!-- easy pie chart-->
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- owl carousel -->
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
	<link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
	<link rel="stylesheet" href="css/fullcalendar.css">
	<link href="css/widgets.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
	<link href="css/xcharts.min.css" rel=" stylesheet">	
	<link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
  </head>

  <body>
  <!-- container section start -->
  <section id="container" class="">
      <header class="header dark-bg">
            <!--logo start-->
            <a href="index.html" class="logo">考试 系统 <span class="lite"> ${user.userIdentity  }</span></a>
            <!--logo end-->
            <div class="top-nav notification-row">                
                <!-- person start-->
           		<c:import url="person.jsp"></c:import>
                <!-- person end-->
            </div>
      </header>      
      <!--header end-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- menu start-->
               <c:import url="menu.jsp"></c:import>
              <!-- menu end-->
          </div>
      </aside>
      <!--main start-->
      <section id="main-content">
      		<section class="wrapper">           	
      		<div class="col-lg-12">
		  	 	<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toChoiceType.do">考试模式</a></li>
		  	 		<li><i class="fa fa-file-text-o"></i><a href="toAllScore.do">配置</a></li>
		  	 	</ol>
		  	 </div>
				 <div class="panel-body">
                  <div class="padd col-lg-8">
                      <div class="form quick-post">
                           <!-- 题目模式-->
                           <form class="form-horizontal" action="toExamType.do" method="get">                          
                               <!-- 题目模式1 -->
                               <div class="form-group">
                                   <label class="control-label col-lg-2">题目数量</label>
                                   <div class="col-lg-10">                               
                                       <select class="form-control" name="num">
                                          <option value="">- 选择数量 -</option>
                                          <option value="5">5</option>
                                          <option value="10">10</option>
                                          <option value="15">15</option>
                                          <option value="20">20</option>
                                       </select>  
                                     </div>
                                </div> 
                                 <!-- 题目模式2 -->
                                 <div class="form-group">
                                   <label class="control-label col-lg-2">题目类型</label>
                                   <div class="col-lg-10">                               
                                       <select class="form-control" name="belong">
                                          <option value="">- 选择类型 -</option>
                                          <c:forEach items="${belong }" var="bl">
                                          <option value="${bl }">${bl }</option>
                                          </c:forEach>
                                       </select>  
                                     </div>
                                </div> 
                                 <!-- 题目模式3 -->
                                 <div class="form-group">
                                   <label class="control-label col-lg-2">题目难度</label>
                                   <div class="col-lg-10">                               
                                       <select class="form-control" name="dif">
                                          <option value="">- 选择难度 -</option>
                                          <option value="简单">简单</option>
                                          <option value="一般">一般</option>
                                          <option value="困难">困难</option>
                                          <option value="极难">极难</option>
                                       </select>  
                                     </div>
                                </div>                        
                                <!-- Buttons -->
                                <div class="form-group">
                                <!-- Buttons -->
									<div class="col-lg-offset-2 col-lg-9" style="padding-left: 250px;">
										<button type="submit" class="btn btn-danger">开始考试</button>
										<button type="reset" class="btn btn-default">清 &ensp;&ensp;除</button>
									</div>
                                </div>
                          </form>
                       </div>
                  </div>
                  <div class="widget-foot">
                    <!-- Footer goes here -->
                  </div>
                </div> 
              <!-- project team & activity end -->
        	</section>
        </section>
      <!--main content end-->
  </section>
  <!-- container section start -->
    <!-- javascripts -->
    <script src="js/jquery.js"></script>
	<script src="js/jquery-ui-1.10.4.min.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
    <!-- bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- nice scroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- charts scripts -->
    <script src="assets/jquery-knob/js/jquery.knob.js"></script>
    <script src="js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="js/owl.carousel.js" ></script>
    <!-- jQuery full calendar -->
    <<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="js/calendar-custom.js"></script>
	<script src="js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="js/jquery.customSelect.min.js" ></script>
	<script src="assets/chart-master/Chart.js"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="js/sparkline-chart.js"></script>
    <script src="js/easy-pie-chart.js"></script>
	<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="js/xcharts.min.js"></script>
	<script src="js/jquery.autosize.min.js"></script>
	<script src="js/jquery.placeholder.min.js"></script>
	<script src="js/gdp-data.js"></script>	
	<script src="js/morris.min.js"></script>
	<script src="js/sparklines.js"></script>	
	<script src="js/charts.js"></script>
	<script src="js/jquery.slimscroll.min.js"></script>
 	<script> 
		$(function(){
			if($("input:hidden[name='identity']").val()=="STU"){
			}else{
				$(".sub-menu2").removeClass("sub-menu2");
			}
		}); 
  	</script>
  </body>
</html>
