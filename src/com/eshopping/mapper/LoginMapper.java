package com.eshopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eshopping.properties.LoginAccessor;

public class LoginMapper implements RowMapper<LoginAccessor> {

	public LoginAccessor mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		LoginAccessor loginAccessor = new LoginAccessor();
		loginAccessor.setUsername(resultSet.getString("username"));
		loginAccessor.setPassword(resultSet.getString("password"));
		return loginAccessor;
	}
}
