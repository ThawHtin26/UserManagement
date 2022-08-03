package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer()
	{
		return (web)->
			web.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/h2-console/**");
		
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/user/signup").permitAll()
			.anyRequest().authenticated();
		
		http.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/user/list",true);
		
		http.csrf().disable();
		return http.build();
	}
	
}
