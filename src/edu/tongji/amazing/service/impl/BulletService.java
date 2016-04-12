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
	
	
	//根据某一个id获得具体的弹幕内容
	@Override
	public Bullet getBullet(String id){
		return bulletdao.QueryById(id);
	}
	
	//返回一个用户的所有弹幕
	@Override
	public List<Bullet> getAllBullet(String userId){
		return bulletdao.QueryByPhone(userId);
	}
	
	//增加新的弹幕
	@Override
	public void addBulet(Bullet bullet){
		bulletdao.Insert(bullet);
	}
}
