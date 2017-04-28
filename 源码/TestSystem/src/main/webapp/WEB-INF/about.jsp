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
    <title>关于系统</title>

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
			<div class="row">
				<div class="col-lg-12">
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
						<li><i class="icon_genius"></i><a href="toAbout.do">关于系统</a></li>	
				</div>
			</div>
              <div class="row">
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              Basic items
                          </header>
                          <ul class="list-group">
                              <li class="list-group-item">Lorem ipsum dolor sit amet</li>
                              <li class="list-group-item">Praesent tempus eleifend risus</li>
                              <li class="list-group-item">Praesent tempus eleifend risus</li>
                              <li class="list-group-item">Porta ac consectetur ac</li>
                              <li class="list-group-item">Vestibulum at eros</li>
                              <li class="list-group-item">Vestibulum at eros</li>
                          </ul>
                      </section>
                  </div>
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              Linked items
                          </header>
                          <div class="list-group">
                              <a class="list-group-item " href="#">
                                  Lorem ipsum dolor sit amet
                              </a>
                              <a class="list-group-item active" href="javascript:;">Praesent tempus eleifend risus</a>
                              <a class="list-group-item" href="javascript:;">Praesent tempus eleifend risus</a>
                              <a class="list-group-item" href="javascript:;">Porta ac consectetur ac</a>
                              <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                              <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              Custom content
                          </header>
                          <div class="list-group">
                              <a class="list-group-item " href="javascript:;">
                                  <h4 class="list-group-item-heading">List group item heading</h4>
                                  <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                              </a>
                              <a class="list-group-item active" href="javascript:;">
                                  <h4 class="list-group-item-heading">List group item heading</h4>
                                  <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                              </a>
                              <a class="list-group-item" href="javascript:;">
                                  <h4 class="list-group-item-heading">List group item heading</h4>
                                  <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                              </a>
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
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

