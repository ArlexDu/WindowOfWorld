package edu.tongji.amazing.action;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.UpLoadFile;
@Controller("administratorAction")
public class AdministratorAction extends ActionSupport implements ServletRequestAware{

	
	@Resource(name="administratorservice")
	private IAdministratorService service;
	
	//用于展示的用户
	private List<User> users;
	
	//用于展示的广告
	private List<Advertisement> advertisements;
	
	//用于展示的支出信息
	private List<Balance> balances;
	
	private HttpServletRequest request;
	
	/*
	 * 管理员登录的接口 /web/administrator/login
	 */
	
	private String phone;
	private String password;
	
	
	public String Login() throws Exception {
		// TODO Auto-generated method stub、
		if(service.login(phone, password)){
			getHomeData();
			return "success";
		}else{
			return "pswwrong";
		}
	}
	
	/*
	 * 管理员的注册 
	 * 参数：
	 *    @手机号
	 *    @密码
	 *    @身份证号码
	 *    @真实的姓名
	 *    @身份证的照片 
	 */
	private String identity;
	private String realname;
	private File identityCard;
	private String identityCardContentType;
	@Resource(name = "uploadfile")
	private UpLoadFile upload;
	
	@Resource(name = "user")
	private User adminstrator;
	
	public String register() throws Exception{
		
		adminstrator.setPhone(phone);
		adminstrator.setPassword(password);
		adminstrator.setIdentity(identity);
		adminstrator.setRealname(realname);
		adminstrator.setUserclass("1");
		adminstrator.setStatus("0");
		String time = String.valueOf(new Date().getTime());
		adminstrator.setTime(time);
		if(identityCard!=null){
			String path = request.getSession().getServletContext().getRealPath("/IdentityCard");
			path = upload.SaveFile(identityCard, path, identityCardContentType);
			String urlpath = "http://10.60.42.70:8080/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
			adminstrator.setIdentityCard(urlpath);
		}
		service.addAdministrator(adminstrator);
		return "success";//转移到一个正在等管理员审核界面（不允许未经审核通过就登录）,管理员这个注册不需要发验证码或者激活操作
	}
	
	public String test() throws Exception{
		getHomeData();
		return "success";
	}
	
	
	/*
	 * 获得home.jsp的数据
	 */
	
	private HashMap<String, Object> data;
	
	private void getHomeData(){
		try {
			data = new HashMap<String,Object>();
		    users = service.getShowUsers();
			advertisements = service.getShowAdvertisements();
			balances = service.getShowBalance();
			int alluser_number = service.getallusers();
			int alladvertisement_number = service.getalladvertisements();
			int examineuer = service.unexamineUsers();
			int examineadvertisement = service.unexamineAdvertisements();
			data.put("users", users);
			data.put("advertisements", advertisements);
			data.put("balances", balances);
			data.put("alluser_number", alluser_number);
			data.put("alladvertisement_number", alladvertisement_number);
			data.put("examineuer", examineuer);
			data.put("examineadvertisement", examineadvertisement);
			ServletActionContext.getRequest().setAttribute("all_user_number", alluser_number);
			ServletActionContext.getRequest().setAttribute("examine_user_number", examineuer);
			ServletActionContext.getRequest().setAttribute("all_advertisement_number", alladvertisement_number);
			ServletActionContext.getRequest().setAttribute("examine_advertisement_number", examineadvertisement);
			ServletActionContext.getRequest().setAttribute("showusers", users);
			ServletActionContext.getRequest().setAttribute("showadvertisements", advertisements);
			ServletActionContext.getRequest().setAttribute("showbalance", balances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	
	
	
	
}
