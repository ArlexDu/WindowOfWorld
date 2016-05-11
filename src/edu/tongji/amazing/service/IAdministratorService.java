package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.Finance;
import edu.tongji.amazing.model.User;

public interface IAdministratorService {

	//添加新的用户
	public boolean addAdministrator(User user) throws Exception;
	
	public User getAdministratorinfo(String phone) throws Exception;
	
	//管理员的登录
	public boolean login(String phone,String password) throws Exception;
	//得到所有的广告
	public int getalladvertisements() throws Exception;
	
	//得到所有的用户数量
	public int getallusers() throws Exception;
	
	//未审核的用户数量
	public int unexamineUsers() throws Exception;
	
	//未审核的广告数量
	public int unexamineAdvertisements() throws Exception;
	
	//得到主页展示的六个最新的用户
	public List<User> getShowUsers() throws Exception;
	
	//得到主页展示的六个最新的广告
	public List<Advertisement> getShowAdvertisements() throws Exception;
	
	//得到展示的四个最新的账目变化
	public List<Balance> getShowBalance() throws Exception;
	
	//审核广告结果
	public void changeAdvertisementStatus(String id ,String status) throws Exception;
	
	//审核用户结果
	public void changeUserStatus(String phone,String status) throws Exception;
	
	//获得总的支出
	public List<Finance> wholefinace()throws Exception;
	
	//根据当前页获得展示用户
	public List<User> UserTable(int pagenum) throws Exception;
	
	//根据当前页获得展示广告
	public List<Advertisement> AdvertisementTable(int pagenum) throws Exception;
	
	//根据当前页获得展示账单
	public List<Balance> BalanceTable(int pagenum) throws Exception;
	
}
