package edu.tongji.amazing.service;

import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;

public interface IAdvertiserService {
	
	public boolean addAdvertise(Advertiser advertiser);
	
	public boolean updateAdvertise(Advertiser advertiser);
	
	public boolean charge(String phone,float num);
	
	public void activeAccount(String phone);
	
	public Advertiser getAdvertisementinfo(String phone) throws Exception;
	
	//妫�鏌ョ敤鎴锋槸鍚﹀瓨鍦�
	public User IsUserExist(String phone) throws Exception;

}
