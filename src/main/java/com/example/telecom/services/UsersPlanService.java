package com.example.telecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.UsersPlanRepository;

@Service
public class UsersPlanService {

	
	@Autowired
	private UsersPlanRepository userplanrepo;
}
