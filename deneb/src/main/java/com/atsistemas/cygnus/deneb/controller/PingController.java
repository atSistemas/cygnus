package com.atsistemas.cygnus.deneb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.atsistemas.cygnus.deneb.generated.api.PingApi;
import com.atsistemas.cygnus.deneb.generated.model.PingResponse;
import com.atsistemas.cygnus.deneb.service.CygnusClient;

@Controller
public class PingController implements PingApi{

	private static Logger logger = LoggerFactory.getLogger(PingController.class);
	
	@Autowired
	private CygnusClient cygnusClient;

	@Override
	public ResponseEntity<PingResponse> pingGet(String forwardService) {
		
		logger.debug("--> pingGet");
		
		if(forwardService == null){
			PingResponse pingResponse = new PingResponse();
			//TODO generate uuid
			pingResponse.setId("0");
			pingResponse.setResponseMessage("hello from Deneb");
			return new ResponseEntity<PingResponse>(pingResponse, HttpStatus.OK);
		}
		
		logger.debug("--> forwarding ping to: {}",forwardService);
		
		return new ResponseEntity<PingResponse>(cygnusClient.pingService(forwardService), HttpStatus.OK);
	}

}