package com.letslearn.models;

import java.util.Hashtable;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ClassRoom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String classTitle;
	private Teacher teacher;
	private Hashtable<Student,Integer> studentGrades;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getClassTitle() {
		return classTitle;
	}
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	public Hashtable<Student,Integer> getStudentGrades() {
		return studentGrades;
	}
	public void setStudentGrades(Hashtable<Student,Integer> studentGrades) {
		this.studentGrades = studentGrades;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
