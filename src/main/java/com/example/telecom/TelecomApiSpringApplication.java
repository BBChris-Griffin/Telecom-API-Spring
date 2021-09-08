package com.example.telecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication() //exclude = SecurityAutoConfiguration.class
public class TelecomApiSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelecomApiSpringApplication.class, args);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String password= "pokerking";
//		String hash="pokerking";
//		hash=encoder.encode(hash);
//		System.out.println(hash);
//		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
//
//		
//		if(encoder2.matches(password, hash)) {
//			System.out.println("Password match");
//		}else {
//			System.out.println("not match");
//
//		}
		
		
		
		
		//System.out.println("hello "+encoder.encode("1234"));
	}

}
