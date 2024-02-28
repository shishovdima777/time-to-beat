package com.timetobeat.timetobeat.controllers;

import com.timetobeat.timetobeat.dto.responses.UserDTO;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    UserDTO getUser(@PathVariable String username) {
        return convertToUserDto(userServiceImpl.getUser(username));
    }

    private UserDTO convertToUserDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
