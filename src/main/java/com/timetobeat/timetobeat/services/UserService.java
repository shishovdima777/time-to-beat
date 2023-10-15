package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UsersRepository usersRepository;
    private final GamesRepository gamesRepository;
    @Autowired
    public UserService(UsersRepository usersRepository, GamesRepository gamesRepository) {
        this.usersRepository = usersRepository;
        this.gamesRepository = gamesRepository;
    }

    public User getUser(String username) {
        List<Game> gameList = gamesRepository.findByUsername(username);
        User user = usersRepository.getUserByUsername(username);
        user.setGames(gameList);
        return usersRepository.getUserByUsername(user.getUsername());
    }
}
