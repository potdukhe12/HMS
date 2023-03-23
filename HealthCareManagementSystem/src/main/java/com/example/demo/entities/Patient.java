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
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	
	@Column
	String pname;
	
	@Column
	Date dob;
	
	@Column
	String mobno;
	
	@Column
	String gender;
	
	@JsonIgnoreProperties("patient")
	@OneToOne
	@JoinColumn(name= "uid")
	User user;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int pid, String pname, Date dob, String mobno, String gender, User user) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.dob = dob;
		this.mobno = mobno;
		this.gender = gender;
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
	
	
}
