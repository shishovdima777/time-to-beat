package com.timetobeat.timetobeat.controllers;

import com.timetobeat.timetobeat.dto.requests.CredentialsDTO;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping()
public class AuthController {
    private final UserServiceImpl userService;

    @Autowired
    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/login")
    public String loginPage(@RequestBody CredentialsDTO credentialsDTO) {
        userService.loadUserByUsername(credentialsDTO.getUsername());
        System.out.println(credentialsDTO.getUsername());
        System.out.println(credentialsDTO.getPassword());
        return "it works";
    }
}
