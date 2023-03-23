package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;
import com.example.demo.services.AdminService;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/regAdmin")
	public Admin regDoctor(@RequestBody Admin u)
	{
		return adminservice.register(u);
	}

//	http://localhost:8080/getAdmin?pid=1
	@GetMapping("/getAdmin")
	public Admin getAdmin(@RequestParam("aid") int aid)
	{
		return adminservice.getAdmin(aid);
	}
	
//	http://localhost:8080/getAdminID?uid=6
	@GetMapping("/getAdminID")
	public Admin getAdminID(@RequestParam("uid") int uid)
	{
		User u = userservice.getOne(uid);
		return adminservice.getAdminID(u);
	}
	
	
	
		
//	http://localhost:8080/getAll
	@GetMapping("/getAllAdmin")
	public List<Admin> getAll()
	{
		return adminservice.getAll();
	}
	
//	http://localhost:8080/saveDoctor
	@PostMapping("/saveAdmin")
	public Admin save(@RequestBody Admin u)
	{
		return adminservice.save(u);
	}
	
//	http://localhost:8080/insertDoctor
//	@PostMapping("/insertDoctor")
//	public Doctor insertDoctor(@RequestBody Doctor u)
//	{
//		return adminservice.insertDoctor(u);
//	}
	
}
