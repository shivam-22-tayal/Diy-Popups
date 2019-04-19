package com.ibm.diypopups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.diypopups.dao.EndUserService;
//import com.ibm.diypopups.model.Advertisement;
import com.ibm.diypopups.model.advertisements;
import com.ibm.diypopups.model.users;

@RestController
@RequestMapping("/advertisements/endUser")
@CrossOrigin(origins="*")
public class endUserController {
	
	@Autowired
	EndUserService Es;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}/profile")
	public users findEndUser(@PathVariable int id) {
		
		return Es.get(id);
		 //return new ResponseEntity<String>("Success", HttpStatus.OK);
		
		
		
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public List<advertisements> EndUserland(@PathVariable int id) {
		
		
		
		return Es.listVids();
		//return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@GetMapping("/{id}/{vid}")
	public int creditFlow(@PathVariable int id,@PathVariable int vid)
	{
		 Es.CreditCount(vid,id);
		 return findEndUser(id).getCredits();
		//return true;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<String> createEndUser(@RequestBody users V)
	{
		Es.add(V);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<users> getAll()
	{
		return Es.list();
	}	
	
	@CrossOrigin(origins="*")
	@GetMapping("/{id}/credits")
	public int getCredits(@PathVariable int id) {
		return findEndUser(id).getCredits();
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/userprofileid")
	public int getUserId(@RequestBody users V) {
		return V.getId();
		
	}

}
