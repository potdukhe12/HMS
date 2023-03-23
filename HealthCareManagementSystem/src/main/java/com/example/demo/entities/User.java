package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "role",referencedColumnName="role")
//	private Role role;
	
	
	@Column
	String pwd;
	
	@Column
	String email;
	
	@Column
	String uname;
	
	@Column
	String address;
	
	@Column
	String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String pwd, String email, String uname, String address, String role) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.email = email;
		this.uname = uname;
		this.address = address;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
