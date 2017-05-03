package com.fortech.java.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.fortech.java.CORSResponseFilter;
import com.fortech.java.LoggingResponseFilter;
import com.fortech.java.rest.PersonRest;


public class MyDemoApplication extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MyDemoApplication(){
		register(RequestContextFilter.class);
		
		register(PersonRest.class);
		
		register(JacksonFeature.class);	
		register(LoggingResponseFilter.class);
		register(CORSResponseFilter.class);
	}
}
