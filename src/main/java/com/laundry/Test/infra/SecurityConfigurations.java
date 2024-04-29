package com.laundry.Test.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

      @Configuration
      @EnableWebSecurity
	  class SecurityConfigurations {
	    
		  @Bean
		  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			  	  http
			  	  .csrf((csrf) -> csrf.disable());
			  	  return http
			  			.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  	        .build();
	    }

          @Bean
          AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)  throws Exception{
			  return configuration.getAuthenticationManager();
		  }

          @Bean
          PasswordEncoder passwordEncoder() {
			  return new BCryptPasswordEncoder();
		  }
      }
