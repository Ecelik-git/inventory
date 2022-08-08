package com.ec.inventorymanager.repository;

import com.ec.inventorymanager.model.Student;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long>{

	void deleteStudentById(Long id);

	Optional<Student> findStudentById(Long id);
    

}
