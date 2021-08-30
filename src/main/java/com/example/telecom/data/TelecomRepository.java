package com.example.telecom.data;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.Users;

@Repository
public interface TelecomRepository extends JpaRepository<Users, Integer>{
	
	Users findByname(String name);
	
	@Modifying
	@Query(value = "UPDATE user AS u set u.total_plans = ?1 where u.customer_id = ?2", nativeQuery = true)
	public int setTotalPlansFor(Integer total_plans, Integer customer_id);
	
	@Modifying
	@Query(value = "UPDATE user AS u set u.estimated_price = ?1 where u.customer_id = ?2", nativeQuery = true)
	public int setEstimatedPriceFor(Integer estimated_price, Integer customer_id);
	
	@Query(value ="select password from user where customer_id = ?1", nativeQuery = true)
	public String getPassword(Integer customer_id);
	
	@Query(value ="select password from user where name = ?1", nativeQuery = true)
	public String getPassword(String customer_id);
	
	@Query(value = "select customer_id from user where name = ?1", nativeQuery = true)
	public Integer getCustomerID(String name);
}