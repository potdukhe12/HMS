package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Hospital;
import com.example.demo.entities.User;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class DoctorService 
{
	@Autowired
	DoctorRepository doctor_repo;
	
	@Autowired
	AppointmentRepository appointment_repo;
	
	@Autowired
	UserRepository user_repo;
	
	public Doctor register(Doctor u)
	{
		return doctor_repo.save(u);
	}
	
	
	public Doctor getDoctor(int uid)
	{
		return doctor_repo.getDoctor(uid);
	}
	
	
	public Doctor getDoctorID(int did)
	{
		return doctor_repo.getDoctorID(did);
	}
	
	
	public Doctor updateDoctor(Doctor d) {
		
		Optional<User> u = user_repo.findById(d.getUser().getUid());
		User user = u.get();
		d.setUser(user);
		return doctor_repo.save(d);
	}


	public List<Doctor> getAll()
	{
		return doctor_repo.findAll();
	}
	
	public List<Doctor> getAllDoctorActive() {
		// TODO Auto-generated method stub
		return doctor_repo.getAllDoctorActive();
	}
	
	public Doctor save(Doctor u)
	{
		return doctor_repo.save(u);
	}


	public List<Appointment> getAllApmt(int did) {
		return appointment_repo.getDocHistory(did);
	}


	public List<Doctor> getDoctorByHid(int hid) {
		return doctor_repo.getDoctorByHid(hid);
	}


	public Doctor updateDocStatus(int did) {
		Optional<Doctor> d = doctor_repo.findById(did);
		Doctor doctor = d.get();
		doctor.setStatus(!doctor.isStatus());
		return doctor_repo.save(doctor);
	}


	public List<Doctor> getDoctorBySpec(String specialization) {
		
		return doctor_repo.getDoctorBySpec(specialization);
	}


	public int getDocActiveApmt(int did) {
		return appointment_repo.getDocActiveApmt(did);
	}
	
//	public List<Appointment> getPatHis(int pid) {
//		return appointment_repo.getPatHis(pid);
//	}
	
	
	

//	public Doctor insertDoctor(Doctor u)
//	{
//		return doctor_repo.insertDoctor(u);
//	}
}
