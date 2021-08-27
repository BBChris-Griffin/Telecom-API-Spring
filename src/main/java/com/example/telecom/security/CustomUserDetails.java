package com.example.telecom.security;

import java.util.Collection;
import java.util.Collections;

import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.telecom.models.Users;

public class CustomUserDetails implements UserDetails {
	
	private Users user;
	
	
	
	

	public CustomUserDetails() {
		super();
	}
	
	
	

	public CustomUserDetails(Users user) {
		super();
		this.user = user;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password="1234";
		String hash=user.getPassword();
		
		if(encoder.matches(password, hash)) {
		System.out.println("is equal");
		System.out.println(user.getPassword());
		}else {
			System.out.println("not equal");
		}
		
		//System.out.println(user.getName());
	//	System.out.println(user.getRole());


	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public String getPassword() {
		
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
