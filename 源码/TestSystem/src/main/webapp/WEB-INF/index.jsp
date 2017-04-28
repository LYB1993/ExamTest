<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

    <title>在线考试系统主界面</title>
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
	</head>

  <body>
  <!-- container section start -->
  <section id="container" class="">     
      <header class="header dark-bg">
            <!--logo start-->
             <input name="src_fenshu" type="hidden" value=${src_fenshu }>
            <a href="" class="logo">考试 系统 <span class="lite"> ${user.userIdentity  }</span></a>          
            <!--logo end-->
            <div class="top-nav notification-row">                
                <c:import url="person.jsp"></c:import>
            </div>
      </header> 
      <!--header end-->
      <!--sidebar start-->
      <aside>
      <!-- menu start-->
          <div id="sidebar"  class="nav-collapse">
               <c:import url="menu.jsp"></c:import>
          </div>
     <!-- menu end-->
      </aside>
      <!--sidebar end-->    
      <!--main start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--status start-->
			  <div class="row">
			  	<div class="col-lg-12">
		  	 		<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		</ol>
		  	 	</div>
                          <!-- 成绩曲线 Line -->
                          <div class="col-lg-6">
                              <section class="panel">
                                  <header class="panel-heading">
                                  	 成绩曲线
                                  </header>
                                  <div class="panel-body text-center">
                                      <canvas id="line" height="300" width="450"></canvas>
                                  </div>
                              </section>
                          </div>                      
                          <!--  柱状统计 Bar -->
                          <div class="col-lg-6">
                              <section class="panel">
                                  <header class="panel-heading">
                                  	柱状统计
                                  </header>
                                  <div class="panel-body text-center">
                                      <canvas id="bar" height="300" width="500"></canvas>
                                  </div>
                              </section>
                          </div>
                         <!-- <div class="col-md-6 portlets">
            				<div class="panel panel-default">
								<div class="panel-heading">
                  				<h2><strong>Calendar</strong></h2>  
								</div><br><br><br>
                				<div class="panel-body">
                  					<!-- Widget content -->
                  					<!-- Below line produces calendar. I am using FullCalendar plugin. -->
                    				<!--<div id="calendar"></div>
                				</div>
              				</div>     
            			   </div>-->
                      </div>  
		  <!-- status end -->
          </section>
          <section>
      	<div class="col-lg-12">
      		<section class="panel">
      			<header class="panel-heading">错题集</header>
 					<table class="table table-bordered">
                       <thead>
                         <tr>
                           <th>序号</th>
                           <th>题目类型</th>
                           <th>题目</th>
                           <th>错误率</th>
                         </tr>
                       </thead>
                       <tbody>
                        <% int i =1; %>
                       <c:forEach items="${wrongquest }" var="errorquestion">
                        <tr>
                          <td><%=i %></td><%i++; %>
                          <td>${errorquestion.errorBelong }</td>
                          <td>${errorquestion.errorSub }</td>
                          <td>${errorquestion.errorRate }</td>
                        </tr>
                       </c:forEach>
                       </tbody>
                    </table>     			
      		</section>
      	</div>
      </section>
      </section>
      <!--main end-->
  </section>
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
    <script src="js/fullcalendar.min.js"></script>
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
	<script src="js/chartjs-custom.js"></script>
	
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
