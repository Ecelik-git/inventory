package com.ec.inventorymanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ec.inventorymanager.service.InventoryService;
import com.ec.inventorymanager.exception.InventoryNotFoundException;
import com.ec.inventorymanager.model.InventoryItem;
import com.ec.inventorymanager.repository.InventoryRepository;

@Service

public class InventoryServiceImpl implements InventoryService {
	
	private InventoryRepository inventoryRepository;
	
	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public InventoryItem addItem(InventoryItem item) {
		return inventoryRepository.save(item);
	}

	@Override
	public List<InventoryItem> getAllItems() {
		return inventoryRepository.findAll();
	}

	@Override
	public InventoryItem getItemById(Long id) {
		return inventoryRepository.findById(id).
				orElseThrow(() -> new InventoryNotFoundException("Item with "+id+" not found"));
	}

	@Override
	public InventoryItem updateItem(InventoryItem item, Long id) {
		InventoryItem existingItem =inventoryRepository.findById(id).orElseThrow(
				()-> new InventoryNotFoundException("Item with "+id+" not found"));
		
		existingItem.setId(item.getId());
		existingItem.setItemName(item.getItemName());
		existingItem.setSerialNumber(item.getSerialNumber());
		existingItem.setKind(item.getKind());
		existingItem.setKind(item.getKind());
		existingItem.setPurchaseDate(item.getPurchaseDate());
		existingItem.setAssignedDate(item.getAssignedDate());
		existingItem.setStatus(item.getStatus());
		existingItem.setAssignedTo(item.getAssignedTo());
		//save existing emp to DB
		
		inventoryRepository.save(existingItem);
		return existingItem;
	}

	@Override
	public void deleteItem(Long id) {
		inventoryRepository.findById(id).orElseThrow(
				()->new InventoryNotFoundException("Item with "+id+" not found"));
		inventoryRepository.deleteById(id);
		
	}


}
