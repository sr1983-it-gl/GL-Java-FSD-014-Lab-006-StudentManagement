package com.greatlearning.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentmanagement.StudentAppConstants;
import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		// get Books from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute(
			StudentAppConstants.MODEL_STUDENTS, theStudents);

		return StudentAppConstants.PAGE_LIST;
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
