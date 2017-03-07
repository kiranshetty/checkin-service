package com.checkin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RefreshScope
@RestController
public class CheckinApplication {

	@Value("${service:service not found}")
	String service;

	@Value("${endpoint:endpoint not found}")
	String endpoint;

	@RequestMapping("/")
	public String home() {

		StringBuilder strBuilder = new StringBuilder("Service Name: ");
		strBuilder.append(service);
		strBuilder.append("<br>");
		strBuilder.append("Endpoint: ");
		strBuilder.append(endpoint);

		return strBuilder.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(CheckinApplication.class, args);
	}

}