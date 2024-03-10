package com.timetobeat.timetobeat.services.serviceImpls;
import com.timetobeat.timetobeat.dto.responses.GameDTO;
import com.timetobeat.timetobeat.dto.responses.GameFullDTO;
import com.timetobeat.timetobeat.dto.responses.GameImageDTO;
import com.timetobeat.timetobeat.dto.requests.TimeDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.exceptions.IgdbIdException;
import com.timetobeat.timetobeat.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class GameServiceImpl implements GameService {
    private final GamesRepository gamesRepository;
    private final WebClient webClient;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GamesRepository gamesRepository, WebClient webClient, ModelMapper modelMapper) {
        this.gamesRepository = gamesRepository;
        this.webClient = webClient;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<Game> findAll() {
        return gamesRepository.findAll();
    }
    @Override
    public Game getGame(int id) {
        return gamesRepository.getGameByGameId(id);
    }

    public List<GameDTO> retrieveGames() {
        List<Game> listOfGames = findAll();
        String strOfIgdbIds = getIgdbIds(listOfGames);

        List<GameDTO> dtoList = listOfGames.stream()
                .map(this::convertToGameDto)
                .sorted(Comparator.comparingInt(GameDTO::getIgdbId))
                .toList();

        return setImage(dtoList, strOfIgdbIds);
    }

    @Transactional
    @Override
    public void updateTime(Game game, TimeDTO timeDTO) {
        updateMainStoryTime(game, avgTime(game.getAvgMainStoryHours(), game.getAvgMainStoryMinutes(),
                timeDTO.getMainStoryHours(), timeDTO.getMainStoryMinutes()));

        updateMainStoryExtraTime(game, avgTime(game.getAvgMainPlusDlcHours(), game.getAvgMainPlusDlcMinutes(),
                timeDTO.getMainPlusDlcHours(), timeDTO.getMainPlusDlcMinutes()));

        updateCompletionistTime(game, avgTime(game.getAvgCompletionistHours(), game.getAvgCompletionistMinutes(),
                timeDTO.getCompletionistHours(), timeDTO.getCompletionistMinutes()));
    }
    @Override
    public void updateMainStoryTime(Game game, List<Integer> time) {
        game.setAvgMainStoryHours(time.get(0));
        game.setAvgMainStoryMinutes(time.get(1));
    }
    @Override
    public void updateMainStoryExtraTime(Game game, List<Integer> time) {
        game.setAvgMainPlusDlcHours(time.get(0));
        game.setAvgMainPlusDlcMinutes(time.get(1));
    }
    @Override
    public void updateCompletionistTime(Game game, List<Integer> time) {
        game.setAvgCompletionistHours(time.get(0));
        game.setAvgCompletionistMinutes(time.get(1));
    }
    @Override
    public List<Integer> avgTime(int currentAvgHours, int currentAvgMinutes,
                        int inputHours, int inputMinutes) {

        List<Integer> result = new ArrayList<>(2);

        int currentTotalMinutes = currentAvgHours * 60 + currentAvgMinutes;
        int newTotalMinutes = inputHours * 60 + inputMinutes;

        int updatedTotalMinutes = currentTotalMinutes + newTotalMinutes;
        int updatedAvgMinutes = updatedTotalMinutes / 2;

        int updatedAvgHours = updatedAvgMinutes / 60;
        int remainingMinutes = updatedAvgMinutes % 60;

        result.add(updatedAvgHours);
        result.add(remainingMinutes);

        return result;
    }
    @Override
    public String getIgdbIds(List<Game> games) {
        StringBuffer igdbIds = new StringBuffer();
        for(int i = 0; i < games.size(); i++) {
            if(games.get(i) == games.get(games.size() - 1)) {
                igdbIds.append(games.get(i).getIgdbId());
            } else {
                igdbIds.append(games.get(i).getIgdbId()).append(", ");
            }
        }
        return igdbIds.toString();
    }
    @Override
    public List<GameDTO> tieUrls(List<GameDTO> list1, List<GameImageDTO> list2) {
        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer1 < list1.size() && pointer2 < list2.size()) {
            int id1 = list1.get(pointer1).getIgdbId();
            int id2 = list2.get(pointer2).getGame();

            if(id1 == id2) {
                list1.get(pointer1).setUrl(list2.get(pointer2).getUrl());
                pointer1++;
                pointer2++;
            } else {
                throw new IgdbIdException("Game ID's in the lists do not match");
            }
        }
        return list1;
    }
    @Override
    public List<GameImageDTO> getGamesImages(String igdbIds) {
        String bodyValue = "f url, game;\n" +
                "w game = (" + igdbIds + ");";

        return webClient
                .post()
                .uri("covers/").accept(MediaType.APPLICATION_JSON)
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToFlux(GameImageDTO.class)
                .collectList()
                .block();
    }
    @Override
    public List<GameDTO> setImage(List<GameDTO> gameDTOList, String igdbIds) {
        List<GameImageDTO> gamesImages = getGamesImages(igdbIds);

        List<GameImageDTO> sortedList = gamesImages.stream()
                .sorted(Comparator.comparingInt(GameImageDTO::getGame))
                .toList();

        return tieUrls(gameDTOList, sortedList);
    }
    @Override
    public Mono<GameFullDTO> getGame(GameDTO gameDTO) {
        String bodyValue = "f name, summary, cover.url, platforms.name, genres.name;\n" +
                "w id = " + gameDTO.getIgdbId() + ";";

        Mono<List<GameFullDTO>> fullGame = webClient
                .post()
                .uri("games/")
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GameFullDTO>>() {});

        return fullGame.map(gameFullDTOS -> gameFullDTOS.get(0));

    }

    private GameDTO convertToGameDto(Game game) {
        return modelMapper.map(game, GameDTO.class);
    }
}
