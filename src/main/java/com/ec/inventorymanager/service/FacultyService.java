package com.ec.inventorymanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.inventorymanager.exception.UserNotFoundException;
import com.ec.inventorymanager.model.Faculty;
import com.ec.inventorymanager.repository.FacultyRepository;

public class FacultyService {
	
	private final FacultyRepository facultyRepository;
	
	@Autowired
	public FacultyService(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}
	
	public Faculty addFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
	
	public List<Faculty> findAllStaff(){
		return facultyRepository.findAll();
	}
	
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	
	}
	
	public Faculty findStaffById(Long id) {
		return facultyRepository.findFacultyById(id)
				.orElseThrow(() -> new UserNotFoundException ("User by id "+id+" was not found"));
	}
	
	public void deleteStudent(Long id) {
		facultyRepository.deleteFacultyById(id);
		
	}

}
