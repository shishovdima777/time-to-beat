package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.responses.GameDTO;
import com.timetobeat.timetobeat.dto.responses.GameFullDTO;
import com.timetobeat.timetobeat.dto.requests.TimeDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.serviceImpls.GameServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping()
public class GameController {
    private final GameServiceImpl gameServiceImpl;
    private final ModelMapper modelMapper;
    @Autowired
    public GameController(GameServiceImpl gameServiceImpl, ModelMapper modelMapper) {
        this.gameServiceImpl = gameServiceImpl;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<GameDTO> getAllGames() {
        return gameServiceImpl.retrieveGames();
    }
    @GetMapping("game/{id}")
    public Mono<GameFullDTO> getGame(@PathVariable int id) {
        GameDTO gameDTO = convertToGameDto(gameServiceImpl.getGame(id));
        return gameServiceImpl.getGame(gameDTO);
    }
    @PatchMapping ("game/{id}")
    public String updateTime(@PathVariable("id") int id, @RequestBody TimeDTO timeDTO){
        gameServiceImpl.updateTime(gameServiceImpl.getGame(id), timeDTO);
        return "redirect:/game/{id}";
    }
    private GameDTO convertToGameDto(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}
