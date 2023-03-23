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

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Hospital;
import com.example.demo.entities.Treatment;
import com.example.demo.entities.MedServ;
import com.example.demo.services.HospitalService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HospitalController {

	@Autowired
	HospitalService hospitalservice;
	
	@PostMapping("/regHospital")
	public Hospital regHospital(@RequestBody Hospital u)
	{
		return hospitalservice.register(u);
	}

//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getHospital")
	public Hospital getHospital(@RequestParam("hid") int hid)
	{
		return hospitalservice.getHospital(hid);
	}
	
//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getHospitalByUid")
	public Hospital getHospitalByUid(@RequestParam("uid") int uid)
	{
		return hospitalservice.getHospitalByUid(uid);
	}
	
//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getTreatmentByHid")
	public List<Treatment> getTreatmentByHid(@RequestParam("hid") int hid)
	{
		return hospitalservice.getTreatmentByHid(hid);
	}
	
//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getMedservByHid")
	public List<MedServ> getMedservByHid(@RequestParam("hid") int hid)
	{
		return hospitalservice.getMedservByHid(hid);
	}
	
	@GetMapping("/updateHosStatus")
	public Hospital updateHosStatus(@RequestParam("hid") int hid)
	{
		return hospitalservice.updateHosStatus(hid);
	}
	
	@PutMapping("/updateHospital")
	public Hospital updateHospital(@RequestBody Hospital u)
	{
		return hospitalservice.updateHospital(u);
	}
	
	
//	http://localhost:8080/getDoctor?pid=1
	@GetMapping("/getAllMedserv")
	public List<MedServ> getAllMedserv()
	{
		return hospitalservice.getAllMedserv();
	}
	
		
//	http://localhost:8080/getAll
	@GetMapping("/getAllHospital")
	public List<Hospital> getAll()
	{
		return hospitalservice.getAllHospital();
	}
	
//	http://localhost:8080/getAll
	@GetMapping("/getAllHospitalActive")
	public List<Hospital> getAllHospitalActive()
	{
		return hospitalservice.getAllHospitalActive();
	}
	
	//	http://localhost:8080/saveDoctor
	@PostMapping("/saveHospital")
	public Hospital save(@RequestBody Hospital u)
	{
		return hospitalservice.save(u);
	}
	
	
}
