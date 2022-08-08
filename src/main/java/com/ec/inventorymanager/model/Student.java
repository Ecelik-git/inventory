package com.ec.inventorymanager.model;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="students")
public class Student {

    @Id
    private Long id;
    private String name;
    private String email;
    private String status;
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
        return "Student [email=" + email + ", name=" + name + ", status=" + status + "]";
    }
    
    public Student() {}
    
	public Student(Long id, String name, String email, String status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
	}

    

}
