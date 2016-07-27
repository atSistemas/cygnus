package com.atsistemas.cygnus.services.sadr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		System.setProperty("spring.cloud.bootstrap.name", "sadr-service/bootstrap");
		System.setProperty("spring.config.name", "sadr-service/default-config");
		SpringApplication.run(Application.class, args);
	}
	
}
