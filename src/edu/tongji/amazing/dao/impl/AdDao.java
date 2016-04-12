package edu.tongji.amazing.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdDao;
import edu.tongji.amazing.model.Advertisement;
import oracle.net.aso.q;
/*
 * hql 语言简介：http://blog.csdn.net/yaerfeng/article/details/6969649
 * 用于处理与数据库中广告数据交互的实现类
 */
@Repository("addao")
public class AdDao extends GeneralDao<Advertisement> implements IAdDao{
	
	public AdDao() {
		super(Advertisement.class);
		// TODO Auto-generated constructor stub
	}



}
