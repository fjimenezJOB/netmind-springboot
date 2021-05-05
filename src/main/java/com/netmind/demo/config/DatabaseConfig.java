package com.netmind.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

	static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private String url;
	private String username;
	private String password;
	private String driverClassName;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		logger.info("Database URL: " + url);
		logger.info("Database Username: "+ username);
		logger.info(password);
		logger.info("Database Driver: "+driverClassName);
		return url;
	}

	@Profile("pro")
	@Bean
	public String proDatabaseConnection() {
		logger.info("Database URL: " + url);
		logger.info("Database Username: "+ username);
		logger.info(password);
		logger.info("Database Driver: "+driverClassName);
		return url;
	}
}
