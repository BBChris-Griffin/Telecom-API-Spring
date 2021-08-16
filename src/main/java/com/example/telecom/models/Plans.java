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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Plan")
public class Plans {
	
	@Id
	@Column (name="plan_id")
	private int planId;
	
	@Column (name="plan_type")
	private String planType;

	@Column
	private int price;
	
	@Column
	private int num_of_lines;
		
	
	@OneToMany (fetch= FetchType.LAZY,mappedBy="plan", cascade=CascadeType.MERGE)
	private Set<UsersPlan> usersplans = new HashSet<>();
	
	@JsonBackReference
	@OneToMany (fetch= FetchType.LAZY,mappedBy="plan", cascade=CascadeType.MERGE)
	private Set<Device> device = new HashSet<>();

	
	
	public Plans() {
		super();
	}

	


	public Plans(String planType, int price, int num_of_lines) {
		super();
		this.planType = planType;
		this.price = price;
		this.num_of_lines = num_of_lines;
	}




	public Plans(int planId, String planType, int price, int num_of_lines) {
		super();
		this.planId = planId;
		this.planType = planType;
		this.price = price;
		this.num_of_lines = num_of_lines;
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




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getNum_of_lines() {
		return num_of_lines;
	}




	public void setNum_of_lines(int num_of_lines) {
		this.num_of_lines = num_of_lines;
	}




	@Override
	public int hashCode() {
		return Objects.hash(num_of_lines, planId, planType, price);
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
		return num_of_lines == other.num_of_lines && planId == other.planId && Objects.equals(planType, other.planType)
				&& Objects.equals(price, other.price);
	}




	@Override
	public String toString() {
		return "Plans [planId=" + planId + ", planType=" + planType + ", price=" + price + ", num_of_lines="
				+ num_of_lines + "]";
	}
	
	
	


	
}
