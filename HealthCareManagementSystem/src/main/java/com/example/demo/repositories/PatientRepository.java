package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Patient;
import com.example.demo.entities.User;

//@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> 
{
	
	@Query("select a from Patient a where pid=:pid")
	public Optional<Patient> getPatient(int pid);
	
	@Query("select a from Patient a where uid=:uid")
	public Patient getPatientbyUid(int uid);

//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getPatientLogin(String uname,String pwd);
//	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getLogin(String uname,String pwd);
	
	
	
	
	
	
	
		
}