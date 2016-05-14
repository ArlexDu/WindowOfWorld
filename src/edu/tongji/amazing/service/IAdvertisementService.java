package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Advertisement;

public interface IAdvertisementService {

	// 获得当前广告商的所有广告
	public List<Advertisement> GetAdsList(String identity);

	// 根据广告的id获得广告的具体信息
	public Advertisement GetAd(String ad_id);

	// 添加新的广告
	public void AddNewAd(Advertisement ad);

	// 更新新的广告信息
	public void UpdateAd(Advertisement ad);

	// 根据广告的id删除广告信息
	public void DeleteAd(String ad_id);
	
	//向pad端发送广告
	public List<Advertisement> SendAdvertise(String longitude, String latitude)throws Exception;
	
	//获得android端需要的广告
	public List<Advertisement> GetShowAdvertisements()throws Exception;
	
	//获得android端需要的广告(特殊地点)
	public List<Advertisement> SpecialShowAdvertisements(String place) throws Exception;
	
	//调用百度地图api获得当前位置的信息
	public boolean getfrombaidu(String lon, String lat,String place) throws Exception;
}
