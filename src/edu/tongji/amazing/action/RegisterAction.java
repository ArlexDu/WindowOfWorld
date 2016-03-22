package edu.tongji.amazing.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IUserService;

@Controller("register")
public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	@Resource
	private User user;
	
	@Resource(name = "iservice")
	private IUserService userService ;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getIdentity_id());
		userService.addUser(user);
		return "success";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
