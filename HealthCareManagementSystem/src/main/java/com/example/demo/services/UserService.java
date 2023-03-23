package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository user_repo;
	
//	public int register(User u)
//	{
//		return user_repo.saveUser(u);
//	}

	public User save(User u)
	{
		return user_repo.save(u);
	}
	
	public User updateUser(User u)
	{
		return user_repo.updateUser(u);
	}
	
	public void deleteUser(int uid) {
		Optional<User> u = user_repo.findById(uid);
		user_repo.delete(u.get());
	}
	
	
	public User getLogin(String uname,String pwd)
	{
		User r;
		Optional<User> ou=user_repo.getLogin(uname, pwd);
		try
		{
			r=ou.get();
		}
		catch(Exception e)
		{
			r=null;	
		}
		return r;
	}
	
	
	public User getOne(int uid)
	{
		return user_repo.findById(uid).get();
	}
	
	public List<User> getAll()
	{
		return user_repo.findAll();
	}
	

}
