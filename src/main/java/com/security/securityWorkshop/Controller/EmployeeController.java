package com.security.securityWorkshop.Controller;

import com.security.securityWorkshop.Repositery.Employees;
import com.security.securityWorkshop.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getEmployees() {
        return "List of Tech Amplifiers' Employees";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/employees/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employees> getAllEmployees() {
        return service.getAllEmployees();
    }
}
