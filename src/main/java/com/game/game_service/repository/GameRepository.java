package com.game.game_service.repository;

import com.game.game_service.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository <Game,Long> {
}
