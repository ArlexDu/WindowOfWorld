<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../assets/js/jquery.js"></script>
<script>
	
	$(document).ready(function() {
		
		$('.buttonhello').click(function() {
			$.ajax({
				type:"post",
				url:"/AmazingAd/web/adowner/register",
				success:function(response){
					$('.result').html(response);
					
				}
			})
		})
		
	}		
	)

	
</script>
</head>
<body>
	<form action="">
		<input type="button" value="hello" class="buttonhello">
		<br/>
		<div class="result"></div>
	</form>
</body>
</html>