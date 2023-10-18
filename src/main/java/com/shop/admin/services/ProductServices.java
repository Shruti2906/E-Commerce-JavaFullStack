package com.shop.admin.services;

import java.util.List;

import com.shop.admin.model.Product;

public interface ProductServices {

	String create(List<Product> lst);
	List<Product> retreiveProduct(int productId);
	List<Product> displayAll();
	String deleteProduct(int productId);
	boolean decreaseQty(List<Product> plst);
}
