package edu.tongji.amazing.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import edu.tongji.amazing.dao.IBulletDao;
import edu.tongji.amazing.model.Bullet;


@Repository("bulletdao")
public class BulletDao extends GeneralDao<Bullet> implements IBulletDao  {	
	
	public BulletDao(){
		super(Bullet.class);
	}

}
