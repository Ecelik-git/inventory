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
import com.ec.inventorymanager.model.Faculty;
import com.ec.inventorymanager.repository.FacultyRepository;



@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/facultyapp/v1")
public class FacultyController {
	
	@Autowired
	FacultyRepository facultyRepository;
	
	
	@GetMapping("/all-faculty")
	public ResponseEntity<List<Faculty>> getAllFaculty(){
		 
		List<Faculty> allFaculty = facultyRepository.findAll();
		return new ResponseEntity<>(allFaculty, HttpStatus.OK);
		
	}
	
//	@GetMapping("/students/{id}")
//	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
//		Student student = studentService.findStudentById(id);
//		return new ResponseEntity<>(student, HttpStatus.OK);
//	}
	
	@PostMapping("/add-faculty")
	public Faculty createFaculty(@RequestBody Faculty faculty) {
		return facultyRepository.save(faculty);
	}
//	
	@PostMapping("/add-a-faculty")
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
		try {
		    Faculty newFaculty = facultyRepository.
		    		save(new Faculty(faculty.getId(), faculty.getName(), faculty.getEmail(), faculty.getStatus(), faculty.getDepartment()));
		    return new ResponseEntity<>(newFaculty, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
//	
	@PutMapping("/update/{id}")
	public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty facultyDetail, Long id){
		Faculty faculty = facultyRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Faculty not exist with id: "+id));
		faculty.setName(facultyDetail.getName());
		faculty.setId(facultyDetail.getId());
		faculty.setEmail(facultyDetail.getEmail());
		faculty.setStatus(facultyDetail.getStatus());
		faculty.setDepartment(facultyDetail.getDepartment());
		
		
		
		Faculty updatedFaculty = facultyRepository.save(faculty);
		
		//return ResponseEntity.ok(updatedStudent);
		return new ResponseEntity<>(updatedFaculty, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Faculty> deleteStudent(@PathVariable("id") Long id){
		facultyRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
