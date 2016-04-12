package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.Bullet;

/*
 * 弹幕类的操作
 */
public interface IBulletDao {

	//设置弹幕的快捷键
	public boolean setShortCut(String id,String key);
	
	//清空对应弹幕的key
	public boolean clearShortCut(String phone,String key);
	

}
