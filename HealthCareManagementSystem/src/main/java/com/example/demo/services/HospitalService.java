package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Hospital;
import com.example.demo.entities.MedServ;
import com.example.demo.entities.Treatment;
import com.example.demo.entities.User;
import com.example.demo.repositories.HospitalRepository;
import com.example.demo.repositories.MedServRepository;
import com.example.demo.repositories.TreatmentRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class HospitalService 
{
	@Autowired
	HospitalRepository hospital_repo;
	
	@Autowired
	TreatmentRepository treatment_repo;
	
	@Autowired
	MedServRepository medserv_repo;
	
	@Autowired
	UserRepository user_repo;
	
	public Hospital register(Hospital u)
	{
		return hospital_repo.save(u);
	}
	
	
	public Hospital getHospital(int hid)
	{
		return hospital_repo.findById(hid).get();
	}
	
	public List<Hospital> getAllHospital()
	{
		return hospital_repo.findAll();
	}
	
	public Hospital save(Hospital u)
	{
		return hospital_repo.save(u);
	}


	public List<Treatment> getTreatmentByHid(int hid) {
		return treatment_repo.getTreatmentByHid(hid);
	}


	public Hospital getHospitalByUid(int uid) {
		// TODO Auto-generated method stub
		return hospital_repo.getHospitalByUid(uid);
	}


	public List<MedServ> getMedservByHid(int hid) {
		// TODO Auto-generated method stub
		return medserv_repo.getMedservByHid(hid);
	}
	
	public List<MedServ> getAllMedserv() {
		// TODO Auto-generated method stub
		return medserv_repo.findAll();
	}


	public Hospital updateHosStatus(int hid) {
		Optional<Hospital> d = hospital_repo.findById(hid);
		Hospital hospital = d.get();
		hospital.setStatus(!hospital.getStatus());
		return hospital_repo.save(hospital);
	}


	public List<Hospital> getAllHospitalActive() {
		// TODO Auto-generated method stub
		return hospital_repo.getAllHospitalActive();
	}


	public Hospital updateHospital(Hospital h) {
		
		Optional<User> u = user_repo.findById(h.getUser().getUid());
		User user = u.get();
		h.setUser(user);
		return hospital_repo.save(h);
	}

}
