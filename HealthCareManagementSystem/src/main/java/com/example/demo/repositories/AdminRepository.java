package com.example.demo.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.User;

//@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> 
{
	
	@Query("select a from Admin a where aid=:aid")
	public Optional<Admin> getAdmin(int aid);
	
	@Query("select a from Admin a where uid=:u")
	public Admin getAdminID(User u);
	
	
//	@Modifying
//	@Query("insert into Doctor(dname,dob,mobno,gender,uid,degree,experience,specialization,status,hid) values(:dname,:dob,:mobno,:gender,:uid,:degree,:experience,:specialization,:status,:hid")
//	public int insertDoctor(String dname,Date dob,String mobno,String gender,int uid,String degree,int experience,String specialization,boolean status,int hid);
	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getPatientLogin(String uname,String pwd);
//	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getLogin(String uname,String pwd);
	
	
	
	
	
	
	
		
}