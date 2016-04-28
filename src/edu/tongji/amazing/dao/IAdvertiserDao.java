package edu.tongji.amazing.dao;

import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;

public interface IAdvertiserDao {

	
	public void activeAccount(String phone);
	
	public Advertiser getUserbyPhone(String phone);
	
}
