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
public class CarOwnerDao extends GeneralDao<CarOwner> implements ICarOwnerDao{

	public CarOwnerDao() {
		super(CarOwner.class);
	}

	@Resource
	private SessionFactory factory;

	@Override
	public boolean RvokeAccount(long identity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ResumeAccount(long identity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CarOwner getUserbyIndentity(long identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Disconnect() {
		// TODO Auto-generated method stub
//		factory.close();
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where username = '"+username+"' and password = '"
		                   +password+"'";
		boolean result = false;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if(iterator.hasNext()){
			result = true;
		}
		transaction.commit();
		session.close();
		return result;
	}

	

}
