package com.mbpatil.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration  implements WebMvcConfigurer{
	
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	        .allowedOrigins("http://localhost:5173")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Authorization", "Origin", "Content-Type", "Accept")
            .exposedHeaders("Authorization")
            .allowCredentials(true); // Expose Authorization header to client    
	    }
}
