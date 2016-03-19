<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib 
    prefix="s" uri="/struts-tags"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<s:form action="/Action/userlogin" method="post">
	<s:textfield label="用户名" name="username"></s:textfield>
	<s:password label="密码" name="password"></s:password>
	<s:submit value="提交"></s:submit>
</s:form>
</body>
</html>