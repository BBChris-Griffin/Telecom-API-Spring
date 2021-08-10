package com.telecom.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int plans_id;
	
	@Column
	private String plansType;

	@Column
	private int price;

	public Plans(int plans_id, String plansType, int price) {
		super();
		this.plans_id = plans_id;
		this.plansType = plansType;
		this.price = price;
	}

	public Plans() {
		super();
	}

	@Override
	public String toString() {
		return "Plans [plans_id=" + plans_id + ", plansType=" + plansType + ", price=" + price + "]";
	}

	public int getPlans_id() {
		return plans_id;
	}

	public void setPlans_id(int plans_id) {
		this.plans_id = plans_id;
	}

	public String getPlansType() {
		return plansType;
	}

	public void setPlansType(String plansType) {
		this.plansType = plansType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(plansType, plans_id, price);
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
		return Objects.equals(plansType, other.plansType) && plans_id == other.plans_id && price == other.price;
	}
	
	
	
	
}
