package edu.tongji.amazing.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component("filetool")
public class FileTools {

	// 存储文件
	public String SaveFile(File file, String path, String wholetype) throws Exception {
		InputStream is = new FileInputStream(file);
		OutputStream os = null;
		String type = wholetype.split("/")[1];
		String filepath = path + "\\" + System.currentTimeMillis() + "." + type;
		os = new FileOutputStream(filepath);
		int a = 0;
		while ((a = is.read()) != -1) {
			os.write(a);
		}
		os.flush();
		os.close();
		is.close();
		return filepath;
	}
	
	@Resource(name = "define")
	private Defined defined;
	
	public void deleteFile(String path) throws Exception {
		/*
		http://10.60.42.70:8080/AmazingAd/Individuation/1462291638455.png
	             转换为：D:\Eclipse\apache-tomcat\webapps\AmazingAd\Individuation\1462291638455.png
	    */
		String localpath = defined.basepath + "\\AmazingAd"+ path.split("AmazingAd")[1].replace('/', '\\');
		File file = new File(localpath);
		if(file.isFile()&&file.exists()){
			file.delete();
		}
	}
}
