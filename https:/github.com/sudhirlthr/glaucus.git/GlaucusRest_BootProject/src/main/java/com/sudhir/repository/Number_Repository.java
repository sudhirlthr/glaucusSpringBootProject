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
 * @author sudhir
 *
 */
@Repository
public class Number_Repository {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSourceFactory dataSourceFactory;
	
	@Autowired
	public Number_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Integer getNumber() {
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
	
	public void saveNumber() {
		if(jdbcTemplate.update("update "+dataSourceFactory.getTableName()+" set id =id+1;")>0)
			System.out.println("Number updated.");
		else
			System.out.println("Some error, Number did not updated.");
	}
}
