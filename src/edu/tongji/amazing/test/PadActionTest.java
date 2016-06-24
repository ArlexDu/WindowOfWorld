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

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import edu.tongji.amazing.action.ActionTest;
import edu.tongji.amazing.action.PadAction;
import edu.tongji.amazing.action.PadAction.ad;
import edu.tongji.amazing.model.TestingResult;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.FileTools;
import edu.tongji.amazing.tool.PushMsgToDevice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PadActionTest extends AbstractJUnit4SpringContextTests {

	@Resource(name = "filetool")
	FileTools excel;
	/*
	 * 测试SendAdvertise函数
	 */

	@Resource(name = "advertisementservice")
	private IAdvertisementService advertisementService;

	public boolean UT_TC_002_001_001_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(135.05), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_001_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(53.3)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_002_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(73.33), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_002_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(3.51)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_003() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_004_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(73.34), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_004_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(3.52)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_005_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(73.32), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_005_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(3.5)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_006_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(135.06), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_006_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(53.34)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_007_001() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(135.04), String.valueOf(28)) != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_001_007_002() throws Exception {
		if (advertisementService.SendAdvertise(String.valueOf(104), String.valueOf(53.32)) != null) {
			return true;
		}
		return false;
	}

	@Test
	public void T1_SendAdvertise_Test() {
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_002_001_001_001",
					String.valueOf(UT_TC_002_001_001_001()), "true");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_002_001_001_002",
					String.valueOf(UT_TC_002_001_001_002()), "true");
			results.add(result1_2);
			TestingResult result2_1 = excel.getTestingResult("UT_TC_002_001_002_001",
					String.valueOf(UT_TC_002_001_002_001()), "true");
			results.add(result2_1);
			TestingResult result2_2 = excel.getTestingResult("UT_TC_002_001_002_002",
					String.valueOf(UT_TC_002_001_002_002()), "true");
			results.add(result2_2);
			TestingResult result3 = excel.getTestingResult("UT_TC_002_001_003", String.valueOf(UT_TC_002_001_003()),
					"true");
			results.add(result3);
			TestingResult result4_1 = excel.getTestingResult("UT_TC_002_001_004_001",
					String.valueOf(UT_TC_002_001_004_001()), "true");
			results.add(result4_1);
			TestingResult result4_2 = excel.getTestingResult("UT_TC_002_001_004_002",
					String.valueOf(UT_TC_002_001_004_002()), "true");
			results.add(result4_2);
			TestingResult result5_1 = excel.getTestingResult("UT_TC_002_001_005_001",
					String.valueOf(UT_TC_002_001_005_001()), "false");
			results.add(result5_1);
			TestingResult result5_2 = excel.getTestingResult("UT_TC_002_001_005_002",
					String.valueOf(UT_TC_002_001_005_002()), "false");
			results.add(result5_2);
			TestingResult result6_1 = excel.getTestingResult("UT_TC_002_001_006_001",
					String.valueOf(UT_TC_002_001_006_001()), "false");
			results.add(result6_1);
			TestingResult result6_2 = excel.getTestingResult("UT_TC_002_001_006_002",
					String.valueOf(UT_TC_002_001_006_002()), "false");
			results.add(result6_2);
			TestingResult result7_1 = excel.getTestingResult("UT_TC_002_001_007_001",
					String.valueOf(UT_TC_002_001_007_001()), "true");
			results.add(result7_1);
			TestingResult result7_2 = excel.getTestingResult("UT_TC_002_001_007_002",
					String.valueOf(UT_TC_002_001_007_002()), "true");
			results.add(result7_2);
			excel.SoftwareTesingResult("SendAdvertise", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 测试getfrombaidu函数
	 */
	public boolean UT_TC_002_002_001_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(135.05), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_001_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(53.3), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_002_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(73.33), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_002_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(3.51), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_003() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_004_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(73.34), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_004_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(3.52), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_005_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(73.32), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_005_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(3.5), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_006_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(135.06), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_006_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(53.34), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_007_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(135.04), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_007_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(53.32), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_008_001() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(28), "学校")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_008_002() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(53.32), "医院")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_008_003() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(28), "酒店")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_002_008_004() throws Exception {
		if (advertisementService.getfrombaidu(String.valueOf(104), String.valueOf(53.32), "xx")) {
			return true;
		}
		return false;
	}

	@Test
	public void T2_getfrombaidu_Test() {
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_002_002_001_001",
					String.valueOf(UT_TC_002_002_001_001()), "true");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_002_002_001_002",
					String.valueOf(UT_TC_002_002_001_002()), "true");
			results.add(result1_2);
			TestingResult result2_1 = excel.getTestingResult("UT_TC_002_002_002_001",
					String.valueOf(UT_TC_002_002_002_001()), "true");
			results.add(result2_1);
			TestingResult result2_2 = excel.getTestingResult("UT_TC_002_002_002_002",
					String.valueOf(UT_TC_002_002_002_002()), "true");
			results.add(result2_2);
			TestingResult result3 = excel.getTestingResult("UT_TC_002_002_003", String.valueOf(UT_TC_002_002_003()),
					"true");
			results.add(result3);
			TestingResult result4_1 = excel.getTestingResult("UT_TC_002_002_004_001",
					String.valueOf(UT_TC_002_002_004_001()), "true");
			results.add(result4_1);
			TestingResult result4_2 = excel.getTestingResult("UT_TC_002_002_004_002",
					String.valueOf(UT_TC_002_002_004_002()), "true");
			results.add(result4_2);
			TestingResult result5_1 = excel.getTestingResult("UT_TC_002_002_005_001",
					String.valueOf(UT_TC_002_002_005_001()), "false");
			results.add(result5_1);
			TestingResult result5_2 = excel.getTestingResult("UT_TC_002_002_005_002",
					String.valueOf(UT_TC_002_002_005_002()), "false");
			results.add(result5_2);
			TestingResult result6_1 = excel.getTestingResult("UT_TC_002_002_006_001",
					String.valueOf(UT_TC_002_002_006_001()), "false");
			results.add(result6_1);
			TestingResult result6_2 = excel.getTestingResult("UT_TC_002_002_006_002",
					String.valueOf(UT_TC_002_002_006_002()), "false");
			results.add(result6_2);
			TestingResult result7_1 = excel.getTestingResult("UT_TC_002_002_007_001",
					String.valueOf(UT_TC_002_002_007_001()), "true");
			results.add(result7_1);
			TestingResult result7_2 = excel.getTestingResult("UT_TC_002_002_007_002",
					String.valueOf(UT_TC_002_002_007_002()), "true");
			results.add(result7_2);
			TestingResult result8_1 = excel.getTestingResult("UT_TC_002_002_008_001",
					String.valueOf(UT_TC_002_002_008_001()), "true");
			results.add(result8_1);
			TestingResult result8_2 = excel.getTestingResult("UT_TC_002_002_008_002",
					String.valueOf(UT_TC_002_002_008_002()), "true");
			results.add(result8_2);
			TestingResult result8_3 = excel.getTestingResult("UT_TC_002_002_008_003",
					String.valueOf(UT_TC_002_002_008_003()), "true");
			results.add(result8_3);
			TestingResult result8_4 = excel.getTestingResult("UT_TC_002_002_008_004",
					String.valueOf(UT_TC_002_002_008_004()), "false");
			results.add(result8_4);
			excel.SoftwareTesingResult("getfrombaidu", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 测试SpecialShowAdvertisements函数
	 */
	public boolean UT_TC_002_003_001_001() throws Exception {
		if (advertisementService.SpecialShowAdvertisements("学校") != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_003_001_002() throws Exception {
		if (advertisementService.SpecialShowAdvertisements("医院") != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_003_001_003() throws Exception {
		if (advertisementService.SpecialShowAdvertisements("酒店") != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_003_001_004() throws Exception {
		if (advertisementService.SpecialShowAdvertisements("xxx") != null) {
			return true;
		}
		return false;
	}

	@Test
	public void T3_SpecialShowAdvertisements_Test() {
		try {
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_002_003_001_001",
					String.valueOf(UT_TC_002_003_001_001()), "true");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_002_003_001_002",
					String.valueOf(UT_TC_002_003_001_002()), "true");
			results.add(result1_2);
			TestingResult result1_3 = excel.getTestingResult("UT_TC_002_003_001_003",
					String.valueOf(UT_TC_002_003_001_003()), "true");
			results.add(result1_3);
			TestingResult result1_4 = excel.getTestingResult("UT_TC_002_003_001_004",
					String.valueOf(UT_TC_002_003_001_004()), "false");
			results.add(result1_4);
			excel.SoftwareTesingResult("SpecialShowAdvertisements", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 测试getProduct函数
	 */
	@Resource(name = "carownerservice")
	ICarOwnerService carOwnerService;

	public boolean UT_TC_002_004_001() {
		if (carOwnerService.getProduct("150abcd9675") != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_004_002() {
		if (carOwnerService.getProduct("15012349675") != null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_004_003() {
		if (carOwnerService.getProduct("15021799675") != null) {
			return true;
		}
		return false;
	}

	@Test
	public void T4_getProduct_Test() {
		ArrayList<TestingResult> results = new ArrayList<TestingResult>();
		TestingResult result1 = excel.getTestingResult("UT_TC_002_004_001", String.valueOf(UT_TC_002_004_001()),
				"false");
		results.add(result1);
		TestingResult result2 = excel.getTestingResult("UT_TC_002_004_002", String.valueOf(UT_TC_002_004_002()),
				"false");
		results.add(result2);
		TestingResult result3 = excel.getTestingResult("UT_TC_002_004_003", String.valueOf(UT_TC_002_004_003()),
				"true");
		results.add(result3);
		excel.SoftwareTesingResult("getProduct", results);
	}

	/*
	 * 测试send函数
	 */
	@Resource(name = "actiontest")
	private ActionTest action;
	private List<ad> advertisements = new ArrayList<ad>();

	public boolean UT_TC_002_005_001_001() throws Exception {
		if (action.send("", advertisements, "3")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_005_001_002() throws Exception {
		if (action.send("4398277239313873648", null, "3")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_005_001_003() throws Exception {
		if (action.send("4398277239313873648", advertisements, "")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_005_002_001() throws Exception {
		if (action.send("4398277239313873648", advertisements, "1")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_005_002_002() throws Exception {
		if (action.send("4398277239313873648", advertisements, "2")) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_005_002_003() throws Exception {
		if (action.send("4398277239313873648", advertisements, "3")) {
			return true;
		}
		return false;
	}

	@Test
	public void T5_send_Test() {
		try {
			PadAction.ad a = new PadAction().new ad();
			a.setContent("mengmengda");
			a.setSort("0");
			advertisements.add(a);
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_002_005_001_001",
					String.valueOf(UT_TC_002_005_001_001()), "false");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_002_005_001_002",
					String.valueOf(UT_TC_002_005_001_002()), "false");
			results.add(result1_2);
			TestingResult result1_3 = excel.getTestingResult("UT_TC_002_005_001_003",
					String.valueOf(UT_TC_002_005_001_003()), "true");
			results.add(result1_3);
			TestingResult result2_1 = excel.getTestingResult("UT_TC_002_005_002_001",
					String.valueOf(UT_TC_002_005_002_001()), "true");
			results.add(result2_1);
			TestingResult result2_2 = excel.getTestingResult("UT_TC_002_005_002_002",
					String.valueOf(UT_TC_002_005_002_002()), "true");
			results.add(result2_2);
			TestingResult result2_3 = excel.getTestingResult("UT_TC_002_005_002_003",
					String.valueOf(UT_TC_002_005_002_003()), "true");
			results.add(result2_3);
			excel.SoftwareTesingResult("send", results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 测试SendAdvertisement函数
	 */
	public boolean UT_TC_002_006_001_001() throws Exception {
		if (action.SendAdvertisement("", "28", "15021799675")!=null) {
			return true;
		}
		return false;
	}

	public boolean UT_TC_002_006_001_002() throws Exception {
		if (action.SendAdvertisement("104", "", "15021799675")!=null) {
			return true;
		}
		return false;
	}
	public boolean UT_TC_002_006_001_003() throws Exception {
		if (action.SendAdvertisement("104", "28", "")!=null) {
			return true;
		}
		return false;
	}
	public boolean UT_TC_002_006_002() throws Exception {
		if (action.SendAdvertisement("104", "28", "15021799675")!=null) {
			return true;
		}
		return false;
	}
	
	@Test
	public void T6_SendAdvertisement_Test() {
		try{
			ArrayList<TestingResult> results = new ArrayList<TestingResult>();
			TestingResult result1_1 = excel.getTestingResult("UT_TC_002_006_001_001", String.valueOf(UT_TC_002_006_001_001()),
					"false");
			results.add(result1_1);
			TestingResult result1_2 = excel.getTestingResult("UT_TC_002_006_001_002", String.valueOf(UT_TC_002_006_001_002()),
					"false");
			results.add(result1_2);
			TestingResult result1_3 = excel.getTestingResult("UT_TC_002_006_001_003", String.valueOf(UT_TC_002_006_001_003()),
					"false");
			results.add(result1_3);
			TestingResult result2 = excel.getTestingResult("UT_TC_002_006_002", String.valueOf(UT_TC_002_006_002()),
					"true");
			results.add(result2);
			excel.SoftwareTesingResult("SendAdvertisement", results);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}