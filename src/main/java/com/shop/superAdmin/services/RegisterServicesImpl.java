package com.shop.superAdmin.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.shop.datasource.MyConnection;
import com.shop.superAdmin.model.Register;

public class RegisterServicesImpl implements RegisterServices{

	@Override
	public int create(List<Register> lst) {
	
		Scanner sc = new Scanner(System.in);
		Register reg = lst.get(0);
		
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		System.out.println("con : "+con);
		PreparedStatement pstate;
		
		int i = 0;
		try {
			pstate = con.prepareStatement("insert into shopRegister values(?, ?, ?, ?, ?, ?, ?)");
			pstate.setString(1, reg.getFirstName());
			pstate.setString(2, reg.getLastName());
			pstate.setString(3, reg.getEmail());
			pstate.setString(4, reg.getGender());
			pstate.setString(5, reg.getUserName());
			pstate.setString(6, reg.getPassword());
			pstate.setString(7, reg.getRegisterType());
			i = pstate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}
	
}
/*
 
create table shopRegister
(
	first_Name varchar2(20),
	last_Name varchar2(20),
	email varchar2(25),
	gender varchar2(10),
	userName varchar2(20),
	password varchar2(15),
	registerType varchar2(10)
);
 
 */
 