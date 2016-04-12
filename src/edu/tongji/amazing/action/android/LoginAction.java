package edu.tongji.amazing.action.android;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.service.impl.CarOwnerService;
import edu.tongji.amazing.tool.Defined;
import sun.print.resources.serviceui;

@Controller("loginAndroid")
public class LoginAction extends ActionSupport {

	private Map<String, Object> data;
	@Resource
	private CarOwnerService service;
	
	private String phone;
	private String password;
	
	@Resource(name ="define")
	private Defined defined;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String,Object>();
		//判断是否有此用户
		if(service.getUserbyPhone(phone)==null){
			data.put(defined.Error, defined.NOUSER);
			return "success";
		}
		if(service.checkUser(phone, password)){
			data.put(defined.Error, defined.SUCCESS);
		}else{
			data.put(defined.Error, defined.FAIL);
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
