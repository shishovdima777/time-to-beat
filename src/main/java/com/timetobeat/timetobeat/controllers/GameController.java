package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


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
    public List<GameDTO> getAllGames() {
        List<GameDTO> gameDTOList = gameService.findAll().stream().map(this::convertToGameDto).toList(); // TODO 1.
        return gameDTOList;
    }
    @GetMapping("game/{id}")
    public GameDTO getGame(@PathVariable int id) {
        return convertToGameDto(gameService.getGame(id));
    }
    private GameDTO convertToGameDto(Game game) {
        GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
        return gameService.setImageUrl(game, gameDTO);
    }
}
