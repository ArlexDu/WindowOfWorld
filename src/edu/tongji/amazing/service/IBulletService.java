package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

public interface IBulletService {
	//由弹幕id获取
	public Bullet getBullet(String id);
	
	//由用户id获取 
	public List<Bullet> getAllBullet(String userId);
	
	//增加弹幕
	public void addBulet(Bullet bullet);
}
