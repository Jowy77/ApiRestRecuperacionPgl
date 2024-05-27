package com.example.apirestrecuperacionpgl.game.service.impl;


import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.game.repository.GameRepository;
import com.example.apirestrecuperacionpgl.game.service.GameService;
import com.example.apirestrecuperacionpgl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;

    private final UserService userService;

    public List<Game> getAllGames() {
        log.info("get games");
        return gameRepository.findAll();
    }


    public Optional<Game> getGameById(Long id) {
        log.info("get reserva by id: {}", id);
        return gameRepository.findById(id);
    }


    public Game createGame(Game game) {
        log.info("create game");
        return gameRepository.save(game);
    }


    public Game updateGame(Game game) {
        log.info("update game");
        return gameRepository.save(game);
    }
}
