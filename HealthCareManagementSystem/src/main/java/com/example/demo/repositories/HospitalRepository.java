package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Hospital;

//@Transactional
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> 
{
	
	@Query("select a from Hospital a where hid=:hid")
	public Optional<Hospital> getHospital(int hid);

	@Query("select a from Hospital a where uid=:uid")
	public Hospital getHospitalByUid(int uid);

	@Query("select a from Hospital a where status=1 order by hname")
	public List<Hospital> getAllHospitalActive();
	
	
	
	
	
		
}