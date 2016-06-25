package edu.tongji.amazing.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.Bullet;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.IBulletService;
import edu.tongji.amazing.tool.FileTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BulletActionTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="filetool")
	FileTools excel;
	/*
	 * 测试clearShortCut函数
	 */
	@Resource(name = "bulletservice")
	private IBulletService service;
	
	public boolean UT_TC_006_001_001_001() throws Exception{
		if(service.clearShortCut("", "1")){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_001_001_002() throws Exception{
		if(service.clearShortCut("15021799675", "")){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_001_002() throws Exception{
		if(service.clearShortCut("15012349675", "1")){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_001_003_001() throws Exception{
		if(service.clearShortCut("15012349675", "1")){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_001_003_002() throws Exception{
		if(service.clearShortCut("15012349675", "9")){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_001_003_003() throws Exception{
		if(service.clearShortCut("15012349675", "2")){
			return true;
		}
		return false;
	}	
	public boolean UT_TC_006_001_003_004() throws Exception{
		if(service.clearShortCut("15012349675", "8")){
			return true;
		}
		return false;
	}
	
	@Test
	public void T1_clearShortCut_Test(){
		try{
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_006_001_001_001",String.valueOf(UT_TC_006_001_001_001()),"false");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_006_001_001_002",String.valueOf(UT_TC_006_001_001_002()),"false");
			results.add(result1_2);
			TestingResult result2 = excel.getTestingResult("UT_TC_006_001_002",String.valueOf(UT_TC_006_001_002()),"false");
			results.add(result2);
			TestingResult result3_1 = excel.getTestingResult("UT_TC_006_001_003_001",String.valueOf(UT_TC_006_001_003_001()),"true");
			results.add(result3_1);
			TestingResult result3_2 = excel.getTestingResult("UT_TC_006_001_003_002",String.valueOf(UT_TC_006_001_003_002()),"true");
			results.add(result3_2);
			TestingResult result3_3 = excel.getTestingResult("UT_TC_006_001_003_003",String.valueOf(UT_TC_006_001_003_003()),"true");
			results.add(result3_3);
			TestingResult result3_4 = excel.getTestingResult("UT_TC_006_001_003_004",String.valueOf(UT_TC_006_001_003_004()),"true");
			results.add(result3_4);
			excel.SoftwareTesingResult("clearShortCut", results);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试updateBullet 函数
	 */
	public boolean UT_TC_006_003_001(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_001(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_002(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_003(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_003_002_004(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_005(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_006(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_007(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_002_008(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_003_003(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	@Test
	public void T2_updateBullet_Test(){
		try{
			Bullet bullet = null;;
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1 = excel.getTestingResult("UT_TC_006_002_001",String.valueOf(UT_TC_006_002_001(bullet)),"false");
			results.add(result1);
			bullet = new Bullet();
			bullet.setId("");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_1 = excel.getTestingResult("UT_TC_006_002_002_001",String.valueOf(UT_TC_006_002_002_001(bullet)),"flase");
			results.add(result2_1);
			bullet.setId("2312314124");
			bullet.setPhone("");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_2 = excel.getTestingResult("UT_TC_006_002_002_002",String.valueOf(UT_TC_006_002_002_002(bullet)),"false");
			results.add(result2_2);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_3 = excel.getTestingResult("UT_TC_006_002_002_003",String.valueOf(UT_TC_006_002_002_003(bullet)),"false");
			results.add(result2_3);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_4 = excel.getTestingResult("UT_TC_006_002_003_004",String.valueOf(UT_TC_006_002_002_004(bullet)),"false");
			results.add(result2_4);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_5 = excel.getTestingResult("UT_TC_006_002_003_005",String.valueOf(UT_TC_006_002_002_005(bullet)),"false");
			results.add(result2_5);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_6 = excel.getTestingResult("UT_TC_006_002_003_006",String.valueOf(UT_TC_006_002_002_006(bullet)),"false");
			results.add(result2_6);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("");
			bullet.setKey("1");
			TestingResult result2_7 = excel.getTestingResult("UT_TC_006_002_003_007",String.valueOf(UT_TC_006_002_002_007(bullet)),"false");
			results.add(result2_7);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("");
			TestingResult result2_8 = excel.getTestingResult("UT_TC_006_002_003_008",String.valueOf(UT_TC_006_002_002_008(bullet)),"false");
			results.add(result2_8);
			bullet.setId("2312314124");
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result3 = excel.getTestingResult("UT_TC_006_002_003",String.valueOf(UT_TC_006_002_003(bullet)),"true");
			results.add(result3);
			excel.SoftwareTesingResult("updateBullet", results);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 测试addBullet函数
	 */
	
	public boolean UT_TC_006_002_001(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_001(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_002(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_003(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_002_002_004(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_005(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_006(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_007(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_002_008(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_002_003(Bullet bullet) throws Exception{
		if(service.updateBullet(bullet)){
			return true;
		}
		return false;
	}
	@Test
	public void T3_addBullet_Test(){
		try{
			Bullet bullet = null;;
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1 = excel.getTestingResult("UT_TC_006_003_001",String.valueOf(UT_TC_006_003_001(bullet)),"false");
			results.add(result1);
			bullet = new Bullet();
			bullet.setPhone("");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_1 = excel.getTestingResult("UT_TC_006_003_002_001",String.valueOf(UT_TC_006_003_002_001(bullet)),"flase");
			results.add(result2_1);
			bullet.setPhone("15021799675");
			bullet.setTime("");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_2 = excel.getTestingResult("UT_TC_006_003_002_002",String.valueOf(UT_TC_006_003_002_002(bullet)),"false");
			results.add(result2_2);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_3 = excel.getTestingResult("UT_TC_006_003_002_003",String.valueOf(UT_TC_006_003_002_003(bullet)),"false");
			results.add(result2_3);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_4 = excel.getTestingResult("UT_TC_006_003_003_004",String.valueOf(UT_TC_006_003_002_004(bullet)),"false");
			results.add(result2_4);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result2_5 = excel.getTestingResult("UT_TC_006_003_003_005",String.valueOf(UT_TC_006_003_002_005(bullet)),"false");
			results.add(result2_5);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("");
			bullet.setKey("1");
			TestingResult result2_6 = excel.getTestingResult("UT_TC_006_003_003_006",String.valueOf(UT_TC_006_003_002_006(bullet)),"false");
			results.add(result2_6);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("");
			TestingResult result2_7 = excel.getTestingResult("UT_TC_006_003_003_007",String.valueOf(UT_TC_006_003_002_007(bullet)),"false");
			results.add(result2_7);
			bullet.setPhone("15021799675");
			bullet.setTime("2016/6/24");
			bullet.setContent("我很开心");
			bullet.setColor("#ff0000");
			bullet.setSize("16");
			bullet.setTitle("哈哈哈");
			bullet.setKey("1");
			TestingResult result3 = excel.getTestingResult("UT_TC_006_003_003",String.valueOf(UT_TC_006_003_003(bullet)),"true");
			results.add(result3);
			excel.SoftwareTesingResult("addBullet", results);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 测试changebarrage函数
	 */
	@Resource(name="actiontest")
	ActionTest action;
	public boolean UT_TC_006_004_001_001() throws Exception{
		if(action.changebarrage("", "", "我很开心", "#ff0000", "16", "哈哈哈", "8")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_001_002() throws Exception{
		if(action.changebarrage("", "15021799675", "", "#ff0000", "16", "哈哈哈", "8")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_001_003() throws Exception{
		if(action.changebarrage("", "15021799675", "我很开心", "", "16", "哈哈哈", "8")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_001_004() throws Exception{
		if(action.changebarrage("", "15021799675", "我很开心", "#ff0000", "", "哈哈哈", "8")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_001_005() throws Exception{
		if(action.changebarrage("", "15021799675", "我很开心", "#ff0000", "16", "", "8")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_001_006() throws Exception{
		if(action.changebarrage("", "15021799675", "我很开心", "#ff0000", "16", "哈哈哈", "")!=null){
			return true;
		}
		return false;
	}
	public boolean UT_TC_006_004_002() throws Exception{
		if(action.changebarrage("", "150abcd9675", "我很开心", "#ff0000", "16", "哈哈哈", "")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_004_003() throws Exception{
		if(action.changebarrage("", "15012349675", "我很开心", "#ff0000", "16", "哈哈哈", "4")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_004_004() throws Exception{
			if(action.changebarrage("", "150abcd9675", "我很开心", "#ff0000", "16sd", "哈哈哈", "4")!=null){
				return true;
			}
			return false;
		}
	public boolean UT_TC_006_004_005() throws Exception{
		if(action.changebarrage("", "150abcd9675", "我很开心", "ff0000", "16", "哈哈哈", "5")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_004_006() throws Exception{
		if(action.changebarrage("", "150abcd9675", "我很开心", "#ff0000", "16", "哈哈哈", "10")!=null){
			return true;
		}
		return false;
	}
	
	public boolean UT_TC_006_004_007() throws Exception{
		if(action.changebarrage("", "150abcd9675", "我很开心", "#ff0000", "16", "哈哈哈", "8")!=null){
			return true;
		}
		return false;
	}
	
	@Test
	public void T4_changebarrage_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_006_004_001_001",String.valueOf(UT_TC_006_004_001_001()),"false");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_006_004_001_002",String.valueOf(UT_TC_006_004_001_002()),"false");
			results.add(result1_2);
			TestingResult result1_3 = excel.getTestingResult("UT_TC_006_004_001_003",String.valueOf(UT_TC_006_004_001_003()),"false");
			results.add(result1_3);
			TestingResult result1_4 = excel.getTestingResult("UT_TC_006_004_001_004",String.valueOf(UT_TC_006_004_001_004()),"false");
			results.add(result1_4);
			TestingResult result1_5 = excel.getTestingResult("UT_TC_006_004_001_005",String.valueOf(UT_TC_006_004_001_005()),"false");
			results.add(result1_5);
			TestingResult result1_6 = excel.getTestingResult("UT_TC_006_004_001_006",String.valueOf(UT_TC_006_004_001_006()),"false");
			results.add(result1_6);
			TestingResult result2 = excel.getTestingResult("UT_TC_006_004_002",String.valueOf(UT_TC_006_004_002()),"false");
			results.add(result2);
			TestingResult result3 = excel.getTestingResult("UT_TC_006_004_003",String.valueOf(UT_TC_006_004_003()),"false");
			results.add(result3);
			TestingResult result4 = excel.getTestingResult("UT_TC_006_004_004",String.valueOf(UT_TC_006_004_004()),"false");
			results.add(result4);
			TestingResult result5 = excel.getTestingResult("UT_TC_006_004_005",String.valueOf(UT_TC_006_004_005()),"false");
			results.add(result5);
			TestingResult result6 = excel.getTestingResult("UT_TC_006_004_006",String.valueOf(UT_TC_006_004_006()),"false");
			results.add(result6);
			TestingResult result7 = excel.getTestingResult("UT_TC_006_004_007",String.valueOf(UT_TC_006_004_007()),"true");
			results.add(result7);
			excel.SoftwareTesingResult("changebarrage", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}