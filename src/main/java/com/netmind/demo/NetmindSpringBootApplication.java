package com.netmind.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetmindSpringBootApplication {

	static final Logger logger = LoggerFactory
			.getLogger(NetmindSpringBootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(NetmindSpringBootApplication.class, args);
		logger.info("Netmind SpringBoot Api REDY");
	}

}
