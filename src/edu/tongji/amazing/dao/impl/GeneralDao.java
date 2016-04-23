package edu.tongji.amazing.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IGeneralDao;

/*
 * 大多数模块都需要处理的共同的函数
 */

public class GeneralDao<T> implements IGeneralDao<T> {
	
    private Class<T> entityClass;

    public GeneralDao (Class<T> clazz) {
        this.entityClass = clazz;
    }
    
    @Resource
    protected  SessionFactory sessionFactory;

//插入对象
    @Override
    public boolean Insert(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(t);
			return true;
		}catch(Exception e){
			return false;
		}finally{
			transaction.commit();
			session.close();
		}
    }
//根据id删除对象
    @Override
    public boolean DeleteViaId(String id) {
    	String dataname = entityClass.getName();
    	String hql = "delete from "+dataname+" where id = '"+id+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		//int num = query.
		transaction.commit();
		session.close();
		return true;
    }
    
    @Override
	public boolean DeleteViaPhone(String phone) {
		// TODO Auto-generated method stub
    	String dataname = entityClass.getName();
    	String hql = "delete from "+dataname+" where phone = '"+phone+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		//int num = query.
		transaction.commit();
		session.close();
		return true;
	}
    
//更新对象
    @Override
    public boolean Update(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
		  session.update(t);
		  return true;
		}catch(Exception e){
			return false;
		}finally{
		  transaction.commit();
		  session.close();
		}
    }

    //获得一个人发的所有的弹幕或者广告或者个性化操作
	@Override
	public List<T> QueryByPhone(String phone) {
		// TODO Auto-generated method stub
		String dataname = entityClass.getName();
    	String hql = "from "+dataname+" where phone = '"+phone+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<T> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

//	根据id获得弹幕或者广告或者个性化操作
	@Override
	public T QueryById(String id) {
		// TODO Auto-generated method stub
		String dataname = entityClass.getName();
    	String hql = "from "+dataname+" where id = '"+id+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		Iterator iterator = query.iterate();
		T ob = null;
		if(iterator.hasNext()){
			ob = (T) iterator.next();			
		}
		transaction.commit();
		session.close();
		return ob;
	}
	@Override
	public int GetNumbers(String phone) {
		// TODO Auto-generated method stub
		String dataname = entityClass.getName();
		String hql = "select count(*) from "+dataname+" where phone ='"+phone+"'";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			Iterator iterator = query.iterate();
			Number number = 0;
			if(iterator.hasNext()){
				number = (Number) iterator.next();			
			}
			return number.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally {
			transaction.commit();
			session.close();
		}
	}
	@Override
	public T GetLast(String phone) {
		// TODO Auto-generated method stub
		String dataname = entityClass.getName();
		String hql = "select max(id) from "+dataname+" where phone ='"+phone+"'";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String maxid = "";
		T ob = null;
		try{
			Query query = session.createQuery(hql);
			Iterator iterator = query.iterate();
			if(iterator.hasNext()){
				maxid = (String) iterator.next();			
			}
			hql = "from "+dataname+" where id ='"+maxid+"'";
			query = session.createQuery(hql);
			iterator = query.iterate();
			if(iterator.hasNext()){
				ob = (T) iterator.next();			
			}
			return ob;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			transaction.commit();
			session.close();
		}
	}

}