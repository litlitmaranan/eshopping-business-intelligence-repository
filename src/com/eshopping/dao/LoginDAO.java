package com.eshopping.dao;

import javax.sql.DataSource;

public interface LoginDAO {
	public void setDataSource(DataSource ds);
	
	public void addCustomer(String firstname, String lastname, String address, String contact, String username, String password);
}
