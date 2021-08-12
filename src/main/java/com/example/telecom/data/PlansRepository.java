package com.example.telecom.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Integer> {

}
