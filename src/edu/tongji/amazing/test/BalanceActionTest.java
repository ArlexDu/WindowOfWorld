package edu.tongji.amazing.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.tongji.amazing.model.Balance;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.IBalanceService;
import edu.tongji.amazing.tool.FileTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceActionTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="filetool")
	FileTools excel;
	/*
	 * 测试changeBalance函数
	 */
	@Resource(name = "balanceservice")
	private IBalanceService service;
	
	public boolean UT_TC_003_001(Balance balance){
		if(service.changeBalance(balance)){
			return true;
		}
		return false;
	}
	
	@Test
	public void T1_changeBalance_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("changeBalance");
			for(int i=0;i<tests.size();i++){
				Balance balance = null;
				if(i!=0){
					balance = new Balance();
					balance.setMoney(tests.get(i)[1]);
					balance.setPhone(tests.get(i)[2]);
					balance.setReason(tests.get(i)[3]);
				}
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_003_001(balance)),tests.get(i)[4]);
				results.add(result);
			}
			excel.SoftwareTesingResult("changeBalance", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 测试Changebill函数
	 */
	@Resource(name="actiontest")
	private ActionTest action;
	
	public boolean UT_TC_003_002(String money,String phone,String reason) throws Exception{
		if(action.Changebill(money, phone, reason)!=null){
			return true;
		}
		return false;
	}
	
	@Test
	public void T2_Changebill_Test(){
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			List<String[]> tests;
				tests = excel.readExcel("Changebill");
			for(int i=0;i<tests.size();i++){
				TestingResult result = excel.getTestingResult(tests.get(i)[0],String.valueOf(UT_TC_003_002(tests.get(i)[1],tests.get(i)[2],tests.get(i)[3])),tests.get(i)[4]);
				results.add(result);
			}
			excel.SoftwareTesingResult("Changebill", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}