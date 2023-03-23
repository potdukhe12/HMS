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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="treatment")
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int treatid;
	
	@Column
	String tname;
	
	@JsonIgnoreProperties("treatment")
	@ManyToOne
	@JoinColumn(name= "did")
	Doctor doctor;

	public Treatment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Treatment(int treatid, String tname, Doctor doctor) {
		super();
		this.treatid = treatid;
		this.tname = tname;
		this.doctor = doctor;
	}

	public int getTreatid() {
		return treatid;
	}

	public void setTreatid(int treatid) {
		this.treatid = treatid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
