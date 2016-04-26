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
	
	<script src="../assets/js/check.js"></script>
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</head>

<body id="page-top" class="index">

	<!-- 菜单栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="home.jsp">世界之窗</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">首页</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="login.jsp">返回</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
	<!-- 注册部分 -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">注册</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="register" id="register">
                        <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="用户昵称" name="username" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="法人姓名 " name="realname" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="广告商执照 " name="liscense" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="身份证" name="identity" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="联系电话" name="phone" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="邮箱" name="mail" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="password" class="form-control" placeholder="密码 --8~16位" name="password" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="password" class="form-control" placeholder="重复密码" name="password1" required>
                               <p class="help-block text-danger"></p>
                           </div>
                           <div class="form-group">
                              	<input type="text" class="form-control" placeholder="用户头像" name="avatar" required>
                               <p class="help-block text-danger"></p>
                           </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-3"></div>   
                           <div class="col-lg-12">
                               <div class="col-lg-4"></div>
	                               <div class="col-lg-4">
	                               	  <input type="button" class="btn btn-xl" value="注册" onclick="return check_reg()">
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
   

	<!-- 注册弹出框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息</h4>
	      </div>
	      <div class="modal-body">注册成功</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="window.location.href='/AmazingAd/Webapp/wow/account.jsp'">确定</button>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="myModalLabel">注册信息出错</h3>
	      </div>
	      <div class="modal-body">企业名称超过30位</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息出错</h4>
	      </div>
	      <div class="modal-body">法人名称超过30位</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息出错</h4>
	      </div>
	      <div class="modal-body">身份证长度不正确</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息出错</h4>
	      </div>
	      <div class="modal-body">密码长度不符合要求</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息出错</h4>
	      </div>
	      <div class="modal-body">两次输入密码不一致</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
</body>
</html>