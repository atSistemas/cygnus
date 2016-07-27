package com.atsistemas.cygnus.services.deneb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.model.PingRequest;
import com.atsistemas.cygnus.model.PingResponse;

@Service
public class SadrClient {

	private static Logger logger = LoggerFactory.getLogger(SadrClient.class);
	
	public static final String SADR_URL = "http://SADR-SERVICE/sadr/ping";
	
	@Autowired
	private RestTemplate restTemplate;

	public PingResponse pingSadr(PingRequest pingRequest){
		
		logger.debug("--> pinging Sadr...");
		logger.debug("--> Id: {}",pingRequest.getId());
		logger.debug("--> Message: {}",pingRequest.getMessage());
		
		return restTemplate.postForObject(SADR_URL, pingRequest, PingResponse.class);
	}
	
}
