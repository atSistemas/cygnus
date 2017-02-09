package com.atsistemas.cygnus.services.deneb.service;

import java.util.concurrent.Future;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.model.PingRequest;
import com.atsistemas.cygnus.model.PingResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

//import rx.Observable;

@ConfigurationProperties(prefix="cygnus.sadr")
public class SadrClient {

	private static Logger logger = LoggerFactory.getLogger(SadrClient.class);
	
	private String pingUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public PingResponse pingSadr(PingRequest pingRequest){
		
		logger.debug("--> pingSadr - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
		logger.debug("--> sadr endpoint: {}",pingUrl);

		return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
	}
	
	@Async
	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public Future<PingResponse> pingSadrAsync(PingRequest pingRequest){
		
		logger.debug("--> pingSadrAsync - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
		logger.debug("--> sadr endpoint: {}",pingUrl);
		
		return new AsyncResult<PingResponse>(){

			@Override
			public PingResponse invoke() {
				return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
			}
		};
	}
	
	@Async
	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public Observable<PingResponse> pingSadrRx(PingRequest pingRequest){
		
		logger.debug("--> pingSadrAsync - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
		logger.debug("--> sadr endpoint: {}",pingUrl);
		
		return new ObservableResult<PingResponse>(){
			
			public PingResponse invoke() {
				return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
			    }
			
		};
			
	

	}
	
	public PingResponse retrieveFallbackPingSadr(PingRequest pingRequest){
		
		return new PingResponse("Error pinging sadr. This is a fallback message");
	}

	public void setPingUrl(String pingUrl) {
		this.pingUrl = pingUrl;
	}

}