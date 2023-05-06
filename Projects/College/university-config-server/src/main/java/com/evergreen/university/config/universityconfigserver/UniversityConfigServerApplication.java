package com.evergreen.university.config.universityconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class UniversityConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityConfigServerApplication.class, args);
	}

}
