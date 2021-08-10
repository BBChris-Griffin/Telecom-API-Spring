package com.telecom.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int device_id;
	
	@Column
	int device_model;
	
	@Column
	int phoneNumber;
	
	@ManyToOne
	private Plans PlansId;

	public Device(int device_id, int device_model, int phoneNumber, Plans plansId) {
		super();
		this.device_id = device_id;
		this.device_model = device_model;
		this.phoneNumber = phoneNumber;
		PlansId = plansId;
	}

	public Device() {
		super();
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getDevice_model() {
		return device_model;
	}

	public void setDevice_model(int device_model) {
		this.device_model = device_model;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

}