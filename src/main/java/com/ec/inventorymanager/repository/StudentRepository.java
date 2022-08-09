package com.ec.inventorymanager.repository;

import com.ec.inventorymanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Long>{

}
