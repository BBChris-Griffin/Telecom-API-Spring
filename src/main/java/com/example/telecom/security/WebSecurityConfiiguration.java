package com.example.telecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiiguration extends WebSecurityConfigurerAdapter {

	// Autheication provider that uses dao provider 
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=
				new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		System.out.print(provider);

		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		System.out.print(provider);
		
		return provider;
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/home")
		.hasAuthority("USER")
		.antMatchers("/admin")
		.hasAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
//		http.authorizeRequests()
//		.antMatchers("/")
//		.permitAll()
//		.antMatchers("telecom/home")
//		.hasAuthority("USER")
//		.antMatchers("telecom/admin")
//		.hasAuthority("ADMIN")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
	}
	
	
}
