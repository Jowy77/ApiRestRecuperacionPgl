package com.example.apirestrecuperacionpgl.game.controller;


import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("{id}")
    public Optional<Game> getGameByID(@PathVariable Long id) {
        return gameService.getGameById(id);
    }



    @PostMapping("/create")
    public Game create(@RequestBody Game game) {
        return gameService.createGame(game);
    }


    @PutMapping("put/{id}")
    public Game update(@RequestBody Game game, @PathVariable Long id) {
        game.setIdGame(id);
        return gameService.updateGame(game);
    }
}
