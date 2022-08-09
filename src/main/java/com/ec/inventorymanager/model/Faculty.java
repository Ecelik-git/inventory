package com.ec.inventorymanager.model;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="faculty")
public class Faculty {

    @Id
    private Long id;
    private String name;
    private String email;
    private String status;
    private String department;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Student [email=" + email + ", name=" + name + ", status=" + status + ", department=" + department + "]";
    }
    
    public Faculty() {}
    
	public Faculty(Long id, String name, String email, String status, String department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

    

}
