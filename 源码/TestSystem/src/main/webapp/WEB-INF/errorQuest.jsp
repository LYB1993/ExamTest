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

    <title>Error quest Page</title>

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
            <a href="index.html" class="logo">EXAM <span class="lite">TEST</span></a>
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
      <!--sidebar end-->

      <!--main content start-->
      <section id="main-content-score">
          <section class="wrapper">             
              <div class="row">
                  <div class="col-lg-6">
                      <!--notification start-->
                      <form class="form-validate form-horizontal" id="feedback_form" method="   " action="toExamAnser.do">    
                   <section class="panel">
                   <c:forEach items="${request }" var="quests">
                      <header class="panel-heading">
                         <strong>${quests.questId }&nbsp;&nbsp;${quests.questSubjct }</strong>
                      </header>
                          <div class="panel-body">
                            <div class="alert alert-success fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input type=radio value="A" name="${quests.questId }">
                                  <strong>A.</strong> ${quests.questA }
                            </div>      
                              <div class="alert alert-block alert-danger fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input type=radio value="B" name="${quests.questId }">
                                  <strong>B.</strong> ${quests.questB }
                              </div>                              
                              <div class="alert alert-info fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input type=radio value="C" name="${quests.questId }">
                                  <strong>C.</strong> ${quests.questC }
                              </div>
                              <div class="alert alert-warning fade in">
                                  <button data-dismiss="alert" class="close close-sm" type="button">
                                      <i class="icon-remove"></i>
                                  </button>
                                  <input type=radio value="D" name="${quests.questId }">
                                  <strong>D.</strong> ${quests.questD }
                              </div>
                          </div>
                        </c:forEach>
                          <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                  <button class="btn btn-primary" type="submit">Save</button>  
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
    </script>
</body>
</html>
