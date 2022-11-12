package com.departments.app.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class OncePerRequestFilterImpl extends OncePerRequestFilter{
	
	private Logger LOGGER = LoggerFactory.getLogger(OncePerRequestFilterImpl.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		LOGGER.info("Start of OncePerRequestFilterImpl class, doFilterInternal method ROLE - {}, USERNAME - {}", request.getHeader("role"), request.getHeader("username"));
		String roles = request.getHeader("role");
		String userName = request.getHeader("username");
		if(roles != null && !roles.isEmpty() && userName != null && !userName.isEmpty()) {
			LOGGER.info("Before authentication object OncePerRequestFilterImpl class, doFilterInternal method ROLE - {}, USERNAME - {}", request.getHeader("role"), request.getHeader("username"));
			String[] roleArr = roles.split(",");
			List<GrantedAuthority> authorities = new ArrayList<>();
			Arrays.stream(roleArr).forEach(role -> authorities.add(new SimpleGrantedAuthority(role.trim())));			
					
			UsernamePasswordAuthenticationToken authentication = new 
					UsernamePasswordAuthenticationToken(userName, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		LOGGER.info("End of OncePerRequestFilterImpl class, doFilterInternal method");		
		filterChain.doFilter(request, response);
	}

}
