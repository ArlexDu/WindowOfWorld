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
    <link href="../assets/css/new.css" rel="stylesheet">
</head>

<body id="page-top" class="index">
    <!-- 菜单栏-->
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
                        <a class="page-scroll" href="upload.jsp">上传广告</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp" id="logoff">退出</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#AppModal" data-toggle="modal">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Hello!XXX</div>
                <div class="intro-heading">欢迎进入个人主页</div>
            </div>
        </div>
    </header>
    
    <!-- 个人信息 -->
    <section id="about">
    	<div class="container">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">个人信息</h2>
                    <h3 class="section-subheading text-muted"></h3>
                </div>
            <div class="row">
                <div class="col-lg-3">
                	<label>
              	    <img id="portrait1" src="">
              	    </label>	
                </div>
                <div class="col-lg-9">
                	<table class="table table-hover account">
                    <tr><td style="width:40%;">公司名称</td><td id="username" style="width:60%;" colspan="2"></td></tr>
                    <tr><td>法人姓名</td><td id="realname" colspan="2"></td></tr>
                    <tr><td>账户余额</td><td id="money" style="width:460px;"></td>
                    <td class="addmoneytd" style="width:40px;"><span class="glyphicon glyphicon-yen addmoney" data-toggle="modal" data-target="#myModal"></span></td></tr>
                    <tr><td>联系电话</td><td id="phone" colspan="2"></td></tr>
                    <tr><td>联系邮箱</td><td id="email" colspan="2"></td></tr>
                    </table>
                </div>
            </div>
        </div>
        <!-- 广告罗列 -->
        <div class="row account-ad-show">
            <hr>
        	<div class="col-lg-12 text-center">
                    <h2 class="section-heading">最新广告</h2>
            </div>
            <div class="col-lg-12 shijian">
            	<div class="col-lg-6">
	                <ul class="timeline ad_time" id="shijiantiao">
	                </ul>
                </div>
                <div class="col-lg-6">
                	<ul class="timeline ad_time" id="shijiantiao1">
	                </ul>
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
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
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
    
    <!-- 1 -->
    <div class="portfolio-modal modal fade" id="adModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
             <div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>广告详细信息</h2>
                         <table class="table table-hover table-bordered">
                         <tr><th>广告编号</th><td id="ad_num"></td></tr>
                         <tr><th>广告标题</th><td id="ad_title"></td></tr>
                 	     <tr><th>广告内容</th><td id="ad_co"></td></tr>
                 	     <tr><th>广告状态</th><td id="ad_status"></td></tr>
                 	     <tr><th>广告费用</th><td id="ad_fare">0</td></tr>
                         <tr><th>广告发布时段</th><td id="ad_time"></td>
                         </tr>
                         <tr><th>广告发布地段</th><td id="ad_diduan"></td>
                         </tr>
                         </table>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
             </div>
        </div>
    </div>
    
    <!--充钱模态框 -->
	<div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:30%">
			    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">请输入金额</h4>
				      </div>
				      <div class="modal-body">
				        <div class="input-group">
						  <span class="input-group-addon">$</span>
						  <input id="money_input" type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
						  <span class="input-group-addon">.00</span>
					  	</div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
				        <button type="button" class="btn btn-default" id="modal_finish">确 认</button>
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
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script>

