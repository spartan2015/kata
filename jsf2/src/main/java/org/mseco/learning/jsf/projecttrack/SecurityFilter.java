package org.mseco.learning.jsf.projecttrack;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {

	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		
		System.out.println("Security Fitler: " + ((HttpServletRequest)request).getRequestURI());
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
