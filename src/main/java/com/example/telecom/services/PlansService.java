package com.example.telecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.data.PlansRepository;
import com.example.telecom.models.Plans;

@Service
public class PlansService {
	
	@Autowired
	private PlansRepository plansRepository;
	
	public Plans addPlanOptions(Plans starter, Plans extra, Plans elite) {
		plansRepository.save(starter);
		plansRepository.save(extra);
		return plansRepository.save(elite);
	}
	
	public List<Plans> findAll() {
		return plansRepository.findAll();
	}

}
