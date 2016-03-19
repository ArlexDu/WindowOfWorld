<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib
    prefix="s" uri="/struts-tags"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册新的用户</title>
<link href="../../Libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src ="../../Libs/Jquery/jquery-1.12.1.js"></script>
		<script src ="../../Libs/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form id="mform" class="form-horizontal" action="<%=request.getContextPath() %>/Action/register.action" method="post">
		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-1">邮         箱:</label>
			<div class="col-sm-7">
				<input class="form-control" type="text" name="username">	
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-1">密	    码：</label>
			<div class="col-sm-7">
				<input class="form-control" type="password" name="password">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-1">确认密码：</label>
			<div class="col-sm-7">
				<input class="form-control" type="password" name="repassword">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-1">身份证号：</label>
			<div class="col-sm-7">
				<input class="form-control" type="text" name="identity_id">
			</div>
		</div>
		<div id="submit" class="form-group">
			<button type="button" class="btn btn-primary col-sm-offset-2 col-sm-8" 
			         data-loading-text="Loading...">注         册
			</button>
		</div>
    </form>
    <script type="text/javascript">
      $(function(){
    	  $("#submit .btn").click(function(){
    		  console.log("click");
    		  $(this).button('loading').delay(500).queue(function(){
    			  $("#mform").submit();
    		  });
    	  });
      });
      
    </script>
</body>
</html>