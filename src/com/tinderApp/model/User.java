package com.tinderApp.model;

public class User {
	
	private String userName;
	private int age;
	private String gender;
	
	public User(String userName, int age, String gender) {
		super();
		this.userName = userName;
		this.age = age;
		this.gender = gender;
	}
	
	//Getters and Setters
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", gender=" + gender + "]";
	}

	


}