package edu.tongji.amazing.tool;

import org.springframework.stereotype.Component;

@Component("define")
public class Defined {

	public final String Error = "errCode";
	public final String apikey = "1d2113d4b2e5178c1d097916c5f691e8";
//	public final String baseurl = "http://10.60.42.70:8080";
	public final String baseurl = "localhost:8080";
	public final String basepath = "D:\\Eclipse\\apache-tomcat\\webapps";
	public final int SUCCESS = 1;//鎴愬姛
	public final int FAIL = 0; //澶辫触
	public final int NOUSER = 101; //涓嶅瓨鍦ㄧ敤鎴�
	public final int WrongPassword = 102; //瀵嗙爜閿欒
	public final int RrgisteredUSER = 104; //宸茬粡娉ㄥ唽鐨勭敤鎴�
	public final int BARRAGEEXIST = 110;  //寮瑰箷蹇嵎閿凡缁忚浣跨敤
	public final int BARRAGENOEXIST = 111;  //寮瑰箷蹇嵎閿病鏈夎浣跨敤
}
