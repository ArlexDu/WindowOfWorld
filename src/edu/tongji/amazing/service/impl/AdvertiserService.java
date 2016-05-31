package edu.tongji.amazing.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.action.PadAction.ad;
import edu.tongji.amazing.dao.impl.AdvertiserDao;
import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertiserService;
@Service("advertiserservice")
public class AdvertiserService implements IAdvertiserService{

	@Resource(name="advertiserdao")
	private AdvertiserDao dao;
	
	
	@Override
	public boolean addAdvertise(Advertiser advertiser) {
		// TODO Auto-generated method stub
		return dao.Insert(advertiser);
	}
	@Override
	public void activeAccount(String phone) {
		// TODO Auto-generated method stub
		dao.activeAccount(phone);
	}
	@Override
	public Advertiser getAdvertisementinfo(String phone) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUserbyPhone(phone);
	}
	@Override
	public User IsUserExist(String phone) throws Exception {
		// TODO Auto-generated method stub
		return dao.IsUserExist(phone);
	}
	@Override
	public boolean updateAdvertise(Advertiser advertiser) {
		// TODO Auto-generated method stub
		return dao.Update(advertiser);
	}
	@Override
	public boolean charge(String phone,float num) {
		// TODO Auto-generated method stub
		Advertiser advertiser = dao.getUserbyPhone(phone);
		User user= advertiser.getUser();
		float balance= user.getBalace();
		user.setBalace(balance+num);
		advertiser.setUser(user);
		return dao.Update(advertiser);
	}
	


}
