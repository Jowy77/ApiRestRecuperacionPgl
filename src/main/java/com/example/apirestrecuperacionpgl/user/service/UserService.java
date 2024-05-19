package com.example.apirestrecuperacionpgl.user.service;

import com.example.apirestrecuperacionpgl.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    List<User> getUsersByNameOrTelefono(String nombre, String telefono);

    Optional<User> getUsersById(Long id);

    void desvincularGame(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(Long id);
}
