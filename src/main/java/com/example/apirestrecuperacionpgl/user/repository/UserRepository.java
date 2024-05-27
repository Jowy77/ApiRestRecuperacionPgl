package com.example.apirestrecuperacionpgl.user.repository;

import com.example.apirestrecuperacionpgl.game.model.Game;
import com.example.apirestrecuperacionpgl.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailAndPassword(String email, String password);

    User findUserByGames(Game game);
}
