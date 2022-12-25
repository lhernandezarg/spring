package com.prrin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecutiryConfig {

	private static final String[] AUTH_WHITELIST = { "/swagger-resources/**", "/swagger-ui/**", "/v3/api-docs",
			"/webjars/**" };

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("alfa_trion").password(passwordEncoder().encode("Til_all_are_one!"))
				.roles("ADMIN")

				.build();

		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().antMatchers("/api/**")
				.authenticated().and().httpBasic().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}