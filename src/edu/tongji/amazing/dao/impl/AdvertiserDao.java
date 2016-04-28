package edu.tongji.amazing.dao.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdvertisementDao;
import edu.tongji.amazing.dao.IAdvertiserDao;
import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.CarOwner;
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
	
	
	@Override
	public Advertiser getUserbyPhone(String phone) {
		Advertiser advertiser = null;
		String hql = "from Advertiser where phone = '" + phone + "'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			advertiser = (Advertiser) iterator.next();
		}
		transaction.commit();
		session.close();
		return advertiser;
	}

}
