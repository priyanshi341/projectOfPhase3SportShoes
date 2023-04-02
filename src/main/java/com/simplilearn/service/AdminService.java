package com.simplilearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.AdminTable;
import com.simplilearn.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	public AdminRepository adminrepository;
	
	public void addadmin(AdminTable admintable)
	{
		adminrepository.save(admintable);
	}
	
	public AdminTable getadmindetail(String email)
	{
		return adminrepository.findById(email).get();
	}
}
