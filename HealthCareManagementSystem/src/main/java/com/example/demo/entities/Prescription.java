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
@Table(name="prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prescid;
	
	@Column
	String description;
	
	@JsonIgnoreProperties("prescription")
	@ManyToOne
	@JoinColumn(name= "pid")
	Patient patient;
	
	@JsonIgnoreProperties("prescription")
	@ManyToOne
	@JoinColumn(name= "did")
	Doctor doctor;

	public Prescription()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescription(int prescid, String description, Patient patient, Doctor doctor) {
		super();
		this.prescid = prescid;
		this.description = description;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getPrescid() {
		return prescid;
	}

	public void setPrescid(int prescid) {
		this.prescid = prescid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
		
}
