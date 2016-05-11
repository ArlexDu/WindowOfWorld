package edu.tongji.amazing.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.id.uuid.StandardRandomStrategy;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.inject.Factory;

import edu.tongji.amazing.dao.IAdministratorDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Advertiser;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.Finance;
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

	@Override
	public User getUserbyPhone(String phone) throws Exception {
		User administrator = null;
		String hql = "from User where phone = '" + phone + "'";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			administrator = (User) iterator.next();
		}
		transaction.commit();
		session.close();
		return administrator;
	}

	@Override
	public void changeAdvertisementStatus(String id, String status) throws Exception {
		// TODO Auto-generated method stub
		String hql = "Update Advertisement set status = '"+status+"' where id = '"+id+"'";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	public void changeUserStatus(String phone, String status) throws Exception {
		// TODO Auto-generated method stub
		String hql = "Update User set status = '"+status+"' where id = '"+phone+"'";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	@Override
	public List<Finance> wholefinace() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select income,outgoing,finance_date from totalfinance";
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();
		List list = session.createSQLQuery(sql)
				.addScalar("income",StandardBasicTypes.DOUBLE)
				.addScalar("outgoing",StandardBasicTypes.DOUBLE)
				.addScalar("finance_date",StandardBasicTypes.STRING).list();
		List<Finance> finances = new ArrayList<Finance>();
		for(int i = 0; i< list.size(); i++){
			Object[] ob =(Object[])list.iterator().next();
			Finance finance = new Finance();
			finance.setIncome((double)ob[0]);
			finance.setOutgoing((double)ob[1]);
			finance.setFinance_date((String)ob[2]);
			finances.add(finance);
			
		}
		transaction.commit();
		session.close();
		return finances;
	}

	

}
