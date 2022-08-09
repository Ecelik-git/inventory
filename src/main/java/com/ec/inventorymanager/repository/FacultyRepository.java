package com.ec.inventorymanager.repository;

import com.ec.inventorymanager.model.Faculty;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends MongoRepository<Faculty, Long>{

	void deleteFacultyById(Long id);

	Optional<Faculty> findFacultyById(Long id);
    

}
