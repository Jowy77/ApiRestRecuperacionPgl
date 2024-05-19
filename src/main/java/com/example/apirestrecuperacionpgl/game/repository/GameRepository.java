package com.example.apirestrecuperacionpgl.game.repository;


import com.example.apirestrecuperacionpgl.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByfechaEntradaOrFechaSalida(String fecha, String telefono);


}