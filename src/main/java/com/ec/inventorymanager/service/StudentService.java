package com.ec.inventorymanager.service;


import java.util.List;
import com.ec.inventorymanager.model.Student;

public interface StudentService {
	
	
	Student addStudent(Student student);
	
	List<Student> getAllStudents();
	
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student, Long id);
	
	void deleteStudent(Long id);
	

}
