package com.atsistemas.cygnus.deneb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.deneb.service.CygnusClient;

@Configuration
class DenebConfig {

	@Bean
	@RefreshScope
	CygnusClient cygnusClient(){
		return new CygnusClient();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
