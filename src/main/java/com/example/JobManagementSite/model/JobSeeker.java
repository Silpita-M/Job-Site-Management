package com.example.JobManagementSite.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="JobSeeker")
public class JobSeeker {

	@Id
	@GeneratedValue
	private int jobSeekerId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(nullable=false)
	private String fullName;
	
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String education;
	
	@Column(nullable=false)
	private String majorSkill;

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMajorSkill() {
		return majorSkill;
	}

	public void setMajorSkill(String majorSkill) {
		this.majorSkill = majorSkill;
	}
	
	
	
}
