package com.timetobeat.timetobeat.controllers;

import com.timetobeat.timetobeat.dto.UserDTO;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{username}")
    UserDTO getUser(@PathVariable String username) {
        return convertToUserDto(userService.getUser(username));
    }

    private UserDTO convertToUserDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
