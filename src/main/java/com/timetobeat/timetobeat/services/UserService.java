package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.models.User;

import java.util.Optional;

public interface UserService {
    User getUser(String username);
    void saveUser(User user);
}
