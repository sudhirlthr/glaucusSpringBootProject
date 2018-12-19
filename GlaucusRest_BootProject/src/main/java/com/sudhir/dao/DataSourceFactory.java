package com.sudhir.dao;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ConfigurationProperties(prefix="prod.db")
public class DataSourceFactory {
	
	private String tableName;
	private String driverClass;
	private String url;
	private String userName;
	private String password;
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*@Override
	public String toString() {
		return "DataSource [driverClass=" + driverClass + ", url=" + url + ", userName=" + userName + ", password="
				+ password + "]";
	}*/
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driverClass);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(userName);
		driverManagerDataSource.setPassword(password);
		return driverManagerDataSource;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
