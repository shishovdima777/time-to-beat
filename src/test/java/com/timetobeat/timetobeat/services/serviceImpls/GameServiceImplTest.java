package com.timetobeat.timetobeat.services.serviceImpls;

import com.timetobeat.timetobeat.dto.requests.TimeDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.services.serviceImpls.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {
    private int currentAvgHours;
    private int currentAvgMinutes;
    private int addedHours;
    private int addMinutes;
    @Mock
    private GamesRepository gamesRepository;
    @Mock
    private WebClient webClient;
    private List<Game> games;
    private GameServiceImpl gameServiceImpl;
    @BeforeEach
    public void initService() {
        gameServiceImpl = new GameServiceImpl(gamesRepository, webClient);
    }
    @BeforeEach
    public void prepareTestData() {
        prepareTestDataForTestGetIgdbIds();
        prepareTestDataForTestAvgTime();
    }

    private void prepareTestDataForTestGetIgdbIds() {
        games = new ArrayList<>();
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

    private void prepareTestDataForTestAvgTime() {
        this.currentAvgHours = 75;
        this.currentAvgMinutes = 30;
        this.addedHours = 100;
        this.addMinutes = 10;
    }

    @Test
    public void testGetIgdbIds() {
        String resultString = gameServiceImpl.getIgdbIds(games);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals("9999, 123, 1056", resultString);
    }
    @Test
    public void testAvgTime() {
        List<Integer> list = gameServiceImpl.avgTime(currentAvgHours, currentAvgMinutes, addedHours, addMinutes);
        Assertions.assertNotNull(list);
        Assertions.assertInstanceOf(Integer.class, list.get(0));
        Assertions.assertInstanceOf(Integer.class, list.get(1));
        Assertions.assertEquals(87, list.get(0));
        Assertions.assertEquals(50, list.get(1));
    }
}
