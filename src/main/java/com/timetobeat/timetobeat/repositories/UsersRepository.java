package com.timetobeat.timetobeat.repositories;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findUserByUsername(String username);
    @Override
    <S extends User> S save(S entity);
}
