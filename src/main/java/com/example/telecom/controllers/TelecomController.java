package com.example.telecom.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import javax.xml.ws.soap.Addressing;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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
import com.example.telecom.models.Plans;
import com.example.telecom.models.Users;
import com.example.telecom.security.CustomUserDetailService;
import com.example.telecom.services.DeviceService;
import com.example.telecom.services.PlansService;
import com.example.telecom.services.TelecomService;

@RestController

@RequestMapping("/telecom")
@CrossOrigin(origins = "http://localhost:4200")
public class TelecomController {

	@Autowired
	private TelecomService service;
	
	@Autowired
	private DeviceService deviceservice;
	
	@Autowired
	private PlansService plansservice;
	
	
	@Autowired
	
	private CustomUserDetailService customerservice;
	
	public TelecomController() {
		System.out.println("Controller Created");
	}
	
	@GetMapping("/home")
	public String home(CsrfToken token) {
		return "this is home page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "this is admin page";
	}

	// To be called when web-application starts
	@PostMapping("/createPlans")
	public ResponseEntity<Plans> createPlans() {
		System.out.println("Plans Created");
		Plans starter = new Plans(1, "STARTER", 35, 1);
		Plans extra = new Plans(2, "EXTRA", 40, 4);
		Plans elite = new Plans(3, "ELITE", 50, 4);

		return new ResponseEntity<Plans>(plansservice.addPlanOptions(starter, extra, elite), HttpStatus.CREATED);
	}
	
