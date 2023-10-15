package com.timetobeat.timetobeat.repositories;

import com.timetobeat.timetobeat.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends ListCrudRepository<Game, Integer> {
    @Query("select g from Game g join g.userList b where b.username = :username")
    List<Game> findByUsername(@Param("username") String username);
    Game getGameByGameId(int id);
}
