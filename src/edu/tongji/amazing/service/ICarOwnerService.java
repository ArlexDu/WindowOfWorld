package edu.tongji.amazing.service;


import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;

public interface ICarOwnerService {
	
	// 登录的时候查看是否有此用户
	public boolean checkUserExist(String phone);
	
	//对比用户名密码
	public boolean checkUser(String phone,String password);

	// 增加用户
	public boolean addUser(CarOwner user);

	// 更新用户信息
	public boolean updateUser(CarOwner user);

	// 根据身手机号查找用户
	public CarOwner getUserbyPhone(String phone);
	
	//更改头像
	public void changeavatar(String phone , String path);
	
	//设备号与用户对应
	public void setProductId(String phone,String channelid);
	
	//通过用户手机获得设备号
	public String getProduct(String phone);
	
	//检查用户是否存在
	public User IsUserExist(String phone);
	
	//根据用户的channelid获得用户的手机
	public String GetphonebyChannelid(String channelid)throws Exception;
	
}
