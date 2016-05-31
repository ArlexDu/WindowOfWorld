package edu.tongji.amazing.test;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.action.PadAction.Place;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.AdvertisementPlaceAndTime;
import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.CarOwner;
import edu.tongji.amazing.model.Finance;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdministratorService;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.impl.AdvertisementService;
import edu.tongji.amazing.service.impl.BulletService;
import edu.tongji.amazing.service.impl.CarOwnerService;
import edu.tongji.amazing.tool.FileTools;
import edu.tongji.amazing.tool.SendEmail;
import edu.tongji.amazing.tool.ShowAdvertisement;

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
  		bullet.setContent("鍔ㄧ敾鍩�");
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
  	  advertisement.setContent("specialplace");
	  AdvertisementPlaceAndTime placeandtime1 = new AdvertisementPlaceAndTime();
	  placeandtime1.setBegin_time("21");
	  placeandtime1.setEnd_time("22");
	  placeandtime1.setLatitude("32");
	  placeandtime1.setLongtitude("112");
  	  AdvertisementPlaceAndTime placeandtime2 = new AdvertisementPlaceAndTime();
	  placeandtime2.setBegin_time("18");
	  placeandtime2.setEnd_time("19");
	  placeandtime2.setPlace("school");
      advertisement.getPlaceandtime().add(placeandtime1);
      advertisement.getPlaceandtime().add(placeandtime2);
      adservice.AddNewAd(advertisement);
	}
  	/*
  	 * 娴嬭瘯瀹氱偣鎶曟斁
  	 */
//  	@Test
    public void sendad(){
    	try {
		    List<Advertisement> ads = adservice.SendAdvertise("121.49854302406311", "31.28540017791541");
    		Place[] places = Place.values();
    		for(Place curplace : places){
    			//褰撳墠鍧愭爣鍛ㄥ洿鏈夎繖涓湴鐐�
    			System.out.println("name is "+curplace.getName());
    			System.out.println("code is "+curplace.getCode());
    			if(adservice.getfrombaidu("121.49854302406311", "31.28540017791541", curplace.getCode())){
    				ads.addAll(adservice.SpecialShowAdvertisements(curplace.getCode()));
    			}
    		}
    		 for(int i = 0; i<ads.size();i++){
				 System.out.println("advertisement's content is "+ads.get(i).getContent());
			 }
//    		adservice.getfrombaidu("121.49854302406311", "31.28540017791541", "瀛︽牎");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Resource(name="administratorservice")
	private IAdministratorService adminservice;
    @Test
    public void wholeFinance() throws Exception{
		try{
			List<Finance> finaces = adminservice.wholefinace();
			for(int i = 0; i<finaces.size() ; i++){
				 System.out.println("date is "+finaces.get(i).getFinance_date());
				 System.out.println("income is "+finaces.get(i).getIncome());
	             System.out.println("outgoing is "+finaces.get(i).getOutgoing());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//  	@Test
    public void AdvertisementTable() throws Exception{
		try{
			int num = Integer.parseInt("1");
			List<Advertisement> advertisements = adminservice.AdvertisementTable(num);
			List<ShowAdvertisement> showadvertisements = new ArrayList<ShowAdvertisement>();
			for(int i=0;i<advertisements.size();i++){
				ShowAdvertisement sa = new ShowAdvertisement();
				sa.setUsername(adminservice.GetUsernameByPhone(advertisements.get(i).getPhone()));
				sa.setPhone(advertisements.get(i).getPhone());
				sa.setPrice(advertisements.get(i).getPrice());
				sa.setStatus(advertisements.get(i).getStatus());
				sa.setDate(advertisements.get(i).getTime());
				showadvertisements.add(sa);
			}
			for(int i=0;i<showadvertisements.size();i++){
				System.out.println("username is "+showadvertisements.get(i).getUsername());
				System.out.println("username is "+showadvertisements.get(i).getPrice());
			}
//			ServletActionContext.getRequest().setAttribute("advertisements",advertisements);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
