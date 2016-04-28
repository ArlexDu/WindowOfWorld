package edu.tongji.amazing.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.service.IBulletService;
import edu.tongji.amazing.service.impl.BulletService;
import edu.tongji.amazing.tool.Defined;

@Controller("bulletAndroid")
public class BulletAction extends ActionSupport{

	private Map<String, Object> data;
	@Resource(name = "bulletservice")
	private IBulletService bulletservice;
	private String method = null;
	private String id = null;
	private String phone = null;
	private String content = null;
	private String title;
	@Resource(name="bullet")
	private Bullet bullet;
	private List<Bullet> bulletList = null;
	private String key;
	private String color;
	private String size;
	
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
				 data.put("id", bullet.getId());
				 data.put("content", bullet.getContent());
				 data.put("key", bullet.getKey());
				 data.put("time", bullet.getTime());
				 data.put("color", bullet.getColor());
				 data.put("size", bullet.getSize());
				 data.put("title", bullet.getTitle());
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
	
	//处理 android/barrage/changebarrage 请求
	public String changebarrage() throws Exception{
		 data = new HashMap<String, Object>();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String time = df.format(new Date());// new Date()为获取当前系统时间
		 bullet.setPhone(phone);
		 bullet.setTime(time);
		 bullet.setContent(content);
		 bullet.setColor(color);
		 bullet.setSize(size);
		 bullet.setTitle(title);
		 bullet.setKey(key);
		 if(!bulletservice.clearShortCut(phone, key)){
			 data.put(defined.Error, defined.FAIL);
		 }
		 if(id !=null){//更新操作
			 if(bulletservice.updateBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }
		 }else{//添加新的弹幕
			 if(bulletservice.addBullet(bullet)){
				 data.put(defined.Error, defined.SUCCESS);
			 }else{
				 data.put(defined.Error, defined.FAIL);
			 }

		 }
		 return "success";
	}
	//检查弹幕的快捷键是否已经被使用 android/barrage/checkshortcut
	public String checkbarrage() throws Exception{
		data = new HashMap<String,Object>();
		if(bulletservice.CheckShortCut(phone, key)=="1"){//已存在
			data.put(defined.Error,defined.BARRAGEEXIST);
		}else if(bulletservice.CheckShortCut(phone, key)=="1"){//不存在
			data.put(defined.Error,defined.BARRAGENOEXIST);
		}else{//出错
			data.put(defined.Error,defined.FAIL);
		}
		return "result";
	}

	//处理 android/barrage/shortcut 请求
	public String shortcut() throws Exception{
		 data = new HashMap<String, Object>();
		 if(!bulletservice.clearShortCut(phone, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "result";
		 }
		 if(!bulletservice.addShortCut(id, key)){
			 data.put(defined.Error, defined.FAIL);
			 return "result";
		 }
		 data.put(defined.Error, defined.SUCCESS);
		 return "result";
	}
	//android/barrage/getnumber?phone=
	public String getNumber()throws Exception{
		data = new HashMap<String, Object>();
		try{
			int number = bulletservice.Getnumbers(phone);
			if(number == -1){
				 data.put(defined.Error, defined.FAIL);
				 return "result";
			 }
			bullet = bulletservice.GetLast(phone);
			data.put(defined.Error, defined.SUCCESS);
			data.put("number", number);
			data.put("title", bullet.getTitle());
			data.put("content", bullet.getContent());
			data.put("time", bullet.getTime());
			return "result";
		}catch(Exception  e){
			data.put(defined.Error, defined.FAIL);
			return "result";
		}
	}
	
	//根据id删除弹幕 android/individuation/delete
	public String delete() throws Exception{
		data = new HashMap<String,Object>();
		if(bulletservice.DeleteBullet(id)){
			data.put(defined.Error, defined.SUCCESS);
		}else{
			data.put(defined.Error, defined.FAIL);
		}
		return "result";
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
