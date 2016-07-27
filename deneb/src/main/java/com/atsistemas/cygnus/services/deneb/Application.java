package com.atsistemas.cygnus.services.deneb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {

		System.setProperty("spring.cloud.bootstrap.name", "deneb-service/bootstrap");
		System.setProperty("spring.config.name", "deneb-service/default-config");
		SpringApplication.run(Application.class, args);
	}
	
}
