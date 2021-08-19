package com.example.telecom.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="device")
public class Device {
	
	@Id
	@Column(name="phone_number")
	String phoneNumber;
	
	
	@Column(name="model")
	String device_model;
	
	@ManyToOne(cascade=CascadeType.MERGE)
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

	public Device(String phoneNumber, String device_model) {
		super();
		this.phoneNumber = phoneNumber;
		this.device_model = device_model;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Device(String phoneNumber, String device_model,Plans plan) {
		super();
		this.phoneNumber = phoneNumber;
		this.device_model = device_model;
		this.plan = plan;
		
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDevice_model() {
		return device_model;
	}

	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}

	@Override
	public int hashCode() {
		return Objects.hash(device_model, phoneNumber);
	}

	public Plans getPlan() {
		return plan;
	}

	public void setPlan(Plans plan) {
		this.plan = plan;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
