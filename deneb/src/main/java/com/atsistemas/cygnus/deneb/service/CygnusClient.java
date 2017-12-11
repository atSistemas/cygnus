package com.atsistemas.cygnus.deneb.service;

import java.util.concurrent.Future;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atsistemas.cygnus.deneb.generated.model.PingResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class CygnusClient {

	private static Logger logger = LoggerFactory.getLogger(CygnusClient.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public PingResponse pingService(String serviceName){
		
		logger.debug("--> pingService - serviceName: {}",serviceName);

		return restTemplate.getForObject("http://" + serviceName + ":8080/ping", PingResponse.class);
		
	}
	
	@Async
	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	public Future<PingResponse> pingServiceAsync(String serviceName){
		
		logger.debug("--> pingService - serviceName: {}",serviceName);
		
		return new AsyncResult<PingResponse>(){

			@Override
			public PingResponse invoke() {
				return restTemplate.getForObject("http://" + serviceName + "/ping", PingResponse.class);
			}
		};
	}
	
//	@Async
//	@HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
//	public Observable<PingResponse> pingSadrRx(PingRequest pingRequest){
//		
//		logger.debug("--> pingSadrAsync - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
//		logger.debug("--> sadr endpoint: {}",pingUrl);
//		
//		
//		return new ObservableResult<PingResponse>(){
//			
//			public PingResponse invoke() {
//				return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
//			    }
//			
//		};
//
//	}
	
	public PingResponse retrieveFallbackPingSadr(String serviceName){
		
		PingResponse pingResponse = new PingResponse();
		pingResponse.setId("error");
		pingResponse.setResponseMessage("Error pinging " + serviceName + ". This is a fallback message");
		return pingResponse;
	}


}