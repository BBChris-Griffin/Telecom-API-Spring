package com.example.telecom.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Plan")
public class Plans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="plan_id")
	private int planId;
	
	@Column (name="plan_type")
	private String planType;

	@Column
	private String price;
	
//	@OneToMany(mappedBy="plan", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	private Set<Users> users;
	

	public Plans(int planId, String planType, String price /*, Set<Users> users*/) {
		super();
		this.planId = planId;
		this.planType = planType;
		this.price = price;
		//this.users = users;
	}
	
	public Plans(int planId) {
		super();
		this.planId = planId;
	}

	public Plans() {
		super();
	}

	@Override
	public String toString() {
		return "Plans [plans_id=" + planId + ", plansType=" + planType + ", price=" + price + "]";
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(planType, planId, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plans other = (Plans) obj;
		return Objects.equals(planType, other.planType) && planId == other.planId && price == other.price;
	}

//	public Set<Users> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<Users> users) {
//		this.users = users;
//	}
	
}
