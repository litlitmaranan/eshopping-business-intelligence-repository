package com.eshopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eshopping.properties.ProductAccessor;

public class ProductMapper implements RowMapper<ProductAccessor>{
	public ProductAccessor mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductAccessor product = new ProductAccessor();
		product.setProductid(rs.getInt("productid"));
		product.setProductbrand(rs.getString("productbrand"));
		product.setProductname(rs.getString("productname"));
		product.setProductprice(rs.getInt("productprice"));
		product.setQuantity(rs.getInt("quantity"));
		return product;
	}
}
