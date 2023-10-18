package com.shop.admin.services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.shop.datasource.*;
import com.shop.admin.model.Product;

public class ProductServicesImpl implements ProductServices{

	@Override
	public String create(List<Product> lst) {
		
		String str=null;
		Product prod = lst.get(0);
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("insert into Product values(?,?,?,?)");
			pstate.setInt(1, prod.getProductId());
			pstate.setString(2, prod.getProductName());
			pstate.setDouble(3, prod.getProductPrice());
			pstate.setInt(4, prod.getProductQty());
			int i = pstate.executeUpdate();
			if(i>0) {
				str = "valid";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			str = e.getMessage();
		}
		return str;
	}

	@Override
	public List<Product> retreiveProduct(int productId) {
		
		List<Product> lst = null;
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		
		try {
			
			PreparedStatement pstate = con.prepareStatement("select * from product where product_Id=?");
			pstate.setInt(1, productId);
			ResultSet result = pstate.executeQuery();
			if(result.next()) {
				Product prod = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4));
				lst = new ArrayList();
				lst.add(prod);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lst;
	}

	@Override
	public List<Product> displayAll() {
	
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		
		List<Product> lst = new LinkedList<Product>();
		String str = "select * from product";
		Statement state = null;
		try {
			state = con.createStatement();
			ResultSet result = state.executeQuery(str);
			
			while(result.next()){
					Product prod = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4));
					lst.add(prod);
					System.out.println("in loop");
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return lst;
	}

	@Override
	public String deleteProduct(int productId) {
		
		String msg=null;
		List<Product> lst = retreiveProduct(productId);
		if(lst != null) {
			
			MyConnection mycon = new MyConnection();
			Connection con = mycon.getConnection();
			try {
				PreparedStatement pstate = con.prepareStatement("delete from product where product_id=?");
				pstate.setInt(1, productId);
				int i = pstate.executeUpdate();
				if(i>0) {
					msg = "query ok";
				}
				else {
					msg = "Unable to delete product";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			msg = "Product Does not Exist.!";
		}
		
		return msg;
	}

	@Override
	public boolean decreaseQty(List<Product> plst) {
		
		boolean b = false;
		Product prod = plst.get(plst.size()-1);
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("update product set PRODUCT_QTY=? where product_id=?");
			pstate.setInt(1, (prod.getProductQty()-1));
			pstate.setInt(2, prod.getProductId());
			int i = pstate.executeUpdate();
			if(i>0) {
				b = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("qty decreased");
		return b;
	}

}
/*
 create table product
 (
 	product_Id number(20),
 	product_Name varchar2(30),
 	product_Price float,
 	Product_Qty number(20)	
 );
  
  
  
 */
//1:39search