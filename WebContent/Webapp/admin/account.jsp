<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="edu.tongji.amazing.model.*"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>财务报告</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<s:action name="finances" namespace="/web/administator"></s:action>
	<link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">
	<script src="../../Webapp/assets/js/Chart.bundle.js" ></script>
    <script src="../../Webapp/assets/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<%
    if(session.getAttribute("phone")==null)
	{
		response.setCharacterEncoding("UTF-8");  
		response.sendRedirect("sign-in.jsp");
	}
    	String path = request.getContextPath();
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
    
    <% 
  
  		//获取收支信息
  		List<String> fidate = new ArrayList<String>();
  		List<Double> income = new ArrayList<Double>();
  		List<Double> outgoing = new ArrayList<Double>();
  		List finances = (List)request.getAttribute("finance");
  		System.out.println("11111");
  		for(int i=0; i < finances.size() ;i++) 
		{
  			Finance fi = (Finance)finances.get(i);
  			if(fi.getFinance_date()==null)
  				fidate.add("null");
  			else
  				fidate.add(i, fi.getFinance_date().toString());
  			income.add(i, fi.getIncome());
  			outgoing.add(i, fi.getOutgoing());
		}
    %>
    
    <script>
    
    var randomColorFactor = function() {
        return Math.round(Math.random() * 255);
    };
    var randomColor = function(opacity) {
        return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
    };

    var config = {
        type: 'line',
        data: {
        	labels: [<%
        			String datetemp;
        			for( int i = 0;  i < ( finances.size()-1 )  ; i++){
        				datetemp = fidate.get(i).substring(fidate.get(i).length()-2);
    			 %>
    			 <%=datetemp %>+"月",
    			 <%
        			}
    			 %>],
            datasets: [{
                label: "收入",
                data: [<%
        			
        			for( int i = 0;  i < ( finances.size()-1 )  ; i++){
    			 %>
    			 <%=income.get(i) %>,
    			 <%
        			}
    			 %>
    			 ],
                fill: false,
                
            },  {
                label: "支出",
                data: [<%
           			
           			for( int i = 0;  i < ( finances.size()-1 )  ; i++){
       			 %>
       			 <%=outgoing.get(i) %>,
       			 <%
           			}
       			 %>],
       			fill: false,
       			
            }, {
                label: "净利润",
                data: [<%
           			Double temp = 0.0;
           			for( int i = 0;  i < ( finances.size()-1 )  ; i++){
           				temp = income.get(i)-outgoing.get(i);
       			 %>
       			 <%=temp %>,
       			 <%
           			}
       			 %>],
       			fill: true,
       			hidden: true,
            }]
        },
        options: {
            responsive: true,
            title:{
                display:true,
                text:'收支查看'
            },
            tooltips: {
                mode: 'label',
                callbacks: {
                    // beforeTitle: function() {
                    //     return '...beforeTitle';
                    // },
                    // afterTitle: function() {
                    //     return '...afterTitle';
                    // },
                    // beforeBody: function() {
                    //     return '...beforeBody';
                    // },
                    // afterBody: function() {
                    //     return '...afterBody';
                    // },
                    // beforeFooter: function() {
                    //     return '...beforeFooter';
                    // },
                    // footer: function() {
                    //     return 'Footer';
                    // },
                    // afterFooter: function() {
                    //     return '...afterFooter';
                    // },
                }
            },
            hover: {
                mode: 'dataset'
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        show: true,
                        labelString: '月份'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        show: true,
                        labelString: '数值'
                    },
                    ticks: {
                        suggestedMin: -10,
                        suggestedMax: 250,
                    }
                }]
            }
        }
    };

    $.each(config.data.datasets, function(i, dataset) {
        dataset.borderColor = randomColor(0.4);
        dataset.backgroundColor = randomColor(0.5);
        dataset.pointBorderColor = randomColor(0.7);
        dataset.pointBackgroundColor = randomColor(0.5);
        dataset.pointBorderWidth = 1;
    });

    window.onload = function() {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myLine = new Chart(ctx, config);
    };
    </script>
     </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
  <s:action name="gethomedata" namespace="/web/administator"></s:action> 
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
            <li ><a href="../../web/administator/usertable?pagenum=1">用户列表<span class="label label-info">+<s:property value="#request.examine_user_number"/></span></a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-picture"></i>广告管理<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="../../web/administator/advertisementtable?pagenum=1">广告列表<span class="label label-info">+<s:property value="#request.examine_advertisement_number"/></span></a></li>
            
        </ul>

        <a  class="nav-header" ><i class="icon-question-sign"></i>收入查看</a>
		
    </div>
    

     <form name="formtohome" action="<%=path%>/web/administator/login" method="post" >
<input name="phone" type="hidden" value="<%=session.getAttribute("phone") %>">
<input name="password" type="hidden" value="<%=session.getAttribute("password") %>">
</form> 
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">收支查看</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="#" onclick="javascript:document.formtohome.submit();">主页</a> <span class="divider">/</span></li>
            <li class="active">收支查看</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    

<div class="row-fluid">
        <div class="block span6">
        <div class="block-heading">
            
            <a href="#widget2container" data-toggle="collapse">收支列表</a>
        </div>
        <div id="widget2container" class="block-body collapse in">
            <table class="table list">
            <thead>
        		<tr>
          		<th>收支年月</th>
          		<th>总收入</th>
          		<th>总支出</th>
        		</tr>
      		</thead>
              <tbody>
                 <%
        			int i = finances.size()-2;
        			for( ;  i > -1  ; i--){
    			 %>
            			<tr>
            				<td><%=fidate.get(i) %></td>
            				<td><%=income.get(i) %></td>
            				<td><%=outgoing.get(i) %></td>	
            			</tr>
    			<%
        			}
    			%> 
              </tbody>
            </table>
        </div>
    </div>
    <div class="block span6">
        <div class="block-heading">
           <a href="#widget2container1" data-toggle="collapse">收支图示</a>
        </div>
        <div id="widget2container1" class="block-body collapse in">
        	<canvas id="canvas"></canvas>
        </div>
    </div>
</div>

<!-- <div class="pagination">
    <ul>
        <li><a href="#">首页</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">下一页</a></li>
    </ul>
</div>
-->

                    
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
