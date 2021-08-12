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
			// If generated number also matches an existing device, try and try again
			do {
				newnewNumber = "";
				int firstNum = (int)Math.floor(Math.random()*(999-100+1)+100);
				int secondNum = (int)Math.floor(Math.random()*(999-100+1)+100);
				int thirdNum = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
				newnewNumber = firstNum + "-" + secondNum + "-" + thirdNum;
			} while(deviceRepository.findByPhoneNumber(newnewNumber) != null);
			deviceRepository.setPhoneNumberFor(newnewNumber, newNumber);
		}
		deviceRepository.setPhoneNumberFor(newNumber, oldNumber);
		return 1;
	}
	
	public int UpdatePlanId(int plan_id,String phone_number) {
		
		if(deviceRepository.findByPhoneNumber(phone_number) != null) {
			deviceRepository.setPlanId(plan_id, phone_number);
		}else {
			System.out.println("Number not in database");
		}
		return 1;
		
		
	}
	
	public int UpdateCustomerId(int customer_id,String phone_number) {
		
		if(deviceRepository.findByPhoneNumber(phone_number) != null) {
			deviceRepository.setCustomerId(customer_id, phone_number);
		}else {
			System.out.println("Number not in database");
		}
		return 1;
		
		
	}
}
