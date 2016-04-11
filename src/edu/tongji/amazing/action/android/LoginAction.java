package edu.tongji.amazing.action.android;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.service.impl.CarOwnerService;
import sun.print.resources.serviceui;

@Controller("loginAndroid")
public class LoginAction extends ActionSupport {

	private Map<String, Object> data;
	@Resource
	private CarOwnerService service;
	
	private String phone;
	private String password;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String,Object>();
		if(service.checkUser(phone, password)){
			data.put("errCode", 1);
		}else{
			data.put("errCode", 0);
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
