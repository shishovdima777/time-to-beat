package com.timetobeat.timetobeat.controllers;


import com.timetobeat.timetobeat.dto.responses.GameDTO;
import com.timetobeat.timetobeat.dto.responses.GameFullDTO;
import com.timetobeat.timetobeat.dto.requests.TimeDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.services.serviceImpls.GameServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/game")
public class GameController {
    private final GameServiceImpl gameServiceImpl;

    @Autowired
    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @GetMapping()
    public List<GameDTO> getAllGames() {
        return gameServiceImpl.retrieveGames();
    }
    @GetMapping("/findByName")
    public List<Game> getByName(@RequestParam String name) {
        return gameServiceImpl.findAllByName(name);
    }

    @GetMapping("/{id}")
    public GameFullDTO getGame(@PathVariable int id) {
        return gameServiceImpl.getGame(gameServiceImpl.getGame(id));
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<HttpStatus> updateTime(@PathVariable("id") int id,
                                                 @RequestBody TimeDTO timeDTO){
        gameServiceImpl.updateTime(gameServiceImpl.getGame(id), timeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
