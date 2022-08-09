package com.ec.inventorymanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ec.inventorymanager.model.InventoryItem;

public interface InventoryRepository extends MongoRepository<InventoryItem, Long>{
	

}
