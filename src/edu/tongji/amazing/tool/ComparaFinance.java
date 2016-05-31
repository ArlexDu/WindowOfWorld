package edu.tongji.amazing.tool;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import edu.tongji.amazing.model.Finance;
@Component("compara")
public class ComparaFinance implements Comparator<Finance> {

	@Override
	public int compare(Finance o1, Finance o2) {
		// TODO Auto-generated method stub
	//	int f1_date = Integer.parseInt(o1.getFinance_date().replace("-", ""));
	//	int f2_date = Integer.parseInt(o2.getFinance_date().replace("-", ""));
		int flag = o1.getFinance_date().compareTo(o2.getFinance_date());
		return flag;
	}

}
