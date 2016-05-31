package edu.tongji.amazing.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.AdvertisementDao;
import edu.tongji.amazing.dao.impl.GeneralDao;
import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.User;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.tool.Defined;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("advertisementservice")
public class AdvertisementService implements IAdvertisementService {

	@Resource(name="advertisementdao")
	private AdvertisementDao dao;
	@Override
	public List<Advertisement> GetAdsList(String phone) {
		// TODO Auto-generated method stub
		return dao.QueryByPhone(phone);
	}

	@Override
	public Advertisement GetAd(String ad_id) {
		// TODO Auto-generated method stub
		return dao.QueryById(ad_id);
	}

	@Override
	public void AddNewAd(Advertisement ad) {
		// TODO Auto-generated method stub
		dao.Insert(ad);
	}

	@Override
	public void UpdateAd(Advertisement ad) {
		// TODO Auto-generated method stub
		dao.Update(ad);
	}

	@Override
	public void DeleteAd(String ad_id) {
		// TODO Auto-generated method stub
		dao.DeleteViaId(ad_id);
	}

	@Override
	public List<Advertisement> SendAdvertise(String longitude, String latitude) throws Exception {
		// TODO Auto-generated method stub
		double lon = Double.parseDouble(longitude);
		double lat = Double.parseDouble(latitude);
		//100米对应的纬度
		double round_lat = 1.0/111000*100;
		//100米对应的经度
		double round_lon = 1.0/111000*Math.cos(lat)*100;
//		System.out.println("round_lat is "+round_lat);
//		System.out.println("round_lon is "+round_lon);
		//查找经度的范围
		double start_lat = lat - round_lat;
		double end_lat = lat + round_lat;
//		System.out.println("start_lat is "+start_lat);
//		System.out.println("end_lat is "+end_lat);
		//查找纬度的范围
		double start_lon = lon - round_lon;
		double end_lon = lon + round_lon;
//		System.out.println("start_lon is "+start_lon);
//		System.out.println("end_lon is "+end_lon);
		Date date = new Date();
		int hour = date.getHours();
		long d = System.currentTimeMillis();
//		System.out.println("hour is "+hour);
		return dao.SendAdvertise(start_lon, end_lon, start_lat, end_lat, hour,d);
	}

	@Override
	public List<Advertisement> GetShowAdvertisements() throws Exception{
		// TODO Auto-generated method stub
		return dao.GetShowAdvertisements();
	}

	@Override
	public List<Advertisement> SpecialShowAdvertisements(String place) throws Exception {
		// TODO Auto-generated method stub
		return dao.SpecialShowAdvertisements(place);
	}
	
	@Override
	public boolean getfrombaidu(String lon, String lat,String place) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		String searchurl = "http://api.map.baidu.com/place/v2/search?query="+place+"&"
				+ "page_size=1&page_num=0&scope=1&location="+lat+","+lon+"&radius=200"
				+ "&output=json&ak="+Defined.Baiduapk;
		HttpGet get = new HttpGet(searchurl);
		CloseableHttpResponse response = null;
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inputStream = entity.getContent();
				String info = getStreamAsString(inputStream, "UTF-8");
//				System.out.println(info);
				JSONObject object = JSONObject.fromString(info);
				String number = object.getString("total");
				System.out.println("number is "+number);
				if(!number.equals("0")){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}
	
	 public String getStreamAsString(InputStream stream, String charset) throws IOException {
	     try {
	         BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset), 8192);
	         StringWriter writer = new StringWriter();

	         char[] chars = new char[8192];
	         int count = 0;
	         while ((count = reader.read(chars)) > 0) {
	             writer.write(chars, 0, count);
	         }

	         return writer.toString();
	     } finally {
	         if (stream != null) {
	             stream.close();
	         }
	     }
	 }
	

}
