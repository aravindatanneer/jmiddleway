package com.jmiddleway.app.ExceptionMappers;

/*
 * Author  : Aravinda
 * Description :JMiddleWay generic java exception mapper
 * 
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JMiddleWayGenericExceptionMapper implements ExceptionMapper<Throwable> {
 
	private static final Logger logger = LoggerFactory.getLogger(JMiddleWayGenericExceptionMapper.class);
	
	public Response toResponse(Throwable ex) {
		
		JMiddleWayErrorMessage errorMessage = new JMiddleWayErrorMessage();
		setError(ex,errorMessage);
		return Response.status(errorMessage.status)
				.entity(errorMessage)
				.type(MediaType.APPLICATION_JSON)
				.build();	
	}
	
	private void setError(Throwable ex, JMiddleWayErrorMessage errorMessage) {
		logger.info("Stack Trace : " + getStackTraceAsString(ex));		
		if(ex instanceof WebApplicationException ) {
			WebApplicationException we = (WebApplicationException)ex;
			logger.debug("WEBAPPLICATION EXCEPTION : MESSAGE : " + we.getMessage());
			// write the code to handle this particular exception and return what you want to return to user
		} else if (ex instanceof SQLException) {
			SQLException sqe = (SQLException)ex;
			logger.debug("SQL EXCEPTION : MESSAGE : " + sqe.getMessage() + " Code : " + sqe.getErrorCode());
			// write the code to handle this particular exception and return what you want to return to user		
		}
		else {
			logger.debug("GENERIC EXCEPTION : MESSAGE : " + ex.getMessage() + " Type :" + ex.getClass());		
		
		}
	}
	private String getStackTraceAsString(Throwable ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
}
