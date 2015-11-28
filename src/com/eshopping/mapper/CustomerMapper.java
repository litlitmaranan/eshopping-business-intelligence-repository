package com.eshopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eshopping.properties.CustomerAccessor;

public class CustomerMapper implements RowMapper<CustomerAccessor> {

	@Override
	public CustomerAccessor mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		CustomerAccessor customer = new CustomerAccessor();
		customer.setId(resultSet.getInt("id"));
		customer.setFirstname(resultSet.getString("firstname"));
		customer.setLastname(resultSet.getString("lastname"));
		customer.setAddress(resultSet.getString("address"));
		customer.setContact(resultSet.getString("contact"));
		customer.setUsername(resultSet.getString("username"));
		customer.setPassword(resultSet.getString("password"));
		return customer;
	}
	
	
}
