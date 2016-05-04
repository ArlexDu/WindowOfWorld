package edu.tongji.amazing.service;

import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;

public interface IAdvertiserService {
	
	public boolean addAdvertise(Advertiser advertiser);
	
	public void activeAccount(String phone);
	
	public Advertiser getAdvertisementinfo(String phone) throws Exception;
	
	//检查用户是否存在
	public User IsUserExist(String phone) throws Exception;

}
