package com.netmind.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.netmind.demo.security.JWTAuthorizationFilter;

@SpringBootApplication
public class NetmindSpringBootApplication {

	static final Logger logger = LoggerFactory.getLogger(NetmindSpringBootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(NetmindSpringBootApplication.class, args);
		logger.info("Netmind SpringBoot Api REDY");
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(),
							UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/", "/v2/api-docs", // swagger
							"/webjars/**", // swagger-ui webjars
							"/swagger-resources/**", // swagger-ui resources
							"/configuration/**", // swagger configuration
							"/*.html", "/favicon.ico", "/**/*.html",
							"/**/*.css", "/**/*.js")
					.permitAll().antMatchers(HttpMethod.POST, "/user")
					.permitAll().anyRequest().authenticated();
		}
	}
}