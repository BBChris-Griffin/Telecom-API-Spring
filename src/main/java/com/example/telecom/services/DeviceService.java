package com.example.telecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.DeviceRepository;
import com.example.telecom.models.Device;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public DeviceService() {
		
	}
	
	public Device save(Device device) {
		
		return deviceRepository.save(device);
	}
	
	public Device findByPhoneNumber(String number) {
		return deviceRepository.findByPhoneNumber(number);
	}
	

	public int deleteDevice(String phoneNumber) {
		deviceRepository.deleteByPhoneNumber(phoneNumber);
		return 1;
	}
	
	public int updatePhoneNumber(String oldNumber, String newNumber) {
		if(deviceRepository.findByPhoneNumber(newNumber) != null) {
			System.out.println("Number Found");
			String newnewNumber = "";
			int firstNum = (int)Math.floor(Math.random()*(999-100+1)+100);
			int secondNum = (int)Math.floor(Math.random()*(999-100+1)+100);
			int thirdNum = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
			newnewNumber = firstNum + "-" + secondNum + "-" + thirdNum;
			deviceRepository.setPhoneNumberFor(newnewNumber, newNumber);
		}
		deviceRepository.setPhoneNumberFor(newNumber, oldNumber);
		return 1;
	}
}
