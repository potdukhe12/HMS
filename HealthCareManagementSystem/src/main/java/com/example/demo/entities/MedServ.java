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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="medserv")
public class MedServ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	
	@Column
	String sname;
		
	@JsonIgnoreProperties("medserv")
	@ManyToOne
	@JoinColumn(name= "hid")
	Hospital hospital;

	public MedServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedServ(int sid, String sname, Hospital hospital) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.hospital = hospital;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
		
}
