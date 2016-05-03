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
    <link href="../assets/css/new.css" rel="stylesheet">
</head>

<body id="page-top" class="index">

	<!-- 菜单栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="home.jsp">注册</a>
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
                        <a class="page-scroll" href="#AppModal" data-toggle="modal">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
	<!-- 注册部分 -->
    <section id="contact">
        <div class="container">
                <form name="register" id="register" method="post" onsubmit="return check_reg()" action="">
                    <div class="col-lg-12 reg_font">
                        <div class="col-lg-3">
                        	<div class="ava_all">
                               <label>
							   <img id="portrait" src="/AmazingAd/Webapp/assets/images/avatar.jpg">
                               <input class="avatar" accept="image/gif, image/jpeg, image/x-png" type="file" name="avatar" onchange="showPreview(this)" />
                               </label>
                            </div>
                        </div>
                        <div class="col-lg-6">
                           <div class="reg_1">	 
                           <div class="form-group">
                           		<label>企业名称</label>
                           		<input type="text" class="form-control" placeholder="不大于30字符" name="username">
                           </div>
                           <div class="form-group">
                               <label>法人姓名</label>
                               <input type="text" class="form-control" placeholder="不大于30字符 " name="realname">
                           </div>
                           <div class="form-group">
                           		<label>广告商执照</label>
                              	<input type="text" class="form-control" placeholder="证件编号" name="licence">
                           </div>
                           <div class="form-group">
                           		<label>身份证</label>
                              	<input type="text" class="form-control" placeholder="二代身份证" name="identity">
                           </div>
                           </div>
                           <div class="reg_2">	 
                           <div class="form-group">
                          		<label>联系电话</label>
                              	<input type="text" class="form-control" placeholder="手机号码或固话" name="phone">
                           </div>
                           <div class="form-group">
                           		<label>邮箱</label>
                              	<input type="email" class="form-control" placeholder="常用邮箱" name="mail">
                           </div>
                           <div class="form-group">
                           		<label>密码 </label>
                              	<input type="password" class="form-control" placeholder="8~16位" name="password">
                           </div>
                           <div class="form-group">
                           		<label>重复密码</label>
                              	<input type="password" class="form-control" placeholder="请于上一致" name="password1">
                           </div>
                           </div>
                           <div class="reg_3">
                           <div class="picture">
                           		<label class="liscense1">广告商执照认证</label>
                           		<img id="liscense_p" src="/AmazingAd/Webapp/assets/images/jiazhao_m.jpg">
                           		<label class="liscense0">本地选取
                              	<input class="liscense" accept="image/gif, image/jpeg, image/x-png" type="file" name="licencecard" onchange="showPreview1(this)" />
                           		</label>
                           </div>
                           <div class="picture">
                           		<label class="identity1">身份证照片认证</label>
                           		<img id="identity_p" src="/AmazingAd/Webapp/assets/images/id.jpg">
                           		<label class="identity0">本地选取
                              	<input class="identity" accept="image/gif, image/jpeg, image/x-png" type="file" name="identitycard" onchange="showPreview2(this)" />
                           		</label>
                           </div>
                           </div>	
                       </div>
					   <div class="col-lg-3">
					   	   <div class="reg_change">
                       	   <span class="glyphicon glyphicon-chevron-up" id="reg_change1" onclick="reg_change1();"></span><br>
                       	   <span class="glyphicon glyphicon-minus" id="reg_change2" onclick="reg_change2();"></span><br>
                       	   <span class="glyphicon glyphicon-chevron-down" id="reg_change3" onclick="reg_change3();"></span><br>
                       	   </div>
                       </div> 
                    </div>
                       <div class="col-lg-12">
                           <div class="col-lg-4"></div>
                           <div class="col-lg-4">
                           	  <input type="submit" class="btn btn-xl" value="注册">
                           </div>
                           <div class="col-lg-4"></div>
                       </div>
                </form>
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
    
	
	<script src="../assets/js/check.js"></script>
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.easing.min.js"></script>
    <script src="../assets/js/classie.js"></script>
    <script src="../assets/js/cbpAnimatedHeader.js"></script>
    <script src="../assets/js/jqBootstrapValidation.js"></script>
    <script src="../assets/js/contact_me.js"></script>
    <script src="../assets/js/agency.js"></script>
    

	<!-- 注册弹出框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息</h4>
	      </div>
	      <div class="modal-body">注册成功</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">注册信息出错</h4>
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