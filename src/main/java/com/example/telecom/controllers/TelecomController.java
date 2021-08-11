package com.example.telecom.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Users;
import com.example.telecom.services.TelecomService;

@RestController
//@RequestMapping("/telecom-api-spring/user")
//@CrossOrigin(origins = "http://localhost:9001")
public class TelecomController {

	@Autowired
	private TelecomService service;
	
	public TelecomController() {
		System.out.println("Controller Created");
	}
	
	@GetMapping("/telecom-api-spring/user")
	public ResponseEntity<Users> find() {
		System.out.println("GET called");
		return new ResponseEntity<Users>(service.findById(1), HttpStatus.OK);
	}

	@PostMapping("/telecom-api-spring/user")
	public ResponseEntity<Users> save(@RequestBody @Valid Users user) {
		System.out.println("POST called");
		Users newUser = service.save(user);
		System.out.println(newUser);
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/telecom-api-spring/user")
	public ResponseEntity<Users> delete() {
		System.out.println("DELETE called");
		return null;
	}
}
