package edu.tongji.amazing.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import edu.tongji.amazing.dao.IBulletDao;
import edu.tongji.amazing.model.Bullet;


@Repository("bulletdao")
public class BulletDao extends GeneralDao<Bullet> implements IBulletDao  {	
	
	@Resource
	private SessionFactory factory;
	
	public BulletDao(){
		super(Bullet.class);
	}

	@Override
	public boolean setShortCut(String id,String key) {
		// TODO Auto-generated method stub
		String hql = "Update Bullet set key = '"+key+"' where bulletId = '"+id+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			return true;
		}catch(Exception e){
			return false;
		}finally{
			transaction.commit();
			session.close();
		}
	}

	@Override
	public boolean clearShortCut(String phone, String key) {
		String hql = "Update Bullet set key = ' ' where userId = '"+phone+"' and key = '"+key+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			return true;
		}catch(Exception e){
			return false;
		}finally{
			transaction.commit();
			session.close();
		}
	}

}

