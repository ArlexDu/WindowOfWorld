package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

public interface IBulletService {
	//�ɵ�Ļid��ȡ
	public Bullet getBullet(String id);
	
	//���û�id��ȡ 
	public List<Bullet> getAllBullet(String userId);
	
	//���ӵ�Ļ
	public void addBulet(Bullet bullet);
}
