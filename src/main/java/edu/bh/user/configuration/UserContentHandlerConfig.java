package edu.bh.user.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class UserContentHandlerConfig implements WebMvcConfigurer {

	
	 /**set path extension to true , set favor parameter to false ,
	ignore the accept headers, 
	dont use Java Activation Framework since we are manually specifying the mediatypes required below useJaf(false). **/
	/*
	@Override 
	public void  configureContentNegotiation(ContentNegotiationConfigurer configurer) {
			configurer
		  .favorPathExtension(true)
		  .favorParameter(false)
		  .ignoreAcceptHeader(true)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("xml", MediaType.APPLICATION_XML)
		  .mediaType("json",MediaType.APPLICATION_JSON);
	}*/
	
	 /**set path extension to true , set favor parameter to false ,
	ignore the accept headers, 
	dont use Java Activation Framework since we are manually specifying the mediatypes required below useJaf(false). **/
	
	
	/**
	@Override 
	public void  configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	  		configurer
		  .favorPathExtension(false)
		  .favorParameter(true)
		  .parameterName("mediaType")
		  .ignoreAcceptHeader(true)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("xml",MediaType.APPLICATION_XML)
		  .mediaType("json", MediaType.APPLICATION_JSON);
		 
	  
	  }**/
}
