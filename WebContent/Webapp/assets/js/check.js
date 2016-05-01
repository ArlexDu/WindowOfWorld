/**
 * 
 */
function check_login(){
	var account=document.login.account.value;
	var pw=document.login.password.value;
	if(pw!=111){
		$('#login_Modal').modal('show');
		return false;
	}else{
		window.location.href="/AmazingAd/Webapp/wow/account.jsp"; //跳转不了？？？？？
	}
}

function reg_change1(){
	 $(".reg_1").slideDown("slow");
	 $(".reg_2").slideUp("slow");
	 $(".reg_3").slideUp("slow");
}

function reg_change2(){
	 $(".reg_1").slideUp("slow");
	 $(".reg_2").slideDown("slow");
	 $(".reg_3").slideUp("slow");
}

function reg_change3(){
	 $(".reg_1").slideUp("slow");
	 $(".reg_2").slideUp("slow");
	 $(".reg_3").slideDown("slow");
}

function showPreview(source) {  //上传头像预览
	var file = source.files[0];
	if (window.FileReader) {
		var fr = new FileReader();
		fr.onloadend = function(e) {
			document.getElementById("portrait").src = e.target.result;
		};
		fr.readAsDataURL(file);
	}
}

function showPreview1(source) {  //上传广告商执照预览
	var file = source.files[0];
	if (window.FileReader) {
		var fr = new FileReader();
		fr.onloadend = function(e) {
			document.getElementById("liscense_p").src = e.target.result;
		};
		fr.readAsDataURL(file);
	}
}

function showPreview2(source) {  //上传身份证图片预览
	var file = source.files[0];
	if (window.FileReader) {
		var fr = new FileReader();
		fr.onloadend = function(e) {
			document.getElementById("identity_p").src = e.target.result;
		};
		fr.readAsDataURL(file);
	}
}

function check_reg(){                        //注册验证
	var username=document.register.username.value;
	var realname=document.register.realname.value;
	var liscense=document.register.liscense.value;
	var id=document.register.identity.value;
	var mail=document.register.mail.value;
	var phone=document.register.phone.value;
	var pw=document.register.password.value;
	var pw1=document.register.password1.value;
	
	var uname_lg=username.length;			 //企业名称长度是否符合要求
	var rname_lg=realname.length;			 //法人姓名长度是否符合要求
	var id_lg=id.length;			 		 //法人身份证长度是否符合要求	
	var phone_lg=phone.length;			 	 //联系电话长度是否符合要求
	var pw_lg=pw.length;          
	if(username==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("企业名称不能为空");
		return false;
	}
	if(realname==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("法人姓名不能为空");
		return false;
	}
	if(liscense==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("广告商执照不能为空");
		return false;
	}
	if(id==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("身份证不能为空");
		return false;
	}
	if(mail==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("邮箱不能为空");
		return false;
	}
	if(phone==""){
		$('#myModal0').modal('show');
		$("#reg_context").html("联系电话不能为空");
		return false;
	}
	if(uname_lg>30){
		$('#myModal0').modal('show');
		$("#reg_context").html("企业名称长度不能大于30位");
		return false;                         
	}else if(rname_lg>30){
		$('#myModal0').modal('show');
		$("#reg_context").html("法人姓名长度不能大于30位");
		return false;
	}else if(id_lg!=15&&id_lg!=18){
		$('#myModal0').modal('show');
		$("#reg_context").html("身份证长度不符合要求");
		return false;
	}else if(pw_lg<8||pw_lg>16){			//判断密码长度是否符合要求
		$('#myModal0').modal('show');
		$("#reg_context").html("密码长度要在8到16位之间");
		return false;
	}else if(pw!=pw1){              //判断密码两次是否输入一致
		$('#myModal0').modal('show');
		$("#reg_context").html("两次密码输入不一致");
		return false;
	}else{
		$('#myModal').modal('show');
	}
}            

function adtype1(){
	$(".adtype1").slideDown("slow");
	$(".adtype2").slideUp("slow");
}

function adtype2(){
	$(".adtype1").slideUp("slow");
	$(".adtype2").slideDown("slow");
}

function ad_change1(){
	 $(".ad1").slideDown("slow");
	 $(".ad2").slideUp("slow");
	 $("#ad_change1").slideUp("slow");
	 $("#ad_change2").slideDown("slow");
}

function ad_change2(){
	 $(".ad1").slideUp("slow");
	 $(".ad2").slideDown("slow");
	 $("#ad_change2").slideUp("slow");
	 $("#ad_change1").slideDown("slow");
}

function showPreview_ad(source) {  //上传身份证图片预览
	var file = source.files[0];
	if (window.FileReader) {
		var fr = new FileReader();
		fr.onloadend = function(e) {
			document.getElementById("ad_picture").src = e.target.result;
		};
		fr.readAsDataURL(file);
	}
}

function date() {
    $('#datetimepicker').datetimepicker({
    	format: "yyyy-mm-dd",
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        showMeridian: true,
        pickerPosition: "bottom-left",
        language: 'zh-CN',
        startView: 2,//月视图
        minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
    });
}

function date1() {
    $('#datetimepicker1').datetimepicker({
    	format: "yyyy-mm-dd",
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        showMeridian: true,
        pickerPosition: "bottom-left",
        language: 'zh-CN',
        startView: 2,//月视图
        minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
    });
}

function ad_more(id){//广告信息
	$('#adModal').modal('show');
	$("#ad_num").html(id);
	$("#ad_co").text("广告内容");
	$("#ad_begin").val("2016-05-01");
	$("#ad_end").val("2016-05-01");
	$("#ad_time").text(id);
	$("#ad_diduan").text(id);
}

function ad_date() {
    $("#ad_begin").datetimepicker({
    	format: "yyyy-mm-dd",
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        showMeridian: true,
        pickerPosition: "bottom-left",
        language: 'zh-CN',
        startView: 2,//月视图
        minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
    });
}
function ad_date1() {
    $("#ad_end").datetimepicker({
    	format: "yyyy-mm-dd",
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        showMeridian: true,
        pickerPosition: "bottom-left",
        language: 'zh-CN',
        startView: 2,//月视图
        minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
    });
}

function pw_change(){
	$(".pw_change").fadeIn("slow");
	$("#pw_close").fadeIn("slow");
}
function pw_close(){
	$(".pw_change").fadeOut("slow");
	$("#pw_close").fadeOut("slow");
}