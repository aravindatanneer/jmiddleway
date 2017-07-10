package com.jmiddleway.app.restapis;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jmiddleway.exceptionhandlers.JMiddleWayException;
import com.jmiddleway.service.YourResourceService;

/* YourResource class is a sample to show case REST API in the JMiddleWay framework. 
 * Create yourown APIs based on this sample and write appropriate services classes talking to back end for 
 * ex GET,CREATE, PUT or DEL a row or rows from a particualt table.
 * Pass the parameter as JSON object mapped to POJO. Write your own JSON and use POJO mapping tool 
 * to generate Java class. When REST client sends the parameter as JSON object it will be mapped to 
 * Java object automatically by framwork 
 * */

@Component
@Path("/YourResource")
public class YourResource {
	@Autowired
	private YourResourceService yourResourceService;
	
	@GET	
	@Produces("application/json")
	public Response GetYourResource(@Context HttpServletRequest request) throws JMiddleWayException {	
		
		return yourResourceService.getYourResource(request);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	
	public Response CreateYourResource(@Context HttpServletRequest request) throws JMiddleWayException {
		return yourResourceService.createYourResource(request);
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	
	public Response UpdateYourResource(@Context HttpServletRequest request) throws JMiddleWayException {
		return yourResourceService.updateYourResource(request);
	}

	@DELETE
	@Consumes("application/json")
	@Produces("application/json")
	
	public Response DeleteYourResource(@Context HttpServletRequest request) throws JMiddleWayException {
		return yourResourceService.deleteYourResource(request);
	}
}
