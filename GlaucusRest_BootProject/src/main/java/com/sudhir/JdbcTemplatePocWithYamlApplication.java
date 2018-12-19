package com.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*
 * author: Sudhir Kumar
 * 
 * Main class to start the application
 * */
@SpringBootApplication
@EnableConfigurationProperties
public class JdbcTemplatePocWithYamlApplication extends SpringBootServletInitializer{// extend SpringBootServletInitializer class to support WAR import through Maven

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JdbcTemplatePocWithYamlApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplatePocWithYamlApplication.class, args);

	}

}

