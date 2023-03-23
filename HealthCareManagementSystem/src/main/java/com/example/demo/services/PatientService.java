package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.History;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Treatment;
import com.example.demo.entities.User;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.repositories.HistoryRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.TreatmentRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class PatientService 
{
	@Autowired
	PatientRepository patient_repo;
	
	@Autowired
	TreatmentRepository treatment_repo;
	
	@Autowired
	HistoryRepository history_repo;
	
	@Autowired
	AppointmentRepository appointment_repo;
	
	@Autowired
	UserRepository user_repo;
	
	public Patient register(Patient u)
	{
		return patient_repo.save(u);
	}
	
	
//	public Patient getPatient(int uid)
//	{
//		return patient_repo.findById(uid).get();
//	}
	
	public Patient getPatient(int uid)
	{
		return patient_repo.getPatientbyUid(uid);
	}
	
	public List<Patient> getAll()
	{
		return patient_repo.findAll();
	}
	
	public Patient save(Patient u)
	{
		return patient_repo.save(u);
	}

	public Patient updatePatient(Patient d) {
		
		Optional<User> u = user_repo.findById(d.getUser().getUid());
		User user = u.get();
		d.setUser(user);
		return patient_repo.save(d);
	}
	
	public List<Treatment> getAllTreatment() {
		return treatment_repo.findAll();
	}

	public List<History> getAllHistory(int pid) {
		return history_repo.getAllHistory(pid);
	}


	public List<Appointment> getAllApmt(int pid) {
		return appointment_repo.getPatHistory(pid);
	}


	public Appointment saveApmt(Appointment u) {
		return appointment_repo.save(u);
	}


	public List<Appointment> getApmtByDid(int did) {
		return appointment_repo.getApmtByDid(did);
	}


	public List<Appointment> getApmtByHid(int hid) {
		return appointment_repo.getApmtByHid(hid);
	}

	
}
