package edu.tongji.amazing.test;




import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.impl.AdService;
import edu.tongji.amazing.service.impl.BulletService;
import edu.tongji.amazing.service.impl.CarOwnerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestHibernate extends AbstractJUnit4SpringContextTests{
	
//	private ApplicationContext context = null;
	
	@Resource(name="user")
	private User user;
	
	@Resource(name="advertisement")
	private Advertisement ad;
	
	@Resource(name="adservice")
	private AdService service;
	
//	@Test
	public void testName() throws Exception {
		
		user.setUsername("happy");
		System.out.println("username is "+user.getUsername());
	}
    //@Test
    public void addad(){
    	ad.setPhone("123456789");
    	service.AddNewAd(ad);
    }
    
  @Resource(name="bulletservice")
	private BulletService bulletService;
//  @Resource
//    private CarOwner carowner;
//  @Resource
//  private CarOwnerService s;
//  @Test
//	public void getBullet() throws Exception {
//		
//	    carowner = s.getUserbyIndentity("130823200001290001");
//		System.out.println(carowner);
//	}
	
  //@Test
	public void getBullet(){
	  Bullet bullet = bulletService.getBullet("25");
	  System.out.println(bullet.getTime());
}
  
  @Test
  	public void getAllBullet(){
	  List<Bullet> bulletList = bulletService.getAllBullet("100000001");
	  System.out.println(bulletList.size());
  }
//  	@Test
  	public void addBullet(){
  		Bullet addbullet=new Bullet();
		 addbullet.setUserId("100000001");
		 addbullet.setTime("time");
		 addbullet.setContent("path");
		 System.out.println(addbullet.getUserId());
		 bulletService.addBulet(addbullet);
  	}
}
