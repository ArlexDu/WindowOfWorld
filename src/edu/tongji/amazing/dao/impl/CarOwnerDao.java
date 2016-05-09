package edu.tongji.amazing.dao.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.ICarOwnerDao;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;

@Repository("userdao")
public class CarOwnerDao extends GeneralDao<CarOwner> implements ICarOwnerDao {

	
	public CarOwnerDao() {
		super(CarOwner.class);
	}

	@Resource
	private SessionFactory factory;

	@Override
	public CarOwner getUserbyPhone(String phone) {
		CarOwner owner = null;
		String hql = "from CarOwner where phone = '" + phone + "'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			owner = (CarOwner) iterator.next();
		}
		transaction.commit();
		session.close();
		return owner;
	}

	@Override
	public boolean checkUser(String phone, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where phone = '" + phone + "' and password = '" + password + "'";
		boolean result = false;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public void ChangeAvatar(String phone, String path) {
		// TODO Auto-generated method stub
		String hql = "Update User set avatar = '"+path+"' where phone = '" + phone + "'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	public void setproductId(String phone, String channelid) {
		// TODO Auto-generated method stub
		String hql = "Update CarOwner set productId = '"+channelid+"' where phone = '" + phone + "'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	public String getProduct(String phone) {
		// TODO Auto-generated method stub
		String hql = "select productId from CarOwner where phone = '" + phone + "'";
		String result="";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			result = (String)iterator.next();
		}
		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public String GetphonebyChannelid(String channelid) throws Exception{
		// TODO Auto-generated method stub
		String hql = "select phone from CarOwner where productId = '" + channelid + "'";
		String result="";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			result = (String)iterator.next();
		}
		transaction.commit();
		session.close();
		return result;
	}
}
