package com.timetobeat.timetobeat.controllers;
import com.timetobeat.timetobeat.dto.requests.CredentialsDTO;
import com.timetobeat.timetobeat.exceptions.RegistrationNotPerformedException;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import com.timetobeat.timetobeat.util.CredentialsValidator;
import com.timetobeat.timetobeat.util.RegistrationNotPerformedResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<HttpStatus> performRegistration(@RequestBody CredentialsDTO credentialsDTO,
                                                          BindingResult bindingResult) {
        credentialsValidator.validate(credentialsDTO, bindingResult);

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError e: errorList) {
                errorMap.put(e.getField(), e.getDefaultMessage());
            }

          throw new RegistrationNotPerformedException(errorMap);
        }

        userService.saveUser(convertToUser(credentialsDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<RegistrationNotPerformedResponse> handleException(RegistrationNotPerformedException e) {
        RegistrationNotPerformedResponse response = new RegistrationNotPerformedResponse(
                e.getErrorMap(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public User convertToUser(CredentialsDTO credentialsDTO) {
        return modelMapper.map(credentialsDTO, User.class);
    }
}
