package edu.tongji.amazing.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.SendMessage;
@Controller("authcode")
public class AuthCodeAction extends ActionSupport {
	
	private String phone;
	private HashMap<String, Object> authcode;
    @Resource(name="sendmessage")
    private SendMessage send;
    
    @Resource(name ="define")
	private Defined defined;
    
	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}


	public HashMap<String, Object> getAuthcode() {
		return authcode;
	}



	public void setAuthcode(HashMap<String, Object> authcode) {
		this.authcode = authcode;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		send.setPhonenumber(phone);
		send.Send();
		int code = send.getCode();
		authcode = new HashMap<String, Object>();
		authcode.put(defined.Error, defined.SUCCESS);
		authcode.put("authCode", String.valueOf(code));
		return "success";
	}
}
