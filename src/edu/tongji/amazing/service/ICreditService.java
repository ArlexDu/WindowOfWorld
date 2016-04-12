package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Credit;

public interface ICreditService {

	public boolean addCredit(Credit credit);
	
	public List<Credit> getCreditList(String phone);
}
