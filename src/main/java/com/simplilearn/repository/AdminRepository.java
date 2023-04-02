package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.entity.AdminTable;


public interface AdminRepository extends JpaRepository<AdminTable,String>{

}
