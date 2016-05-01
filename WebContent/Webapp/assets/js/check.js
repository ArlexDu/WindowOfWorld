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
	if(uname_lg>30){
		$('#myModal1').modal('show');
		return false;                         
	}else if(rname_lg>30){
		$('#myModal2').modal('show');
		return false;
	}else if(id_lg!=15&&id_lg!=18){
		$('#myModal3').modal('show');
		return false;
	}else if(pw_lg<8||pw_lg>16){			//判断密码长度是否符合要求
		$('#myModal4').modal('show');
		return false;
	}else if(pw!=pw1){              //判断密码两次是否输入一致
		$('#myModal5').modal('show');
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

