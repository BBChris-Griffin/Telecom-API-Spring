package com.telecom.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telecom.models.Users;

@Repository
public interface TelecomRepository extends JpaRepository<Users, Integer>{
	
	
	@Modifying
	@Query("UPDATE user set plan_id = ?1 where customer_id = ?2")
	public Users setPlansId(int plans_id,int user_id); 
	
	
	@Modifying
	@Query("UPDATE user set device_id = ?1 where customer_id = ?2")
	public Users setDeviceId(int device_id,int user_id); 
		
		
		
		
	

	 

	
}
