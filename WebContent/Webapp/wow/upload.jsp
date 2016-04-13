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
	<link href="../assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    
    <!-- New -->
    <link href="../assets/css/new.css" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="../assets/css/lq.datetimepick.css"/>

</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="account.jsp">个人主页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="account.jsp">返回</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="history.jsp">查看历史</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="owner.jsp">个人信息</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">退出</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">App</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
  
    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">上传广告</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="upload" id="contactForm" novalidate>
                        <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="账号--手机号/身份证" id="account" required>
                                <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                                <textarea class="form-control" placeholder="广告内容" id="context" required></textarea>
                                <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
							    <input type="file" id="exampleInputFile"  class="form-control" placeholder="上传图片">
							    <p class="help-block text-danger"></p>
						   </div>
						   <div class="form-group">
							    <input type="text" class="form-control" placeholder="发布日期" id="begin-date" required>
                                <p class="help-block text-danger"></p>
						   </div>
						   <div class="form-group">
							    <input type="text" class="form-control" placeholder="截止日期" id="end-date" required>
                                <p class="help-block text-danger"></p>
						   </div>
						   <div class="form-group">
							    <input type="text" class="form-control" placeholder="发布时段" id="time" required>
                                <p class="help-block text-danger"></p>
						   </div>
						   <div class="form-group">
							    <input type="text" class="form-control" placeholder="发布地段" id="area" required>
                                <p class="help-block text-danger"></p>
						   </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-3"></div>   
                           <div class="col-lg-12">
                               <div class="col-lg-4"></div>
	                               <div class="col-lg-4">
	                               	  <a class="btn btn-xl" href="upload.jsp">上传</a>
	                               </div>
                               <div class="col-lg-4"></div>
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
                    <span class="copyright">Our Website 2016</span>
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


 	 <!-- jQuery -->
    <script src="../assets/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../assets/js/jquery.easing.min.js"></script>
    <script src="../assets/js/classie.js"></script>
    <script src="../assets/js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="../assets/js/jqBootstrapValidation.js"></script>
    <script src="../assets/js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../assets/js/agency.js"></script>
 
</body>

</html>
