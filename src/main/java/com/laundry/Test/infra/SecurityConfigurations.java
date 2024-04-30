package com.laundry.Test.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

      @Configuration
      @EnableWebSecurity
	  class SecurityConfigurations {
	    
    	  @Autowired
    	  private SecurityFilter securityFilter;
    	 
		  @Bean
		  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			  	  http
			  	  .csrf((csrf) -> csrf.disable());
			  	  return http
			  			.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  			.authorizeHttpRequests((authorize) -> authorize
			  			.requestMatchers(HttpMethod.POST, "/login").permitAll()
			  			.anyRequest().authenticated())
			  			.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
			  			.build();
	    }

		
		  
		  @Bean
		    WebSecurityCustomizer webSecurityCustomizer() {
		        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**");
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
