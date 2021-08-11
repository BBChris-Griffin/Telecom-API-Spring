package com.example.telecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TelecomApiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomApiSpringApplication.class, args);
	}

}
