package com.mbpatil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbpatil.dto.admin.AdminDto;
import com.mbpatil.models.Admin;
import com.mbpatil.responses.Response;
import com.mbpatil.security.JwtService;
import com.mbpatil.services.AdminServices;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServices adminService;
	

		
	@Autowired
	private JwtService jwt;
	
	@GetMapping("/check")
	public ResponseEntity<?> login(@ModelAttribute AdminDto obj,HttpServletResponse response)
	{
		
		System.out.println(obj.getUsername());
		System.out.println(obj.getPassword());
		Admin user=adminService.findUser(obj);
		
	
		
		String tokenValue="";
		if(user!=null)
		{
			tokenValue=jwt.generateToken(obj.getUsername()+obj.getPassword());
			Cookie cookie = new Cookie("ultv", tokenValue);
	        cookie.setMaxAge(3600); // set cookie expiration time in seconds
	        cookie.setPath("/"); // set cookie path, '/' means it's valid for the whole application
	        cookie.setSecure(false); // set the cookie to be secure, only sent over HTTPS
	        response.addCookie(cookie);
	        return new ResponseEntity<>(Response.success(200,"validate successfully", tokenValue),HttpStatusCode.valueOf(200)); 
		}	
        return new ResponseEntity<>(Response.error(401,"Invalid User", null),HttpStatusCode.valueOf(401)); 

	}
	
	@PostMapping
	public AdminDto saveUser(@RequestBody AdminDto obj)
	{
		return adminService.saveCredenTials(obj);
	}
	

}
