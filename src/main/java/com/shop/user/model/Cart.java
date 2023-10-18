package com.shop.user.model;

public class Cart {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String userName;
	
	public Cart(int productId, String productName, double productPrice, String userName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	//	this.ProductQty = ProductQty;
		this.userName = userName;
	}
	
	public Cart() {
		super();
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/*public int getProductQty() {
		return ProductQty;
	}

	public void setProductQty(int productQty) {
		ProductQty = productQty;
	}
*/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
