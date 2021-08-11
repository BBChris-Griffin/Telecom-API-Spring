package com.example.telecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Users;

import org.springframework.transaction.annotation.Transactional;


@Service
public class TelecomService {
	
	@Autowired
	private TelecomRepository repository;
	
	public TelecomService() {
		
	}
	
	public Users save(Users user) {
		return repository.save(user);
	}
	
	
	public Users findById(Integer id) {
		Optional<Users> optional= repository.findById(id);
		return optional.isPresent()? optional.get():null;
		
	}
	
	
	public List <Users> findAll() {
		return repository.findAll();
	}
	
	
	public int  UpdatePlan(Integer id) {

		if(id !=null) {
			
			return repository.setPlanIdFor(id,2);						
			
		}else {
			System.out.println("please enter a value");
			
		}
		return id;
		
	}
	
	

	
	
}
