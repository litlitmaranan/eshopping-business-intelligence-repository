package com.eshopping.dao;

import javax.sql.DataSource;


public interface CustomerDAO {
	
	public void setDataSource(DataSource ds);
	
	public void addCustomer(String firstname, String lastname, String address, String contact, String username, String password);
}
