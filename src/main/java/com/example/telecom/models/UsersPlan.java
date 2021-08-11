package com.example.telecom.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UsersPlan {
	
	@Column 
	@Id
	private int up_id;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Users user;
	
	
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Plans plan;


	public UsersPlan(int up_id) {
		super();
		this.up_id = up_id;
	}


	public UsersPlan() {
		super();
	}


	public Plans getPlan() {
		return plan;
	}


	public void setPlan(Plans plan) {
		this.plan = plan;
	}


	@Override
	public int hashCode() {
		return Objects.hash(plan);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersPlan other = (UsersPlan) obj;
		return Objects.equals(plan, other.plan);
	}


	@Override
	public String toString() {
		return "UsersPlan [up_id=" + up_id + "]";
	}
	
	
	
	
	

}
