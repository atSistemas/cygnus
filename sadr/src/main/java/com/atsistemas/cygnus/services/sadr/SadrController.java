package com.atsistemas.cygnus.services.sadr;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.cygnus.model.PingRequest;
import com.atsistemas.cygnus.model.PingResponse;
import com.atsistemas.cygnus.services.sadr.util.RuntimeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("sadr/")
public class SadrController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@RequestMapping(method = RequestMethod.POST, value = "ping/")
	@ApiOperation(value = "ping", nickname = "ping", response = PingResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public PingResponse ping(HttpServletRequest request,
			@ApiParam(value = "request", required = true) @RequestBody(required = true) PingRequest pingRequest) {

		logger.debug("--> ping received - id: {} - message: {}", pingRequest.getId(), pingRequest.getMessage());
		return new PingResponse("Hello from Sadr on port: " + RuntimeUtil.getPort());
	}
}