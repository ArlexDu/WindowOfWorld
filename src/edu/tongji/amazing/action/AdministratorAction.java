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
import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.Finance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.IAdvertiserService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.SendMessage;
import edu.tongji.amazing.tool.FileTools;
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
	 * 参数：
	 *   @phone
	 *   @password
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
	 * 管理员的注册   /web/administrator/register
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
	@Resource(name = "filetool")
	private FileTools upload;
	
	@Resource(name = "user")
	private User adminstrator;
	
	@Resource(name = "define")
	private Defined defined;
	
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
			String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
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
//			data = new HashMap<String,Object>();
		    users = service.getShowUsers();
			advertisements = service.getShowAdvertisements();
			balances = service.getShowBalance();
			int alluser_number = service.getallusers();
			int alladvertisement_number = service.getalladvertisements();
			int examineuer = service.unexamineUsers();
			int examineadvertisement = service.unexamineAdvertisements();
//			data.put("users", users);
//			data.put("advertisements", advertisements);
//			data.put("balances", balances);
//			data.put("alluser_number", alluser_number);
//			data.put("alladvertisement_number", alladvertisement_number);
//			data.put("examineuer", examineuer);
//			data.put("examineadvertisement", examineadvertisement);
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
	
	/*
	 *  广告的审核信息   /web/administrator/advertisement
	 *  参数：
	 *   @id
	 */
	@Resource(name = "advertisementservice")
	private IAdvertisementService advertisementservice;
	private String id;
	public String advertisementdata(){
		try{
			Advertisement advertisement = advertisementservice.GetAd(id);
			ServletActionContext.getRequest().setAttribute("advertisement",advertisement);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 * 广告审核结果 /web/administrator/examineadvertisement
	 * 参数：
	 *   @id
	 *   @phone
	 *   @result //审核结果   1：通过  -1：不通过
	 *   @title //广告的主题
	 */
	@Resource(name = "sendmessage")
	private SendMessage sendmessage;
	private String result;
	private String title;//广告的主题
	public String examineAdvertisement() throws Exception{
		try{
			service.changeAdvertisementStatus(id, result);
//			短信通知
	        sendmessage.SendAdvertisementExamineResult(phone, result, title);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 *  用户的审核信息  /web/administrator/user
	 *  参数：
	 *   @phone
	 *   @userclass 
	 */
	
	@Resource(name = "carownerservice")
	private ICarOwnerService carownerservice;
	
	@Resource(name = "advertiserservice")
	private IAdvertiserService advertiserservice;
	
	private String userclass;
	
	public String userdata(){
		try{
			if(userclass.equals("1")){//管理员
				User user =service.getAdministratorinfo(phone);
				ServletActionContext.getRequest().setAttribute("userinfo",user);
			}else if(userclass.equals("2")) {//广告商
				Advertiser advertiser = advertiserservice.getAdvertisementinfo(phone);
				ServletActionContext.getRequest().setAttribute("userinfo",advertiser);
			}else{//车主
				CarOwner carowner = carownerservice.getUserbyPhone(phone);
				ServletActionContext.getRequest().setAttribute("userinfo",carowner);
			}
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/* 
	 *  用户的审核结果 /web/administrator/examineuser
	 *  参数：
	 *   @phone
	 *   @result //审核结果   1：通过  -1：不通过
	 *   @userclass //用户的类别
	 *
	 */
	public String examineUser() throws Exception{
		try{
			service.changeUserStatus(phone, result);
//			短信通知
	        sendmessage.SendUserExamineResult(phone, result, userclass);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 *  return finance of the company 
	 *  
	 */
	
	public String wholeFinance() throws Exception{
		try{
			List<Finance> finances = service.wholefinace();
			ServletActionContext.getRequest().setAttribute("finance",finances);
			return "success";
		}catch(Exception e){
			return "fail";
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

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public File getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(File identityCard) {
		this.identityCard = identityCard;
	}

	public String getIdentityCardContentType() {
		return identityCardContentType;
	}

	public void setIdentityCardContentType(String identityCardContentType) {
		this.identityCardContentType = identityCardContentType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserclass() {
		return userclass;
	}

	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	
	
	
	
	
}
