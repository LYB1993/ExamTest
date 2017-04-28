<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
	<meta name="author" content="GeeksLabs">
	<meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
	<link rel="shortcut icon" href="img/favicon.png">
	<title>上传试卷</title>
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
    	<a href="index.html" class="logo">考试 系统 <span class="lite"> ${user.userIdentity  }</span></a> 
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
  <!--sidebar end--> 
  
  <!--main content start-->
  	<section id="main-content">
    	<section class="wrapper">
      		<div class="row">
      		<div class="col-lg-12">
		  	 	<ol class="breadcrumb">
		  	 		<li><i class="fa fa-home"></i><a href="toIndex.do">主页</a></li>
		  	 		<li><i class="icon_document_alt"></i><a href="toExamgrow.do">试卷生成</a></li>
		  	 	</ol>
		  	 </div>
        		<div class="col-lg-11">
         		 	<section class="panel">
           		 		<header class="panel-heading">上传试卷<span>${message }</span></header>
            			<div class="panel-body">
              				<form role="form" method="post" enctype="multipart/form-data" action="UploadTXTFile.do">
                			<div class="form-group">题目类型 ：
                  				<input type="email" class="form-control" id="exampleInputSub" placeholder="试题类型">
                			</div>
                			<div class="form-group">题目描述：
                  				<input type="text" class="form-control" id="exampleInput" placeholder="试题描述">
                			</div>
                			<div class="form-group">
                  				<label for="exampleInputFile">打开文件</label>
                  				<input type="file" id="exampleInputFile" name="examTXT">
                  				<p class="help-block">请选择需要上传的文件</p>
                			</div>
                			<div class="checkbox">
                  				<label>
                    				<input type="checkbox"> 勾选
                  				</label>
                			</div>
                			<button  type="submit" class="btn btn-primary">开始上传</button>
              				</form>
            			</div>
          			</section>
        		</div>
        		<section class="panel">
        		<div class="col-lg-11">
    				<header class="panel-heading">上传试题<span>${message2 }</span></header>
    				<div class="panel-body">
    					<form class="form-horizontal" action="oneQuestion.do" method="post">
    						<div class="form-group has-success">
                       		<label class="control-label col-lg-2" for="inputSuccess">输入题目：</label>
                        	<div class="col-lg-10">
                           		<input type="text" class="form-control" name="sub">
                       	 	</div>
                    		</div>
                    		<div class="form-group has-success">
                       			<label class="control-label col-lg-2" for="inputSuccess">输入答案A：</label>
                        		<div class="col-lg-10">
                           			<input type="text" class="form-control" name="qa">
                        		</div>
                    		</div>
		                    <div class="form-group has-success">
		                        <label class="control-label col-lg-2" for="inputSuccess">输入答案B：</label>
		                        <div class="col-lg-10">
		                           <input type="text" class="form-control" name="qb">
		                        </div>
		                    </div>
		                    <div class="form-group has-success">
		                        <label class="control-label col-lg-2" for="inputSuccess">输入答案C：</label>
		                        <div class="col-lg-10">
		                           <input type="text" class="form-control"name="qc">
		                        </div>
		                    </div>
		                    <div class="form-group has-success">
		                        <label class="control-label col-lg-2" for="inputSuccess">输入答案D：</label>
		                        <div class="col-lg-10">
		                           <input type="text" class="form-control" name="qd">
		                        </div>
		                    </div>
			                <div class="form-group has-success col-lg-10">
			                  <div class="row">
								<label class="control-label col-lg-2" for="inputSuccess">答案：</label>
			                     <div class="col-lg-2">
			                       <select class="form-control" name="an">
                                        <option>A</option>
                                        <option>B</option>
                                        <option>C</option>
                                        <option>D</option>
                                     </select>
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">分值：</label>
			                     <div class="col-lg-2">
			                       <input type="text" class="form-control col-lg-1" name="score">
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">分值：</label>
			                     <div class="col-lg-2">
			                     	<select class="form-control" name="belong">
                                        <option>Option 1</option>
                                        <option>Option 2</option>
                                        <option>Option 3</option>
                                     </select>
			                     </div>
			                  </div>
							</div>
		                    <div class="col-lg-offset-2 col-lg-5" style="postion:absolute;left:20%;">
                    			<button type="submit" class="btn btn-success" >提交</button>
                    			<button type="reset" class="btn btn-danger" >清除</button>
                    			<!--<a class="btn btn-success" href="">提交</a>-->
                    		</div>
    					</form>
    				</div>
    			</div>
    			</section>
    			<section class="panel">           	
                  <div class="col-lg-11" style="margin-top: 30px;">
                  <header class="panel-heading">制作考卷<span>${message2 }</span></header>
                  <div class="panel-body">
                      <div class="form quick-post">
                           <form class="form-horizontal" action="addExamTest.do" method="get">                          
                               <!-- 题目模式1 -->  
                              <div class="form-group has-success col-lg-10">
			                  <div class="row">
								<label class="control-label col-lg-2" for="inputSuccess">选择题数目：</label>
			                     <div class="col-lg-2">
			                       <select class="form-control" name="choiceNum">
                                        <option>15</option>
                                        <option>20</option>
                                        <option>25</option>
                                        <option>30</option>
                                     </select>
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">分值：</label>
			                     <div class="col-lg-2">
			                       <input type="text" class="form-control col-lg-1" name="choiceScore">
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">时间：</label>
			                     <div class="col-lg-2">
			                     	<select class="form-control" name="examTime">
                                        <option value="">- 选择时间 -</option>
                                        <option>30</option>
                                        <option>45</option>
                                        <option>60</option>
                                        <option>90</option>
                                     </select>
			                     </div>
			                  </div>
							</div>
							<!--  -->
							<div class="form-group has-success col-lg-10">
			                  <div class="row">
								<label class="control-label col-lg-2" for="inputSuccess">简答题数目：</label>
			                     <div class="col-lg-2">
			                       <select class="form-control" name="jdNum">
                                        <option>15</option>
                                        <option>20</option>
                                        <option>25</option>
                                        <option>30</option>
                                     </select>
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">分值：</label>
			                     <div class="col-lg-2">
			                       <input type="text" class="form-control col-lg-1" name="jdScore">
			                     </div>
			                     <label class="control-label col-lg-2" for="inputSuccess">难度：</label>
			                     <div class="col-lg-2">
			                     	<select class="form-control" name="examDif">
                                        <option value="">- 选择难度 -</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                     </select>
			                     </div>
			                  </div>
							</div>  
							<!--  --> 
							<div class="form-group has-success col-lg-10">
			                  <div class="row">
			                     <label class="control-label col-lg-2" for="inputSuccess">试卷名称：</label>
			                     <div class="col-lg-9">
			                       <input type="text" class="form-control col-lg-9" name="examName">
			                     </div>
			                  </div>
							</div>                   
                                <div class="form-group">
                                <!-- Buttons -->
									<div class="col-lg-offset-2 col-lg-9" style="padding-left: 250px;">
										<button type="submit" class="btn btn-danger">完 &ensp;&ensp;成</button>
										<button type="reset" class="btn btn-default">清 &ensp;&ensp;除</button>
									</div>
                                </div>
                          </form>
                       </div>
                  </div>
                  </div>
        	</section>
      		</div>
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

	<!-- jquery ui --> 
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script> 
	<!--custom checkbox & radio--> 
	<script type="text/javascript" src="js/ga.js"></script> 
	<!--custom switch--> 
	<script src="js/bootstrap-switch.js"></script> 
	<!--custom tagsinput--> 
	<script src="js/jquery.tagsinput.js"></script> 
	<!-- colorpicker --> 
	<!-- bootstrap-wysiwyg --> 
	<script src="js/jquery.hotkeys.js"></script> 
	<script src="js/bootstrap-wysiwyg.js"></script> 
	<script src="js/bootstrap-wysiwyg-custom.js"></script> 
	<!-- ck editor --> 
	<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script> 
	<!-- custom form component script for this page--> 
	<script src="js/form-component.js"></script> 
	<!-- custome script for all page --> 
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