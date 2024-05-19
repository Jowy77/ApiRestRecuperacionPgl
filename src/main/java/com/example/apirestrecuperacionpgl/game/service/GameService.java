package com.example.apirestrecuperacionpgl.game.service;

import com.example.apirestrecuperacionpgl.game.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<Game> getAllUsers();

    List<Game> getGamesByFechaEntradaOrFechaSalida(String fechaEntrada, String fechaSalida);

    Optional<Game> getGameById(Long id);


    Game createGame(Game game);


    Game updateGame(Game game);


    void deleteGameById(Long id);
}
