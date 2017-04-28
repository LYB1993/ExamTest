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
    <title>题库查看</title>

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
            <a href="index.html" class="logo">考试 系统<span class="lite">${user.userIdentity  }</span></a>
            <!--logo end-->
            <div class="top-nav notification-row">                
                <!-- person start-->
                 <c:import url="person.jsp"></c:import>
                <!-- person end-->
            </div>
      </header>      
      <!--header end-->
      <!--sidebar start-->
      <aside>
          <!-- menu start-->
          <div id="sidebar"  class="nav-collapse ">   
             <c:import url="menu.jsp"></c:import>
          </div>
          <!-- menu end-->
      </aside>

      <!--main start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <div class="row">
              	<div class="col-lg-12">
		  	 		<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toAllQuestions.do">题库总览</a></li>
		  	 		</ol>
		  	 	</div>
                <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading"> 题库信息</header>
                          <div class="table-responsive">
                            <table class="table">
                              <thead>
                                <tr>
                                  <th>编号</th>
                                  <th>题目</th>
                                  <th>答案A</th>
                                  <th>答案B</th>
                                  <th>答案C</th>
                                  <th>答案D</th>
                                  <th>正确答案</th>
                                  <th>操作</th>
                                </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${allquest }" var="quest">
                                <tr>
                                  <td>${quest.questId }&ensp;&ensp;</td>
                                  <td>${quest.questSubjct }</td>
                                  <td>${quest.questA }</td>
                                  <td>${quest.questB }</td>
                                  <td>${quest.questC }</td>
                                  <td>${quest.questD }</td>
                                  <td>${quest.questAnswer }</td>
                                  <td>
                                  <div class="btn-group">
                                      <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>
                                  </div>
                                  </td>
                                </tr>
                               </c:forEach>
                              </tbody>
                            </table>
                          </div>

                      </section>
                  </div>
              </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main end-->
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

