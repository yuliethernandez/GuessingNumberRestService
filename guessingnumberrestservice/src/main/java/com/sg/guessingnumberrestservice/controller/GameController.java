
package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.service.GameService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {
    
    @Autowired
    GameService gameService;
    
    @PostMapping("/begin")
    public ResponseEntity startNewGame(Model model) throws URISyntaxException {

        Game game = gameService.startNewGame();
        game.setAnswer("XXXX");
        model.addAttribute("Game", game);
        int gameId = game.getGameId();
        URI uri = new URI("api/game/"+ gameId);
        return ResponseEntity.created(uri).body(model);
    }
    
    @GetMapping("/game/{GameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int GameId) {
        Game game = gameService.getGameById(GameId);
        if (game == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(game);
    }
    
    @GetMapping("/game")
    List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}
