package com.studentmgmt.Studentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmgmt.Studentmanagement.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
