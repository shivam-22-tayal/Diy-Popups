package com.ibm.diypopups.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.diypopups.model.advertisements;
import com.ibm.diypopups.model.users;
import com.ibm.diypopups.model.creditcounter;
@Component
public class EndUserService {
	
	@Autowired 
	EndUserRepository repo;

	@Autowired
	AdvertisementDAO vidrepo;

	@Autowired
	creditcounterRepository credRepo;


		public void add(users U) {
			//MultipartFile file=repo.findById(V.getId()).get(). 
			// @formatter:on

			//String filename=
			
			repo.save(U);
		}
		
		
		public void update(users U) {
			
			repo.save(U);
		}
		
		
		public void delete(int id) {
			repo.delete(repo.findById(id).get());
		}
		
		public List<users> list() {
			
				List<users> eU = new ArrayList<>();
				for (users U : repo.findAll()) {
					eU.add(U);
				}
				return eU;
			}
			
		
		public users get(int vId)
		{
			//return employees.get(empId);
			return repo.findById(vId).get();
			 
			// @formatter:on

		}
		
		public List<advertisements> listVids() {
			
			List<advertisements> vds = new ArrayList<>();
			for (advertisements V : vidrepo.findAll()) {
				vds.add(V);
			}
			return vds;
		}
		
		public void UpdateClick(int id){
			//return  (List<Employee>)repository.findByDepartment(department);
			advertisements v1=vidrepo.findById(id).get();
			int z=v1.getClicks()+1;
			v1.setClicks(z);
			vidrepo.save(v1);
			//return true;
		}
		
		public void CreditCount(int vid,int eid) {
			creditcounter cct=new creditcounter();
			cct.setVid(vid);
			cct.setEid(eid);
			int ct=credRepo.countCredit(vid, eid);
			
			users eu;
		
			if(ct==0) {
				
				credRepo.save(cct);
				
				//cct=credRepo.findById(vid).get();
				
				eu=repo.findById(eid).get();
				int x=eu.getCredits();
				x+=10;
				eu.setCredits(x);
				repo.save(eu);
				
			}
			
		}
	}






