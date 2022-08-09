package com.letslearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.letslearn.models.Student;

@SpringBootApplication
public class LetsLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsLearnApplication.class, args);
		
		Student bob = new Student();
		bob.setEmail("bob@email.com");
		bob.setName("bob");
		bob.setPassword("12345678");
		bob.setPhoneNumber("2060001234");
		bob.setPasswordConfirmation("12345678");
		
		
	}

}
