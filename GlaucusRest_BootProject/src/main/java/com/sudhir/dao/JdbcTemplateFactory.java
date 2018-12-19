package com.sudhir.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateFactory {
	
	// Inject datasource reference which comes from DataSourceFactory class handed over to container
	@Autowired
	DataSource dataSource;
	
	// Giving JdbcTempate object to container as a Bean with the dataSorce object reference
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
