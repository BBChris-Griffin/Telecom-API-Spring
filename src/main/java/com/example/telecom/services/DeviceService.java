package com.example.telecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceReposiotry;
	

}
