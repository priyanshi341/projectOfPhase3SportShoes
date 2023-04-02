package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.simplilearn.entity.UserSignedup;
import com.simplilearn.repository.UserSignedUpRepository;

@Service
public class UserSignedUpService {

	@Autowired
	UserSignedUpRepository userrepository;
	
	public void saveuserdetails(UserSignedup usersignedup)
	{
		userrepository.save(usersignedup);
	}
	
	public List<UserSignedup> getalluserdata()
	{
		return userrepository.findAll();
	}
	
	public UserSignedup getsingleserdata(int id)
	{
		return userrepository.findById(id).get();
	}
}
