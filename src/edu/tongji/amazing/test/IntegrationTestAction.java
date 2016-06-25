package edu.tongji.amazing.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import edu.tongji.amazing.action.PadAction;
import edu.tongji.amazing.action.PadAction.Place;
import edu.tongji.amazing.action.PadAction.ad;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.Individuation;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.service.IBulletService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.service.IIndividuationService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.FileTools;
import edu.tongji.amazing.tool.PushMsgToDevice;
import edu.tongji.amazing.tool.SendMessage;


@Controller("integrationtestAction")
public class IntegrationTestAction {
	
	
	private Map<String, Object> data;
	@Resource
	private ICarOwnerService service;

	@Resource(name = "define")
	private Defined defined;
	
	
	//integration of loginAndroid
	public String loginAndroid_stub1(String phone, String password) {
		// TODO Auto-generated method stub
		if (phone.equals("") || password.equals("")) {
			return null;
		}
		if (password.length() < 8) {
			return null;
		}
		if (!phone.matches("[0-9]+")) {
			return null;
		}
		data = new HashMap<String, Object>();
		// 判断是否有此用户
		if (service.IsUserExist("15021796775") == null) {
			data.put(defined.Error, defined.NOUSER);
			return "success";
		}
		if (service.checkUser("15021799675", "dsy941225")) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.WrongPassword);
		}
		return "success";
	}
	public String loginAndroid_stub2(String phone, String password) {
		// TODO Auto-generated method stub
		if (phone.equals("") || password.equals("")) {
			return null;
		}
		if (password.length() < 8) {
			return null;
		}
		if (!phone.matches("[0-9]+")) {
			return null;
		}
		data = new HashMap<String, Object>();
		// 判断是否有此用户
		if (service.IsUserExist(phone) == null) {
			data.put(defined.Error, defined.NOUSER);
			return "account not catlog";
		}
		if (service.checkUser("15021799675", "dsy941225")) {
			data.put(defined.Error, defined.SUCCESS);
			return "success";
			
		} else {
			data.put(defined.Error, defined.WrongPassword);
			return "wrong password";
		}
		
	}
	public String loginAndroid_stub3(String phone, String password) {
		// TODO Auto-generated method stub
		if (phone.equals("") || password.equals("")) {
			return null;
		}
		if (password.length() < 8) {
			return null;
		}
		if (!phone.matches("[0-9]+")) {
			return null;
		}
		data = new HashMap<String, Object>();
		// 判断是否有此用户
		if (service.IsUserExist(phone) == null) {
			data.put(defined.Error, defined.NOUSER);
			return "account not catlog";
		}
		if (service.checkUser(phone, password)) {
			data.put(defined.Error, defined.SUCCESS);
			return "success";
		} else {
			data.put(defined.Error, defined.WrongPassword);
			return "wrong password";
		}
		
	}
	
	
	@Resource(name = "sendinfo")
	private PushMsgToDevice push;
	@Resource
	private IAdvertisementService adservice;
	public String sendAd_stub1(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat>3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise("104.11", "28.33");
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu("104.11", "28.33", "学校")) {
					rawads.addAll(adservice.SpecialShowAdvertisements("学校"));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct("15021799675");
			push.send("214214214214", null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	public String sendAd_stub2(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat>3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise(longitude, latitude);
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu("104.11", "28.33", "学校")) {
					rawads.addAll(adservice.SpecialShowAdvertisements("学校"));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct("15021799675");
			push.send("214214214214", null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	public String sendAd_stub3(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat<3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise(longitude, latitude);
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu(longitude, latitude, curplace.getName())) {
					rawads.addAll(adservice.SpecialShowAdvertisements("学校"));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct("15021799675");
			push.send("214214214214", null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	public String sendAd_stub4(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat<3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise(longitude, latitude);
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu(longitude, latitude, curplace.getName())) {
					rawads.addAll(adservice.SpecialShowAdvertisements(curplace.getName()));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct("15021799675");
			push.send("214214214214", null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	public String sendAd_stub5(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat<3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise(longitude, latitude);
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu(longitude, latitude, curplace.getName())) {
					rawads.addAll(adservice.SpecialShowAdvertisements(curplace.getName()));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct(phone);
			push.send("214214214214", null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	public String sendAd_stub6(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return "wrong";
		}
		Double lng=Double.parseDouble(longitude);
		Double lat=Double.parseDouble(latitude);
		if(lng>135.05||lng<73.33||lat>53.33||lat<3.51){
			return "wrong";
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise(longitude, latitude);
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu(longitude, latitude, curplace.getName())) {
					rawads.addAll(adservice.SpecialShowAdvertisements(curplace.getName()));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct(phone);
			push.send(p_id, advertisements, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	
	@Resource(name = "balanceservice")
	private IBalanceService balanceservice;
	
	@Resource(name = "balance")
	private Balance balance;
	public String changeBill_stub1(String money,String phone,String reason) throws Exception{
		if(money.equals("")||phone.equals("")||reason.equals("")){
			return "failed";
		}
		data = new HashMap<String, Object>();
		balance.setMoney("1000");
		balance.setPhone("15021799675");
		balance.setReason("because of love");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		balance.setTime("2016/6/25");
		if (!balanceservice.changeBalance(balance)) {
			data.put(defined.Error, defined.FAIL);
			return "result";
		}
		data.put(defined.Error, defined.SUCCESS);
		return "success";
	}
	public String changeBill_stub2(String money,String phone,String reason) throws Exception{
		if(money.equals("")||phone.equals("")||reason.equals("")){
			return "failed";
		}
		data = new HashMap<String, Object>();
		balance.setMoney(money);
		balance.setPhone(phone);
		balance.setReason(reason);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		balance.setTime(time);
		if (!balanceservice.changeBalance(balance)) {
			data.put(defined.Error, defined.FAIL);
			return "result";
		}
		data.put(defined.Error, defined.SUCCESS);
		return "success";
	}
	
	
	@Resource(name = "individuation")
	private Individuation individuation;

	@Resource(name = "individuationservice")
	private IIndividuationService service1;


	@Resource(name = "filetool")
	private FileTools upload;
	
	public String addindividuation_stub1(File image,String imageContentType,String phone,String title,String description) throws Exception {
		if(image==null||imageContentType.equals("")||phone.equals("")||title.equals("")||description.equals("")){
			return "result";
		}
		data = new HashMap<String, Object>();
		File file=new File("D:\\asszy.jpg");
		if(!file.exists()){
			return "result";
		}
		try {
			String path=defined.baseurl+"/AmazingAd";
			String filepath = upload.SaveFile(file, path, ".jpg");
			String urlpath = defined.baseurl+"/AmazingAd" + filepath.split("AmazingAd")[1].replace('\\', '/');
	//		System.out.println("individuation phone is "+phone);
			individuation.setPhone("15012349675");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			individuation.setTime(time);
			individuation.setTitle("hah");
			individuation.setDescription("ddddddd");
			individuation.setContent(urlpath);
			individuation.setStatus("-1");
			if (!service1.AddIndividuation(individuation)) {
				data.put(defined.Error, defined.FAIL);
				return "result";
			}
			data.put(defined.Error, defined.SUCCESS);
			data.put("url", urlpath);
			return "success";
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
			return "result";
		}
	}
	public String addindividuation_stub2(File image,String imageContentType,String phone,String title,String description) throws Exception {
		if(image==null||imageContentType.equals("")||phone.equals("")||title.equals("")||description.equals("")){
			return "result";
		}
		data = new HashMap<String, Object>();
		
		try {
			String path=defined.baseurl+"/AmazingAd";
			String filepath = upload.SaveFile(image, path, imageContentType);
			String urlpath = defined.baseurl+"/AmazingAd" + filepath.split("AmazingAd")[1].replace('\\', '/');
	//		System.out.println("individuation phone is "+phone);
			individuation.setPhone("15021799675");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			individuation.setTime(time);
			individuation.setTitle("hah");
			individuation.setDescription("ddddddd");
			individuation.setContent(urlpath);
			individuation.setStatus("-1");
			if (!service1.AddIndividuation(individuation)) {
				data.put(defined.Error, defined.FAIL);
				return "result";
			}
			data.put(defined.Error, defined.SUCCESS);
			data.put("url", urlpath);
			return "success";
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
			return "result";
		}
	}
	public String addindividuation_stub3(File image,String imageContentType,String phone,String title,String description) throws Exception {
		if(image==null||imageContentType.equals("")||phone.equals("")||title.equals("")||description.equals("")){
			return "result";
		}
		data = new HashMap<String, Object>();
		String path=defined.baseurl+"/AmazingAd";
		try {
			String filepath = upload.SaveFile(image, path, imageContentType);
			String urlpath = defined.baseurl+"/AmazingAd" + filepath.split("AmazingAd")[1].replace('\\', '/');
	//		System.out.println("individuation phone is "+phone);
			individuation.setPhone(phone);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			individuation.setTime(time);
			individuation.setTitle(title);
			individuation.setDescription(description);
			individuation.setContent(urlpath);
			individuation.setStatus("-1");
			if (!service1.AddIndividuation(individuation)) {
				data.put(defined.Error, defined.FAIL);
				return "result";
			}
			data.put(defined.Error, defined.SUCCESS);
			data.put("url", urlpath);
			return "success";
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
			return "result";
		}
	}
	
	
	@Resource(name = "sendmessage")
	private SendMessage sendmessage;
	@Resource(name="administratorservice")
	private IAdministratorService service11;
	public String examineUser_stub1(String phone,String result,String userclass) throws Exception{
		if(phone.equals("")||result.equals("")||userclass.equals("")){
			return "fail";
		}
		try{
			service11.changeUserStatus("15021799675", "1");                             
//			鐭俊閫氱煡
	        sendmessage.SendUserExamineResult("15021799675", "1", "1");
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	public String examineUser_stub2(String phone,String result,String userclass) throws Exception{
		if(phone.equals("")||result.equals("")||userclass.equals("")){
			return "fail";
		}
		try{
			service11.changeUserStatus(phone, result);                             
//			鐭俊閫氱煡
			sendmessage.SendUserExamineResult("15021799675", "1", "1");
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	public String examineUser_stub3(String phone,String result,String userclass) throws Exception{
		if(phone.equals("")||result.equals("")||userclass.equals("")){
			return "fail";
		}
		try{
			service11.changeUserStatus(phone, result);                             
//			鐭俊閫氱煡
	        sendmessage.SendUserExamineResult(phone, result, userclass);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	@Resource(name="bullet")
	private Bullet bullet;
	@Resource(name = "bulletservice")
	private IBulletService bulletservice;
	public String changebarrage_stub1(String phone,String content,String color,String size,String title,String key,String updateid) throws Exception{
		 if(phone.equals("")||content.equals("")||color.equals("")||size.equals("")||title.equals("")||key.equals("")){
			 return "fail";
		 }
		 data = new HashMap<String, Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String time = df.format(new Date());// new Date()为获取当前系统时间
//	     System.out.println("barrage phone is "+phone);
	     bullet.setPhone("15221605290");
		 bullet.setTime("2016/5/25");
		 bullet.setContent("sssssss");
		 bullet.setColor("#ac5318");
		 bullet.setSize("100");
		 bullet.setTitle("title");
		 bullet.setKey("1");
		 
		 if(!bulletservice.clearShortCut("15221605290", "1")){
			 data.put(defined.Error, defined.FAIL);
			 return "failed";
		 }
		 if(updateid != null){//更新操作
			 bullet.setId(updateid);
			 if(bulletservice.updateBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }
			 updateid = null;
		 }else{//添加新的弹幕
			 if(bulletservice.addBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }

		 }
		 return "success";
	}
	public String changebarrage_stub2(String phone,String content,String color,String size,String title,String key,String updateid) throws Exception{
		 if(phone.equals("")||content.equals("")||color.equals("")||size.equals("")||title.equals("")||key.equals("")){
			 return "fail";
		 }
		 data = new HashMap<String, Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String time = df.format(new Date());// new Date()为获取当前系统时间
//	     System.out.println("barrage phone is "+phone);
		 bullet.setPhone("15221605290");
		 bullet.setTime("2016/5/25");
		 bullet.setContent("sssssss");
		 bullet.setColor("#ac5318");
		 bullet.setSize("100");
		 bullet.setTitle("title");
		 bullet.setKey("1");
		 if(!bulletservice.clearShortCut(phone, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "failed";
		 }
		 if(updateid != null){//更新操作
			 bullet.setId("2");
			 if(bulletservice.updateBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }
			 updateid = null;
		 }else{//添加新的弹幕
			 if(bulletservice.addBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }

		 }
		 return "success";
	}
	public String changebarrage_stub3(String phone,String content,String color,String size,String title,String key,String updateid) throws Exception{
		 if(phone.equals("")||content.equals("")||color.equals("")||size.equals("")||title.equals("")||key.equals("")){
			 return "fail";
		 }
		 data = new HashMap<String, Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String time = df.format(new Date());// new Date()为获取当前系统时间
//	     System.out.println("barrage phone is "+phone);
		 bullet.setPhone(phone);
		 bullet.setTime(time);
		 bullet.setContent(content);
		 bullet.setColor(color);
		 bullet.setSize(size);
		 bullet.setTitle(title);
		 bullet.setKey(key);
		 if(!bulletservice.clearShortCut(phone, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "failed";
		 }
		 if(updateid != null){//更新操作
			 bullet.setId(updateid);
			 
			 if(bulletservice.updateBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }
			 updateid = null;
		 }else{//添加新的弹幕
			 if(bulletservice.addBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }

		 }
		 return "success";
	}
	public String changebarrage_stub4(String phone,String content,String color,String size,String title,String key,String updateid) throws Exception{
		 if(phone.equals("")||content.equals("")||color.equals("")||size.equals("")||title.equals("")||key.equals("")){
			 return "fail";
		 }
		 data = new HashMap<String, Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String time = df.format(new Date());// new Date()为获取当前系统时间
//	     System.out.println("barrage phone is "+phone);
		 bullet.setPhone(phone);
		 bullet.setTime(time);
		 bullet.setContent(content);
		 bullet.setColor(color);
		 bullet.setSize(size);
		 bullet.setTitle(title);
		 bullet.setKey(key);
		 if(!bulletservice.clearShortCut(phone, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "failed";
		 }
		 if(updateid != null){//更新操作
			 bullet.setId(updateid);
			 if(bulletservice.updateBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }
			 updateid = null;
		 }else{//添加新的弹幕
			 if(bulletservice.addBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }

		 }
		 return "success";
	}
}
