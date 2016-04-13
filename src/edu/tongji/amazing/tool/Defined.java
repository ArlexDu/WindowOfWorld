package edu.tongji.amazing.tool;

import org.springframework.stereotype.Component;

@Component("define")
public class Defined {

	public final String Error = "errCode";
	public final String apikey = "1d2113d4b2e5178c1d097916c5f691e8";
	
	public final int SUCCESS = 1;
	public final int FAIL = 0;
	public final int NOUSER = 101;
	public final int WrongPassword = 102;
	public final int RrgisteredUSER = 104;
}
