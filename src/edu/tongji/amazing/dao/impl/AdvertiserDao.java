package edu.tongji.amazing.dao.impl;

import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdvertisementDao;
import edu.tongji.amazing.model.Advertiser;
@Repository("advertiserdao")
public class AdvertiserDao extends GeneralDao<Advertiser> implements IAdvertisementDao{

	public AdvertiserDao() {
		super(Advertiser.class);
		// TODO Auto-generated constructor stub
	}

}
