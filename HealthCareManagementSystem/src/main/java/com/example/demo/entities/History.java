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
@Table(name="history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hisid;
	
	@JsonIgnoreProperties("history")
	@ManyToOne
	@JoinColumn(name= "pid")
	Patient patient;
	
	@Column
	double cost;
	
	@JsonIgnoreProperties("history")
	@ManyToOne
	@JoinColumn(name= "treatid")
	Treatment treatment;
	
	@JsonIgnoreProperties("history")
	@OneToOne
	@JoinColumn(name= "apmtid")
	Appointment appointment;
	
	@JsonIgnoreProperties("history")
	@ManyToOne
	@JoinColumn(name= "hid")
	Hospital hospital;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public History(int hisid, Patient patient, double cost, Treatment treatment, Appointment appointment,
			Hospital hospital) {
		super();
		this.hisid = hisid;
		this.patient = patient;
		this.cost = cost;
		this.treatment = treatment;
		this.appointment = appointment;
		this.hospital = hospital;
	}

	public int getHisid() {
		return hisid;
	}

	public void setHisid(int hisid) {
		this.hisid = hisid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}



	
	

		
}
