package edu.tongji.amazing.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IGeneralDao;

@Repository("generaldao")
public abstract class GeneralDao<T> implements IGeneralDao<T> {
    private Class<T> entityClass;

    public GeneralDao (Class<T> clazz) {
        this.entityClass = clazz;
    }

    @Resource
    protected  SessionFactory sessionFactory;

    @Override
    public void insert(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
    }

    @Override
    public void delete(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
    }

    @Override
    public void update(T t) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T queryById(String id) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		T t=(T) session.get(entityClass, id);
		transaction.commit();
		session.close();
        return t;
    }

    @SuppressWarnings("unchecked")
	@Override
    public T queryByIntId(int id) {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		T t=(T) session.get(entityClass, id);
		transaction.commit();
		session.close();
        return t;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> queryAll() {
    	Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(entityClass);
		transaction.commit();
		session.close();
        return criteria.list();
    }

}