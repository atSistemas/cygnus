package com.atsistemas.cygnus.sadr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.atsistemas.sadr.generated.api.PingApi;
import com.atsistemas.sadr.generated.model.PingResponse;

@Controller
public class PingController implements PingApi{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResponseEntity<PingResponse> pingGet(String message) {
		
		logger.debug("--> pingGet - message: {}", message);
		PingResponse pingResponse = new PingResponse();
		//TODO generate uuid
		pingResponse.setId("0");
		pingResponse.setResponseMessage("hello from Sadr");
		return new ResponseEntity<PingResponse>(pingResponse, HttpStatus.OK);
	}

	

	
}