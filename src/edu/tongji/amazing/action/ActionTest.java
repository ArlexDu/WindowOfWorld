package edu.tongji.amazing.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import edu.tongji.amazing.action.PadAction.Place;
import edu.tongji.amazing.action.PadAction.ad;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.service.ICarOwnerService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.PushMsgToDevice;
import net.sf.json.JSONObject;

@Controller("actiontest")
public class ActionTest {
	private Map<String, Object> data;
	@Resource
	private ICarOwnerService service;

	@Resource(name = "define")
	private Defined defined;

	// LoginAndroidTest
	public String LoginAndroidTest(String phone, String password) {
		// TODO Auto-generated method stub
		if (phone.equals("") || password.equals("")) {
			return null;
		}
		if (password.length() < 8) {
			return null;
		}
		if (!phone.matches("[0-9]+")) {
			return null;
		}
		data = new HashMap<String, Object>();
		// 判断是否有此用户
		if (service.IsUserExist("15021796775") == null) {
			data.put(defined.Error, defined.NOUSER);
			return "success";
		}
		if (service.checkUser("15021799675", "dsy941225")) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.WrongPassword);
		}
		return "success";
	}

	/*
	 * send函数
	 */
	public boolean send(String channelid, Object ob, String type) throws PushClientException, PushServerException {
		if (channelid.equals("")) {
			return false;
		}
		if (ob == null) {
			return false;
		}
		if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
			return false;
		}
		// 1. get apiKey and secretKey from developer console
		String apiKey = Defined.Baiduapk;
		String secretKey = "UPMlWj1SDcEHFsO6SdgPzmyzBKxFdgwe";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			// 创建 Android的通知
			JSONObject notification = new JSONObject();
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("type", type);
			jsonCustormCont.put("data", ob); // 自定义内容，key-value
			notification.put("wow", jsonCustormCont);

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelid)// "4262492356657242983"
					.addMsgExpires(new Integer(3600)). // message有效时间
					addMessageType(0).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
					addMessage(notification.toString()).addDeviceType(3);// deviceType
																			// =>
																			// 3:android,
																			// 4:ios
			// 5. http request
			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime());
			return true;
		} catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
			return false;
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
						e.getErrorCode(), e.getErrorMsg()));
			}
			return false;
		}
	}
	/*
	 * sendadvertisement函数
	 */
	@Resource
	private IAdvertisementService adservice;
	@Resource(name = "sendinfo")
	private PushMsgToDevice push;
	public String SendAdvertisement(String longitude,String latitude,String phone) throws Exception {
		if(longitude.equals("")||latitude.equals("")||phone.equals("")){
			return null;
		}
		data = new HashMap<String, Object>();
		try {
			List<Advertisement> rawads = adservice.SendAdvertise("104", "28");
			List<ad> advertisements = new ArrayList<ad>();
			Place[] places = Place.values();
			for (Place curplace : places) {
				// 当前坐标周围有这个地点
				if (adservice.getfrombaidu("104", "28", "学校")) {
					rawads.addAll(adservice.SpecialShowAdvertisements("学校"));
				}
			}
			String select = String.valueOf((int) ((Math.random()) * 2));// 0 1
			for (int i = 0; i < rawads.size(); i++) {
				PadAction.ad a = new PadAction().new ad();
				String sort = rawads.get(i).getAdvertisementclass();
				if (sort.equals(select)) {
					a.setSort(rawads.get(i).getAdvertisementclass());
					a.setContent(rawads.get(i).getContent());
					advertisements.add(a);
				}
			}
			// 若某一种格式不存在，则发送另外一种格式广告
			if (advertisements.size() == 0) {
				select = String.valueOf(1 - Integer.valueOf(select));
				for (int i = 0; i < rawads.size(); i++) {
					PadAction.ad a = new PadAction().new ad();
					String sort = rawads.get(i).getAdvertisementclass();
					if (sort.equals(select)) {
						a.setSort(rawads.get(i).getAdvertisementclass());
						a.setContent(rawads.get(i).getContent());
						advertisements.add(a);
					}
				}
			}
			//去除重复的广告
			for (int i = 0; i < advertisements.size() - 1; i++) {
				for (int j = advertisements.size() - 1; j > i; j--) {
					if (advertisements.get(j).getContent().equals(advertisements.get(i).getContent())) {
						advertisements.remove(j);
					}
				}
			}
			String p_id = service.getProduct("15021799675");
			push.send("214141241241241",null, "3");
			data.put(defined.Error, defined.SUCCESS);
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
}
