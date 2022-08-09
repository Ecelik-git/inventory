package com.ec.inventorymanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ec.inventorymanager.exception.UserNotFoundException;
import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.repository.StudentRepository;
import com.ec.inventorymanager.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).
				orElseThrow(() -> new UserNotFoundException("Student with "+id+" not found"));
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				()-> new UserNotFoundException("Student with "+id+" not found"));
		
		existingStudent.setId(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setStatus(student.getStatus());
		
		//save existing emp to DB
		
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.findById(id).orElseThrow(
				()->new UserNotFoundException("Student with "+id+" not found"));
		studentRepository.deleteById(id);
		
	}

}
