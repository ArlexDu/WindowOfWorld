package edu.tongji.amazing.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.tool.Defined;

@Controller("advertisementaction")
public class AdvertisementAction extends ActionSupport implements ModelDriven<Advertisement> {
	@Resource(name = "advertisement")
	private Advertisement advertisement;

	@Resource(name = "advertisementservice")
	private IAdvertisementService adservice;

	// 骞垮憡鐨勬坊鍔� /advertisement/add
	public String newAdvertisement() throws Exception {
		 System.out.println("identity: "+advertisement.getPhone());
		 System.out.println("price: "+advertisement.getPrice());
		 System.out.println("time: "+advertisement.getTime());
		 System.out.println("status: "+advertisement.getStatus());
		 System.out.println("content: "+advertisement.getContent());
		 return "fail";

	}

	// 骞垮憡鐨勬洿鏂� /advertisement/update
	public String updateAdvertisement() throws Exception {

		try {
			adservice.UpdateAd(advertisement);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}

	// 骞垮憡鐨勫垹闄�/advertisement/delete
	private String id;

	public String deleteAdvertisement() throws Exception {

		try {
			adservice.DeleteAd(id);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}
	
	//鑾峰緱骞垮憡鍟嗙殑鎵�鏈夊箍鍛�  /advertisement/getall
	private String phone;
	public String GetAdvertisements()throws Exception{
		
		try{
			List<Advertisement> advertisements = adservice.GetAdsList(phone);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	/*
	 * return 5 advertisements to android device
	 *  /android/user/getadvertisements
	 */
	private HashMap<String, Object> data;
	@Resource(name = "define")
	private Defined defined;
	public String Getadvertisements() throws Exception{

		try{
			data = new HashMap<String,Object>();
			List<Advertisement> advertisements = adservice.GetShowAdvertisements();
			List<String> urls = new ArrayList<String>();
			for(int i = 0; i< advertisements.size() ; i++ ){
			   urls.add(advertisements.get(i).getContent());
			}
			data.put("urls", urls);
			data.put(defined.Error,defined.SUCCESS);
		}catch(Exception e){
			data.put(defined.Error,defined.FAIL);
		}
		return "result";
	}

	@Override
	public Advertisement getModel() {
		// TODO Auto-generated method stub
		return advertisement;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	

}
