package com.ec.inventorymanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ec.inventorymanager.exception.InventoryNotFoundException;
import com.ec.inventorymanager.model.InventoryItem;
import com.ec.inventorymanager.repository.InventoryRepository;

public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	public InventoryItem addItem(InventoryItem item) {
		return inventoryRepository.save(item);
	}
	
	public List<InventoryItem> findAllItems(){
		return inventoryRepository.findAll();
	}
	
	public InventoryItem updateItem(InventoryItem item) {
		return inventoryRepository.save(item);
	
	}
	
	public InventoryItem findItemById(Long id) {
		return inventoryRepository.findInventoryById(id)
				.orElseThrow(() -> new InventoryNotFoundException ("Item by id "+id+" was not found"));
	}
	
	public void deleteStudent(Long id) {
		inventoryRepository.deleteInventoryById(id);
		
	}

}
