package edu.tongji.amazing.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.ICarOwnerService;

@Controller("register")
public class RegisterAction extends ActionSupport {

	@Resource
	private User user;
	
	@Resource(name = "carownerservice")
	private ICarOwnerService userService ;
    
	@Resource(name="carowner")
	private CarOwner owner;
	
	private String username;
	private String password;
	private String mail;
	private String phone;
	private String identity;
	private String license;
	private String carnumber;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(username);
		System.out.println(password);
		System.out.println(mail);
		System.out.println(phone);
		System.out.println(identity);
		user.setIdentity(identity);
		user.setMail(mail);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		owner.setUser(user);
		owner.setPhone(phone);
		owner.setDrivinglicense(license);
		owner.setCarnumber(carnumber);
		userService.addUser(owner);
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public String getCarnumber() {
		return carnumber;
	}


	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}


}
