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

    <title>删除试卷</title>

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
            <a href="" class="logo">考试 系统 <span class="lite"> ${user.userIdentity  }</span></a> 
            <!--logo end-->
            <!-- person start-->
            <div class="top-nav notification-row">                
               	<c:import url="person.jsp"></c:import>
            </div>
            <!-- person end-->
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

      <!--main content start-->
		<section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <div class="row">
              	<div class="col-lg-12">
		  	 		<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toExamdelete.do">试卷删除</a></li>
		  	 		</ol>
		  	 	</div>
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">试卷列表</header>
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
                              	 <th><i class="icon_profile"></i>编号</th>
                              	 <th><i class="icon_profile"></i>试卷名称</th>
                                 <th><i class="icon_cogs"></i> 操作</th>
                              </tr>
                              <%int i = 1; %>
                              <c:forEach items="${belong }" var="bl">
                              <tr>
                              	 <td><%=i %></td>
                             	 <td>${bl }</td>
                                 <td>
                                  <div class="btn-group">
                                  	  <a class="btn btn-primary" href="toExamgrow.do"><i class="icon_plus_alt2"></i></a>
                                      <a class="btn btn-danger" href="examdelete.do?exampageName=${bl }"><i class="icon_close_alt2"></i></a>
                                  </div>
                                  </td>
                              </tr>  
                              <%i++; %>
                              </c:forEach>            
                           </tbody>
                        </table>
                      </section>
                  </div>
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