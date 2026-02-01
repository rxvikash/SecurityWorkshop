package com.security.securityWorkshop.Service;

import com.security.securityWorkshop.Repositery.EmployeeRepo;
import com.security.securityWorkshop.Repositery.Employees;
import com.security.securityWorkshop.Repositery.LoginDTO;
import com.security.securityWorkshop.Repositery.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AuthService {

    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    public Employees register(RegisterDTO input) {
        Employees user = new Employees();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());
        return repo.save(user);
    }

    public Employees authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
        );
        return repo.findByEmail(input.getEmail());
    }
}