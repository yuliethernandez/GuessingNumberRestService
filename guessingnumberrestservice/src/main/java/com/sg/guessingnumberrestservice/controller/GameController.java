
package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameServiceImpl gameService;

    @GetMapping("/game")
    List<Game> getAllGames() {
        return gameService.getAllGames();
    }
}
