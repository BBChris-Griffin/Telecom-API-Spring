package com.example.telecom.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.telecom.models.UsersPlan;

@Repository
public interface UsersPlanRepository extends JpaRepository<UsersPlan, Integer> {

}
