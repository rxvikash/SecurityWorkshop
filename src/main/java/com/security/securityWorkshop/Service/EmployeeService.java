package com.security.securityWorkshop.Service;

import com.security.securityWorkshop.Repositery.EmployeeRepo;
import com.security.securityWorkshop.Repositery.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    // Field, Constructor, Setter
    @Autowired
    private EmployeeRepo repo;


    public List<Employees> getAllEmployees() {
        return repo.findAll();
    }
}
