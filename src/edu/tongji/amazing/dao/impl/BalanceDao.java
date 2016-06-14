package edu.tongji.amazing.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IBalanceDao;
import edu.tongji.amazing.model.Balance;
@Repository("balancedao")
public class BalanceDao extends GeneralDao<Balance> implements IBalanceDao{

	@Resource
	private SessionFactory factory;
	
	public BalanceDao() {
		super(Balance.class);
		// TODO Auto-generated constructor stub
	}

    //获得一个人发的所有的弹幕或者广告或者个性化操作
	public List<Balance> QueryBalanceByPhone(String phone) {
		// TODO Auto-generated method stub
    	String hql = "from Balance where phone = '"+phone+"' order by time";
    	Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Balance> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}
}
