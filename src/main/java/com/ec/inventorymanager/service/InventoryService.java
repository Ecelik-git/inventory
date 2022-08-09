package com.ec.inventorymanager.service;

import java.util.List;

import com.ec.inventorymanager.model.InventoryItem;

public interface InventoryService {
	
	
	InventoryItem addItem(InventoryItem item);
	
	List<InventoryItem> getAllItems();
	
	InventoryItem getItemById(Long id);
	
	InventoryItem updateItem(InventoryItem item, Long id);
	
	void deleteItem(Long id);

}
