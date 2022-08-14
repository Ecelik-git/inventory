package com.ec.inventorymanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ec.inventorymanager.model.InventoryItem;
import com.ec.inventorymanager.service.InventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/inventoryapp/v1")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<InventoryItem>> getItems(){
		List<InventoryItem> items = inventoryService.getAllItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@PostMapping("/additem")
	public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
		InventoryItem newItem = inventoryService.addItem(item);
		return ResponseEntity.ok(newItem);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<InventoryItem> deleteItem(@PathVariable("id") Long id){
		inventoryService.deleteItem(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<InventoryItem> updateItem(@RequestBody InventoryItem itemDetails, Long id){
		InventoryItem item = inventoryService.getItemById(id);
		item.setId(itemDetails.getId());
		item.setItemName(itemDetails.getItemName());
		item.setSerialNumber(itemDetails.getSerialNumber());
		item.setKind(itemDetails.getKind());
		item.setPurchaseDate(itemDetails.getPurchaseDate());
		item.setPurchaseDate(itemDetails.getPurchaseDate());
		item.setStatus(itemDetails.getStatus());
		item.setAssignedTo(itemDetails.getAssignedTo());
		
		
		InventoryItem updatedItem = inventoryService.updateItem(item, id);
		
		//return ResponseEntity.ok(updatedStudent);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
		
	}
	
	
	

}
