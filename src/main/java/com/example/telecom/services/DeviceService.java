package com.example.telecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.DeviceRepository;
import com.example.telecom.models.Device;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceReposiotry;
	
	public DeviceService() {
		
	}
	
	public Device save(Device device) {
		
		return deviceReposiotry.save(device);
	}
	

}
