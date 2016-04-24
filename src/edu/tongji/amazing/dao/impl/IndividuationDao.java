package edu.tongji.amazing.dao.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IIndividuationDao;
import edu.tongji.amazing.model.Individuation;

@Repository("individuationdao")
public class IndividuationDao extends GeneralDao<Individuation> implements IIndividuationDao{

	
	@Resource
	private SessionFactory factory;
	
	public IndividuationDao() {
		super(Individuation.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean setShortCut(String id,String key) {
		// TODO Auto-generated method stub
		String hql = "Update Individuation set key = '"+key+"' where id = '"+id+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			query.executeUpdate();
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
		String hql = "Update Individuation set key = '' where phone = '"+phone+"' and key = '"+key+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			query.executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			transaction.commit();
			session.close();
		}
	}

	@Override
	public String CheckShortCut(String phone, String key) {
		// TODO Auto-generated method stub
		String hql = "from Individuation where phone = '"+phone+"' and key = '"+key+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			Iterator iterator = query.iterate();
			if(iterator.hasNext()){
				return "1";
			}
			return "2";
		}catch(Exception e){
			return "3";
		}finally{
			transaction.commit();
			session.close();
		}
	}

	@Override
	public boolean ChangeStatus(String id, String status) {
		String hql = "Update Individuation set status = '"+status+"' where id = '"+id+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			query.executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			transaction.commit();
			session.close();
		}
	}


}
