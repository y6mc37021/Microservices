package com.evergreen.university.universitynamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class UniversityNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityNamingServerApplication.class, args);
	}

}
