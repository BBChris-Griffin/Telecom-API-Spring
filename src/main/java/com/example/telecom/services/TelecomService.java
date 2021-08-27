package com.example.telecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
	public int UpdateTotalPlans(Integer custom_id, Integer plans) {
		if(custom_id > 0) {
			return repository.setTotalPlansFor(plans, custom_id);
		}
		System.out.println("Not a valid id");
		return -1;
	}
	
	public int UpdateEstimatedPrice(Integer custom_id, Integer e_price) {
		if(custom_id > 0) {
			return repository.setEstimatedPriceFor(e_price, custom_id);
		}
		System.out.println("Not a valid id");
		return -1;
	}
	
	public boolean comparePassword(Integer custom_id, String basePassword) {
		String correctPassword = repository.getPassword(custom_id);
		return basePassword.equals(correctPassword);
	}
	
	public boolean comparePassword2(String custom_id, String password) {
		String hash = repository.getPassword(custom_id);
		
		if(custom_id==null) {
			return false;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(encoder.matches(password,hash)) {
			System.out.println("is equal");
			return true;
			}else {
				System.out.println("not equal");
				return false;
			}

		
		
		
		
		
		
		
	}
	
	
	
}
