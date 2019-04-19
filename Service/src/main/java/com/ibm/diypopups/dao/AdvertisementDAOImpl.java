package com.ibm.diypopups.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.diypopups.model.advertisements;

/*@Transactional
@Repository

/*public class AdvertisementDAOImpl implements AdvertisementDAO{
	
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
	
}*/

@Component
public class AdvertisementDAOImpl 
{
	@Autowired AdvertisementDAO repo;
	public boolean addAdvertisement(advertisements advt) {
		boolean flag=false;
		repo.save(advt);
		flag= true;
		return flag;
	}
	
	public void Update(advertisements advt) {
		
		repo.save(advt);
	}
	
	public List<advertisements> getAllAdvertisement() {
		
		/*String hql = "FROM Advertisement as ats ORDER BY ats.id";
		return (List<Advertisement>) entityManager.createQuery(hql).getResultList();*/
		List<advertisements> adv=new ArrayList();
		
		for(advertisements A:repo.findAll()) {
			
			adv.add(A);
		}
		return adv;
	}
	
	public advertisements getAdvertisementById(int advtId) {
		
		return repo.findById(advtId).get();
	}
	
	public void delete(int id) {
		repo.delete(repo.findById(id).get());
	}
	
	public void UpdateClick(int id){
		//return  (List<Employee>)repository.findByDepartment(department);
		advertisements v1=repo.findById(id).get();
		int z=v1.getClicks()+1;
		v1.setClicks(z);
		repo.save(v1);
		//return true;
	}
}