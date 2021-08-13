package com.example.telecom.data;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.Device;
import com.example.telecom.models.Plans;


@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {

	@Modifying
	@Query(value="DELETE FROM DEVICE WHERE PHONE_NUMBER = ?1", nativeQuery = true)
	void deleteByPhoneNumber(String phoneNumber);

	@Modifying
	@Query(value = "UPDATE DEVICE SET PHONE_NUMBER = ?1 where PHONE_NUMBER = ?2", nativeQuery = true)
	void setPhoneNumberFor(String new_phone_number, String old_phone_number);

	@Query(value = "SELECT * FROM DEVICE WHERE PHONE_NUMBER = ?1", nativeQuery = true)
	Device findByPhoneNumber(String newNumber);
	
	
	@Modifying
	@Query(value="update device as u set u.plan_id=?1 where u.phone_number=?2", nativeQuery=true)
	void setPlanId(int plan_id,String phone_number);
	
	
	@Modifying
	@Query(value="update device as u set customer_id=?1 where u.phone_number=?2", nativeQuery=true)
	void setCustomerId(int customer_id, String phone_number);

	@Query(value = "select price from plan inner join device on plan.plan_id = device.plan_id where "
			+ "device.customer_id = ?1", nativeQuery = true)
	List<Integer> getPlanPrices(int c_id);
	
	@Query(value = "select num_of_lines from plan inner join device on plan.plan_id = device.plan_id where "
			+ "device.customer_id = ?1", nativeQuery = true)
	List<Integer> getPlanLines(int c_id);
	
}
