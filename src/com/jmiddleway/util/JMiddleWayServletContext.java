package com.jmiddleway.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class JMiddleWayServletContext implements ServletContextAware {
	 private ServletContext servletContext;
	 
	    public void setServletContext(ServletContext context) {
	        this.servletContext = context;
	    }
	 
	    public ServletContext getServletContext() {
	        return servletContext;
	    }
}
