<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WOW添加广告</title>
    <link rel="stylesheet" href="../../Libs/bootstrap/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
	<h1>添加广告</h1>
	<hr/>
	<form action="addAdP" method="post">
		<div class="form-group" >
			<label for="identity">发布者身份证号</label>
			<input id="identity" name="identity" />
		</div>
		<div class="form-group" >
			<label for="begin_time">开始时间</label>
			<input id="begin_time" name="begin_time" />
		</div>
		<div class="form-group" >
			<label for="end_time">结束时间</label>
			<input id="end_time" name="end_time" />
		</div>
		<div class="form-group" >
			<label for="place">地点</label>
			<input id="place" name="place" />
		</div>
		<div class="form-group" >
			<label for="price">价格</label>
			<input id="price" name="price" />
		</div>
		<div class="form-group" >
			<label for="priority">优先级</label>
			<input id="priority" name="priority" />
		</div>
		<div class="form-group" >
			<label for="time">时间</label>
			<input id="time" name="time" />
		</div>
		<div class="form-group" >
			<label for="status">状态</label>
			<input id="status" name="status" />
		</div>
		<div class="form-group" >
			<label for="content">内容</label>
			<input id="content" name="content" />
		</div>
		
		<div class="form-group">
            <button type="submit" class="btn btn-sm btn-success" >提交</button>
        </div>
	</form>
</div>

<script src="../../Libs/Jquery/jquery-1.12.1.js" ></script>
<script src="../../Libs/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>