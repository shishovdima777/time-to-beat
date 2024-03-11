package com.timetobeat.timetobeat.controllers;
import com.timetobeat.timetobeat.dto.requests.CredentialsDTO;
import com.timetobeat.timetobeat.dto.requests.RegistrationDataDTO;
import com.timetobeat.timetobeat.dto.responses.LoginResponseDTO;
import com.timetobeat.timetobeat.dto.responses.RegistrationResponseDTO;
import com.timetobeat.timetobeat.exceptions.RegistrationNotPerformedException;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.security.JWTAuth;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import com.timetobeat.timetobeat.util.RegistrationValidator;
import com.timetobeat.timetobeat.util.RegistrationNotPerformedResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final RegistrationValidator registrationValidator;
    private final JWTAuth jwtAuth;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserServiceImpl userService, ModelMapper modelMapper,
                          RegistrationValidator registrationValidator, JWTAuth jwtAuth,
                          AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.registrationValidator = registrationValidator;
        this.jwtAuth = jwtAuth;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody CredentialsDTO credentialsDTO) {
        User user = convertToUser(credentialsDTO);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtAuth.generateToken(user.getUsername());

        return new LoginResponseDTO(token, "User successfully logged in", user.getUsername());
    }

    @PostMapping("/registration")
    public RegistrationResponseDTO performRegistration(@RequestBody @Valid RegistrationDataDTO registrationDataDTO,
                                                       BindingResult bindingResult) {
        registrationValidator.validate(registrationDataDTO, bindingResult);

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError e: errorList) {
                errorMap.put(e.getField(), e.getDefaultMessage());
            }

          throw new RegistrationNotPerformedException(errorMap);
        }
        User user = convertToUser(registrationDataDTO);

        userService.saveUser(user);
        String token = jwtAuth.generateToken(user.getUsername());

        return new RegistrationResponseDTO(token);
    }

    private User convertToUser(RegistrationDataDTO registrationDataDTO) {
        return modelMapper.map(registrationDataDTO, User.class);
    }

    private User convertToUser(CredentialsDTO credentialsDTO) {
        return modelMapper.map(credentialsDTO, User.class);
    }
}