	@GetMapping("/getPlans")
	public ResponseEntity<List<Plans>> getPlans(){
		return new ResponseEntity<List<Plans>>(plansservice.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<Users> find() {
		System.out.println("GET called");
		return new ResponseEntity<Users>(service.findById(1), HttpStatus.OK);
	}
	
	// find all users
	
	
	@GetMapping("/devices")
	public ResponseEntity<List<Device>> findAllDevice(){
		return new ResponseEntity<List<Device>>(deviceservice.findAll(), HttpStatus.OK);
	}
	@GetMapping("/findByNumber={phoneNumber}")
	public ResponseEntity<Device> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
		System.out.println("GET called");
		return new ResponseEntity<Device>(deviceservice.findByPhoneNumber(phoneNumber), HttpStatus.OK);
	}
	
	@GetMapping("/DeviceCustomerId={customer_id}")
	public ResponseEntity<List<Device>> findByCustomerId(@PathVariable("customer_id") int customer_id) {
		System.out.println("GET called");
		return new ResponseEntity<List<Device>>(deviceservice.findByCustomerId(customer_id), HttpStatus.OK);
	}
	
	@GetMapping("/attribute={attribute}/id={id}")
	public ResponseEntity<List<Integer>> getPlanPropertyFromDevice(@PathVariable("attribute")
	String attribute, @PathVariable("id") Integer id) {
		System.out.println("Stringy");
		return new ResponseEntity<List<Integer>>(deviceservice.getPlanProperty(attribute, id), HttpStatus.OK);
	}
	
	
	@GetMapping("/total/attribute={attribute}/id={id}")
	public ResponseEntity<List<Integer>> getTotalPlanPropertyFromDevice(@PathVariable("attribute")
	String attribute, @PathVariable("id") Integer id) {
		System.out.println("Stringy");
		return new ResponseEntity<List<Integer>>(deviceservice.TotalPlanProperty(attribute, id), HttpStatus.OK);
	}
	
	@GetMapping("/total/c_id={c_id}")
	public ResponseEntity<List<Map<Integer, Integer>>> getDevicesPerPlan(@PathVariable("c_id") int c_id) {
		return new ResponseEntity<List<Map<Integer, Integer>>>(deviceservice.getDevicesPerPlan(c_id), HttpStatus.OK);
	}
	
	@GetMapping("/totalPrice/c_id={c_id}")
	public ResponseEntity<Integer> getEP(@PathVariable("c_id") int c_id) {
		return new ResponseEntity<Integer>(deviceservice.calculateEstimatedPrice(c_id), HttpStatus.OK);
	}
	
	@GetMapping("/devices/c_id={c_id}")
	public ResponseEntity<Integer> getTotalDevicesByCustomer(@PathVariable("c_id") int c_id) {
		return new ResponseEntity<Integer>(deviceservice.getTotalDevicesByCustomer(c_id), HttpStatus.OK);
	}
	
	@GetMapping("/authenticate/id={id}/password={password}")
	public ResponseEntity<Boolean> comparePasswords(@PathVariable("id") int id, 
			@PathVariable("password") String password) {
		return new ResponseEntity<Boolean>(service.comparePassword(id, password), HttpStatus.OK);
	}
	
	
	@RequestMapping("/login")
	public boolean compareHashPasswords(@RequestBody @Valid Users user) {
		return service.comparePassword2(user.getName(), user.getPassword());
	}
	
	
	@GetMapping("/login/name={username}")
		public void login(@PathVariable("username") String username) {
		customerservice.loadUserByUsername(username);
			
		}
		
		
	
	
	@Transactional
	@PutMapping(value = "/plans/c_id={custom_id}")
		public int updateTotalPlans(@PathVariable("custom_id") Integer custom_id){
		System.out.println("update called");
		return service.UpdateTotalPlans(custom_id, deviceservice.totalPlansUsed(custom_id));
	}
	
	@Transactional
	@PutMapping(value = "/price/c_id={custom_id}")
		public int updateEstimatedPrice(@PathVariable("custom_id") Integer custom_id){
		System.out.println("update called");
		return service.UpdateEstimatedPrice(custom_id, deviceservice.calculateEstimatedPrice(custom_id));
	}

	@PostMapping("/Adduser")
	public ResponseEntity<Users> save(@RequestBody @Valid Users user) {
		System.out.println("POST called");
		Users newUser = service.save(user);
		System.out.println(newUser);
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/AddDevice")
	public ResponseEntity<Device> save(@RequestBody @Valid Device device){
		System.out.println("Post for device called");
		Device newdevice=deviceservice.save(device);
		System.out.println(newdevice);
		return new ResponseEntity<>(deviceservice.save(device), HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/Deleteuser")
	public ResponseEntity<Users> delete() {
		System.out.println("DELETE called");
		return null;
	}
	
	@Transactional
	@PutMapping(value = "/old_phone_num={old_phone_num}/new_phone_num={new_phone_num}")
	public ResponseEntity<Integer>  updateDevicePhoneNumber(@PathVariable("old_phone_num") String old_phone_num, 
			@PathVariable("new_phone_num") String new_phone_num) {
		return new ResponseEntity<>(deviceservice.updatePhoneNumber(old_phone_num, new_phone_num), HttpStatus.OK);
	}
	
	@Transactional
	@PutMapping(value="plan_id={plan_id}/phone_number={phone_number}")
	public ResponseEntity<Integer> updateDevicePlanId(@PathVariable("plan_id") int plan_id, @PathVariable("phone_number") String phone_number) {
		return new ResponseEntity<>(deviceservice.UpdatePlanId(plan_id, phone_number), HttpStatus.OK);
		
	};
	
	@Transactional
	@PutMapping(value="customer_id={customer_id}/phone_number={phone_number}")
	public ResponseEntity<Integer> updateDeviceCustomerId(@PathVariable("customer_id") int customer_id, @PathVariable("phone_number") String phone_number) {
		return new ResponseEntity<>(deviceservice.UpdateCustomerId(customer_id, phone_number), HttpStatus.OK);
		
	};
	
	@Transactional
	@DeleteMapping("/delete-device={phoneNumber}") 
	public ResponseEntity<Integer> deleteDevice(@PathVariable("phoneNumber") String phoneNumber){
		System.out.println("DE)LETE called");
		return new ResponseEntity<>(deviceservice.deleteDevice(phoneNumber), HttpStatus.OK);
	}
}
