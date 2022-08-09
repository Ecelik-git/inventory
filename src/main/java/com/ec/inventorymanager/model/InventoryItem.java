package com.ec.inventorymanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class InventoryItem {
	
	@Id
	private Long id;
	private String itemName;
	private String kind;
	private String purchaseDate;
	private String assignedDate;
	private String status;
	private String assignedTo;
	
	public InventoryItem() {}
	
	public InventoryItem(Long id, String itemName, String kind, String purchaseDate, String assignedDate, String status,
			String assignedTo) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.kind = kind;
		this.purchaseDate = purchaseDate;
		this.assignedDate = assignedDate;
		this.status = status;
		this.assignedTo = assignedTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", itemName=" + itemName + ", kind=" + kind + ", purchaseDate="
				+ purchaseDate + ", assignedDate=" + assignedDate + ", status=" + status + ", assignedTo=" + assignedTo
				+ "]";
	}
	
	
	
	
}
