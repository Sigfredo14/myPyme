package com.pe.mypyme.seguridad.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pe.mypyme.seguridad.service.UserDetailsServiceImpl;



public class JwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
	
	@Autowired
	private JwtProvider JwtProvider;
	
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	
	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		
		if(header != null && header.startsWith("Bearer")) {
			return header.replace("Bearer ", "");
		}
		
		return null;
	}	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String token = getToken(request);
			if(token != null && JwtProvider.validateToken(token)){
				String username = JwtProvider.getUsernameFromToken(token);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
						
		} catch (Exception e) {
			logger.error("fail en el método doFilter");
		}
		
		filterChain.doFilter(request, response);		
	}	

}