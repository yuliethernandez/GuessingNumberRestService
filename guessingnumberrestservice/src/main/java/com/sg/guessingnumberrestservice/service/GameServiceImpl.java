
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dto.Game;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    
    @Autowired
    GameDao gameDao;
    
    @Override
    public Game startNewGame() {
        Game game = gameDao.createNewGame();
        gameDao.addGame(game);
        return game;
    }

    @Override
    public Game getGameById(int GameId) {
        Game game = gameDao.getGameById(GameId);
        if (!game.getStatusGame()) {
            game.setAnswer("****");
        }

        return game;
    }
    
    @Override
    public List<Game> getAllGames() {
        // List to get all games
        List<Game> allGames = gameDao.getAllGames();

        // Hide Answer for "In-Progress" games
        // Insert "XXXX"
        // New Empty list to store hidden games
        List<Game> gamesToBeHidden = new ArrayList<>();
        // For-each: Iterate through all games stored
        for (Game game: allGames) {
            if (game.getStatusGame().equals(true)) {
                game.setAnswer("XXXX");
            }
            gamesToBeHidden.add(game);
        }
        //return list of games with hidden answers
        return gamesToBeHidden;
    }
}
