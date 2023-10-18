package com.shop.superAdmin.services;

import java.util.List;

import com.shop.superAdmin.model.Login;
import com.shop.superAdmin.model.Register;

public interface loginServices {

	public boolean validateLogin(List<Login> lst);
	//view user data
	public List<Register> getCurrentUser(List<Login> lst);
	
	//update user data
	public List<Register> updateUser(List<Register> lst, String attr, String updateValue);
}
