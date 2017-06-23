package com.jmiddleway.app.ExceptionMappers;

/*
 * Author  : Aravinda
 * Description :JMiddleWay specific application exception mapper
 * Company :  
 */

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.jmiddleway.exceptionhandlers.JMiddleWayException;



public class JMiddleWayExceptionMapper implements ExceptionMapper<JMiddleWayException> {
	public Response toResponse(JMiddleWayException ex) {
		return Response.status(ex.getStatus())
				.entity(new JMiddleWayErrorMessage(ex))
				.type(MediaType.APPLICATION_JSON).
				build();
	}
}
