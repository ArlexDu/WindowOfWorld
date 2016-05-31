<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="edu.tongji.amazing.model.User"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>用户列表</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<s:action name="gethomedata" namespace="/web/administator"></s:action>

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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../../Webapp/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../../Webapp/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../../Webapp/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../../Webapp/assets/ico/apple-touch-icon-57-precomposed.png">
    <%
    if(session.getAttribute("phone")==null)
	{
		response.setCharacterEncoding("UTF-8");  
		response.sendRedirect("sign-in.jsp");
	}
    	String path = request.getContextPath();
    %>
	
  </head>

  <body class="">
  
  <%
	//获取用户信息
		List<String> username = new ArrayList<String>();
  		List<String> userIDcard = new ArrayList<String>();
  		List<String> userphone = new ArrayList<String>();
		List<String> userclass = new ArrayList<String>();
		List<String> userclassch = new ArrayList<String>();
		List<String> userstatus = new ArrayList<String>();
		List<String> userstatusch = new ArrayList<String>();
		List userlist = (List)request.getAttribute("users");
		for(int i=0;i<userlist.size();i++) 
		{ 
		User user = (User)userlist.get(i);
		if(user.getRealname()==null)
			username.add(i, "null");
		else
			username.add(i, user.getRealname().toString());
		if(user.getIdentity()==null)
			userIDcard.add(i, "null");
		else
			userIDcard.add(i, user.getIdentity().toString());
		if(user.getPhone()==null)
			userphone.add(i, "null");
		else
			userphone.add(i, user.getPhone());
		if(user.getUserclass().toString().equals("2"))
		{
			userclassch.add(i, "2");
			userclass.add(i, "广告商");
		}	
		else if(user.getUserclass().toString().equals("3"))
		{
			userclassch.add(i, "3");
			userclass.add(i, "车主");
		}
		else
		{
			userclassch.add(i, "1");
			userclass.add(i, "管理员");
		}
		if(user.getStatus().toString().equals("0"))
		{
			userstatusch.add(i, "0");
			userstatus.add(i, "未审核");
		}
		else
		{
			userstatusch.add(i, "1");
			userstatus.add(i, "审核通过");
		}
		}
	%>
   
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
                <a class="brand" href="#" onclick="javascript:document.formtohome.submit();" ><span class="first">WOW</span> <span class="second">世界之窗</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>用户管理<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <!--<li><a href="index.jsp">Home</a></li>-->
            <li ><a >用户列表<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a></li>
		</ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="../../web/administator/advertisementtable?pagenum=1">广告列表<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a></li>
        </ul>

        <a href="../../Webapp/admin/account.jsp" class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
		
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">用户列表</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#" onclick="javascript:document.formtohome.submit();">主页</a> <span class="divider">/</span></li>
            <li class="active">用户列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <!-- <button class="btn">导出</button> -->
  <div class="btn-group">
  </div>
</div>
<form name="formtohome" action="<%=path%>/web/administator/login" method="post" >
<input name="phone" type="hidden" value="<%=session.getAttribute("phone") %>">
<input name="password" type="hidden" value="<%=session.getAttribute("password") %>">
</form>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>姓名</th>
          <th>身份证号</th>
          <th>手机号</th>
		  <th>用户类型</th>
		  <th>用户状态</th>
          <th style="width: 92px;"></th>
        </tr>
      </thead>
      <tbody>
       			<%
        			int i = 0;
        			for( ;  i < userlist.size()  ; i++){
    			%>
            			<tr>
            			<form id="form<%=i %>" action="<%=path%>/web/administator/user" method="post">
            				<td><%=i+1 %></td>
            				<td><%=username.get(i) %></td>
            				<td><%=userIDcard.get(i) %></td>
            				<td><input type="hidden" name="phone" value=<%=userphone.get(i) %>> <%=userphone.get(i) %></td>
            				<td><input type="hidden" name="userclass" value=<%=userclassch.get(i) %>> <%=userclass.get(i) %></td>
            				<td><input type="hidden" name="userstate" value=<%=userstatusch.get(i) %>> <%=userstatus.get(i) %></td>
            				<td>
            				<%
        						if(userstatus.get(i).equals("未审核"))
        								{
    						%>
		      					<button class="btn btn-link" style=" color:red" OnClick="javascript:document.forms[<%=i %>].submit();"><i class="icon-search"></i> 审核</button>
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
    	int pagenow = Integer.parseInt(session.getAttribute("pagenum").toString());
    	int totaluser = Integer.parseInt(request.getAttribute("all_user_number").toString());
    	System.out.println("总用户数为"+totaluser);
    	int totalpage = ((totaluser/10)+1);
    	System.out.println("总页数为"+totalpage);
    	if(totalpage!=1)
    	{
    	if(pagenow==1)
    	{
    	
    	%>
        <li><a style="color:black;" >首页</a></li>
        <li><a style="color:black;" >1</a></li>
        <li><a href="../../web/administator/usertable?pagenum=2">2</a></li>
        <li><a href="../../web/administator/usertable?pagenum=<%=pagenow+1%>">下一页</a></li>
        <li><a href="../../web/administator/usertable?pagenum=<%=totalpage%>">末页</a></li>
        <%
    	}
    	else if(pagenow==totalpage)
    	{
    		%>
            <li><a href="../../web/administator/usertable?pagenum=1">首页</a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow-1%>">上一页</a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow-1 %>"><%=pagenow-1 %></a></li>
            <li><a style="color:black;"><%=pagenow %></a></li>
            <li><a style="color:black;">末页</a></li>
            <%	
    	}
    	else
    	{
    		%>
            <li><a href="../../web/administator/usertable?pagenum=1">首页</a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow-1%>">上一页</a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow-1 %>"><%=pagenow-1 %></a></li>
            <li><a style="color:black;"><%=pagenow %></a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow+1 %>"><%=pagenow+1 %></a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=pagenow+1%>">下一页</a></li>
            <li><a href="../../web/administator/usertable?pagenum=<%=totalpage%>">末页</a></li>
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


