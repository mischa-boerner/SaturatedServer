package com.mischaboerner.saturatedserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//TODO: tokenbasierte Authentifizierung, z.B. mit JWT
		http.csrf().disable()
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(HttpMethod.POST, "/users/create").permitAll()
					.anyRequest().authenticated()
			);
		return http.build();
	}
}