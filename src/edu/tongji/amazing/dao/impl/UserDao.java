package edu.tongji.amazing.dao.impl;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IUserDao;
import edu.tongji.amazing.model.User;

@Repository
public class UserDao implements IUserDao{

	@Resource
	private SessionFactory factory;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
        transaction.commit();
        session.close();
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

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
	public User getUserbyIndentity(long identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Disconnect() {
		// TODO Auto-generated method stub
//		factory.close();
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
