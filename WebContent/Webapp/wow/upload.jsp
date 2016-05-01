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
    <link href="../assets/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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

    <!--标题栏-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="#">上传广告</a>
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
        </div>
    </nav>
  
    <!-- 上传部分 -->
    <section id="contact">
        <div class="container">
             <form name="upload" id="upload" method="post">
                 <div class="col-lg-12 reg_font">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                    	<div class="ad1">
	                    <div class="form-group">
	                    	<label>上传内容类型选择：</label>
	                       	<span class="label label-success adtype" onclick="adtype1();">文字</span>
	                       	<span class="label label-success adtype" onclick="adtype2();">图片</span>
	                    </div>
	                    <div class="adtype1">
	                    <div class="form-group">
	                         <textarea class="form-control" placeholder="广告内容" name="context" required></textarea>
	                    </div>
	                    </div>
	                    <div class="adtype2">
                       	     <img id="ad_picture" src="/AmazingAd/Webapp/assets/images/ad_back.jpg">
                       	     <br>
                             <label class="ad_picture">本地选取
                             <input class="avatar" accept="image/gif, image/jpeg, image/x-png" type="file" name="ad_picture" onchange="showPreview_ad(this)" />
                             </label>
					 	</div>
					 	<div class="form-group">&nbsp;</div>
						<div class="form-group">
						    <label class="control-label">发布日期</label>
						    <input id="datetimepicker" class="form-control" type="text" name="begin-date" value="2016-5-1" onclick="date();">
						</div>
						<div class="form-group">
						    <label>结束日期</label>
						    <input id="datetimepicker1" class="form-control" type="text" name="end-date" value="2016-5-1" onclick="date1();">
						</div>
					    </div>
					    <div class="ad2">
					    <div class="form-group">
					   		<label>发布时段</label>
					    	<select class="form-control" name="time">
								<option value="6:00~8:00">6:00~8:00</option>
								<option value="8:00~10:00">8:00~10:00</option>
								<option value="10:00~12:00">10:00~12:00</option>
								<option value="12:00~14:00">12:00~14:00</option>
								<option value="14:00~16:00">14:00~16:00</option>
								<option value="16:00~18:00">16:00~18:00</option>
								<option value="18:00~20:00">18:00~20:00</option>
								<option value="20:00~22:00">20:00~22:00</option>
								<option value="22:00~6:00">22:00~6:00</option>
							</select>
					    </div>
					    <div class="form-group">
					   		<label>发布地段</label>
					    	<select class="form-control" name="area">
								<option value="嘉定区">嘉定区</option>
								<option value="杨浦区">杨浦区</option>
								<option value="浦东新区">浦东新区</option>
								<option value="宝山">宝山</option>
								<option value="闵行">闵行</option>
								<option value="奉贤">奉贤</option>
								<option value="金山">金山</option>
								<option value="黄埔">黄埔</option>
								<option value="静安">静安</option>
								<option value="长宁">长宁</option>
								<option value="松江">松江</option>
								<option value="虹口">虹口</option>
								<option value="普陀">普陀</option>
								<option value="徐汇">徐汇</option>
								<option value="青浦">青浦</option>
							</select>
					    </div>
					    </div>
                    </div>
                    <div class="col-lg-3">
                    	<div class="ad_change">
	                  	    <span class="glyphicon glyphicon-chevron-up" id="ad_change1" onclick="ad_change1();"></span>
	                  	    <span class="glyphicon glyphicon-chevron-down" id="ad_change2" onclick="ad_change2();"></span>
                   	    </div>
                    </div>   
                 </div>
                 <div class="col-lg-12">
                      <div class="col-lg-4"></div>
                      <div class="col-lg-4">
                      	  <input type="submit" class="btn btn-xl" value="上传">
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
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
 
</body>

</html>
