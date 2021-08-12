package com.example.telecom.data;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {

	@Modifying
	@Query(value="DELETE FROM DEVICE WHERE PHONE_NUMBER = ?1", nativeQuery = true)
	void deleteByPhoneNumber(String phoneNumber);

	
	
}
