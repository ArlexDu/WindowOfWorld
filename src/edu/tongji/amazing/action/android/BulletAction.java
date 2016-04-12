package edu.tongji.amazing.action.android;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.service.impl.BulletService;

@Controller("bulletAndroid")
public class BulletAction extends ActionSupport {

	private Map<String, Object> data;

	@Resource(name = "bulletservice")
	private BulletService bulletservice;
	private String method = null;
	private String id = null;
	private String phone = null;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String time = null;
	private String content = null;
	private Bullet bullet = null;
	private List<Bullet> bulletList = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, Object> getData() {
		return data;
	}

	//处理 android/bullet/getbullet 请求
	public String getBullet() throws Exception{
		data = new HashMap<String, Object>();
			 bullet = bulletservice.getBullet(id);
			 if(bullet == null){
				 data.put("errCode", 0);
			 }else{
				 data.put("errCode", 1);
				 data.put("bullet", bullet);
			 }
			return "success";
	}
	//处理 android/bullet/getallbullets 请求
	public String getAllBullet() throws Exception{
		data = new HashMap<String, Object>();
			 bulletList= bulletservice.getAllBullet(phone);
			 if(bulletList.size()==0){
				 data.put("errCode", 0);
			 }else{
				 data.put("errCode", 1);
				 data.put("bulletList", bulletList);
			 }
			 return "success";
	}
	//处理 android/bullet/addbullet 请求
	public String addBullet() throws Exception{
		 data = new HashMap<String, Object>();
		 Bullet addbullet=new Bullet();
		 addbullet.setUserId(phone);
		 addbullet.setTime(time);
		 addbullet.setContent(content);
		 bulletservice.addBulet(addbullet);
		 return "success";
	}

}
