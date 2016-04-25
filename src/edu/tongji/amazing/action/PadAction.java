package edu.tongji.amazing.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.service.IBulletService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.PushMsgToDevice;

@Controller("padaction")
public class PadAction extends ActionSupport {

	private String phone;
	private String channelid;
	
	@Resource(name="define")
	private Defined define;
	
	@Resource(name="carowner")
	private CarOwner owner;
	
	@Resource(name = "carownerservice")
	private ICarOwnerService service;
	
	private HashMap<String, Object> data;
	//用户设备绑定
    public String SetProductId() throws Exception {
    	// TODO Auto-generated method stub
    	data = new HashMap<String,Object>();
    	try{
    		service.setProductId(phone, channelid);
    		data.put(define.Error, define.SUCCESS);
    	}catch(Exception e){
    		data.put(define.Error, define.FAIL);
    	}
    	return "result";
    }
//    根据快捷键发送弹幕
    private String key;
    @Resource(name="bullet")
    private Bullet barrage;
    @Resource(name = "bulletservice")
    private IBulletService bulletService;
    @Resource(name = "sendinfo")
    private PushMsgToDevice push;
    public String SendBarrage() throws Exception {
    	// TODO Auto-generated method stub
    	data = new HashMap<String,Object>();
    	try{
    		String p_id = service.getProduct(phone);
    		barrage = bulletService.GetBarrageByKey(phone, key);
    		push.send(p_id, barrage);
    		data.put(define.Error, define.SUCCESS);
    	}catch(Exception e){
    		data.put(define.Error, define.FAIL);
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
    
    
}
