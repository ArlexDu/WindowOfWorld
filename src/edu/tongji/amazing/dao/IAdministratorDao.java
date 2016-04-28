package edu.tongji.amazing.dao;

import java.util.List;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.User;

public interface IAdministratorDao {
	
	    //登录
        public boolean login(String phone,String password) throws Exception;    
	
	    //得到所有的广告
		public int getalladvertisements() throws Exception;
		
		//得到所有的用户数量
		public int getallusers() throws Exception;
		
		//未审核的用户数量
		public int unexamineUsers() throws Exception;
		
		//未审核的广告数量
		public int unexamineAdvertisement() throws Exception;
		
		//得到主页展示的六个最新的用户
		public List<User> getShowUsers() throws Exception;
		
		//得到主页展示的六个最新的广告
		public List<Advertisement> getShowAdvertisement() throws Exception;
		
		//得到展示的四个最新的账目变化
		public List<Balance> getShowBalance() throws Exception;
		
}
