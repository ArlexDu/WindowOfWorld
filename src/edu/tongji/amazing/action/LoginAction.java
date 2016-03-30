package edu.tongji.amazing.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IUserService;

@Controller("login")
public class LoginAction extends ActionSupport implements ModelDriven<User>{

	@Resource(name="user")
	private User user;
	
	@Resource(name="userservice")
	private IUserService userservice;
	
	public String execute(){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		userservice.checkUser(user);
		return "success";
		
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
