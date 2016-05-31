<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>注册界面</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">

    <script src="../../Webapp/assets/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <!-- Demo page code -->
	<%
String path = request.getContextPath();
%>
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
    
    <script type="text/javascript">
	
	
	function check()//全检验
	{
		if(namecheck()=="1"&&phonecheck()=="1"&&IDcardcheck()=="1"&&IDcheck()=="1"&&pswcheck()=="1")
			{
				return true;
			}
		else
			{
				return false;
			}
	}
	function namecheck()//姓名检验
	{
		$("#nameinfo").show()
		  var reg = /^[\u4e00-\u9fa5]{0,}$/
		  if($("#name").val()==""){
		    $("#nameinfo").text("姓名不能为空");
		    return 2;
		  }
		  else if(!reg.test($("#name").val())){
		     $("#nameinfo").text("姓名必须为汉字");
		     return 2;
		  }
		  else{
			 $("#nameinfo").hide()
			 return 1;
		  }
	}
	function phonecheck()//手机号检验
	{
		$("#phoneinfo").show()
		  var reg = /^1\d{10}$/
		  if($("#phone").val()==""){
		    $("#phoneinfo").text("手机号不能为空");
		    return 2;
		  }
		  else if(!reg.test($("#phone").val())){
		     $("#phoneinfo").text("手机号格式不正确");
		     return 2;
		  }
		  else{
			 $("#phoneinfo").hide();
			 return 1;
		  }
	}
	function IDcardcheck()//身份证检验
	{
		$("#IDcardinfo").show()
		  var reg = /^\d{15}|\d{18}$/
		  if($("#IDcard").val()==""){
		    $("#IDcardinfo").text("身份证不能为空");
		    return 2;
		  }
		  else if(!reg.test($("#IDcard").val())){
		     $("#IDcardinfo").text("身份证格式不正确");
		     return 2;
		  }
		  else{
			 $("#IDcardinfo").hide();
			 return 1;
		  }
	}
	function IDcheck()//账号检验
	{
		$("#IDinfo").show()
		  var reg = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/
		  if($("#ID").val()==""){
		    $("#IDinfo").text("账号不能为空");
		    return 2;
		  }
		  else if(!reg.test($("#ID").val())){
		     $("#IDinfo").text("账号格式不正确[字母开头,5-16位,允许字母数字下划线]");
		     return 2;
		  }
		  else{
			 $("#IDinfo").hide();
			 return 1;
		  }
	}
	function pswcheck()//密码检验
	{
		$("#pswinfo").show()
		  var reg = /[a-zA-Z0-9]\w{4,15}$/
		  if($("#psw").val()==""){
		    $("#pswinfo").text("密码不能为空");
		    return 2;
		  }
		  else if(!reg.test($("#psw").val())){
		     $("#pswinfo").text("密码格式不正确[5-16位,允许字母数字]");
		     return 2;
		  }
		  else{
			 $("#pswinfo").hide()
			 return 1;
		  }
	}
	</script>
    
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
            <p class="block-heading">注册</p>
            <div class="block-body">
                <form action="<%=path%>/web/administator/register" enctype="multipart/form-data" method="post">
                    <label>姓名</label>
                    <input name="realname" id="name" type="text" class="span12" onblur="namecheck()">
                    <div id="nameinfo" style="height:20px;color:red;display:none;"></div>
                    <label>手机号</label>
                    <input name="phone" id="phone" type="text" class="span12" onblur="phonecheck()">
                    <div id="phoneinfo" style="height:20px;color:red;display:none;"></div>
                    <label>身份证号码</label>
                    <input name="identity" id="IDcard" type="text" class="span12" onblur="IDcardcheck()">
                    <div id="IDcardinfo" style="height:20px;color:red;display:none;"></div>
                    <label>身份证照片</label>
                    <div class="uploader white">
    					
    					<input name="identityCard" type="file" size="30" accept="image/*"/>
					</div>
                    <label>账号</label>
                    <input name="username" id="ID" type="text" class="span12" onblur="IDcheck()">
                    <div id="IDinfo" style="height:20px;color:red;display:none;"></div>
                    <label>密码</label>
                    <input name="password" id="psw" type="password" class="span12" onblur="pswcheck()">
                    <div id="pswinfo" style="height:20px;color:red;display:none;"></div>
                    <input type="submit" class="btn btn-primary pull-right" value="注册" onclick="return check();">
                    
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        
    </div>
</div>


    

    <script src="../../Webapp/assets/bootstrap-v2.1.1/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


