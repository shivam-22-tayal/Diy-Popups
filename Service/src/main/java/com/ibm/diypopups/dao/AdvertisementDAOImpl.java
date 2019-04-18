package com.ibm.diypopups.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.diypopups.model.Advertisement;

@Transactional
@Repository

public class AdvertisementDAOImpl implements AdvertisementDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;	

	@Override
	public void addAdvertisement(Advertisement advt) {
		// TODO Auto-generated method stub
		entityManager.persist(advt);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAllAdvertisement() {
		// TODO Auto-generated method stub
		String hql = "FROM Advertisement as ats ORDER BY ats.id";
		return (List<Advertisement>) entityManager.createQuery(hql).getResultList();
	}


	@Override
	public Advertisement getAdvertisementById(int advtId) {
		// TODO Auto-generated method stub
		return entityManager.find(Advertisement.class, advtId);
	}
	
}
