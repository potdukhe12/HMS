package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Appointment;
import com.example.demo.entities.History;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Treatment;
import com.example.demo.entities.User;

//@Transactional
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> 
{
	
	@Query("select a from Appointment a where pid=:pid order by datetime")	//use 
	public List<Appointment> getPatHistory(int pid);
	
	@Query("select a from Appointment a where did=:did order by datetime")
	public List<Appointment> getDocHistory(int did);
	
	@Query("select a from Appointment a where did=:did order by datetime")
	public List<Appointment> getApmtByDid(int did);
	
	@Query("select count(a) from Appointment a where did=:did and status=0")
	public int getDocActiveApmt(int did);
	
	@Query("select a from Appointment a where hid=:hid order by datetime")
	public List<Appointment> getApmtByHid(int hid);
	
	
//	@Query("select a from Treatment")
//	public Optional<Treatment> findAllTreatment();
//	
//	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getLogin(String uname,String pwd);
	
	
	
	
	
	
	
		
}