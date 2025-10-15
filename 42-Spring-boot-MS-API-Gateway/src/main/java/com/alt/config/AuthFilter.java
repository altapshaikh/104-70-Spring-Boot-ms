package com.alt.config;

import java.io.IOException;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpRequest token = (HttpRequest) request.getAttribute("token");
		
		System.out.println("we are in authentication filter");
		
		chain.doFilter(request, response);
	}

}
