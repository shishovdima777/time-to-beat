package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GameService {
    private final GamesRepository gamesRepository;
    @Autowired
    public GameService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public List<Game> findAll() {
        return gamesRepository.findAll();
    }

    public Game getGame(int id) {
        return gamesRepository.getGameByGameId(id);
    }


}
