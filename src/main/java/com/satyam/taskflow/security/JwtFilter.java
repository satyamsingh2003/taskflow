package com.satyam.taskflow.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
@Autowired
private JwtUtil jwtUtil;

@Autowired
private CustomUserDetailsService userDetailsService;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {

	final String authHeader = request.getHeader("Authorization");
	String username = null;
	String jwt = null;
	
	if(authHeader !=null && authHeader.startsWith("Bearer")) {
		jwt = authHeader.substring(7);
		username = jwtUtil.extractUsername(jwt);
	}
	
	if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if(jwtUtil.validateToken(jwt, userDetails)) {
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}
	}
	filterChain.doFilter(request, response);
}

@Override
protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
	String path = request.getServletPath();
	return path.equals("/auth/login") || path.equals("/auth/register");
}


}
