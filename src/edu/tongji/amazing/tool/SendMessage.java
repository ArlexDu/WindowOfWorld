package edu.tongji.amazing.tool;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 短信http接口的java代码调用示例
 * 基于Apache HttpClient 4.3
 *
 */
@Service("sendmessage")
public class SendMessage {

    //智能匹配模版发送接口的http地址
    private static String URI_SEND_SMS = "https://sms.yunpian.com/v1/sms/send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后获取
    static String apikey = "1d2113d4b2e5178c1d097916c5f691e8";
    
    private String phonenumber;
    private int code;
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
    

	public int getCode() {
		return code;
	}


//	@Test
    public void Send() throws IOException, URISyntaxException{


        //修改为您要发送的手机号
        String mobile = phonenumber;
        /**************** 使用智能匹配模版接口发短信(推荐) *****************/
        //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
        Random random = new Random();
        code = (int)(random.nextFloat()*1000000);
//        System.out.println("code is "+code);
        String text = "【WOW】您的验证码是"+code;
        //发短信调用示例
        sendSms(apikey, text, mobile);
    }


    /**
     * 智能匹配模版接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public String sendSms(String apikey, String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}

