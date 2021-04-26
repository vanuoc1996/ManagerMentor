package com.vti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "MentorManagement", name = "mentor")
public class Mentor implements Serializable {
	
	@Column(name = "MentorId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(name = "Fullname", length = 30, nullable = false)
	private String fullName;

	@Column(name = "Email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "Password", length = 30, nullable = false)
	private String password;
	
	@Column(name = "Phone", length = 20, nullable = false)
	private String phone;
	
	@Column(name = "Address", length = 50, nullable = false)
	private String address;
	
	@Column(name = "PersonalDescription", length = 100)
	private String personalDescription;
	
	@Column(name = "Avatar", length = 50)
	private String avatar;
	
	@OneToMany(mappedBy = "mentor")
	private Set<ClassRequest> classRequest;
	
	public Mentor() {
		// TODO Auto-generated constructor stub
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonalDescription() {
		return personalDescription;
	}

	public void setPersonalDescription(String personalDescription) {
		this.personalDescription = personalDescription;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		
		for (ClassRequest classRequest2 : classRequest) {
			System.out.println(classRequest2.getId());
		}
		
		return "Mentor [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", personalDescription=" + personalDescription
				+ ", avatar=" + avatar + "]";
	}
	
	

}
