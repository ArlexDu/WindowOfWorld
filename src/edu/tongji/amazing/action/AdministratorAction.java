package edu.tongji.amazing.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import edu.tongji.amazing.tool.ShowAdvertisement;
import edu.tongji.amazing.tool.ShowBalance;
import edu.tongji.amazing.tool.FileTools;
@Controller("administratorAction")
public class AdministratorAction extends ActionSupport implements ServletRequestAware{

	
	@Resource(name="administratorservice")
	private IAdministratorService service;
	
	//鐢ㄤ簬灞曠ず鐨勭敤鎴�
	private List<User> users;
	
	//鑾峰緱鐨勫箍鍛�
	private List<Advertisement> advertisements;
	
	//鐢ㄤ簬灞曠ず鐨勬敮鍑轰俊鎭�
	private List<Balance> balances;
	
	private HttpServletRequest request;
	
	/*
	 * 绠＄悊鍛樼櫥褰曠殑鎺ュ彛 /web/administrator/login
	 * 鍙傛暟锛�
	 *   @phone
	 *   @password
	 */
	
	private String phone;
	private String password;
	
	
	public String Login() throws Exception {
		// TODO Auto-generated method stub銆�
		if(service.login(phone, password)){
			getHomeData();
			HttpSession session = request.getSession();
			session.setAttribute("phone", phone);
			session.setAttribute("password", password);
			return "success";
		}else{
			return "fail";
		}
	}
	
