package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.entities.History;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Treatment;
import com.example.demo.services.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

	@Autowired
	PatientService patientservice;
	
	@PostMapping("/regPatient")
	public Patient registerUser(@RequestBody Patient u)
	{
		return patientservice.register(u);
	}

//	http://localhost:8080/getPatient?pid=1
//	@GetMapping("/getPatient")
//	public Patient getPatient(@RequestParam("pid") int pid)
//	{
//		return patientservice.getPatient(pid);
//	}
//	
	
	@GetMapping("/getPatient")
	public Patient getPatient(@RequestParam("uid") int uid)
	{
		return patientservice.getPatient(uid);
	}
	
	
	@PutMapping("/updatePatient")
	public Patient updatePatient(@RequestBody Patient u)
	{
		return patientservice.updatePatient(u);
	}
	
	
	@GetMapping("/getAllTreatment")
	public List<Treatment> getAllTreatment()
	{
		return patientservice.getAllTreatment();
	}
	
	@GetMapping("/getAllHistory")
	public List<History> getAllHistory(@RequestParam("pid") int pid)
	{
		return patientservice.getAllHistory(pid);
	}
	
//	@GetMapping("/getActivetApmt")
//	public List<History> getActivetApmt(@RequestParam("pid") int pid)
//	{
//		return patientservice.getActivetApmt(pid);
//	}
	
	@GetMapping("/getApmtByPid")
	public List<Appointment> getAllApmt(@RequestParam("pid") int pid)
	{
		return patientservice.getAllApmt(pid);
	}
	
	@PostMapping("/saveApmt")
	public Appointment saveApmt(@RequestBody Appointment u)
	{
		return patientservice.saveApmt(u);
	}
	
	@GetMapping("/getApmtByDid")
	public List<Appointment> getApmtByDid(@RequestParam("did") int did)
	{
		return patientservice.getApmtByDid(did);
	}
	
	@GetMapping("/getApmtByHid")
	public List<Appointment> getApmtByHid(@RequestParam("hid") int hid)
	{
		return patientservice.getApmtByHid(hid);
	}
		
//	http://localhost:8080/getAll
	@GetMapping("/getAllPatient")
	public List<Patient> getAll()
	{
		return patientservice.getAll();
	}
	
//	http://localhost:8080/saveUser
	@PostMapping("/savePatient")
	public Patient save(@RequestBody Patient u)
	{
		return patientservice.save(u);
				
	}
	
	
}
