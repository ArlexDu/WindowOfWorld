package edu.tongji.amazing.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.tongji.amazing.dao.IAdvertisementDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.CarOwner;
import oracle.net.aso.q;
/*
 * hql 语言简介：http://blog.csdn.net/yaerfeng/article/details/6969649
 * 用于处理与数据库中广告数据交互的实现类
 */
@Repository("advertisementdao")
public class AdvertisementDao extends GeneralDao<Advertisement> implements IAdvertisementDao{
	
	public AdvertisementDao() {
		super(Advertisement.class);
		// TODO Auto-generated constructor stub
	}
	@Resource
    protected  SessionFactory factory;

	@Override
	public List<Advertisement> SendAdvertise(double lon1, double lon2, double lat1, double lat2 ,int time,long date) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Advertisement where status = 1 and id in (select adid from AdvertisementPlaceAndTime where begin_time <= "+time
				      +" and end_time >= "+time
				      +" and begindate <= "+date+" and enddate >= "+date
				      + " and longitude between "+lon1+" and "+lon2+" and latitude between "
				      +lat1+" and "+lat2+")";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Advertisement> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public List<Advertisement> GetShowAdvertisements() throws Exception{
		// TODO Auto-generated method stub
		String hql = "from Advertisement where rownum<6 and advertisementclass = 1 order by id desc";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Advertisement> advertisements = query.list();
		transaction.commit();
		session.close();
		return advertisements;
	}

	@Override
	public List<Advertisement> SpecialShowAdvertisements(String place) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Advertisement where status = 1 and id in (select adid from AdvertisementPlaceAndTime where place = '"+place+"')";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		List<Advertisement> advertisements = query.list();
		transaction.commit();
		session.close();
		return advertisements;
	}

}
