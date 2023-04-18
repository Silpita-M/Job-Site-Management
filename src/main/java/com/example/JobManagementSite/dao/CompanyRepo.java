package com.example.JobManagementSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.Company;
import com.example.JobManagementSite.model.User;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
}
