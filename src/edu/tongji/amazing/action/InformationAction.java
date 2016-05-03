package edu.tongji.amazing.action;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.UpLoadFile;

@Controller("infromation")
public class InformationAction extends ActionSupport implements ServletRequestAware{
	private String phone;
	private String identity;
	private String password;
	private String email;
	private String drivinglicense;
	private String carnumber;
	private String realname;
	private HashMap<String, Object> data;
	@Resource(name = "carownerservice")
	private ICarOwnerService service;
	@Resource(name = "user")
	private User user;
	@Resource(name = "carowner")
	private CarOwner carowner;
	@Resource(name = "define")
	private Defined defined;
	@Resource(name="uploadfile")
	private UpLoadFile upload;
	private File image;
	private String imageContentType;
	private File identitycard;
	private String identitycardContentType;
	private File drivinglicensecard;
	private String drivinglicensecardContentType;
	private HttpServletRequest request;
	// 对应的android/user/addinformation 的执行方法
	public String addInfromation() throws Exception {
		carowner = service.getUserbyPhone(phone);
		user = carowner.getUser();
		if(identitycard != null){
			String path = request.getSession().getServletContext().getRealPath("/IdentityCard");
			path = upload.SaveFile(identitycard, path, identitycardContentType);
			String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
			user.setIdentityCard(urlpath);;
		}
		if(drivinglicensecard != null){
			String path = request.getSession().getServletContext().getRealPath("/DrivingLicense");
			path = upload.SaveFile(drivinglicensecard, path, drivinglicensecardContentType);
			String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
			carowner.setDrivinglicenseCard(urlpath);
		}
		user.setIdentity(identity);
		user.setBalace(0.0f);
		user.setCredit(0.0f);
		user.setRealname(realname);
		carowner.setDrivinglicense(drivinglicense);
		carowner.setCarnumber(carnumber);
		data = new HashMap<String, Object>();
		if (service.updateUser(carowner)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "result";
	}

	// 对应的android/user/carowenrinfo?phone= 的执行方法
	public String getInformation() throws Exception {
		data = new HashMap<String, Object>();
		carowner = service.getUserbyPhone(phone);
		if (carowner != null) {
			data.put(defined.Error, defined.SUCCESS);
			data.put("carowner", carowner);
		} else {
			data.put(defined.Error, defined.NOUSER);
		}
		return "result";
	}

	// 对应的android/user/changepassword 的执行方法
	public String changePassword() throws Exception {
		data = new HashMap<String, Object>();
		carowner = service.getUserbyPhone(phone);
		if (carowner == null) {
			data.put(defined.Error, defined.NOUSER);
			return "result";
		}
		user = carowner.getUser();
		user.setPassword(password);
		carowner.setUser(user);
		if (service.updateUser(carowner)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "result";
	}
	// 对应的android/user/changeavatar 的执行方法
	public String uploadavatar()throws Exception{
		data = new HashMap<String,Object>();
		String path = request.getSession().getServletContext().getRealPath("/Avatar");
		try{
			String filepath = upload.SaveFile(image, path, imageContentType);
			String urlpath = defined.baseurl+"/AmazingAd"+filepath.split("AmazingAd")[1].replace('\\', '/');
//			System.out.println(urlpath);
			service.changeavatar(phone, urlpath);
			data.put(defined.Error, defined.SUCCESS);
			data.put("url", urlpath);
		}catch (Exception e){
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDrivinglicense() {
		return drivinglicense;
	}

	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
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

	public File getDrivinglicensecard() {
		return drivinglicensecard;
	}

	public void setDrivinglicensecard(File drivinglicensecard) {
		this.drivinglicensecard = drivinglicensecard;
	}

	public String getDrivinglicensecardContentType() {
		return drivinglicensecardContentType;
	}

	public void setDrivinglicensecardContentType(String drivinglicensecardContentType) {
		this.drivinglicensecardContentType = drivinglicensecardContentType;
	}

	

}
