package edu.tongji.amazing.test;




import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.AdvertisementPlaceAndTime;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.impl.AdvertisementService;
import edu.tongji.amazing.service.impl.BulletService;
import edu.tongji.amazing.service.impl.CarOwnerService;
import edu.tongji.amazing.tool.FileTools;
import edu.tongji.amazing.tool.SendEmail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestHibernate extends AbstractJUnit4SpringContextTests{
	
//	private ApplicationContext context = null;
	
	@Resource(name="user")
	private User user;
	
	@Resource(name="advertisement")
	private Advertisement ad;
	
	@Resource(name="advertisementservice")
	private AdvertisementService service;
	
//	@Test
	public void testName() throws Exception {
		
		user.setUsername("happy");
		System.out.println("username is "+user.getUsername());
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
  
//  @Test
  	public void getAllBullet(){
	  List<Bullet> bulletList = bulletService.getAllBullet("100000002");
	  System.out.println(bulletList.size());
  }
  	@Resource(name="bullet")
  	private Bullet bullet;
//  	@Test
  	public void addBullet(){
  		bullet.setPhone("100000001");
  		bullet.setTime("2016-04-23");
  		bullet.setContent("动画城");
  		bullet.setTitle("wobufu");
		bulletService.addBullet(bullet);
  	}
  	@Resource(name="sendemail")
  	private SendEmail email;
//  	@Test
  	public void send(){
  		try {
			email.send("shengyudu@gmail.com","15021799675");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
  	
  	@Resource(name = "filetool")
  	private FileTools file;
  	public void deletefile(){
  		try {
			file.deleteFile("http://10.60.42.70:8080/AmazingAd/Individuation/1.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
  	@Resource(name = "advertisement")
  	private Advertisement advertisement;
  	@Resource(name = "advertisementservice")
  	private IAdvertisementService adservice;
//	@Test
  	public void addad(){
  	  advertisement.setPhone("15021799675");
  	  advertisement.setContent("wocao123333");
	  AdvertisementPlaceAndTime placeandtime1 = new AdvertisementPlaceAndTime();
	  placeandtime1.setBegin_time("21");
	  placeandtime1.setEnd_time("22");
	  placeandtime1.setLatitude("38");
	  placeandtime1.setLongtitude("130");
  	  AdvertisementPlaceAndTime placeandtime2 = new AdvertisementPlaceAndTime();
	  placeandtime2.setBegin_time("18");
	  placeandtime2.setEnd_time("19");
	  placeandtime2.setLatitude("20");
	  placeandtime2.setLongtitude("130");
      advertisement.getPlaceandtime().add(placeandtime1);
      advertisement.getPlaceandtime().add(placeandtime2);
      adservice.AddNewAd(advertisement);
	}
  	
  	@Test
    public void sendad(){
    	try {
			 List<Advertisement> id = adservice.SendAdvertise("130", "20");
			 for(int i = 0; i<id.size();i++){
				 System.out.println("id is "+id.get(i).getContent());
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  	
}
