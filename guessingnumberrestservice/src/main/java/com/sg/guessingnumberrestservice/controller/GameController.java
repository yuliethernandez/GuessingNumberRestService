package com.sg.guessingnumberrestservice.controller;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dao.GameDaoImpl;
import com.sg.guessingnumberrestservice.dto.Game;
import com.sg.guessingnumberrestservice.service.GameService;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("begin")
    public ResponseEntity startNewGame(Model model) throws URISyntaxException {

        Game game = gameService.startNewGame();
        game.setAnswer("XXXX");
        model.addAttribute("Game", game);
        int gameId = game.getGameId();
        URI uri = new URI("api/game/"+ gameId);
        return ResponseEntity.created(uri).body(model);
    }
    
    
}
