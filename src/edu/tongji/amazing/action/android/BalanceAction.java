package edu.tongji.amazing.action.android;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.tool.Defined;

@Controller("balanceAction")
public class BalanceAction extends ActionSupport {

	private String phone;
	private String money;
	private String reason;

	private HashMap<String, Object> data;

	@Resource(name = "define")
	private Defined define;

	@Resource(name = "balanceservice")
	private IBalanceService service;
	
	@Resource(name = "balance")
	private Balance balance;

	// 处理/android/bill/changebill
	public String Changebill() throws Exception {

		data = new HashMap<String, Object>();
		balance.setMoney(money);
		balance.setPhone(phone);
		balance.setReason(reason);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		balance.setTime(time);
		if (!service.changeBalance(balance)) {
			data.put(define.Error, define.FAIL);
			return "result";
		}
		data.put(define.Error, define.SUCCESS);
		return "result";
	}

	// android/bill/checkbills?phone=
	public String getBills() throws Exception {

		data = new HashMap<String, Object>();
		List<Balance> list = new ArrayList<Balance>();
		list = service.getOrderList(phone);
		if (list == null) {
			data.put(define.Error, define.FAIL);
			return "result";
		}
		data.put(define.Error, define.SUCCESS);
		data.put("bills", list);
		return "result";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

}
