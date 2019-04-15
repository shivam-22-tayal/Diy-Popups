package com.ibm.diypopups.dao;

import java.util.List;

import com.ibm.diypopups.model.Advertisement;

public interface AdvertisementDAO {
	void addAdvertisement(Advertisement advt);
	List<Advertisement> getAllAdvertisement();
	Advertisement getAdvertisementById(int advtId);
}