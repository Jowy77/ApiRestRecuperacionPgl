package com.example.apirestrecuperacionpgl.user.model;

import com.example.apirestrecuperacionpgl.game.model.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String nombre;
    private String telefono;
    private String fotoPerfil;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;
}
