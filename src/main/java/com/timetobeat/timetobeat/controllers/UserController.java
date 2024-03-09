package com.timetobeat.timetobeat.controllers;

import com.timetobeat.timetobeat.dto.responses.UserDTO;
import com.timetobeat.timetobeat.exceptions.UserNotExistsException;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import com.timetobeat.timetobeat.util.UserNotExistsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, ModelMapper modelMapper) {
        this.userServiceImpl = userServiceImpl;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{username}")
    public UserDTO getUser(@PathVariable String username) {
        try {
            User user = userServiceImpl.getUser(username);
            return convertToUserDto(user);
        } catch (NoSuchElementException e) {
            throw new UserNotExistsException("User " + username + " " + "not exists");
        }
    }

    private UserDTO convertToUserDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<UserNotExistsResponse> handleUserNotExistsException(UserNotExistsException e) {
        UserNotExistsResponse response = new UserNotExistsResponse(e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
