package com.example.JobManagementSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.dao.CompanyRepo;
import com.example.JobManagementSite.dao.JobRepo;
import com.example.JobManagementSite.model.Company;
import com.example.JobManagementSite.model.Job;

@RestController
public class CompanyController {

	@Autowired
	CompanyRepo crepo;
	
	@Autowired
	JobRepo jobRepo;
	
	@PostMapping("/company")
	public Company addCompany(@RequestBody Company company)
	{
		crepo.save(company);
		return company;
	}
	
	@GetMapping("/companies")
	public List<Company> findAllCompanies()
	{
		return crepo.findAll();
	}
	
	@GetMapping("/companies/{id}")
	public Company findById(@PathVariable int id)
	{
		return crepo.findById(id).orElse(new Company());
	}
	
	@DeleteMapping("/companies/{id}")
	public String deleteById(@PathVariable int id )
	{
		crepo.deleteById(id);
		return "DELETED";
	}
	
	@GetMapping("/companies/{id}/jobs")
	public List<Job> getJobsByCompany(@PathVariable int id)
	{
		Company company = crepo.findById(id).orElse(new Company());
		List<Job> jobs = jobRepo.findAllByCompany(company);
		return jobs;
	}
}
