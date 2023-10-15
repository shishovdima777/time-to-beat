package com.timetobeat.timetobeat.repositories;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);
}
