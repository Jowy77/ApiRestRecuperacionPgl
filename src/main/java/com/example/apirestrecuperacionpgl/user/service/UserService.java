package com.example.apirestrecuperacionpgl.user.service;

import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.user.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<User> getAllUsers();

    Optional<Set<Game>> getGamesByUserId(Long id);

    List<User> getUsersByEmailAndPassword(String email, String password);

    Optional<User> getUsersById(Long id);

    void desvincularGameFromUser(Long userId, Long gameId);

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(Long id);

    void linkGameToUser(Long userId, Long gameId);
}
