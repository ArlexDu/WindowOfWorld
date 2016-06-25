package edu.tongji.amazing.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import edu.tongji.amazing.model.TestingResult;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
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
	/*
	 * 测试的时候，把测试结果输入到excel中
	 */
	 public void SoftwareTesingResult(String functionname,List<TestingResult> results) {
	        try {
	        	File file = new File("E:\\SoftwareTesting\\单元测试.xls");
	        	 //设置函数字体
                WritableFont fonttitle = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);  
                
                WritableCellFormat cellFormat1 = new WritableCellFormat(fonttitle); 
                //设置自动换行;  
                cellFormat1.setWrap(true);  
                //设置文字居中对齐方式;  
                cellFormat1.setAlignment(Alignment.CENTRE);  
                //设置垂直居中;  
                cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE); 
                
	        	 //设置结果正确字体
                WritableFont fontright = new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.GREEN);  
                
                WritableCellFormat cellFormat2 = new WritableCellFormat(fontright);    
                //设置文字居中对齐方式;  
                cellFormat2.setAlignment(Alignment.CENTRE);  
                //设置垂直居中;  
                cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE); 
                
                
	        	 //设置结果错误字体
                WritableFont fontwrong = new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);  
                
                WritableCellFormat cellFormat3 = new WritableCellFormat(fontwrong);    
                //设置文字居中对齐方式;  
                cellFormat3.setAlignment(Alignment.CENTRE);  
                //设置垂直居中;  
                cellFormat3.setVerticalAlignment(VerticalAlignment.CENTRE);
                
                //设置函数字体
                WritableFont fontcontent = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);  
                
                WritableCellFormat cellFormat4 = new WritableCellFormat(fontcontent);    
                //设置文字居中对齐方式;  
                cellFormat4.setAlignment(Alignment.CENTRE);  
                //设置垂直居中;  
                cellFormat4.setVerticalAlignment(VerticalAlignment.CENTRE); 
	            if (!file.exists()) { //判断文件是否已存在，如果没有存在则创建新文件
	                WritableWorkbook wwb = Workbook.createWorkbook(file);
	                WritableSheet ws = wwb.createSheet("测试结果", 0);
	                //给sheet电子版中所有的列设置默认的列的宽度;  
	                ws.getSettings().setDefaultColumnWidth(20); 
	                ws.setColumnView(0, 40); //设置列宽
	                WritableFont fonttitlebar = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.WHITE);  
	                
	                WritableCellFormat cellFormat0 = new WritableCellFormat(fonttitlebar);
	                //设置背景颜色;  
	                cellFormat0.setBackground(Colour.GRAY_50);  
	                //设置自动换行;  
	                cellFormat0.setWrap(true);  
	                //设置文字居中对齐方式;  
	                cellFormat0.setAlignment(Alignment.CENTRE);  
	                //设置垂直居中;  
	                cellFormat0.setVerticalAlignment(VerticalAlignment.CENTRE); 
	                Label label = new Label(0, 0, "函数名称",cellFormat0);
	                ws.addCell(label);
	                Label space1 = new Label(1, 0, "",cellFormat0);
	                ws.addCell(space1);
	                Label label2 = new Label(2, 0, "测试结果",cellFormat0);
	                ws.addCell(label2);
	                Label space2 = new Label(3, 0, "",cellFormat0);
	                ws.addCell(space2); 
	                Label label3 = new Label(4, 0, "预计结果",cellFormat0);
	                ws.addCell(label3);
	                Label space3 = new Label(5, 0, "",cellFormat0);
	                ws.addCell(space3);
	                Label label4 = new Label(6, 0, "是否通过",cellFormat0);
	                ws.addCell(label4);
	                Label name = new Label(0, 1, functionname,cellFormat1);
	                ws.addCell(name);
	                //写入Exel工作表
	                for(int i = 0;i<results.size();i++){
		                Label param1 = new Label(0, i+2, results.get(i).getFunction_name(),cellFormat4);
		                ws.addCell(param1);
		                Label param2 = new Label(2, i+2, results.get(i).getReal_result(),cellFormat4);
		                ws.addCell(param2);
		                Label param3 = new Label(4, i+2, results.get(i).getPredict_result(),cellFormat4);
		                ws.addCell(param3);
		                Label param4;
		                if(results.get(i).getResult()=="pass"){
		                	 param4 = new Label(6, i+2, results.get(i).getResult(),cellFormat2);
		                }else{
		                	 param4 = new Label(6, i+2, results.get(i).getResult(),cellFormat3);
		                }
		                ws.addCell(param4);
	                }
	                wwb.write();
	                //关闭Excel工作薄对象
	                wwb.close();
	            } else {
	                Workbook rwb = Workbook.getWorkbook(file);
	                File tempfile = new File("E:\\tempfile.xls");
	                WritableWorkbook wwb = Workbook.createWorkbook(tempfile, rwb);
	                WritableSheet ws = wwb.getSheet(0);
	                ws.getSettings().setDefaultColumnWidth(20); 
	                int row = rwb.getSheet(0).getRows();
	                String name = functionname; //添加列名
	                Label label = new Label(0, row, name,cellFormat1);
	                ws.addCell(label);
	                //写入Excel工作表
	                for(int i = 0;i<results.size();i++){
		                Label param1 = new Label(0, row+i+1, results.get(i).getFunction_name(),cellFormat4);
		                ws.addCell(param1);
		                Label param2 = new Label(2, row+i+1, results.get(i).getReal_result(),cellFormat4);
		                ws.addCell(param2);
		                Label param3 = new Label(4, row+i+1, results.get(i).getPredict_result(),cellFormat4);
		                ws.addCell(param3);
		                Label param4;
		                if(results.get(i).getResult()=="pass"){
		                	 param4 = new Label(6, row+i+1, results.get(i).getResult(),cellFormat2);
		                }else{
		                	 param4 = new Label(6, row+i+1, results.get(i).getResult(),cellFormat3);
		                }
		                ws.addCell(param4);
	                }
	                wwb.write();
	                wwb.close();
	                rwb.close();
//	                String filename = file.getPath();
//	                System.out.println("filename:" + filename);
	                file.delete();
	                tempfile.renameTo(file);
//	                System.out.println("tempfile:" + tempfile.getPath());
//	                System.out.println(tempfile.exists());
//	                System.out.println(file.exists());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 //获得result结果
	 public TestingResult getTestingResult(String functionname,String real_result,String predict_result){
		TestingResult result = new TestingResult();
		result.setFunction_name(functionname);
		result.setReal_result(real_result);
		result.setPredict_result(predict_result);
		if(real_result.equals(predict_result)){
			result.setResult("pass");
		}else{
			result.setResult("wrong");
		}
		return result;
	 }
	 
	 //从excel中读取测试用例
	 public List<String[]> readExcel(String excel) throws Exception{
		   
		    //创建一个list用来存读取的内容
		    List<String[]> list =new ArrayList<String[]>();
		    Workbook rwb = null;
		    Cell cell = null;
		    File excelFile = new File("E:\\SoftwareTesting\\"+excel+".xls");
		    //创建输入流
		    InputStream stream = new FileInputStream(excelFile);
		    //获取Excel文件对象
		    rwb = Workbook.getWorkbook(stream);
		    //获取文件的指定工作表 默认的第一个
		    Sheet sheet = rwb.getSheet(0);
		    //行数(表头的目录不需要，从1开始)
		    for(int i = 0;i<sheet.getRows();i++){
		    //创建一个数组 用来存储每一列的值
			    String[] str = new String[sheet.getColumns()];
			    //列数
			    for(int j =0;j<sheet.getColumns();j++){
				    //获取第i行，第j列的值
				    cell = sheet.getCell(j, i);
				    str[j] = cell.getContents();
			    }
			    list.add(str);
		    }
		    return list;
		    }
}
