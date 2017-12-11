package com.atsistemas.cygnus.sadr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.atsistemas.cygnus.sadr.generated.api.PingApi;
import com.atsistemas.cygnus.sadr.generated.model.PingResponse;

@Controller
public class PingController implements PingApi{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResponseEntity<PingResponse> pingGet() {
		
		logger.debug("--> pingGet");
		PingResponse pingResponse = new PingResponse();
		//TODO generate uuid
		pingResponse.setId("1");
		pingResponse.setResponseMessage("hello from Sadr");
		return new ResponseEntity<PingResponse>(pingResponse, HttpStatus.OK);
	}

	

	
}