<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="edu.tongji.amazing.model.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>广告商用户信息查看</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<%
	if(session.getAttribute("phone")==null)
	{
		response.setCharacterEncoding("UTF-8");  
		response.sendRedirect("sign-in.jsp");
	}
	//获取用户信息
			List<String> username = new ArrayList<String>();
	  		List<String> userIDcard = new ArrayList<String>();
	  		List<String> userIDcardpic = new ArrayList<String>();
	  		List<String> userphone = new ArrayList<String>();
			List<String> userlicense = new ArrayList<String>();
			List<String> userlicensepic = new ArrayList<String>();

			Advertiser userlist = (Advertiser)request.getAttribute("userinfo");
			System.out.println("获取用户成功");
			if(userlist.getUser().getIdentityCard()==null)
				userIDcardpic.add("null");
			else
				userIDcardpic.add( userlist.getUser().getIdentityCard());
			if(userlist.getUser().getRealname()==null)
				username.add( "null");
			else
				username.add( userlist.getUser().getRealname().toString());
			if(userlist.getUser().getIdentity()==null)
				userIDcard.add( "null");
			else
				userIDcard.add( userlist.getUser().getIdentity().toString());
			if(userlist.getPhone()==null)
				userphone.add( "null");
			else
				userphone.add( userlist.getPhone());
			if(userlist.getLicense()==null)
				userlicense.add( "null");
			else
				userlicense.add( userlist.getLicense());
			if(userlist.getLicensecard()==null)
				userlicensepic.add( "null");
			else
				userlicensepic.add( userlist.getLicensecard().toString());
		
	%>
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">

    <script src="../../Webapp/assets/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	
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
    <%
String path = request.getContextPath();
%>
  </head>

  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> 超级管理员
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../../Webapp/admin/sign-in.jsp">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="#" onclick="javascript:document.formtohome.submit();"><span class="first">WOW</span> <span class="second">世界之窗</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
       

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>用户管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <!--<li><a href="index.jsp">Home</a></li>-->
            <li ><a href="../../web/administator/usertable?pagenum=<%=session.getAttribute("pagenum")%>">用户列表</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="../../web/administator/usertable?pagenum=1">广告列表</a></li>
        </ul>

        <a href="../../Webapp/account.jsp" class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">用户信息查看</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#" onclick="javascript:document.formtohome.submit();">主页</a> <span class="divider">/</span></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=session.getAttribute("pagenum")%>">用户列表</a> <span class="divider">/</span></li>
            <li class="active">用户信息</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
<form name="formtohome" action="<%=path%>/web/administator/login" method="post" >
<input name="phone" type="hidden" value="<%=session.getAttribute("phone") %>">
<input name="password" type="hidden" value="<%=session.getAttribute("password") %>">
</form>
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">简介</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="span6">
        <label>姓名</label>
        <input type="text" value=<%=username.get(0) %> class="input-xlarge">
        <label>身份证号</label>
        <input type="text" value=<%=userIDcard.get(0) %> class="input-xlarge">
		<label>身份证照</label>
		<a id="example1-1" title="" href="#IDcard" data-toggle="modal"><img alt="" src=<%=userIDcardpic.get(0) %>  style="width:250px;"/></a>
      </div>
	  <div class="span6">
	  <label>手机号</label>
        <input type="text" value=<%=userphone.get(0) %> class="input-xlarge">
        <label>营业执照注册号</label>
        <input type="text" value=<%=userlicense.get(0) %> class="input-xlarge">
       <label>营业执照</label>
       <a id="example1-1" title="" href="#jiazhao" data-toggle="modal"><img alt="" src="<%=userlicensepic.get(0) %>"  style="width:250px;"/></a>
	   <!-- <a id="example1-1" title="" href="#jiazhao" data-toggle="modal"><img alt="" src="../../Webapp/assets/images/jiazhao.jpg"  style="width:250px;"/></a> -->
	  </div>
  </div>

</div>
<div>
<table>
<tr>
<td>
	<button class="btn btn-primary" onclick="window.location = '../../web/administator/usertable?pagenum=<%=session.getAttribute("pagenum")%>';">确认</button>
</td>
</tr>
</table>
</div>


                    
                    <footer>
                        <hr>
                        
                    </footer>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="IDcard" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <img class="img-responsive img-centered" src=<%=userIDcardpic.get(0) %> alt="">
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="jiazhao" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <img class="img-responsive img-centered" src="<%=userlicensepic.get(0) %>" alt="">
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


