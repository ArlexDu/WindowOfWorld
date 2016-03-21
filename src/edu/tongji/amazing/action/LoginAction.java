package edu.tongji.amazing.action;

import org.springframework.stereotype.Controller;

@Controller("login")
public class LoginAction {

	//属性数据封装
	private String username;
	private String password;
	
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
	
	public String execute(){
//		System.out.println(username);
//		System.out.println(password);
		if(username.equals("admin")&&password.equals("123")){
			return "success";
		}else{
			return "fail";
		}
	}
}
