package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdDao;
import edu.tongji.amazing.dao.impl.GeneralDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdService;

@Service("adservice")
public class AdService implements IAdService {

	@Resource(name="addao")
	private AdDao dao;
	@Override
	public List<Advertisement> GetAdsList(String phone) {
		// TODO Auto-generated method stub
		return dao.QueryByPhone(phone);
	}

	@Override
	public Advertisement GetAd(String ad_id) {
		// TODO Auto-generated method stub
		return dao.QueryById(ad_id);
	}

	@Override
	public void AddNewAd(Advertisement ad) {
		// TODO Auto-generated method stub
		dao.Insert(ad);
	}

	@Override
	public void UpdateAd(Advertisement ad) {
		// TODO Auto-generated method stub
		dao.Update(ad);
	}

	@Override
	public void DeleteAd(String ad_id) {
		// TODO Auto-generated method stub
		dao.DeleteViaId(ad_id);
	}

}
