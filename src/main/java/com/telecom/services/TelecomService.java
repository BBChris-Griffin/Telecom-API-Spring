package com.telecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.data.TelecomRepository;
import com.telecom.models.Users;

@Service
public class TelecomService {
	
	@Autowired
	private TelecomRepository repository;
	
	public Users save(Users user) {
		return repository.save(user);
	}
	
	
	public Users findById(Integer id) {
		
		Optional<Users> optional= repository.findById(id);
		return optional.isPresent()? optional.get():null;
		
	}
	
	
	
	

	
	
}
