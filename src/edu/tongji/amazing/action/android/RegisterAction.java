package edu.tongji.amazing.action.android;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.service.impl.CarOwnerService;
import edu.tongji.amazing.tool.Defined;
import sun.print.resources.serviceui;

@Controller("registerAndroid")
public class RegisterAction extends ActionSupport {

	private String username;
	private String password;
	private String phone;
	private HashMap<String, Object> data;
	@Resource(name = "user")
	private User user;
	@Resource(name = "carownerservice")
	private ICarOwnerService service;
	@Resource(name = "carowner")
	private CarOwner carowner;

	@Resource(name = "define")
	private Defined defined;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 判断是否有此用户
		if (service.getUserbyPhone(phone) != null) {
			data.put(defined.Error, defined.RrgisteredUSER);
			return "success";
		}
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		carowner.setUser(user);
		carowner.setPhone(phone);
		data = new HashMap<String, Object>();
		if (service.addUser(carowner)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "success";
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

}