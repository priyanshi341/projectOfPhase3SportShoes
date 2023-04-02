package com.simplilearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminTable {
@Id
public String adminemail;
public String password;
public String getAdminemail() {
	return adminemail;
}
public void setAdminemail(String adminemail) {
	this.adminemail = adminemail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public AdminTable(String adminemail, String password) {
	super();
	this.adminemail = adminemail;
	this.password = password;
}
public AdminTable() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "AdminTable [adminemail=" + adminemail + ", password=" + password + "]";
}

}
