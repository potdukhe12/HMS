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
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int apmtid;
	
	@Column
	boolean status;
	
	@Column
	Date datetime;
	
	@JsonIgnoreProperties("appointment")
	@ManyToOne
	@JoinColumn(name= "treatid")
	Treatment treatment;
	
	@JsonIgnoreProperties("appointment")
	@ManyToOne
	@JoinColumn(name= "did")
	Doctor doctor;
	
	@JsonIgnoreProperties("appointment")
	@ManyToOne
	@JoinColumn(name= "pid")
	Patient patient;
	
	@JsonIgnoreProperties("appointment")
	@ManyToOne
	@JoinColumn(name= "hid")
	Hospital hospital;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int apmtid, boolean status, Date datetime, Treatment treatment, Doctor doctor,
			Patient patient, Hospital hospital) {
		super();
		this.apmtid = apmtid;
		this.status = status;
		this.datetime = datetime;
		this.treatment = treatment;
		this.doctor = doctor;
		this.patient = patient;
		this.hospital = hospital;
	}

	public int getApmtid() {
		return apmtid;
	}

	public void setApmtid(int apmtid) {
		this.apmtid = apmtid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Treatment gettreatment() {
		return treatment;
	}

	public void setTreatid(Treatment treatment) {
		this.treatment = treatment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	

		
}
