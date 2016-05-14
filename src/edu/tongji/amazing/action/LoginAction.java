package edu.tongji.amazing.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.service.impl.CarOwnerService;
import edu.tongji.amazing.tool.Defined;

@Controller("login")
public class LoginAction extends ActionSupport {

	private Map<String, Object> data;
	@Resource
	private ICarOwnerService service;
	
	private String phone;
	private String password;
	
	@Resource(name ="define")
	private Defined defined;
	
//	缃戦〉鐧诲綍鐨勬帴鍙� android/user/login
//	public String LoginWeb() throws Exception {
//		// TODO Auto-generated method stub
//		//鍒ゆ柇鏄惁鏈夋鐢ㄦ埛
//		if(service.getUserbyPhone(phone)==null){
//			data.put(defined.Error, defined.NOUSER);
//			return "fail";
//		}
//		if(service.checkUser(phone, password)){
//			data.put(defined.Error, defined.SUCCESS);
//			return "success";
//		}else{
//			data.put(defined.Error, defined.WrongPassword);
//			return "pswwrong";
//		}
//	}
//	瀹㈡埛绔櫥褰曠殑鎺ュ彛 android/user/login
	public String LoginAndroid() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String,Object>();
		//鍒ゆ柇鏄惁鏈夋鐢ㄦ埛
		if(service.IsUserExist(phone)==null){
			data.put(defined.Error, defined.NOUSER);
			return "success";
		}
		if(service.checkUser(phone, password)){
			data.put(defined.Error, defined.SUCCESS);
		}else{
			data.put(defined.Error, defined.WrongPassword);
		}
		return "success";
	}
	//用于登录时后判断用户是否存在 /android/isuser?phone=
	public String IsUser() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String,Object>();
		//判断是否有此用户
		if(service.IsUserExist(phone)==null){
			data.put(defined.Error, defined.NOUSER);
		}else{
			data.put(defined.Error, defined.SUCCESS);
		}
		return "success";
	}
	
	public Map<String, Object> getData() {
		return data;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
