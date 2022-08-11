package com.letslearn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.letslearn.models.Student;

@Component
public class StudentValidator implements Validator {
	//1
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}
	//2
	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		if(!student.getPasswordConfirmation().equals(student.getPassword())) {
			errors.rejectValue("passwordConfirmation","Match");
		}
	}
}
