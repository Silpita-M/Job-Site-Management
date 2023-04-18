package com.example.JobManagementSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.JobSeeker;
import com.example.JobManagementSite.model.User;

public interface JobSeekerRepo extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findByUser(User user);
}
