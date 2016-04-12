package edu.tongji.amazing.action.android;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Credit;
import edu.tongji.amazing.service.ICreditService;
import edu.tongji.amazing.tool.Defined;
@Controller("creditAction")
public class CreditAction extends ActionSupport {

	private String phone;
	private String reason;
	private String credits;
	private HashMap<String, Object> data;
	
	@Resource(name = "creditservice")
	private ICreditService service;
	
	@Resource(name = "credit")
	private Credit credit;
	
	@Resource(name = "define" )
	private Defined define;
	//处理/android/credit/addcredits 
	public String addCredits() throws Exception{
		
		data = new HashMap<String,Object>();
		credit.setCredit(credits);
		credit.setPhone(phone);
		credit.setReason(reason);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		credit.setTime(time);
		if(!service.addCredit(credit)){
			data.put(define.Error, define.FAIL);
			return "result";
		}
		data.put(define.Error, define.SUCCESS);
		return "result";
	}
	
	//android/credit/checkcredits?phone= 
	public String checkCredits() throws Exception{
		
		data = new HashMap<String,Object>();
		List<Credit> creditlist = new ArrayList<Credit>();
		creditlist = service.getCreditList(phone);
		if(creditlist == null){
			data.put(define.Error, define.FAIL);
			return "result";
		}
		data.put(define.Error, define.SUCCESS);
		data.put("credits", creditlist);
		return "result";
	}
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	
	
}
