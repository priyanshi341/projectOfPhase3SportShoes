package com.simplilearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSignedup {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public UserSignedup( String name, String email, String password) {
	super();
	
	this.name = name;
	this.email = email;
	this.password = password;
}
public UserSignedup() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "UserSignedup [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
}

}
