package com.ec.inventorymanager.config;

import com.ec.inventorymanager.controller.StudentController;
import com.ec.inventorymanager.model.Student;
import com.ec.inventorymanager.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfig {

    @Bean
    public StudentController studentController(){
        return new StudentController();
    }


}
