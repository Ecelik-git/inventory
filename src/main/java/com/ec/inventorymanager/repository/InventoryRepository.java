package com.ec.inventorymanager.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ec.inventorymanager.model.InventoryItem;

public interface InventoryRepository extends MongoRepository<InventoryItem, Long>{
	
	void deleteInventoryById(Long id);

	Optional<InventoryItem> findInventoryById(Long id);

}
