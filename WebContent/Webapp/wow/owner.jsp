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
                <a class="navbar-brand page-scroll" href="#">个人信息</a>
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
                        <a class="page-scroll" href="#AppModal" data-toggle="modal">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!--信息部分 -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 reg_font">
                    <form name="register1" id="register1" onSubmit=" return closebut()">
                        <div class="row">
                        <div class="col-lg-3">
	                        <div class="form-group">
	                           <label>
	                           <input class="avatar" accept="image/gif, image/jpeg, image/x-png" type="file" name="avatar" onchange="showPreview(this)" />
	                       	   <img id="portrait" src="/AmazingAd/Webapp/assets/images/avatar.jpg">
	                       	   </label>
	                        </div>
                        	<div class="form-group">
	                        <label>商业执照</label>
	                        <img id="lis_pic" src="/AmazingAd/Webapp/assets/images/jiazhao_m.jpg"><br/>
	                        </div>
	                        <div class="form-group">
	                        <label>身份证照片</label>
	                        <img id="id_pic" src="/AmazingAd/Webapp/assets/images/id.jpg"><br/>
	                        </div>
                        </div>
                        <div class="col-lg-1"></div>
                        <div class="col-lg-6">
                           <div class="form-group">
                           		<label>企业名称</label>
                           		<input type="text" class="form-control" placeholder="不大于30字符" name="username" readonly>
                           </div>
                           <div class="form-group">
                               <label>法人姓名</label>
                               <input type="text" class="form-control" placeholder="不大于30字符 " name="realname" readonly>
                           </div>
                           <div class="form-group">
                          		<label>联系电话</label>
                              	<input type="text" class="form-control" placeholder="手机号码或固话" name="phone" readonly>
                           </div>
                           <div class="form-group">
                           		<label>邮箱</label>
                              	<input type="email" class="form-control" placeholder="常用邮箱" name="mail" readonly>
                           </div>
                           <div class="form-group">
                           		<span class="label label-success pw" onclick="pw_change();">更改密码</span>
                           		<span id="pw_close" class="label label-success" onclick="pw_close();">收起</span>
                           </div>
                           <div class="pw_change">
                           <div class="form-group">
                           		<label>密码 </label>
                              	<input type="password" class="form-control" placeholder="8~16位" name="password" readonly>
                           </div>
                           <div class="form-group">
                           		<label>重复密码</label>
                              	<input type="password" class="form-control" placeholder="请于上一致" name="password1" readonly>
                           </div>
                           </div>
                        </div> 
                        <div class="col-lg-2"></div>
                        <div class="col-lg-12">
                            <div class="col-lg-4"></div>
                             <div class="col-lg-3">
                             	  <input class="btn btn-xl" type="button" value="修改"  onclick="doclick1();" />
                             </div>
                             <div class="col-lg-3">
                                <input class="btn btn-xl" type="button" value="保存"  onclick="doclick2();" />
                             </div>
                            <div class="col-lg-2"></div>
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
 
	<script src="../assets/js/check.js"></script>
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
