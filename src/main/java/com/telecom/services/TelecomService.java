package com.telecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.data.TelecomRepository;

@Service
public class TelecomService {
	
	@Autowired
	private TelecomRepository respository;
}
