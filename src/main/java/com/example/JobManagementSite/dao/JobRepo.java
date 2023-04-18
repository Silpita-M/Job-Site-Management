package com.example.JobManagementSite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.Company;
import com.example.JobManagementSite.model.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {

	List<Job> findAllByCompany(Company company);
}
