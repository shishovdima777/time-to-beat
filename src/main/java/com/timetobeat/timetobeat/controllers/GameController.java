package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.dto.GameFullDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.serviceImpls.GameServiceImpl;
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
    private final GameServiceImpl gameServiceImpl;
    private final ModelMapper modelMapper;
    @Autowired
    public GameController(GameServiceImpl gameServiceImpl, ModelMapper modelMapper) {
        this.gameServiceImpl = gameServiceImpl;
        this.modelMapper = modelMapper;
    }
    @GetMapping()
    public Mono<List<GameDTO>> getAllGames() {
        List<Game> gameList = gameServiceImpl.findAll();
        String igdbIds = gameServiceImpl.getIgdbIds(gameList);
        List<GameDTO> gameDTOList = gameList.stream().map(this::convertToGameDto).sorted(Comparator.comparingInt(GameDTO::getIgdbId)).toList();
        return gameServiceImpl.setImage(gameDTOList, igdbIds);
    }
    @GetMapping("game/{id}")
    public Mono<GameFullDTO> getGame(@PathVariable int id) {
        GameDTO gameDTO = convertToGameDto(gameServiceImpl.getGame(id));
        return gameServiceImpl.getGame(gameDTO);
    }
    @PatchMapping ("game/{id}")
    public String updateTime(@PathVariable("id") int id, @RequestBody GameDTO gameDTO){
        gameServiceImpl.updateTime(gameServiceImpl.getGame(id), gameDTO);
        return "redirect:/game/{id}";
    }
    private GameDTO convertToGameDto(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}
