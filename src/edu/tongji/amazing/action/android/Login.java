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
public class Login extends ActionSupport {

	private Map<String, Object> data;
	@Resource
	private CarOwnerService service;
	
	private String username;
	private String password;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("username is "+username);
		System.out.println("password is "+password);
		data = new HashMap<String,Object>();
		CarOwner carowner = service.getUserbyIndentity("130823200001290001");
		data.put("carowner", carowner);
		return "success";
	}
	public Map<String, Object> getData() {
		return data;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
