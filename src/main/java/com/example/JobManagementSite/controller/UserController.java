package com.example.JobManagementSite.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.dao.CompanyRepo;
import com.example.JobManagementSite.dao.JobSeekerRepo;
import com.example.JobManagementSite.dao.UserRepo;
import com.example.JobManagementSite.model.Company;
import com.example.JobManagementSite.model.JobSeeker;
import com.example.JobManagementSite.model.User;
import com.example.JobManagementSite.model.UserMappingReference;

@RestController
public class UserController {

	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	JobSeekerRepo jobSeekerRepo;
	
	@Autowired
	CompanyRepo companyRepo;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		return userrepo.save(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		 return userrepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id)
	{
		return userrepo.findById(id).orElse(new User());
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable int id, @RequestBody User user)
	{
		User existingUser=userrepo.findById(id).orElse(null);
		existingUser.setUserEmail(user.getUserEmail());
		existingUser.setUserId(user.getUserId());
		existingUser.setUserName(user.getUserName());
		existingUser.setUserPassword(user.getUserPassword());
		existingUser.setUserRole(user.getUserRole());
		userrepo.save(existingUser);
		return existingUser;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id)
	{
		userrepo.findById(id).orElse(null);
		userrepo.deleteById(id);
        return "DELETED";
	}
	
	
	@PostMapping("/usermapping")
	public User postUserMapping(@RequestBody UserMappingReference refmap)
	{
		User existingUser = userrepo.findById(refmap.getUserId()).orElse(new User());
		if (existingUser.getUserId() == refmap.getUserId()) {
			if (existingUser.getUserRole() == "JobSeeker") {
				JobSeeker jobSeeker = jobSeekerRepo.findById(refmap.getRefId()).orElse(new JobSeeker());
				jobSeeker.setUser(existingUser);
				jobSeekerRepo.save(jobSeeker);
			} else if (existingUser.getUserRole() == "Company") {
				Company company = companyRepo.findById(refmap.getRefId()).orElse(new Company());
				company.setUser(existingUser);
				companyRepo.save(company);
			}
		}
		
		return existingUser;
	}
}
