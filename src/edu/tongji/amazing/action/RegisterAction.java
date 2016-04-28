package edu.tongji.amazing.action;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;

@Controller("register")
public class RegisterAction extends ActionSupport {

	private String username;
	private String password;
	private String phone;
	
	private HashMap<String, Object> data;
	@Resource(name = "user")
	private User user;
	@Resource(name = "define")
	private Defined defined;


	//android端的用户注册
	@Resource(name = "carownerservice")
	private ICarOwnerService service;
	@Resource(name = "carowner")
	private CarOwner carowner;
	
	public String RegisterAndroid() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String, Object>();
		// 判断是否有此用户
		if (service.getUserbyPhone(phone) != null) {
			data.put(defined.Error, defined.RrgisteredUSER);
			return "success";
		}
		String time = String.valueOf(new Date().getTime());
		user.setTime(time);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUserclass("3");
		user.setStatus("0");
		carowner.setUser(user);
		carowner.setPhone(phone);
		if (service.addUser(carowner)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "success";
	}
	
//	网页端的管理员注册
	private String realname;
	private String identity;
	@Resource(name="administratorservice")
	private IAdministratorService administratorService;
	
	public String RegisterAdmin() throws Exception {
		// TODO Auto-generated method stub
		// 判断是否有此用户
		if (service.getUserbyPhone(phone) != null) {
			return "exist";
		}
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setIdentity(identity);
		user.setRealname(realname);
		user.setUserclass("1");
		String time = String.valueOf(new Date().getTime());
		user.setTime(time);
		if (administratorService.addAdministrator(user)) {
			return "success";
		} else {
			return "fail";
		}
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


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}

	
}
