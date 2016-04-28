package edu.tongji.amazing.service;

import edu.tongji.amazing.model.Advertiser;

public interface IAdvertiserService {
	
	public boolean addAdvertise(Advertiser advertiser);
	
	public void activeAccount(String phone);

}
