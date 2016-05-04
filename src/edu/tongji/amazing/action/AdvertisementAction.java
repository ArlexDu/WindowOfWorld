package edu.tongji.amazing.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tongji.amazing.model.Advertisement;

import edu.tongji.amazing.service.IAdvertisementService;

@Controller("addadpost")
public class AdvertisementAction extends ActionSupport implements ModelDriven<Advertisement> {
	@Resource(name = "advertisement")
	private Advertisement advertisement;

	@Resource(name = "advertisementservice")
	private IAdvertisementService adservice;

	// 广告的添加 /advertisement/add
	public String newAdvertisement() throws Exception {

		// System.out.println("identity: "+advertisement.getPhone());
		// System.out.println("begin_time: "+advertisement.getBegin_time());
		// System.out.prinln("end_time: "+advertisement.getEnd_time());
		// System.out.println("place: "+advertisement.getPlace());
		// System.out.println("price: "+advertisement.getPrice());
		// System.out.println("time: "+advertisement.getTime());
		// System.out.println("status: "+advertisement.getStatus());
		// System.out.println("content: "+advertisement.getContent());
		try {
			adservice.AddNewAd(advertisement);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}

	// 广告的更新 /advertisement/update
	public String updateAdvertisement() throws Exception {

		try {
			adservice.UpdateAd(advertisement);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}

	// 广告的删除/advertisement/delete
	private String id;

	public String deleteAdvertisement() throws Exception {

		try {
			adservice.DeleteAd(id);
			return "success";
		} catch (Exception e) {
			return "fail";
		}

	}
	
	//获得广告商的所有广告  /advertisement/getall
	private String phone;
	public String GetAdvertisements()throws Exception{
		
		try{
			List<Advertisement> advertisements = adservice.GetAdsList(phone);
			return "success";
		}catch(Exception e){
			return "fail";
		}
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

}
