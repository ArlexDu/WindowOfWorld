package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

public interface IBulletService {
	public Bullet getBullet(String id);
	
	public List<Bullet> getAllBullet(String userId);
	
	public boolean addBulet(Bullet bullet);
	
	public boolean clearShortCut(String phone,String key);
	
	public boolean addShortCut(String id,String key);
	
	public int Getnumbers(String phone);
	
	public Bullet GetLast(String phone);
}
