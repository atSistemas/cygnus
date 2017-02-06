package com.atsistemas.cygnus.services.sadr.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.services.sadr.service.DenebClient;

@Configuration
class SadrConfig {

	@Bean
	@RefreshScope
	DenebClient denebClient(){
		return new DenebClient();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
