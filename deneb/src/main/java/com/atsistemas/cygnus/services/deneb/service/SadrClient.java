package com.atsistemas.cygnus.services.deneb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.model.PingRequest;
import com.atsistemas.cygnus.model.PingResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SadrClient {

	private static Logger logger = LoggerFactory.getLogger(SadrClient.class);
	
	public static final String SADR_URL = "http://sadr-service/sadr/ping";
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public PingResponse pingSadr(PingRequest pingRequest){
		
		logger.debug("--> ping received - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());

		return restTemplate.postForObject(SADR_URL, pingRequest, PingResponse.class);
	}
	
	public PingResponse retrieveFallbackPingSadr(PingRequest pingRequest){
		
		return new PingResponse("Error pinging sadr. This is a fallback message");
	}
	
}
