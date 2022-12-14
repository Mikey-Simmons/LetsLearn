package com.letslearn.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.letslearn.models.Student;
import com.letslearn.services.StudentService;
import com.letslearn.validator.StudentValidator;
@SuppressWarnings("unused")
@Controller

public class StudentController {
	private final StudentService studentService;
	private final StudentValidator studentValidator;
	public StudentController(StudentService studentService,StudentValidator studentValidator) {
		this.studentService=studentService;
		this.studentValidator = new StudentValidator();
	}
	
@RequestMapping("/")
public String index() {
	return "index.jsp";
}
@RequestMapping("/home")
public String home() {
	return "home.jsp";
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public String loginStudent(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	boolean isAuthenticated = studentService.authenticateStudent(email, password);
	if(isAuthenticated) {
		Student u = studentService.findByEmail(email);
		session.setAttribute("studentId", u.getId());
		return "redirect:/home";
	}
	else {
		model.addAttribute("error", "Email/Password is incorrect.  Please register if you do not have an account.");
		return "index.jsp";	
	}
}
@RequestMapping(value="/registration", method=RequestMethod.POST)
public String registerUser(@Valid @ModelAttribute("student") Student student, BindingResult result, HttpSession session) {
	studentValidator.validate(student, result);
	if(result.hasErrors()) {
		return "registrationPage.jsp";
	}
	Student u = studentService.registerStudent(student);
	session.setAttribute("id", u.getId());
	return "redirect:/home";
}
}
