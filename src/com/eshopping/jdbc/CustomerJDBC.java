package com.eshopping.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJDBC{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds){
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void addCustomer(String firstname, String lastname, String address,
			String contact, String username, String password) {
		String SQLRegister = "INSERT INTO customer_db (firstname, lastname, address, contact, username, password) VALUES(?, ?, ?, ?, ?, ?);"; 
		jdbcTemplateObject.update(SQLRegister, firstname, lastname, address, contact, username, password);
		return;
	}

	public void addCustomerRights(String username, String password) {
		String SQLAdmin = "INSERT INTO admin_db (username, password) VALUES(?, ?);";
		jdbcTemplateObject.update(SQLAdmin, username, password);
		return;
	}

}
