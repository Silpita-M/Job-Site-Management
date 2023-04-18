package com.example.JobManagementSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
