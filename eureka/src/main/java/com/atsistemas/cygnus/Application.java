package com.atsistemas.cygnus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 */
	public static void main(String[] args) {

		System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		SpringApplication.run(Application.class, args);
	}
}
