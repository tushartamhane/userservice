package edu.bh.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter{

	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.httpBasic();
	}
	
	@Autowired
	public void configueGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()	
		.withUser("admin")
		.password("{noop}password")
		.roles("USER");
	}
}
