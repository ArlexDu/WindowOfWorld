package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.Advertisement;
/*
 * 用于与数据库广告数据交互的接口类
 */
public interface IAdvertisementDao {

	public List<Advertisement> SendAdvertise(double lon1 , double lon2 ,double lat1 ,double lat2 ,int time)throws Exception;
}
