package com.example.telecom.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.Users;

@Repository
public interface TelecomRepository extends JpaRepository<Users, Integer>{
	
	
	@Modifying
	//@Query("UPDATE User AS u set u.plan_id = ?1 where u.customer_id = ?2")
	@Query(value ="UPDATE user AS u set u.plan_id = ?1 where u.customer_id = ?2", nativeQuery = true)
	public Users setPlanIdFor(Integer plans_id,Integer user_id); 
	
//	
//	@Modifying
//	@Query("UPDATE user AS u set u= ?1 where u.customer_id = ?2")
//	public Users setDeviceId(Integer device_id,Integer user_id); 
	
}
