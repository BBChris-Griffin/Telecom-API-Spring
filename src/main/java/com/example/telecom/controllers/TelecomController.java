package com.example.telecom.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Users;
import com.example.telecom.services.TelecomService;

@RestController
@RequestMapping("/telecom")
//@CrossOrigin(origins = "http://localhost:9001")
public class TelecomController {

	@Autowired
	private TelecomService service;
	
//	@Autowired
//	private TelecomRepository repos;
	
	public TelecomController() {
		System.out.println("Controller Created");
	}
	
	
	// find by id
	@GetMapping
	public ResponseEntity<Users> find() {
		System.out.println("GET called");
		return new ResponseEntity<Users>(service.findById(1), HttpStatus.OK);
	}
	
	// find all users
	@GetMapping("/users")
		public List<Users> findAll(){
		
		return service.findAll();
		
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
		public int update(@PathVariable("id") Integer id){
		System.out.println("update called");
		return service.UpdatePlan(id);

	}
	

//	@PutMapping()
//	public
}
