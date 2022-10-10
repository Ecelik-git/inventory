package com.ec.inventorymanager.controller;

import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.repository.StudentRepository;
import com.ec.inventorymanager.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Autowired
    StudentService studentService;

    @Test
    @Order(1)
    public void saveStudentTest(){
        Student student = new Student(12341L, "Ahmet Sahin", "asahin@gmail.org", "Not Assigned");
        studentService.addStudent(student);
        assertNotNull(studentService.getStudentById(12341L));

    }

    @Test
    @Order(2)
    public void saveStudentTest1(){
        Student student = new Student(12341L, "Ahmet Sahin", "asahin@gmail.org", "Not Assigned");
        studentService.addStudent(student);
        assertNotNull(studentService.getStudentById(123L), "please insert an object");

    }

    @Test
    @Order(3)
    public void getStudentByIdTest(){
        Student student = new Student(12341L, "Ahmet Sahin", "asahin@gmail.org", "Not Assigned");
        studentService.addStudent(student);
        //long expected = 12341L;
        assertNotNull(studentService.getStudentById(student.getId()));
    }


}

