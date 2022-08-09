package com.ec.inventorymanager.repository;

import com.ec.inventorymanager.model.Faculty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacultyRepository extends MongoRepository<Faculty, Long>{
    

}
