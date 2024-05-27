package com.example.apirestrecuperacionpgl.user.controller;


import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.user.model.User;
import com.example.apirestrecuperacionpgl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/filter")
    public List<User> getAllUsersByEmailAndPassword(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
        return userService.getUsersByEmailAndPassword(email,password);
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<Set<Game>> getGamesByUserId(@PathVariable Long id) {
        Optional<Set<Game>> games = userService.getGamesByUserId(id);
        if (games.isPresent()) {
            return ResponseEntity.ok(games.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public Optional<User> getAllUserById(@PathVariable Long id) {
        return userService.getUsersById(id);
    }


    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PutMapping("put/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        user.setIdUser(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("{userId}/games/{gameId}")
    public ResponseEntity<String> desvincularGameFromUser(@PathVariable Long userId, @PathVariable Long gameId) {
        userService.desvincularGameFromUser(userId, gameId);
        return ResponseEntity.ok("Juego desvinculado exitosamente del usuario.");
    }

    @PostMapping("/{userId}/games/{gameId}")
    public ResponseEntity<?> linkGameToUser(@PathVariable Long userId, @PathVariable Long gameId) {
        userService.linkGameToUser(userId, gameId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
