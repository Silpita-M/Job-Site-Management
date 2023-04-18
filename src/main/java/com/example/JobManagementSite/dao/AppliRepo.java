package com.example.JobManagementSite.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.Application;
import com.example.JobManagementSite.model.Job;
import com.example.JobManagementSite.model.JobSeeker;

public interface AppliRepo extends JpaRepository<Application, Integer>{

	List<Application> findAllByJob(Job job);

	List<Application> findAllByJobSeeker(JobSeeker jobSeeker);

	

}
