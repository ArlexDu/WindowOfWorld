package edu.tongji.amazing.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.model.Individuation;
import edu.tongji.amazing.service.IIndividuationService;
import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.UpLoadFile;

@Controller("individuationAction")
public class IndividuationAction extends ActionSupport implements ServletRequestAware {

	private HashMap<String, Object> data;

	@Resource(name = "individuation")
	private Individuation individuation;

	@Resource(name = "individuationservice")
	private IIndividuationService service;

	@Resource(name = "define")
	private Defined defined;

	private HttpServletRequest request;

	@Resource(name = "uploadfile")
	private UpLoadFile upload;

	// 添加一个新的个性化图片 android/individaution/add 请求
	private String phone;
	private String title;
	private File image;
	private String imageContentType;

	public String addindividuation() throws Exception {
		data = new HashMap<String, Object>();
		String path = request.getSession().getServletContext().getRealPath("/Individuation");
		try {
			String filepath = upload.SaveFile(image, path, imageContentType);
			String urlpath = "http://10.60.42.70:8080/AmazingAd" + filepath.split("AmazingAd")[1].replace('\\', '/');
			System.out.println(urlpath);
			individuation.setPhone(phone);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			individuation.setTime(time);
			individuation.setTitle(title);
			individuation.setContent(urlpath);
			individuation.setStatus("-1");
			if (!service.AddIndividuation(individuation)) {
				data.put(defined.Error, defined.FAIL);
				return "result";
			}
			data.put(defined.Error, defined.SUCCESS);
			data.put("url", urlpath);
			return "result";
		} catch (Exception e) {
			data.put(defined.Error, defined.FAIL);
			e.printStackTrace();
			return "result";
		}
	}

	// 根据id删除个性化图片 android/individuation/delete
	private String id;

	public String delete() throws Exception {
		data = new HashMap<String, Object>();
		if (service.DeleteIndividuation(id)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "result";
	}

	// 处理 android/individuation/get 请求指定的个性化图片
	public String getindividuation() throws Exception {
		data = new HashMap<String, Object>();
		individuation = service.GetIndividuationById(id);
		if (individuation == null) {
			data.put(defined.Error, defined.FAIL);
		} else {
			data.put(defined.Error, defined.SUCCESS);
			data.put("id", individuation.getId());
			data.put("content", individuation.getContent());
			data.put("time", individuation.getTime());
			data.put("title", individuation.getTitle());
			data.put("status", individuation.getStatus());
		}
		return "result";
	}

	// 处理 android/individuation/getall 请求
	private List<Individuation> lists;

	public String getAllindividuations() throws Exception {
		data = new HashMap<String, Object>();
		lists = service.GetIndividuationByPhone(phone);
		if (lists.size() == 0) {
			data.put(defined.Error, defined.FAIL);
		} else {
			data.put(defined.Error, defined.SUCCESS);
			data.put("individuations", lists);
		}
		return "result";
	}

	// 处理android/individuation/status 改变当前的个性化图片的状态
	private String status;

	public String ChangStatus() throws Exception {
		data = new HashMap<String, Object>();
		if (service.ChangeStatus(id, status)) {
			data.put(defined.Error, defined.SUCCESS);
		} else {
			data.put(defined.Error, defined.FAIL);
		}
		return "result";
	}

	// android/individuation/getnumber?phone= 获得用户发布弹幕的数量
	public String getNumber() throws Exception {
		data = new HashMap<String, Object>();
		int number = service.GetNumbers(phone);
		if (number == -1) {
			data.put(defined.Error, defined.FAIL);
			return "result";
		}
		individuation = service.GetLast(phone);
		data.put(defined.Error, defined.SUCCESS);
		data.put("number", number);
		data.put("title", individuation.getTitle());
		data.put("time", individuation.getTime());
		return "result";
	}


	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
