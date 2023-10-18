package com.shop.superAdmin.model;

public class Register {

	
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String userName;
	private String password;
	private String registerType;
	
	public Register() {
		registerType = "other";
	}

	public Register(String firstName, String lastName, String email, String gender, String userName, String password,
			String registerType) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.registerType = registerType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	
	
	
	
}
