package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
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
        return gameService.findAll().stream().map(this::convertToGameDto).toList();
    }
    @GetMapping("game/{id}")
    public GameDTO getGame(@PathVariable int id) {
        return convertToGameDto(gameService.getGame(id));
    }
    private GameDTO convertToGameDto(Game game) {
       return modelMapper.map(game, GameDTO.class);
    }
}
