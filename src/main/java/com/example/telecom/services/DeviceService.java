package com.example.telecom.services;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.DeviceRepository;
import com.example.telecom.models.Device;
import com.example.telecom.models.Plans;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public DeviceService() {
		
	}
	
	public Device save(Device device) {
		
		return deviceRepository.save(device);
	}
	
	public List<Device> findAll(){
		return deviceRepository.findAll();
	}
	
	public Device findByPhoneNumber(String number) {
		return deviceRepository.findByPhoneNumber(number);
	}
	
	public List<Device> findByCustomerId(int customer_id) {
		return deviceRepository.findByCustomerID(customer_id);

		
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
	
	public List<Integer> getPlanProperty(String attribute, int c_id) {
		List<Integer> results = new LinkedList<>();
		if(attribute.equals("price")) {
			results = deviceRepository.getPlanPrices(c_id);
		} else if(attribute.equals("num_of_lines")) {
			results = deviceRepository.getPlanLines(c_id);
		}
		return results;
	}
	
	
	public List<Integer> TotalPlanProperty(String attribute, int c_id) {
		List<Integer> results = new LinkedList<>();
		if(attribute.equals("price")) {
			results = deviceRepository.TotalBill(c_id);
		} else if(attribute.equals("num_of_lines")) {
			results = deviceRepository.TotalLines(c_id);
		}
		return results;
	}
	
	public List<Map<Integer, Integer>> getDevicesPerPlan(int c_id) {
		return deviceRepository.getDevicesPerPlan(c_id);
	}
	
	public int calculateEstimatedPrice(int c_id) {
		List<Map<Integer, Integer>> priceMap = deviceRepository.getDevicesPerPlan(c_id);
		int estimatedPrice = 0;
		for(int i = 0; i < priceMap.size(); i++) {
			if(priceMap.get(i).get("plan_id") == 1) {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				estimatedPrice += temp.intValue() * 35;

			} else if(priceMap.get(i).get("plan_id") == 2) {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				estimatedPrice += Math.ceil(temp.doubleValue() / 4) * 40;
			} else {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				estimatedPrice += Math.ceil(temp.doubleValue() / 4) * 50;			
			}
		}
		return estimatedPrice;
	}
	
	public int totalPlansUsed(int c_id) {
		int plans = 0;
		List<Map<Integer, Integer>> priceMap = deviceRepository.getDevicesPerPlan(c_id);
		for(int i = 0; i < priceMap.size(); i++) {
			if(priceMap.get(i).get("plan_id") == 1) {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				plans += temp.intValue();

			} else if(priceMap.get(i).get("plan_id") == 2) {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				plans += Math.ceil(temp.doubleValue() / 4);
			} else {
				Number temp = (Number)priceMap.get(i).get("count(phone_number)");
				plans += Math.ceil(temp.doubleValue() / 4);			
			}
		}
		return plans;
	}
	
	public int getTotalDevicesByCustomer(int c_id) {
		return deviceRepository.getTotalDevicesByCustomer(c_id);
	}
}
