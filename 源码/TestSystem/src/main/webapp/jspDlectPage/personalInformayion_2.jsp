<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Profile | Creative - Bootstrap 3 Responsive Admin Template</title>

    <!-- Bootstrap CSS -->    
    <link href="styles/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="styles/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="styles/elegant-icons-style.css" rel="stylesheet" />
    <link href="styles/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/style-responsive.css" rel="stylesheet" />
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

      //knob
      $(".knob").knob();

  </script>
</head>
	
<body>
	<div class="row">
       <!-- profile-widget -->
        <div class="col-lg-12">
            <div class="profile-widget profile-widget-info">
                <div class="panel-body">
                    <div class="col-lg-2 col-sm-2">
                        <h4>${User.userName }</h4>               
                            <div class="follow-ava">
                                  <img src="img/profile-widget-avatar.jpg" alt="">
                            </div>
                              <h6>User_Study</h6>
                    </div>
                    <div class="col-lg-4 col-sm-4 follow-info">
                        <p>姓名：${User.userName }</p>
                        <p>身份证号：${User.userUnmcard }</p>
						<p><i class="fa fa-phone">${User.userPhone }</i></p>
                        <h6>
                        <span><i class="icon_clock_alt"></i>11:05 AM</span>
                        <span><i class="icon_calendar"></i>25.10.13</span>
                        <span><i class="icon_pin_alt"></i>NY</span>
                        </h6>
                    </div>
                </div>
                <div class="row">
                 <div class="col-lg-12">
                   <section class="panel">
                    <header class="panel-heading tab-bg-info">
                        <ul class="nav nav-tabs">
                            <li>
                            <a data-toggle="tab" href="#profile">
                             <i class="icon-user"></i>
                               Profile
                            </a>
                            </li>
                            <li class="">
                            <a data-toggle="tab" href="#edit-profile">
                            <i class="icon-envelope"></i>
                            Edit Profile
                            </a>
                            </li>
                            </ul>
                    </header>
                    <div class="panel-body">
                      <div class="tab-content">
                                <!-- profile -->
                        <div id="profile" class="tab-pane">
                           <section class="panel">
                           <div class="bio-graph-heading">
                             Hello I’m Jenifer Smith, a leading expert in interactive and creative design specializing in the mobile medium. My graduation from Massey University with a Bachelor of Design majoring in visual communication.
                            </div>
                            <div class="panel-body bio-graph-info">
                              <h1>Bio Graph</h1>
                              <div class="row">
								<div class="bio-row">
								<p><span>First Name </span>: ${User.userName } </p>
								</div>
								<div class="bio-row">
									<p><span>Last Name </span>: ${User.userName }</p>
								</div>                                              
								<div class="bio-row">
									  <p><span>Birthday</span>: 27 August 1987</p>
								</div>
								<div class="bio-row">
									  <p><span>Country </span>: United</p>
								</div>
								<div class="bio-row">
									  <p><span>Occupation </span>: Student</p>
								</div>
								<div class="bio-row">
									  <p><span>Email </span>:jenifer@mailname.com</p>
								</div>
								<div class="bio-row">
									  <p><span>Mobile </span>: ${User.userPhone }</p>
								</div>
								<div class="bio-row">
									  <p><span>Card </span>:  ${User.userUnmcard }</p>
								</div>
                              </div>
                            </div>
                            </section>
                            <section>
                              <div class="row"></div>
                            </section>
                        </div>
                           <!-- edit-profile -->
                        <div id="edit-profile" class="tab-pane">
                            <section class="panel">                                          
                                  <div class="panel-body bio-graph-info">
                                      <h1> Profile Info</h1>
                                      <form class="form-horizontal" role="form" action="to_edit-profile.do">                                                  
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">First Name</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="f-name" name="name"placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">PassWord</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="pwd" name="pwd" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">About Me</label>
                                            <div class="col-lg-10">
                                                <textarea name="" id="" class="form-control" cols="30" rows="5"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Country</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="c-name" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Birthday</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="b-day" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">NumCard</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="occupation" name="numcard" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Email</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="email" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Mobile</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="mobile" name="mobile" placeholder=" ">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Website URL</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="url" placeholder="http://www.demowebsite.com ">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button type="submit" class="btn btn-primary">Save</button>
                                                <button type="button" class="btn btn-danger">Cancel</button>
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
			</div>
		</div>
	</div>
</body>
</html>