function logoff() {
    eraseCookie("userphone");
}
function eraseCookie(name) {
    createCookie(name,"",-1);
}
function createCookie(name,value,hours) {
    if (hours) {
        var date = new Date();
        date.setTime(date.getTime()+(hours*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/AmazingAd/Webapp/wow";
}
function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

window.onload = function () {
 var phone=readCookie('userphone'); 
 
    console.log("phone",phone);
    
    $('#modal_finish').click(function () {
        var x = $('#money_input').val();
        $.get("http://localhost:8080/AmazingAd/web/advertiser/charge?phone="+ phone +"&charge=" +x);
       
        $('#myModal').modal('hide');
        location.reload(true);
      });
    
    if(phone!=null){
    	$("div.intro-lead-in").text("Hello "+phone);
    	$.ajax({
            type: "POST",
            url : "/AmazingAd/web/advertiser/getuserinfo",
            data : {
	            	phone:phone,
            		},
            success: function(response){
             	var result = JSON.stringify(response, null, 3);    
            	data =(new Function("","return "+result))();
            	console.log(data);
            	if(data.errCode==1){
            		console.log("userinfo",data.userinfo);
//             		document.getElementById("portrait1").src=data.userinfo.user.avatar;
					$("#portrait1").attr("src",data.userinfo.user.avatar);
            		document.getElementById("username").innerHTML=data.userinfo.user.username;
            		document.getElementById("realname").innerHTML=data.userinfo.user.realname;
            		document.getElementById("money").innerHTML=data.userinfo.user.balace;
            		document.getElementById("phone").innerHTML=data.userinfo.user.phone;
            		document.getElementById("email").innerHTML=data.userinfo.mail;
            	}else{
            		//wrong
            		window.location.href="/AmazingAd/Webapp/wow/login.jsp"
            	}
            },
            error:function(){
            	window.location.href="/AmazingAd/Webapp/wow/login.jsp"
            }
        });
    	
    	var ad_data;
    	
    	$.ajax({
            type: "GET",
            url : "/AmazingAd/web/advertiser/getallads?phone="+phone,
            success: function(response){
            	var result = JSON.stringify(response, null, 3);    
            	ad_data =(new Function("","return "+result))();
            	console.log(ad_data);
            	var ad_size=ad_data.adList.length;
            	var i;
            	for(i=0;i<ad_size;i++){
					var li = "<li class='timeline-inverted'>"+
							 "<div class='timeline-image' onclick='ad_more("+i+");'>"+
							 "<img class='img-circle img-responsive' src='../assets/images/about/4.jpg' alt='''>"+
							 "</div>"+
							 "<div class='timeline-panel'>"+
							 "<div class='timeline-heading'><h4 id='title"+i+"'></h4></div>"+
							 "<div class='timeline-body'><p class='text-muted' id='context"+i+"'></p></div>"+
							 "<div class='nosee'><p id='id"+i+"'></p><p id='status"+i+"'></p><p id='placeandtime"+i+"'></p></div>"+
							 "</div></li>";
					if(i%2==0){
						$("#shijiantiao").append(li);
					}else{
						$("#shijiantiao1").append(li);}
            		eval("document.getElementById('title"+i+"').innerHTML=ad_data.adList["+i+"].title");
            		eval("document.getElementById('id"+i+"').innerHTML=ad_data.adList["+i+"].id");
            		eval("document.getElementById('context"+i+"').innerHTML=ad_data.adList["+i+"].content");
            		eval("document.getElementById('status"+i+"').innerHTML=ad_data.adList["+i+"].status");
            	}
            },
            error:function(){
            	//window.location.href="/AmazingAd/Webapp/wow/login.jsp"
            }
        });
    }
}

$("#logoff").click(function(){
	logoff();
});

function ad_more(a){		//单个广告详细信息
	var b = a;
	$('#adModal').modal('show');
	var ad_num = document.getElementById("id"+b).innerHTML;
	var ad_title = document.getElementById("title"+b).innerHTML;
 	var ad_co = document.getElementById("context"+b).innerHTML;
 	var ad_status = document.getElementById("status"+b).innerHTML;
	$("#ad_num").html(ad_num);
	$("#ad_title").html(ad_title);
  	$("#ad_co").text(ad_co);
	$("#ad_status").html(ad_status);
// 	$("#ad_time").text(ad_data.adList[a].id);
// 	$("#ad_diduan").text(ad_data.adList[a].id);
}

</script>
</body>




</html>
