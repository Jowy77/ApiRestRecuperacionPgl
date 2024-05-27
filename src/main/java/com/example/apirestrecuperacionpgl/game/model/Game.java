package com.example.apirestrecuperacionpgl.game.model;

import com.example.apirestrecuperacionpgl.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;

    private String nombreJuego;
    private String fechaSalida;
    private String valoracionPersonal;
    private String caratula;

    @ManyToMany(mappedBy = "games")
    @JsonIgnore //PARA EVITAR LA SERIALIZACIO INFINITA
    private Set<User> users;

}
