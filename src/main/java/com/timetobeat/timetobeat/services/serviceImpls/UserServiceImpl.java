package com.timetobeat.timetobeat.services.serviceImpls;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.models.User;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.repositories.UsersRepository;
import com.timetobeat.timetobeat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final GamesRepository gamesRepository;
    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, GamesRepository gamesRepository) {
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
