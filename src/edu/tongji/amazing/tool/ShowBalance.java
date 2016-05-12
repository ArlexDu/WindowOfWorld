package edu.tongji.amazing.tool;

import org.springframework.stereotype.Component;

@Component("showbalance")
public class ShowBalance {
	private String username;
	private String money;
	private String date;
	private String reason;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
