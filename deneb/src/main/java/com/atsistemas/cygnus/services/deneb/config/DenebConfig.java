package com.atsistemas.cygnus.services.deneb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.services.deneb.service.SadrClient;

@Configuration
class DenebConfig {

	@Bean
	@RefreshScope
	SadrClient sadrClient(){
		return new SadrClient();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
