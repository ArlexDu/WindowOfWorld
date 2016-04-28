package edu.tongji.amazing.action;

import java.io.File;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertiserService;
import edu.tongji.amazing.tool.SendEmail;
import edu.tongji.amazing.tool.UpLoadFile;
@Controller("advertiserAction")
public class AdvertiserAction extends ActionSupport implements ServletRequestAware{

	@Resource(name = "advertiserservice")
	private IAdvertiserService service;
	
	
	private HashMap<String, Object> data;
	
	@Resource(name = "advertiser")
	private Advertiser advertiser;
	
//	新的广告商注册
	private String phone;
	private String username;
	private String realname;
	private String identity;
	private String password;
	private String licence;
	private String mail;
	@Resource(name="user")
	private User user;
	
	//添加新的广告商
	private File avatar;
	private File licensecard;
	private String avatarContentType;
	private String licensecardContentType;
	private File identitycard;
	private String identitycardContentType;
	private HttpServletRequest request;
	@Resource(name="uploadfile")
	private UpLoadFile upload;
	
	@Resource(name = "sendemail")
	private SendEmail sendemail;
	
	public void register() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out= response.getWriter();
		try{
			if(avatar != null){
				String path = request.getSession().getServletContext().getRealPath("/Avatar");
				upload.SaveFile(avatar, path, avatarContentType);
				String urlpath = "http://10.60.42.70:8080/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				user.setAvatar(urlpath);
			}
			if(licensecard != null){
				String path = request.getSession().getServletContext().getRealPath("/Businesslicense");
				upload.SaveFile(licensecard, path, licensecardContentType);
				String urlpath = "http://10.60.42.70:8080/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				advertiser.setLicensecard(urlpath);
			}
			if(identitycard != null){
				String avatarpath = request.getSession().getServletContext().getRealPath("/IdentityCard");
				upload.SaveFile(identitycard, avatarpath, identitycardContentType);
				String urlpath = "http://10.60.42.70:8080/AmazingAd" + avatarpath.split("AmazingAd")[1].replace('\\', '/');
				user.setIdentityCard(urlpath);
			}
			user.setBalace(0.0f);
			user.setCredit(0.0f);
			user.setIdentity(identity);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRealname(realname);
			user.setUsername(username);
			user.setUserclass("2");//广告商
			user.setStatus("-2");//未激活
			advertiser.setLicense(licence);
			advertiser.setPhone(phone);
			advertiser.setMail(mail);
			advertiser.setUser(user);
			service.addAdvertise(advertiser);
			out.print("true");
			out.flush();
			sendemail.send(mail,phone);
		}catch(Exception e){
			out.print("false");
			out.flush();
		}
	}
	
	
	/*
	 * 邮箱激活  /
	 */
	public String ActiveAccount() throws Exception{
		try{
			service.activeAccount(phone);
			System.out.println("active account :"+phone);
		}catch(Exception e){
			return "fail";
		}
		return "success";
	}
	
	/*更新广告商信息 
	 * 参数： 昵称，营业执照，验证码，
	 *  
	 */
		public String updateAdvertiser() throws Exception{

			user.setIdentity(identity);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRealname(realname);
			user.setUsername(username);
			user.setStatus("0");//未审核
			advertiser.setPhone(phone);
			advertiser.setUser(user);
//			if(service.Advertise(advertiser)){
//				return "success";
//			}
			return "fail";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public File getLicensecard() {
		return licensecard;
	}

	public void setLicensecard(File licensecard) {
		this.licensecard = licensecard;
	}

	public String getLicensecardContentType() {
		return licensecardContentType;
	}

	public void setLicensecardContentType(String licensecardContentType) {
		this.licensecardContentType = licensecardContentType;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public File getIdentitycard() {
		return identitycard;
	}

	public void setIdentitycard(File identitycard) {
		this.identitycard = identitycard;
	}

	public String getIdentitycardContentType() {
		return identitycardContentType;
	}

	public void setIdentitycardContentType(String identitycardContentType) {
		this.identitycardContentType = identitycardContentType;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