	/*
	 * 绠＄悊鍛樼殑娉ㄥ唽   /web/administrator/register
	 * 鍙傛暟锛�
	 *    @鎵嬫満鍙�
	 *    @瀵嗙爜
	 *    @韬唤璇佸彿鐮�
	 *    @鐪熷疄鐨勫鍚�
	 *    @韬唤璇佺殑鐓х墖 
	 */
	private String identity;
	private String realname;
	private String username;
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
		adminstrator.setUsername(username);
		adminstrator.setPassword(password);
		adminstrator.setIdentity(identity);
		adminstrator.setRealname(realname);
		adminstrator.setUserclass("1");
		adminstrator.setStatus("0");
		String time = String.valueOf(new Date().getTime());
		adminstrator.setTime(time);
		if(identityCard!=null){
			System.out.println("图片上传");
			String path = request.getSession().getServletContext().getRealPath("/IdentityCard");
			System.out.println(path);
			path = upload.SaveFile(identityCard, path, identityCardContentType);
			String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
			System.out.println(urlpath);
			adminstrator.setIdentityCard(urlpath);
		}
		service.addAdministrator(adminstrator);
		return "success";//杞Щ鍒颁竴涓鍦ㄧ瓑绠＄悊鍛樺鏍哥晫闈紙涓嶅厑璁告湭缁忓鏍搁�氳繃灏辩櫥褰曪級,绠＄悊鍛樿繖涓敞鍐屼笉闇�瑕佸彂楠岃瘉鐮佹垨鑰呮縺娲绘搷浣�
	}
	
	public String test() throws Exception{
		getHomeData();
		return "success";
	}
	
	
	/*
	 * 鑾峰緱home.jsp鐨勬暟鎹�
	 */
	
	private HashMap<String, Object> data;
	
	private void getHomeData(){
		try {
//			data = new HashMap<String,Object>();
		    users = service.getShowUsers();
			advertisements = service.getShowAdvertisements();
			//鑾峰緱灞曠ず鐨勫箍鍛�
			List<ShowAdvertisement> showadvertisements = new ArrayList<ShowAdvertisement>();
			for(int i=0;i<advertisements.size();i++){
				ShowAdvertisement sa = new ShowAdvertisement();
				sa.setId(advertisements.get(i).getId());
				sa.setUsername(service.GetUsernameByPhone(advertisements.get(i).getPhone()));
				sa.setPhone(advertisements.get(i).getPhone());
				sa.setPrice(advertisements.get(i).getPrice());
				sa.setStatus(advertisements.get(i).getStatus());
				sa.setDate(advertisements.get(i).getTime());
				sa.setTitle(advertisements.get(i).getTitle());
				showadvertisements.add(sa);
			}
			balances = service.getShowBalance();
			//鑾峰緱灞曠ず鐨勮储鍔�
			List<ShowBalance> showbalances = new ArrayList<ShowBalance>();
			for(int i=0;i<balances.size();i++){
				ShowBalance sbal = new ShowBalance();
				sbal.setUsername(service.GetUsernameByPhone(balances.get(i).getPhone()));
				sbal.setMoney(balances.get(i).getMoney());
				sbal.setReason(balances.get(i).getReason());
				sbal.setDate(balances.get(i).getTime());
				showbalances.add(sbal);
			}
			int alluser_number = service.getallusers();
			int alladvertisement_number = service.getalladvertisements();
			int examineuer = service.unexamineUsers();
			int examineadvertisement = service.unexamineAdvertisements();
			ServletActionContext.getRequest().setAttribute("all_user_number", alluser_number);
			ServletActionContext.getRequest().setAttribute("examine_user_number", examineuer);
			ServletActionContext.getRequest().setAttribute("all_advertisement_number", alladvertisement_number);
			ServletActionContext.getRequest().setAttribute("examine_advertisement_number", examineadvertisement);
			ServletActionContext.getRequest().setAttribute("showusers", users);
			ServletActionContext.getRequest().setAttribute("showadvertisements", showadvertisements);
			ServletActionContext.getRequest().setAttribute("showbalance", showbalances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *  骞垮憡鐨勫鏍镐俊鎭�   /web/administrator/advertisement
	 *  鍙傛暟锛�
	 *   @id
	 */
	@Resource(name = "advertisementservice")
	private IAdvertisementService advertisementservice;
	private String id;
	public String advertisementdata(){
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			Advertisement advertisement = advertisementservice.GetAd(id);
			ServletActionContext.getRequest().setAttribute("advertisement",advertisement);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 * 骞垮憡瀹℃牳缁撴灉 /web/administrator/examineadvertisement
	 * 鍙傛暟锛�
	 *   @id
	 *   @phone
	 *   @result //瀹℃牳缁撴灉   1锛氶�氳繃  -1锛氫笉閫氳繃
	 *   @title //骞垮憡鐨勪富棰�
	 */
	@Resource(name = "sendmessage")
	private SendMessage sendmessage;
	private String result;
	private String title;//骞垮憡鐨勪富棰�
	public String examineAdvertisement() throws Exception{
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			service.changeAdvertisementStatus(id, result);
//			鐭俊閫氱煡
	        sendmessage.SendAdvertisementExamineResult(phone, result, title);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 *  鐢ㄦ埛鐨勫鏍镐俊鎭�  /web/administrator/user
	 *  鍙傛暟锛�
	 *   @phone
	 *   @userclass 
	 */
	
	@Resource(name = "carownerservice")
	private ICarOwnerService carownerservice;
	
	@Resource(name = "advertiserservice")
	private IAdvertiserService advertiserservice;
	
	private String userclass;
	private String userstate;
	
	public String userdata(){
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			if(userstate.equals("1")){
				if(userclass.equals("1")){//绠＄悊鍛�
					User user =service.getAdministratorinfo(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",user);
					return "check1";
				}else if(userclass.equals("2")) {//骞垮憡鍟�
					Advertiser advertiser = advertiserservice.getAdvertisementinfo(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",advertiser);
					return "check2";
				}else{//杞︿富
					CarOwner carowner = carownerservice.getUserbyPhone(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",carowner);
					return "check3";
				}
			}else{
				if(userclass.equals("1")){//绠＄悊鍛�
					User user =service.getAdministratorinfo(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",user);
					return "success1";
				}else if(userclass.equals("2")) {//骞垮憡鍟�
					Advertiser advertiser = advertiserservice.getAdvertisementinfo(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",advertiser);
					return "success2";
				}else{//杞︿富
					CarOwner carowner = carownerservice.getUserbyPhone(phone);
					ServletActionContext.getRequest().setAttribute("userinfo",carowner);
					return "success3";
				}
			}
		}catch(Exception e){
			return "fail";
		}
	}
	
	/* 
	 *  鐢ㄦ埛鐨勫鏍哥粨鏋� /web/administrator/examineuser
	 *  鍙傛暟锛�
	 *   @phone
	 *   @result //瀹℃牳缁撴灉   1锛氶�氳繃  -1锛氫笉閫氳繃
	 *   @userclass //鐢ㄦ埛鐨勭被鍒�
	 *
	 */
	public String examineUser() throws Exception{
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			service.changeUserStatus(phone, result);
//			鐭俊閫氱煡
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
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			List<Finance> finances = service.wholefinace();
			ServletActionContext.getRequest().setAttribute("finance",finances);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 * 鍒嗛〉鑾峰緱user鐨勫垪琛�
	 *  鍙傛暟锛�
	 *     @pagenum //褰撳墠椤垫暟
	 */
	private String pagenum;
	
	public String UserTable() throws Exception{
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			int num = Integer.parseInt(pagenum);
			List<User> users = service.UserTable(num);
			ServletActionContext.getRequest().setAttribute("users",users);
			HttpSession session = request.getSession();
			session.setAttribute("pagenum", pagenum);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 * 鍒嗛〉鑾峰緱骞垮憡鐨勫垪琛�
	 *  鍙傛暟锛�
	 *     @pagenum //褰撳墠椤垫暟
	 */
	public String AdvertisementTable() throws Exception{
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			int num = Integer.parseInt(pagenum);
			List<Advertisement> advertisements = service.AdvertisementTable(num);
			//鑾峰緱灞曠ず鐨勫箍鍛�
			List<ShowAdvertisement> showadvertisements = new ArrayList<ShowAdvertisement>();
			for(int i=0;i<advertisements.size();i++){
				ShowAdvertisement sa = new ShowAdvertisement();
				sa.setId(advertisements.get(i).getId());
				sa.setUsername(service.GetUsernameByPhone(advertisements.get(i).getPhone()));
				sa.setPhone(advertisements.get(i).getPhone());
				sa.setPrice(advertisements.get(i).getPrice());
				sa.setStatus(advertisements.get(i).getStatus());
				sa.setDate(advertisements.get(i).getTime());
				sa.setTitle(advertisements.get(i).getTitle());
				showadvertisements.add(sa);
			}
			ServletActionContext.getRequest().setAttribute("advertisements",showadvertisements);
			HttpSession session = request.getSession();
			session.setAttribute("pagenum1", pagenum);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	/*
	 * 鍒嗛〉鑾峰緱鏀舵敮鐨勫垪琛�
	 *  鍙傛暟锛�
	 *     @pagenum //褰撳墠椤垫暟
	 */
	public String BalanceTable() throws Exception{
		if(request.getSession().getAttribute("phone")==null)
		{
			return "unlog";
		}
		try{
			int num = Integer.parseInt(pagenum);
			List<Balance> balances = service.BalanceTable(num);
			//鑾峰緱灞曠ず鐨勮储鍔�
			List<ShowBalance> showbalances = new ArrayList<ShowBalance>();
			for(int i=0;i<balances.size();i++){
				ShowBalance sbal = new ShowBalance();
				sbal.setUsername(service.GetUsernameByPhone(balances.get(i).getPhone()));
				sbal.setMoney(balances.get(i).getMoney());
				sbal.setReason(balances.get(i).getReason());
				sbal.setDate(balances.get(i).getTime());
				showbalances.add(sbal);
			}
			ServletActionContext.getRequest().setAttribute("balances",showbalances);
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPagenum() {
		return pagenum;
	}

	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}
	
	
	
	
	
}
