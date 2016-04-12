package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

public interface IBulletService {
	public Bullet getBullet(String id);
	
	public List<Bullet> getAllBullet(String userId);
	
	public void addBulet(Bullet bullet);
}
