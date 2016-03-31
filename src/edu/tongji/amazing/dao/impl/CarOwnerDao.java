package edu.tongji.amazing.dao.impl;


import javax.annotation.Resource;

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
	public CarOwner checkUser(CarOwner user) {
		// TODO Auto-generated method stub
		return null;
	}

}
