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
import com.example.demo.entities.Treatment;
import com.example.demo.entities.User;

//@Transactional
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> 
{
	
	@Query("select a from Treatment a where hid=:hid order by tname")
	public List<Treatment> getTreatmentByHid(int hid);
	
	
	
//	@Query("select a from Treatment")
//	public Optional<Treatment> findAllTreatment();
//	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getPatientLogin(String uname,String pwd);
//	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getLogin(String uname,String pwd);
	
	
	
	
	
	
	
		
}