package com.example.telecom.security;

import java.util.Arrays;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
		
		http.cors()
		.configurationSource(corsConfigurationSource())
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/telecom/login")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	    configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
	    configuration.setAllowCredentials(true);
	    //the below three lines will add the relevant CORS response headers
	    configuration.addAllowedOrigin("http://localhost:4200");
	    configuration.addAllowedHeader("*");
	    configuration.addAllowedMethod("*");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	
	
}
