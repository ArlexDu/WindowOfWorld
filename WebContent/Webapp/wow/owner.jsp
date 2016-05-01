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

    <link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/css/agency.css" rel="stylesheet">
	<link href="../assets/wow-font/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    
    <!-- New -->
    <link href="../assets/css/new.css" rel="stylesheet">
</head>

<body id="page-top" class="index">

    <!-- 菜单栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="#">个人主页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="account.jsp">返回</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="upload.jsp">上传广告</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">退出</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">个人信息</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="register1" id="register1" onSubmit=" return closebut()" novalidate>
                        <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="账号--手机号/身份证" id="account" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="姓名 " id="name" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="昵称 " id="nickname" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="身份证" id="identity" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="联系电话" id="telephone" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="password" class="form-control" placeholder="密码 --8~16位" id="password" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="password" class="form-control" placeholder="重复密码" id="password" required readonly>
                               <p class="help-block text-danger"></p>
                           </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-3"></div>   
                           <div class="col-lg-12">
                               <div class="col-lg-3"></div>
	                               <div class="col-lg-3">
	                               	  <input class="btn btn-xl" type="button" value="修改"  onclick="doclick1();" />
	                               </div>
	                               <div class="col-lg-3">
	                                  <input class="btn btn-xl" type="button" value="保存"  onclick="doclick2();" />
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
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.easing.min.js"></script>
    <script src="../assets/js/classie.js"></script>
    <script src="../assets/js/cbpAnimatedHeader.js"></script>
    <script src="../assets/js/jqBootstrapValidation.js"></script>
    <script src="../assets/js/contact_me.js"></script>
    <script src="../assets/js/agency.js"></script>
    
    <script>
		function closebut(){
		document.register1.imageField.disabled=true;
		}
	</script>
	
	<script>
		function doclick1(){  
		var txtN =document.getElementById("register1").getElementsByTagName("input");
		 for(i=0;i<txtN.length;i++){
		   if(txtN[i].type="text"){
		    txtN[i].readOnly=false;
		   }
		 }
		} 
		function doclick2(){  
			var txtN =document.getElementById("register1").getElementsByTagName("input");
			 for(i=0;i<txtN.length;i++){
			   if(txtN[i].type="text"){
			    txtN[i].readOnly=true;
			   }
			 }
			}
	</script>

</body>

</html>
