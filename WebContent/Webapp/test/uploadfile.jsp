<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File</title>
</head>
<body>
<form method="post" action="<%=path%>/android/user/changeavatar" name="upload" enctype="multipart/form-data">
<p>文件名：<input type="file" name = "uploadfile"></p>
<p><input type = "submit" value ="上传" name = "submit"></p>
</form>

</body>
</html>