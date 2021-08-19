package com.example.telecom.data;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Query(value = "select *from device where customer_id=?1", nativeQuery = true)
	 List<Device> findByCustomerID(int customer_id);
	
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
	
	@Query(value = "select sum(price) as total_bill from plan inner join device on plan.plan_id = device.plan_id where "
			+ "device.customer_id = ?1", nativeQuery = true)
	List<Integer>TotalBill(int c_id);
	
	@Query(value = "select sum(num_of_lines) as total_lines from plan inner join device on plan.plan_id = device.plan_id where "
			+ "device.customer_id = ?1", nativeQuery = true)
	List<Integer> TotalLines(int c_id);
	
	@Query(value = "select plan_id, count(phone_number)\r\n"
			+ "from device\r\n"
			+ "inner join user\r\n"
			+ "on device.customer_id = user.customer_id\r\n"
			+ "where device.customer_id = ?1  AND plan_id IS NOT NULL\r\n"
			+ "group by device.plan_id;", nativeQuery = true)
	List<Map<Integer, Integer>> getDevicesPerPlan(int c_id);
	
	@Query(value = "select count(phone_number) from device where customer_id = ?1", nativeQuery = true)
	Integer getTotalDevicesByCustomer(int c_id);
}
