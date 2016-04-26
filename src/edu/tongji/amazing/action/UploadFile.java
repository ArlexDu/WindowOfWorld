package edu.tongji.amazing.action;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.amazing.tool.Defined;
import edu.tongji.amazing.tool.UpLoadFile;
@Controller("uploadfileaction")
public class UploadFile extends ActionSupport implements ServletRequestAware{

	private File uploadfile;
	private String uploadfileContentType;
	private HttpServletRequest request;
	private HashMap<String, Object> data;
	@Resource(name = "define")
	private Defined define;
	@Resource(name="uploadfile")
	private UpLoadFile upload;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		data = new HashMap<String,Object>();
		String path = request.getSession().getServletContext().getRealPath("/Avatar");
		try{
			data.put(define.Error, define.SUCCESS);
		}catch (Exception e){
			data.put(define.Error, define.FAIL);
			e.printStackTrace();
		}
		return "result";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request  = arg0;
	}

	public File getUploadfile() {
		return uploadfile;
	}
	
	

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

    	
	
	
}
