package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.dto.GameFullDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.Comparator;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping()
public class GameController {
    private final GameService gameService;
    private final ModelMapper modelMapper;
    @Autowired
    public GameController(GameService gameService, ModelMapper modelMapper) {
        this.gameService = gameService;
        this.modelMapper = modelMapper;
    }
    @GetMapping()
    public Mono<List<GameDTO>> getAllGames() {
        List<Game> gameList = gameService.findAll();
        String igdbIds = gameService.getIgdbIds(gameList);
        List<GameDTO> gameDTOList = gameList.stream().map(this::convertToGameDto).sorted(Comparator.comparingInt(GameDTO::getIgdbId)).toList();
        return gameService.setImage(gameDTOList, igdbIds);
    }
    @GetMapping("game/{id}")
    public Mono<GameFullDTO> getGame(@PathVariable int id) {
        GameDTO gameDTO = convertToGameDto(gameService.getGame(id));
        return gameService.getGame(gameDTO);
    }
    private GameDTO convertToGameDto(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}
