package edu.tongji.amazing.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.Advertisement;

import edu.tongji.amazing.service.IAdService;

@Controller("addadpost")
public class AddAdAction extends ActionSupport implements ModelDriven<Advertisement> {
	@Resource(name="advertisement")
	private Advertisement advertisement;
	
	@Resource(name="adservice")
	private IAdService adservice;
	
	public String execute(){
		
//		userservice.checkUser(user);
		System.out.println("identity: "+advertisement.getPhone());
		System.out.println("begin_time: "+advertisement.getBegin_time());
		System.out.println("end_time: "+advertisement.getEnd_time());
		System.out.println("place: "+advertisement.getPlace());
		System.out.println("price: "+advertisement.getPrice());
		System.out.println("time: "+advertisement.getTime());
		System.out.println("status: "+advertisement.getStatus());
		System.out.println("content: "+advertisement.getContent());

	//	adservice.AddNewAd(advertisement);
		return "success";
		
	}
	@Override
	public Advertisement getModel() {
		// TODO Auto-generated method stub
		return advertisement;
	}
}
