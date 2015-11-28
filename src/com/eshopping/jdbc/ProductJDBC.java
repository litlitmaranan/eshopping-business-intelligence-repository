package com.eshopping.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.eshopping.mapper.ProductMapper;
import com.eshopping.properties.ProductAccessor;

public class ProductJDBC {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<ProductAccessor> viewProducts() {
		String SQL = "SELECT * FROM prod_db;";
		List<ProductAccessor> productlist = jdbcTemplateObject.query(SQL, new ProductMapper());
		return productlist;
	}

	public void insertProducts(String productbrand, String productname, int quantity, int productprice) {
		String SQLInsert = "INSERT INTO prod_db (productbrand, productname, quantity, productprice) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQLInsert, productbrand, productname, quantity, productprice);
		return;
	}

	public ProductAccessor getProductForUpdate(int productidParam) {
		String SQL = "SELECT * FROM prod_db WHERE productid = ?";
		ProductAccessor product = jdbcTemplateObject.queryForObject(SQL, new Object[] {productidParam}, new ProductMapper());
		return product;
	}

	public void updateProducts(int productid, String productbrand, String productname, int quantity, int productprice) {
		String SQL = "UPDATE prod_db SET productbrand = ?, productname = ?, quantity = ?, productprice = ? WHERE productid = ?";
		jdbcTemplateObject.update(SQL, productbrand, productname, quantity, productprice, productid);
		return;
	}

	public void deleteProduct(int productid) {
		String SQL = "DELETE FROM prod_db WHERE productid = ?";
		jdbcTemplateObject.update(SQL, productid);
		return;
	}

	public void insertProductsInCart(String productbrand, String productname,
			int quantity, int productprice) {
		String SQLInsert = "INSERT INTO cart_db (productbrand, productname, quantity, productprice) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQLInsert, productbrand, productname, quantity, productprice);
		return;
		
	}

	public void insertProductsInOwn(String productbrand, String productname,
			int quantity, int productprice) {
		String SQLInsert = "INSERT INTO own_db (productbrand, productname, quantity, productprice) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(SQLInsert, productbrand, productname, quantity, productprice);
		return;
	}

	//TODO deleteProductInCart
	public void deleteProductInCart(int productid) {
		String SQL = "DELETE FROM cart_db WHERE productid = ?";
		jdbcTemplateObject.update(SQL, productid);
		return;
	}

	public List<ProductAccessor> viewProductsCart() {
		String SQL = "SELECT * FROM cart_db;";
		List<ProductAccessor> productlist = jdbcTemplateObject.query(SQL, new ProductMapper());
		return productlist;
	}

	public void deleteProductAllItemsInCart() {
		String SQL = "DELETE * FROM cart_db";
		jdbcTemplateObject.query(SQL, new ProductMapper());
		return;
	}

	public List<ProductAccessor> viewProductsOwn() {
		String SQL = "SELECT * FROM own_db;";
		List<ProductAccessor> productlist = jdbcTemplateObject.query(SQL, new ProductMapper());
		return productlist;
	}
}
