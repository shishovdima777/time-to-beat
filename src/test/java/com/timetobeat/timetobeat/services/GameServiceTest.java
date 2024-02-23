package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GamesRepository gamesRepository;
    @Mock
    private WebClient webClient;
    private List<Game> games;
    private GameService gameService;
    @BeforeEach
    public void initService() {
        gameService = new GameService(gamesRepository, webClient);
    }
    @BeforeEach
    public void prepareTestData() {
        games = new ArrayList<>();
        Random random = new Random();
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        game1.setIgdbId(9999);
        game2.setIgdbId(123);
        game3.setIgdbId(1056);
        games.add(game1);
        games.add(game2);
        games.add(game3);
    }
    @Test
    public void testGetIgdbIds() {
        String resultString = gameService.getIgdbIds(games);

        Assertions.assertNotNull(resultString);
        Assertions.assertEquals("9999, 123, 1056", resultString);
    }
}
