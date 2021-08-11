package com.example.telecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Users;
import com.example.telecom.services.TelecomService;

@RestController
@RequestMapping("/telecom-api-spring/user")
//@CrossOrigin(origins = "http://localhost:9001")
public class TelecomController {

	@Autowired
	private TelecomService service;
	
//	@Autowired
//	private TelecomRepository repos;
	
	public TelecomController() {
		System.out.println("Controller Created");
	}
	
	@GetMapping
	public ResponseEntity<Users> find() {
		System.out.println("GET called");
		return new ResponseEntity<Users>(service.findById(1), HttpStatus.OK);
	}

//	@PutMapping()
//	public
}
