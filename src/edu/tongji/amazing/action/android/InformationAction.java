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

@Controller("infromation")
public class InformationAction extends ActionSupport {
	private String phone;
	private String identity;
	private String password;
	private String email;
	private String drivinglicense;
	private String carnumber;
	private HashMap<String, Object> data;
	@Resource(name="carownerservice")
	private ICarOwnerService service;
	@Resource(name="user")
	private User user;
	@Resource(name="carowner")
	private CarOwner carowner;
	@Resource(name ="define")
	private Defined defined;

	//对应的android/user/addinformation 的执行方法
	public String addInfromation() throws Exception {
		carowner = service.getUserbyPhone(phone);
        user = carowner.getUser();
        user.setIdentity(identity);
        user.setMail(email);
        user.setBalace(0.0f);
        user.setCredit(0.0f);
        carowner.setDrivinglicense(drivinglicense);
        carowner.setCarnumber(carnumber);
        data = new HashMap<String,Object>();
        if(service.updateUser(carowner)){
        	 data.put(defined.Error, defined.SUCCESS);
        }else{
        	 data.put(defined.Error, defined.FAIL);
        }
        return "result";
	}
	//对应的android/user/carowenrinfo?phone= 的执行方法
	public String getInformation() throws Exception{
		data = new HashMap<String,Object>();
		carowner = service.getUserbyPhone(phone);
		if(carowner != null){
			data.put(defined.Error, defined.SUCCESS);
			data.put("carowner",carowner);
		}else{
			data.put(defined.Error, defined.NOUSER);
		}
		return "result";
	}

	//对应的android/user/changepassword 的执行方法
		public String changePassword() throws Exception{
			data = new HashMap<String,Object>();
			carowner = service.getUserbyPhone(phone);
			if(carowner == null){
				data.put(defined.Error, defined.NOUSER);
				return "result";
			}
			user = carowner.getUser();
			user.setPassword(password);
			carowner.setUser(user);
			if(service.updateUser(carowner)){
	        	 data.put(defined.Error, defined.SUCCESS);
	        }else{
	        	 data.put(defined.Error, defined.FAIL);
	        }
			return "result";
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDrivinglicense() {
		return drivinglicense;
	}

	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
