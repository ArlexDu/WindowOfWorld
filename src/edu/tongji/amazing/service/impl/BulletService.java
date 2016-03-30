package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdDao;
import edu.tongji.amazing.dao.impl.BulletDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.service.IBulletService;

@Service("bulletservice")
public class BulletService implements IBulletService {
	
	
	@Resource(name="bulletdao")
	private BulletDao bulletdao;
	
	@Resource
	private SessionFactory factory;
	
	//由弹幕id获取
	@Override
	public Bullet getBullet(String id){
		return bulletdao.queryById(id);
	}
	
	//由用户id获取 
	@Override
	public List<Bullet> getAllBullet(String userId){
		String hql = "from bullet where identity = '"+userId+"'";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Bullet> bulletList = query.list();
		transaction.commit();
		session.close();
		return bulletList;
	}
	
	//增加弹幕
	@Override
	public void addBulet(Bullet bullet){
		bulletdao.insert(bullet);
	}
}
