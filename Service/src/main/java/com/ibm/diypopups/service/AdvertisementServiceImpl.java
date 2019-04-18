package com.ibm.diypopups.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.diypopups.dao.AdvertisementDAO;
import com.ibm.diypopups.model.Advertisement;



@Service
public class AdvertisementServiceImpl implements AdvertisementService{

	@Autowired
	private AdvertisementDAO dpDAO;
	
	
	@Override
	public boolean addAdvertisement(Advertisement advt) {
		// TODO Auto-generated method stub
	
		dpDAO.addAdvertisement(advt);
	
		return true;
	}
	

	@Override
	public List<Advertisement> getAllAdvertisement() {
		// TODO Auto-generated method stub
		return dpDAO.getAllAdvertisement();
	}


	@Override
	public Advertisement getAdvertisementById(int advtId) {
		// TODO Auto-generated method stub
		Advertisement obj = dpDAO.getAdvertisementById(advtId);
		return obj;
	}


}
