package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SaltValue;
import com.example.demo.entities.LoginCheck;
import com.example.demo.entities.PassBasedEnc;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@Autowired
	SaltValue saltValue;
	
//	http://localhost:8080/saveUser
	@PostMapping("/saveUser")
	public User save(@RequestBody User u)
	{
		System.out.println("\n sv = "+saltValue.getSalt());
		String encrypted = PassBasedEnc.generateSecurePassword(u.getPwd(), saltValue.getSalt());
		System.out.println("\n **"+encrypted);
		u.setPwd(encrypted);
		return userservice.save(u);
		
	}
	
//	@PostMapping("/regUser")
//	public int registerUser(@RequestBody User u)
//	{
//		return userservice.register(u);
//	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User u)
	{
		return userservice.updateUser(u);
	}
	
	@PostMapping("/checkLogin")
	public User checkLogin(@RequestBody LoginCheck lcheck)
	{
		System.out.println("\n sv = "+saltValue.getSalt());
		String encrypted = PassBasedEnc.generateSecurePassword(lcheck.getPwd(), saltValue.getSalt());
		System.out.println("\n **"+encrypted);
		return userservice.getLogin(lcheck.getUname(), encrypted);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam("uid") int uid)
	{
		userservice.deleteUser(uid);
	}
	
	
	
	
//	http://localhost:8080/getOne?uid=1
	@GetMapping("/getOne")
	public User getOne(@RequestParam("uid") int uid)
	{
		return userservice.getOne(uid);
	}
		
//	http://localhost:8080/getAll
	@GetMapping("/getAll")
	public List<User> getAll()
	{
		return userservice.getAll();
	}
	
	
	
}
