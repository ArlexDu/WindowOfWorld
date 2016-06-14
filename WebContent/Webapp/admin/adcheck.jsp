<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.tongji.amazing.model.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>广告信息</title>
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
	//获取广告信息	
			List<String> ownername = new ArrayList<String>();
			List<Long> adID = new ArrayList<Long>();
			List<String> adtime = new ArrayList<String>();
			List<String> adtitle = new ArrayList<String>();
			List<String> adcon = new ArrayList<String>();
			List<String> adclassch = new ArrayList<String>();
			List<String> adclass = new ArrayList<String>();
			List<String> adprio = new ArrayList<String>();
			List<String> adprice = new ArrayList<String>();
			List<String> adstatus = new ArrayList<String>();
			Set<AdvertisementPlaceAndTime> tpset = new HashSet<AdvertisementPlaceAndTime>();
			Advertisement ad = (Advertisement)request.getAttribute("advertisement");
	
			adID.add( ad.getId());
			
			if(ad.getPhone()==null)
				ownername.add( "null");
			else
				ownername.add( ad.getPhone().toString());
			
			
			
			if(ad.getTitle()==null)
				adtitle.add( "null");
			else
				adtitle.add( ad.getTitle().toString());
			
			if(ad.getContent()==null)
				adcon.add( "null");
			else
				adcon.add( ad.getContent().toString());
			
			if(ad.getAdvertisementclass()==null)
			{
				adclassch.add( "null");
				adclass.add( "null");
			}
			else if(ad.getAdvertisementclass().equals("0"))
			{
				adclassch.add("0");
				adclass.add( "文字");
			}
			else
			{
				adclassch.add("1");
				adclass.add( "图片");
			}
			
			
			
			if(ad.getPrice()==null)
				adprice.add( "null");
			else
				adprice.add( ad.getPrice().toString());
			
			if(ad.getStatus()==null)
				adstatus.add( "0");
			else
				adstatus.add( ad.getStatus().toString());
			
			tpset = ad.getPlaceandtime();
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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../../Webapp/assets/ico/favicon.ico">
	<%
String path = request.getContextPath();
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
        

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>用户管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse">
            <li ><a href="../../web/administator/usertable?pagenum=1">用户列表</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理</a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="../../web/administator/advertisementtable?pagenum=<%=session.getAttribute("pagenum1")%>">广告列表</a></li>
        </ul>

        <a href="../../Webapp/admin/account.jsp" class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
		
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">广告信息</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#" onclick="javascript:document.formtohome.submit();">主页</a> <span class="divider">/</span></li>
            <li><a href="../../web/administator/advertisementtable?pagenum=<%=session.getAttribute("pagenum1")%>">广告列表</a> <span class="divider">/</span></li>
            <li class="active">广告信息</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
  <form name="formtohome" action="<%=path%>/web/administator/login" method="post" >
<input name="phone" type="hidden" value="<%=session.getAttribute("phone") %>">
<input name="password" type="hidden" value="<%=session.getAttribute("password") %>">
</form>
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">广告信息</a></li>
      <li><a href="#profile" data-toggle="tab">投放详情</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
    <div class="tab-pane active in" id="home">
      <div class="span6">
		<label>广告商手机号</label>
        <input type="text" value=<%=ownername.get(0) %> class="input-xlarge">
        
        <label>广告价格</label>
        <input type="text" value=<%=adprice.get(0) %> class="input-xlarge"> 
        <label>广告类型</label>
        <input type="text" value=<%=adclass.get(0) %> class="input-xlarge">
      </div >
	  <div class="span6">
	  
        <label>广告主题</label>
        <input type="text" value=<%=adtitle.get(0) %> class="input-xlarge">
        <label>详情</label>
        <%
        	if(adclassch.get(0).equals("null"))
        	{
        %>
        <input type="text" value=<%=adcon.get(0) %> class="input-xlarge">
        <%		
        	}
        	else if(adclassch.get(0).equals("0"))//文字类型
        	{
        %>
        <input type="text" value=<%=adcon.get(0) %> class="input-xlarge">
        <%
        	}
        	else if(adclassch.get(0).equals("1"))//图片类型
        	{
        %>
        <a id="example1-1" title="" href="#guanggao" data-toggle="modal"><img alt="" src=<%=adcon.get(0) %>  style="width:250px;"/></a>
        <%
        	}
        	else
        	{
        %>
         <input type="text" value="null" class="input-xlarge">
         <%
        	}
         %>
	  </div>
  	</div>
	<div class="tab-pane fade" id="profile">
    <form id="tab2">
        <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>广告开始时间</th>
          <th>广告结束时间</th>
          <th>广告投放经度</th>
		  <th>广告投放纬度</th>
		  <th>广告投放地点</th>
        </tr>
      </thead>
      <tbody>
        <%
        			int i = 0;
        			String longtitude="null",latitude="null",place="null";
        			for(Iterator<AdvertisementPlaceAndTime> iter = tpset.iterator();iter.hasNext();)
        			{
        				AdvertisementPlaceAndTime tp = iter.next();
        				if(tp.getLongtitude()!=null)
        					longtitude=tp.getLongtitude();
        				if(tp.getLatitude()!=null)
        					latitude=tp.getLatitude();
        				if(tp.getPlace()!=null)
        					place=tp.getPlace();
        				
    			%>
            			<tr>
            				<td><%=i+1 %></td>
            				<td><%=tp.getBegin_time().toString() %></td>
            				<td><%=tp.getEnd_time().toString() %></td>
            				<td><%=longtitude %></td>
             				<td><%=latitude %></td>
            				<td><%=place %></td>
            			</tr>
    			<%
					i=i+1;
    				longtitude="null";
    				latitude="null";
    				place="null";
    			}
    			%>
      </tbody>
    </table>
    </form>
      </div>
	</div>             
                    <footer>
                        <hr>
                        
                    </footer>
<%
	if(adstatus.get(0).equals("0"))
	{
%>
 <table>
<tr>
<td>
<form name="form1" action="<%=path%>/web/administator/examineadvertisement">

	<input type="hidden" name="phone" value=<%=ownername.get(0) %>>
	<input type="hidden" name="result" value="1">
	<input type="hidden" name="id" value=<%=adID.get(0) %>>
	<input type="hidden" name="title" value=<%=adtitle.get(0) %>>
	<button class="btn btn-primary" onClick="javascript:document.forms1.submit();"><i class="icon-ok"></i> 通过</button>

</form>
</td>
<td>
<form name="form2" action="<%=path%>/web/administator/examineadvertisement">

	<input type="hidden" name="phone" value=<%=ownername.get(0) %>>
	<input type="hidden" name="result" value="-1">
	<input type="hidden" name="userclass" value=<%=adID.get(0) %>>
	<input type="hidden" name="title" value=<%=adtitle.get(0) %>>
	<button class="btn btn-primary" onClick="javascript:document.forms1.submit();"><i class="icon-remove"></i> 不通过</button>

</form>
</td>
</tr>
</table>
<% 
	}
	else
	{
%>
	<div>
	<table>
	<tr>
	<td>
		<button class="btn btn-primary" onclick="window.location = '../../web/administator/advertisementtable?pagenum=<%=session.getAttribute("pagenum1")%>';">确认</button>
	</td>
	</tr>
	</table>
	</div>
<%
	}
%>                   
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="guanggao" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <img class="img-responsive img-centered" src=<%=adcon.get(0) %> alt="" >
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


