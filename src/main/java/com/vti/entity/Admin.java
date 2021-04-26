package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin", catalog = "mentormanagement")
public class Admin implements Serializable {
	
	@Column(name = "Username", length = 30, nullable = false, updatable = false)
	@Id
	private String username;

	@Column(name = "password", length = 30, nullable = false)
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + username + ", password=" + password + "]";
	}
	
	

}
