package com.setup.details.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// all requests should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		// if the request is not authenticated then show the login page.
		http.httpBasic(withDefaults());
		
		// disable csrf -> for put, post
		http.csrf().disable();
		
		return http.build(); 
		
	}
}
