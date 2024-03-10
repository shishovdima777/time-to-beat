package com.timetobeat.timetobeat.services;

import com.timetobeat.timetobeat.dto.responses.GameDTO;
import com.timetobeat.timetobeat.dto.responses.GameFullDTO;
import com.timetobeat.timetobeat.dto.responses.GameImageDTO;
import com.timetobeat.timetobeat.dto.requests.TimeDTO;
import com.timetobeat.timetobeat.models.Game;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GameService {
    List<Game> findAll();
    Game getGame(int id);
    void updateTime(Game game, TimeDTO timeDTO);
    void updateMainStoryTime(Game game, List<Integer> time);
    void updateMainStoryExtraTime(Game game, List<Integer> time);
    void updateCompletionistTime(Game game, List<Integer> time);
    List<Integer> avgTime(int currentAvgHours, int currentAvgMinutes, int inputHours, int inputMinutes);
    String getIgdbIds(List<Game> games);
    List<GameDTO> tieUrls(List<GameDTO> list1, List<GameImageDTO> list2);
    List<GameImageDTO> getGamesImages(String igdbIds);
    List<GameDTO> setImage(List<GameDTO> gameDTOList, String igdbIds);
    Mono<GameFullDTO> getGame(GameDTO gameDTO);
}
