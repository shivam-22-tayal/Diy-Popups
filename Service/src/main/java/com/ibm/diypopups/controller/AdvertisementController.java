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

import com.ibm.diypopups.model.Advertisement;
import com.ibm.diypopups.service.AdvertisementService;

@Controller
@CrossOrigin(origins = "*")
public class AdvertisementController {

	@Autowired
	private AdvertisementService dpService;
	
	@GetMapping("status")
	public ResponseEntity<String> status(){
		return new ResponseEntity<String>("Services running", HttpStatus.OK);
	}
		
	@GetMapping("advt/{id}")
	public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable("id") Integer id) {
		Advertisement avt = dpService.getAdvertisementById(id);
		return new ResponseEntity<Advertisement>(avt, HttpStatus.OK);
	}
	@GetMapping("advts")
	public ResponseEntity<List<Advertisement>> getAllAdvertisement() {
		List<Advertisement> list = dpService.getAllAdvertisement();
		return new ResponseEntity<List<Advertisement>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("advt")
	public ResponseEntity<Void> addAdvertisement(@RequestBody Advertisement advt) {
		boolean flag = dpService.addAdvertisement(advt);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}	
}
