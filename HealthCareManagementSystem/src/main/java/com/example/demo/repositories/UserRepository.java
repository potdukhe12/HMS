package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	
	@Query("select a from User a where uname=:uname and pwd=:pwd")
	public Optional<User> getLogin(String uname,String pwd);
	
	@Modifying
	@Query("update User a set pwd=:pwd,email=:email, uname=:uname, address=:address, role=:role where uid=:uid")
	public User updateUser(User u);
	
	@Modifying
    @Query(value = "insert into User (pwd, email, uname, address, role) VALUES (:pwd, :email, :uname, :address, :role)", nativeQuery = true)
	public int saveUser(User u);
	
//	@Query("select a from User a where uname=:uname and pwd=:pwd")
//	public Optional<User> getLogin(String uname,String pwd);
	
	
	
	
	
	
	
		
}