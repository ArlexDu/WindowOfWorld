package edu.tongji.amazing.test;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.FileTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegrationTest extends AbstractJUnit4SpringContextTests{
	@Resource(name="filetool")
	FileTools excel;
	
	

	
	@Resource(name="integrationtestAction")
	IntegrationTestAction action;
	
	public boolean IT_TD_001_001_001_1(){
		if(action.loginAndroid_stub1("","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_001_001_2(){
		if(action.loginAndroid_stub2("","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_001_001_3(){
		if(action.loginAndroid_stub3("","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_001_002_1(){
		if(action.loginAndroid_stub1("15021799675","")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_001_002_2(){
		if(action.loginAndroid_stub2("15021799675","")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_001_002_3(){
		if(action.loginAndroid_stub3("15021799675","")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_002_1(){
		if(action.loginAndroid_stub1("150abcd9675","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_002_2(){
		if(action.loginAndroid_stub2("150abcd9675","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_002_3(){
		if(action.loginAndroid_stub3("150abcd9675","28850169")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_003_1(){
		if(action.loginAndroid_stub1("15012349675","2885")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_003_2(){
		if(action.loginAndroid_stub2("15012349675","2885")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_003_3(){
		if(action.loginAndroid_stub3("15012349675","2885")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_004_1(){
		if(action.loginAndroid_stub1("15021799675","dsy941225")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_004_2(){
		if(action.loginAndroid_stub2("15021799675","dsy941225")!=null){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_001_004_3(){
		if(action.loginAndroid_stub3("15021799675","dsy941225")!=null){
			return true;	
		}
		return false;
	}
	
	
	@Test
	public void Integration_LoginAndroid(){
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_001_001_001_1",String.valueOf(IT_TD_001_001_001_1()),"false");
		results.add(result1_1);
		TestingResult result1_2 = excel.getTestingResult("IT_TD_001_001_001_2",String.valueOf(IT_TD_001_001_001_2()),"false");
		results.add(result1_2);
		TestingResult result1_3 = excel.getTestingResult("IT_TD_001_001_001_3",String.valueOf(IT_TD_001_001_001_3()),"false");
		results.add(result1_3);
		TestingResult result2_1 = excel.getTestingResult("IT_TD_001_002_001_1",String.valueOf(IT_TD_001_002_1()),"false");
		results.add(result2_1);
		TestingResult result2_2 = excel.getTestingResult("IT_TD_001_002_001_2",String.valueOf(IT_TD_001_002_2()),"false");
		results.add(result2_2);
		TestingResult result2_3 = excel.getTestingResult("IT_TD_001_002_001_3",String.valueOf(IT_TD_001_002_3()),"false");
		results.add(result2_3);
		TestingResult result3_1 = excel.getTestingResult("IT_TD_001_003_001_1",String.valueOf(IT_TD_001_003_1()),"false");
		results.add(result3_1);
		TestingResult result3_2 = excel.getTestingResult("IT_TD_001_003_001_2",String.valueOf(IT_TD_001_003_2()),"false");
		results.add(result3_2);
		TestingResult result3_3 = excel.getTestingResult("IT_TD_001_003_001_3",String.valueOf(IT_TD_001_003_3()),"false");
		results.add(result3_3);
		TestingResult result4_1 = excel.getTestingResult("IT_TD_001_004_001_1",String.valueOf(IT_TD_001_004_1()),"false");
		results.add(result4_1);
		TestingResult result4_2 = excel.getTestingResult("IT_TD_001_004_001_2",String.valueOf(IT_TD_001_004_2()),"false");
		results.add(result4_2);
		TestingResult result4_3 = excel.getTestingResult("IT_TD_001_004_001_3",String.valueOf(IT_TD_001_004_3()),"false");
		results.add(result4_3);
	
		excel.SoftwareTesingResult("LoginAndroid", results);
	}
	//integration of send_advertisement
	
	public boolean IT_TD_002_000_1() throws Exception{
		String result=action.sendAd_stub1("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_000_2() throws Exception{
		String result=action.sendAd_stub2("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_000_3() throws Exception{
		String result=action.sendAd_stub3("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_000_4() throws Exception{
		String result=action.sendAd_stub4("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_000_5() throws Exception{
		String result=action.sendAd_stub5("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_000_6() throws Exception{
		String result=action.sendAd_stub6("104.11","28.33","");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_001_1() throws Exception{
		String result=action.sendAd_stub3("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_001_2() throws Exception{
		String result=action.sendAd_stub3("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_001_3() throws Exception{
		String result=action.sendAd_stub3("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_001_4() throws Exception{
		String result=action.sendAd_stub4("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_001_5() throws Exception{
		String result=action.sendAd_stub5("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_001_6() throws Exception{
		String result=action.sendAd_stub6("70.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_1() throws Exception{
		String result=action.sendAd_stub1("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_2() throws Exception{
		String result=action.sendAd_stub2("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_3() throws Exception{
		String result=action.sendAd_stub3("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_4() throws Exception{
		String result=action.sendAd_stub4("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_5() throws Exception{
		String result=action.sendAd_stub5("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_002_6() throws Exception{
		String result=action.sendAd_stub6("73.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_1() throws Exception{
		String result=action.sendAd_stub1("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_2() throws Exception{
		String result=action.sendAd_stub2("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_3() throws Exception{
		String result=action.sendAd_stub3("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_4() throws Exception{
		String result=action.sendAd_stub4("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_5() throws Exception{
		String result=action.sendAd_stub5("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_003_6() throws Exception{
		String result=action.sendAd_stub6("75.33","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_004_1() throws Exception{
		String result=action.sendAd_stub1("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_004_2() throws Exception{
		String result=action.sendAd_stub2("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_004_3() throws Exception{
		String result=action.sendAd_stub3("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_004_4() throws Exception{
		String result=action.sendAd_stub4("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_004_5() throws Exception{
		String result=action.sendAd_stub5("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_004_6() throws Exception{
		String result=action.sendAd_stub6("104.19","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_005_1() throws Exception{
		String result=action.sendAd_stub1("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_005_2() throws Exception{
		String result=action.sendAd_stub2("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_005_3() throws Exception{
		String result=action.sendAd_stub3("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_005_4() throws Exception{
		String result=action.sendAd_stub4("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_005_5() throws Exception{
		String result=action.sendAd_stub5("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_005_6() throws Exception{
		String result=action.sendAd_stub6("133.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_002_006_1() throws Exception{
		String result=action.sendAd_stub1("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_006_2() throws Exception{
		String result=action.sendAd_stub2("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_006_3() throws Exception{
		String result=action.sendAd_stub3("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_006_4() throws Exception{
		String result=action.sendAd_stub4("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_006_5() throws Exception{
		String result=action.sendAd_stub5("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_002_006_6() throws Exception{
		String result=action.sendAd_stub6("135.05","28.41","15021799675");
		if(!result.equals("wrong")){
			return true;	
		}
		return false;
	}
	@Test
	public void Integration_SendAd() throws Exception{
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_002_001_1",String.valueOf(IT_TD_002_001_1()),"false");
		results.add(result1_1);
	
		TestingResult result2_1 = excel.getTestingResult("IT_TD_002_002_1",String.valueOf(IT_TD_002_002_1()),"true");
		results.add(result2_1);
		TestingResult result2_2 = excel.getTestingResult("IT_TD_002_002_2",String.valueOf(IT_TD_002_002_2()),"true");
		results.add(result2_2);
	
		TestingResult result3_1 = excel.getTestingResult("IT_TD_002_003_1",String.valueOf(IT_TD_002_003_1()),"true");
		results.add(result3_1);
		TestingResult result3_2 = excel.getTestingResult("IT_TD_002_003_2",String.valueOf(IT_TD_002_003_2()),"true");
		results.add(result3_2);
		
		TestingResult result4_1 = excel.getTestingResult("IT_TD_002_004_1",String.valueOf(IT_TD_002_004_1()),"true");
		results.add(result4_1);
		TestingResult result4_2 = excel.getTestingResult("IT_TD_002_004_2",String.valueOf(IT_TD_002_004_2()),"true");
		results.add(result4_2);
	
		TestingResult result5_1 = excel.getTestingResult("IT_TD_002_005_1",String.valueOf(IT_TD_002_005_1()),"true");
		results.add(result5_1);
		TestingResult result5_2 = excel.getTestingResult("IT_TD_002_005_2",String.valueOf(IT_TD_002_005_2()),"true");
		results.add(result5_2);
		TestingResult result6_1 = excel.getTestingResult("IT_TD_002_006_1",String.valueOf(IT_TD_002_006_1()),"true");
		results.add(result6_1);
		TestingResult result6_2 = excel.getTestingResult("IT_TD_002_006_2",String.valueOf(IT_TD_002_006_2()),"true");
		results.add(result6_2);
		
		
	
		excel.SoftwareTesingResult("SendAdvertisement", results);
	}
	
	//integration of changeBill
	public boolean IT_TD_003_003_1() throws Exception{
		String result=action.changeBill_stub1("100", "15021799675", "hello world");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	
	public boolean IT_TD_003_003_2() throws Exception{
		String result=action.changeBill_stub2("100", "15021799675", "hello world");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	
	@Test
	public void Integration_changeBill() throws Exception{
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_003_003_1",String.valueOf(IT_TD_003_003_1()),"false");
		results.add(result1_1);
		TestingResult result2_1 = excel.getTestingResult("IT_TD_003_003_2",String.valueOf(IT_TD_003_003_2()),"true");
		results.add(result2_1);
		excel.SoftwareTesingResult("ChangeBill", results);
	}
	
	
	//integration of add_individual
	public boolean IT_TD_004_001_1() throws Exception{
		String result=action.addindividuation_stub1(null, "text", "15021799675", "individual", "description");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_004_002_1() throws Exception{
		File file=new File("D:\\asszy.jpg");
		if(!file.exists()){
			return false;
		}
		String result=action.addindividuation_stub1(file, "text", "15021799675", "individual", "description");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_004_002_2() throws Exception{
		File file=new File("D:\\asszy.jpg");
		String result=action.addindividuation_stub2(file, "text", "15021799675", "individual", "description");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	public boolean IT_TD_004_002_3() throws Exception{
		File file=new File("D:\\asszy.jpg");
		String result=action.addindividuation_stub3(file, "text", "15021799675", "individual", "description");
		if(result.equals("success")){
			return true;	
		}
		return false;
	}
	
	@Test
	public void Integration_addIndividual() throws Exception{
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_004_001_1",String.valueOf(IT_TD_004_001_1()),"false");
		results.add(result1_1);
		TestingResult result2_1 = excel.getTestingResult("IT_TD_004_002_1",String.valueOf(IT_TD_004_002_1()),"false");
		results.add(result2_1);
		TestingResult result2_2 = excel.getTestingResult("IT_TD_004_002_2",String.valueOf(IT_TD_004_002_2()),"false");
		results.add(result2_2);
		TestingResult result2_3 = excel.getTestingResult("IT_TD_004_002_3",String.valueOf(IT_TD_004_002_3()),"true");
		results.add(result2_3);
		excel.SoftwareTesingResult("addindividuation", results);
	}
	
	
	public boolean IT_TD_005_001_1() throws Exception{
		String result=action.examineUser_stub1("", "1", "1");
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	
	public boolean IT_TD_005_002_1() throws Exception{
		String result=action.examineUser_stub1("15021799675", "1", "1");
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	
	public boolean IT_TD_005_002_2() throws Exception{
		String result=action.examineUser_stub2("15021799675", "1", "1");
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	
	public boolean IT_TD_005_002_3() throws Exception{
		String result=action.examineUser_stub3("15021799675", "1", "1");
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	
	@Test
	public void Integration_examineUser() throws Exception{
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_005_001_1",String.valueOf(IT_TD_005_001_1()),"false");
		results.add(result1_1);
		TestingResult result2_1 = excel.getTestingResult("IT_TD_005_002_1",String.valueOf(IT_TD_005_002_1()),"true");
		results.add(result2_1);
		TestingResult result2_2 = excel.getTestingResult("IT_TD_005_002_2",String.valueOf(IT_TD_005_002_2()),"true");
		results.add(result2_2);
		TestingResult result2_3 = excel.getTestingResult("IT_TD_005_002_3",String.valueOf(IT_TD_005_002_3()),"true");
		results.add(result2_3);
		excel.SoftwareTesingResult("examineUser", results);
	}
	
	
	
	public boolean IT_TD_006_001_1() throws Exception{
		String result=action.changebarrage_stub1("15221605290", "haha", "#000fff", "", "title", "2", "1");
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	public boolean IT_TD_006_002_1() throws Exception{
		String result=action.changebarrage_stub1("15221605290", "haha", "#000fff", "100", "title", "1", null);
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	public boolean IT_TD_006_002_2() throws Exception{
		String result=action.changebarrage_stub2("15221605290", "haha", "#000fff", "100", "title", "1", null);
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	public boolean IT_TD_006_002_3() throws Exception{
		String result=action.changebarrage_stub3("15221605290", "haha", "#000fff", "100", "title", "1", null);
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	public boolean IT_TD_006_002_4() throws Exception{
		String result=action.changebarrage_stub4("15221605290", "haha", "#000fff", "100", "title", "1", null);
		if(result.equals("success")){
			return true;
		}
		return false;
	}
	
	@Test
	public void Integration_changebarrage() throws Exception{
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1_1= excel.getTestingResult("IT_TD_006_001_4",String.valueOf(IT_TD_006_001_1()),"true");
		results.add(result1_1);
		TestingResult result2_1 = excel.getTestingResult("IT_TD_006_002_1",String.valueOf(IT_TD_006_002_1()),"false");
		results.add(result2_1);
		TestingResult result2_2 = excel.getTestingResult("IT_TD_006_002_2",String.valueOf(IT_TD_006_002_2()),"false");
		results.add(result2_2);
		TestingResult result2_3 = excel.getTestingResult("IT_TD_006_002_3",String.valueOf(IT_TD_006_002_3()),"false");
		results.add(result2_3);
		TestingResult result2_4 = excel.getTestingResult("IT_TD_006_002_4",String.valueOf(IT_TD_006_002_4()),"true");
		results.add(result2_4);
		excel.SoftwareTesingResult("changebarrage", results);
	}
}
