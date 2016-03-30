package edu.tongji.amazing.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdDao;
import edu.tongji.amazing.model.Advertisement;
import oracle.net.aso.q;
/*
 * hql 语言简介：http://blog.csdn.net/yaerfeng/article/details/6969649
 * 用于处理与数据库中广告数据交互的实现类
 */
@Repository("addao")
public class AdDao implements IAdDao{
	
	@Resource
	private SessionFactory factory;

	@Override
	public List<Advertisement> GetAdsList(String identity) {
		// TODO Auto-generated method stub
		String hql = "from Advertisement where identity = '"+identity+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Advertisement> ads = query.list();
		transaction.commit();
		session.close();
		return ads;
	}

	@Override
	public Advertisement GetAd(String ad_id) {
		// TODO Auto-generated method stub
		String hql = "from Advertisement where ad_id = '"+ad_id+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		iterator.hasNext();
		Advertisement ad = (Advertisement) iterator.next();
		transaction.commit();
		session.close();
		return ad;
	}

	@Override
	public void AddNewAd(Advertisement ad) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ad);
		transaction.commit();
		session.close();
	}

	@Override
	public void UpdateAd(Advertisement ad) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(ad);
		transaction.commit();
		session.close();
	}

	@Override
	public void DeleteAd(String ad_id) {
		// TODO Auto-generated method stub
		String hql = "delete from Advertisement where ad_id = '"+ad_id+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
	    //int num = query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
