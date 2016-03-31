package edu.tongji.amazing.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.ICarOwnerService;

@Controller("login")
public class LoginAction extends ActionSupport {

	
	@Resource(name="carownerservice")
	private ICarOwnerService userservice;
	
	private String username;
	private String password;
	
	public String execute(){
		boolean isok ;
		isok = userservice.checkUser(username,password);
		if(isok){
			return "success";
		}
		return "fail";
		
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
