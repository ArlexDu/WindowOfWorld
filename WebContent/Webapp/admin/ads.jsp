<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="edu.tongji.amazing.model.*"%>
<%@ page import="edu.tongji.amazing.tool.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>广告列表</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<s:action name="gethomedata" namespace="/web/administator"></s:action>
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">
	<%
	if(session.getAttribute("phone")==null)
	{
		response.setCharacterEncoding("UTF-8");  
		response.sendRedirect("sign-in.jsp");
	}
	String path = request.getContextPath();%>
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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../../Webapp/assets/ico/favicon.ico">
    <%
	//获取广告信息	
			List<String> ownername = new ArrayList<String>();
    		List<Long> adid = new ArrayList<Long>();
			List<String> adtitle = new ArrayList<String>();
			List<String> adtime = new ArrayList<String>();
			List<String> adstatus = new ArrayList<String>();
			List<String> adprice = new ArrayList<String>();
			List adlist = (List)request.getAttribute("advertisements");
			for(int i=0;i<adlist.size();i++) 
			{ 
			ShowAdvertisement ad = (ShowAdvertisement)adlist.get(i);
			if(ad.getId()==null)
				adid.add(i, 9999L);
			else
				adid.add(i, ad.getId());
			if(ad.getTitle()==null)
				adtitle.add(i, "null");
			else
				adtitle.add(i, ad.getTitle().toString());
			if(ad.getUsername()==null)
				ownername.add(i, "null");
			else
				ownername.add(i, ad.getUsername().toString());
			if(ad.getDate()==null)
				adtime.add(i, "null");
			else
				adtime.add(i, ad.getDate().toString());
			if(ad.getPrice()==null)
				adprice.add(i, "null");
			else
				adprice.add(i, ad.getPrice().toString());
			if(ad.getStatus()==null)
				adstatus.add(i, "null");
			else if(ad.getStatus().toString().equals("0"))
				adstatus.add(i, "未审核");
			else
				adstatus.add(i, "审核通过");
			}
	%>
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <!--<li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>-->
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
        
        

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>用户管理<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a>
        <ul id="dashboard-menu" class="nav nav-list collapse">
            <!--<li><a href="index.jsp">Home</a></li>-->
            <li ><a href="../../web/administator/usertable?pagenum=1">用户列表<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a >广告列表<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a></li>
        </ul>

        <a href="../../Webapp/admin/account.jsp" class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
		
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">广告列表</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#" onclick="javascript:document.formtohome.submit();">主页</a> <span class="divider">/</span></li>
            <li class="active">广告列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <!-- <button class="btn">导出</button> -->
  <div class="btn-group">
  </div>
  <form name="formtohome" action="<%=path%>/web/administator/login" method="post" >
<input name="phone" type="hidden" value="<%=session.getAttribute("phone") %>">
<input name="password" type="hidden" value="<%=session.getAttribute("password") %>">
</form>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>广告商姓名</th>
          <th>广告发布时间</th>
          <th>广告主题</th>
		  <th>广告状态</th>
		  <th>广告价格</th>
          <th style="width: 92px;"></th>
        </tr>
      </thead>
      <tbody>
        <%
        			int i = 0;
        			for( ;  i < adlist.size()  ; i++){
    			%>
            			<tr>
            			<form id="form<%=i %>"action="<%=path%>/web/administator/advertisement" method="post">
            				<td><%=i+1 %></td>
            				<td><%=ownername.get(i) %></td>
            				<td><%=adtime.get(i) %></td>
            				<td><%=adtitle.get(i) %></td>
             				<td><%=adstatus.get(i) %></td>
            				<td><%=adprice.get(i) %></td>
            				<input type="hidden" name="id" value=<%=adid.get(i) %>>
            				<td>
            				<%
        						if(adstatus.get(i).equals("未审核"))
        								{
    						%>
		      					<button class="btn btn-link"  style=" color:red" OnClick="javascript:document.forms[<%=i %>].submit();"><i class="icon-search"></i> 审核</button>
		      				<%} 
		      				else
		      				{%>
		      					<button class="btn btn-link" OnClick="javascript:document.forms[<%=i %>].submit();"><i class="icon-eye-open"></i> 查看</button>
		      				<%}%>
          					</td>
          				</form>	
            			</tr>
    			<%
					}
    			%>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <%
    	int pagenow = Integer.parseInt(session.getAttribute("pagenum1").toString());
    	int totaluser = Integer.parseInt(request.getAttribute("all_advertisement_number").toString());
    	int totalpage = ((totaluser/10)+1);
    	if(totalpage!=1)
    	{
    	if(pagenow==1)
    	{
    	
    	%>
        <li><a style="color:black;" >首页</a></li>
        <li><a style="color:black;" >1</a></li>
        <li><a href="../../web/administator/advertisementtable?pagenum=2">2</a></li>
        <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow+1%>">下一页</a></li>
        <li><a href="../../web/administator/advertisementtable?pagenum=<%=totalpage%>">末页</a></li>
        <%
    	}
    	else if(pagenow==totalpage)
    	{
    		%>
            <li><a href="../../web/administator/advertisementtable?pagenum=1">首页</a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow-1%>">上一页</a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow-1 %>"><%=pagenow-1 %></a></li>
            <li><a style="color:black;"><%=pagenow %></a></li>
            <li><a style="color:black;">末页</a></li>
            <%	
    	}
    	else
    	{
    		%>
            <li><a href="../../web/administator/advertisementtable?pagenum=1">首页</a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow-1%>">上一页</a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow-1 %>"><%=pagenow-1 %></a></li>
            <li><a style="color:black;"><%=pagenow %></a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow+1 %>"><%=pagenow+1 %></a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=pagenow+1%>">下一页</a></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=totalpage%>">末页</a></li>
            <%
    	}
    	}
        %>
    </ul>
</div>

                    
                    <footer>
                        <hr>
                        
                    </footer>
                    
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
