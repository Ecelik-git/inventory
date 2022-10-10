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

import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.service.StudentService;



@RestController
@CrossOrigin
@RequestMapping("/studentapp/v1")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		 
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
		
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PostMapping("/addastudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
//	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		try {
		    Student newStudent = studentService.addStudent(student);
		    return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
//	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetail, Long id){
		Student student = studentService.getStudentById(id);
		student.setName(studentDetail.getName());
		student.setId(studentDetail.getId());
		student.setEmail(studentDetail.getEmail());
		student.setStatus(studentDetail.getStatus());
		
		Student updatedStudent = studentService.updateStudent(student, id);
		
		//return ResponseEntity.ok(updatedStudent);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
}
