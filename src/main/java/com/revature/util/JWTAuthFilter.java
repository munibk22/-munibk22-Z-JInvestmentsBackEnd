package com.revature.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.models.Users;
import com.revature.services.UserService;

public class JWTAuthFilter extends OncePerRequestFilter {

	private UserService userService;
	private JWTTokenHelper jwtTokenHelper;

	public JWTAuthFilter(UserService userService, JWTTokenHelper jwtTokenHelper) {
		super();
		this.userService = userService;
		this.jwtTokenHelper = jwtTokenHelper;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authToken = jwtTokenHelper.getAuthHeaderFromHeader(request);
		if (null != authToken) {
			String userName = jwtTokenHelper.getUsernameFromToken(authToken);
			if (null != userName) {
				Users user = userService.loadUserByUsername2(userName);

			}
		}
	}

}
