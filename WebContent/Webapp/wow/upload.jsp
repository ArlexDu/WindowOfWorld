<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>The World Window</title>

    <link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="../assets/css/agency.css" rel="stylesheet">
	<link href="../assets/wow-font/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link href="../assets/css/new.css" rel="stylesheet">
    
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.easing.min.js"></script>
    <script src="../assets/js/jqBootstrapValidation.js"></script>
    <script src="../assets/js/contact_me.js"></script>
    <script src="../assets/js/agency.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=826e806b86676d155282de3d37188137"></script>
    <script src="../assets/js/check.js"></script>
</head>

<body id="page-top" class="index">

    <!--标题栏-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="#">上传广告</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="account.jsp">返回</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">退出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  
    <!-- 上传部分 -->
    <section id="contact">
        <div class="container" class="bg-light-gray">
      		<form name="upload1" id="upload1">
      			<div class="col-lg-12 reg_font">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
      				<div class="form-group">
				   		<label>发布日期</label>
						<input type="text" value="2016-05-17 00" class="form-control choosetime" name="time" onchange="changelength(this)"/>
						<label>当日发布时长</label>
						<select id="length" class="form-control" name="tlength"></select>
				    </div>
			    	<div class="form-group">
                  		<label>地段类型选择：</label>
                     		<span class="label label-success adtype" onclick="placetype1();">坐标</span>
                     		<span class="label label-success adtype" onclick="placetype2();">类型</span>
                  	</div>
                  	<div class="place1">
                  		<div id="drag">
			    		<div id="map"></div>
			    	</div>
                  	</div>
                  	<div class="place2">
			    	<select name="area_type" class="form-control" onchange="timearea1();">
						<option value="学校">学校</option>
						<option value="医院">医院</option>
						<option value="酒店">酒店</option>
						<option value="学校,医院,酒店">学校,医院,酒店</option>
					</select>
                  	</div>
                  	</div>
                    <div class="col-lg-3">
                    </div>
                </div>
             </form>
             <form name="upload" id="upload"  method="post" action="/AmazingAd/web/advertiser/testad" enctype="multipart/form-data">
                 <div class="col-lg-12 reg_font">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                    	<div class="form-group">
						    <label>广告标题</label>
						    <input class="form-control" type="text" name="title" id="title">
						</div>
	                    <div class="form-group">
	                    	<label>上传内容类型选择：</label>
	                       	<span class="label label-success adtype0" onclick="adtype1();">文字</span>
	                       	<span class="label label-success adtype0" onclick="adtype2();">图片</span>
	                    </div>
	                    <div class="adtype1">
	                    <div class="form-group">
	                        <textarea class="form-control" placeholder="广告内容" id="character" name="character"></textarea>
	                    </div>
	                    </div>
	                    <div class="adtype2">
	                    	 <label class="ad_picture">
                       	     <img id="ad_picture" src="/AmazingAd/Webapp/assets/images/adback.jpg">
                             <input class="avatar" accept="image/gif, image/jpeg, image/x-png" type="file" id="picture" name="picture" onchange="showPreview_ad(this)" />
                             </label>
					 	</div>
                    </div>
                    <div class="col-lg-3">
                    </div>   
                 </div>
                 <div class="col-lg-12">
                 <div class="col-lg-2"></div>
	                 <div class="col-lg-8 quxiao">
	                 	<h3>广告发布时间表</h3>
					    <table class="table table-bordered" id="table_ta">
					    <tr>
					    	<th></th>
						    <th>发布日期</th>
						    <th>发布时长</th>
						    <th>发布地段</th>
						    <th class="nosee">地段类型</th>
						    <td><a  class="glyphicon glyphicon-plus plus" onclick="ta_more();"></a></td>
					    </tr>
					    <tr>
					    	<th>1</th>
					    	<td><input type="text" id="time1" name="showtime" readonly="readonly"></td>
					    	<td><input type="text" id="length1" name="length" readonly="readonly"></td>
					    	<td><input type="text" id="area1" name="showarea" readonly="readonly"></td>
					    	<td class="nosee"><input class="diduanleixing" type="checkbox" id="areatype1" name="type" readonly="readonly" onclick="changetype(this)"></td>
					    </tr>
					    </table>
					    <input type="hidden" id="showinfo" name="showinfo"/>
            			<input type="hidden" id="phone" name="phone"/>
				    </div>
			    <div class="col-lg-2"></div>
			    </div>
                 <div class="col-lg-12">
                      <div class="col-lg-4"></div>
                      <div class="col-lg-4">
                      	  <input type="submit" class="btn btn-xl" value="上传" onclick="adupload();">
                      </div>
                      <div class="col-lg-4"></div>
                 </div>
             </form>
        </div>
    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Our Web 2016</span>
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-arrow-circle-up"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    
    <!--APP二维码-->
    <div class="portfolio-modal modal fade" id="AppModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>扫二维码下载APP</h2>
                        <img class="img-responsive img-centered" src="../assets/images/portfolio/dreams-preview.png" alt="">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                    </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
    var marker, oDrag = document.getElementById("drag");    // 百度地图API功能
	var map = new BMap.Map("map");            				// 创建Map实例
	map.enableScrollWheelZoom(true);
	map.addControl(new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT}));    // 右下比例尺
	map.setDefaultCursor("Crosshair");											  //鼠标样式
	map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT}));  //右上角，仅包含平移和缩放按钮
	map.centerAndZoom("上海", 11);
	oDrag.style.display = "block";
	map.addEventListener("click", showInfo);
	function showInfo(e){
		map.clearOverlays();
		marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));  // 创建标注
		map.addOverlay(marker);   //获取经纬度
		$('#areaModal').modal('show');
		$("#lng").html(e.point.lng);
		$("#lat").html(e.point.lat);
	}
	</script>
	<script>
		$(".choosetime").datetimepicker({
		    minView: "day", //选择日期后，不会再跳转去选择时分秒
		    format: "yyyy-mm-dd hh", //选择日期后，文本框显示的日期格式
		    language: 'zh-CN', //汉化
		    autoclose:true //选择日期后自动关闭
		});
		function changelength(obj){
			var str = obj.value;
			var hour = str.substring(10);
			var select = obj.parentNode.parentNode.childNodes[3].childNodes[1];
			for(var i=1;i<24-hour+1;i++){
				str+="<option value='"+i+"'>"+i+"小时</option>'";
			}
			$('#length').append(str);
			
		}
		function readCookie(name) {
		    var nameEQ = name + "=";
		    var ca = document.cookie.split(';');
		    for(var i=0;i < ca.length;i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') c = c.substring(1,c.length);
		        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
		    }
		    return null;
		}
		  window.onload=function () {
			  var phone=readCookie('userphone'); 
			  if(phone!=null){
				  $('#phone').val(phone);
			  }else{
				  alert("请登录");
				  window.location.href="/AmazingAd/Webapp/wow/login.jsp";
			  }
		  }
		  function adupload() {
			    var showtimes = document.getElementsByName("showtime");
			    var showareas = document.getElementsByName("showarea");
			    var lengths = document.getElementsByName("length");
			    var types = document.getElementsByName("type");
			    var len = showareas.length;
			    var showinfo="{\"showinfo\": [";
			    for(var i=0;i<len;i++){
			      showinfo+="{\"time\":\""+showtimes[i].value+"\",\"length\":\""+lengths[i].value+"\",\"area\":\""+showareas[i].value+"\",\"type\":\""+types[i].value+"\"}";
			      if(i<len-1)
			        showinfo+=",";
			    }
			    showinfo+="]}";
			    $('#showinfo').val(showinfo);
			  }
			  function changetype(obj){
				if(obj.checked){
					obj.value="coordinate";//坐标
				}
				else{
					obj.value="area";	//区域
				}
			  }
	</script>

	<!-- 上传弹出框 -->
	<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">上传信息</h4>
	      </div>
	      <div class="modal-body" id="upload_context"></div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 上传坐标弹出框 -->
	<div class="modal fade" id="areaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title" id="myModalLabel">选择地段</h4>
	      </div>
	      <div class="modal-body">选择以经度：<p id="lng"></p>&nbsp;纬度：<p id="lat"></p>为中心的地段发布！</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="timearea();">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>

</html>
