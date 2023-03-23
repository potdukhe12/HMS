package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Hospital;
import com.example.demo.entities.User;
import com.example.demo.services.DoctorService;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {

	@Autowired
	DoctorService doctorservice;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/regDoctor")
	public Doctor regDoctor(@RequestBody Doctor u)
	{
		return doctorservice.register(u);
	}

//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getDoctor")
	public Doctor getDoctor(@RequestParam("uid") int uid)
	{
		return doctorservice.getDoctor(uid);
	}
	
//	http://localhost:8080/getDoctor?hid=1
	@GetMapping("/getDoctorByHid")
	public List<Doctor> getDoctorByHid(@RequestParam("hid") int hid)
	{
		return doctorservice.getDoctorByHid(hid);
	}
	
	@PutMapping("/updateDoctor")
	public Doctor updateDoctor(@RequestBody Doctor u)
	{
		return doctorservice.updateDoctor(u);
	}
	
	
	@GetMapping("/getDocApmt")
	public List<Appointment> getAllApmt(@RequestParam("did") int did)
	{
		return doctorservice.getAllApmt(did);
	}
	
	@GetMapping("/getDocActiveApmt")
	public int getDocActiveApmt(@RequestParam("did") int did)
	{
		return doctorservice.getDocActiveApmt(did);
	}
	
	@GetMapping("/updateDocStatus")
	public Doctor updateDocStatus(@RequestParam("did") int did)
	{
		return doctorservice.updateDocStatus(did);
	}
	
	@GetMapping("/getAllDoctorActive")
	public List<Doctor> getAllDoctorActive()
	{
		return doctorservice.getAllDoctorActive();
	}
	
	
//	http://localhost:8080/getDoctorID?uid=6
	@GetMapping("/getDoctorByDid")
	public Doctor getDoctorID(@RequestParam("did") int did)
	{
//		User u = userservice.getOne(uid);
		return doctorservice.getDoctorID(did);
	}
	
	@GetMapping("/getDoctorBySpec")
	public List<Doctor> getDoctorBySpec(@RequestParam("specialization") String specialization)
	{
		return doctorservice.getDoctorBySpec(specialization);
	}
	
		
//	http://localhost:8080/getAll
	@GetMapping("/getAllDoctor")
	public List<Doctor> getAll()
	{
		return doctorservice.getAll();
	}
	
//	http://localhost:8080/saveDoctor
	@PostMapping("/saveDoctor")
	public Doctor save(@RequestBody Doctor u)
	{
		return doctorservice.save(u);
	}
	
//	http://localhost:8080/insertDoctor
//	@PostMapping("/insertDoctor")
//	public Doctor insertDoctor(@RequestBody Doctor u)
//	{
//		return doctorservice.insertDoctor(u);
//	}
	
}
