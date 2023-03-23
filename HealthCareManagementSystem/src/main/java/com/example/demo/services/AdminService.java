package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;
import com.example.demo.repositories.AdminRepository;

@Service
public class AdminService 
{
	@Autowired
	AdminRepository admin_repo;
	
	public Admin register(Admin u)
	{
		return admin_repo.save(u);
	}
	
	
	public Admin getAdmin(int did)
	{
		return admin_repo.findById(did).get();
	}
	
	public Admin getAdminID(User u)
	{
		return admin_repo.getAdminID(u);
	}
	
	
	
	public List<Admin> getAll()
	{
		return admin_repo.findAll();
	}
	
	public Admin save(Admin u)
	{
		return admin_repo.save(u);
	}

//	public Doctor insertDoctor(Doctor u)
//	{
//		return doctor_repo.insertDoctor(u);
//	}
}
