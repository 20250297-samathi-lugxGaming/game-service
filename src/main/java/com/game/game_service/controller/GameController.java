package com.game.game_service.controller;


import com.game.game_service.model.Game;
import com.game.game_service.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController {
    private final GameRepository repo;

    public GameController(GameRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return repo.findAll();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return repo.save(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game updated) {
        Game g = repo.findById(id).orElseThrow();
        g.setName(updated.getName());
        g.setCategory(updated.getCategory());
        g.setReleaseDate(updated.getReleaseDate());
        g.setPrice(updated.getPrice());
        return repo.save(g);

    }
 @PostMapping("/bulk")
public List<Game> getGamesByIds(@RequestBody List<Long> ids) {
    return repo.findAllById(ids);
}

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        repo.deleteById(id);
    }
    @GetMapping("/{id}")
public ResponseEntity<Game> getGameById(@PathVariable Long id) {
    return repo.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
}



}
