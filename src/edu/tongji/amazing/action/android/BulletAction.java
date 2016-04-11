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
	private String identity = null;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
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

	@Override
	public String execute() throws Exception {
		data = new HashMap<String, Object>();
		 if(method.equals("getBullet")){
			 bullet = bulletservice.getBullet(id);
			 if(bullet == null){
				 data.put("errCode", 0);
			 }else{
				 data.put("errCode", 1);
				 data.put("bullet", bullet);
			 }
			 return "success";
		 }else if(method.equals("getAllBullet")){
			 bulletList= bulletservice.getAllBullet(identity);
			 if(bulletList.size()==0){
				 data.put("errCode", 0);
			 }else{
				 data.put("errCode", 1);
				 data.put("bulletList", bulletList);
			 }
			 return "success";
		 }else if(method.equals("addBullet")){
			 Bullet addbullet=new Bullet();
			 addbullet.setUserId(identity);
			 addbullet.setTime(time);
			 addbullet.setContent(content);
			 bulletservice.addBulet(addbullet);
			 return "success";
		 }
		 else{
			 System.out.println("xxxxxxx"+method);
			 return "fail";
		 }

	}

}
