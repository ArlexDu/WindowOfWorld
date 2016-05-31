<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="edu.tongji.amazing.model.*"%>
<%@ page import="edu.tongji.amazing.tool.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>WOW管理端主页</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">

    <script src="../../Webapp/assets/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<%
	if(session.getAttribute("phone")==null)
	{
		response.setCharacterEncoding("UTF-8");  
		response.sendRedirect("sign-in.jsp");
	}
	//获取用户信息
		List<String> username = new ArrayList<String>();
		List<String> userclass = new ArrayList<String>();
		List<String> userstatus = new ArrayList<String>();
		List userlist = (List)request.getAttribute("showusers");
		for(int i=0;i<userlist.size();i++) 
		{ 
		User user = (User)userlist.get(i);
		if(user.getRealname()==null)
			username.add("null");
		else
			username.add(i, user.getRealname().toString());
		if(user.getUserclass().toString().equals("2"))
			userclass.add(i, "广告商");
		else if(user.getUserclass().toString().equals("3"))
			userclass.add(i, "车主");
		else
			userclass.add(i, "管理员");
		if(user.getStatus().toString().equals("0"))
			userstatus.add(i, "未审核");
		else
			userstatus.add(i, "审核通过");
		} 
	//获取广告信息	
		List<String> ownername = new ArrayList<String>();
		List<String> adtitle = new ArrayList<String>();
		List<String> adprice = new ArrayList<String>();
		List adlist = (List)request.getAttribute("showadvertisements");
		for(int i=0;i<adlist.size();i++) 
		{ 
		ShowAdvertisement ad = (ShowAdvertisement)adlist.get(i);
		if(ad.getUsername()==null)
			ownername.add("null");
		else
			ownername.add(i, ad.getUsername().toString());
		if(ad.getTitle()==null)
			adtitle.add("null");
		else
			adtitle.add(i, ad.getTitle());
		if(ad.getPrice()==null)
			adprice.add("null");
		else
			adprice.add(i, ad.getPrice().toString());
		}
	//获取收支信息
		List<String> bownername = new ArrayList<String>();
		List<String> amount = new ArrayList<String>();
		List<String> date = new ArrayList<String>();
		List blist = (List)request.getAttribute("showbalance");
		for(int i=0;i<blist.size();i++) 
		{ 
		ShowBalance b = (ShowBalance)blist.get(i);
		if(b.getUsername()==null)
			bownername.add("null");
		else
			bownername.add(i, b.getUsername().toString());
		if(b.getMoney()==null)
			amount.add("null");
		else
			amount.add(i, b.getMoney().toString());
		if(b.getDate()==null)
			date.add("null");
		else
			date.add(i, b.getDate().toString());
		}
		System.out.println("登录手机号："+session.getAttribute("phone"));
	%>
	

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
                <a class="brand"><span class="first">WOW</span> <span class="second">世界之窗</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>用户管理<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <!--<li><a href="index.jsp">Home</a></li>-->
            <li ><a href="../../web/administator/usertable?pagenum=1">用户列表<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a></li>
       
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="../../web/administator/advertisementtable?pagenum=1">广告列表<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a></li>
            
        </ul>

        <!-- <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>事务管理 <i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="calendar.jsp">日程事务管理</a></li>
            <li ><a href="not-vetted.jsp">事务详情报表</a></li>
            <!--<li ><a href="500.jsp">500 page</a></li>
            <li ><a href="503.jsp">503 page</a></li>
        </ul> -->

        <a href="../../Webapp/admin/account.jsp" class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
		
        <!-- <a href="map.jsp" class="nav-header" ><i class="icon-comment"></i>查看地图</a>
		<a href="#legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-legal"></i>法律相关<i class="icon-chevron-up"></i></a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.jsp">隐私说明</a></li>
            <li ><a href="terms-and-conditions.jsp">服务条款</a></li>
        </ul> -->
    </div>
    

    
      <div class="content">
        
        <div class="header">
            <div class="stats">
    			<p class="stat"><span class="number"><s:property value="#request.all_user_number"/></span>总用户</p>
    			<p class="stat"><span class="number"><s:property value="#request.all_advertisement_number"/></span>总广告</p>
			</div>

            <h1 class="page-title">公示面板</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#"><span class="first">WOW</span> <span class="second">主页</a> <span class="divider">/</span></li>
            <li class="active">公示面板</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>最新公示:</strong> 有<a href="../../web/administator/usertable?pagenum=1">+<s:property value="#request.examine_user_number"/>新用户</a>与<a href="../../web/administator/advertisementtable?pagenum=1">+<s:property value="#request.examine_advertisement_number"/>新广告</a>等待处理
    </div>

