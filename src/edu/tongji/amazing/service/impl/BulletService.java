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
	
	//�ɵ�Ļid��ȡ
	@Override
	public Bullet getBullet(String id){
		return bulletdao.queryById(id);
	}
	
	//���û�id��ȡ 
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
	
	//���ӵ�Ļ
	@Override
	public void addBulet(Bullet bullet){
		bulletdao.insert(bullet);
	}
}
