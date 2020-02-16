package edu.bh.user.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.bh.user.filter.UserServiceFilter;

@Configuration
public class UserServiceConfig implements WebMvcConfigurer {

	@Bean
	public FilterRegistrationBean<UserServiceFilter> loggingFilter(){
	    FilterRegistrationBean<UserServiceFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new UserServiceFilter());
	    registrationBean.addUrlPatterns("/gobal/*");
	         
	    return registrationBean;    
	}
	

}
