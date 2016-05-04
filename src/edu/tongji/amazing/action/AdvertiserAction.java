package edu.tongji.amazing.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.IAdvertiserService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.SendEmail;
import edu.tongji.amazing.tool.FileTools;
@Controller("advertiserAction")
public class AdvertiserAction extends ActionSupport implements ServletRequestAware{

	@Resource(name = "advertiserservice")
	private IAdvertiserService service;
	
	@Resource(name = "carownerservice")
	private ICarOwnerService userservice;
	
	@Resource(name = "advertisementservice")
	private IAdvertisementService adservice;
	
	private HashMap<String, Object> data;
	
	@Resource(name = "advertiser")
	private Advertiser advertiser;
	
//	鏂扮殑骞垮憡鍟嗘敞鍐�
	private String phone;
	private String username;
	private String realname;
	private String identity;
	private String password;
	private String licence;
	private String mail;
	@Resource(name="user")
	private User user;
	
	/*  娣诲姞鏂扮殑骞垮憡鍟�
	 *  鍙傛暟锛�
	 *    @avatar
	 *    @licence
	 *    @licensecard
	 *    @identity
	 *    @phone
	 *    @password
	 *    @mail
	 *    @identityCard
	 *    @license
	 *     
	 */
	private File avatar;
	private File licensecard;
	private String avatarContentType;
	private String licensecardContentType;
	private File identitycard;
	private String identitycardContentType;
	private HttpServletRequest request;
	@Resource(name="filetool")
	private FileTools upload;
	
	@Resource(name = "sendemail")
	private SendEmail sendemail;
	
	@Resource(name = "define")
	private Defined defined;
	
	public String register() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out= response.getWriter();
		try{
			if(avatar != null){
				String path = request.getSession().getServletContext().getRealPath("/Avatar");
				path = upload.SaveFile(avatar, path, avatarContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				user.setAvatar(urlpath);
				System.out.println("avatar>>");
			}
			System.out.println(avatar);
			if(licensecard != null){
				String path = request.getSession().getServletContext().getRealPath("/Businesslicense");
				path = upload.SaveFile(licensecard, path, licensecardContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				advertiser.setLicensecard(urlpath);
				System.out.println("licensecard>>");
			}
			System.out.println(licensecard);
			if(identitycard != null){
				String path = request.getSession().getServletContext().getRealPath("/IdentityCard");
				path = upload.SaveFile(identitycard, path, identitycardContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				user.setIdentityCard(urlpath);
				System.out.println("identitycard>>");
			}
			System.out.println(identitycard);
			user.setBalace(0.0f);
			user.setCredit(0.0f);
			user.setIdentity(identity);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRealname(realname);
			user.setUsername(username);
			
			System.out.println(identity);
			System.out.println(password);
			System.out.println(phone);
			System.out.println(realname);
			System.out.println(username);
			
			user.setUserclass("2");//骞垮憡鍟�
			user.setStatus("-2");//鏈縺娲�
			String time = String.valueOf(new Date().getTime());//瀛樺偍鏃堕棿鎴�
			user.setTime(time);
			advertiser.setLicense(licence);
			advertiser.setPhone(phone);
			
			advertiser.setMail(mail);
			System.out.println(licence);
			System.out.println(phone);
			System.out.println(mail);
			
			advertiser.setUser(user);
			//service.addAdvertise(advertiser);
//			out.print("true");
//			out.flush();
			//sendemail.send(mail,phone);
			
			return "success";
			
		}catch(Exception e){
//			out.print("false");
//			out.flush();
			return "fail";
		}
	}
	
	
	public void login(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=null;
		try {
			out= response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(phone);
		System.out.println(password);
		
		try{
			
			if(userservice.getUserbyPhone(phone)==null){
				out.println("no such user");
				out.flush();
			}else if(userservice.checkUser(phone, password)){
				out.println("success");
				out.flush();
				//设置cookie
		        // 创建一个Cookie,包括(key,value).
		        Cookie cookie = new Cookie("userphone", phone);
		        // 设置Cookie的生命周期,如果设置为负值的话,关闭浏览器就失效.
		        cookie.setMaxAge(60*60*24);
		        // 设置Cookie路径,不设置的话为当前路径(对于Servlet来说为request.getContextPath() + web.xml里配置的该Servlet的url-pattern路径部分)
		        cookie.setPath("/AmazingAd/Webapp/wow");
		        // 输出Cookie
		        response.addCookie(cookie);
			
			}else{
				out.println("wrong password");
				out.flush();
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	
	public void getAllAdByPhone(){
		System.out.println(phone);
		List<Advertisement> ads=adservice.GetAdsList(phone);
		System.out.println(ads.size());
		
	}
	
	/*
	 * 閭婵�娲�  
	 *  鍙傛暟锛�
	 *  @phone
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
	
	/* 鏇存柊骞垮憡鍟嗕俊鎭� (寰呭畾)
	 * 鍙厑璁告洿鎹㈡墜鏈哄彿锛岄偖绠憋紝鏄电О锛屽瘑鐮侊紙鎴戣寰楄繖浜涚殑鏇存敼闇�瑕佷竴涓釜鏉ユ敼鑰屼笉鏄竴璧锋敼鐨勶級
	 * 鍙傛暟锛�
	 *    @phone
	 *    @authcode
	 *    @password
	 *    @mail
	 *  
	 */
		public String updateAdvertiser() throws Exception{

			user.setIdentity(identity);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRealname(realname);
			user.setUsername(username);
			user.setStatus("0");//鏈鏍�
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
