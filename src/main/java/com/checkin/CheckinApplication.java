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
public class CheckinApplication  {

  @Value("${name:name not found}")
  String name;

  @Value("${gender:gender not found}")
  String gender;

  @RequestMapping("/")
  public String home() {
	  
	  StringBuilder strBuilder = new StringBuilder("Hello ");
	  strBuilder.append(name);
	  strBuilder.append("<br>");
	  strBuilder.append("Gender: ");
	  strBuilder.append(gender);
	  
    return strBuilder.toString();
  }

  public static void main(String[] args) {
    SpringApplication.run(CheckinApplication.class, args);
  }

}