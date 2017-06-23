package com.jmiddleway.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.jmiddleway.exceptionhandlers.JMiddleWayException;




public class YourResourceService {
	
	@com.jmiddleway.log.InjectLogger
	private Logger logger;
	
	public YourResourceService() {
	
	}
		
	
	public Response getYourResource(HttpServletRequest request) throws JMiddleWayException {	
		
		Response response = null;
		//do what you want to do here and create a appriate response object
		return response;
	}
	
	
	public Response createYourResource(HttpServletRequest request) throws JMiddleWayException {
		
		Response response = null;
		//do what you want to do here and create a appriate response object
		return response;
	}
	
	public Response updateYourResource(HttpServletRequest request) throws JMiddleWayException {
		
		Response response = null;
		//do what you want to do here and create a appriate response object
		return response;
	}

	public Response deleteYourResource(HttpServletRequest request) throws JMiddleWayException {
		
		Response response = null;
		//do what you want to do here and create a appriate response object
		return response;
	}
}

