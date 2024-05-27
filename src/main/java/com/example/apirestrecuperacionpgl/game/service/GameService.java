package com.example.apirestrecuperacionpgl.game.service;

import com.example.apirestrecuperacionpgl.game.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<Game> getAllGames();

    Optional<Game> getGameById(Long id);

    Game createGame(Game game);

    Game updateGame(Game game);
}
