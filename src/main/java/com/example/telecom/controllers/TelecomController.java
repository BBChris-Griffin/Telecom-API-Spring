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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Device;
import com.example.telecom.models.Users;
import com.example.telecom.services.DeviceService;
import com.example.telecom.services.PlansService;
import com.example.telecom.services.TelecomService;
import com.example.telecom.services.UsersPlanService;

@RestController

@RequestMapping("/telecom")

//@RequestMapping("/telecom-api-spring/user")

//@CrossOrigin(origins = "http://localhost:9001")
public class TelecomController {

	@Autowired
	private TelecomService service;
	
	@Autowired
	private UsersPlanService userplanservice;
	
	@Autowired
	private DeviceService deviceservice;
	
	@Autowired
	private PlansService plansservice;
	
	public TelecomController() {
		System.out.println("Controller Created");
	}
		

	@GetMapping("/user")
	public ResponseEntity<Users> find() {
		System.out.println("GET called");
		return new ResponseEntity<Users>(service.findById(1), HttpStatus.OK);
	}
	
	// find all users
	@GetMapping("/users")
	public ResponseEntity<List<Users>> findAll(){
		return new ResponseEntity<List<Users>>(service.findAll(), HttpStatus.OK);
	}
	
//	@Transactional
//	@PutMapping(value = "/{user_id}/{plan_id}")
//		public int update(@PathVariable("user_id") Integer user_id, 
//				@PathVariable("plan_id") Integer plan_id){
//		System.out.println("update called");
//		return service.UpdatePlan(user_id, plan_id);
//
//	}
	
	
	@Transactional
	@PutMapping(value = "/id={custom_id}/plans={plans}")
		public int updateTotalPlans(@PathVariable("custom_id") Integer custom_id, 
				@PathVariable("plans") Integer plans){
		System.out.println("update called");
		return service.UpdateTotalPlans(custom_id, plans);

	}
	
	@Transactional
	@PutMapping(value = "/id={custom_id}/e_price={e_price}")
		public int updateEstimatedPrice(@PathVariable("custom_id") Integer custom_id, 
				@PathVariable("e_price") Integer e_price){
		System.out.println("update called");
		return service.UpdateEstimatedPrice(custom_id, e_price);
	}

	@PostMapping("/Adduser")
	public ResponseEntity<Users> save(@RequestBody @Valid Users user) {
		System.out.println("POST called");
		Users newUser = service.save(user);
		System.out.println(newUser);
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Deleteuser")
	public ResponseEntity<Users> delete() {
		System.out.println("DELETE called");
		return null;
	}
	
	@Transactional
	@DeleteMapping("/delete-device={phoneNumber}") 
	public ResponseEntity<Integer> deleteDevice(@PathVariable("phoneNumber") String phoneNumber){
		System.out.println("DELETE called");
		return new ResponseEntity<>(deviceservice.deleteDevice(phoneNumber), HttpStatus.OK);
	}
}
