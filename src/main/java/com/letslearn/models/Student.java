package com.letslearn.models;

import java.util.Hashtable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Email(message="Must be a valid email")
	private String email;
	private int phoneNumber;
	private String name;
	
	@Size(min=5,message="Password must be greater than 5 characters")
	private String password;
	@Transient
    private String passwordConfirmation;
	private Hashtable<ClassRoom,Integer> studentGrades;
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hashtable<ClassRoom,Integer> getStudentGrades() {
		return studentGrades;
	}
	public void setStudentGrades(Hashtable<ClassRoom,Integer> studentGrades) {
		this.studentGrades = studentGrades;
	} 
	
}
