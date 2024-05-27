package com.example.apirestrecuperacionpgl.user.service.impl;


import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.game.repository.GameRepository;
import com.example.apirestrecuperacionpgl.user.model.User;
import com.example.apirestrecuperacionpgl.user.repository.UserRepository;
import com.example.apirestrecuperacionpgl.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        log.info("get users");
        return userRepository.findAll();
    }

    @Override
    public Optional<Set<Game>> getGamesByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getGames);
    }

    @Override
    public List<User> getUsersByEmailAndPassword(String email, String password) {
        log.info("get userByEmailAndPassword");
        return userRepository.findByEmailAndPassword(email,password);
    }

    public Optional<User> getUsersById(Long id) {
        log.info("get user by id: {}",id);
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void desvincularGameFromUser(Long userId, Long gameId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Game> gameOptional = gameRepository.findById(gameId);

            if (gameOptional.isPresent()) {
                Game game = gameOptional.get();
                user.getGames().remove(game); // Desvincula el juego del usuario
                game.getUsers().remove(user); // Desvincula el usuario del juego

                userRepository.save(user); // Guarda el usuario actualizado
                gameRepository.save(game); // Guarda el juego actualizado
            }
        }
    }


    public User createUser(User user) {
        log.info("create user");
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        log.info("update user");
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        log.info("delete user by id: {}",id);
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void linkGameToUser(Long userId, Long gameId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Game> gameOptional = gameRepository.findById(gameId);

        if (userOptional.isPresent() && gameOptional.isPresent()) {
            User user = userOptional.get();
            Game game = gameOptional.get();

            user.getGames().add(game);
            game.getUsers().add(user);

            userRepository.save(user);
            gameRepository.save(game);
        } else {
            throw new EntityNotFoundException("User or game not found");
        }
    }

}
