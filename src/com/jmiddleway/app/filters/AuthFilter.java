package com.jmiddleway.app.filters;

/*
 * Author  : Aravinda
 * Description :Filter called by framework for every request except what ever APIs user specifically exclude.
 * Company :  
 */


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


@Provider
public class AuthFilter implements ContainerRequestFilter, ContainerResponseFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
	
	ApplicationContext ctx = AppContext.getApplicationContext();
	
	@Context
    private HttpServletRequest request;
	
    
	//When REST API is called, framework calls this filter before actually calling the actual API
	@Override
	public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
	
		logger.debug("Request Authentication");
		String path = requestContext.getUriInfo().getPath();
		String method = requestContext.getMethod();
		logger.debug(" Request URI is : " + path + " Method : " + method);
		
		/* If some APIs need to be without authentication of some thing special then it can return without doing anything here
		if(("YourResource/").equals(path) && (method.equals("POST")))
		{
			return;
		} */
		//Get header info if you have anything to validate
		
		String userHeaderInfo = requestContext.getHeaderString("USERHEADERINFO");
		
		logger.info("AUDIT TRAIL : USERHEADERINFO : " + userHeaderInfo);
		
		// call your authentication service
		//	AuthenticationService authenticationService = new AuthenticationService(); or inject it
		// add code to chk for timeout, user verification
		//store any data in servlet context (request.getServletContext()) if you want to share some data between calls - not large data
		
	}	
	
	//When REST API response is generated the frameowrk calls this filter before ther response is returned
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)  {
		
		logger.debug("Response Filter");
		String methodName = requestContext.getMethod();
		logger.debug(" Request URI is : " + methodName);
	}	
}

