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
	String phoneNumber;
	
	
	@Column
	int device_model;
	
	
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Plans plan;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Users user;
	
	
	public Device() {
		super();
	}
	
	
	

	public Device(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}




	public Device(String phoneNumber, int device_model) {
		super();
		this.phoneNumber = phoneNumber;
		this.device_model = device_model;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public int getDevice_model() {
		return device_model;
	}




	public void setDevice_model(int device_model) {
		this.device_model = device_model;
	}




	@Override
	public int hashCode() {
		return Objects.hash(device_model, phoneNumber);
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
		return device_model == other.device_model && Objects.equals(phoneNumber, other.phoneNumber);
	}




	@Override
	public String toString() {
		return "Device [phoneNumber=" + phoneNumber + ", device_model=" + device_model + "]";
	}

		

	
	
	

}
