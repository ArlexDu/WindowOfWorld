package edu.tongji.amazing.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdvertisementDao;
import edu.tongji.amazing.dao.IAdvertiserDao;
import edu.tongji.amazing.model.Advertiser;
@Repository("advertiserdao")
public class AdvertiserDao extends GeneralDao<Advertiser> implements IAdvertiserDao{

	@Resource
	private SessionFactory factory;
	
	public AdvertiserDao() {
		super(Advertiser.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activeAccount(String phone) {
		// TODO Auto-generated method stub
		String hql = "Update User set status = '0' where phone = '" + phone + "'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
