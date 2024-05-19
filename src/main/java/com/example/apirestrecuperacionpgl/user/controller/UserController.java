package com.example.apirestrecuperacionpgl.user.controller;


import com.example.apirestrecuperacionpgl.user.model.User;
import com.example.apirestrecuperacionpgl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<User> getAllUsersByNameOrTelefono(@RequestParam(value = "nombre", required = false) String nombre, @RequestParam(value = "telefono", required = false) String telefono) {
        return userService.getUsersByNameOrTelefono(nombre,telefono);
    }

    @GetMapping("{id}")
    public Optional<User> getAllUserById(@PathVariable Long id) {
        return userService.getUsersById(id);
    }


    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PutMapping("put/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        user.setIdUser(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
