package com.evergreen.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UniversityManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementServiceApplication.class, args);
	}

}
