package com.example.apirestrecuperacionpgl.user.service.impl;


import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.game.repository.GameRepository;
import com.example.apirestrecuperacionpgl.user.model.User;
import com.example.apirestrecuperacionpgl.user.repository.UserRepository;
import com.example.apirestrecuperacionpgl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    public List<User> getAllUsers() {
        log.info("get users");
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByNameOrTelefono(String nombre, String telefono) {
        log.info("get userByNameOrTelefono");
        return userRepository.findByNombreIgnoreCaseOrTelefono(nombre,telefono);
    }

    public Optional<User> getUsersById(Long id) {
        log.info("get user by id: {}",id);
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void desvincularGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);

        if(game.isPresent()){
            User user = userRepository.findUserByGames(game.get());
            if(user != null && !CollectionUtils.isEmpty(user.getGames())){
                user.getGames().remove(game.get());
                userRepository.save(user);
            }
        }
    }

    public User createUser(User user) {
        log.info("create user");
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

}
