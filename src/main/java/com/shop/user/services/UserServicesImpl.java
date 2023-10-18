package com.shop.user.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import com.shop.admin.model.Product;
import com.shop.datasource.MyConnection;
import com.shop.user.model.Cart;

public class UserServicesImpl implements UserServices {

	@Override
	public List<Product> displayAllAvailables() {
		
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		
		List<Product> lst = new LinkedList<Product>();
		String str = "select * from product where PRODUCT_QTY>0";
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
	public List<Product> getProductById(int prodId) {

		List<Product> plst = new LinkedList();
		Product prod = null;
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("select * from product where PRODUCT_ID=?");
			pstate.setInt(1, prodId);
			ResultSet result = pstate.executeQuery();
			if(result.next()) {
				prod = new Product(result.getInt(1), result.getString(2), result.getFloat(3), result.getInt(4));
				plst.add(prod);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return plst;
	}

	public int getPurchaseQty(int prodId, String username) {
		
		int qty = 0;
		Product prod = null;
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("select * from User_product_Cart where PRODUCT_ID=? AND USERNAME=?");
			pstate.setInt(1, prodId);
			pstate.setString(2, username);
			ResultSet result = pstate.executeQuery();
			while(result.next()) {
				//prod = new Product(result.getInt(1), result.getString(2), result.getFloat(3), result.getInt(4));
				qty++;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return qty;
	}
	
	
	@Override
	public int addToCart(List<Cart> clst) {
		
	
			Cart c = clst.get(0);
			
			int i = 0;
			MyConnection mycon = new MyConnection();
			Connection con = mycon.getConnection();
			
			try {
				PreparedStatement pstate = con.prepareStatement("insert into User_product_Cart values(?, ?, ?, ?)");
				pstate.setInt(1, c.getProductId());
				pstate.setString(2, c.getProductName());
				pstate.setDouble(3, c.getProductPrice());
				//pstate.setInt(4, (qtybyNow+1));//..not available qty
				pstate.setString(4, c.getUserName());
				i = pstate.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(i>0) {
			System.out.println("impl added to car db");
		}
		else {
			System.out.println("impl NOT added to car db");
		}
		return i;
	}

	@Override
	public List<Cart> getCart(String userName) {
	
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		List<Cart> lst = new LinkedList<Cart>();
		int i=0;
		try {
			PreparedStatement pstate = con.prepareStatement("select * from User_product_Cart where USERNAME=?");
			pstate.setString(1, userName);
			ResultSet result = pstate.executeQuery();
			System.out.println("unm"+userName);
			while(result.next()){
					Cart prod = new Cart(result.getInt(1), result.getString(2), result.getDouble(3), result.getString(4));
					lst.add(prod);
					System.out.println(prod.getProductId());
					System.out.println("getting cart in loop");
					i=1;
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		if(i==0) {
			return null;
		}
		else
			return lst;
	
	}

}
