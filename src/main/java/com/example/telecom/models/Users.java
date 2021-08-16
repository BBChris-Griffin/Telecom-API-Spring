package com.example.telecom.models;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 

@Table(name="User")
public class Users {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
	@Column
	private int estimated_price;
	
	@Column
	private int total_plans;
	
	
	
	
	public Users() {
		super();
	}

	@OneToMany (mappedBy="user")
	private Set<UsersPlan> usersplans = new HashSet<>();
	
	
	@JsonBackReference
	@OneToMany (mappedBy="user")
	private Set<Device> device = new HashSet<>();

	public Users(int customerId, String name, String email, String password, int estimated_price, int total_plans) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.estimated_price = estimated_price;
		this.total_plans = total_plans;
	}
	
	
	public Users(int customerId) {
		super();
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstimated_price() {
		return estimated_price;
	}

	public void setEstimated_price(int estimated_price) {
		this.estimated_price = estimated_price;
	}

	public Set<Device> getDevice() {
		return device;
	}

	public void setDevice(Set<Device> device) {
		this.device = device;
	}
	
	

	public int getTotal_plans() {
		return total_plans;
	}


	public void setTotal_plans(int total_plans) {
		this.total_plans = total_plans;
	}


	@Override
	public String toString() {
		return "Users [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", estimated_price=" + estimated_price + ", total_plans=" + total_plans + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, device, email, estimated_price, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return customerId == other.customerId && Objects.equals(device, other.device)
				&& Objects.equals(email, other.email) && estimated_price == other.estimated_price
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	public Users(String name, String email, String password, int estimated_price, int total_plans) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.estimated_price = estimated_price;
		this.total_plans = total_plans;
	}
	
	
	

}
