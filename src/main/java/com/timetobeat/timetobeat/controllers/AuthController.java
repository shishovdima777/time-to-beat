package com.timetobeat.timetobeat.controllers;
import com.timetobeat.timetobeat.dto.requests.CredentialsDTO;
import com.timetobeat.timetobeat.exceptions.RegistrationNotPerformedException;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import com.timetobeat.timetobeat.util.CredentialsValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;
    private final CredentialsValidator credentialsValidator;

    @Autowired
    public AuthController(UserServiceImpl userService, ModelMapper modelMapper, CredentialsValidator credentialsValidator) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.credentialsValidator = credentialsValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> performRegistration(@RequestBody CredentialsDTO credentialsDTO, BindingResult bindingResult) {
        credentialsValidator.validate(credentialsDTO, bindingResult);

        if(bindingResult.hasErrors()) {
          throw new RegistrationNotPerformedException("User registration was not performed");
        }

        userService.saveUser(convertToUser(credentialsDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public User convertToUser(CredentialsDTO credentialsDTO) {
        return modelMapper.map(credentialsDTO, User.class);
    }
}
