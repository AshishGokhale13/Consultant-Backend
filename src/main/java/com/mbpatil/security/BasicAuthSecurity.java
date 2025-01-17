package com.mbpatil.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicAuthSecurity {


  private final RestAuthenticationEntryPoint authenticationEntryPoint;

  @Autowired
  public BasicAuthSecurity(RestAuthenticationEntryPoint authenticationEntryPoint) {
    this.authenticationEntryPoint = authenticationEntryPoint;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests()
        .requestMatchers("/admin/**")
        .authenticated()
        .and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint);
    return http.build();
  }
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth,PasswordEncoder passwordEncoder) throws Exception {
    auth.inMemoryAuthentication()
            .passwordEncoder(PasswordEncoderConfig.passwordEncoder())
            .withUser("mbpatil")
            .password(PasswordEncoderConfig.passwordEncoder().encode("ad31n"))
            .roles("ADMIN");
  }

}