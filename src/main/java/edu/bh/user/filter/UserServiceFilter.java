package edu.bh.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserServiceFilter implements Filter {

	private Logger log = LoggerFactory.getLogger(UserServiceFilter.class);

	public void init(FilterConfig config) throws ServletException {

		System.out.println("User Service Filter init() servlet context is "+config.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		log.info("Request URI {} ", hRequest.getRequestURI());
		log.info("Request Method {} ", hRequest.getMethod());
		log.info("Remote Address {} ", hRequest.getRemoteAddr());
		chain.doFilter(request, response);
	}

	public void destroy() {

		System.out.println("User Service Filter Destory() ");
	}
}
