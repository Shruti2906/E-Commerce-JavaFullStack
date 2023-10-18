package com.shop.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	public Connection getConnection() {
		System.out.println("in get connection");
		Connection con = null;
		
		try {
			//load Driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			//establish connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1612");
			
			System.out.println("Connection to Database done.!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
