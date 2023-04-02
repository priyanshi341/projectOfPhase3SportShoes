package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.entity.UserSignedup;

public interface UserSignedUpRepository  extends JpaRepository<UserSignedup,Integer>{

}
