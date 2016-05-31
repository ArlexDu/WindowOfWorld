package edu.tongji.amazing.action;

import com.opensymphony.xwork2.ActionSupport;

public class SendMessageAction extends ActionSupport {
	private String phonenumber;

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
