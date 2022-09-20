package com.departments.app.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class OncePerRequestFilterImpl extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String roles = request.getHeader("role");
		String userName = request.getHeader("username");
		if(roles != null && !roles.isEmpty() && userName != null && !userName.isEmpty()) {
			String[] roleArr = roles.split(",");
			List<GrantedAuthority> authorities = new ArrayList<>();
			Arrays.stream(roleArr).forEach(role -> authorities.add(new SimpleGrantedAuthority(role.trim())));
			
					
			UsernamePasswordAuthenticationToken authentication = new 
					UsernamePasswordAuthenticationToken(userName, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}

}
