package com.ec.inventorymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	public InventoryController(InventoryService inventoryService) {
//		super();
//		this.inventoryService = inventoryService;
//	}
	
	@GetMapping("/items")
	public ResponseEntity<List<InventoryItem>> getItems(){
		List<InventoryItem> items = inventoryService.getAllItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@PostMapping("/additem")
	public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
		InventoryItem newItem = inventoryService.
				addItem(new InventoryItem(item.getId(), item.getAssignedDate(), 
						item.getAssignedTo(), item.getItemName(), item.getPurchaseDate(), 
						item.getKind(), item.getStatus()));
		return new ResponseEntity<>(newItem, HttpStatus.CREATED);
		
		
	}
	
	
	
	

}
