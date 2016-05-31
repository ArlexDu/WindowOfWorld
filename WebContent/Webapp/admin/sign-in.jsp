<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">

    <script src="../../Webapp/assets/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="../../Webapp/assets/js/jquery.cookie.js" type="text/javascript"></script>
	<%
String path = request.getContextPath();
%>
	<script type="text/javascript">
	
//初始化页面时验证是否记住了密码
$(document).ready(function() {
    if ($.cookie("rmbPhone") == "true") {
    	console.log("记住密码");
        $("#rmbPhone").attr("checked", true);
        $("#phone").val($.cookie("Phone"));
        $("#password").val($.cookie("passWord"));
    }
    else
    	console.log("未记住密码");
});


function saveUserInfo() {
    if ($("#rmbPhone").prop("checked") == true) {
    	console.log("勾选");
        var Phone = $("#phone").val();
        var passWord = $("#password").val();
        $.cookie("rmbPhone", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
        $.cookie("Phone", Phone, { expires: 7 }); // 存储一个带7天期限的 cookie
        $.cookie("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
    }
    else {
    	console.log("未勾选");
        $.cookie("rmbPhone", "false", { expires: -1 });        // 删除 cookie
        $.cookie("Phone", '', { expires: -1 });
        $.cookie("passWord", '', { expires: -1 });
    }
}

function check()//全检验
{
	
	if(phonecheck()=="1"&&pswcheck()=="1")
		{
			return true;
		}
	else
		{
			return false;
		}
}
function pswcheck()//密码检验
{
	$("#pswinfo").show()
	  if($("#password").val()==""){
	    $("#pswinfo").text("密码不能为空");
	    return 2;
	  }
	  else{
		 $("#pswinfo").hide()
		 return 1;
	  }
}
function phonecheck()//手机号检验
{
	$("#phoneinfo").show()
	  if($("#phone").val()==""){
	    $("#phoneinfo").text("手机号不能为空");
	    return 2;
	  }
	  else{
		 $("#phoneinfo").hide();
		 return 1;
	  }
}
</script>
	
    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    
    <link rel="shortcut icon" href="../../Webapp/assets/ico/favicon.ico">
  </head>

  
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand"><span class="first">WOW</span> <span class="second">世界之窗</span></a>
        </div>
    </div>
    


    

    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">登录</p>
            <div class="block-body">
                <form  action="<%=path%>/web/administator/login" method="post">
                    <label>手机号</label>
                    <input type="text" name="phone" id="phone" class="span12">
                    <div id="phoneinfo" style="height:20px;color:red;display:none;"></div>
                    <label>密码</label>
                    <input type="password" name="password" id="password" class="span12">
					<div id="pswinfo" style="height:20px;color:red;display:none;"></div>
                    <input type="submit" class="btn btn-primary pull-right" value="登录" onclick="saveUserInfo();return check();">
                    <label class="remember-me"><input type="checkbox"  checked="true" name="chkRememberPhone" class="checkbox" id="rmbPhone"> 记住手机号及密码</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
		<p><a href="../../Webapp/admin/sign-up.jsp" class="pull-right">还未注册？</a></p>
    </div>
</div>


    


    <script src="../../Webapp/assets/bootstrap-v2.1.1/js/bootstrap.min.js"></script>
    
    
  </body>
</html>


