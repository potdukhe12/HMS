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
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int did;
	
	@Column
	String dname;
	
	@Column
	Date dob;
	
	@Column
	String mobno;
	
	@Column
	String gender;
	
	@JsonIgnoreProperties("doctor")
	@OneToOne
	@JoinColumn(name= "uid")
	User user;

	@Column
	String degree;
	
	@Column
	int experience;
	
	@Column
	String specialization;
	
	@Column
	boolean status;
	
	@JsonIgnoreProperties("doctor")
	@ManyToOne
	@JoinColumn(name= "hid")
	Hospital hospital;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int did, String dname, Date dob, String mobno, String gender, User user, String degree,
			int experience, String specialization, boolean status, Hospital hospital) {
		super();
		this.did = did;
		this.dname = dname;
		this.dob = dob;
		this.mobno = mobno;
		this.gender = gender;
		this.user = user;
		this.degree = degree;
		this.experience = experience;
		this.specialization = specialization;
		this.status = status;
		this.hospital = hospital;
	}

	
//	
//	public Doctor(int did, String dname, Date dob, String mobno, String gender, int uid, String degree,
//			int experience, String specialization, boolean status, int hid) {
//		super();
//		this.did = did;
//		this.dname = dname;
//		this.dob = dob;
//		this.mobno = mobno;
//		this.gender = gender;
//		this.user.uid = uid;
//		this.degree = degree;
//		this.experience = experience;
//		this.specialization = specialization;
//		this.status = status;
//		this.hospital.hid = hid;
//	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
	
}
