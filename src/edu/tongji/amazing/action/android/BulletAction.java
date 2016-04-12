package edu.tongji.amazing.action.android;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.service.impl.BulletService;
import edu.tongji.amazing.tool.Defined;

@Controller("bulletAndroid")
public class BulletAction extends ActionSupport {

	private Map<String, Object> data;
	@Resource(name = "bulletservice")
	private BulletService bulletservice;
	private String method = null;
	private String id = null;
	private String phone = null;
	private String time = null;
	private String content = null;
	@Resource(name="bullet")
	private Bullet bullet;
	private List<Bullet> bulletList = null;
	private String key;
	private String bulletid;
	
	@Resource(name ="define")
	private Defined defined;


	//处理 android/barrage/getbarrage 请求
	public String getbarrage() throws Exception{
		data = new HashMap<String, Object>();
			 bullet = bulletservice.getBullet(id);
			 if(bullet == null){
				 data.put(defined.Error, defined.FAIL);
			 }else{
				 data.put(defined.Error, defined.SUCCESS);
				 data.put("bulletId", bullet.getBulletId());
				 data.put("content", bullet.getContent());
				 data.put("key", bullet.getKey());
				 data.put("time", bullet.getTime());
			 }
			return "success";
	}
	//处理 android/barrage/getallbarrages 请求
	public String getAllbarrage() throws Exception{
		data = new HashMap<String, Object>();
			 bulletList= bulletservice.getAllBullet(phone);
			 if(bulletList.size()==0){
				 data.put(defined.Error, defined.FAIL);
			 }else{
				 data.put(defined.Error, defined.SUCCESS);
				 data.put("bulletList", bulletList);
			 }
			 return "success";
	}
	//处理 android/barrage/addbarrage 请求
	public String addbarrage() throws Exception{
		 data = new HashMap<String, Object>();
		 bullet.setUserId(phone);
		 bullet.setTime(time);
		 bullet.setContent(content);
		 if(bulletservice.addBulet(bullet)){
			 data.put(defined.Error, defined.SUCCESS);
		 }else{
			 data.put(defined.Error, defined.FAIL);
		 }
		 return "success";
	}
	//处理 android/barrage/shortcut 请求
	public String shortcut() throws Exception{
		 data = new HashMap<String, Object>();
		 if(!bulletservice.clearShortCut(phone, key)){
			data.put(defined.Error, defined.FAIL);
			return "result";
		 }
		 if(!bulletservice.addShortCut(bulletid, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "result";
		 }
		 data.put(defined.Error, defined.SUCCESS);
		 return "result";
	}
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getBulletid() {
		return bulletid;
	}
	public void setBulletid(String bulletid) {
		this.bulletid = bulletid;
	}
	
	

}
