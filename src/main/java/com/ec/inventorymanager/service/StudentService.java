package com.ec.inventorymanager.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.inventorymanager.exception.UserNotFoundException;
import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student addStudent(Student student) {

		return studentRepository.save(student);
		
	}
	
	public List<Student> findAllStudent(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	
	}
	
	public Student findStudentById(Long id) {
		return studentRepository.findStudentById(id)
				.orElseThrow(() -> new UserNotFoundException ("User by id "+id+" was not found"));
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteStudentById(id);
		
	}
	

}
