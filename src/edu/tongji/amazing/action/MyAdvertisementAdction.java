package edu.tongji.amazing.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Synthesizer;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Advertisement;
import edu.tongji.amazing.model.AdvertisementPlaceAndTime;
import edu.tongji.amazing.service.IAdvertisementService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.FileTools;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Controller("myadvertisement")
public class MyAdvertisementAdction extends ActionSupport {
	private String phone;
	private String showinfo;
	private String title;
	private String character;
	private File picture;
	@Resource(name="filetool")
	private FileTools upload;
	@Resource(name = "define")
	private Defined defined;
	private String pictureContentType;
	
	private HttpServletRequest request;
	@Resource(name = "advertisement")
  	private Advertisement advertisement;
  	@Resource(name = "advertisementservice")
  	private IAdvertisementService adservice;
	public String newad() throws Exception{

		  advertisement.setPhone(phone);
		  advertisement.setTitle(title);
		  System.out.println("showinfo>>>"+showinfo);
		  if(character.length()>0){
			  advertisement.setContent(character);
		  }
		  else if(picture != null){
			  	HttpServletRequest request = ServletActionContext.getRequest();
				String path = request.getSession().getServletContext().getRealPath("/Advertisement");
				path = upload.SaveFile(picture, path, pictureContentType);
				String urlpath = defined.baseurl+"/AmazingAd" + path.split("AmazingAd")[1].replace('\\', '/');
				advertisement.setContent(urlpath);
		  }else{
			  advertisement.setContent("error");
		  }
		try{
			JSONObject jsonObject = JSONObject.fromObject(showinfo);
			JSONArray jsonArray = jsonObject.getJSONArray("showinfo");
			
			for (int i = 0; i < jsonArray.length(); i++) {
	
				JSONObject temp = JSONObject.fromObject(jsonArray.getString(i));
				String area = temp.getString("area");
				String length = temp.getString("length");
				String time = temp.getString("time");
				String type = temp.getString("type");
				AdvertisementPlaceAndTime placeandtime = new AdvertisementPlaceAndTime();
				if(type.equals("coordinate")){
					String[] sourceStrArray = area.split("@");
					String longitude = sourceStrArray[0];
					String latitude = sourceStrArray[1];
					placeandtime.setLatitude(latitude);
					placeandtime.setLongtitude(longitude);
				}else{
					placeandtime.setPlace(area);
				}
				
				String tempdate=time.substring(0, 10);
				String hour=time.substring(11);
			    placeandtime.setBegin_time(Integer.toString(Integer.parseInt(hour)));
			    placeandtime.setEnd_time(Integer.toString(Integer.parseInt(hour)+Integer.parseInt(length)));
			    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			    long startdate=sdf.parse(tempdate).getTime();
			    long enddate=startdate+24*60*60*1000;
			    placeandtime.setBegindate(Long.toString(startdate));
			    placeandtime.setEnddate(Long.toString(enddate));
			    advertisement.getPlaceandtime().add(placeandtime);
			}

			adservice.AddNewAd(advertisement);
		}catch (JSONException e) {

			e.printStackTrace();

		}
		return "success";
	}
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getShowinfo() {
		return showinfo;
	}

	public void setShowinfo(String showinfo) {
		this.showinfo = showinfo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	

}
