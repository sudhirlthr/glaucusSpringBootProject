/**
 * 
 */
package com.sudhir.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sudhir.dao.DataSourceFactory;
import com.sudhir.pojo.Number_Pojo;
/**
 * @author : Sudhir Kumar
 * 
 * A repository class to get the Jdbctemplate object 
 * and perform CRUD operations 
 *
 */
@Repository
public class Number_Repository {
	
	// Inject JdbcTemplate object Autowired DI
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Inject dataSourceFactory object Autowired DI to get Table Name dynamically
	@Autowired
	DataSourceFactory dataSourceFactory;
	
	// method to get latest updated number from DB
	public synchronized Integer getNumber() {
		Number_Pojo numberPojo = jdbcTemplate.query("select id from "+dataSourceFactory.getTableName()+"", new ResultSetExtractor<Number_Pojo>() {

			@Override
			public Number_Pojo extractData(ResultSet rs) throws SQLException, DataAccessException {
				Number_Pojo num = new Number_Pojo();
				while(rs.next())
					num.setId(rs.getInt(1));
				return num;
			}
		});
		return numberPojo.getId();
	}
	
	
	// method to update / increment the number for each request
	public void saveNumber() {
		/*if(jdbcTemplate.update("update "+dataSourceFactory.getTableName()+" set id =id+1;")>0)
			System.out.println("Number updated.");
		else
			System.out.println("Some error, Number did not updated.");*/
		jdbcTemplate.update("update "+dataSourceFactory.getTableName()+" set id =id+1;");
	}
}
