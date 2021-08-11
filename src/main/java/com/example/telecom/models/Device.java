package com.example.telecom.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="plan_id")
	private Plans PlansId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Users user;

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

	@Override
	public int hashCode() {
		return Objects.hash(device_id, device_model, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		return device_id == other.device_id && device_model == other.device_model && phoneNumber == other.phoneNumber;
	}
	
	
	

}
