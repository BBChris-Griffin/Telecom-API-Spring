package com.example.telecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.telecom.data.TelecomRepository;
import com.example.telecom.models.Users;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private TelecomRepository telecomRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Users user= telecomRepository.findByname(name);
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		user.getPassword();
		return new CustomUserDetails(user) ;
	}

}
