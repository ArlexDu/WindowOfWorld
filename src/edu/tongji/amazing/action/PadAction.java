package edu.tongji.amazing.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.IBulletService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.PushMsgToDevice;

@Controller("padaction")
public class PadAction extends ActionSupport {

	private String phone;
	private String channelid;

	@Resource(name = "define")
	private Defined define;

	@Resource(name = "carowner")
	private CarOwner owner;

	@Resource(name = "carownerservice")
	private ICarOwnerService service;

	private HashMap<String, Object> data;

	/*
	 * band user and pad /android/user/productid parameter
	 * 
	 * @phone
	 * 
	 * @channelid
	 */
	public String SetProductId() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String, Object>();
		try {
			service.setProductId(phone, channelid);
			data.put(define.Error, define.SUCCESS);
		} catch (Exception e) {
			data.put(define.Error, define.FAIL);
		}
		return "result";
	}

	/*
	 * get phonemuber by channelid parameter:
	 * 
	 * @channelid
	 */
	public String GetphoneByChannelid() throws Exception {
		data = new HashMap<String, Object>();
		try {
			String phone = service.GetphonebyChannelid(channelid);
			data.put("phone", phone);
			data.put(define.Error, define.SUCCESS);
		} catch (Exception e) {
			data.put(define.Error, define.FAIL);
		}
		return "result";
	}

	/*
	 * send barrage to pad /android/user/sendbarrage parameter:
	 * 
	 * @phone
	 * 
	 * @key
	 */
	private String key;
	@Resource(name = "bullet")
	private Bullet barrage;
	@Resource(name = "bulletservice")
	private IBulletService bulletService;
	@Resource(name = "sendinfo")
	private PushMsgToDevice push;

	public class bag {
		private String content;
		private String color;
		private String size;

		public bag() {
			// TODO Auto-generated constructor stub
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

	}

	public String SendBarrage() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String, Object>();
		try {
			// System.out.println("key is "+key);
			String p_id = service.getProduct(phone);
			barrage = bulletService.GetBarrageByKey(phone, key);
			bag send = new bag();
			send.setContent(barrage.getContent());
			send.setColor(barrage.getColor());
			send.setSize(barrage.getSize());
			push.send(p_id, send, "1");
			data.put(define.Error, define.SUCCESS);
		} catch (Exception e) {
			data.put(define.Error, define.FAIL);
			e.printStackTrace();
		}
		return "result";
	}

	/*
	 * send advertisement by coordinate /android/user/sendcoordinate parameter:
	 * 
	 * @phone
	 * 
	 * @longitude
	 * 
	 * @latitude
	 */
	private String type; // 1:normal 2:school and hospital and so on
	private String longitude;
	private String latitude;

	// 推送到pad的广告信息
	public class ad {

		private String sort;
		private String content;

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

	// 特殊地点的枚举
	public enum Place {
		SCHOOL("学校", "school"), HOSPITAL("医院", "hospital"), HOTEL("酒店", "hotel");

		private String name;
		private String code;

		private Place(String name, String code) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@Resource
	private IAdvertisementService adservice;

	public String SendAdvertisement() throws Exception {
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
				ad a = new ad();
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
					ad a = new ad();
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
			data.put(define.Error, define.SUCCESS);
		} catch (Exception e) {
			data.put(define.Error, define.FAIL);
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

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
