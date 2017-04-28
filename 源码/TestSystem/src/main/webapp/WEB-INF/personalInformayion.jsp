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

    <title>个人信息详情</title>
	
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
	<style type="text/css">
		#imagepath{
			opacity:0;
		}
	</style>
  </head>

  <body>
    <section id="container" class="">
      <header class="header dark-bg">
            <!--logo start-->
            <input type="file" id="imagepath" name="imagepath" >
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
		  <div class="row">
		 
			<div class="col-lg-12">
			  <h3 class="page-header"><i class="fa fa-user-md"></i> 个人信息</h3>
			</div>
			 <div class="col-lg-12">
		  	 	<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toPersonalInformation.do">个人信息</a></li>
		  	 	</ol>
		  	</div>
			</div>
              <div class="row">
                <!-- profile-widget -->
                <div class="col-lg-12">
                    <div class="profile-widget profile-widget-info">
                          <div class="panel-body">
                            <div class="col-lg-2 col-sm-2">
                              <h4>${User.userName }</h4> 
                              <div class="follow-ava">
                                <a  href="#">             
                                  <img src="img/profile-widget-avatar.jpg" alt="">
                                </a>
                              </div>
                              <h6>图像展示</h6>
                            </div>
                            <div class="col-lg-4 col-sm-4 follow-info">
                                <p>你好，我的名字是${User.userName }，以下是我的相关信息，请大家多多指教</p>
                                <p>身份证号：${User.userUnmcard }</p>
								<p><i class="fa fa-phone">${User.userPhone }</i></p>
                                <h6>
                                    <span><i class="icon_clock_alt"></i>11:05 AM</span>
                                    <span><i class="icon_calendar"></i>25.10.13</span>
                                    <span><i class="icon_pin_alt"></i>NY</span>
                                </h6>
                            </div>
                            <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                      <ul>
                                          <li class="active">  
                                              <i class="fa fa-comments fa-2x"> </i><br>
											  Contrary to popular belief, Lorem Ipsum is not simply
                                          </li> 
                                      </ul>
                            </div>
							<div class="col-lg-2 col-sm-6 follow-info weather-category">
                                 <ul>
                                     <li class="active">
                                       <i class="fa fa-bell fa-2x"> </i><br>
											Contrary to popular belief, Lorem Ipsum is not simply 
                                       </li>
							     </ul>
                            </div>
							<div class="col-lg-2 col-sm-6 follow-info weather-category">
                                  <ul>
                                       <li class="active">
                                         <i class="fa fa-tachometer fa-2x"> </i><br>
											 Contrary to popular belief, Lorem Ipsum is not simply
                                          </li> 
                                  </ul>
                            </div>
                          </div>
                    </div>
                </div>
              </div>
              <!-- page start-->
              <div class="row">
                 <div class="col-lg-12">
                    <section class="panel">
                          <header class="panel-heading tab-bg-info">
                              <ul class="nav nav-tabs">
                             	<li class="active">
                                      <a data-toggle="tab" href="#recent-activity">
                                          <i class="icon-home"></i>个人信息
                                      </a>
                                 </li>
                                 <li class="">
                                      <a data-toggle="tab" href="#edit-profile">
                                          <i class="icon-envelope"></i>修改信息
                                      </a>
                                  </li>
                              </ul>
                          </header>
                          <div class="panel-body">
                              <div class="tab-content">
                               	  <div id="recent-activity" class="tab-pane active">
                                      <div class="profile-activity"> 
                                          <section class="panel">
                                      <div class="bio-graph-heading">
                                      	你好，我的名字是${User.userName }，以下是我的相关信息，请大家多多指教
                                      </div>
                                      <div class="panel-body bio-graph-info">
                                          <h1>简介</h1>
                                          <div class="row">
                                              <div class="bio-row">
                                                  <p><span>姓名 </span>: ${User.userName } </p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>姓名 </span>: ${User.userName }</p>
                                              </div>                                              
                                              <div class="bio-row">
                                                  <p><span>出生日期</span>: 27 August 1987</p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>所在地 </span>: United</p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>职业 </span>: UI Designer</p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>电子邮箱 </span>:${User.userEmail }</p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>电话</span>: ${User.userPhone }</p>
                                              </div>
                                              <div class="bio-row">
                                                  <p><span>身份证号码 </span>:  ${User.userUnmcard }</p>
                                              </div>
                                          </div>
                                      </div>
                                    </section>                                       
                                   </div>
                                  </div>
                                  <!-- profile -->
                               
                                  <!-- edit-profile -->
                                  <div id="edit-profile" class="tab-pane">
                                    <section class="panel">                                          
                                          <div class="panel-body bio-graph-info">
                                              <h1> 修改信息</h1>
                                              <form class="form-horizontal" role="form" action="to_edit-profile.do">                                                  
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">姓名</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="f-name" name="name" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">密码</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="l-name" name="pwd" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">简介信息</label>
                                                      <div class="col-lg-10">
                                                          <textarea name="" id="" class="form-control" cols="30" rows="5"></textarea>
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">居住地</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="c-name" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">生日</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="b-day" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">身份证号码</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="NumCard" name="numcard" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">邮箱地址</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="email" name="email" placeholder="" >
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">手机号码</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="mobile"  name="mobile" placeholder=" ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <label class="col-lg-2 control-label">个人主页</label>
                                                      <div class="col-lg-6">
                                                          <input type="text" class="form-control" id="url" placeholder="http://www.demowebsite.com ">
                                                      </div>
                                                  </div>
                                                  <div class="form-group">
                                                      <div class="col-lg-offset-2 col-lg-10">
                                                          <button type="submit" class="btn btn-primary">保存</button>
                                                          <button type="reset" class="btn btn-danger">取消</button>
                                                      </div>
                                                  </div>
                                              </form>
                                          </div>
                                      </section>
                                  </div>
                              </div>
                          </div>
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
    <!-- nice scroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- jquery knob -->
    <script src="assets/jquery-knob/js/jquery.knob.js"></script>
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
