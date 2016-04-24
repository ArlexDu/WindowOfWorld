package edu.tongji.amazing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tongji.amazing.dao.impl.IndividuationDao;
import edu.tongji.amazing.model.Individuation;
import edu.tongji.amazing.service.IIndividuationService;

@Service("individuationservice")
public class IndividuationService implements IIndividuationService{

	@Resource(name="individuationdao")
	private IndividuationDao dao;
	@Override
	public boolean AddIndividuation(Individuation individuation) {
		// TODO Auto-generated method stub
		return dao.Insert(individuation);
	}

	@Override
	public boolean DeleteIndividuation(String id) {
		// TODO Auto-generated method stub
		return dao.DeleteViaId(id);
	}

	@Override
	public Individuation GetIndividuationById(String id) {
		// TODO Auto-generated method stub
		return dao.QueryById(id);
	}

	@Override
	public int GetNumbers(String phone) {
		// TODO Auto-generated method stub
		return dao.GetNumbers(phone);
	}

	@Override
	public Individuation GetLast(String phone) {
		// TODO Auto-generated method stub
		return dao.GetLast(phone);
	}

	@Override
	public List<Individuation> GetIndividuationByPhone(String phone) {
		// TODO Auto-generated method stub
		return dao.QueryByPhone(phone);
	}

	@Override
	public boolean clearShortCut(String phone, String key) {
		// TODO Auto-generated method stub
		return dao.clearShortCut(phone, key);
	}

	@Override
	public boolean addShortCut(String id, String key) {
		// TODO Auto-generated method stub
		return dao.setShortCut(id, key);
	}

	@Override
	public String CheckShortCut(String phone, String key) {
		// TODO Auto-generated method stub
		return dao.CheckShortCut(phone, key);
	}

	@Override
	public boolean ChangeStatus(String id, String status) {
		// TODO Auto-generated method stub
		return dao.ChangeStatus(id, status);
	}

}
