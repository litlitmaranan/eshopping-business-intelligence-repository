package com.eshopping.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.eshopping.mapper.LoginMapper;
import com.eshopping.properties.LoginAccessor;

public class LoginJDBC {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds){
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public LoginAccessor login(String username, String password){
		String SQL = "SELECT * FROM admin_db WHERE username LIKE ? AND password LIKE ?;";
		LoginAccessor loginAccessor = jdbcTemplateObject.queryForObject(SQL, new Object[]{username, password}, new LoginMapper());
		return loginAccessor;
	}

	
}
