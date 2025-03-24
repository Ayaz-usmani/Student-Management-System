package com.studentmgmt.Studentmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmt.Studentmanagement.models.Student;
import com.studentmgmt.Studentmanagement.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}
	
	public boolean addNewStudent(Student student) {
		studentRepo.save(student);
		return true;
	}
	
	public void updateStudent(Student student) {
		
		System.out.println("Student is: " + student);
		Integer id = student.getId();
		System.out.println();
		System.out.println(id);
		System.out.println();
		Student studentToBeUpdated = getStudentById(id);
		
		studentToBeUpdated.setName(student.getName());
		studentToBeUpdated.setEmail(student.getEmail());
		studentToBeUpdated.setPhone(student.getPhone());
		studentToBeUpdated.setGender(student.getGender());
		
		studentRepo.save(studentToBeUpdated);
	}
	
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
	}

}
