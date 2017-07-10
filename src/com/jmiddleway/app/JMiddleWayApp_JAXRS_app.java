package com.jmiddleway.app;

/*
 * Author  : Aravinda
 * Description :JAX RX Application class, Registers the components to be used by the JAX-RS application
 * Company :   
 */

import java.util.logging.Logger;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.jmiddleway.app.ExceptionMappers.JMiddleWayExceptionMapper;
import com.jmiddleway.app.ExceptionMappers.JMiddleWayGenericExceptionMapper;
import com.jmiddleway.app.filters.ApplicationContextProvider;
import com.jmiddleway.log.JMiddleWayLoggingFilter;
import com.jmiddleway.log.LoggerInjector;
import com.jmiddleway.service.YourResourceService;


public class JMiddleWayApp_JAXRS_app extends ResourceConfig {
	
	public JMiddleWayApp_JAXRS_app() {
		
		packages("com.jmiddleway");
		
	    register(LoggerInjector.class);
	    	
		register(JMiddleWayExceptionMapper.class);
		register(JMiddleWayGenericExceptionMapper.class);
		register(ApplicationContextProvider.class);
		register(YourResourceService.class);
		
		
		// Optionally remove existing handlers attached to j.u.l root logger
		SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)
		// add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
		 // the initialization phase of your application
		SLF4JBridgeHandler.install();
				
		registerInstances(new JMiddleWayLoggingFilter(Logger.getLogger(JMiddleWayApp_JAXRS_app.class.getName()), true));
		
	}
}
