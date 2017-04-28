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

    <title>考试情况详情页</title>

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
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
            </div>

            <!--logo start-->
            <a href="index.html" class="logo">考试  <span class="lite">系统</span></a>
            <!--logo end-->

            <div class="top-nav notification-row">                
                <!-- notificatoin dropdown start-->
            	<c:import url="person.jsp"></c:import>
                <!-- notificatoin dropdown end-->
            </div>
      </header>      
      <!--header end-->

      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
               <c:import url="menu.jsp"></c:import>
              <!-- sidebar menu end-->
          </div>
      </aside>

      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
		  	 <div class="col-lg-12">
		  	 	<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toSlelctScore.do">成绩总览</a></li>
		  	 		<li><i class="fa fa-file-text-o"></i><a href="toAllScore.do">详细情况</a></li>
		  	 	</ol>
		  	 </div>
              <!-- page start-->
              <c:forEach items="${all_as }" var="as">
                  <div class="col-sm-6">
                      <section class="panel">
                          <header class="panel-heading no-border">
                           	  考生 ${name } 的所有考试情况
                          </header>
                          <%int i =1; %>
                          <table class="table table-bordered">
                         	 
                         		<%for(int j = 0;j<20;j+=5){ %>
                         		<%int end = j+4; %>
                              <thead>
                              <tr>
                                  <th>ID<%=i %></th>
                                  <%i++; %>
                                  <th>ID<%=i %></th>
                                  <%i++; %>
                                  <th>ID<%=i %></th>
                                  <%i++; %>
                                  <th>ID<%=i %></th>
                                  <%i++; %>
                                  <th>ID<%=i %></th>
                                  <%i++; %>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                              	<c:forTokens items="${as.answerstr }" var="ass" delims="X" begin="<%=j %>" end="<%=end %>">
                                  <td>${ass }</td>
                                </c:forTokens>
                              </tr>
                              </tbody>
                           		<%} %>
                             
                          </table>
                      </section>
                  </div>
              </c:forEach>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section end -->
    <!-- javascripts -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- nicescroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
        <script type="text/javascript">
	$(function(){
		
		if($("input:hidden[name='identity']").val()=="STU"){
			
		}else{
			$(".sub-menu2").removeClass("sub-menu2");
		}
	});
    </script>


  </body>
</html>
