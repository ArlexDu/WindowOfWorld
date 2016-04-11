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
    public void Insert(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
    }
//根据id删除对象
    @Override
    public void DeleteViaId(String id) {
    	String dataname = entityClass.getName();
    	String hql = "delete from "+dataname+" where id = '"+id+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		//int num = query.
		transaction.commit();
		session.close();
    }
    
    @Override
	public void DeleteViaIdentity(String identity) {
		// TODO Auto-generated method stub
    	String dataname = entityClass.getName();
    	String hql = "delete from "+dataname+" where identity = '"+identity+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		//int num = query.
		transaction.commit();
		session.close();
	}
    
//更新对象
    @Override
    public void Update(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
    }

    //获得一个人发的所有的弹幕或者广告或者个性化操作
	@Override
	public List<T> QueryByIdentity(String identity) {
		// TODO Auto-generated method stub
		String dataname = entityClass.getName();
    	String hql = "from "+dataname+" where identity = '"+identity+"'";
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<T> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}


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

}