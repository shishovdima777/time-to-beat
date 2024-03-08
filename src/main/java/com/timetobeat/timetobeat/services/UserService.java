package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.models.User;

public interface UserService {
    User getUser(String username);
    void saveUser(User user);
}
