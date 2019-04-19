package com.ibm.diypopups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.diypopups.dao.AdvertisementDAOImpl;
import com.ibm.diypopups.model.advertisements;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/advertisements")
public class AdvertisementController {

	@Autowired
	//private AdvertisementService dpService;
	private AdvertisementDAOImpl adrepo;
	//@GetMapping("status")
	@GetMapping("/status")
	public ResponseEntity<String> status(){
		return new ResponseEntity<String>("Services running", HttpStatus.OK);
	}
		
	//@GetMapping("advt/{id}")
	@GetMapping("/{id}")
	public ResponseEntity<advertisements> getAdvertisementById(@PathVariable("id") Integer id) {
		//Advertisement avt = dpService.getAdvertisementById(id);
		advertisements avt=adrepo.getAdvertisementById(id);
		return new ResponseEntity<advertisements>(avt, HttpStatus.OK);
	}
	//@GetMapping("advts")
	@GetMapping
	public ResponseEntity<List<advertisements>> getAllAdvertisement() {
		List<advertisements> list = adrepo.getAllAdvertisement();
		return new ResponseEntity<List<advertisements>>(list, HttpStatus.OK);
	}
	
	
	//@PostMapping("advt")
	@PostMapping
	public ResponseEntity<Void> addAdvertisement(@RequestBody advertisements advt) {
		boolean flag = adrepo.addAdvertisement(advt);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}	
	
	@CrossOrigin(origins="*")
	@GetMapping("/{id}/clicks")

	public boolean clickify(@PathVariable int id) {
		
		adrepo.UpdateClick(id);
		return true;
	}
	@CrossOrigin(origins="*")
	@GetMapping("/AdId")
	public int getAdId(@RequestBody advertisements ad ) {
		
		return ad.getId();
	}
}
