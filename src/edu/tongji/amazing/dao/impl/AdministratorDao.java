package edu.tongji.amazing.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.inject.Factory;

import edu.tongji.amazing.dao.IAdministratorDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.User;
@Repository("administratordao")
public class AdministratorDao extends GeneralDao<User> implements IAdministratorDao{

	public AdministratorDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
	@Resource
	private SessionFactory Factory;

	@Override
	public int getalladvertisements()throws Exception {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Advertisement";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		Number number = 0;
		if(iterator.hasNext()){
			number = (Number)iterator.next();
		}
		transaction.commit();
		session.close();
		return number.intValue();
	}

	@Override
	public int getallusers() throws Exception {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User where not (userclass = 1)";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		Number number = 0;
		if(iterator.hasNext()){
			number = (Number)iterator.next();
		}
		transaction.commit();
		session.close();
		return number.intValue();
	}

	@Override
	public int unexamineUsers() throws Exception {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User where status = 0";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		Number number = 0;
		if(iterator.hasNext()){
			number = (Number)iterator.next();
		}
		transaction.commit();
		session.close();
		return number.intValue();
	}

	@Override
	public int unexamineAdvertisement() throws Exception {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Advertisement where status = 0";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		Number number = 0;
		if(iterator.hasNext()){
			number = (Number)iterator.next();
		}
		transaction.commit();
		session.close();
		return number.intValue();
	}

	@Override
	public List<User> getShowUsers() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from User where rownum<7 order by time desc ";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		return users;
	}

	@Override
	public List<Advertisement> getShowAdvertisement() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Advertisement where rownum<7 order by id desc ";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Advertisement> advertisements = query.list();
		transaction.commit();
		session.close();
		return advertisements;
	}

	@Override
	public List<Balance> getShowBalance() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Balance where rownum<5 order by id desc ";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Balance> balances = query.list();
		transaction.commit();
		session.close();
		return balances;
	}

	@Override
	public boolean login(String phone, String password) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from User where phone = '" + phone + "' and password = '" + password + "' and status = 1";
		boolean result = false;
		Session session = Factory.openSession();
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

	

}
