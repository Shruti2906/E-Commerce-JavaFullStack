package com.shop.user.services;

import java.util.List;

import com.shop.admin.model.Product;
import com.shop.user.model.Cart;

public interface UserServices {
	
	//String create(List<Product> lst);
	//List<Product> retreiveProduct(int productId);
	List<Product> displayAllAvailables();
	//String deleteProduct(int productId);
	List<Product> getProductById(int prodId);
	//add product to cart
	int addToCart(List<Cart> clst);
	//get cart
	List<Cart> getCart(String userName);
}
