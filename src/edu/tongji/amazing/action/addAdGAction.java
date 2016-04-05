package edu.tongji.amazing.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller("addadget")
public class addAdGAction extends ActionSupport {
		public String execute() {
	
			return "AddAD";
	
		}
}
