package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.Advertisement;
/*
 * 用于与数据库广告数据交互的接口类
 */
public interface IAdDao {

	//获得当前广告商的所有广告
	public List<Advertisement> GetAdsList(String identity);
	
	//根据广告的id获得广告的具体信息
	public Advertisement GetAd(String ad_id);
	
	//添加新的广告
	public void AddNewAd(Advertisement ad);
	
	//更新新的广告信息
	public void UpdateAd(Advertisement ad);
	
	//根据广告的id删除广告信息
	public void DeleteAd(String ad_id);
}
