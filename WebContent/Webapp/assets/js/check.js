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

function check_reg(){                        //注册验证
	var username=document.register.username.value;
	var realname=document.register.realname.value;
	var liscense=document.register.liscense.value;
	var id=document.register.identity.value;
	var mail=document.register.mail.value;
	var phone=document.register.phone.value;
	var pw=document.register.password.value;
	var pw1=document.register.password1.value;
	var avatar=document.register.avatar.value;
	
	var uname_lg=username.length;			 //企业名称长度是否符合要求
	var rname_lg=realname.length;			 //法人姓名长度是否符合要求
	var id_lg=id.length;			 		 //法人身份证长度是否符合要求
	var pw_lg=pw.length;                 
	if(uname_lg>30){
		$('#myModal1').modal('show');
		return false;                         //false不能去
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
		$.ajax({
            type: "POST",
            url : "/AmazingAd/web/adowner/register",
            data : {username:username,
	            	realname:realname,
	            	liscense:liscense,
	            	identity:id,
	            	phone:phone,
	            	mail:mail,
	            	avatar:avatar,
	            	password:pw
            		},
            success: function(response){
                if(response=="fail"){
                    alert("fail");
                }else if(response=="true"){
            		$('#myModal').modal('show');
                }else{
                	alert("response:"+response);
                }
                
            }
        });
	}
}            