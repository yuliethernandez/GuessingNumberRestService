
package com.sg.guessingnumberrestservice.service;

import com.sg.guessingnumberrestservice.dao.GameDao;
import com.sg.guessingnumberrestservice.dto.Game;
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
    public String generateAnswer() {

        HashSet<Integer> answer = new HashSet<>();
        Random numberGen = new Random();
        for (int i = 0; answer.size() < 4; i++) {
            answer.add(numberGen.nextInt(8) + 1);
        }

        String numberGuess = "";
        for (int i : answer) {
            numberGuess += i;
        }

        return numberGuess;
    }

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
        List<Game> allGames = gameDao.getAllGames();
        //Hide Answer for "In-Progress" games
        for (Game game : allGames) {
            if (game.getStatusGame().equals(true)) {
                game.setAnswer("****");
            } else {
            }
        }
        return allGames;
    }
}
