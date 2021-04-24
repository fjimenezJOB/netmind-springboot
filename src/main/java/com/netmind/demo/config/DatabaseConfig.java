package com.netmind.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("com.netmind.app.database")
public class DatabaseConfig {

	static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private String url;
	private String user;
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		logger.info(url);
		logger.info(user);
		logger.info(password);
		return url;
	}

	@Profile("pro")
	@Bean
	public String prodDatabaseConnection() {
		logger.info(url);
		logger.info(user);
		logger.info(password);
		return url;
	}
}
