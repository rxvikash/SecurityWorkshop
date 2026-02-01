package com.security.securityWorkshop.Controller;

import com.security.securityWorkshop.Repositery.Employees;
import com.security.securityWorkshop.Repositery.LoginDTO;
import com.security.securityWorkshop.Repositery.RegisterDTO;
import com.security.securityWorkshop.Service.AuthService;
import com.security.securityWorkshop.Service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JWTService jwtService;


    @PostMapping("/register")
    public Employees register(@RequestBody RegisterDTO registerDto) {
        Employees user = authService.register(registerDto);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDto) {
        Employees user = authService.authenticate(loginDto);
        String token = jwtService.generateToken(user);
        return token;
    }
}