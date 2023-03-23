package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hid;
	
	@Column
	String hname;

	@Column
	String teleno;
	
	@Column
	boolean status;
	
	@JsonIgnoreProperties("hospital")
	@OneToOne
	@JoinColumn(name= "uid")
	User user;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hid, String hname, String teleno, boolean status, User user) {
		super();
		this.hid = hid;
		this.hname = hname;
		this.teleno = teleno;
		this.status = status;
		this.user = user;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getTeleno() {
		return teleno;
	}

	public void setTeleno(String teleno) {
		this.teleno = teleno;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
}
