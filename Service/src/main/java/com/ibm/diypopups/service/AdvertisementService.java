package com.ibm.diypopups.service;

import java.util.List;

import com.ibm.diypopups.model.Advertisement;

public interface AdvertisementService {

	List<Advertisement> getAllAdvertisement();
    Advertisement getAdvertisementById(int advtId);
	boolean addAdvertisement(Advertisement advt);
}
