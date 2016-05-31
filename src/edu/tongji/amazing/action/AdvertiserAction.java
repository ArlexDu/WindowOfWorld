package edu.tongji.amazing.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.IAdvertiserService;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.service.impl.AdvertiserService;
import edu.tongji.amazing.tool.SendEmail;
import edu.tongji.amazing.tool.FileTools;
@Controller("advertiserAction")
public class AdvertiserAction extends ActionSupport implements ServletRequestAware{

	@Resource(name = "advertiserservice")
	private AdvertiserService service;
	
	@Resource(name = "carownerservice")
	private ICarOwnerService userservice;
	
	@Resource(name = "advertisementservice")
	private IAdvertisementService adservice;
	
	private HashMap<String, Object> data;
	
	@Resource(name = "advertiser")
	private Advertiser advertiser;
	
	
//	闁哄倹澹嗗▓鎴︾嵁閸喗鍟為柛鐔锋閺佺偤宕橀敓锟�
	private String phone;
	private String username;
	private String realname;
	private String identity;
	private String password;
	private String licence;
	private String mail;
	@Resource(name="user")
	private User user;
	private float charge;
	
	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	/*  婵烇綀顕ф慨鐐哄棘閹殿喗鐣辨鐐茬仢閹诧繝宕敓锟�
	 *  闁告瑥鍊归弳鐔兼晬閿燂拷
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
//				System.out.println("url:"+urlpath);
			}
			if(licensecard != null){
				String path = request.getSession().getServletContext().getRealPath("/Businesslicense");
				path = upload.SaveFile(licensecard, path, licensecardContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				advertiser.setLicensecard(urlpath);
//				System.out.println("url:"+urlpath);
			}
			if(identitycard != null){
				String path = request.getSession().getServletContext().getRealPath("/IdentityCard");
				path = upload.SaveFile(identitycard, path, identitycardContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				user.setIdentityCard(urlpath);
//				System.out.println("url:"+urlpath);
			}
			user.setBalace(0.0f);
			user.setCredit(0.0f);
			user.setIdentity(identity);
			user.setPassword(password);
			user.setPhone(phone);
			user.setRealname(realname);
			user.setUsername(username);
			user.setUserclass("2");//妤犵偛鐏濋幉锟犲疮閿燂拷
			user.setStatus("-2");//闁哄牜浜濈缓鍝劽洪敓锟�
			String time = String.valueOf(new Date().getTime());//閻庢稒锚閸嬪秹寮崼鏇燂紵闁硅揪鎷�
			user.setTime(time);
			advertiser.setLicense(licence);
			advertiser.setPhone(phone);
			
			advertiser.setMail(mail);
			advertiser.setUser(user);
			service.addAdvertise(advertiser);
			sendemail.send(mail,phone);
			
			Cookie cooki; 
			cooki=new Cookie("userphone",phone);//鐢ㄦ埛ID 
			cooki.setMaxAge(60*60);//cookie鏃堕棿 
			cooki.setPath("/AmazingAd/Webapp/wow"); //鏍规嵁涓汉鐨勪笉鐢紝鍦ㄤ笉鍚屽姛鑳界殑璺緞涓嬪垱寤� 
			response.addCookie(cooki); 
			
			return "success";
			
		}catch(Exception e){
			return "fail";
		}
	}
	
	public void hasuser(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=null;
		try {
			out= response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(userservice.IsUserExist(phone)==null)
			out.print("false");
		else 
			out.print("true");
			out.flush();
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
		
//		System.out.println(phone);
//		System.out.println(password);
	
		try{
			
			if(userservice.IsUserExist(phone)==null){
				out.print("娌℃湁姝ょ敤鎴�");
				out.flush();
			}else if(userservice.checkUser(phone, password)){
				Cookie cooki; 
				cooki=new Cookie("userphone",phone);//鐢ㄦ埛ID 
				cooki.setMaxAge(60*60);//cookie鏃堕棿 
				cooki.setPath("/AmazingAd/Webapp/wow"); //鏍规嵁涓汉鐨勪笉鐢紝鍦ㄤ笉鍚屽姛鑳界殑璺緞涓嬪垱寤� 
				response.addCookie(cooki); 
				out.print("success");
				out.flush();
			}else{
				out.print("瀵嗙爜閿欒");
				out.flush();
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public String getAllAdByPhone(){
//		System.out.println(phone);
		List<Advertisement> ads=adservice.GetAdsList(phone);
		data= new HashMap<String, Object>();
		
		 if(ads.size()==0){
			 data.put(defined.Error, defined.FAIL);
		 }else{
			 data.put(defined.Error, defined.SUCCESS);
			 data.put("adList", ads); 
		 }
		return "success";
	}
	
	public String getUserInfo(){
		try {
			advertiser=service.getAdvertisementinfo(phone);
			data= new HashMap<String, Object>();
			 data.put(defined.Error, defined.SUCCESS);
			 advertiser.getUser().setPassword("");//灞忚斀鏁忔劅淇℃伅
			 data.put("userinfo", advertiser); 
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		
		return "success";
	}

	@Resource(name = "balanceservice")
	private IBalanceService balanceservice;
	
	@Resource(name = "balance")
	private Balance balance;

	//充值
	public String charge() throws Exception {

		data = new HashMap<String, Object>();
		balance.setMoney(Float.toString(charge));
		balance.setPhone(phone);
		balance.setReason("charge");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 璁剧疆鏃ユ湡鏍煎紡
		String time = df.format(new Date());// new Date()涓鸿幏鍙栧綋鍓嶇郴缁熸椂闂�
		balance.setTime(time);
		if (!balanceservice.changeBalance(balance)) {
			data.put(defined.Error, defined.FAIL);
			return "success";
		}
		data.put(defined.Error, defined.SUCCESS);
		return "success";
//		System.out.println(phone);
//		System.out.println(charge);
//		return "success";
	}

	
	/*
	 * 闂侇収鍠氶鍫濃攽閿熻棄煤閿燂拷  
	 *  闁告瑥鍊归弳鐔兼晬閿燂拷
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
	
	/* 闁哄洤鐡ㄩ弻濠囩嵁閸喗鍟為柛鐔锋娣囧﹪骞侀敓锟� (鐎垫澘鎳庨悾锟�)
	 * 闁告瑯浜滈崢鎴犳媼閸涘﹥绾柟骞垮灪婢ф粓寮甸崫鍕▏闁挎稑鐭傞崑鏍不閹插绀夐柡鍕暩琚ㄩ柨娑樿嫰閻︽垿鎯嶆笟濠勭闁瑰瓨鍨奸～搴☆嚗濡ゅ嫮绠瑰ù婊勭〒濞堟垿寮寸�涙ɑ鏆梻鍥锋嫹閻熸洑妞掔粩瀛樼▔椤忓啴鍤嬮柡澶堝劜閺佸ジ鎳撶仦鑲╃憹闁哄嫷鍨粩瀵告導闁垮鏆柣銊ュ缁憋拷
	 * 闁告瑥鍊归弳鐔兼晬閿燂拷
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
			user.setStatus("0");//闁哄牜浜滈鎼佸冀閿燂拷
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
