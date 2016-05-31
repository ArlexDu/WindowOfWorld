<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>The World Window</title>

    <!-- Bootstrap Core CSS -->
    <link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../assets/css/agency.css" rel="stylesheet">

    <!-- Custom Fonts -->
	<link href="../assets/wow-font/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    
    <!-- New -->
    <link href="../assets/css/new.css" rel="stylesheet">

</head>

<body id="page-top" class="index">
	<!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="home.jsp">世界之窗</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">返回</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#AppModal" data-toggle="modal">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
	<!-- 登录部分 -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">登录</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="login" id="login">
                        <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="手机号" id="account" name="phone" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="password" class="form-control" placeholder="密码 " id="password" name="password" required>
                               <p class="help-block text-danger"></p>
                           </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-3"></div>   
                           <div class="col-lg-12">
                               <div class="col-lg-3"></div>
	                               <div class="col-lg-3">
	                               	  <input type="button" class="btn btn-xl" value="登录" onclick="return check_login()">
	                               </div>
	                               <div class="col-lg-3">
	                               	  <a class="btn btn-xl" href="register.jsp">注册</a>
	                               </div>
                               <div class="col-lg-3"></div>
                           </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Our Web 2016</span>
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-arrow-circle-up"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/check.js"></script>
    
    <!-- 登录出错弹出 -->

<div class="modal fade" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">登录信息出错</h4>
	      </div>
	      <div class="modal-body" id="reg_context"></div>
	      <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
    <!--APP二维码-->
    <div class="portfolio-modal modal fade" id="AppModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>扫二维码下载APP</h2>
                        <img class="img-responsive img-centered" src="../assets/images/portfolio/dreams-preview.png" alt="">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                    </div>
            </div>
        </div>
    </div>
    
</body>
</html>