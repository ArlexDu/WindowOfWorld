package edu.tongji.amazing.service;

import java.util.List;

import edu.tongji.amazing.model.Individuation;

public interface IIndividuationService {

	public boolean AddIndividuation(Individuation individuation);
	
	public boolean DeleteIndividuation(String id);
	
	public Individuation GetIndividuationById(String Id);
	
	public int GetNumbers(String phone);
	
	public Individuation GetLast(String phone);
	
	public List<Individuation> GetIndividuationByPhone(String phone);
	
    public boolean clearShortCut(String phone,String key);
	
	public boolean addShortCut(String id,String key);
	
	public String CheckShortCut(String phone,String key);
	
	public boolean ChangeStatus(String id,String status);
}
