package edu.tongji.amazing.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
@Component("uploadfile")
public class UpLoadFile {

	// 存储文件
	public void SaveFile(File file, String path, String wholetype) throws Exception {
		InputStream is = new FileInputStream(file);
		OutputStream os = null;
		String type = wholetype.split("/")[1];
		os = new FileOutputStream(path + "\\" + System.currentTimeMillis() + "." + type);
		int a = 0;
		while ((a = is.read()) != -1) {
			os.write(a);
		}
		os.flush();
		os.close();
		is.close();
	}
}
