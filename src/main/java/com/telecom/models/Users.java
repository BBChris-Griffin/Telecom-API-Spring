package com.telecom.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 

@Table(name="User")
public class Users {
	
	
	
	@ManyToOne
	private Plans plansId;
	
	@OneToMany
	private Device device;
	
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
	
	
	public Users() {
		super();
	}



	public Users(int customerId) {
		super();
		this.customerId = customerId;
	}




	public Users(int customerId, String customerName, String email, String password) {
		super();
		this.customerId = customerId;
		this.name = customerName;
		this.email = email;
		this.password = password;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return name;
	}


	public void setCustomerName(String customerName) {
		this.name = customerName;
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




	@Override
	public String toString() {
		return "Users [customerId=" + customerId + ", customerName=" + name + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
