package com.vti.dto;

public class AdminDto {
	private String Username;
	private String Password;

	public AdminDto(String username, String password) {
		Username = username;
		Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [Username=" + Username + ", Password=" + Password + "]";
	}

}
