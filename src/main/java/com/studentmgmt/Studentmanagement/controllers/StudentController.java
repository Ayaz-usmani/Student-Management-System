package com.studentmgmt.Studentmanagement.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.studentmgmt.Studentmanagement.models.Student;
import com.studentmgmt.Studentmanagement.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public ModelAndView getStudents() {
		String view = "students";
		
		Map<String, List<Student>> model = new HashMap<String, List<Student>>();
		
		model.put("studentList", service.getAllStudents());
		
		return new ModelAndView(view, model);
	}
	
	@GetMapping("/addStudentForm")
	public ModelAndView getInsertForm() {
		String view = "insertStudent";
		Map<String, Student> model = new HashMap<String, Student>();
		
		model.put("student", new Student());
		return new ModelAndView(view,model);
	}
	
	@GetMapping("/updateStudent")
	public ModelAndView showUpdateForm(@RequestParam(name = "id") int id) {
		Student student = service.getStudentById(id);
		service.updateStudent(student);
		
		String view  = "editStudent";
		
		Map<String, Student> model = new HashMap<String, Student>();
		
		model.put("student", student);
		
		return new ModelAndView(view,model);
	}
	
	
	
	@PostMapping("/addStudentForm")
	public ModelAndView addNewStudent(Student student) {
		service.addNewStudent(student);
		
		RedirectView view = new RedirectView();
		view.setUrl("/");
		System.out.println(student);
		
		return new ModelAndView(view);
		
	}
	
	@PostMapping("/updateStudent")
	public ModelAndView updateStudent(Student student) {
		service.updateStudent(student);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");
		
		return new ModelAndView(redirectView);
	}
	
	@GetMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam(name = "id") int id) {
		service.deleteStudentById(id);
		System.out.println("DEleted id: " + id);
		return new ModelAndView(new RedirectView("/"));
	}
}
