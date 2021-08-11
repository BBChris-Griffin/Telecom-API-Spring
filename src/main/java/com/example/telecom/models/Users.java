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
	
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name="plan_id")
	private Plans plan;
	
	@OneToMany (mappedBy="user")
	private Set<Device> device = new HashSet<>();
	
	
	public Users() {
		super();
	}


	public Users(int customerId) {
		super();
		this.customerId = customerId;
	}


	public Plans getPlan() {
		return plan;
	}


	public void setPlan(Plans plan) {
		this.plan = plan;
	}


	public Users(int customerId, String name, String email, String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Users(String name, String email, String password, Plans plan) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		//this.setPlan(planId);
		this.plan = plan;
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
	
//	public void setPlanId(int planId) {
//		this.plan = new Plans(planId);
//	}
//
//	public Plans getPlanId() {
//		return plan;
//	}


	@Override
	public String toString() {
		return "Users [customerId=" + customerId + ", customerName=" + name + ", email=" + email + ", password="
				+ password + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(customerId, email, name, password);
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
		return customerId == other.customerId && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
	
	
	
	
	
	
	
	
	

}
