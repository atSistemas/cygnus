package com.atsistemas.cygnus.sadr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.model.PingRequest;
import com.atsistemas.cygnus.model.PingResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@ConfigurationProperties(prefix="cygnus.deneb")
public class DenebClient {

	private static Logger logger = LoggerFactory.getLogger(DenebClient.class);
	
	private String pingUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="retrieveFallbackPingDeneb")
	public PingResponse pingDeneb(PingRequest pingRequest){
		
		logger.debug("--> pingDeneb received - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
		logger.debug("--> deneb endpoint: {}",pingUrl);
		return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
	}
	
	public PingResponse retrieveFallbackPingDeneb(PingRequest pingRequest){
		return new PingResponse("Error pinging deneb. This is a fallback message");
	}

	public void setPingUrl(String pingUrl) {
		this.pingUrl = pingUrl;
	}
}