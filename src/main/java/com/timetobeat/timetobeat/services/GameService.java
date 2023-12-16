package com.timetobeat.timetobeat.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GameService {
    private final GamesRepository gamesRepository;
    private final WebClient webClient;
    private final ModelMapper modelMapper;
    @Autowired
    public GameService(GamesRepository gamesRepository, WebClient webClient, ModelMapper modelMapper) {
        this.gamesRepository = gamesRepository;
        this.webClient = webClient;
        this.modelMapper = modelMapper;
    }

    public List<Game> findAll() {
        return gamesRepository.findAll();
    }

    public Game getGame(int id) {
        return gamesRepository.getGameByGameId(id);
    }

    public GameDTO setImageUrl(Game game, GameDTO gameDTO) {
        JsonNode responseJson = webClient
                .post()
                .uri("covers/").accept(MediaType.APPLICATION_JSON)
                .bodyValue("fields alpha_channel,animated,checksum,game,game_localization,height,image_id,url,width;\n" +
                        "where game = " + game.getIgdbId() + ";")
                        .retrieve()
                                .bodyToMono(JsonNode.class)
                                        .block();

        gameDTO.setUrl(responseJson.get(0).get("url").asText());
        return gameDTO;
    }


}