<div class="row-fluid">
    <div class="block span6">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">用户<span class="label label-warning">+<s:property value="#request.examine_user_number"/></span></a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>姓名</th>
                  <th>用户类型</th>
                  <th>用户状态</th>
                </tr>
              </thead>
              <tbody>
              	<%
        			for(int i = 0 ; ( i < userlist.size() ) && ( i < 6 ) ; i++){
    			%>
            			<tr>
            				<td><%=username.get(i) %></td>
            				<td><%=userclass.get(i) %></td>
            				<td><%=userstatus.get(i) %></td>
            			</tr>
    			<%
        			}
    			%>
              </tbody>
            </table>
            <p><a href="../../web/administator/usertable?pagenum=1">More...</a></p>
        </div>
    </div>
    <div class="block span6">
        <a href="#widget1container" class="block-heading" data-toggle="collapse">广告<span class="label label-warning">+<s:property value="#request.examine_advertisement_number"/></span></a>
        <div id="widget1container" class="block-body collapse in">
            <table class="table">
              <thead>
                <tr>
                  <th>广告商姓名</th>
                  <th>广告主题</th>
                  <th>广告价格</th>
                </tr>
              </thead>
              <tbody>
                <%
        			for(int i = 0 ; ( i < adlist.size() ) && ( i < 6 ) ; i++){
    			%>
            			<tr>
            				<td><%=ownername.get(i) %></td>
            				<td><%=adtitle.get(i) %></td>
            				<td><%=adprice.get(i) %></td>
            			</tr>
    			<%
        			}
    			%>
              </tbody>
            </table>
            <p><a href="../../web/administator/advertisementtable?pagenum=1">More...</a></p>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div class="block span6">
        <div class="block-heading">
            <span class="block-icon pull-right">
                <a href="#" class="demo-cancel-click" rel="tooltip" title="Click to refresh"><i class="icon-refresh"></i></a>
            </span>

            <a href="#widget2container" data-toggle="collapse">收支</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
              <tbody>
                <%
        			for(int i = 0 ; ( i < blist.size() ) && ( i < 6 ) ; i++){
    			%>
            			<tr>
            				<td><p><i class="icon-user"></i><%=bownername.get(i) %></p></td>
            				<td>Date:<%=date.get(i) %></td>
            				<td>Amount:<%=amount.get(i) %></td>
            			</tr>
    			<%
        			}
    			%>  
              </tbody>
            </table>
        </div>
    </div>
    <!--<div class="block span6">
        <p class="block-heading" >Not Collapsible</p>
        <div class="block-body">
            <h2>Tip of the Day</h2>
            <p>Fava bean jícama seakale beetroot courgette shallot amaranth pea garbanzo carrot radicchio peanut leek pea sprouts arugula brussels sprout green bean. Spring onion broccoli chicory shallot winter purslane pumpkin gumbo cabbage squash beet greens lettuce celery. Gram zucchini swiss chard mustard burdock radish brussels sprout groundnut. Asparagus horseradish beet greens broccoli brussels sprout bitterleaf groundnut cress sweet pepper leek bok choy shallot celtuce scallion chickpea radish pea sprouts.</p>
            <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
    </div>-->
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


