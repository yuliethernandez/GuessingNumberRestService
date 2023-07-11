
package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    GameServiceImpl service;

    @GetMapping("/game/{GameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int GameId) {
        Game game = service.getGameById(GameId);
        if (game == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(game);
    }
}
