package com.letslearn.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.stereotype.Service;

import com.letslearn.models.Student;
import com.letslearn.repositories.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	// register student and hash password
	public Student registerStudent(Student student) {
		String hashed = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()); 
		student.setPassword(hashed);
		return studentRepository.save(student);
	}
	//find by student by email
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	public Student findStudentById(long id) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
		
	}
	//authenticate student
	public boolean authenticateStudent(String email, String password) {
		//first find student by email
		Student student = studentRepository.findByEmail(email);
		//if email is not found it will return false
		if(student==null) {
			return false;
		}else {
			//if passwords match return true otherwise it will return false
			if (BCrypt.checkpw( password, student.getPassword())){
				return true;
			}
			else {
				return false;
				
			}
		}
	}
}
