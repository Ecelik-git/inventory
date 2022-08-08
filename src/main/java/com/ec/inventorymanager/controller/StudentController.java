package com.ec.inventorymanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.inventorymanager.exception.UserNotFoundException;
import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.repository.StudentRepository;



@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/app/v1")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		 
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
		
	}
	
//	@GetMapping("/students/{id}")
//	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
//		Student student = studentService.findStudentById(id);
//		return new ResponseEntity<>(student, HttpStatus.OK);
//	}
	
	@PostMapping("/addastudent")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
//	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		try {
		    Student newStudent = studentRepository.save(new Student(student.getId(), student.getName(), student.getEmail(), student.getStatus()));
		    return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
//	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetail, Long id){
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Student not exist with id: "+id));
		student.setName(studentDetail.getName());
		student.setId(studentDetail.getId());
		student.setEmail(studentDetail.getEmail());
		student.setStatus(studentDetail.getStatus());
		
		Student updatedStudent = studentRepository.save(student);
		
		//return ResponseEntity.ok(updatedStudent);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
		studentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
