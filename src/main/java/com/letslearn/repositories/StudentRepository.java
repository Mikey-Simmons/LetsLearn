package com.letslearn.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.letslearn.models.Student;

@Repository 
public interface StudentRepository extends CrudRepository<Student, Long> {
	Student findByEmail(String email);
}
