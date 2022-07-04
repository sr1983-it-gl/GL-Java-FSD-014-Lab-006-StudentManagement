package com.greatlearning.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.studentmanagement.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student thestudent);

	public void deleteById(int theId);

}
