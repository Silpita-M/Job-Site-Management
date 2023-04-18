package com.example.JobManagementSite.controller;

import com.example.JobManagementSite.dao.AppliRepo;
import com.example.JobManagementSite.dao.JobSeekerRepo;
import com.example.JobManagementSite.model.Application;
import com.example.JobManagementSite.model.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    
    @Autowired
    private AppliRepo arepo;

    @PostMapping("/jobseeker")
    public JobSeeker addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerRepo.save(jobSeeker);
    }

    @GetMapping("/jobseekers")
    public List<JobSeeker> findAllJobSeekers() {
        return jobSeekerRepo.findAll();
    }

    @GetMapping("/jobseekers/{id}")
    public JobSeeker findJobSeekerById(@PathVariable int id) {
        JobSeeker jobSeeker = jobSeekerRepo.findById(id).orElse(null);
        return jobSeeker;
    }

    @PutMapping("/jobseekers/{id}")
    public JobSeeker updateJobSeekerById(@PathVariable int id, @RequestBody JobSeeker jobSeeker) {
        JobSeeker existingJobSeeker = jobSeekerRepo.findById(id).orElse(null);
        existingJobSeeker.setFullName(jobSeeker.getFullName());
        existingJobSeeker.setPhoneNumber(jobSeeker.getPhoneNumber());
        existingJobSeeker.setAddress(jobSeeker.getAddress());
        existingJobSeeker.setEducation(jobSeeker.getEducation());
        existingJobSeeker.setMajorSkill(jobSeeker.getMajorSkill());
        jobSeekerRepo.save(existingJobSeeker);
        return existingJobSeeker;
    }

    @DeleteMapping("/jobseekers/{id}")
    public String deleteJobSeekerById(@PathVariable int id) {
        jobSeekerRepo.findById(id).orElse(null);
        jobSeekerRepo.deleteById(id);
        return "DELETED";
    }
    
    @GetMapping("/jobseekers/{id}/applications")
    public List<Application> getApplicationsByJobSeeker(@PathVariable int id)
    {
    	JobSeeker jobSeeker = jobSeekerRepo.findById(id).orElse(new JobSeeker());
    	return arepo.findAllByJobSeeker(jobSeeker);
    }
}
