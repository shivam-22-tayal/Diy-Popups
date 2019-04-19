package com.ibm.diypopups.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.diypopups.model.advertisements;

public interface AdvertisementDAO extends JpaRepository<advertisements, Integer>{
	/*void addAdvertisement(Advertisement advt);
	List<Advertisement> getAllAdvertisement();
	Advertisement getAdvertisementById(int advtId);*/
}