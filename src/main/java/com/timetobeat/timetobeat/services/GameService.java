package com.timetobeat.timetobeat.services;
import com.timetobeat.timetobeat.dto.GameDTO;
import com.timetobeat.timetobeat.dto.GameImageDTO;
import com.timetobeat.timetobeat.models.Game;
import com.timetobeat.timetobeat.repositories.GamesRepository;
import com.timetobeat.timetobeat.exception.IgdbIdException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Comparator;
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
    public String getIgdbIds(List<Game> games) {
        StringBuilder igdbIds = new StringBuilder();
        for(int i = 0; i < games.size(); i++) {
            if(games.get(i) == games.get(games.size() - 1)) {
                igdbIds.append(games.get(i).getIgdbId());
            } else {
                igdbIds.append(games.get(i).getIgdbId()).append(", ");
            }
        }
        return igdbIds.toString();
    }
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
    public Mono<List<GameImageDTO>> getGamesImages(String igdbIds) {
      return webClient
                .post()
                .uri("covers/").accept(MediaType.APPLICATION_JSON)
                .bodyValue("f url, game;\n" +
                        "w game = (" + igdbIds + ");")
                .retrieve()
              .bodyToMono(new ParameterizedTypeReference<List<GameImageDTO>>() {});
    }
    public Mono<List<GameDTO>> setImage(List<GameDTO> gameDTOList, String igdbIds) {
        Mono<List<GameImageDTO>> gamesImages = getGamesImages(igdbIds);

        return gamesImages.flatMap(gameImageDTOS -> {
            try {
                List<GameImageDTO> sortedList = gameImageDTOS.stream()
                        .sorted(Comparator.comparingInt(GameImageDTO::getGame))
                        .toList();

                return Mono.just(tieUrls(gameDTOList, sortedList));
            } catch (IgdbIdException e) {
                return Mono.error(e);
            }
        });
    }
}
