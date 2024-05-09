package com.mbpatil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.security.JwtService;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	JwtService jwt;
	
	@GetMapping
	public boolean isValidTOken(@RequestHeader("Authorization") String token )
	{
		
		
		
		if(jwt.validateToken(token.replace("Bearer ", "")))
		return true;
		return false;
	}
}
